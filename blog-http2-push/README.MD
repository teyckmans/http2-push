using e8c88cfd9cf3cab89788cd530838314089ce9b23 from git://git.eclipse.org/gitroot/jetty/org.eclipse.jetty.project.git

execute mvn clean install using maven 3

extract the distribution from org.eclipse.jetty.project\jetty-distribution\target\jetty-distribution-9.3.0-SNAPSHOT.zip

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT\http2-demo>cd C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2>mkdir blog-http2-push

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2>set JETTY_HOME=C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2>cd blog-http2-push

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-push>set JETTY_BASE=C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-push>java -jar %JETTY_HOME%\start.jar --add-to-start=annotations,http2,deploy

ALERT: There are enabled module(s) with licenses.
The following 1 module(s):
 + contains software not provided by the Eclipse Foundation!
 + contains software not covered by the Eclipse Public License!
 + has not been audited for compliance with its license

 Module: protonego-impl
  + ALPN is a hosted at github under the GPL v2 with ClassPath Exception.
  + ALPN replaces/modifies OpenJDK classes in the java.sun.security.ssl package.
  + http://github.com/jetty-project/jetty-alpn
  + http://openjdk.java.net/legal/gplv2+ce.html

Proceed (y/N)? y
INFO: protonego       initialised (transitively) in ${jetty.base}\start.ini
INFO: protonego-boot  skipping (virtual module)
INFO: protonego-impl  skipping (virtual module)
INFO: server          initialised (transitively) in ${jetty.base}\start.ini
INFO: jndi            initialised (transitively) in ${jetty.base}\start.ini
INFO: security        initialised (transitively) in ${jetty.base}\start.ini
INFO: servlet         initialised (transitively) in ${jetty.base}\start.ini
INFO: ssl             initialised (transitively) in ${jetty.base}\start.ini
INFO: http2           initialised in ${jetty.base}\start.ini
INFO: webapp          initialised (transitively) in ${jetty.base}\start.ini
INFO: deploy          initialised in ${jetty.base}\start.ini
INFO: plus            initialised (transitively) in ${jetty.base}\start.ini
INFO: annotations     initialised in ${jetty.base}\start.ini
DOWNLOAD: http://central.maven.org/maven2/org/mortbay/jetty/alpn/alpn-boot/8.1.1.v20141016/alpn-boot-8.1.1.v20141016.jar to ${jetty.base}\lib\alpn\alpn-boot-8.1.1.v20141016.jar
DOWNLOAD: http://git.eclipse.org/c/jetty/org.eclipse.jetty.project.git/plain/jetty-server/src/main/config/etc/keystore to ${jetty.base}\etc\keystore
MKDIR: ${jetty.base}\webapps
INFO: Base directory was modified

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-push>cp C:\dev\blog-http2-push\blog-http2-push\src\main\jetty\blog-http2-push.xml .\webapps
'cp' is not recognized as an internal or external command,
operable program or batch file.

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-push>copy C:/dev/blog-http2-push/blog-http2-push/build/libs/blog-http2-push.xml .\webapps
C:
The system cannot find the file specified.
        0 file(s) copied.

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-push>copy C:\dev\blog-http2-push\blog-http2-push\build\libs\blog-http2-push.xml .\webapps
        1 file(s) copied.

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-push>java -jar %JETTY_HOME%\start.jar
2014-12-30 21:19:57.091:INFO::main: Logging initialized @131ms
2014-12-30 21:19:57.305:INFO:oejs.Server:main: jetty-9.3.0-SNAPSHOT
2014-12-30 21:19:57.324:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:///C:/tools/jetty/jetty-distribution-9.3.0-SNAPSHOT_2/blog-http2-push/webapps/] at interval 1
2014-12-30 21:19:58.168:INFO:oejw.StandardDescriptorProcessor:main: NO JSP Support for /blog-http2-push, did not find org.eclipse.jetty.jsp.JettyJspServlet
2014-12-30 21:19:58.201:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@6108b2d7{/blog-http2-push,file:///C:/Users/eyckmto/AppData/Local/Temp/jetty-0.0.0.0-8443-blog-http2-push-1.0.war-_blog-http2-push-any-2915100617218568179.dir/webapp/,AVAILABLE}{C:\dev\blog-http2-push\blog-http2-push\build\libs\blog-http2-push-1.0.war}
2014-12-30 21:19:58.428:INFO:oejs.ServerConnector:main: Started ServerConnector@3cf420cb{SSL,[ssl, alpn, h2-15, h2-14]}{0.0.0.0:8443}
2014-12-30 21:19:58.429:INFO:oejs.Server:main: Started @1472ms

browse to https://localhost:8443/blog-http2-push/push?push=true

using "C:\Users\eyckmto\AppData\Local\Google\Chrome SxS\Application\chrome.exe" --enable-spdy4
or firefox with network.http.spdy.enabled.http2draft;true in about:config