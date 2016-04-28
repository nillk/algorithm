import java.util.Scanner;
 
public class Q1076_Resistance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Resistance res1 = Resistance.of(scan.next());
        Resistance res2 = Resistance.of(scan.next());
        Resistance res3 = Resistance.of(scan.next());
 
        System.out.println((long) ((res1.ordinal() * 10 + res2.ordinal()) * Math.pow(10, res3.ordinal())));
 
        scan.close();
    }
 
    enum Resistance {
        BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GREY, WHITE;
 
        public static Resistance of(String name) {
            for (Resistance res : values()) {
                if (res.name().equalsIgnoreCase(name)) return res;
            }
 
            return null;
        }
    }
}