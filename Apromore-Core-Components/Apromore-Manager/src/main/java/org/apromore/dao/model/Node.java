/*-
 * #%L
 * This file is part of "Apromore Core".
 *
 * Copyright (C) 2012 - 2017 Queensland University of Technology.
 * %%
 * Copyright (C) 2018 - 2020 The University of Melbourne.
 * %%
 *
 * "Apromore" is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * "Apromore" is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

package org.apromore.dao.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apromore.graph.canonical.AllocationStrategyEnum;
import org.apromore.graph.canonical.DirectionEnum;
import org.apromore.graph.canonical.NodeTypeEnum;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Node generated by hbm2java
 */
@Entity
@Table(name = "node",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"uri"})
        }
)
@Configurable("node")
@Cache(expiry = 180000, size = 10000, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)
public class Node implements Serializable {

    private Integer id;
    private String uri;
    private String name;
    private String netId;
    private String originalId;
    private String graphType;
    private Date timeDate;
    private String timeDuration;
    private Boolean configuration = false;
    private Boolean teamWork = false;
    private NodeTypeEnum nodeType;
    private AllocationStrategyEnum allocation;
    private DirectionEnum messageDirection;

    private ProcessModelVersion subProcess;
    private Expression timerExpression;
    private Expression resourceDataExpression;
    private Expression resourceRunExpression;

    private Set<NodeMapping> nodeMappings = new HashSet<>();

    private Set<Expression> inputExpressions = new HashSet<>();
    private Set<Expression> outputExpressions = new HashSet<>();

    private Set<Edge> sourceNodes = new HashSet<>();
    private Set<Edge> targetNodes = new HashSet<>();
    private Set<Node> cancelNodes = new HashSet<>();
    private Set<Edge> cancelEdges = new HashSet<>();

    private Set<ObjectRef> objectRefs = new HashSet<>();
    private Set<ResourceRef> resourceRefs = new HashSet<>();
    private Set<NodeAttribute> attributes = new HashSet<>();



    /**
     * Public Constructor.
     */
    public Node() { }


    /**
     * returns the Id of this Object.
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the Id of this Object
     * @param id the new Id.
     */
    public void setId(final Integer id) {
        this.id = id;
    }


    /**
     * The URI of this fragmentVersion.
     * @return the uri
     */
    @Column(name = "uri", length = 40)
    public String getUri() {
        return this.uri;
    }

    /**
     * The URI of this fragmentVersion.
     * @param newUri the new uri.
     */
    public void setUri(final String newUri) {
        this.uri = newUri;
    }

    @Column(name = "name", length = 2000)
    public String getName() {
        return this.name;
    }

    public void setName(final String newName) {
        this.name = newName;
    }

    @Column(name = "netId", length = 200)
    public String getNetId() {
        return this.netId;
    }

    public void setNetId(final String newNetId) {
        this.netId = newNetId;
    }

    @Column(name = "originalId", length = 200)
    public String getOriginalId() {
        return this.originalId;
    }

    public void setOriginalId(final String newOriginalId) {
        this.originalId = newOriginalId;
    }

    @Column(name = "graphType", length = 50)
    public String getGraphType() {
        return this.graphType;
    }

    public void setGraphType(final String newGraphType) {
        this.graphType = newGraphType;
    }

    @Column(name = "nodeType", length = 50)
    @Enumerated(EnumType.STRING)
    public NodeTypeEnum getNodeType() {
        return this.nodeType;
    }

    public void setNodeType(final NodeTypeEnum newNodeType) {
        this.nodeType = newNodeType;
    }

    @Column(name = "configuration", length = 1)
    public Boolean getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(final Boolean newConfigurable) {
        this.configuration = newConfigurable;
    }

    @Column(name="teamWork", length = 1)
    public Boolean getTeamWork() {
        return this.teamWork;
    }

    public void setTeamWork(Boolean teamWork) {
        this.teamWork = teamWork;
    }

    @Column(name = "allocation", length = 40)
    @Enumerated(EnumType.STRING)
    public AllocationStrategyEnum getAllocation() {
        return this.allocation;
    }

