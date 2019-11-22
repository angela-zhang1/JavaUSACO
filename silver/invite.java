import java.util.*;
import java.io.*;

/*
10 4
2 1 3
2 3 4
6 1 2 3 4 6 7
4 4 3 2 1
ans:
4
*/

public class invite {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("invite.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int x;
		for (int i = 0; i < g; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			for (int j = 0; j < x; j++) {

			}
		}
	}
}
