import java.io.*;
import java.util.*;

/*
5 8
4
7
8
6
4
ans:
4
*/
//doesn't work because my answers are too small...?

public class cowdance {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter (new FileWriter("cowdance.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int x;
		int[] a = new int[n];
		PriorityQueue<Integer> onstage = new PriorityQueue<Integer> ();

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());
			a[i] = x;
		}

		for (int i = 0; i < n; i++) {
			x = a[i];
			if (onstage.size() == 0) {
				onstage.add(x);
			}
			else if (t - onstage.peek() < a[i]) {
				onstage.add(x);
			}
			else {
				if (onstage.peek() + x <= t) {
				onstage.add(onstage.poll() + x);
				}
				else
					onstage.add(x);
			}
		}

		//while (!onstage.isEmpty())
			//System.out.println(onstage.poll());
		System.out.println(onstage.size());
		pw.close();

	}
}
