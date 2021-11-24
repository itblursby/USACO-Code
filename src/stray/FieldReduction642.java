package stray;

import java.util.*;
import java.io.*;

public class FieldReduction642 {
	private static int cowsTotal;
	private static int[][] points;
	private static Integer[] xsorted;
	private static Integer[] ysorted;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("reduce.in"));
		cowsTotal = scanner.nextInt();
		points = new int[cowsTotal][2];
		for (int i = 0; i < cowsTotal; i++) {
			points[i][0] = scanner.nextInt();
			points[i][1] = scanner.nextInt();
		}
		scanner.close();
		System.out.println("Total: " + cowsTotal);
		System.out.println("points: " + Arrays.deepToString(points));
		xsorted = new Integer[cowsTotal]; // indexes for x
		ysorted = new Integer[cowsTotal]; // indexes for y
		for (int i = 0; i < cowsTotal; i++) {
			xsorted[i] = Integer.valueOf(i);
			ysorted[i] = Integer.valueOf(i);
		}
		Arrays.sort(xsorted, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return points[a.intValue()][0] - points[b.intValue()][0];
			}
		});
		Arrays.sort(ysorted, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return points[a.intValue()][1] - points[b.intValue()][1];
			}
		});
//		System.out.println(Arrays.deepToString(xsorted));
//		System.out.println(Arrays.deepToString(ysorted));
//		System.out.println(removeCows(3));
		PrintWriter writer = new PrintWriter("reduce.out");
		writer.println(removeCows(3));
		writer.close();
	}

	static int removeCows(int cowsToRemove) {

		int leftmost;
		int rightmost;
		int upmost;
		int downmost;
		
		for (leftmost = 0; leftmost < cowsTotal; leftmost++) {
			if (points[xsorted[leftmost].intValue()] != null) {
				break;
			}
		}
		for (rightmost = cowsTotal - 1; rightmost >= 0; rightmost--) {
			if (points[xsorted[rightmost].intValue()] != null) {
				break;
			}
		}
		for (downmost = 0; downmost < cowsTotal; downmost++) {
			if (points[ysorted[downmost].intValue()] != null) {
				break;
			}
		}
		for (upmost = cowsTotal - 1; upmost >= 0; upmost--) {
			if (points[ysorted[upmost].intValue()] != null) {
				break;
			}
		}
//		System.out.println(leftmost);
//		System.out.println(rightmost);
//		System.out.println(upmost);
//		System.out.println(downmost);
		if (cowsToRemove == 0) {
			return (points[xsorted[rightmost].intValue()][0] - points[xsorted[leftmost].intValue()][0])
					* (points[ysorted[upmost].intValue()][1] - points[ysorted[downmost].intValue()][1]);
		}else {
			int result = Integer.MAX_VALUE;
			
			int[] cowTakenOut = points[xsorted[leftmost].intValue()];
			points[xsorted[leftmost].intValue()] = null;
			result = Math.min(result, removeCows(cowsToRemove-1));
			points[xsorted[leftmost].intValue()] = cowTakenOut;
			
			cowTakenOut = points[xsorted[rightmost].intValue()];
			points[xsorted[rightmost].intValue()] = null;
			result = Math.min(result, removeCows(cowsToRemove-1));
			points[xsorted[rightmost].intValue()] = cowTakenOut;
			
			cowTakenOut = points[ysorted[upmost].intValue()];
			points[ysorted[upmost].intValue()] = null;
			result = Math.min(result, removeCows(cowsToRemove-1));
			points[ysorted[upmost].intValue()] = cowTakenOut;

			cowTakenOut = points[ysorted[downmost].intValue()];
			points[ysorted[downmost].intValue()] = null;
			result = Math.min(result, removeCows(cowsToRemove-1));
			points[ysorted[downmost].intValue()] = cowTakenOut;
			
			return result;
		}

	}

}
