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
package org.apromore.apmlog.filter.rules;


import org.apromore.apmlog.filter.types.FilterType;
import org.apromore.apmlog.filter.types.OperationType;

import java.io.Serializable;

public class RuleValue implements Comparable<RuleValue>, Serializable {

    private FilterType filterType;
    private OperationType operationType;
    private String key;
    private String stringVal;
    private long longVal = 0;
    private double doubleVal = 0;
    private int intVal = 0;

    public RuleValue(FilterType filterType, OperationType operationType, String key, String stringVal) {
        this.filterType = filterType;
        this.operationType = operationType;
        this.key = key;
        this.stringVal = stringVal;
    }

    public RuleValue(FilterType filterType, OperationType operationType, String key, long longVal) {
        this.filterType = filterType;
        this.operationType = operationType;
        this.key = key;
        this.longVal = longVal;
        this.stringVal = longVal + "";
    }

    public RuleValue(FilterType filterType, OperationType operationType, String key, double doubleVal) {
        this.filterType = filterType;
        this.operationType = operationType;
        this.key = key;
        this.doubleVal = doubleVal;
        this.stringVal = doubleVal + "";
    }

    public RuleValue(FilterType filterType, OperationType operationType, String key, int intVal) {
        this.filterType = filterType;
        this.operationType = operationType;
        this.key = key;
        this.intVal = intVal;
        this.stringVal = intVal + "";
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getKey() {
        return this.key;
    }

    public String getStringValue() {
        return this.stringVal;
    }

    public long getLongValue() {
        return longVal;
    }

    public double getDoubleValue() {
        return doubleVal;
    }

    public int getIntValue() {
        return intVal;
    }

    public RuleValue clone() {
        FilterType filterTypeCopy = filterType;
        OperationType operationTypeCopy = operationType;
        String keyCopy = key;
        String stringValCopy = stringVal;
        long longValCopy = longVal;
        double doubleValCopy = doubleVal;
        int intValCopy = intVal;

        if (longValCopy != 0) return new RuleValue(filterTypeCopy, operationTypeCopy, keyCopy, longValCopy );
        else if (doubleValCopy != 0) return new RuleValue(filterTypeCopy, operationTypeCopy, keyCopy, doubleValCopy );
        else if (intValCopy != 0) return new RuleValue(filterTypeCopy, operationTypeCopy, keyCopy, intValCopy );
        else return new RuleValue(filterTypeCopy, operationTypeCopy, keyCopy, stringValCopy );
    }


    @Override
    public int compareTo(RuleValue o) {
        if (this.intVal != 0 && o.getIntValue() != 0) {
            if (this.intVal > o.getIntValue()) return 1;
            else if (this.intVal < o.getIntValue()) return -1;
            else return 0;
        } else if (this.doubleVal != 0 && o.getDoubleValue() != 0) {
            if (this.doubleVal > o.getDoubleValue()) return 1;
            else if (this.doubleVal < o.getDoubleValue()) return -1;
            else return 0;
        } else if (this.longVal != 0 && o.getLongValue() != 0) {
            if (this.longVal > o.getLongValue()) return 1;
            else if (this.longVal < o.getLongValue()) return -1;
            else return 0;
        } else {
            return this.stringVal.compareTo(o.getStringValue());
        }
    }
}
