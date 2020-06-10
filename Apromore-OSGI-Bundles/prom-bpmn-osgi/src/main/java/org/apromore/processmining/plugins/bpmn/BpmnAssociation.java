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
package org.apromore.processmining.plugins.bpmn;

import java.util.Collection;
import java.util.Map;

import org.apromore.processmining.models.graphbased.directed.bpmn.BPMNDiagram;
import org.apromore.processmining.models.graphbased.directed.bpmn.BPMNNode;
import org.apromore.processmining.models.graphbased.directed.bpmn.elements.Association;
import org.xmlpull.v1.XmlPullParser;


public class BpmnAssociation extends BpmnFlow {

	public enum AssociationDirection {NONE, ONE, BOTH};
	
	private AssociationDirection direction;
	
	public BpmnAssociation(String tag) {
		super(tag);
	}
	
	public void unmarshall(BPMNDiagram diagram, Map<String, BPMNNode> id2node) {
		Association association = diagram.addAssociation(id2node.get(sourceRef), id2node.get(targetRef), direction);
		association.getAttributeMap().put("Original id", id);
		association.setDirection(direction);
	}

	public void unmarshall(BPMNDiagram diagram, Collection<String> elements, Map<String, BPMNNode> id2node) {
		if (elements.contains(sourceRef) && elements.contains(targetRef)) {
			if (id2node.containsKey(sourceRef) && id2node.containsKey(targetRef)) {
				Association association = diagram.addAssociation(id2node.get(sourceRef), id2node.get(targetRef), direction);
				association.getAttributeMap().put("Original id", id);
				association.setDirection(direction);
			}
			else {
				if (!id2node.containsKey(sourceRef)) {
					System.out.println("org.processmining.plugins.bpmn.BpmnAssociation.unmarshall(BPMNDiagram, Collection<String>, Map<String, BPMNNode>) element with sourceRef="+sourceRef+" not existing in id2node");
				}
				if (!id2node.containsKey(targetRef)) {
					System.out.println("org.processmining.plugins.bpmn.BpmnAssociation.unmarshall(BPMNDiagram, Collection<String>, Map<String, BPMNNode>) element with targetRef="+targetRef+" not existing in id2node");
				}
			}
		}
	}
	
	public void marshall(Association association) {
		super.marshall(association);
		direction = association.getDirection();
	}
	
	public void setDirection(AssociationDirection direction) {
		this.direction = direction;
	}
	
	protected void importAttributes(XmlPullParser xpp, Bpmn bpmn) {
		super.importAttributes(xpp, bpmn);
		String value = xpp.getAttributeValue(null, "associationDirection");
		if (value != null) {
			direction = AssociationDirection.valueOf(value.toUpperCase());
		}
	}
	
	protected String exportAttributes() {
		String s = super.exportAttributes();
		if (direction != null) {
			s += exportAttribute("associationDirection", direction.toString().substring(0, 1).toUpperCase() 
					+ direction.toString().substring(1));
		}
		return s;
	}
}
