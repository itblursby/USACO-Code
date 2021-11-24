//http://www.usaco.org/index.php?page=viewproblem2&cpid=1015

package stray;

import java.util.*;
import java.io.*;

public class Triangles1015 {

	public static void main(String[] super_mario_bros) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int totalPoints;
		int[][] points;
//		ArrayList[][] ysums = new int[20001][];
		int[][] xsums = new int[10][];
		int[][] ysums = new int[10][];
		Scanner scanner = new Scanner(new File("triangles.in"));
		totalPoints = scanner.nextInt();
		points = new int[totalPoints][2];
		for (int i = 0; i < totalPoints; i++) {
			points[i][0] = scanner.nextInt() + 0; //10000
			points[i][1] = scanner.nextInt() + 0; //10000
		}
		scanner.close();
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return a[0] - b[0];
				return a[1] - b[1];
			}
		});
		int last = 0;
		for (int i = 0; i < points.length; i++) {
			if (points[i][1] != points[last][1]) {
				xsums[points[last][1]] = new int[i - last];
				xsums[points[last][1]][0] = points[last][0];
				for (int j = last + 1; j < i; j++) {
					xsums[points[last][1]][j - last] = points[j][0];
				}
				last = i;

			}
		}
		last = 0;
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] != points[last][0]) {
				ysums[points[last][0]] = new int[i - last];
				ysums[points[last][0]][0] = points[last][0];
				for (int j = last + 1; j < i; j++) {
					ysums[points[last][0]][j - last] = points[j][1];
				}
				last = i;
			}

		}
		System.out.println(Arrays.deepToString(xsums));
		System.out.println(Arrays.deepToString(ysums));


//		PrintWriter writer = new PrintWriter("triangles.out");
//		writer.close();
	}

}
