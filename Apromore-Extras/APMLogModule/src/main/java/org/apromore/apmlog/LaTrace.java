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
package org.apromore.apmlog;

import org.eclipse.collections.impl.map.mutable.UnifiedMap;

import java.util.List;

/**
 * @author Chii Chang (created: 2020-03-18)
 */
public interface LaTrace {

    String getCaseId();
    long getCaseIdDigit();
    int getEventSize();
    List<AActivity> getActivityList();
    UnifiedMap<String, String> getAttributeMap();
    int getCaseVariantId();
    List<AEvent> getEventList();
    long getStartTimeMilli();
    long getEndTimeMilli();
    long getDuration();
    long getTotalProcessingTime();

    long getAverageProcessingTime();

    long getMaxProcessingTime();

    long getTotalWaitingTime();

    long getAverageWaitingTime();

    long getMaxWaitingTime();

    double getCaseUtilization();
}
