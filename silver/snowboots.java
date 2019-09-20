import java.io.*;
import java.util.*;

/*
10 4
0 2 8 3 6 7 5 1 4 0
2 3
4 2
3 4
7 1
ans:
2
*/

//8 out of 10 test cases
//check if the next pair of boots is OK to step on current tile
public class snowboots {
	public static void main (String[]args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new FileWriter("snowboots.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[]t = new int[n];
		int[][]boot = new int[b][2];
		int bo = 0;
		int x,y,z=0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			boot[i][0] = x;
			boot[i][1] = y;
		}
		for (int i = 0; i < n; i++) {
			x = boot[bo][0]; //snow depth
			y = boot[bo][1]; //distance
			if (t[i] > x) {
				z++;
			}
			else { 
				if (z!=0 && z+1 > y) {
					bo++;
					i-=z;
					i-=2;
				}
				z=0;
			}
		}
		System.out.println(bo);
		//pw.close();
	}
} 
