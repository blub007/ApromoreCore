package org.apromore.plugin.router;

import java.io.InputStream;

/**
 * An OSGi service describing a handler for certain URLs.
 */
public interface RouteService {

    /**
     * @param path  a candidate servlet path info
     * @return whether the <var>path</var> is on this route
     */
    boolean hasResource(String path);

    /**
     * @param path  a servlet path info that's been accepted by {@link #canRoute}
     * @return a stream containing the contents of the <var>path</var>
     */
    InputStream getResourceAsStream(String path);
}
