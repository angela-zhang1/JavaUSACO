import java.io.*;
import java.util.*;

/*
3
2 1
8 3
5 7
ans:
15
*/

public class cowqueue {
	public static void main(String[]args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		int x = Integer.parseInt(st.nextToken()); 
		//int z; int a; 
		int ret = 0;
		/*int[][] y = new int[x][2];
		int[]b = new int[x];
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			z = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			y[i][0] = z;
			y[i][1] = a;
			b[z] = a;
		}
		for (int i = 1; i <x; i++) {
			
		}
		*/
		int[] y = new int[1000000];
		int z; int a;
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			z = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			for (int j = z; j < z+a; j++) {
				y[i]++;
				ret+=a;
			}
		}
		for (int i = 0; i < 1000000; i++) {
			if (y[i] > 1) {
				ret+=y[i] - 1;
			}
		}
		System.out.println(ret);
		//pw.close();
	}
}
