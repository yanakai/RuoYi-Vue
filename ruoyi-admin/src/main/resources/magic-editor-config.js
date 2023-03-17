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
            var tokenTemp = "Admin-Token";
            var token ="";// 此处自行获取token
            // header cookie拿token
            var strCookie = document.cookie;
            var arrCookie = strCookie.split("=");
            if(arrCookie[0] == tokenTemp){
                token =  arrCookie[1];
            }
            // 如果是基于Cookie验证的，此处可以不配。
            config.headers.token =token ; // 此处自行获取Token
            console.log("请求参数config",config);
            return config;
        }
    },
    getMagicTokenValue: function(){
        var tokenTemp = "Admin-Token";
        var token ="";// 此处自行获取token
        // header cookie拿token
        var strCookie = document.cookie;
        var arrCookie = strCookie.split("=");
        if(arrCookie[0] == tokenTemp){
            token =  arrCookie[1];
        }
        return token;
    }

}