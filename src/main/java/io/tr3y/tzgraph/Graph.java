package io.tr3y.tzgraph;

import java.util.Collection;

public interface Graph<D, E> {

	Collection<Node<D, E>> getNodes();
	Collection<Edge<D, E>> getEdges();
	
}
