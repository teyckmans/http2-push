package eu.iadvise.blog.http2.push;

import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Request;

import javax.servlet.RequestDispatcher;
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
        final boolean push = booleanParameter("push");

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
     * Retrieves the {@link javax.servlet.RequestDispatcher} for the resource path that needs to be pushed.
     *
     * Casts the request dispatcher to a {@link org.eclipse.jetty.server.Dispatcher} so we can use the experimental
     * push api.
     *
     * Calls push on the {@link org.eclipse.jetty.server.Dispatcher} of the resource that needs to be pushed for the
     * request the resource needs to be pushed for.
     *
     * @param resourceToPush path of the resource to push
     */
    private void pushResource(String resourceToPush)
    {
        final RequestDispatcher requestDispatcher = getRequest()
            .getServletContext()
            .getRequestDispatcher("/blog-http2-push/" + resourceToPush);

        final Dispatcher jettyDispatcher = (Dispatcher) requestDispatcher;

        jettyDispatcher.push(getRequest());
    }
}
