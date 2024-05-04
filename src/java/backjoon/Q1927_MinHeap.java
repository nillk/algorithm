package backjoon;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1927_MinHeap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<Integer> queue = new PriorityQueue<Integer>();

        int test = scan.nextInt();
        while (test-- > 0) {
            int num = scan.nextInt();
            if (num == 0) {
                if (queue.size() == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else if (num > 0) {
                queue.add(num);
            }
        }
    }
}
