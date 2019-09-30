import java.io.*;
import java.util.*;

/*
4 3
1 2 3
2 3 2
2 4 4
1 2
4 1
3 1
ans:
3
0
2
*/

public class mootube {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int k = 0; int[] ret = new int[q];
		int x,y,z = 0;
		int[][] a = new int[q][q];
		for (int i = 0; i < n-1; i++) {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			a[x][y] = z;
			a[y][x] = z;
		}
		for (int i = 0; i < q; i++) {
			
		}
		for (int i = 0; i < q; i++) {
			System.out.println(ret[i]);
		}
		//pw.close();
	}
}
