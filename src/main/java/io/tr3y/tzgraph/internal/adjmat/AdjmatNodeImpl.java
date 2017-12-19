package io.tr3y.tzgraph.internal.adjmat;

import java.util.ArrayList;
import java.util.Collection;

import io.tr3y.tzgraph.Edge;
import io.tr3y.tzgraph.Node;

public class AdjmatNodeImpl<D, E> implements Node<D, E> {

	protected AdjmatGraphImpl<D, E> graph;
	protected int index;
	
	protected AdjmatNodeImpl(AdjmatGraphImpl<D, E> g, int i) {
		this.graph = g;
		this.index = i;
	}
	
	public D getData() {
		return this.graph.nodeData[index];
	}

	public Collection<Edge<D, E>> getEdges() {
		
		E[] es = this.graph.adjMatrix[this.index];
		
		/*
		 * Iterate through each of the entries in the adjacency matrix and if
		 * there's data there (meaning it's taken care of), then add an entry
		 * to the collection. 
		 */
		ArrayList<Edge<D, E>> edges = new ArrayList<>();
		for (int i = 0; i < es.length; i++) {
			if (es[i] != null) edges.add(new AdjmatEdgeImpl<>(this.graph, this.index, i));
		}
		
		return edges;
		
	}

}
