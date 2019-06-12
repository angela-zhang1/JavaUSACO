import java.io.*;
import java.util.*;

/*
4 6
3 2 7 5
2 3
2 4
2 5
2 7
4 6
8 10
ans:
2
2
3
4
1
0

-------------------------------------- manual
	2	3	5	7
	
	2 3   - 2
	2 4   - 2
	2 5   - 3
	2 7   - 4
	4 6   - 1
	8 10  - 0
----------------------------------------- analysis
1) this is simulation,	range count

2) nested loop to solve this problem --> take n squared time, it is too slow when n is large
3) we find a better way to speed up the count, which we can sort the input, and find start/end index using binary search

	sort the input: 2	3	5	7
	
	binary search 2:	find the index is 0
	binary search 3:	find the index is 1 --> 1-0+1 = 2
	
	binary search 2:	find the index is 0
	binary search 4:	find the index is 1 --> 1-0+1 = 2	(4 is not directly in the dataset, but we can find the index right below it)
						floor-index
	binary search 8:	index is 3
				  10:	index is 3	---> both not exact math 3-3=0
--------------------------------------------------
4) if one number binary search is in dataset, we need adjust 1
   if both number binary search are not in the data set, but return floor idex, we don't need to adjust (8,10)
   
*/

public class haybales {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		int n = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
	}
	static int bsearch(int val) {
		if (a[0] > val)
			return 0;
		int lo = 0; hi = a.length-11;
		while (lo!= hi) {
			int mid = (lo+hi+1)/2;
			if (a[mid] <= val)
				lo = mid;
			else 
				hi = mid-1;
		}
		return lo+1;
	}
}
