package io.tr3y.tzgraph.internal.adjmat;

import io.tr3y.tzgraph.Edge;
import io.tr3y.tzgraph.Node;

public class AdjmatEdgeImpl<D, E> implements Edge<D, E> {

	protected AdjmatGraphImpl<D, E> graph;
	protected int firstIndex, secondIndex;
	
	protected AdjmatEdgeImpl(AdjmatGraphImpl<D, E> g, int a, int b) { 
		this.graph = g;
		this.firstIndex = a;
		this.secondIndex = b;
	}
	
	public Node<D, E> getFirst() {
		return new AdjmatNodeImpl<>(this.graph, this.firstIndex);
	}

	public Node<D, E> getSecond() {
		return new AdjmatNodeImpl<>(this.graph, this.secondIndex);
	}

	public E getData() {
		return this.graph.adjMatrix[this.firstIndex][this.secondIndex];
	}

	@Override
	public boolean equals(Object o) {
		
		if (o == null) return false;
		if (o.getClass() != this.getClass()) return false;
		
		@SuppressWarnings("unchecked") 
		AdjmatEdgeImpl<D, E> p = (AdjmatEdgeImpl<D, E>) o;
		
		// This conditional is so fucking disgusting, but I'm sorry.
		return this.graph == p.graph &&
				((this.firstIndex == p.firstIndex && this.secondIndex == p.secondIndex) ||
				(this.firstIndex == p.secondIndex && this.secondIndex == p.firstIndex));
		
	}
	
}
