package com.bmoellerit.springclient.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

/**
 * Created by Bernd on 14.05.2018.
 *
 * Package com.bmoellerit.springclient.configuration
 */
public class CanaryDeploymentRule extends AbstractLoadBalancerRule {

  @Override
  public void initWithNiwsConfig(IClientConfig iClientConfig) {

  }

  @Override
  public Server choose(Object key) {
    return null;
  }
}
