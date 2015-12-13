/*
 * Copyright © 2009-2015 The Apromore Initiative.
 *
 * This file is part of "Apromore".
 *
 * "Apromore" is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * "Apromore" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/lgpl-3.0.html>.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.29 at 04:56:08 PM EST 
//


package de.hpi.bpmn2_0.model.extension.synergia;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tGatewayType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tGatewayType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="data-based_exclusive"/>
 *     &lt;enumeration value="event-based_exclusive"/>
 *     &lt;enumeration value="inclusive"/>
 *     &lt;enumeration value="parallel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tGatewayType", namespace = "http://www.processconfiguration.com")
@XmlEnum
public enum TGatewayType {

    @XmlEnumValue("data-based_exclusive")
    DATA_BASED_EXCLUSIVE("data-based_exclusive"),
    @XmlEnumValue("event-based_exclusive")
    EVENT_BASED_EXCLUSIVE("event-based_exclusive"),
    @XmlEnumValue("inclusive")
    INCLUSIVE("inclusive"),
    @XmlEnumValue("parallel")
    PARALLEL("parallel");
    private final String value;

    TGatewayType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGatewayType fromValue(String v) {
        for (TGatewayType c: TGatewayType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
