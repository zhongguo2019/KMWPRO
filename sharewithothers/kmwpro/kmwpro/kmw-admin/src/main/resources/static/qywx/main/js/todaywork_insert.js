//判断是否在企业微信中打开  不是就跳到错误提示页
var ua = window.navigator.userAgent.toLowerCase();
/*if ((ua.match(/MicroMessenger/i) == 'micromessenger') && (ua.match(/wxwork/i) == 'wxwork')) {
// 企业微信客户端
} else if (ua.match(/micromessenger/i) == 'micromessenger') {
 // 微信客户端
    // window.location.replace('../pages/error.html')
} else {
    // 浏览器
    window.location.replace('../error.html')
}*/

// 初始化选项卡高度
var winHeight = document.documentElement.clientHeight;// 页面高度

// var buttonHeight = winHeight - $("#layuiAll").height();//底部高度

// var detailHeight = winHeight - buttonHeight - 153;//内页高度

var detailHeight = $("#layuiAll").height() - 50 - 58 - 41 - 20 - 20;

$("#todayDetail").attr("style", "height: " + detailHeight + "px;overflow: scroll;");// 设置表单高度

$("#projectSummary").attr("style", "resize: none;height:" + (detailHeight - 50) + "px");// 设置工作总结高度

$("body").attr("style", "height: 100%;opacity: 1;");// 显示body内容

sliderInit();// 初始化滑块
function sliderInit() {
    $(".js-range-slider").ionRangeSlider({
        skin: "round",
        min: 0,
        max: 100,
        step: 5,
        postfix: "%",
        from: 0,
        hide_min_max: true,    // show/hide MIN and MAX labels
        onStart: function (data) {
        },

        onChange: function (data) {
            console.log(data.from);
        },

        onFinish: function (data) {
            console.log(data.to);
        },

        onUpdate: function (data) {
            console.log(data.from_percent);
        }
    });
}


formStarted();

