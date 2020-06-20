const baseurl="http://106.55.63.99:8081/api/";
function present(){
    var yourid=$("#yourid").val();
    var password=$("#password").val();
    var friendid=$("#friendid").val();
    var score_number=$("#score_number").val();

    if(yourid==''){
        alert('您的用户名不能为空！');
        return false;
    }
    if(friendid==''){
        alert('好友用户名不能为空！');
        return false;
    }
    if(score_number==''){
        alert('转赠额度不能为空！');
        return false;
    }
    if(password==''){
        alert('您的密码不能为空！');
        return false;
    }
    else {
        $.ajax({
            type: "POST",//HTTP请求方法类型
            contentType:"application/json;charset=utf-8",
            dataType: "json",//预期前端发给后端的数据类型
            url: baseurl+"presentscore" ,//url地址
            data:JSON.stringify({'yourid':yourid,'password':password,
                'friendid':friendid,'score_number':score_number}),

            success: function (result) {
                if (result.statecode==1){
                    alert('用户名密码错误，请重新操作')
                };
                if(result.statecode==2){
                    alert('您的积分余额不足，转赠失败')
                };
                if (result.statecode== 3) {
                    alert('转赠成功，请尽快通知您的好友进行核实')
                }
                if(result.statecode==4){
                    alert('好友不存在，请确认好友用户名是否正确')
                }
                ;
            },
            error : function() {
                alert("异常！");
            }
        });
    }
}





function showscoreP() {
    var id=$("#id").val();
    var password=$("#password").val();


    if(id==''){
        alert('您的用户名不能为空！');
        return false;
    }
    if(password==''){
        alert('您的密码不能为空！');
        return false;
    }
    else {
        $.ajax({
            type: "get",//HTTP请求方法类型
            dataType: "json",//预期前端发给后端的数据类型
            url: baseurl+"showscoreP",//url地址
            data: {
                'id': id, 'password': password
            },
            success: function (result) {
                if(result.statecode==1){
                    alert('用户名密码错误，请重新操作')
                };
                if (result.statecode == 3) {
                    alert('您的积分数额为：'+result.score_number)
                }
                ;
            },
            error: function () {
                alert("查询异常！");
            }
        });
    }
}