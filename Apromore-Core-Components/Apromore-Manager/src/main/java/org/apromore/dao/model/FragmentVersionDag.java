/*-
 * #%L
 * This file is part of "Apromore Core".
 *
 * Copyright (C) 2012 - 2017 Queensland University of Technology.
 * Copyright (C) 2012 Felix Mannhardt.
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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * FragmentVersionDag generated by hbm2java
 */
@Entity
@Table(name = "fragment_version_dag",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"fragmentVersionId", "childFragmentVersionId", "pocketId"})
        }
)
@Configurable("fragmentVersionDag")
@Cache(expiry = 180000, size = 10000, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)
public class FragmentVersionDag implements Serializable {

    private Integer id;
    private String pocketId;

    private FragmentVersion fragmentVersion;
    private FragmentVersion childFragmentVersion;

    /**
     * Public Constructor.
     */
    public FragmentVersionDag() { }



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



    @Column(name = "pocketId", length = 40)
    public String getPocketId() {
        return this.pocketId;
    }

    public void setPocketId(final String pocketId) {
        this.pocketId = pocketId;
    }


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fragmentVersionId")
    public FragmentVersion getFragmentVersion() {
        return this.fragmentVersion;
    }

    public void setFragmentVersion(final FragmentVersion newFragmentVersion) {
        this.fragmentVersion = newFragmentVersion;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "childFragmentVersionId")
    public FragmentVersion getChildFragmentVersion() {
        return this.childFragmentVersion;
    }

    public void setChildFragmentVersion(final FragmentVersion newChildFragmentVersion) {
        this.childFragmentVersion = newChildFragmentVersion;
    }
}
