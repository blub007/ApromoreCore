/*-
 * #%L
 * This file is part of "Apromore Core".
 * 
 * Copyright (C) 2012 Felix Mannhardt.
 * Copyright (C) 2012 - 2017 Queensland University of Technology.
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

package org.apromore.service.helper;

import org.apromore.dao.model.ProcessModelVersion;
import org.apromore.helper.Version;
import org.apromore.model.ProcessSummaryType;
import org.apromore.model.SummariesType;
import org.apromore.model.SummaryType;
import org.apromore.plugin.property.RequestParameterType;
import org.apromore.service.CanoniserService;
import org.apromore.service.ProcessService;
import org.apromore.service.model.CanonisedProcess;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.HashSet;
import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.fail;

/**
 * Unit test the CanoniserService Implementation.
 *
 * @author <a href="mailto:cam.james@gmail.com">Cameron James</a>
 */
@Ignore
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/applicationContext-jpa-TEST.xml",
        "classpath:META-INF/spring/applicationContext-services-TEST.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class)
public class UIHelperImplIntgTest {

    @Inject
    private UserInterfaceHelper uiSrv;
    @Inject
    private CanoniserService cSrv;
    @Inject
    private ProcessService pSrv;

    private HashSet<RequestParameterType<?>> emptyCanoniserRequest;

    @Before
    public void setUp() {
        emptyCanoniserRequest = new HashSet<RequestParameterType<?>>();
    }


    @Test
    @Rollback
    public void TestUIHelper() throws Exception {
        createProcessModel("testUI");

        SummariesType summariesType = uiSrv.buildProcessSummaryList(0, "testUserRowGuid", "", "", "");

        assertThat(summariesType, notNullValue());
        assertThat(summariesType.getSummary().size(), greaterThan(0));

        boolean found = false;
        for (SummaryType summaryType : summariesType.getSummary()) {
            if(summaryType instanceof ProcessSummaryType) {
                ProcessSummaryType processSummaryType = (ProcessSummaryType) summaryType;
                if (processSummaryType.getName().equals("testUI")) {
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            fail("Process with name testUI not found in processSummary.");
        }
    }



    private void createProcessModel(String name) throws Exception {
        String nativeType = "EPML 2.0";

        InputStream input = ClassLoader.getSystemResourceAsStream("EPML_models/test2.epml");
        CanonisedProcess cp = cSrv.canonise(nativeType, input, emptyCanoniserRequest);

        assertThat(cp, notNullValue());
        assertThat(cp.getCpt(), notNullValue());

        String username = "james";
        String domain = "TEST";
        String created = "01/01/2011";
        String lastUpdate = "01/01/2011";
        Version version = new Version(1, 0);

        ProcessModelVersion pst = pSrv.importProcess(username, 0, name, version, nativeType, cp, domain, "", created, lastUpdate, true);

        assertThat(pst, notNullValue());
    }

}
