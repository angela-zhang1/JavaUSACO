import java.io.*;
import java.util.*;

//USACO Bronze 2016 December contest, problem: square

public class square {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader("square.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter("square.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sb0; int sb1; int st0; int st1;
		int squareLength;
		
		int r1b0 = Integer.parseInt(st.nextToken()); //r1 bottom x
		int r1b1 = Integer.parseInt(st.nextToken()); //r1 bottom y
		int r1t0 = Integer.parseInt(st.nextToken());
		int r1t1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r2b0 = Integer.parseInt(st.nextToken()); //r2 bottom x
		int r2b1 = Integer.parseInt(st.nextToken()); //r2 bottom y
		int r2t0 = Integer.parseInt(st.nextToken());
		int r2t1 = Integer.parseInt(st.nextToken());
		
		sb0 = Math.min(r1b0, r2b0);
		sb1 = Math.min(r1b1, r2b1);
		
		squareLength = Math.max((Math.max(r1t0, r2t0) - sb0), Math.max(r1t1, r2t1)-sb1);
		
		pw.println(squareLength);
		br.close();
		pw.close();
		
	}
}
