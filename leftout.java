import java.io.*;
import java.util.*;

/*
3
RLR
RRL
LLR
ans:
1 1
 */
public class leftout {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter (new FileWriter("leftout.out"));
		int n = Integer.parseInt(br.readLine());
		String x; char y;
		int[] z = new int[2];
		int left = 0; int right = 0;
		boolean [][] a = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			x = br.readLine();
			for (int j = 0; j < n; j++) {
				y = x.charAt(j);
				if (y == 'L') {
					a[i][j] = true;
					left++;
				}
				else {
					a[i][j] = false;
					right++;
				}
			}
		}
		while (left!=1 && right!=1) {
			
		}
		System.out.println(z[0] + " " + z[1]);
	}
}
