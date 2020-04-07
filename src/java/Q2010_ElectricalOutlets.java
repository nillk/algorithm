import java.util.Scanner;

public class Q2010_ElectricalOutlets {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		long availablePlug = 1;
		for (int i = 0; i < n; i++) {
			availablePlug--;
			availablePlug += scan.nextInt();
		}

		System.out.println(availablePlug);
		scan.close();
	}
}
