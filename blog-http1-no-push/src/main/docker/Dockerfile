FROM teyckmans/jetty:9.3.0-SNAPSHOT
MAINTAINER Tom Eyckmans <tom.eyckmans@iadvise.eu>
EXPOSE 8080
WORKDIR $JETTY_HOME
RUN mkdir blog-http1-no-push
ENV JETTY_BASE $JETTY_HOME/blog-http1-no-push
WORKDIR $JETTY_BASE
RUN java -jar $JETTY_HOME/start.jar --add-to-start=annotations,http,deploy
ADD blog-http1-no-push.xml $JETTY_BASE/webapps/blog-http1-no-push.xml
ADD blog-http1-no-push-1.0.war $JETTY_BASE/webapps/blog-http1-no-push.war
CMD java -jar $JETTY_HOME/start.jar
