/*-
 * #%L
 * This file is part of "Apromore Core".
 * 
 * Copyright (C) 2012, 2014 - 2017 Queensland University of Technology.
 * %%
 * Copyright (C) 2018 - 2020 The University of Melbourne.
 * %%
 * Copyright (C) 2020, Apromore Pty Ltd.
 *
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

package org.apromore.canoniser.bpmn.anf;

// Java 2 Standard packages
import java.math.BigDecimal;

// Local packages
import org.apromore.anf.PositionType;
import org.omg.spec.dd._20100524.dc.Bounds;
import org.omg.spec.dd._20100524.dc.Point;

/**
 * ANF 0.3 position element.
 *
 * @author <a href="mailto:simon.raboczi@uqconnect.edu.au">Simon Raboczi</a>
 */
public class AnfPositionType extends PositionType {

    /** No-arg constructor. */
    public AnfPositionType() { }

    /**
     * Construct a position corresponding to the upper left corner of an OMG DC Bounds.
     *
     * @param bounds  an OMG DC Bounds
     */
    public AnfPositionType(final Bounds bounds) {
        setX(new BigDecimal(bounds.getX()));
        setY(new BigDecimal(bounds.getY()));
    }

    /**
     * Construct a position corresponding to an OMG DC Point.
     *
     * @param point  an OMG DC Point
     */
    public AnfPositionType(final Point point) {
        setX(new BigDecimal(point.getX()));
        setY(new BigDecimal(point.getY()));
    }
}
