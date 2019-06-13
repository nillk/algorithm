import java.util.Scanner;
 
public class Q1924_2007 {
    static byte[] dayCount = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] dayOfWeek = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
     
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte month = scan.nextByte();
        byte day = scan.nextByte();
         
        short days = 0;
        for (byte i = 1; i < month; i++) {
            days += dayCount[i];
        }
        days += day;
         
        System.out.println(dayOfWeek[days % 7]);
 
        scan.close();
    }
}