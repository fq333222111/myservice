package com.myservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description swagger2 配置文件
 * @date 2019/4/17
 */
@Configuration
public class Swagger2 {


    /**
     * @Description //TODO 用于构建swagger2的方法参数设置以及扫包范围
     * @Date 2019/4/30
     * @Param []
     * @return springfox.documentation.spring.web.plugins.Docket
     * @Author
     **/
    @Bean
    public Docket createRestApi() {
        //添加head参数start
         ParameterBuilder tokenPar = new ParameterBuilder();
         List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token")
                 .description("令牌(登录后获取令牌)")
                 .modelRef(new ModelRef("string"))
                 .parameterType("header")
                 .required(false)
                 .build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                     .genericModelSubstitutes(DeferredResult.class)
                     .useDefaultResponseMessages(false)
                     .forCodeGeneration(false)
                     .pathMapping("")
                     .select()
                     .apis(RequestHandlerSelectors.basePackage("com.myservice.controller"))
                     // TODO 如果是线上环境，添加路径过滤，设置为全部都不符合 none()
                     .paths(PathSelectors.any())
                     .build()
                     .globalOperationParameters(pars)
                     .apiInfo(apiInfo());
    }

    /**
     * @Description //TODO 用于构建swagger2的头部信息
     * @Date 2019/4/30
     * @Param []
     * @return springfox.documentation.service.ApiInfo
     * @Author
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("描述：用于测试构建文档")
                .version("2.6.1")
                .build();
    }

}
