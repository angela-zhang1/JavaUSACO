import java.io.*;
import java.util.*;

/*
5 3 4
6
2
4
7
1
10 25
2 10
15 15
250
80
100
40
ans:
725
*/

public class rental {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new FileWriter("rental.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue <Integer> c = new PriorityQueue<Integer> (); //cow milk production
		PriorityQueue <Integer> f = new PriorityQueue<Integer> (Collections.reverseOrder()); //farmer prices
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		state[]s = new state[m]; //store prices and stuff
		int x = 0; int y = 0; int t = 0;
		for (int i = 0; i < n; i++) { //cow milk
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			c.add(x);
			t+=x;
		}
		for (int i = 0; i < m; i++) { //store prices
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			s[i] = new state(x,y);
		}
		Arrays.sort(s);
		for (int i = 0; i < r; i++) { //farmer rental
			x = Integer.parseInt(br.readLine());
			f.add(x);
		}
		br.close();
		int ret = 0;
		for (int i = 0; i < n; i++) {
			x = c.poll(); //minimum cow milk offered
			y = f.poll(); //maximum farmer price offered
			
		}
	}
	static class state implements Comparable<state>{
		int g, p; //g = gallons accepted, p = price
		public state (int gall, int price) { 
			g = gall;
			p = price;
		}
		public int compareTo(state o) {
			if (o.p > this.p) {
				return 1;
			}
			else if (o.p < this.p) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}
