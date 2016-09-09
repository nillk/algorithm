import java.util.Scanner;

public class Q10845_Queue {
	private static int[] QUEUE = new int[10010];
	private static int REAR = 0;
	private static int FRONT = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		while (N-- > 0) {
			String command = scan.next();
			switch (command) {
			case "push":
				int x = scan.nextInt();
				QUEUE[FRONT++] = x;
				break;
			case "pop":
				if (REAR >= FRONT) {
					System.out.println(-1);
				} else {
					System.out.println(QUEUE[REAR++]);
				}
				break;
			case "size":
				System.out.println(FRONT - REAR);
				break;
			case "empty":
				System.out.println(FRONT - REAR == 0 ? 1 : 0);
				break;
			case "front":
				if (REAR >= FRONT) {
					System.out.println(-1);
				} else {
					System.out.println(QUEUE[REAR]);
				}
				break;
			case "back":
				if (REAR >= FRONT) {
					System.out.println(-1);
				} else {
					System.out.println(QUEUE[FRONT - 1]);
				}
				break;
			}
		}

		scan.close();
	}
}
