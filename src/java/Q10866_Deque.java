import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q10866_Deque {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Deque dq = new Deque();

		scan.nextLine();
		while (N-- > 0) {
			String command = scan.nextLine();
			String[] comm = command.split(" ");
			if (comm.length > 1) {
				Deque.class.getMethod(comm[0], int.class).invoke(dq,
						Integer.parseInt(comm[1]));
			} else {
				Object invoke = Deque.class.getMethod(comm[0]).invoke(dq);
				System.out.println(invoke);
			}
		}

		scan.close();
	}
}

class Deque {
	List<Integer> deque = new ArrayList<Integer>();

	public void push_front(int x) {
		deque.add(0, x);
	}

	public void push_back(int x) {
		deque.add(x);
	}

	public int pop_front() {
		if (deque.isEmpty()) {
			return -1;
		}
		return deque.remove(0);
	}

	public int pop_back() {
		if (deque.isEmpty()) {
			return -1;
		}
		return deque.remove(size() - 1);
	}

	public int size() {
		return deque.size();
	}

	public int empty() {
		return deque.isEmpty() ? 1 : 0;
	}

	public int front() {
		if (deque.isEmpty()) {
			return -1;
		}
		return deque.get(0);
	}

	public int back() {
		if (deque.isEmpty()) {
			return -1;
		}
		return deque.get(size() - 1);
	}
}