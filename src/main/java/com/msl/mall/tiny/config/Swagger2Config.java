package com.msl.mall.tiny.config;

import com.msl.mall.tiny.common.config.BaseSwaggerConfig;
import com.msl.mall.tiny.dto.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2API文档的配置
 */
@Configuration
@EnableWebMvc
public class Swagger2Config extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.msl.mall.tiny.controller")
                .title("mall-tiny")
                .contactName("msl")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

//    @Bean
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //为当前包下controller生成API文档
//                .apis(RequestHandlerSelectors.basePackage("com.msl.mall.tiny.controller"))
//                //为有@Api注解的Controller生成API文档
////                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                //为有@ApiOperation注解的方法生成API文档
////                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//                //添加登录认证;
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
//
//
//    }
//
//    private List<SecurityContext> securityContexts() {
//        //设置需要登录认证的路径
//        List<SecurityContext> list = new ArrayList<>();
//        list.add(getContextByPath("/brand/.*"));
//        return list;
//
//    }
//
//    private SecurityContext getContextByPath(String pathRegex) {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex(pathRegex))
//                .build();
//
//
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        List<SecurityReference> result = new ArrayList<>();
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        result.add(new SecurityReference("Authorization", authorizationScopes));
//        return result;
//    }
//
//    private List<ApiKey> securitySchemes() {
//        //设置请求头信息
//        List<ApiKey> list = new ArrayList<>();
//
//        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
//        list.add(apiKey);
//        return list;
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("SwaggerUI演示")
//                .description("mall-tiny")
//                .version("1.0")
//                .build();
//    }
}
