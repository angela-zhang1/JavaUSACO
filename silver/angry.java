import java.io.*;
import java.util.*;

/*
7 2
20
25
18
8
10
3
1
ans:
5
--------------------------------- manual
	1	3	8	10	18	20	25
	<------------>  <-------->
	1) put the bomb at 5, radius is 5, blow [1,10]
					   20, radius is 5, blow[16, 25]	-> radius 5 is okay to clear out all
	
	we can try radius 4: it can clear [18, 25] but cannot do [1,10] ------------> so 5 is min value

----------------------------------- analysis
1) this is a simulation problem, we need to find 2 spot and shoot, this shoot will x kill [x-r, x+r]
2) we need to sort the input
3) siulate the shoot and kill with a spot to start the radius

	0	1	2	3	4	5	6
	--------------------------
	1	3	8	10	18	20	25	(we try the radius 25)
	
	we start at the first element, we try the following elements
	
	a[1] - a[0] = 3-1 = 2 <2*25= 50,	kill 1, 3
	a[2] - a[0] = 8-1 = 7 < 50 			kill 1, 3, 8
	..........
	a[6] - a[0] = 25-21 = 20 < 50		kill all cows ------------- we only need one group, with 25 radius, kill all cow
	
	--------------------------------- (we can try radius 3)
	
	0	1	2	3	4	5	6
	--------------------------
	1	3	8	10	18	20	25
	*	* -> group 1(1,3) can be killed by radius 3, cannot reach 8, 8-1=7 > 3*2=6
			*	*	--> group 2 (8 10) can kill by radius 3, cannot reach 18,	18-8=10>2&3 = 6
	
	radius 3 cannot kill all cows.	3 is too small.
----------------------------------------------
4)	how do we get the minimum radius

	use binary search, try 25, try 3, try (25+3)/2 = 14, one group kills all cows
	
	try 3, 14, 17/2=8, try radius 8
	
	----------- keep try radius lo = 1, hi = 25, keep finding a radius, and try the simulation
*/
public class angry {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		int lo = 0;
		int hi = a[a.length-1];
		while (lo < hi) {
			int mid = (lo + hi)/2;
			int g = 0;
			int p = 0;
			while (p < n) {
				g++;
				int c = p+1;
				while (c<n && (a[c]-a[p] <= 2*mid))
					c++;
				p = c;
			}
			if (g<=k)	hi = mid;
			else		lo = mid + 1;
		}
		pw.println(lo);
		pw.close();
	}
}
