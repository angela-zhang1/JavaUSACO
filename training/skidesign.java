/*
ID: angela.11
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

/*
5
20
4
1
24
21
ans:
18
*/

public class skidesign {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int ret = Integer.MAX_VALUE; 
		int distances = 0;
		int x = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.sort(a);
		/*for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}*/
		for (int i = 0; i < n; i++) {
			distances = 0;
			x = a[i] - 17;
			//THIS IS YOUR MOMENT
			//NOW IS YOUR TIME SO
			//PROVE YOURSELF AND
			//  ___           ___   ______
			// |   \    |    /      |
			// |    |   |   |       |
			// |___/    |   \____   |____
			// |  \     |        \  |
			// |   \    |        |  |
			// |    \   |   ____/   |_____
			// that was a waste of time....
			for (int j = 0; j <= i; j++) {
				if (x - a[j] > 0) {
					distances+=Math.pow(x-a[j], 2);
				} 
			}
			for (int j = i; j < n; j++) {
				distances +=Math.pow(a[j] - a[i], 2);
			}
			ret = Math.min(distances, ret);
			
			x = a[i] + 17;
			distances = 0;
			for (int j = 0; j <= i; j++) {
					distances+=Math.pow(a[i]-a[j], 2);
			}
			for (int j = i; j < n; j++) {
				distances +=Math.pow(a[j] - x, 2);
			}
			ret = Math.min(distances, ret);
  		}
		pw.println(ret);
		pw.close();
	}
}
