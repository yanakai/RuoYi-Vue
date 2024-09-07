package com.ruoyi.web.core.config;

import com.ruoyi.common.config.RuoYiConfig;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Swagger2的接口配置
 *
 * @author ruoyi
 */
@Configuration
public class SwaggerConfig {
    /**
     * 系统基础配置
     */
    @Autowired
    private RuoYiConfig ruoyiConfig;

    /**
     * 是否开启swagger
     */
    @Value("${swagger.enabled}")
    private boolean enabled;

    /**
     * 设置请求的统一前缀
     */
    @Value("${swagger.pathMapping}")
    private String pathMapping;

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                // 是否启用Swagger
                .enable(enabled)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
               // .apis(RequestHandlerSelectors.basePackage("com.ruoyi.web.controller"))
                // 扫描指定包中的swagger注解
               .apis(RequestHandlerSelectors.basePackage("com.ruoyi.web.controller.tool"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
               // .paths(PathSelectors.ant("/system/**","/test/**"))
                .build()
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }

    @Bean
    public Docket web_api_base() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(api_base_info())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ruoyi.business"))
                .paths(PathSelectors.ant("/business/base/**"))
                .build()
                .groupName("企业档案")
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }

    @Bean
    public Docket web_api_statistics() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(api_statistics_info())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ruoyi.business"))
                .paths(PathSelectors.ant("/business/statistics/**"))
                .build()
                .groupName("污染物排放监测报表")
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }

    @Bean
    public Docket statistics_alarm_api_statistics() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(api_statistics_alarm_info())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ruoyi.business.statisticsAlarm"))
                .paths(PathSelectors.ant("/business/statisticsAlarm/**"))
                .build()
                .groupName("分级预警报警")
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }

    @Bean
    public Docket online_monitoring_api_statistics() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(api_online_monitoring_info())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ruoyi.business.onlineMonitoring"))
                .paths(PathSelectors.ant("/business/onlinemonitoring/**"))
                .build()
                .groupName("排口在线监测")
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }
    //api_system_info
    @Bean
    public Docket api_system_info_api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(api_system_info())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ruoyi.web.controller.system"))
//                .paths(PathSelectors.ant("/system/**"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .groupName("系统管理")
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }

    /**
     * 安全模式，这里指定token通过Authorization头请求头传递
     */
    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList = new ArrayList<SecurityScheme>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", In.HEADER.toValue()));
        return apiKeyList;
    }

    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build());
        return securityContexts;
    }

    /**
     * 默认的安全上引用
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("标题：若依管理系统_接口文档")
                // 描述
                .description("描述：用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
                // 作者信息
                .contact(new Contact(ruoyiConfig.getName(), null, null))
                // 版本
                .version("版本号:" + ruoyiConfig.getVersion())
                .build();
    }

    public ApiInfo api_base_info() {
        return new ApiInfoBuilder()
                .title("企业档案")
                .description("企业档案描述：企业信息管理、排口信息管理（废水、废气、无组织）")
                // 作者信息
                .contact(new Contact(ruoyiConfig.getName(), null, null))
               // .termsOfServiceUrl("")//这里可以是项目地址
                .version("版本号:" + ruoyiConfig.getVersion())
                .build();
    }

    public ApiInfo api_statistics_info() {
        return new ApiInfoBuilder()
                .title("污染排放监测报表")
                .description("污染排放监测报表：XXX模块等")
                // 作者信息
                .contact(new Contact(ruoyiConfig.getName(), null, null))
//                .termsOfServiceUrl("")//这里可以是项目地址
                .version("版本号:" + ruoyiConfig.getVersion())
                .build();
    }

    public ApiInfo api_statistics_alarm_info() {
        return new ApiInfoBuilder()
                .title("分级预警报警")
                .description("污染排放监测报表：XXX模块等")
                // 作者信息
                .contact(new Contact(ruoyiConfig.getName(), null, null))
//                .termsOfServiceUrl("")//这里可以是项目地址
                .version("版本号:" + ruoyiConfig.getVersion())
                .build();
    }

    public ApiInfo api_online_monitoring_info() {
        return new ApiInfoBuilder()
                .title("排口在线监测")
                .description("排口在线监测：XXX模块等")
                // 作者信息
                .contact(new Contact(ruoyiConfig.getName(), null, null))
//                .termsOfServiceUrl("")//这里可以是项目地址
                .version("版本号:" + ruoyiConfig.getVersion())
                .build();
    }

    /**
     * 系统管理
     * @return
     */
    public ApiInfo api_system_info() {
        return new ApiInfoBuilder()
                .title("系统管理")
                .description("系统管理：用户管理、菜单管理等")
                // 作者信息
                .contact(new Contact(ruoyiConfig.getName(), null, null))
//                .termsOfServiceUrl("")//这里可以是项目地址
                .version("版本号:" + ruoyiConfig.getVersion())
                .build();
    }


}
