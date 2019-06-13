import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1991_BinaryTreeTraversal {
    private static final byte NONE = -99;
    private static final byte LEFT = -1;
    private static final byte RIGHT = 1;

    private static byte N;
    private static Queue<Byte> q = new LinkedList<Byte>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextByte();
        byte[][] matrix = new byte[26][26];

        scan.nextLine();
        for (byte i = 0; i < N; i++) {
            char[] nodes = scan.nextLine().toCharArray();
            int parent = nodes[0] - 'A';
            int left = nodes[2] - 'A';
            int right = nodes[4] - 'A';

            if (left >= 0) {
                matrix[parent][left] = LEFT;
            }
            if (right >= 0) {
                matrix[parent][right] = RIGHT;
            }
        }

        preorder(matrix, (byte) 0);
        printQueue();
        inorder(matrix, (byte) 0);
        printQueue();
        postorder(matrix, (byte) 0);
        printQueue();

        scan.close();
    }

    private static void preorder(byte[][] matrix, byte current) {
        if (q.size() == N) return;
        if (current == NONE) return;
        if (q.contains(current)) return;

        q.add(current);

        byte leftIndex = getNextNodeIndex(matrix, current, LEFT);
        byte rightIndex = getNextNodeIndex(matrix, current, RIGHT);

        if (leftIndex != NONE) {
            preorder(matrix, leftIndex);
        }
        if (rightIndex != NONE) {
            preorder(matrix, rightIndex);
        }

        return;
    }

    private static void inorder(byte[][] matrix, byte current) {
        if (q.size() == N) return;
        if (current == NONE) return;
        if (q.contains(current)) return;

        byte leftIndex = getNextNodeIndex(matrix, current, LEFT);
        byte rightIndex = getNextNodeIndex(matrix, current, RIGHT);

        if (leftIndex != NONE) {
            inorder(matrix, leftIndex);
        }

        q.add(current);

        if (rightIndex != NONE) {
            inorder(matrix, rightIndex);
        }

        return;
    }

    private static void postorder(byte[][] matrix, byte current) {
        if (q.size() == N) return;
        if (current == NONE) return;
        if (q.contains(current)) return;

        byte leftIndex = getNextNodeIndex(matrix, current, LEFT);
        byte rightIndex = getNextNodeIndex(matrix, current, RIGHT);

        if (leftIndex != NONE) {
            postorder(matrix, leftIndex);
        }
        if (rightIndex != NONE) {
            postorder(matrix, rightIndex);
        }

        q.add(current);

        return;
    }

    private static byte getNextNodeIndex(byte[][] matrix, byte current, byte position) {
        for (byte i = 0; i < matrix[current].length; i++) {
            if (matrix[current][i] == position) return i;
        }

        return NONE;
    }

    private static void printQueue() {
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Byte poll = q.poll();
            sb.append((char)(poll + 'A'));
        }

        System.out.println(sb.toString());
    }
}
