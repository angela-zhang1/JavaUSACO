import java.io.*;
import java.util.*;

//USACO Bronze 2015 December contest, problem: paint

public class paint {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader("paint.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter("paint.out")));
		int f0 = Integer.parseInt(st.nextToken());
		int f1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b0 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		int painted = (f1-f0)+(b1-b0);
		if (f1>b0) {
		}
		pw.println();
		br.close();
		pw.close();
	}

}
