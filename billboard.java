/*
1 2 3 5
6 0 10 4
2 1 8 3
ans:
17 
*/

import java.io.*;
import java.util.*;

public class billboard {
	public static void main (String[]args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter ("teleport.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a; int b; int c; int d; int corner = 0;
		int[] b0 = new int [4];
		int[] b1 = new int [4];
		int[] t0 = new int [4];
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		b0[0] = a; b0[1] = b; b0[2] = c; b0[3] = d;
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		b1[0] = a; b1[1] = b; b1[2] = c; b1[3] = d;
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		t0[0] = a; t0[1] = b; t0[2] = c; t0[3] = d;
		br.close();

		int visible = (b0[2]-b0[0])*(b0[3]-b0[1]) + (b1[2]-b1[0])*(b1[3]-b1[1]);
		
		a= Math.min(b0[0], b1[0]);
		b= Math.min(b0[1], b1[1]);
		
		c= Math.max(b0[2], b1[2]);
		d = Math.max(b0[3], b1[3]);
		
		if (t0[2] <= a && t0[3] <= b) {
			System.out.println(visible);
		}
		else if (t0[0] >= c && t0[1] >=d) {
			System.out.println(visible);
		}
		
		//check to see if billboard 1 is blocked
		else {
			for (int i = 0; i < 2; i++) {
				if (b0[0] < t0[i*2] && b0[2] > t0[i*2]) {
					for (int j = 0; j < 2; j++) {
						if (b0[1] < t0[j*2+1] && b0[3] > t0[j*2+1]) {
							if (i == 0 && j ==0 && corner ==0) {
								visible -= (Math.min(t0[2], b0[2])-t0[0])*(Math.min(t0[3], b0[3]) - t0[1]);
							}// bottom left
							else if (i == 1 && j == 0 && corner == 0) {
								visible -= (t0[2] - Math.max(t0[0], b0[0]))*(Math.min(t0[3], b0[3]) - t0[1]);
							} //bottom right
							else if  (i==0 && j == 1 && corner == 0)  {
								visible -= (Math.min(t0[2], b0[2])-t0[0])*(t0[3] - Math.max(t0[1], b0[1]));
							}// top left
							else if (i == 1 && j== 1 & corner == 0) {
								visible -= (t0[2] - Math.max(t0[0], b0[0]))*(t0[3] - Math.max(t0[1], b0[1]));
							} // top right
							corner++;
						}
					}
				}
			}
			corner = 0;
			//check to see if billboard 2 is blocked
			for (int i = 0; i < 2; i++) {
				if (b1[0] < t0[i*2] && b1[2] > t0[i*2]) {
					for (int j = 0; j < 2; j++) {
						if (b1[1] < t0[j*2+1] && b1[3] > t0[j*2+1]) {
							if (i == 0 && j ==0 && corner == 0) {
								visible -= (Math.min(t0[2], b1[2])-t0[0])*(Math.min(t0[3], b1[3]) - t0[1]);
							}// bottom left
							else if (i == 1 && j == 0 && corner ==0) {
								visible -= (t0[2] - Math.max(t0[0], b1[0]))*(Math.min(t0[3], b1[3]) - t0[1]);
							} //bottom right
							else if  (i==0 && j == 1 && corner == 0)  {
								visible -= (Math.min(t0[2], b1[2])-t0[0])*(t0[3] - Math.max(t0[1], b1[1]));
							}// top left
							else if  (i == 1 && j == 1 && corner == 0) {
								visible -= (t0[2] - Math.max(t0[0], b1[0]))*(t0[3] - Math.max(t0[1], b1[1]));
							} // top right
							corner++;
						}
					}
				}
			}
			System.out.println(visible);
		}

		//pw.close();
	}
}
