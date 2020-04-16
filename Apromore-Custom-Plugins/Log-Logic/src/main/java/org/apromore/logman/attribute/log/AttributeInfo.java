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

package org.apromore.logman.attribute.log;

public class AttributeInfo {
    private String attValue;
    private long attOccurCount;
    private double attOccurFreq;
    
    public AttributeInfo(String attValue, long attOccurCount, double attOccurFreq) {
        this.attValue = attValue;
        this.attOccurCount = attOccurCount;
        this.attOccurFreq = attOccurFreq;
    }
    
    public String getAttributeValue() {
        return this.attValue;
    }
    
    public long getAttributeOccurrenceCount() {
        return this.attOccurCount;
    }
    
    public double getAttributeOccurrenceFrequency() {
        return this.attOccurFreq;
    }
}
