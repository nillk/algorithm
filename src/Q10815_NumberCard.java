import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
 
public class Q10815_NumberCard {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
 
        Set<Integer> cards = new HashSet<Integer>();
 
        int N = Integer.parseInt(reader.readLine());
        String[] c = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(c[i]));
        }
         
        int M = Integer.parseInt(reader.readLine());
        String[] m = reader.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            result.append(cards.contains(Integer.parseInt(m[i])) ? 1 : 0).append(" ");
        }
         
        System.out.println(result.toString());
    }
}