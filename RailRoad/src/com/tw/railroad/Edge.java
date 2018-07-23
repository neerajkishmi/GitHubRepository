package com.tw.railroad;

/**The edge could be the path between the two cities, with the distance.
*/
public class Edge {
	//Name of origin town
	public Node origin;
	//Name of destination town
	public Node destination;
	//Route weight to destination
	public int weight;
	//next possible route
	public Edge next;
	
	/** Creates a node
	 * @origin name The name of origin town
	 * @destination The name of destination town
	 * @weight name Route weight to destination
	 * @next name The next possible route
	*/
	public Edge(Node origin, Node destination, int weight) {
		this.origin 		= origin;
		this.destination	= destination;
		this.weight 		= weight;
		this.next 		= null;
	}
 
	public Edge next(Edge edge) {
		this.next = edge;
		return this;
	}
}