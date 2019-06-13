import java.util.Scanner;

public class Q9498_ExamScore {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		byte score = reader.nextByte();
		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		reader.close();
	}
}
