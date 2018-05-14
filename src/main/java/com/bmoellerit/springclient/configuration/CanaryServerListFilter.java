package com.bmoellerit.springclient.configuration;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.consul.discovery.ConsulServer;

/**
 * Created by Bernd on 12.05.2018.
 *
 * Package com.bmoellerit.springclient.configuration
 */
public class CanaryServerListFilter implements ServerListFilter<Server> {

  private static final Logger LOGGER = LoggerFactory.getLogger(CanaryServerListFilter.class);

  @Override
  public List<Server> getFilteredListOfServers(List<Server> list) {

    ConsulServer cSrv;

    for(Server srv: list){
      cSrv = (ConsulServer) srv;
      LOGGER.info(srv.toString() + "Metadata: " + cSrv.getMetadata().get("abcd"));
    }


    return list;
  }
}
