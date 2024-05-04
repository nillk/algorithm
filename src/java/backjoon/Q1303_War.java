package backjoon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
 
public class Q1303_War {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte n = scan.nextByte();
        byte m = scan.nextByte();
 
        Set<Integer> whiteField = new HashSet<Integer>();
        Set<Integer> blueField = new HashSet<Integer>();
        int count = 1;
        for (byte row = 0; row < m; row++) {
            char[] charArray = scan.next().toCharArray();
            for (byte col = 0; col < n; col++) {
                if (charArray[col] == 'W') {
                    whiteField.add(count++);
                } else {
                    blueField.add(count++);
                }
            }
        }
 
        System.out.printf("%d %d", getEnergy(n, whiteField), getEnergy(n, blueField));
    }
 
    private static int getEnergy(byte n, Set<Integer> field) {
        Queue<Integer> newAddedSoldier = new LinkedList<Integer>();
        int energy = 0;
        while (!field.isEmpty()) {
            int size = 0;
            Integer soldier = field.iterator().next();
            size += checkNearby(field, newAddedSoldier, soldier);
            while (!newAddedSoldier.isEmpty()) {
                soldier = newAddedSoldier.poll();
                size += moveNearbySoldier(field, newAddedSoldier, soldier, n);
            }
 
            energy += size * size;
        }
        return energy;
    }
 
    private static int moveNearbySoldier(Set<Integer> field, Queue<Integer> newAddedSoldier, Integer soldier, byte n) {
        /** +n, -n, +1, -1*/
        int size = 0;
        size += checkNearby(field, newAddedSoldier, soldier + n);
        size += checkNearby(field, newAddedSoldier, soldier - n);
        if (soldier % n != 0) {
            size += checkNearby(field, newAddedSoldier, soldier + 1);
        }
        if (soldier % n != 1) {
            size += checkNearby(field, newAddedSoldier, soldier - 1);
        }
 
        return size;
    }
 
    private static int checkNearby(Set<Integer> field, Queue<Integer> newAddedSoldier, Integer nearby) {
        if (field.contains(nearby)) {
            field.remove(nearby);
            newAddedSoldier.add(nearby);
            return 1;
        }
 
        return 0;
    }
}