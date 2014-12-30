package eu.iadvise.blog.http2.push;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tom Eyckmans
 */
class ServletCallContext
{
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    ServletCallContext(HttpServletRequest request, HttpServletResponse response)
    {
        if (request == null) {
            throw new IllegalArgumentException("request is required");
        }
        if (response == null) {
            throw new IllegalArgumentException("response is required");
        }

        this.request = request;
        this.response = response;
    }

    HttpServletRequest getRequest()
    {
        return request;
    }

    HttpServletResponse getResponse()
    {
        return response;
    }
}
