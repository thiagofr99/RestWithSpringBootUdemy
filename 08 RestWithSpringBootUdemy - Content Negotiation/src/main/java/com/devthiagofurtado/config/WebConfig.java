package com.devthiagofurtado.config;

import com.devthiagofurtado.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    @Override //Anotação para sobrescrever um método do Java
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        - > VIA EXTENSÃO - Metodo serve para passar o content no link exemplo.json ou exemplo.xml
//        configurer.favorParameter(false)
//                .ignoreAcceptHeader(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json",MediaType.APPLICATION_JSON)
//                .mediaType("xml",MediaType.APPLICATION_XML);

        // - > VIA QUERY PARAM - Metodo serve para passar o content como parametro atendendo como ?mediaType=xml ou ?mediaType=json
//        configurer.favorParameter(true)
//                .favorPathExtension(false)
//                .ignoreAcceptHeader(true)
//                .parameterName("mediaType")
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json",MediaType.APPLICATION_JSON)
//                .mediaType("xml",MediaType.APPLICATION_XML);
//      - > VIA HEADER - Metodo serve para passar o content no Header atendendo como ?mediaType=xml ou ?mediaType=json
        configurer.favorParameter(false)
                .favorPathExtension(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_YML);
    }

}
