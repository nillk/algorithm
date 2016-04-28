import java.util.Scanner;
 
public class Q1747_PrimeAndPalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
     
        while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                System.out.println(n);
                break;
            }
            n++;
        }
         
        scan.close();
    }
     
    private static boolean isPrime(int i) {
        if (i % 2 == 0) return false;
        for (int index = 3; index <= Math.sqrt(i); index += 2) {
            if (i % index == 0) return false;
        }
        return true;
    }
     
    private static boolean isPalindrome(int i) {
        String str = String.valueOf(i);
        int length = str.length();
        for (int index = 0; index < length / 2; index++) {
            if (str.charAt(index) != str.charAt(length - index - 1)) {
                return false;
            }
        }
         
        return true;
    }
}