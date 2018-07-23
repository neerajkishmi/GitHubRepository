package com.tw.railroad;

import static org.junit.Assert.*;

import java.util.ArrayList;
 
import org.junit.BeforeClass;
import org.junit.Test;

public class RailRoadTest {
	static Routes graph;
	static Node a, b, c, d, e;
 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		graph = new Routes(); //Build graph
 
		a = new Node("A");
		b = new Node("B");
		c = new Node("C");
		d = new Node("D");
		e = new Node("E");
 
		/*Input given in programming challenge
		Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7*/
		graph.routeTable.put(a, new Edge(a, b, 5).next(new Edge(a, d, 5).next(new Edge(a, e, 7))));
		graph.routeTable.put(b, new Edge(b, c, 4));
		graph.routeTable.put(c, new Edge(c, d, 8).next(new Edge(c, e, 2)));
		graph.routeTable.put(d, new Edge(d, c, 8).next(new Edge(d, e, 6)));
		graph.routeTable.put(e, new Edge(e, b, 3));
	}
 
	//1. The distance of the route A-B-C.
	@Test
	public void testDistanceBetween_ABC() throws Exception {
		ArrayList<Node> route = new ArrayList<Node>(); 
		route.add(a);
		route.add(b);
		route.add(c);
		assertEquals(9, graph.distanceBetween(route));
	}
 
	//2. The distance of the route A-D.
	@Test
	public void testDistanceBetween_AD() throws Exception {
		ArrayList<Node> route = new ArrayList<Node>(); 
		route.add(a);
		route.add(d);
		assertEquals(5, graph.distanceBetween(route));
	}
 
	//3. The distance of the route A-D-C.
	@Test
	public void testDistanceBetween_ADC() throws Exception  {
		ArrayList<Node> route = new ArrayList<Node>(); 
		route.add(a);
		route.add(d);
		route.add(c);
		assertEquals(13, graph.distanceBetween(route));
	}
 
	//4. The distance of the route A-E-B-C-D.
	@Test
	public void testDistanceBetween_AEBCD() throws Exception  {
		ArrayList<Node> route = new ArrayList<Node>(); 
		route.add(a);
		route.add(e);
		route.add(b);
		route.add(c);
		route.add(d);
		assertEquals(22, graph.distanceBetween(route));
	}
 
	//5. The distance of the route A-E-D.
	@Test(expected=Exception.class)
	public void testDistanceBetween_AED() throws Exception  {
		ArrayList<Node> route = new ArrayList<Node>(); 
		route.add(a);
		route.add(e);
		route.add(d);
		assertEquals(-1, graph.distanceBetween(route));
	}
 
	/*
	 * 6. The number of trips starting at C and ending at C with a maximum 
	 * of 3 stops.  In the sample data below, there are two such trips: 
	 * C-D-C (2 stops). and C-E-B-C (3 stops).
	 */
	@Test
	public void testNumStops_CC3() throws Exception {
		int numStops = graph.numStops(c, c, 3);
		assertEquals(2, numStops);
	}
 
	/*
	 * 7. The number of trips starting at A and ending at C with exactly 4 
	 * stops.  In the sample data below, there are three such trips: A to 
	 * C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
	 */
	@Test
	public void testNumStops_AC4() throws Exception {
		int numStops = graph.numStops(a, c, 4);
		assertEquals(4, numStops);
	}
 
	/*
	 * 8. The length of the shortest route (in terms of distance to travel) 
	 * from A to C.
	 */
	@Test
	public void testShortestRoute_AC() throws Exception {
		int shortestRoute = graph.shortestRoute(a, c);
		assertEquals(9, shortestRoute);
	}
 
	//9. The length of the shortest route (in terms of distance to travel) from B to B.
	@Test
	public void testShortestRoute_BB() throws Exception {
		int shortestRoute = graph.shortestRoute(b, b);
		assertEquals(9, shortestRoute);
	}
 
	/*
	 * 10.The number of different routes from C to C with a distance of less 
	 * than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, 
	 * CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
	 */
	@Test
	public void numRoutesWithin_CC30() throws Exception {
		int numRoutesWithin = graph.numRoutesWithin(c, c, 30);
		assertEquals(7, numRoutesWithin);
	}
 
	@Test
	public void testEquals() {
		Node a1 = new Node("A");
		Node a2 = new Node("A");
		Node b = new Node("B");
 
		assertEquals(true, a1.equals(a2));
		assertEquals(false, a1.equals(b));
		assertEquals(true, (new Node("Test").equals(new Node("Test"))));
	}
}