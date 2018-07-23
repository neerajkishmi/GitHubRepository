package com.tw.railroad;

/** A vertex, or a node here could be the city. 
*/
public class Node {
	public String name;
	public boolean visited;

	/** Creates a node
	 * @param name The name of the node eg: A, B, C, D, E
	*/
	public Node(String name) {
		this.name = name;
		
		//If the node has already been visited or not
		this.visited = false;
	}

	/*As we are using class as the key, the default equals() functions won't work. 
	*In Java, the contains() function will first look up for the hashCode(), 
	*and only then, if it needs to will look up the equals() function. 
	*Although even in any other case, always good to override hashCode() 
	*when you override equals(). I didn’t add a toString() function, 
	*but it is considered good practice to override that as well.
	*/
	@Override
	public boolean equals(Object b) {
		if (b == null || b.getClass() != getClass()) {
	        return false;
	    }
		Node bx = (Node)b;
		return this.name.equals(bx.name);
	}

	/*Always good to override hashCode() 
	*when you override equals(). I didn’t add a toString() function, 
	*but it is considered good practice to override that as well.
	*/
	@Override
	public int hashCode() {
		if(this.name == null) return 0;
		return this.name.hashCode();
	}
}