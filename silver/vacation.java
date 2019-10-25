import java.io.*;
import java.util.*;

/*
3 3 1 3
3 1 10
1 3 10
1 2 7
3 2
2 3
1 2
ans:
2
24
*/

public class vacation {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("vacation.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//PrintWriter pw = new PrintWriter(new FileWriter("vacation.out")));		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());//number of hubs
		int q = Integer.parseInt(st.nextToken());
		int x, y, z = 0;
		int count, ret, curr;
		boolean[] in = new boolean[n];
		boolean[] out = new boolean[n];
		int[][] a = new int[n][n];
		Arrays.fill(a,-1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			a[x][y] = z;
			in[y] = true; out[x] = true;
		}
		for (int i = 0; i < q; i++) {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
		}
	}
}
