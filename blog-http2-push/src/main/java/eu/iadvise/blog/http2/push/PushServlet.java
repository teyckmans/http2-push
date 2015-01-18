package eu.iadvise.blog.http2.push;

import org.eclipse.jetty.server.PushBuilder;
import org.eclipse.jetty.server.Request;

import javax.servlet.annotation.WebServlet;

/**
 * @author Tom Eyckmans
 */
@WebServlet("/push")
public class PushServlet extends AbstractHttpServlet
{
    @Override
    protected void doGet()
    {
        final int rows = intParameter("rows", 19);
        final int columns = intParameter("columns", 19);
        final boolean push = booleanParameter("push", true);

        final Page slicePage = new SlicePage(rows, columns);

        if (push) {
            for (String resourceToPush : slicePage.getReferencedResources()) {
                pushResource(resourceToPush);
            }
        }
        // else push is not requested

        setContentType(slicePage.getContentType());
        getOutputWriter().append(slicePage.getPageContent());
    }

    /**
     * Casts the current {@link javax.servlet.http.HttpServletRequest} to a {@link org.eclipse.jetty.server.Request}.
     *
     * Uses the Jetty request to get a {@link org.eclipse.jetty.server.PushBuilder} to execute the HTTP/2 push.
     *
     * @param resourcePath relative path of the resource to push
     */
    private void pushResource(String resourcePath)
    {
        final Request jettyRequest = (Request) getRequest();

        final PushBuilder pushBuilder = jettyRequest.getPushBuilder();

        pushBuilder
                .setQueryString(null)
                .push(resourcePath);
    }
}
