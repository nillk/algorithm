package backjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Q2355_Sigma {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();

		if (i > j) {
			int tmp = i;
			i = j;
			j = tmp;
		}
		BigInteger count = bigInt(j).subtract(bigInt(i)).add(bigInt(1));
		BigInteger add = bigInt(i).add(bigInt(j));
		if ((count.remainder(bigInt(2))).equals(bigInt(0))) {
			System.out.println(add.multiply(count.divide(bigInt(2))));
		} else {
			System.out.println(add.multiply(count.divide(bigInt(2))).add(add.divide(bigInt(2))));
		}

		scan.close();
	}

	private static BigInteger bigInt(int i) {
		return new BigInteger(String.valueOf(i));
	}
}
