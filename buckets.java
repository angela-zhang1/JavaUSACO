import java.io.*;
import java.util.*;

/*
..........
..........
..........
..B.......
..........
.....R....
..........
..........
.....L....
..........
ans:
7
*/

//USACO Bronze 2019 March/US Open Contest, problem: buckets

public class buckets {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
		StringTokenizer st;
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
		int[] b = new int[2];
		int[] l = new int[2];
		int[] r = new int[2];
		int count = 0;
		
		for (int i = 0; i <10; i++) {
			st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			for (int j = 0; j<10; j++) {
				char c = x.toCharArray()[j];
		         
		
				if (c == 'B') {
					b[0] = i;
					b[1] = j;
				}
				else if (c == 'L') {
					l[0] = i;
					l[1] = j;
				}
				else if (c == 'R') {
					r[0] = i;
					r[1] = j;
				}
			}
		}
		br.close();
		
		count = Math.abs(l[1]-b[1]) + Math.abs(l[0]-b[0]) - 1;
		
		if ((b[1] == l[1]) && (b[1] == r[1])) {
			if ((r[0] > b[0] && r[0] < l[0]) || (r[0] > l[0] && r[0] < b[0])) {
				count +=2;
			}
		}
		
		if ((b[0] == l[0]) && (b[0] == r[0])) {
			if ((r[1] > b[1] && r[1] < l[1]) || (r[1] > l[1] && r[1] < b[1])) {
				count +=2;
			}
		}
		
		pw.println(count);
		pw.close();
	}
}
