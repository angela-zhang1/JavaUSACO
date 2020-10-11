import java.io.*;
import java.util.*;

//http://www.usaco.org/index.php?page=viewproblem2&cpid=787
//USACO 2018 Jan Silver Rental

public class rental {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new FileWriter("rental.out"));
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] cows = new int[n];
		long[] cowvalues = new long[n];
		Arrays.fill(cowvalues, 0);
		TreeMap<Integer, Integer> stores = new TreeMap<Integer, Integer> ();
		long[] rent = new long[r];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			cows[i] = x;
		}
		Arrays.sort(cows); //cow producing milk low to high
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //gallons requested
			int y = Integer.parseInt(st.nextToken()); //cents per gallon
			 //want to sort by how much MONEY
			stores.put(y, x);
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); 
			rent[i] = (long) x;
		}
		br.close();
		Arrays.sort(rent); //rental prices low to high
		
		//stores values in cow[count] for how much milk from selling gallons
		boolean gonext = false;
		for (int count = n-1; count >= 0; count--) { //go till we run out of cows
			int x = stores.lastKey(); //cents per gallon
			int y = stores.get(x); //gallons store currently has
			int z = cows[count];
			while (z >= y) { //if one cow can fulfill the requirement for 1 or more stores
				cowvalues[count]+= ((long)x)*((long)y);
				stores.remove(x); //that store is gone
				z -= y;
				if (stores.size() == 0) { //if that store is the last store
					gonext = true;
					break;
				}
				x = stores.lastKey(); //go to the next store
				y = stores.get(x);
			}
			if (gonext)
				break;
			cowvalues[count] += ((long)z)*((long)x);
			stores.put(x, y-z);
		}
		
		//see if the lowest value cows get better by renting
		for (int i = 0; i < r; i++) {
			if (i >= n) {
				break;
			}
			cowvalues[i] = Math.max(cowvalues[i], rent[r-i-1]);
		}
		
		long ret = 0;
		for (int i = 0; i < n; i++) {
			ret+= cowvalues[i];
		}
		
		System.out.println(ret);
		pw.close();
	}
}
