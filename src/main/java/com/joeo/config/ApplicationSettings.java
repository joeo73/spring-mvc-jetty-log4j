package com.joeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationSettings {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
      PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();

      properties.setLocations(new ClassPathResource[]{
          new ClassPathResource("application.properties"),
      });

      return properties;
    }
}
