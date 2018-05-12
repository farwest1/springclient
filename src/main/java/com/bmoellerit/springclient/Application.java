package com.bmoellerit.springclient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bernd on 01.05.2018.
 *
 * Package springclient
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws Exception {
    new SpringApplicationBuilder(Application.class).web(true).run(args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate myRestTemplate(RestTemplateBuilder builder){
    return builder.build();
  }

}
