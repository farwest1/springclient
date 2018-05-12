package com.bmoellerit.springclient.configuration;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernd on 12.05.2018.
 *
 * Package com.bmoellerit.springclient.configuration
 */
public class CanaryServerListFilter implements ServerListFilter<Server> {

  @Override
  public List<Server> getFilteredListOfServers(List<Server> list) {

    List<Server> srvList= new ArrayList<>();
    srvList.add(new Server("192.168.2.11",8080));
    return srvList;
  }
}
