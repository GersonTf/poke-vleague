package com.blazerg.application.pokevleague.config

import io.swagger.annotations.Api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Swagger configuration.
 */
@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    /**
     * Create Swagger Api Configuration.
     *
     * @return Swagger Docket
     */
    @Bean
    Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName('poke-vleague')
            .apiInfo(apiInfo())
            .ignoredParameterTypes(MetaClass)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api))
            .paths(PathSelectors.any())
            .build()
            .pathMapping('/')
            .genericModelSubstitutes(ResponseEntity)
            .useDefaultResponseMessages(false)
    }

    /**
     * Generate Api Info.
     *
     * @return Swagger API Info
     */
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title('Poke virtual league')
            .description('Just a project for practicing heroku integration with spring boot')
            .license('Blazerg')
            .licenseUrl('https://github.com/Blazerg2/')
            .termsOfServiceUrl('')
            .version('1.0.0')
            .build()
    }

}
