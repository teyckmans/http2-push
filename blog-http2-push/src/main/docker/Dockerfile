FROM teyckmans/jetty:9.3.0-SNAPSHOT
MAINTAINER Tom Eyckmans <tom.eyckmans@iadvise.eu>
EXPOSE 8443
WORKDIR $JETTY_HOME
RUN mkdir blog-http2-push
ENV JETTY_BASE $JETTY_HOME/blog-http2-push
WORKDIR $JETTY_BASE
RUN echo 'y' | java -jar $JETTY_HOME/start.jar --add-to-start=annotations,http2,deploy
ADD blog-http2-push.xml $JETTY_BASE/webapps/blog-http2-push.xml
ADD blog-http2-push-1.0.war $JETTY_BASE/webapps/blog-http2-push.war
CMD java -jar $JETTY_HOME/start.jar