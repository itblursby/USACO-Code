//package stray;

import java.util.*;
import java.io.*;

public class IcyPerimeter895_2 {
	private static int size;
	private static final int[][] orthagonal = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("perimeter.in"));
		size = scanner.nextInt();
		scanner.nextLine();
		int[][] icyOutput = new int[size][size];
		for (int y = 0; y < size; y++) {
			String line = scanner.nextLine();
			for (int x = 0; x < size; x++) {
				if (line.charAt(x) == '#') {
					icyOutput[y][x] = 1;
				}
			}
//			System.out.println("\"" + scanner.nextLine() + "\"");
		}
		scanner.close();
//		System.out.println(Arrays.deepToString(icyOutput));
		Queue<Integer> queue = new ArrayDeque<Integer>(1000000);
		int bestarea = -1;
		int bestperimeter = -1;
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (icyOutput[y][x] == 1) {
					queue.add(y + 10000 * x);
					int area = 0;
					int perimeter = 0;
					while (queue.size() > 0) {
						long current = queue.remove();
						int cy = (int) current % 10000;
						int cx = (int) current / 10000;
						if (cy >= 0 && cy < size && cx >= 0 && cx < size) {
							if (icyOutput[cy][cx] == 1) {
								icyOutput[cy][cx] = 2;
								area++;
								for (int i = 0; i < 4; i++) {
									if (cy + orthagonal[i][0] >= 0 && cy + orthagonal[i][0] < size
											&& cx + orthagonal[i][1] >= 0 && cx + orthagonal[i][1] < size) {
										int neighbor = icyOutput[cy + orthagonal[i][0]][cx + orthagonal[i][1]];
										if (neighbor == 0) {
											perimeter++;
										}
										if (neighbor == 1) {
											queue.add(cy + orthagonal[i][0] + (cx + orthagonal[i][1]) * 10000);
										}
									} else {
										perimeter++;
									}
								}
							}
						}
					}
//					double thisratio = ((double) perimeter) / ((double) area);
//					System.out.println("----");
//
//					System.out.println(thisratio);
//					System.out.println(perimeter);
//					System.out.println(area);

					if (area > bestarea) {
//						minratio = thisratio;
						bestarea = area;
						bestperimeter = perimeter;
					} else if (area == bestarea) {
						if ((double)perimeter/area < (double)bestperimeter/bestarea){
							bestarea = area;
							bestperimeter = perimeter;
						}
					}
				}
			}
		}
		System.out.println(bestarea);
		System.out.println(bestperimeter);
		PrintWriter writer = new PrintWriter("perimeter.out");
		writer.println(bestarea + " " + bestperimeter);
//		writer.println(bestperimeter);
		writer.close();

	}

}
