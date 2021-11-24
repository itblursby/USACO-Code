//package stray;

import java.util.*;
import java.io.*;

public class IcyPerimeter895 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		int ax = 0;
//		int ay = 94;
//		System.out.println(ax + " " + ay);
//		int apoint = ay | (ax << 16);
//		System.out.println((apoint >> 16) & 0xffff);
//		System.out.println((apoint) & 0xffff);
		Scanner scanner = new Scanner(new File("perimeter.in"));
		Queue<Integer> queue = new LinkedList<Integer>();
		int size = scanner.nextInt();

//		scanner.nextLine();
		int[][] icecream = new int[size][size];
		for (int y = 0; y < size; y++) {
			String line = scanner.next();
			for (int x = 0; x < size; x++) {
				icecream[y][x] = line.charAt(x) == '.' ? 0 : 1;
			}
		}
		scanner.close();
//		System.out.println(Arrays.deepToString(icecream));
//		double ratio = Double.MAX_VALUE;
		int bestarea = -1;
		int bestperimeter = -1;
//		int 
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (icecream[y][x] == 1) {
					queue.add(y | (x << 16));
					int carea = 0;
					int cperimeter = 0;
					while (queue.size() > 0) {
						int point = queue.poll();
						int px = (point >> 16) & 0xffff;
						int py = (point) & 0xffff;
						if (icecream[py][px] == 1) {
							icecream[py][px] = 2;
							carea++;
							cperimeter += sides(icecream, px, py);
							if (py + 1 < size) {
								queue.add((py + 1) | (px << 16));
							}
							if (py - 1 >= 0) {
								queue.add((py - 1) | (px << 16));
							}
							if (px + 1 < size) {
								queue.add((py) | ((px + 1) << 16));
							}
							if (px - 1 >= 0) {
								queue.add((py) | ((px - 1) << 16));
							}
						}

//						ratio = 
					}
//					double cratio = (double) cperimeter / (double) carea;
//					if ()
//					System.out.println(cratio);
					if (carea > bestarea) {
//						ratio = cratio;
						bestarea = carea;
						bestperimeter = cperimeter;
					}else if (carea == bestarea) {
						if (((double)carea) / cperimeter < ((double)bestarea)/bestperimeter) {
							bestarea = carea;
							bestperimeter = cperimeter;
						}
					}
				}
			}
		}
//		System.out.println(Arrays.deepToString(icecream));
//		System.out.println(bestarea);
//		System.out.println(bestperimeter);
		PrintWriter writer = new PrintWriter("perimeter.out");
		writer.println(bestarea + " " + bestperimeter);
		writer.close();

	}

	private static int sides(int[][] icecream, int x, int y) {
		int perimeter = 0;
		if (x + 1 < icecream[0].length) {
			if (icecream[y][x + 1] == 0) {
				perimeter++;
			}
		} else {
			perimeter++;
		}
		if (x - 1 >= 0) {
			if (icecream[y][x - 1] == 0) {
				perimeter++;
			}
		} else {
			perimeter++;
		}
		if (y + 1 < icecream.length) {
			if (icecream[y + 1][x] == 0) {
				perimeter++;
			}
		} else {
			perimeter++;
		}
		if (y - 1 >= 0) {
			if (icecream[y - 1][x] == 0) {
				perimeter++;
			}
		} else {
			perimeter++;
		}
		return perimeter;
	}

}
