//package stray;

import java.util.*;
import java.io.*;

public class Triangles1015_2 {
	public static final int modnumber = 1000000007;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("triangles.in"));
		int totalPoints = scanner.nextInt();
		int[][] points = new int[totalPoints][4];
		// [x coord, y coord, xsums index, ysums index]
		for (int i = 0; i < totalPoints; i++) {
			points[i][0] = scanner.nextInt() + 10000;
			points[i][1] = scanner.nextInt() + 10000;
//			points[i][0] = scanner.nextInt() + 0; // comment out later
//			points[i][1] = scanner.nextInt() + 0;
		}
		// points[i][0] = x
		// points[i][1] = y
		scanner.close();
//		int[][] xsums = new int[20001][];
//		int[][] ysums = new int[20001][];
		int[][] xsums = new int[20001][];
		int[][] ysums = new int[20001][];
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {

				return a[1] != b[1] ? a[1] - b[1] : a[0] - b[0];
			}
		});
		System.out.println(Arrays.deepToString(points));
		int last = 0;
		for (int i = 0; i <= totalPoints; i++) {
			if (i >= totalPoints || points[i][1] != points[last][1]) {
//				System.out.println("last " + last + " i " + i);
				int len = i - last;
				int currenty = points[last][1];
				xsums[currenty] = new int[len];
				xsums[currenty][0] = points[last][0];
				points[last][2] = 0;
				for (int j = last + 1; j < i; j++) {
					points[j][2] = j - last;
					xsums[currenty][j - last] = xsums[currenty][j - last - 1] + points[j][0];
				}
				last = i;
			}
		}
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
			}
		});
//		System.out.println(Arrays.deepToString(points));
		last = 0;
		for (int i = 0; i <= totalPoints; i++) {
			if (i >= totalPoints || points[i][0] != points[last][0]) {
//				System.out.println("last " + last + " i " + i);
				int len = i - last;
				int currentx = points[last][0];
				ysums[currentx] = new int[len];
				ysums[currentx][0] = points[last][1];
				points[last][3] = 0;
				for (int j = last + 1; j < i; j++) {
					points[j][3] = j - last;
					ysums[currentx][j - last] = ysums[currentx][j - last - 1] + points[j][1];
				}
				last = i;
			}
		}
//		System.out.println(Arrays.deepToString(points));
//
//		System.out.println(Arrays.deepToString(xsums));
//		System.out.println(Arrays.deepToString(ysums));
		long result = 0;
		for (int i = 0; i < totalPoints; i++) {
			int pointx = points[i][0];
			int pointy = points[i][1];
			int indexx = points[i][2];
			int indexy = points[i][3];
			long sumleft = 0;
			long sumright = 0;
			long sumdown = 0;
			long sumup = 0;
			if (indexx != 0) {
				sumleft = pointx * indexx - xsums[pointy][indexx - 1];
			}
			if (indexx != xsums[pointy].length - 1) {
				sumright = -pointx * (xsums[pointy].length - 1 - indexx) + xsums[pointy][xsums[pointy].length - 1]
						- xsums[pointy][indexx];
			}
			if (indexy != 0) {
				sumdown = pointy * indexy - ysums[pointx][indexy - 1];
			}
			if (indexy != ysums[pointx].length - 1) {
				sumup = -pointy * (ysums[pointx].length - 1 - indexy) + ysums[pointx][ysums[pointx].length - 1]
						- ysums[pointx][indexy];
			}
//			System.out.println("(" + pointx + "," + pointy + "): " + sumleft); // how many to the left
//			System.out.println(sumright);
//			System.out.println(sumdown);
//			System.out.println(sumup);
//			sumleft %= modnumber;
//			sumright %= modnumber;
//			sumdown %= modnumber;
//			sumup %= modnumber;
			result += ((sumleft + sumright)) * ((sumdown + sumup))%modnumber;

		}
//		System.out.println("answer " + result);
		PrintWriter writer = new PrintWriter("triangles.out");
		writer.println(result % modnumber);
		writer.close();
		

	}

}
