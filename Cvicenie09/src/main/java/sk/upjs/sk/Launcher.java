package sk.upjs.sk;

import sk.upjs.jpaz2.*;
import sk.upjs.paz.graph.Edge;
import sk.upjs.paz.graph.Graph;

import java.util.Arrays;
import java.util.Set;

public class Launcher {

	public static void main(String[] args) {
		Graph gSubor = Graph.createFromFile("graf.txt", true);
		System.out.println(gSubor);
		Set<Edge> edges = gSubor.getEdges();
		for (Edge e : edges) {
			System.out.print(e.getSource() + " ");
			System.out.print(e.getTarget() + " ");
			System.out.println(e.getWeight());
		}

		Graph gRucne = new Graph();
		gRucne.addVertex("KE");
		gRucne.addVertex("PO");
		gRucne.addVertex("PP");
		gRucne.addVertex("LM");
		gRucne.addEdge(gRucne.getVertex("KE"), gRucne.getVertex("PO"));
		gRucne.addEdge(gRucne.getVertex("PO"), gRucne.getVertex("PP"));
		gRucne.addEdge(gRucne.getVertex("PP"), gRucne.getVertex("LM"));
		System.out.println(gRucne);
		gRucne.getEdge(gRucne.getVertex("PP"), gRucne.getVertex("LM")).setWeight(15);
		gRucne.setDirected(true);

		String[] vrcholy = {"KE", "PO", "PP", "LM"};
		boolean[][] maticaSusednosti = {
				{false, true, false, false},
				{true, false, true, false},
				{false, true, false, true},
				{false, false, true, false}
		};
		System.out.println("Vertices: " + Arrays.toString(vrcholy));
		System.out.println("Matrix: " + Arrays.deepToString(maticaSusednosti));

		double[][] maticaSusednostiOhodnotena = {
				{Double.POSITIVE_INFINITY, 30, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
				{30, Double.POSITIVE_INFINITY, 50, Double.POSITIVE_INFINITY},
				{Double.POSITIVE_INFINITY, 50, Double.POSITIVE_INFINITY, 45},
				{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 45, Double.POSITIVE_INFINITY}
		};
	}
}
