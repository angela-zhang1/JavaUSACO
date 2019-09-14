import java.io.*;
import java.util.*;

/*
8 7
0 3 8 5 6 9 0 0
0 5
0 6
6 2
8 1
10 1
5 3
150 7
ans:
0
1
1
0
1
1
1 
*/

//I haven't even passed silver and somehow I got four test cases...
public class snowboots {
	public static void main (String[]args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new FileWriter("snowboots.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x, y, z = 0;
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		state[] t = new state[n]; //store tiles
		int[][]bc = new int[b][2]; //store boot depth and step
		boolean[] ret = new boolean[b]; //store whether or not can do
		Arrays.fill(ret, true);
		int[]a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			state s = new state(Integer.parseInt(st.nextToken()), i);
			t[i] = s;
		}
		Arrays.sort(t);
		
		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); 
			y = Integer.parseInt(st.nextToken()); 
			bc[i][0] = x;
			bc[i][1] = y;
		}
		for (int i = 0; i < b; i++) {
			x = bc[i][0]; //maximum snow depth
			y = bc[i][1]; //step
			Arrays.fill(a, 100001);
			for (int j = 0; j < t.length; j++) {
				if (t[j].s <= x) {
					break;
				}
				a[j] = t[j].p;
			}
			int l = 0;
			Arrays.sort(a);
			if (a[0]!=100001 && a[1] == 100001) {
				z=1;
			}
			while (a[l]!=100001 && a[l+1] !=100001) {
				if (a[l+1] - a[l] ==1) {
					z++;
				}
				else {
					if (z+2> y && z!=0) {
						ret[i] = false;
						break;
					}
					z= 0;
				}
				l++;
			}
			Arrays.fill(a, 100001);
			if (z+2>y &&z!=0) {
				ret[i] = false;
			}
			z=0;
		}
		for (int i = 0; i < b; i++) {
			if (ret[i]) {
				pw.println(1);
			}
			else {
				pw.println(0);
			}
		}
		pw.close();
	}
	static class state implements Comparable<state>{
		int s, p; //s = snow depth, p = position
		public state (int snow, int pos) {
			s = snow;
			p = pos;
		}
		public int compareTo(state o) {
			if (o.s > this.s) {
				return 1;
			}
			else if (o.s < this.s) {
				return -1;
			}
			else {
				if (o.p>this.p) {
					return 1;
				} 
				else {
					return -1;
				}
			}
		}
	}
}
