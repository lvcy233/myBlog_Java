---
title: Swagger2
date: 2020-05-18 20:10:06
tags: Java
categories: springCloud搭建
---

# Swagger2

#### 1.引入依赖

首先在pom文件中引入两个swagger2的包

```java
<dependency>
    	<groupId>io.springfox</groupId>
    	<artifactId>springfox-swagger2</artifactId>
    	<version>2.9.2</version>
    </dependency>
    <dependency>
    	<groupId>io.springfox</groupId>
    	<artifactId>springfox-swagger-ui</artifactId>
    	<version>2.9.2</version>
</dependency>
```

#### 2.创建配置文件

在java包下创建一个类SwaggerConfig

![](https://gitee.com/lvcy233/imgUrl/raw/master/img/1589812430.jpg) 

写入配置

```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springCloud_dev.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("lvcy的API文档")//标题
                .description("springCloud_dev")//描述
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}

```

要在类上边加入注解@Configuration和@EnableSwagger2

##### 注：

​	引入的swagger2-2.9.2版本不支持webflux，可能需要修改一些配置才能支持，建议用spring-boot-starter-web