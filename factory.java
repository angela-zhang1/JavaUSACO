import java.io.*;
import java.util.*;

//2019 Bronze USACO March/US open contest, problem: factory

/*
Use a 2D array of booleans, check to see if there is a row filled (except for 1 column)
For point arr[i][j]; you can get to i from j for ex, you can get to 3 from 1
  0 1 2 3
0   X
1       X
2    
3     X

3
1 2
3 2
ans:
2
*/

public class factory {
	public static void main(String[]args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("factory.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter ("factory.out")));
		//String str = new String(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int x = 0; int y = 0; int z = 0;
		int count = 0; int column=0;
		
		int n = Integer.parseInt(st.nextToken());
		boolean [][] arr = new boolean [n][n];		
		for (int i = 0; i < n-1; i ++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[y-1][x-1] = true;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <n; j++) {
				if (arr[j][i]) {
					column++;
				}
			}
			if (column == 0) {
				z = i;
			}
			else {
				count++;
			}
			column = 0;
		}
		
		if (count < n-1) {
			pw.println(-1);
		}
		else {
			pw.println(z+1);
		}
		
		br.close();
		pw.close();
	}
}
