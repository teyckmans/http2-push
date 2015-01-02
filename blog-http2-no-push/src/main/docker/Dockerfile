FROM teyckmans/java8
MAINTAINER Tom Eyckmans <tom.eyckmans@iadvise.eu>
EXPOSE 8443
ADD jetty-distribution-9.3.0-SNAPSHOT.zip /jetty/jetty-distribution-9.3.0-SNAPSHOT.zip
WORKDIR /jetty
RUN unzip jetty-distribution-9.3.0-SNAPSHOT.zip
RUN export JETTY_HOME=/jetty/jetty-distribution-9.3.0-SNAPSHOT
WORKDIR $JETTY_HOME
RUN mkdir blog-http2-no-push
RUN export JETTY_BASE=$JETTY_HOME/blog-http2-no-push
WORKDIR $JETTY_BASE
RUN echo 'y' | java -jar $JETTY_HOME/start.jar --add-to-start=annotations,http2,deploy
ADD blog-http2-no-push/build/libs/blog-http2-no-push.xml $JETTY_BASE/webapps/blog-http2-no-push.xml
ADD blog-http2-no-push/build/libs/blog-http2-no-push-1.0.war $JETTY_BASE/webapps/blog-http2-no-push.war
CMD java -jar $JETTY_HOME/start.jar
