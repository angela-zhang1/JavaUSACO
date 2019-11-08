import java.io.*;
import java.util.*;

//how to hack int usaco??

public class wormhole {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int x = 0; int y = 0;
		state[] a2 = new state[n];
		int[]b = new int[n];
		Arrays.fill(b, 13);
		state z;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = new state(x, y);
			a2[i] = z;
		}
		Arrays.sort(a2);
		int curr = 0; int curr2 = 0; int rep = 0;
		for (int i = 0; i < n; i++) {
			if (a2[i].y == a2[curr2].y) {
				rep++;
			}
			else {
				b[curr] = rep;
				curr++;
				curr2 = i+1;
			}
		}
		Arrays.sort(b);
		for (int i : b) {
			
		}
	}
	static class state implements Comparable<state> {
		public int x, y;
		public state (int xpos, int ypos) {
			x = xpos;
			y = ypos;
		}
		public int compareTo(state o) {
			if (y < o.y)
				return -1;
			else if (y>o.y)
				return 1;
			return 0;
		}
	}
}
