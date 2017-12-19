package io.tr3y.tzgraph;

public interface Edge<D, E> {

	Node<D, E> getFirst();
	Node<D, E> getSecond();
	E getData();
	
}
