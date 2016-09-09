import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11650_SortCoord {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		Coord[] coords = new Coord[N];
		for (int i = 0; i < N; i++) {
			String[] coord = reader.readLine().split(" ");
			coords[i] = new Coord(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
		}

		Arrays.sort(coords);
		for (int i = 0; i < N; i++) {
			System.out.println(coords[i]);
		}
	}
}

class Coord implements Comparable<Coord> {
	int x;
	int y;

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Coord o) {
		if (this.x - o.x == 0) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}

	@Override
	public String toString() {
		return String.format("%d %d", this.x, this.y);
	}
}