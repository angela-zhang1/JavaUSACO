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
		int v,w = 0;
		int x = 0; int y = 0; int t = 0;
		long[] a = new long[m];
		int scount = 0; long smilk = 0; int currstore = 0;
		for (int i = 0; i < n; i++) { //cow milk
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			c.add(x);
			t+=x;
		}
		for (int i = 0; i < m; i++) { //store prices
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); //gallons
			y = Integer.parseInt(st.nextToken()); //price
			s[i] = new state(x,y);
		}
		Arrays.sort(s);
		for (int i = 0; i < r; i++) { //farmer rental
			x = Integer.parseInt(br.readLine());
			f.add(x);
		}
		br.close();
		for (int i = 0; i < m; i++) { //if you sell things to farmers only
			x = s[i].g; //gallons
			y = s[i].p; //price
			
			if (t-(x+scount) > 0) {
				smilk+=x*y;
				currstore++;
			}
			else if (t-scount>0) {
				smilk+= (t-scount)*y;
				currstore++;
			}
			scount+=x;
			a[i] = scount;
			System.out.println(a[i]);
		}
		long ret = 0;
		System.out.println(currstore);
		System.out.println(smilk);
		
		for (int i = 0; i < n; i++) {
			x = c.poll(); //minimum cow milk offered
			y = f.poll(); //maximum farmer price offered
			v = currstore-2;
			w = 0;
			while (t-v < x) {
				
			}
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

