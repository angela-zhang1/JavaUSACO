import java.io.*;
import java.util.*;

/*
5
1
5
3
8
2
ans:
4
*/

public class sort {
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new FileWriter("sort.out"));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<state> pq = new PriorityQueue<state> ();
		int ret = 0; int x = 0;
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());
			pq.add(new state(x,i));
		}
		br.close();
		for (int i = 0; i < n; i++) {
			x = pq.poll().p;
			if (x > n-1-i) {
				ret = x-(n+i - 2);
			}
		}
		System.out.println(ret);
		//pw.close();
	}
	static class state implements Comparable<state> {
		int v,p;
		public state(int value, int position) {
			v = value;
			p = position;
		}
		public int compareTo(state o) {
			if (o.v > this.v) {
				return 1;
			}
			else if (o.v < this.v) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}
