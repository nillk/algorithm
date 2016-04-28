import java.util.Arrays;
import java.util.Scanner;
 
public class Q1251_WordSplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        char[] word = scan.next().toCharArray();
 
        int wordLength = word.length;
         
        char[] tmp = new char[wordLength];
        char[] min = new char[wordLength];
        min[0] = word[0];
        min[1] = word[1];
        for (int i = 2, index = 1; i < wordLength; i++, index++) {
            min[i] = word[wordLength - index];
        }
         
        for (int i = 0; i < wordLength - 2; i++) {
            for (int j = i + 1; j < wordLength - 1; j++) {
                for (int first = 0; first <= i; first++) {
                    tmp[first] = word[i - first];
                }
                for (int second = i + 1, index = 0; second <= j; second++, index++) {
                    tmp[second] = word[j - index];
                }
                for (int third = j + 1, index = 1; third < wordLength; third++, index++) {
                    tmp[third] = word[wordLength - index];
                }
                 
                if (isPreOrder(tmp, min)) {
                    min = Arrays.copyOf(tmp, wordLength);
                }
            }
        }
         
        for (int i = 0; i < min.length; i++) {
            System.out.print(min[i]);
        }
         
        scan.close();
    }
     
    private static boolean isPreOrder(char[] tmp, char[] min) {
        for (int i = 0; i < tmp.length; i++) {
            if (min[i] > tmp[i]) {
                return true;
            } else if (min[i] < tmp[i]) {
                return false;
            } else if (min[i] == tmp[i]) {
                continue;
            } 
        }
        return false;
    }
}
