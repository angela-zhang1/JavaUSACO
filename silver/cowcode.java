import java.io.*;
import java.util.*;

/*
COW 8
ans:
C

 n   n    2n        4n
123 312 212331 112331221233
COW|WCO|OCOWWC|CCOWWCOOCOWW|

 n    n      2n           4n
1234 4123 31234412
ABCD|DABC|CABCDDAB

recursive, just do it, it'll be O(log n)

123||123|123||
*/

public class cowcode {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter (new FileWriter("cowcode.out"));
		StringTokenizer st = new StringTokenizer (br.readLine());

		String s = st.nextToken();
		long n = Integer.parseInt(st.nextToken());
		br.close();
		int x = s.length();
		int y = (int) (Math.log(n/x)/Math.log(2)) + 1;

	}
	public char function (int x) {
		
		return 'c';
	}
}
