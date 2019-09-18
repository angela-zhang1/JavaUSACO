import java.io.*;
import java.util.*;

/*
4 10
7 3 +3
4 2 -1
9 3 -1
1 1 +2
ans:
3 
*/
public class measurement {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x,y,z = 0;
		HashSet<Integer> maxIndex = new HashSet<Integer>();  
		int maxValue = 0;
		int ret = 0;
		state[] change = new state[n];
		int[] cows = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			maxIndex.add(y);
			change[i] = new state(x,y,z);
		}
		Arrays.sort(change);
		for (int i = 0; i < n; i++) {
			x = change[i].c;
			y = change[i].m;
			if (y < 0) {
				if (maxIndex.contains(x) && maxIndex.size()!=1) {
					maxIndex.remove(x);
					ret++;
				}
				else if (maxIndex.contains(x) && maxIndex.size() == 1) {
					cows[x] += y;
					maxValue = Integer.MIN_VALUE;
					for (int j = 0; j < n; j++) {
						if (cows[j] > maxValue) {
							maxValue = cows[j];
							maxIndex = new HashSet<Integer>();
							maxIndex.add(j);
						}
						else if (cows[j] == maxValue) {
							maxIndex.add(j);
						}
					}
					if (maxIndex.contains(x) && maxIndex.size() == 1) {
						ret--;
					}
					cows[x] -= y;
					ret++;
				}
			}
			else if (y > 0) {
				if (cows[x] + y > maxValue) {
					if (maxIndex.size() == 1 && cows[x] == maxValue) {
						ret--;
					}
					maxValue = cows[x] + y;
					maxIndex = new HashSet<Integer> ();
					maxIndex.add(x);
					
					ret++;
				}
				else if (cows[x] + y == maxValue) {
					maxIndex.add(x);
					ret++;
				}
			}
			cows[x] += y;
		}
		pw.println(ret);
		pw.close();
	}
	static class state implements Comparable<state> {
		int d, c, m; //day, cow, milk 
		public state(int day, int cow, int milk) {
			d = day;
			c = cow;
			m = milk;
		}
		public int compareTo(state o) {
			if (o.d < this.d) {
				return 1;
			}
			else if (o.d > this.d) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}
