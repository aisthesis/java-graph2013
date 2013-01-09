package com.codemelon.graph.vertex;


import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeType;
import com.codemelon.graph.edge.DfsEdgeData;
import com.codemelon.graph.edge.EdgeDataFactory;

/**
 * Directed vertex supporting the operations required for depth-first search.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class DirectedDfsVertex<E extends DfsEdgeData> 
		extends DirectedEdgeDataVertex<E> implements EdgeTypeDfsVertex<E> {
	private Color color;
	private ChildVertex parent;
	private int discoveryTime;
	private int finishTime;
	
	/**
	 * Constructor from an EdgeDataFactory
	 * @param edgeDataFactory factory to use for creating new EdgeData objects
	 */
	public DirectedDfsVertex(EdgeDataFactory<E> edgeDataFactory) {
		super(edgeDataFactory);
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
	 * @see com.codemelon.graph.vertex.EdgeTypeVertex#setEdgeType(com.codemelon.graph.vertex.EdgeTypeVertex, com.codemelon.graph.edge.EdgeType)
	 */
	@Override
	public void setEdgeType(EdgeTypeVertex<E> to, EdgeType edgeType) {
		super.getEdgeData(to).setEdgeType(edgeType);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeTypeVertex#getEdgeType(com.codemelon.graph.vertex.EdgeTypeVertex)
	 */
	@Override
	public EdgeType getEdgeType(EdgeTypeVertex<E> to) {
		return super.getEdgeData(to).getEdgeType();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#setDiscoveryTime(int)
	 */
	@Override
	public void setDiscoveryTime(int discoveryTime) {
		this.discoveryTime = discoveryTime;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#setFinishTime(int)
	 */
	@Override
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#getDiscoveryTime()
	 */
	@Override
	public int getDiscoveryTime() {
		return discoveryTime;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#getFinishTime()
	 */
	@Override
	public int getFinishTime() {
		return finishTime;
	}
}