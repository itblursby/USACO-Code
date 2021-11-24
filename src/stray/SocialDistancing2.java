//http://www.usaco.org/index.php?page=viewproblem2&cpid=1036
package stray;

import java.util.*;
import java.io.*;

public class SocialDistancing2 {
	private static String testinput = "6\n" + "7 1\n" + "1 1\n" + "15 1\n" + "3 1\n" + "10 0\n" + "6 1";

//	private static sp
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("socdist2.in"));
//		Scanner s = new Scanner(testinput);
		int cowsTotal = s.nextInt();
		int[] space = new int[1000001];

		for (int i = 0; i < cowsTotal; i++) {
			// 1 NUMBER FOR UNAFFECTED
			// -1 NUMBER FOR SICK
			int pos = s.nextInt();
			boolean sick = s.nextInt() == 1;
			space[pos] = sick ? -1 : 1;
		}
		s.close();
//		System.out.println(Arrays.toString(space));
		int R = Integer.MAX_VALUE;
		int last = -1;
		for (int i = 0; i < 1000001; i++) {
			if (space[i] != 0) {
				if (last != -1) {
					if (space[i] != space[last]) {

						R = Math.min(R, i - last - 1);
					}
				}
				last = i;
			}
		}
		
		System.out.println(R);
		int groups = 1;
//		int last = -1;
		last = -1;
		for (int i = 0; i < 1000001; i++) {
			if (space[i] != 0) {
				if (last != -1) {
					if (space[last] == 1 && space[i] == -1) {
						groups++;
					}else if (space[i] == -1 && space[last] == -1 && i - last > R){
						groups++;
					}
				}
				last = i;
			}
		}
		System.out.println(groups);
		PrintWriter pw = new PrintWriter("socdist2.out");
		pw.println(groups);
		pw.close();
	}

}
