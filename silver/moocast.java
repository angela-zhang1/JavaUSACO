import java.io.*;
import java.util.*;

/*
4
1 3 5
5 4 3
7 2 1
6 1 1
ans:
3
*/
public class moocast {
	static boolean d[]; //keep track for dfs which nodes visited
	static boolean c[][];
	static int n;
	public static void main (String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][]a = new int[n][2]; // keep track of locations
		int[] b = new int[n]; //keep track of radius
		c = new boolean[n][n]; //keep track of connections
		d = new boolean[n];
		HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer> ();
		//int[] y = new int[y];
		int p = 0; int x; int y; int x2; int y2;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}

		/* To
		 	1	2	3	4
from	1
		2
		3
		4
		*/
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = false;
			}
		}

		for (int i = 0; i < n; i++) { //setting up connection array
			p = b[i]; //power
			x = a[i][0];
			y = a[i][1];
			for (int j = 0; j < n; j++) {
				x2 = a[j][0];
				y2 = a[j][1];
				if (i == j || //same node
				p*p >= Math.pow(x-x2, 2) + Math.pow(y-y2, 2)) // power > distance between
				{
					c[i][j] = true;
				}
			}
		}

		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j])
				System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}*/

		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[j] = false;
			}
			
			//System.out.println(hmap.size());
			ret = Math.max(ret, dfs(i));

			//debugging
			/*
			Set<Integer> se = new HashSet<Integer> ();
			se = hmap.keySet();
			Iterator it = se.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			System.out.println();
			*/
		}

		pw.println(ret);
		pw.close();
	}
	public static int dfs (int first) { //fix this, stack overflow
		if (d[first]) {
			return 0;
		}
		d[first] = true;
		int ret = 1;
		//System.out.println(first);
		for (int i = 0; i < n; i++) {
			//System.out.println(first + " " + i + " " + d[i] + " " + c[first][i]);
			if (c[first][i]) { //is there any way we can get to a visited cow later?
				//System.out.println("we got em,folks!");
				//System.out.println();
				//d[i] = true;
				ret+=dfs(i);
			}
		}

		return ret;
	}
}
