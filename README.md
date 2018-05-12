Springclient
============

Introduction
--------------

Springclient is a Spring Boot based sample application which communicates
loadbalanced with instances of a RESTful service


Service Registry
-----------------

In order to implement loadbalancing the Spring Cloud Starters _spring-cloud-starter-consul-discovery_
 (see also the [Spring Cloud Documentation](https://projects.spring.io/spring-cloud/))
It expects Consul to be reachable under http://localhost:8500

In order to add Tags to the consul registration Docker labels or environment variables
have to be added e.g.:
 
 _docker run -e SERVICE_TAGS=TESTDELOYMENT_


Deployment
---------------

Springclient is deployed as a Docker container

Exposed Ports: 8081
When creating the container it should use the network "host" (docker run --net host)





