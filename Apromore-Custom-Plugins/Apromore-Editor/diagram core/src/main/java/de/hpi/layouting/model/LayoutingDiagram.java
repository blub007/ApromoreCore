
package de.hpi.layouting.model;

/*-
 * #%L
 * Signavio Core Components
 * %%
 * Copyright (C) 2006 - 2020 Philipp Berger, Martin Czuchra, Gero Decker,
 * Ole Eckermann, Lutz Gericke,
 * Alexander Hold, Alexander Koglin, Oliver Kopp, Stefan Krumnow,
 * Matthias Kunze, Philipp Maschke, Falko Menge, Christoph Neijenhuis,
 * Hagen Overdick, Zhen Peng, Nicolas Peters, Kerstin Pfitzner, Daniel Polak,
 * Steffen Ryll, Kai Schlichting, Jan-Felix Schwarz, Daniel Taschik,
 * Willi Tscheschner, Björn Wagner, Sven Wagner-Boysen, Matthias Weidlich
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 * 
 * #L%
 */

import java.util.List;
import java.util.Map;

public interface LayoutingDiagram {

    public abstract Map<String, LayoutingElement> getElements();

    public abstract List<LayoutingElement> getChildElementsOf(LayoutingElement parent);

    public abstract List<LayoutingElement> getChildElementsOf(
            List<LayoutingElement> parents);

    public abstract List<LayoutingElement> getElementsOfType(String type);

    public abstract List<LayoutingElement> getElementsWithoutType(String type);

    /**
     * Liefert das bereits bekannte Element oder legt ein neues mit der id an
     *
     * @param id die ID des Elements
     * @return ein LayoutingElement mit der id
     */
    public abstract LayoutingElement getElement(String id);

    public abstract List<LayoutingElement> getStartEvents();

    public abstract List<LayoutingElement> getConnectingElements();

    public abstract List<LayoutingElement> getGateways();

}