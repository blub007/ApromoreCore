/*-
 * #%L
 * This file is part of "Apromore Core".
 * 
 * Copyright (C) 2012 Felix Mannhardt.
 * Copyright (C) 2013 - 2017 Queensland University of Technology.
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

package org.apromore.manager.client.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.apromore.canoniser.result.CanoniserMetadataResult;
import org.apromore.helper.CanoniserHelper;
import org.apromore.model.NativeMetaData;
import org.junit.Test;

public class CanoniserHelperUnitTest {

    @Test
    public void testConvertFromCanoniserMetaData() {
        CanoniserMetadataResult metaData = new CanoniserMetadataResult();
        metaData.setProcessAuthor("test");
        metaData.setProcessCreated(new Date());
        metaData.setProcessLastUpdate(null);
        metaData.setProcessName("a name");
        metaData.setProcessVersion("1.0");
        NativeMetaData xmlMetaData = CanoniserHelper.convertFromCanoniserMetaData(metaData);
        assertNotNull(xmlMetaData);
        assertEquals("test", xmlMetaData.getProcessAuthor());
        assertEquals("a name", xmlMetaData.getProcessName());
        assertEquals("1.0", xmlMetaData.getProcessVersion());
        assertNull(xmlMetaData.getProcessLastUpdate());
        assertNotNull(xmlMetaData.getProcessCreated());
    }

}
