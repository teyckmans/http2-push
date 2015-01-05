FROM teyckmans/java8
MAINTAINER Tom Eyckmans <tom.eyckmans@iadvise.eu>
ADD jetty-distribution-9.3.0-SNAPSHOT.zip /jetty/jetty-distribution-9.3.0-SNAPSHOT.zip
WORKDIR /jetty
RUN apt-get install unzip
RUN unzip jetty-distribution-9.3.0-SNAPSHOT.zip
ENV JETTY_HOME /jetty/jetty-distribution-9.3.0-SNAPSHOT