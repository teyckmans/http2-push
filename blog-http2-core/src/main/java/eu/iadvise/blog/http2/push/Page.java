package eu.iadvise.blog.http2.push;

import java.util.List;

/**
 * Very basic representation of a web page.
 *
 * @author Tom Eyckmans
 */
public interface Page
{
    String getPageContent();

    String getContentType();

    List<String> getReferencedResources();
}