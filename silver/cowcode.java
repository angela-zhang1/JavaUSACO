import java.io.*;
import java.util.*;

/*
COW 8
ans:
C

 n   n    2n        4n
123 312 212331 112331221233
COW|WCO|OCOWWC|CCOWWCOOCOWW|

000 000 000111 111111122222
123 456 789012 345678901234

 n    n      2n           4n
1234 4123 31234412
ABCD|DABC|CABCDDAB

recursive, just do it, it'll be O(log n)

123||123|123||
*/

//USACO 2017 January silver
// I did it. I finally did it. That took two years off my lifespan

public class cowcode {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter (new FileWriter("cowcode.out"));
		StringTokenizer st = new StringTokenizer (br.readLine());

		String s = st.nextToken();
		long n = Long.parseLong(st.nextToken());
		br.close();
		int x = s.length();
		int y = (int) (Math.log(n/x)/Math.log(2)) + 1;

		pw.println(function(s, n-1));
		pw.close();

	}
	public static char function (String str, long num) {
		int len = str.length();
		if (num < (long) str.length()) {
			return str.charAt((int) num);
		}
		//if it is one more than a power 2, or is the last one
		//aka a middle character
		//return function(str, the character it's supposed to be in the divided by 2)
		int x = (int) (Math.log((double)num/(double)len)/Math.log(2.0));
		long y = (long) Math.pow((long)2, (long)x) * (long)len;
		long z = num%y;

		if (num == y) { //0123 4567
			z = y-1; //3
		}
		else {
			z-=1;
		}
		if (z >=0) {
			return function(str, z);
		}
		else {
			return 'A';
		}
	}
}
