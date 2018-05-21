package com.bmoellerit.springclient.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ServerListFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Bernd on 11.05.2018.
 *
 * Package com.bmoellerit.springclient.configuration
 */



public class MyRibbonConfiguration {

  @Autowired
  IClientConfig iClientConfig;

  @Bean
  public ServerList<Server> ribbonServerList() {
    return new MyCustomServerList();
  }

  @Bean
  public ServerListFilter<Server> serverListFilter(){
    return new CanaryServerListFilter();
  }



  @Bean
  public IRule canaryDeploymentRule(IClientConfig config) {
    CanaryDeploymentRule rule = new CanaryDeploymentRule ();
    rule.initWithNiwsConfig(config);
    return rule;
  }
}
