//package stray;

import java.util.*;
import java.io.*;

public class Triangles1011 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("triangles.in"));
		int trianglesTotal = scanner.nextInt();
		int[][] points = new int[trianglesTotal][2];
		for (int i = 0; i < trianglesTotal; i++) {
			points[i][0] = scanner.nextInt();
			points[i][1] = scanner.nextInt();
		}
		scanner.close();
//		System.out.println()
//		Integer[] sortX = new Integer[trianglesTotal];
//		Integer[] sortY = new Integer[trianglesTotal];
//		for (int i = 0; i < trianglesTotal; i++) {
//			sortX[i] = i;
//			sortY[i] = i;
//		}
//		System.out.println(Arrays.toString(sortX));
//		System.out.println(Arrays.toString(sortY));
//		Arrays.sort(sortX,new Comparator<Integer>() {
//			public int compare(Integer a, Integer b) {
//				return points[a.intValue()][0] - points[b.intValue()][0];
//			}
//		});
//		Arrays.sort(sortX,new Comparator<Integer>() {
//			public int compare(Integer a, Integer b) {
//				return points[a.intValue()][0] - points[b.intValue()][0];
//			}
//		});
		int max = -1;
		for (int i = 0; i < trianglesTotal; i++) {
			for (int j = i+1; j < trianglesTotal; j++) {
				for (int k = j+1; k < trianglesTotal; k++) {
					if (points[i][0] ==  points[j][0] || points[j][0] ==  points[k][0] || points[i][0] ==  points[k][0]) {
						if (points[i][1] ==  points[j][1] || points[j][1] ==  points[k][1] || points[i][1] ==  points[k][1]) {
							int diffx = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[j][0]-points[k][0]) + Math.abs(points[i][0]-points[k][0]);
		
							int diffy = Math.abs(points[i][1]-points[j][1]) + Math.abs(points[j][1]-points[k][1]) + Math.abs(points[i][1]-points[k][1]);
							max = Math.max(diffx*diffy/4,max);
						}
					}
				}
			}
		}
		PrintWriter writer = new PrintWriter("triangles.out");
		writer.println(max);
		writer.close();
//		System.out.println(max);
	}

}
