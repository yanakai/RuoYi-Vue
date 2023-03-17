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
            //从header的cookie拿token
            const strCookie = document.cookie; // 前端存放cookie的值格式为 Admin-Token = XXXXX
            const arrCookie = strCookie.split("="); // 通过"="截断cookie的值
            // arrCookie[0] = "Admin-Token";
            const token = arrCookie[1];// 此处自行获取token
            // 如果是基于Cookie验证的，此处可以不配。
            config.headers.token =token ; // 此处自行获取Token
            config.headers.Authorization = "Bearer "+token ; // 设置请求头的Authorization的值 模拟前端请求默认植入token的值
            console.log("请求参数config",config);
            return config;
        }
    },
    getMagicTokenValue: function(){
        //从header的cookie拿token
        const strCookie = document.cookie; // 前端存放cookie的值格式为 Admin-Token = XXXXX
        const arrCookie = strCookie.split("="); // 通过"="截断cookie的值
        // arrCookie[0] = "Admin-Token";
        const token = arrCookie[1];// 此处自行获取token
        return token;
    }

}