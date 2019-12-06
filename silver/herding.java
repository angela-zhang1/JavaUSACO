import java.io.*;
import java.util.*;

/*
3
7
4
9
ans:
1
2
*/

public class herding {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		//PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter("herding.out")));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int retmin = n-1; int retmax = n-1;
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		
		/*GENERAL CASE:
		1 <= minimum number of moves <= number of points-1 
		1 <= maximum number of moves <= total gaps? IDK MAN		
		*/
		//PRE
		for (int i = 0; i < n-1; i++) {}
		//MIN
		
		//MAX
	}
}
