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

package org.apromore.logman;

import java.io.File;

import org.deckfour.xes.in.XesXmlGZIPParser;
import org.deckfour.xes.in.XesXmlParser;
import org.deckfour.xes.model.XLog;

public class DataSetup {
    private XLog readXESFile(String fullFilePath) {
        XesXmlParser parser = new XesXmlParser();
        try {
            return parser.parse(new File(fullFilePath)).get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private XLog readXESCompressedFile(String fullFilePath) {
        XesXmlParser parser = new XesXmlGZIPParser();
        try {
            return parser.parse(new File(fullFilePath)).get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public XLog readEmptyLog() {
        return this.readXESFile("src/test/logs/L1_empty_log.xes");
    }
    
    public XLog readLogWithEmptyTrace() {
        return this.readXESFile("src/test/logs/L1_1trace_empty_trace.xes");
    }    
    
    public XLog readLogWithOneTraceOneEvent() {
        return this.readXESFile("src/test/logs/L1_1trace_1event.xes");
    }
    
    public XLog readLogWithOneTraceAndCompleteEvents() {
        return this.readXESFile("src/test/logs/L1_1trace_complete_events_only.xes");
    }
    
    public XLog readLogWithOneTrace_StartCompleteEvents_NonOverlapping() {
        return this.readXESFile("src/test/logs/L1_1trace_start_complete_events_non_overlapping.xes");
    }    
    
    public XLog readLogWithNoLifecycleTransitions() {
        return this.readXESFile("src/test/logs/L1_no_lifecycle_transition.xes");
    }
    
    public XLog readLogWithCompleteEventsOnly() {
        return this.readXESFile("src/test/logs/L1_complete_events_only_with_resources.xes");
        
    }
    
    //@Todo: prepare data
    public XLog readLogWithStartEventsOnly() {
        return this.readXESFile("src/test/logs/L1_complete_events_only_with_resources.xes");
    }
    
    public XLog readLogWithStartCompleteEventsNonOverlappingRepeats() {
        return this.readXESFile("src/test/logs/L1_start_complete_no_overlapping_repeats.xes");
    }
    
    public XLog readLogWithStartCompleteEventsOverlapping() {
        return this.readXESFile("src/test/logs/L1_start_complete_overlapping.xes");
    }
    
    public XLog readRealLog_BPI15() {
        return this.readXESCompressedFile("src/test/logs/BPIC15Municipality1.xes");
        
    }
    
    public XLog readRealLog_BPI12() {
        return this.readXESCompressedFile("src/test/logs/financial_log.xes.gz");
        
    }
    
    public XLog readRealLog_BPI18() {
        return this.readXESCompressedFile("src/test/logs/BPI_Challenge_2018.xes.gz");
        
    }
    
    public XLog readRealLog_teys() {
        return this.readXESCompressedFile("src/test/logs/teys_complete_cases.xes.gz");
        
    }
    
    public XLog readRealLog_procmin() {
        return this.readXESCompressedFile("src/test/logs/procmin20180612_F2_5M.xes.gz");
        
    }
}
