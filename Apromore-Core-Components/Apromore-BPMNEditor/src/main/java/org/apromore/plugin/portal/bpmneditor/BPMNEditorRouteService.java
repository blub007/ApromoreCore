/*-
 * #%L
 * This file is part of "Apromore Core".
 * %%
 * Copyright (C) 2018 - 2020 Apromore Pty Ltd.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
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
