package eu.iadvise.blog.http2.push;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * {@link javax.servlet.http.HttpServlet} utility layer.
 *
 * Stores the current {@link javax.servlet.http.HttpServletRequest} and {@link javax.servlet.http.HttpServletResponse}
 * in a thread local and provides utility methods to implementations.
 *
 * @author Tom Eyckmans
 */
public abstract class AbstractHttpServlet extends HttpServlet
{
    private final ThreadLocal<ServletCallContext> servletCallContext = new ThreadLocal<ServletCallContext>();

    @Override
    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        setUpCallContext(request, response);
        try {
            doGet();
        }
        finally {
            tearDownCallContext();
        }
    }

    @Override
    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        setUpCallContext(request, response);
        try {
            doPost();
        }
        finally {
            tearDownCallContext();
        }
    }

    protected void doGet()
    {

    }

    protected void doPost()
    {

    }

    private void setUpCallContext(HttpServletRequest request, HttpServletResponse response)
    {
        servletCallContext.set(new ServletCallContext(request, response));
    }

    private void tearDownCallContext()
    {
        servletCallContext.set(null);
    }

    protected void setContentType(String contentType)
    {
        getResponse().setContentType(contentType);
    }

    protected boolean booleanParameter(String parameterName)
    {
        return Boolean.valueOf(getRequest().getParameter(parameterName));
    }

    protected boolean booleanParameter(String parameterName, boolean defaultValue)
    {
        String stringValue = getRequest().getParameter(parameterName);

        if (stringValue != null && "".equals(stringValue)) {
            return Boolean.valueOf(stringValue);
        }
        else {
            return defaultValue;
        }
    }

    protected int intParameter(String parameterName)
    {
        return Integer.parseInt(getRequest().getParameter(parameterName));
    }

    protected int intParameter(String parameterName, int defaultValue)
    {
        try {
            return intParameter(parameterName);
        }
        catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    protected HttpServletRequest getRequest()
    {
        return servletCallContext.get().getRequest();
    }

    protected PrintWriter getOutputWriter()
    {
        try {
            return getResponse().getWriter();
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to retrieve output writer", e);
        }
    }

    protected HttpServletResponse getResponse()
    {
        return servletCallContext.get().getResponse();
    }
}
