import java.io.*;
import java.util.*;

/*
4
2 spots firebreathing
0
1 flying
2 telepathic flying
ans:
yes 

if a characteristic appears alone
that characteristic is at top of tree
if a characteristic appears in multiple cows w
*/

//USACO Bronze 2019 March/US Open contest, problem: evolution
public class evolution {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
		int n = Integer.parseInt(st.nextToken());
		int x; String y; String z;
		int a; int b; int c = 0; int d = 0;
		//int e = 0; int count = 0;
		boolean possible = true;
		String[][] arr = new String[n][n];
		//int[]characteristics = new int[625];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			for (int j = 0; j < x; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		br.close();
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) { 
				y = arr[i][j];
				for (int f = 0; f<n-1; f++) {	
					z = arr[i][f];
					c=0;
					d=0;
					for (int k = 1; k <n; k++) {
						a=0;
						b=0;
						for (int l = 0; l<n; l++) {
							if (arr[k][l]!= null &&arr[k][l].equals(y)) {
								a++;
							}
							if (arr[k][l]!=null && arr[k][l].equals(z)) {
								b++;
							}
						}
					if (a!=0 && b == 0) c++;
					if (a==0 && b != 0) d++;	
					}
					if (c!=0 && d!=0) {
						possible=false;
						break;
					}
				}
				//characteristics[i*n+j] = e;
				/*z = arr[i][j+1];
				a = 0;
				b = 0;
				c = 0;
				d = 0;
				for (int k = 1; k <n; k++) {
					for (int l = 0; l<n; l++) {
						if (arr[k][l]!= null &&arr[k][l].equals(y)) {
							a++;
						}
						if (arr[k][l]!=null && arr[k][l].equals(z)) {
							b++;
						}
					}
					if (a==1 && b == 0) c++;
					if (a==0 && b == 1) d++;
				}
				System.out.println(c);
				System.out.println(d);
				if (c!=0 && d!=0) {
					possible=false;
					break;
				}*/
				
			}
			/*for (int m = 0; m<n-1; m++) {
				if (characteristics[i*n + m] !=0) count++;
			}
			if (count > 1) {
				possible = false;
				break;
			}*/
		}
		if (possible)
			pw.println("yes");
		else
			pw.println("no");
		pw.close();
	}
}
