/*-
 * #%L
 * This file is part of "Apromore Core".
 *
 * %%
 * Copyright (C) 2018 - 2020 The University of Melbourne.
 * %%
 *
 * "Apromore Core" is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * "Apromore Core" is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

package org.apromore.plugin.portal.processdiscoverer.data;

import org.apromore.processdiscoverer.Abstraction;

/**
 * OutputData contains data produced from this plugin
 * It can be used for reference to produce the next output
 * 
 * @author Bruce Nguyen
 *
 */
public class OutputData {
    private Abstraction currentAbstraction;
    private String visualizedText; // the corresponding JSON format of the diagram
    
    public OutputData(Abstraction currentAbstraction, String visualizedText) {
        this.currentAbstraction = currentAbstraction;
        this.visualizedText = visualizedText;
    }
    
    public Abstraction getAbstraction() {
        return currentAbstraction;
    }
    
    public String getVisualizedText() {
        return visualizedText;
    }
}
