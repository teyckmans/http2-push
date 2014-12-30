package eu.iadvise.blog.http2.push;

import javax.servlet.annotation.WebServlet;

/**
 * @author Tom Eyckmans
 */
@WebServlet("/nopush")
public class NoPushServlet extends AbstractHttpServlet
{
    @Override
    protected void doGet()
    {
        final int rows = intParameter("rows", 19);
        final int columns = intParameter("columns", 19);

        final Page slicePage = new SlicePage(rows, columns);

        setContentType(slicePage.getContentType());
        getOutputWriter().append(slicePage.getPageContent());
    }
}
