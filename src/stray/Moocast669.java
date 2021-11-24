package stray;

import java.util.*;
import java.io.*;

public class Moocast669 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("moocast.in"));
//		System.out.println(scanner.nextInt());
		int cowsTotal = scanner.nextInt();
		int[] parents = new int[cowsTotal];
		int[][] cows = new int[cowsTotal][2];
		for (int i = 0; i < cowsTotal; i++) {
			parents[i] = i;
			cows[i][0] = scanner.nextInt();
			cows[i][1] = scanner.nextInt();
		}
		scanner.close();
		
		// cow A, cow B,
		int[][] distances = new int[cowsTotal * (cowsTotal - 1) / 2][3];
		int index = 0;
		for (int i = 0; i < cowsTotal; i++) {
			for (int j = i + 1; j < cowsTotal; j++) {
				distances[index][0] = i;
				distances[index][1] = j;
				distances[index][2] = (cows[i][0] - cows[j][0]) * (cows[i][0] - cows[j][0])
						+ (cows[i][1] - cows[j][1]) * (cows[i][1] - cows[j][1]);
				index++;
			}
		}
		Arrays.sort(distances, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});
		int joins = 0;
		for (index = 0; index < distances.length; index++) {
			boolean joined = join(parents,distances[index][0],distances[index][1]);
			if (joined) {
				joins++;
				if (joins == cowsTotal-1) {
					break;
				}
			}
		}
//		System.out.println(Arrays.deepToString(distances));
//		System.out.println(distances[index][2]);
		PrintWriter writer = new PrintWriter("moocast.out");
		writer.println(distances[index][2]);
		writer.close();
		
	}
	private static boolean join(int[] parents, int a, int b) {
		int pa = parent(parents,a);
		int pb = parent(parents,b);
		if (pa == pb) {
			return false;
		}else {
			parents[pa] = pb;
			return true;
		}
	}
	private static int parent(int[] parents, int a) {
		int current = a;
		while(parents[current] != current) {
			current = parents[current];
		}
		return current;
	}
//	private class Point

}
