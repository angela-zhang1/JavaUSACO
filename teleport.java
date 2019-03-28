/*3 10 8 2
ans:
3
*/

import java.io.*;
import java.util.*;

//USACO Bronze 2018 February contest, problem: teleport

public class teleport {
	public static void main (String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter ("teleport.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x0 = Integer.parseInt(st.nextToken());
		int y0 = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int ret = Math.abs(y0-x0);
		
		ret = Math.min(ret, Math.abs(x1-x0) + Math.abs(y1-y0));
		
		ret = Math.min(ret, Math.abs(y1-x0) + Math.abs(y0-x1));
		
		 /*
		int l = Math.min(left, right);
		int r = Math.max(left, right);
		temp = Math.min(x, y);
		y = Math.max(x, y);
		x = temp;
		*/
		
		//pw.println(Math.min((y-x), Math.abs(x-l)+Math.abs(y-r)));
		pw.println(ret);
		br.close();
		pw.close();


	}
}
