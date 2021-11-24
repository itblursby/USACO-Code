//package stray;

import java.util.*;
import java.io.*;

public class BullInAChinaShop640_2 {
//	private static 
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("bcs.in"));
		int size = scanner.nextInt(); // [3,8]
		int numpieces = scanner.nextInt(); // [3,10]
		scanner.nextLine();
		int[] figurine = new int[size];
		for (int y = 0; y < size; y++) {
			String line = scanner.nextLine();
			figurine[y] = 0;
			for (int x = 0; x < size; x++) {
				if (line.charAt(x) == '#') {
					figurine[y] += 1 << x;
				}
			}
		}
//		System.out.println();
//		print2d(figurine);

		int[][] pieces = new int[numpieces][size];
		int[][] bounds = new int[numpieces][4]; // xs,xb,ys,yb
		for (int i = 0; i < numpieces; i++) {
			int[] curpiece = pieces[i];
			bounds[i][0] = 1000;
			bounds[i][1] = -1000;
			bounds[i][2] = 1000;
			bounds[i][3] = -1000;
			for (int y = 0; y < size; y++) {
				String line = scanner.nextLine();
				curpiece[y] = 0;
				for (int x = 0; x < size; x++) {
					if (line.charAt(x) == '#') {
						bounds[i][0] = Math.min(bounds[i][0], x);
						bounds[i][1] = Math.max(bounds[i][1], x);
						bounds[i][2] = Math.min(bounds[i][2], y);
						bounds[i][3] = Math.max(bounds[i][3], y);
						curpiece[y] += 1 << x;
					}
				}
			}
//			System.out.println();
//			print2d(curpiece);
//			System.out.println(Arrays.toString(bounds[i]));
		}
		int answer1 = -1;
		int answer2 = -1;
		int[] space = new int[size];
		for (int p1 = 0; p1 < numpieces; p1++) {
			for (int p2 = p1 + 1; p2 < numpieces; p2++) {
				for (int dx1 = -bounds[p1][0]; dx1 < size - bounds[p1][1]; dx1++) {
					for (int dy1 = -bounds[p1][2]; dy1 < size - bounds[p1][3]; dy1++) {
						for (int dx2 = -bounds[p2][0]; dx2 < size - bounds[p2][1]; dx2++) {
							construction: for (int dy2 = -bounds[p2][2]; dy2 < size - bounds[p2][3]; dy2++) {
								for (int i = 0; i < size; i++) {
									space[i] = 0;
								}
								for (int i = bounds[p1][2] + dy1; i <= bounds[p1][3] + dy1; i++) {
									space[i] |= rShift(pieces[p1][i - dy1], dx1);
								}
//								System.out.println();
//								print2d(space);

								for (int i = bounds[p2][2] + dy2; i <= bounds[p2][3] + dy2; i++) {
									int shifted = rShift(pieces[p2][i - dy2], dx2);
									if ((space[i] & shifted) == 0) {
										space[i] |= shifted;
									} else {
										continue construction;
									}
								}
								for (int i = 0; i < size; i++) {
									if (space[i] != figurine[i]) {
										continue construction;
									}
								}
								answer1 = p1;
								answer2 = p2;
								break;
//								System.out.println("NOOO " + p1 +" "+ p2);
//								print2d(space);

							}
						}
					}
				}
			}
		}
		System.out.println(answer1);
		System.out.println(answer2);
		PrintWriter writer = new PrintWriter("bcs.out");
		writer.println((answer1+1) + " " + (answer2+1));
		writer.close();

	}

	private static void print2d(int[] thing) {
//		System.out.println("[");
		for (int i = 0; i < thing.length; i++) {
			int zeros = Integer.numberOfLeadingZeros(thing[i]);
			for (int s = 0; s < zeros; s++) {
				System.out.print("0");
			}
			if (thing[i] != 0) {
				System.out.println(Integer.toBinaryString(thing[i]));
			} else {
				System.out.println();
			}
		}
	}

	private static int rShift(int x, int y) {
		if (y > 0) {
			return x << y;
		} else {
			return x >> -y;
		}
	}

}
