/*
 * Copyright © 2009-2014 The Apromore Initiative.
 *
 * This file is part of "Apromore".
 *
 * "Apromore" is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * "Apromore" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.
 * If not, see <http://www.gnu.org/licenses/lgpl-3.0.html>.
 */

package de.vogella.algorithms.dijkstra.model;

import java.util.List;

public class Graph<T> {
    private final List<Vertex<T>> vertexes;
    private final List<Edge<T>> edges;

    public Graph(List<Vertex<T>> vertexes, List<Edge<T>> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex<T>> getVertexes() {
        return vertexes;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

} 