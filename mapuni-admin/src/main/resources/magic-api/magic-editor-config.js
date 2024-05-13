var MAGIC_EDITOR_CONFIG = {
    title: 'magic-api',
    header: {
        skin: true,    // 屏蔽皮肤按钮
        document: true,    // 屏蔽文档按钮
        repo: false,    // 屏蔽gitee和github
        qqGroup: false  // 屏蔽加入QQ群
    },
    request: {
        beforeSend: function(config){
            //从cookie中拿token
            const strCookie = document.cookie; // 前端存放cookie的值格式为 Admin-Token = XXXXX
            const arrCookie = strCookie.split("Admin-Token="); // 通过"="截断cookie的值
            // arrCookie[0] = "****Admin-Token";
            const token = arrCookie[1];// 此处自行获取token
            config.headers.token =token ; // 设置请求头的token的值
            config.headers.Authorization = "Bearer "+token ; // 设置请求头的Authorization的值 模拟前端请求默认植入token的值
            return config;
        }
    },
    getMagicTokenValue: function(){
        //从header的cookie拿token
        let strCookie = document.cookie; // 前端存放cookie的值格式为 Admin-Token = XXXXX
        let tokenResult = null;
        if(strCookie !== null && strCookie !== "" && strCookie !== "Admin-Token=null"){
            let arrCookie = strCookie.split("Admin-Token="); // 通过"="截断cookie的值
            // arrCookie[0] = "*******Admin-Token";
            tokenResult = arrCookie[1];// 此处自行获取token
        }else{
            tokenResult = localStorage.getItem("magic-token");
            document.cookie="Admin-Token="+tokenResult;
        }
        return tokenResult;
    }

}