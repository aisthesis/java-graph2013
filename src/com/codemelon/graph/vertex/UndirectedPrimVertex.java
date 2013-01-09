package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * Undirected vertex supporting the functions necessary for Prim's algorithm. This vertex
 * meets not only the requirements for Kruskal's algorithm (edge color and edge weight) but, 
 * in addition, also maintains a <em>vertex</em> weight.
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public class UndirectedPrimVertex<E extends SpanningTreeEdgeData> extends UndirectedKruskalVertex<E>
		implements PrimVertex<E> {
	private double weight;
	private Color color;
	private ChildVertex parent;
	
	/**
	 * Construct vertex from a factory for building appropriate EdgeData objects, 
	 * initialize vertex weight and color to the default values and set vertex
	 * parent to null.
	 * @param edgeDataFactory
	 */
	public UndirectedPrimVertex(EdgeDataFactory<E> edgeDataFactory) {
		super(edgeDataFactory);
		this.weight = WeightedVertex.DEFAULT_WEIGHT;
		this.color = Color.WHITE;
		this.parent = null;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.WeightedVertex#setWeight(double)
	 */
	@Override
	public final void setWeight(double weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.WeightedVertex#getWeight()
	 */
	@Override
	public final double getWeight() {
		return weight;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ColoredVertex#setColor(com.codemelon.graph.common.Color)
	 */
	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ColoredVertex#getColor()
	 */
	@Override
	public Color getColor() {
		return color;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ChildVertex#setParent(com.codemelon.graph.vertex.ChildVertex)
	 */
	@Override
	public void setParent(ChildVertex parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ChildVertex#getParent()
	 */
	@Override
	public ChildVertex getParent() {
		return parent;
	}
}
