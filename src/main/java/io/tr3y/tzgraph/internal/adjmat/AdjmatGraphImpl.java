package io.tr3y.tzgraph.internal.adjmat;

import java.util.ArrayList;
import java.util.Collection;

import io.tr3y.tzgraph.Edge;
import io.tr3y.tzgraph.Graph;
import io.tr3y.tzgraph.Node;

public class AdjmatGraphImpl<D, E> implements Graph<D, E> {

	protected D[] nodeData;
	protected E[][] adjMatrix;
	
	protected AdjmatGraphImpl(D[] nd, E[][] adj) {
		this.nodeData = nd;
		this.adjMatrix = adj;
	}
	
	public Collection<Node<D, E>> getNodes() {
		
		ArrayList<Node<D, E>> nodes = new ArrayList<>();
		for (int i = 0; i < this.nodeData.length; i++) {
			nodes.add(new AdjmatNodeImpl<>(this, i));
		}
		
		return nodes;
		
	}

	public Collection<Edge<D, E>> getEdges() {
		
		ArrayList<Edge<D, E>> edges = new ArrayList<>();
		for (int i = 0; i < this.adjMatrix.length; i++) {
			// FIXME Make sure this math is right.
			for (int j = 0; j < Math.max(i, this.adjMatrix[i].length); j++) {
				edges.add(new AdjmatEdgeImpl<>(this, i, j));
			}
		}
		
		return edges;
		
	}

}
