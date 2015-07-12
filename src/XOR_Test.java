import org.junit.Test;

public class XOR_Test {

    @Test
    public void text() {
        int prev = 1;
        for (byte i = 2; i < 20; i++) {
            prev ^= i;
            System.out.println(prev);
        }
    }
}
