//package stray;

import java.util.*;
import java.io.*;

public class ModernArtBronze {
	private static String testinput = "4\n" + "2230\n" + "2737\n" + "2777\n" + "0000";

	/*
	 * 2230 2737 2777 0000
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner s = new Scanner(testinput);
		Scanner s = new Scanner(new File("art.in"));
		int size = s.nextInt();
		int[][] canvas = new int[size][size];
		for (int y = 0; y < size; y++) {
			String line = s.next();
			for (int x = 0; x < size; x++) {
				canvas[x][y] = (int) (line.charAt(x) - '0');
			}
		}
//		System.out.println(Arrays.deepToString(canvas));
		s.close();
		// Calculating bounding boxes
		// x1,y1,x2,y2

		int[][] boxes = new int[9][4];
		for (int i = 0; i < 9; i++) {
			int x1 = 474, y1 = 4872, x2 = -29, y2 = -583;
			for (int x = 0; x < size; x++) {
				for (int y = 0; y < size; y++) {
					if (canvas[x][y] == i + 1) {
						x1 = Math.min(x1, x);
						x2 = Math.max(x2, x);
						y1 = Math.min(y1, y);
						y2 = Math.max(y2, y);

					}
				}
			}
			boxes[i][0] = x1;
			boxes[i][1] = y1;
			boxes[i][2] = x2 + 1;
			boxes[i][3] = y2 + 1;
		}
//		System.out.println(Arrays.deepToString(boxes));

		int count = 0;
		for (int i = 0; i < 9; i++) {
			boolean good = true;
			if (boxes[i][0] == 474) {
				continue;
			}
//			System.out.println("looped");
			for (int j = 0; j < 9; j++) {

				if (j == i) {
					continue;
				}

				for (int x = boxes[j][0]; x < boxes[j][2]; x++) {
					for (int y = boxes[j][1]; y < boxes[j][3]; y++) {
						if (canvas[x][y] == i + 1) {
//							System.out.println("skip " + x + ' ' + y + ' ' + j);
							good = false;
						}
					}
				}

			}
//			good = true;
			if (good) {
				count++;
//				System.out.println("counted");
			}
		}
		System.out.println(count);
		PrintWriter pw = new PrintWriter("art.out");
		pw.println(count);
		pw.close();
	}
}