// layui初始化
function formStarted() {
    layui.use(['form', 'slider', 'layer', 'element', 'table'], function () {
        var layer = layui.layer
            , form = layui.form
            , slider = layui.slider
            , element = layui.element
            , table = layui.table;
      
        // 获取当前用户用户userId
        var urlCode = location.href.split("code=")[1].split('&')[0];
        var userId = "";
        $.ajax({
            url: "http://krmsoft.natapp1.cc/qywx/main/wxgetJSSUser",
            data: {
                data: urlCode
            },
            type: "POST",
            success: function (result) {
                console.log(result);
                userId=result;
                addcookie("userId",userId);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });



        function isEmptyObject(obj){  
        	  
            for(var key in obj){  
                 break;  return false  
            };  
            return true  
       };  


        form.on('submit(formDemo)', function (data) {
            var formTodayData = new FormData($("#formToday")[0]);
            var formTomorrowData = new FormData($("#formTomorrow")[0]);
            var formSubmitData = new FormData($("#formSubmit")[0]);
            var jsonData01 = {};
            formTodayData.forEach((value, key) => jsonData01[key] = value);
            var jsonData02 = {};
            formTomorrowData.forEach((value, key) => jsonData02[key] = value);
            var jsonData03 = {};
            formSubmitData.forEach((value, key) => jsonData03[key] = value);            
        
            if($.isEmptyObject(jsonData01)||$.isEmptyObject(jsonData02)||$.isEmptyObject(jsonData03)){
                var error_msg = "今天工作内容、明天计划内容、今天的工作总结都要录入内容！";
                layer.msg("<em style='color:red'>" + error_msg + "</em>", {time: 1200, icon: 5});
            	return;
            }
            if(jsonData01.projectName_0==""||projectMessage_0==""){
                var error_msg = "今天工作内容没有录入！";
                layer.msg("<em style='color:red'>" + error_msg + "</em>", {time: 1200, icon: 5});
            	return;	
            }
            if(jsonData02.tomorrow_projectName_0==""||tomorrow_projectMessage_0==""){
                var error_msg = "明天计划内容没有录入！";
                layer.msg("<em style='color:red'>" + error_msg + "</em>", {time: 1200, icon: 5});

                return;
            }
            if(jsonData03.projectSummary==""){
                var error_msg = "今天工作总结没有录入！";
                layer.msg("<em style='color:red'>" + error_msg + "</em>", {time: 1200, icon: 5});
            	return;
            }
            
            jsonData01.worktype = 'today';
            jsonData02.worktype = 'tomorrow';
            jsonData03.worktype = 'submit';
            var jsonCommit = {};
            var jsonUserInfo = {};
            var saveUrl = "http://krmsoft.natapp1.cc/qywx/work/wxworksave";
            var loading = layer.msg('正在保存', {icon: 16, shade: 0.3, time: 0});

            jsonUserInfo.userCode = getcookie("userId");
           /* layer.msg("保存页面时，得到usrId："+getcookie("userId"), {icon: 2}); */
            jsonCommit.userIfno = jsonUserInfo;
            jsonCommit.today = jsonData01;
            jsonCommit.tomorrow = jsonData02;
            jsonCommit.submit = jsonData03;
            console.log(getformTodayData);
            jsonCommit = JSON.stringify(jsonCommit);

            $.ajax({
                method: "POST",
                url: saveUrl,       // 提交表单的地址
                contentType: "application/json;charset-UTF-8",
                data: jsonCommit,
                dataType: 'json',
                success: function (res) {
                    layer.close(loading);
                    if (res.code == 1) {
                        layer.msg(res.msg, {icon: 6});
                        $("#formToday")[0].reset();
                        $("#formTomorrow")[0].reset();
                        $("#formSubmit")[0].reset();
                    }
                    if (res.code == 0) {
                        layer.msg(res.msg, {icon: 6});
                        $("#formToday")[0].reset();
                        $("#formTomorrow")[0].reset();
                        $("#formSubmit")[0].reset();
                    }
                },
                error: function () {
                    layer.close(loading);
                    layer.msg("日报提交失败！", {icon: 2});
                }
            });
            /* return false; //防止表单提交两次 */
        });

        function getformTodayData() {
            console.log($('#formToday').serializeJSON());
            console.log(JSON.stringify($('#formToday').serializeJSON()));
            return JSON.stringify($('#formToday').serializeJSON());
        }

    });
}
$("#btnResetForm").on('click', function () {
    $("#formToday")[0].reset();
    $("#formTomorrow")[0].reset();
    $("#formSubmit")[0].reset();
})

// 事件处理

// 今天项目 添加
var todayAddNum = "1"
$("#todayOptionAdd").on('click', function () {
    var todayOptionItem = ' <div id="todayOption">\
        <fieldset class="layui-elem-field">\
        <div class="layui-field-box">\
        <div class="layui-form-item" style="width: auto">\
        <select id="projectName_' + todayAddNum + '"  name="projectName_' + todayAddNum + '"lay-verify="required">\
        <option value=""></option>\
        <option value="1104监管报送">1104监管报送</option>\
        <option value="人行统计报送">人行统计报送</option>\
        <option value="PISA支付报送">PISA支付报送</option>\
        <option value="EAST数据报送">EAST数据报送</option>\
        <option value="支付结算报送">支付结算报送</option>\
        <option value="客户风险报送">客户风险报送</option>\
        <option value="非居民涉税报送">非居民涉税报送</option>\
        <option value="境外银行卡交易">境外银行卡交易</option>\
        <option value="理财报送">理财报送</option>\
        <option value="信贷小微报送">信贷小微报送</option>\
        <option value="助农取款报送">助农取款报送</option>\
        <option value="监管数据治理">监管数据治理</option>\
        <option value="大数据分析平台">大数据分析平台</option>\
        <option value="行内报表平台">行内报表平台</option>\
        <option value="MAST非现场合规监测">MAST非现场合规监测</option>\
        <option value="反洗钱报送">反洗钱报送</option>\
        <option value="其它临时工作">其它临时工作</option>\
        </select>\
        </div>\
        <div class="layui-form-item layui-form-text" style="width: auto;">\
        <textarea id="projectMessage_' + todayAddNum + '" name ="projectMessage_' + todayAddNum + '" class="layui-textarea"\
         rows="2" style="resize: none;min-height: auto;" placeholder="请输入工作内容"></textarea>\
        </div>\
        <div class="layui-form-item">\
        <input type="text" class="js-range-slider" id="finishPercent_' + todayAddNum + '" name="finishPercent_' + todayAddNum + '"\
         value=""/>\
        </div>\
        </div>\
       </fieldset>\
        </div>';
    $("#todayOption").append(todayOptionItem);
    todayAddNum++;

    // 重新渲染表单元素
    layui.use('form', function () {
        var form = layui.form;
        form.render();
    });

    sliderInit();// 初始化滑块
})

// 明天工作添加
var tomorrowAddNum = "1"
$("#tomorrowOptionAdd").on('click', function () {

    var tomorrowOptionItem = ' <div id="tomorrowOption">\
        <fieldset class="layui-elem-field">\
        <div class="layui-field-box">\
        <div class="layui-form-item" style="width: auto">\
        <select id="tomorrow_projectName_' + tomorrowAddNum + '" lay-verify="required">\
        <option value=""></option>\
        <option value="1104监管报送">1104监管报送</option>\
        <option value="人行统计报送">人行统计报送</option>\
        <option value="PISA支付报送">PISA支付报送</option>\
        <option value="EAST数据报送">EAST数据报送</option>\
        <option value="支付结算报送">支付结算报送</option>\
        <option value="客户风险报送">客户风险报送</option>\
        <option value="非居民涉税报送">非居民涉税报送</option>\
        <option value="境外银行卡交易">境外银行卡交易</option>\
        <option value="理财报送">理财报送</option>\
        <option value="信贷小微报送">信贷小微报送</option>\
        <option value="助农取款报送">助农取款报送</option>\
        <option value="监管数据治理">监管数据治理</option>\
        <option value="大数据分析平台">大数据分析平台</option>\
        <option value="行内报表平台">行内报表平台</option>\
        <option value="MAST非现场合规监测">MAST非现场合规监测</option>\
        <option value="反洗钱报送">反洗钱报送</option>\
        <option value="其它临时工作">其它临时工作</option>\
        </select>\
        </div>\
        <div class="layui-form-item layui-form-text" style="width: auto;">\
        <textarea id="tomorrow_projectMessage_' + tomorrowAddNum + '" class="layui-textarea"\
         rows="2" style="resize: none;min-height: auto;" placeholder="请输入工作内容"></textarea>\
        </div>\
        </div>\
       </fieldset>\
        </div>';
    $("#tomorrowOption").append(tomorrowOptionItem);
    tomorrowAddNum++;

    // 重新渲染表单元素
    layui.use('form', function () {
        var form = layui.form;
        form.render();
    });

    sliderInit();// 初始化滑块
})


var form = layui.form;

// 存Cookie的值 仅同级文件可用
function addcookie(name,value,expireHours){
    var exp = new Date();
    exp.setTime(exp.getTime() + expireHours);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}


// 存Cookie的值 加了cookie作用域 会产生全局有效的cookie
function ADDcookie(name,value,expireHours){
    var exp = new Date();
    exp.setTime(exp.getTime() + expireHours);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() +"; path=/";
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


