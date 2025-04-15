package sk.upjs.sk;

import sk.upjs.paz.graph.Edge;
import sk.upjs.paz.graph.Graph;
import sk.upjs.paz.graph.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NajKostra {
    public static Set<Edge> prime(Graph g, Vertex s) {
        Set<Edge> kostra = new HashSet<>();
        Set<Vertex> q = new HashSet<>(g.getVertices());
        Map<Vertex, Vertex> predchodca = g.createVertexMap(null);
        Map<Vertex, Double> vzdialenosti = g.createVertexMap(Double.POSITIVE_INFINITY);
        vzdialenosti.put(s, 0.0);

        Vertex vyber = s;

        while (!q.isEmpty()) {
            for (Vertex sused : vyber.getNeighbours()) {
                Edge hrana = g.getEdge(sused, vyber);

                if (q.contains(sused) && hrana.getWeight() < vzdialenosti.get(sused)) {
                    predchodca.put(sused, vyber);
                    vzdialenosti.put(sused, hrana.getWeight());
                }
            }

            double min = Double.POSITIVE_INFINITY;
            for (Vertex vrchol : q) {
                if (vzdialenosti.get(vrchol) < min) {
                    min = vzdialenosti.get(vrchol);
                    vyber = vrchol;
                }
            }

            q.remove(vyber);
        }

        for (Vertex vrchol : predchodca.keySet()) {
            if (predchodca.get(vrchol) != null) {
                kostra.add(g.getEdge(predchodca.get(vrchol), vrchol));
            }
        }

        return kostra;
    }

    public static void main(String[] args) {
        Graph g = Graph.createFromFile("grafititititititititititititititititi.txt");
        //System.out.println(prime(g, ));
    }
}
