jQuery(function () {
  layui.use(['jquery', 'layer'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
   // 显示时间轴列表
    var itemIndex = 0;
    var counter = 0;
    // 每次加载展示几个
    var num = 4;
    var pageStart = 0, pageEnd = 0;

    // 获取当前用户用户userId
    // 以下两行代码调试时注掉
     var urlCode = location.href.split("code=")[1].split('&')[0];
     var userCode = getcookie("userId");
     

    // 以下两行代码调试时打开
//    var urlCode ='P1iJnyb-09zdfDiAVt6LOAP24DQJOQViJ873bAJIWEQ';
	// //置上默认的微信传来的参数code=P1iJnyb-09zdfDiAVt6LOAP24DQJOQViJ873bAJIWEQ&state=STATE
//    var userCode = 'Zhaozulong'; //置上默认的用户名
    
    
    
    if (userCode == "") {
      $.ajax({
        url: "http://krmsoft.natapp1.cc/qywx/main/wxgetJSSUser",
        data: {
          data: urlCode
        },
        type: "POST",
        success: function (result) {
          console.log(result);
          addcookie("userId", result);
          showTable();// 显示table
        },
        error: function (jqXHR, textStatus, errorThrown) {
          console.log(jqXHR);
          console.log(textStatus);
          console.log(errorThrown);
        }
      });
    }
    var dropload = $('.content').dropload({
      scrollArea: window,
      loadDownFn: function (me) {
// 加载数据
        // 以下一行代码调试时注掉
    	var data = { userCode:getcookie("userId")};
    	// 以下一行代码调试时注打开
//         var data={"userCode": "ZhaoZulong" };
               
        $.ajax({

          type: 'POST',
          contentType: "application/json;charset=UTF-8",
          url: 'http://krmsoft.natapp1.cc/qywx/work/wxgetRptDList',
          dataType: 'json',
          data: JSON.stringify(data),
          success: function (resultValue) {
            var result = '';
            counter++;
            pageEnd = num * counter;
            pageStart = pageEnd - num;
/*            console.log(Value.data);
            console.log(resultValue.msg);
            console.log(resultValue.code);*/


            if(resultValue.code==0){
            alert(resultValue.msg);	
            return;
            }
  
            var dataValueJSON=eval("("+resultValue.data+")");
            console.log(dataValueJSON);
            
            if (pageStart <= dataValueJSON.lists.length) {
              for (var i = pageStart; i < pageEnd; i++) {
                var dataSet = eval("("+dataValueJSON.lists[i] +")");
                result += '<li class="layui-timeline-item">\
                <i class="layui-icon layui-timeline-axis"></i>\
                <div class="layui-timeline-content layui-text">\
                  <div data-date="'+ dataSet.date + '" data-value="' + dataSet.reporterId + '" name="touchAll" class="listTitle">\
                    <h3 data-date="'+ dataSet.date + '" data-value="' + dataSet.reporterId + '" class="layui-timeline-title">'+ dataSet.date + '</h3>\
                    <div data-date="'+ dataSet.date + '" data-value="' + dataSet.reporterId + '" style="padding-right: 20px;">\
                      <img data-date="'+ dataSet.date + '" data-value="' + dataSet.reporterId + '" id="point_'+ dataSet.reporterId + '" src="images/downPoint.png" height="8" width="16">\
                    </div>\
                  </div>\
                  <div id="showDetail_'+ dataSet.reporterId + '" style="display: none;">\
                  </div>\
                </div>\
              </li>';

                if ((i + 1) >= dataValueJSON.lists.length) {
                  // 数据加载完
                  tab1LoadEnd = true;
                  // 锁定
                  me.lock();
                  // 无数据
                  me.noData();
                  break;
                }
              }
              $('.lists').eq(itemIndex).append(result);
              // 每次数据加载完，必须重置
              me.resetload();
              listEnd();
            }
          },
          error: function (xhr, type) {
            console.log('Ajax 调用后台方法错误！!');
            // 即使加载出错，也得重置
            me.resetload();
          }
        });
      }
    });

    // 加载完调用
    function listEnd() {
      // 滑块点击事件 加载每天工作列表
      $("[name='touchAll']").unbind();
      $("[name='touchAll']").on('click', function (e) {
        console.log(e)
        // 判断如果是显示状态 直接隐藏不调接口
        if($("#showDetail_" + e.target.dataset.value).height() != '0'){
          $("#showDetail_" + e.target.dataset.value).slideToggle();// 缓慢显示隐藏
          $('#point_' + e.target.dataset.value).attr("style", "transform: rotateX(0deg);");
        }else{
          $('.span').show();
          var result = '';
          // 显示当天工作列表
          var data = {
            userCode: getcookie("userId"),
            queryDate: e.target.dataset.date
          };

          $.ajax({
            type: 'POST',
            contentType: "application/json;charset=UTF-8",
            url: 'http://krmsoft.natapp1.cc/qywx/work/wxqueryRptList',
            dataType: 'json',
            data: JSON.stringify(data),
            success: function (resultValue) {
            	var result="";
                if(resultValue.code==0){
                     result = '<div style="border-bottom: 1px solid #a2a2a2;">\
                      <div style="display: flex;margin-top:10px;">\
                        <div style="height:35px">项目名称：</div>\
                        <div>暂无数据</div>\
                      </div>\
                      <div style="margin-top:10px;">\
                        <div style="display: flex;height: 30px;">\
                                                        工作内容：</div>\
                        <div>暂无数据</div>\
                      </div>\
                    </div>';
                    }else{
                        var dataValueJSON=eval("("+resultValue.data+")");
                       for (var i = 0; i < dataValueJSON.lists.length; i++) {
                          var dataSet = eval("("+dataValueJSON.lists[i] +")");
                          var nameValue = dataSet.productName;
                          var workValue = dataSet.workDetail;
                          if(nameValue == ""){
                            nameValue = '暂无数据';
                          }
                          if(workValue == ""){
                            workValue = '暂无数据';
                          }
                          result += '<div style="border-bottom: 1px solid #a2a2a2;">\
                            <div style="display: flex;margin-top:10px;">\
                              <div style="height:35px">项目名称：</div>\
                              <div>'+ nameValue + '</div>\
                            </div>\
                            <div style="margin-top:10px;">\
                              <div style="display: flex;height: 30px;">\
                                工作内容：</div>\
                              <div>'+ workValue + '</div>\
                            </div>\
                          </div>';
                        }
                    	
                    }

              $('#showDetail_' + e.target.dataset.value).html("");
              $('#showDetail_' + e.target.dataset.value).append(result);
              // 箭头翻转
              var rotateX = $('#point_' + e.target.dataset.value).attr("style");
              if (rotateX == "" || rotateX == undefined) {
                $('#point_' + e.target.dataset.value).attr("style", "transform: rotateX(180deg);");
              } else {
                $('#point_' + e.target.dataset.value).attr("style", "");
              }
              $("#showDetail_" + e.target.dataset.value).slideToggle();// 缓慢显示隐藏
              $('.span').hide();
            },
            error: function (xhr, type) {
              console.log('Ajax error!');
            }
          });
        }

        

      })
    }
  });
})


// 存Cookie的值 仅同级文件可用
function addcookie(name, value, expireHours) {
  var exp = new Date();
  exp.setTime(exp.getTime() + expireHours);
  document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}


// 存Cookie的值 加了cookie作用域 会产生全局有效的cookie
function ADDcookie(name, value, expireHours) {
  var exp = new Date();
  exp.setTime(exp.getTime() + expireHours);
  document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + "; path=/";
}

function GetCookies(offset) {
  var endstr = document.cookie.indexOf(";", offset);
  if (endstr == -1) endstr = document.cookie.length;
  return unescape(document.cookie.substring(offset, endstr));
}


// 取Cookie的值
function getcookie(name) {
  var arg = name + "=";
  var alen = arg.length;
  var clen = document.cookie.length;
  var i = 0;
  while (i < clen) {
    var j = i + alen;
    if (document.cookie.substring(i, j) == arg) return GetCookies(j);
    i = document.cookie.indexOf(" ", i) + 1;
    if (i == 0) break;
  }
  return "";
}

