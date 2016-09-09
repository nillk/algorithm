import java.util.Scanner;

public class Q10828_Stack {

	private static final int MAX_CAPACITY = 10005;
	private static int[] stack = new int[MAX_CAPACITY];
	private static int stack_index = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while (n-- > 0) {
			String command = scan.next();
			switch (command) {
			case "push":
				int x = scan.nextInt();
				stack[stack_index++] = x;
				break;
			case "pop":
				if (stack_index > 0) {
					stack_index--;
					System.out.println(stack[stack_index]);
					stack[stack_index] = 0;
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(stack_index);
				break;
			case "empty":
				if (stack_index > 0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
				break;
			case "top":
				if (stack_index > 0) {
					System.out.println(stack[stack_index - 1]);
				} else {
					System.out.println(-1);
				}
				break;
			default:
				break;
			}
		}

		scan.close();
	}
}
