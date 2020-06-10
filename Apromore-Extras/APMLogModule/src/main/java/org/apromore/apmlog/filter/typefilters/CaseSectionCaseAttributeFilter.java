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
package org.apromore.apmlog.filter.typefilters;

import org.apromore.apmlog.LaTrace;
import org.apromore.apmlog.filter.rules.LogFilterRule;
import org.apromore.apmlog.filter.types.Choice;
import org.apromore.apmlog.filter.types.FilterType;

import java.util.Set;

public class CaseSectionCaseAttributeFilter {

    public static boolean toKeep(LaTrace trace, LogFilterRule logFilterRule) {
        Choice choice = logFilterRule.getChoice();
        switch (choice) {
            case RETAIN: return conformRule(trace, logFilterRule);
            default: return !conformRule(trace, logFilterRule);
        }
    }

    private static boolean conformRule(LaTrace trace, LogFilterRule logFilterRule) {
        String attributeKey = logFilterRule.getKey();

        FilterType filterType = logFilterRule.getFilterType();

        switch (filterType) {
            case CASE_ID:
                String caseId = trace.getCaseId();
                Set<String> ids = logFilterRule.getPrimaryValuesInString();

                return ids.contains(caseId);
            case CASE_VARIANT:
                String caseVariant = trace.getCaseVariantId() + "";
                Set<String> variants = logFilterRule.getPrimaryValuesInString();

                return variants.contains(caseVariant);
                default:
                    if (!trace.getAttributeMap().keySet().contains(attributeKey)) return false;

                    String value = trace.getAttributeMap().get(attributeKey);

                    Set<String> values = logFilterRule.getPrimaryValuesInString();

                    return values.contains(value);
        }
//
//        if (!logFilterRule.getKey().equals("concept:name")) {
//            if (!trace.getAttributeMap().keySet().contains(attributeKey)) return false;
//
//            String value = trace.getAttributeMap().get(attributeKey);
//
//            Set<String> values = logFilterRule.getPrimaryValuesInString();
//
//            return values.contains(value);
//        }
//        if (logFilterRule.getKey().equals("concept:name")) {
//            String caseId = trace.getCaseId();
//            Set<String> values = logFilterRule.getPrimaryValuesInString();
//
//            return values.contains(caseId);
//        } else if (logFilterRule.getKey().equals("case:variant")) {
//            String caseId = trace.getCaseId();
//            Set<String> values = logFilterRule.getPrimaryValuesInString();
//
//            return values.contains(caseId);
//        }
    }
}
