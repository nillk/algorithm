package backjoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q2152_TravelPlanning {
    static int[][] CITY;
    static HashMap<Integer, HashSet<Integer>> AIRLINE = new HashMap<Integer, HashSet<Integer>>();
    static int INDEX = 1;

    static Stack<Integer> stack = new Stack<Integer>();

    static Map<Integer, CitySet> scc = new HashMap<Integer, CitySet>();
    static Map<Integer, Integer> sccRootNode = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cities = scan.nextInt();
        int airlines = scan.nextInt();
        int departure = scan.nextInt();
        int arrival = scan.nextInt();

        CITY = new int[cities + 1][2];
        for (int i = 0; i < cities; i++) {
            AIRLINE.put(i + 1, new HashSet<Integer>());
        }
        for (int i = 0; i < airlines; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            AIRLINE.get(from).add(to);
        }

        for (int i = 1; i <= cities; i++) {
            if (CITY[i][0] == 0) {
                strongConnect(i);
            }
        }

        Integer sccDeparture = sccRootNode.get(departure);
        Integer sccArrival = sccRootNode.get(arrival);

        HashMap<Integer, HashSet<Integer>> sccAdj = new HashMap<Integer, HashSet<Integer>>();
        for (Map.Entry<Integer, CitySet> entry : scc.entrySet()) {
            HashSet<Integer> adj = new HashSet<Integer>();
            for (Integer outgoing : entry.getValue().getOutgoingCities()) {
                adj.add(sccRootNode.get(outgoing));
            }
            sccAdj.put(entry.getKey(), adj);
        }

        System.out.println(BFS(sccDeparture, sccArrival, sccAdj));
    }

    private static void strongConnect(int city) {
        CITY[city][0] = INDEX;
        CITY[city][1] = INDEX;
        INDEX++;

        stack.push(city);

        Iterator<Integer> iterator = AIRLINE.get(city).iterator();
        while (iterator.hasNext()) {
            Integer nextCity = iterator.next();
            if (CITY[nextCity][0] == 0) {
                strongConnect(nextCity);
                CITY[city][1] = Math.min(CITY[city][1], CITY[nextCity][1]);
            } else if (stack.contains(nextCity)) {
                CITY[city][1] = Math.min(CITY[city][1], CITY[nextCity][0]);
            }
        }

        if (CITY[city][0] == CITY[city][1]) {
            CitySet set = new CitySet();
            int w = -1;
            while (city != w) {
                w = stack.pop();
                set.addCity(w, AIRLINE.get(w));
                sccRootNode.put(w, city);
            }
            scc.put(city, set);
        }
    }

    private static int BFS(int startV, int endV, HashMap<Integer, HashSet<Integer>> sccAdj) {
        HashMap<Integer, Integer> visiteCount = new HashMap<Integer, Integer>();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startV);
        visiteCount.put(startV, scc.get(startV).size());

        while (!queue.isEmpty()) {
            startV = queue.poll();

            for (Iterator<Integer> iter = sccAdj.get(startV).iterator(); iter.hasNext();) {
                Integer i = iter.next();
                queue.add(i);

                int cityCount = visiteCount.get(startV) + scc.get(i).size();
                if (visiteCount.containsKey(i)) {
                    if (visiteCount.get(i) < cityCount) {
                        visiteCount.put(i, cityCount);
                    }
                } else {
                    visiteCount.put(i, cityCount);
                }
            }
        }

        if (visiteCount.containsKey(endV)) {
            return visiteCount.get(endV);
        } else {
            return 0;
        }
    }
}

class CitySet {
    HashSet<Integer> cities = new HashSet<Integer>();
    HashSet<Integer> outgoing = new HashSet<Integer>();

    void addCity(int city, HashSet<Integer> outgoing) {
        cities.add(city);
        if (outgoing != null) {
            this.outgoing.addAll(outgoing);
        }
    }

    int size() {
        return cities.size();
    }

    boolean contains(int city) {
        return cities.contains(city);
    }

    HashSet<Integer> getOutgoingCities() {
        for (Iterator<Integer> i = cities.iterator(); i.hasNext();) {
            outgoing.remove(i.next());
        }
        return outgoing;
    }
}