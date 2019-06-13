import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q8595_HiddenNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		Pattern pattern = Pattern.compile("([0-9]+)");
		Matcher matcher = pattern.matcher(str);

		long result = 0;
		while (matcher.find()) {
			result += Integer.parseInt(matcher.group());
		}

		System.out.println(result);
		scan.close();
	}
}
