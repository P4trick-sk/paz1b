package sk.upjs.sk;

import java.util.*;

public class Dijkstra {
    public static Map<Integer, Double> dijkstra(double[][] graph, int start){
        Map<Integer, Double> vzdialenosti = new HashMap<>();
        Set<Integer> vrcholy = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            vzdialenosti.put(i, Double.POSITIVE_INFINITY);
            vrcholy.add(i);
        }

        vzdialenosti.put(start, 0.0);

        while(!vzdialenosti.isEmpty()) {
            int v = najdiNajmensiNenavstiveny(vzdialenosti, vrcholy);

            // Keď dostaneme -1, tak vieme, že už sa nemôžeme dostať na žiadnych susedov, takže môžeme skončiť
            if (v == -1)
                break;

            for (int i = 0; i < graph.length; i++) {
                if (graph[v][i] > 0) {
                    if (vzdialenosti.get(v) + graph[v][i] < vzdialenosti.get(i)) {
                        vzdialenosti.put(i, vzdialenosti.get(v) + graph[v][i]);
                    }
                }
            }

            vrcholy.remove(v);
        }

        for (int target = 0; target < graph.length; target++) {
            if (start == target) continue;
            List<Integer> cesta = najdiCestu(graph, vzdialenosti, start, target)
            System.out.println(start + " -> " + target + ": " + cesta + ", " + vzdialenosti.get(target));
        }

        return vzdialenosti;
    }

    private static List<Integer> najdiCestu(double[][] graph, Map<Integer, Double> vzdialenosti, int start, int target) {
        List<Integer> cesta = new LinkedList<>();
        double aktualnaHodnota = vzdialenosti.get(target);
        //TODO: dokončiť hľadanie cez spatný chod

        return cesta;
    }


    private static int najdiNajmensiNenavstiveny(Map<Integer, Double> vzdialenosti, Set<Integer> vrcholy) {
        double najmensiaVzdielenost = Double.POSITIVE_INFINITY;
        int najmensiVrchol = -1;

        for (int vrchol : vrcholy) {
            if (vzdialenosti.get(vrchol) < najmensiaVzdielenost) {
                najmensiVrchol = vrchol;
                najmensiaVzdielenost = vzdialenosti.get(vrchol);
            }
        }

        return najmensiVrchol;
    }

    public static void main(String[] args) {
        double[][] graph = {
                {-1,  4,  2, -1, -1},
                {-1, -1,  3,  2,  3},
                {-1,  1, -1,  4, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1,  1, -1},
        };

        System.out.println(dijkstra(graph, 2));
    }
}
