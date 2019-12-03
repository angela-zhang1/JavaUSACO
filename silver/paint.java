import java.io.*;
import java.util.*;

/*
6 2
2 R
6 L
1 R
8 L
1 R
2 R
ans:
6
*/

public class paint {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("paint.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = 0;
		int ret = 0;

		for (int i = 0; i < n; i++) {

		}
		System.out.println(ret);
	}
}
