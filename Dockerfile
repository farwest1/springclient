FROM openjdk:alpine
VOLUME /tmp
#COPY ./target/loadb.war ${DEPLOYMENT_DIR}
#ADD ./target/loadb.war /opt/jboss/wildfly/standalone/deployments/
ADD ./target/springclient-1.0-SNAPSHOT.jar springclient.jar
RUN sh -c 'touch springclient.jar'
EXPOSE 8081
LABEL maintainer="Bernd Moeller <bmtrash@web.de>"

# RUN /opt/jboss/wildfly/bin/add-user.sh admin ZR20010$%! --silent
ENTRYPOINT ["sh", "-c", "java -jar springclient.jar"]