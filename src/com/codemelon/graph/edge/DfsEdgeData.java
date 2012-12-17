package com.codemelon.graph.edge;

/**
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class DfsEdgeData implements EdgeTypeData {
	private EdgeType edgeType;
	/**
	 * Default constructor sets edge type to UNKNOWN
	 */
	public DfsEdgeData() {
		this(EdgeType.UNKNOWN);
	}
	/**
	 * Construct a DfsEdgeData object with initial type specified by input
	 * @param edgeType type to which to initialize this EdgeData object
	 */
	public DfsEdgeData(EdgeType edgeType) {
		this.edgeType = edgeType;
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeTypeData#setEdgeType(com.codemelon.graph.edge.EdgeType)
	 */
	@Override
	public void setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeTypeData#getEdgeType()
	 */
	@Override
	public EdgeType getEdgeType() {
		return edgeType;
	}

	public static enum Factory implements EdgeDataFactory<DfsEdgeData> {
		INSTANCE;
		/* (non-Javadoc)
		 * @see com.codemelon.graph.edge.interfaces.EdgeDataFactory#newEdgeData()
		 */
		@Override
		public DfsEdgeData newEdgeData() {
			return new DfsEdgeData();
		}		
	}
}
