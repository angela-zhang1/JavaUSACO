import java.io.*;
import java.util.*;

/*
8
3 1
3 0
6 0
2 1
4 1
3 0
4 0
3 1
ans:
3
*/

public class crossroad {
	public static void main (String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
		int x = Integer.parseInt(st.nextToken());
		int y; int z; int ret = 0;
		int[] cowSide = new int[x];
		int[] checked = new int[x];
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			checked[y-1]++;
			if (checked[y-1] > 1) {
				if (cowSide[y-1]!=z){
					ret++;
				}
			}
			cowSide[y-1] = z;
		}
		br.close();
		pw.println(ret);
		pw.close();
	}
}
