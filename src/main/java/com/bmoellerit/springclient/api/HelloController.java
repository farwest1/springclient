package com.bmoellerit.springclient.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bernd on 01.05.2018.
 *
 * Package com.bmoellerit.springclient.api
 */
@Controller
public class HelloController {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

  //TODO: Replace by contructor based injection + assertion
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private DiscoveryClient discoveryClient;

  @Value("${springclient.servicename}")
  private String appName;



  @RequestMapping("/hello")
  public ResponseEntity<String> sayHello(){


    LOGGER.debug("HelloController called");
    String resp = restTemplate.getForObject("http://"+ appName + "/hello", String.class);


    return new ResponseEntity<String>(resp, HttpStatus.OK);
  }

  @RequestMapping("/instances")
  public ResponseEntity<List<ServiceInstance>> instances() {
    return new ResponseEntity<>(discoveryClient.getInstances(appName),HttpStatus.OK);
  }

}
