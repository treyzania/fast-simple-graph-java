package io.tr3y.tzgraph;

import java.util.Collection;

public interface Node<D, E> {
	
	D getData();
	Collection<Edge<D, E>> getEdges();
	
}
