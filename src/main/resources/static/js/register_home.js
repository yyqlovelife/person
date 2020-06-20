const baseurl="http://106.55.63.99:8081/api/";
function register() {
    var id=$("#id").val();
    var password=$("#password").val();
    var tel_number=$("#tel_number").val();
    var card_number=$("#card_number").val();
    var address=$("#address").val();

    if(id==''){
        alert('您的用户名不能为空！');
        return false;
    }
    if(tel_number==''){
        alert('您的电话号码不能为空！');
        return false;
    }
    if(card_number==''){
        alert('您的电话号码不能为空！');
        return false;
    }
    if(address==''){
        alert('您的地址不能为空！');
        return false;
    }
    if(password==''){
        alert('您的密码不能为空！');
        return false;
    }
    else {
        $.ajax({
            type: "post",//HTTP请求方法类型
            contentType:"application/json;charset=utf-8",
			dataType: "json",
            url: baseurl+"register" ,//url地址
            data:JSON.stringify({'id':id,'password':password,'address':address,'card_number':card_number,'tel_number':tel_number}),
            success: function (result) {
                console.log(result);
                if(result.statecode==1){
                    alert('用户名已存在，请重新操作')
                };
                if (result.statecode== 3) {
                    alert('注册成功')
                }
                ;
            },
			fail(res){
				console.log(res);
			},
            error : function() {
                alert("注册异常！");
            }
        });
    }
}
/*
function start() {
    $.ajax({
        url : "http://localhost:8080/api/start",//请求url
        dataType : "json",//后端传到前端的数据格式
        type : "get",//请求方式
        async : true,//是否异步请求
        success : function(data) {
            alert('激活成功!')
        },
        error:function(data){
            alert("激活失败！")
        }
    })
}

function stop() {
    $.ajax({
        url : "http://localhost:8080/api/stop",//请求url
        dataType : "json",//后端传到前端的数据格式
        type : "get",//请求方式
        async : true,//是否异步请求
        success : function(data) {
            alert('休眠成功!')
        },
        error:function(data){
            alert("休眠失败！")
        }
    })
}*/