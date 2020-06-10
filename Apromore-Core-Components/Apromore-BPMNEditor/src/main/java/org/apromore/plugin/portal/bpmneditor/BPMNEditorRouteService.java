package org.apromore.plugin.portal.bpmneditor;

import java.io.InputStream;
import org.apromore.plugin.router.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BPMNEditorRouteService implements RouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BPMNEditorRouteService.class);
    private static final String PREFIX = "/process-model";
    private static final String PACKAGE = "/webapp";

    @Override
    public boolean hasResource(String path) {
        return path.equals(PREFIX) || path.startsWith(PREFIX + "/");
    }

    @Override
    public InputStream getResourceAsStream(String path) {
        assert hasResource(path);
        String classpath = PACKAGE + (path.equals(PREFIX) ? "/editBPMN.zul" : path.substring(PREFIX.length()));
        LOGGER.info("Routed {} to {} within apromore-bpmneditor bundle", path, classpath);

        return BPMNEditorRouteService.class.getClassLoader().getResourceAsStream(classpath);
    }
}
