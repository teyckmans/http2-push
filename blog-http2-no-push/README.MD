
using e8c88cfd9cf3cab89788cd530838314089ce9b23 from git://git.eclipse.org/gitroot/jetty/org.eclipse.jetty.project.git

execute mvn clean install using maven 3

extract the distribution from org.eclipse.jetty.project\jetty-distribution\target\jetty-distribution-9.3.0-SNAPSHOT.zip



C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT\blog-http2-no-push>cd C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2>mkdir blog-http2-no-push

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2>cd blog-http2-no-push

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-no-push>set JETTY_HOME=C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-no-push>set JETTY_BASE=C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-no-push

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-no-push>java -jar %JETTY_HOME%\start.jar --add-to-start=annotations,http,deploy
INFO: server          initialised (transitively) in ${jetty.base}\start.ini
INFO: http            initialised in ${jetty.base}\start.ini
INFO: jndi            initialised (transitively) in ${jetty.base}\start.ini
INFO: security        initialised (transitively) in ${jetty.base}\start.ini
INFO: servlet         initialised (transitively) in ${jetty.base}\start.ini
INFO: webapp          initialised (transitively) in ${jetty.base}\start.ini
INFO: deploy          initialised in ${jetty.base}\start.ini
INFO: plus            initialised (transitively) in ${jetty.base}\start.ini
INFO: annotations     initialised in ${jetty.base}\start.ini
MKDIR: ${jetty.base}\webapps
INFO: Base directory was modified

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-no-push>copy C:\dev\blog-http2-push\blog-http2-no-push\build\libs\blog-http2-no-push.xml .\webapps
        1 file(s) copied.

C:\tools\jetty\jetty-distribution-9.3.0-SNAPSHOT_2\blog-http2-no-push>java -jar %JETTY_HOME%\start.jar
2014-12-30 21:42:38.122:INFO::main: Logging initialized @568ms
2014-12-30 21:42:38.293:INFO:oejs.Server:main: jetty-9.3.0-SNAPSHOT
2014-12-30 21:42:38.310:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:///C:/tools/jetty/jetty-distribution-9.3.0-SNAPSHOT_2/blog-http2-no-push/webapps/] at interval 1
2014-12-30 21:42:38.911:INFO:oejw.StandardDescriptorProcessor:main: NO JSP Support for /blog-http2-no-push, did not find org.eclipse.jetty.jsp.JettyJspServlet
2014-12-30 21:42:38.952:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@5315b42e{/blog-http2-no-push,file:///C:/Users/eyckmto/AppData/Local/Temp/jetty-0.0.0.0-8080-blog-http2-no-push-1.0.war-_blog-http2-no-push-any-8399835108749143877.d
ir/webapp/,AVAILABLE}{C:\dev\blog-http2-push\blog-http2-no-push\build\libs\blog-http2-no-push-1.0.war}
2014-12-30 21:42:39.010:INFO:oejs.ServerConnector:main: Started ServerConnector@7c06c866{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2014-12-30 21:42:39.011:INFO:oejs.Server:main: Started @1458ms

browse to http://localhost:8080/blog-http2-no-push/nopush


