import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q10866_Deque {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();

    int N = Integer.parseInt(reader.readLine());
    List<Integer> deque = new ArrayList<>(N);

    while (N-- > 0) {
      String command = reader.readLine();
      String[] comm = command.split(" ");

      switch (comm[0]) {
        case "push_front":
          deque.add(0, Integer.parseInt(comm[1]));
          break;
        case "push_back":
          deque.add(Integer.parseInt(comm[1]));
          break;
        case "pop_front":
          if (deque.isEmpty()) {
            result.append(-1).append("\n");
          } else {
            result.append(deque.remove(0)).append("\n");
          }
          break;
        case "pop_back":
          if (deque.isEmpty()) {
            result.append(-1).append("\n");
          } else {
            result.append(deque.remove(deque.size() - 1)).append("\n");
          }
          break;
        case "size":
          result.append(deque.size()).append("\n");
          break;
        case "empty":
          result.append(deque.isEmpty() ? "1" : "0").append("\n");
          break;
        case "front":
          result.append(deque.isEmpty() ? "-1" : deque.get(0)).append("\n");
          break;
        case "back":
          result.append(deque.isEmpty() ? "-1" : deque.get(deque.size() - 1)).append("\n");
          break;
      }
    }

    System.out.println(result.toString());

    reader.close();
  }
}
