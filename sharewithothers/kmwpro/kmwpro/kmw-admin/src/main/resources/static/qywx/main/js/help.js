jQuery(function () {


        //获取当前用户用户userId
/*
      var urlCode = location.href.split("code=")[1].split('&')[0];
        console.log(urlCode);
        var userCode = getcookie("userId");
        //userCode = 'Zhaozulong';
        if (userCode == "") {
            $.ajax({
                url: "http://krmsoft.natapp1.cc/main/wxgetJSSUser",
                data: {
                    data: urlCode
                },
                type: "POST",
                success: function (result) {
                    console.log(result);
                    addcookie("userId", result);
                    showTable();//显示table
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                }
            });
        }*/

        layui.use('element', function(){
            var $ = layui.jquery
                ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

            //触发事件
            var active = {
                tabAdd: function(){
                    //新增一个Tab项
                    element.tabAdd('demo', {
                        title: '新选项'+ (Math.random()*1000|0) //用于演示
                        ,content: '内容'+ (Math.random()*1000|0)
                        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                    })
                }
                ,tabDelete: function(othis){
                    //删除指定Tab项
                    element.tabDelete('demo', '44'); //删除：“商品管理”


                    othis.addClass('layui-btn-disabled');
                }
                ,tabChange: function(){
                    //切换到指定Tab项
                    element.tabChange('demo', '22'); //切换到：用户管理
                }
            };

            $('.site-demo-active').on('click', function(){
                var othis = $(this), type = othis.data('type');
                active[type] ? active[type].call(this, othis) : '';
            });

            //Hash地址的定位
            var layid = location.hash.replace(/^#test=/, '');
            element.tabChange('test', layid);

            element.on('tab(test)', function(elem){
                location.hash = 'test='+ $(this).attr('lay-id');
            });

        });


})


//存Cookie的值 仅同级文件可用
function addcookie(name, value, expireHours) {
    var exp = new Date();
    exp.setTime(exp.getTime() + expireHours);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}


//存Cookie的值 加了cookie作用域 会产生全局有效的cookie
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


//取Cookie的值
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

