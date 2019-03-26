/*3 10 8 2
ans:
3
*/
import java.io.*;
import java.util.*;
public class teleport {
	public static void main (String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter ("teleport.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int temp;
		
		int l = Math.min(left, right);
		int r = Math.max(left, right);
		temp = Math.min(x, y);
		y = Math.max(x, y);
		x = temp;
		
		pw.println(Math.min((y-x), Math.abs(x-l)+Math.abs(y-r)));
		br.close();
		pw.close();


	}
}
