package sk.upjs.sk;

import sk.upjs.paz.graph.Edge;
import sk.upjs.paz.graph.Graph;
import sk.upjs.paz.graph.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NajCesty {

    public void relax(Edge e, Map<Vertex, Double> d, Map<Vertex, Vertex> p) {
        Vertex u = e.getSource();
        Vertex v = e.getTarget();
        if (d.get(u) + e.getWeight() < d.get(v)) {
            d.put(v, d.get(u) + e.getWeight());
            p.put(v, u);
        }
    }

    /*public void relax2(Edge e, Map<Vertex, Double> d, Map<Vertex, Vertex> p) {
        Vertex v = e.getSource();
        Vertex u = e.getTarget();
        if (d.get(u) + e.getWeight() < d.get(v)) {
            d.put(v, d.get(u) + e.getWeight());
            p.put(v, u);
        }
    }*/

    public Map<Vertex, Double> bellmanFord(Graph g, Vertex s) {
        Map<Vertex, Double> d =
                g.createVertexMap(Double.POSITIVE_INFINITY);
        Map<Vertex, Vertex> p = g.createVertexMap(null);

        d.put(s, 0d);

        for (int i = 0; i < g.getVertices().size(); i++)
            for (Edge e : g.getEdges()) {
                relax(e, d, p);
                //relax2(e, d, p);
            }

        for (Vertex v : g.getVertices()){
            if (s == v) continue;
            System.out.println(s + " -> " + v + ": " + najdiCestu(s, v, p) + ", " + d.get(v));
        }
        return d;
    }

    public List<Vertex> najdiCestu(Vertex start, Vertex ciel, Map<Vertex, Vertex> predchodcovia) {
        List<Vertex> cesta = new LinkedList<>();
        Vertex aktualny = ciel;

        // Predchodcovia mi vráti pre zadaní vertex jeho predchodcu, z ktorého som sa na daný bod dostal
        while (aktualny != start) {
            cesta.add(0, aktualny);
            aktualny = predchodcovia.get(aktualny);
        }

        cesta.add(0, start);

        return cesta;
    }

    public static void main(String[] args) {
        Graph g = Graph.createFromFile("grafPrednaska.txt");
        g.setDirected(true);
        NajCesty nc = new NajCesty();
        System.out.println(nc.bellmanFord(g, g.getVertex("F")));
    }
}
