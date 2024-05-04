package backjoon;

import java.util.Scanner;
 
public class Q1916_MinimumCost {
    private static final long INFINITE = Integer.MAX_VALUE;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int cities = scan.nextInt();
        int buses = scan.nextInt();
 
        long[][] costMatrix = new long[cities][cities];
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < cities; j++) {
                costMatrix[i][j] = INFINITE;
            }
 
            costMatrix[i][i] = 0;
        }
 
        for (int i = 0; i < buses; i++) {
            short from = scan.nextShort();
            short to = scan.nextShort();
            int cost = scan.nextInt();
 
            if (costMatrix[from - 1][to - 1] > cost) {
                costMatrix[from - 1][to - 1] = cost;
            }
        }
 
        short departureCity = (short) (scan.nextShort() - 1);
        short destinyCity = (short) (scan.nextShort() - 1);
 
        boolean[] visited = new boolean[cities];
        visited[departureCity] = true;
 
        for (short j = 0; j < cities; j++) {
            short currentCity = findMinimumCostCity(costMatrix, visited, departureCity);
 
            for (short i = 0; i < cities; i++) {
                if (!visited[i]) {
                    if (costMatrix[currentCity][i] < INFINITE
                            && costMatrix[departureCity][currentCity] + costMatrix[currentCity][i] < costMatrix[departureCity][i]) {
                        costMatrix[departureCity][i] = costMatrix[departureCity][currentCity] + costMatrix[currentCity][i];
                    }
                }
            }
 
            visited[currentCity] = true;
        }
 
        System.out.println(costMatrix[departureCity][destinyCity]);
    }
 
    private static short findMinimumCostCity(long[][] cost, boolean[] visited, short departure) {
        long min = INFINITE;
        short minIndex = departure;
        for (short i = 0; i < cost[departure].length; i++) {
            if (cost[departure][i] < min && !visited[i]) {
                min = cost[departure][i];
                minIndex = i;
            }
        }
 
        return minIndex;
    }
}