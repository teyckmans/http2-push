package eu.iadvise.blog.http2.push;

import java.util.ArrayList;
import java.util.List;

/**
 * Page containing many references to image slices that make up a large picture.
 *
 * @author Tom Eyckmans
 */
public class SlicePage implements Page
{
    /**
     * [0-19]
     */
    private final int rows;
    /**
     * [0-19]
     */
    private final int columns;

    private String pageContent;
    private String contentType;
    private List<String> referencedResources = new ArrayList<String>();

    public SlicePage(int rows, int columns)
    {
        if (rows < 0 || 19 < rows) {
            throw new IllegalArgumentException("rows is out of bounds expected range [0-19]");
        }
        if (columns < 0 || 19 < columns) {
            throw new IllegalArgumentException("columns is out of bounds expected range [0-19]");
        }

        this.rows = rows;
        this.columns = columns;

        this.pageContent = generateSlicePage();
        this.contentType = "text/html";
    }

    @Override
    public String getPageContent()
    {
        return pageContent;
    }

    @Override
    public String getContentType()
    {
        return contentType;
    }

    @Override
    public List<String> getReferencedResources()
    {
        return referencedResources;
    }

    private String generateSlicePage()
    {
        final StringBuilder pageBuffer = new StringBuilder();

        pageBuffer.append("<html>");
        pageBuffer.append("<body>");

        pageBuffer.append(generateSliceTable());

        pageBuffer.append("</body>");
        pageBuffer.append("</html>");

        return pageBuffer.toString();
    }

    private String generateSliceTable()
    {
        final StringBuilder tableBuffer = new StringBuilder();

        tableBuffer.append("<table cellpadding=\"0\" border=\"0\" cellspacing=\"2\">");

        for(int rowIndex = 0; rowIndex <= rows; rowIndex++) {
            tableBuffer.append(generateSliceRow(rowIndex));
        }

        tableBuffer.append("</table>");

        return tableBuffer.toString();
    }

    private String generateSliceRow(int rowIndex)
    {
        final StringBuilder rowBuffer = new StringBuilder();

        rowBuffer.append("<tr>");

        for(int columnIndex = 0; columnIndex <= columns; columnIndex++) {
            final String imagePath = "images/slice_" + rowIndex + "_" + columnIndex + ".jpg";

            referencedResources.add(imagePath);

            rowBuffer
                .append("<td><img alt=\" \" src=\"")
                .append(imagePath)
                .append("\" style=\"width: 51px;  height: 10px; border-width: 0px;\"></td>");
        }

        rowBuffer.append("</tr>");

        return rowBuffer.toString();
    }
}
