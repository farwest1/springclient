package com.bmoellerit.springclient.configuration;

import com.bmoellerit.springclient.configuration.MyRibbonConfiguration.RibbonConfiguration;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ServerListFilter;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Bernd on 11.05.2018.
 *
 * Package com.bmoellerit.springclient.configuration
 */

//TODO: Avoid this to be part of component scan (see documentation in internet)
@Configuration
@RibbonClient(name = "berndsClient", configuration = RibbonConfiguration.class)
public class MyRibbonConfiguration {

  @Configuration
  protected static class RibbonConfiguration{

//    @Bean
//    public ZonePreferenceServerListFilter serverListFilter() {
//      ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
//      filter.setZone("myTestZone");
//      return filter;
//    }

    @Bean
    @Profile("noconsul")
    public ServerList<Server> ribbonServerList() {
      return new MyCustomServerList();
    }

    @Bean
    @Profile("noconsul")
    public ServerListFilter<Server> serverListFilter(){
      return new CanaryServerListFilter();
    }

  }

}