    public void setAllocation(AllocationStrategyEnum allocation) {
        this.allocation = allocation;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timeDate", length = 19)
    public Date getTimeDate() {
        return this.timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    @Column(name = "timeDuration", length = 100)
    public String getTimeDuration() {
        return this.timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    @Column(name = "messageDirection", length = 10)
    @Enumerated(EnumType.STRING)
    public DirectionEnum getMessageDirection() {
        return this.messageDirection;
    }

    public void setMessageDirection(DirectionEnum messageDirection) {
        this.messageDirection = messageDirection;
    }



    @ManyToOne
    @JoinColumn(name = "subVersionId")
    public ProcessModelVersion getSubProcess() {
        return this.subProcess;
    }

    public void setSubProcess(final ProcessModelVersion newSubProcess) {
        this.subProcess = newSubProcess;
    }

    @ManyToOne
    @JoinColumn(name = "resourceDataExpressionId")
    public Expression getResourceDataExpression() {
        return this.resourceDataExpression;
    }

    public void setResourceDataExpression(final Expression newExpressionByResourceDataExpressionId) {
        this.resourceDataExpression = newExpressionByResourceDataExpressionId;
    }

    @ManyToOne
    @JoinColumn(name = "resourceRunExpressionId")
    public Expression getResourceRunExpression() {
        return this.resourceRunExpression;
    }

    public void setResourceRunExpression(final Expression newExpressionByResourceRunExpressionId) {
        this.resourceRunExpression = newExpressionByResourceRunExpressionId;
    }

    @ManyToOne
    @JoinColumn(name = "timerExpressionId")
    public Expression getTimerExpression() {
        return this.timerExpression;
    }

    public void setTimerExpression(final Expression newTimerExpression) {
        this.timerExpression = newTimerExpression;
    }


    @OneToMany(mappedBy = "node", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<NodeMapping> getNodeMappings() {
        return nodeMappings;
    }

    public void setNodeMappings(Set<NodeMapping> newNodeMappings) {
        nodeMappings = newNodeMappings;
    }


    @ManyToMany
    @JoinTable(name = "cancel_nodes",
            joinColumns = { @JoinColumn(name = "nodeId") },
            inverseJoinColumns = { @JoinColumn(name = "cancelNodeId") })
    public Set<Node> getCancelNodes() {
        return this.cancelNodes;
    }

    public void setCancelNodes(final Set<Node> newCancelNodes) {
        this.cancelNodes = newCancelNodes;
    }




    @OneToMany(mappedBy = "cancelNode", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Edge> getCancelEdges() {
        return this.cancelEdges;
    }

    public void setCancelEdges(final Set<Edge> newCancelEdges) {
        this.cancelEdges = newCancelEdges;
    }

    @OneToMany(mappedBy = "sourceNode", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Edge> getSourceNodes() {
        return this.sourceNodes;
    }

    public void setSourceNodes(Set<Edge> newEdges) {
        this.sourceNodes = newEdges;
    }

    @OneToMany(mappedBy = "targetNode", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Edge> getTargetNodes() {
        return this.targetNodes;
    }

    public void setTargetNodes(Set<Edge> edges2) {
        this.targetNodes = edges2;
    }

    @OneToMany(mappedBy = "inputNode", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Expression> getInputExpressions() {
        return this.inputExpressions;
    }

    public void setInputExpressions(final Set<Expression> newInputExpression) {
        this.inputExpressions = newInputExpression;
    }

    @OneToMany(mappedBy = "outputNode", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Expression> getOutputExpressions() {
        return this.outputExpressions;
    }

    public void setOutputExpressions(final Set<Expression> newOutputExpression) {
        this.outputExpressions = newOutputExpression;
    }

    @OneToMany(mappedBy = "node", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ResourceRef> getResourceRefs() {
        return this.resourceRefs;
    }

    public void setResourceRefs(Set<ResourceRef> newResourceRefTypes) {
        this.resourceRefs = newResourceRefTypes;
    }

    @OneToMany(mappedBy = "node", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ObjectRef> getObjectRefs() {
        return this.objectRefs;
    }

    public void setObjectRefs(Set<ObjectRef> newObjectRefTypes) {
        this.objectRefs = newObjectRefTypes;
    }

    @OneToMany(mappedBy = "node", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<NodeAttribute> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Set<NodeAttribute> newAttributes) {
        this.attributes = newAttributes;
    }
}


