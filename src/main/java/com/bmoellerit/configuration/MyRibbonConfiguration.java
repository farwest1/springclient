package com.bmoellerit.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by Bernd on 11.05.2018.
 *
 * Package com.bmoellerit.configuration
 */



public class MyRibbonConfiguration {

  @Autowired
  IClientConfig iClientConfig;

//  @Bean
//  public ServerList<Server> ribbonServerList() {
//    return new MyCustomServerList();
//  }

//  @Bean
//  public ServerListFilter<Server> serverListFilter(){
//    return new CanaryServerListFilter();
//  }



//  @Bean
//  public IRule canaryDeploymentRule(IClientConfig config) {
//    CanaryDeploymentRule rule = new CanaryDeploymentRule ();
//    rule.initWithNiwsConfig(config);
//    return rule;
//  }

  @Bean
  public IPing ribbonPing(IClientConfig config) {
    return new PingUrl(false, "/hello");
  }

  @Bean
  public IRule ribbonRule(IClientConfig config) {
    return new AvailabilityFilteringRule();
  }
}
