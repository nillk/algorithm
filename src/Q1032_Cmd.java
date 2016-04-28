import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Q1032_Cmd {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte N = Byte.parseByte(reader.readLine());
        char[] fileName = reader.readLine().toCharArray();
        int fileNameLength = fileName.length;
 
        while (N-- > 1) {
            char[] tmpFileName = reader.readLine().toCharArray();
            for (byte i = 0; i < fileNameLength; i++) {
                if (fileName[i] == '?') continue;
                if (fileName[i] == tmpFileName[i]) continue;
                if (fileName[i] != tmpFileName[i]) {
                    fileName[i] = '?';
                }
            }
        }
 
        for (byte i = 0; i < fileNameLength; i++) {
            System.out.print(fileName[i]);
        }
    }
}