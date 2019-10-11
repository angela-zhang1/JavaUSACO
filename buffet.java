import java.io.*;
import java.util.*;

/*
5 2
4 1 2
1 3 1 3 4
6 2 2 5
5 2 2 5
2 2 3 4
ans:
7
*/

public class buffet {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("buffet.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buffet.out")));
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		PriorityQueue <state> pq = new PriorityQueue<state> ();
		int x; int y; int z; int w = 0;
		int[][]a = new int[n][n]; //connections
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			pq.offer(new state(i,x));
			for (int j = 0; j < y; j++) {
				z = Integer.parseInt(st.nextToken());
				a[i][z-1] = 1;
				a[z-1][i] = 1;
			}
		}
		
		br.close();
		int ret = 0;
		while (!pq.isEmpty()) {
			
		}
	}
	static class state implements Comparable<state> {
		int p, t;
		public state (int pos, int tas) {
			p = pos;
			t = tas;
		}
		public int compareTo (state o) {
			if (t < o.t)
				return -1;
			else if (t > o.t)
				return 1;
			return 0;
		}
	}
}
