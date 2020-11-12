FROM tomcat:latest

RUN sed -i \
    -e '\@</tomcat-users>@i <user roles="manager-script" username="username" password="tomcat"/>' \
     $CATALINA_HOME/conf/tomcat-users.xml

EXPOSE 8081

COPY server.xml $CATALINA_HOME/conf/
COPY target/demo_fizz_buzz.war /usr/local/tomcat/webapps/
RUN cp -r /usr/local/tomcat/webapps.dist/manager /usr/local/tomcat/webapps/

COPY healthcheck.sh /
HEALTHCHECK --start-period=60s CMD sh /healthcheck.sh
