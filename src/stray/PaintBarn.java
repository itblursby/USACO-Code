//PREFIX SUM APPROACH

//package stray;

import java.util.*;
import java.io.*;

public class PaintBarn {
	private static String testinput = "1 2\n" + "0 0 5 5\n";
	private static String testinput2 = "3 2\n"
			+ "1 1 5 5\n"
			+ "4 4 7 6\n"
			+ "3 3 8 7\n"
			+ "";
	private static int length = 1001;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(testinput2);
		Scanner s = new Scanner(new File("paintbarn.in"));

		int rects = s.nextInt();
		int bestCoats = s.nextInt();
		int[][] barnPrefix = new int[length][length];
		for (int i = 0; i < rects; i++) {
			int x1, y1, x2, y2;
			x1 = s.nextInt();
			y1 = s.nextInt();
			x2 = s.nextInt();
			y2 = s.nextInt();
			barnPrefix[x1][y1] += 1;
			barnPrefix[x1][y2] += -1;
			barnPrefix[x2][y1] += -1;
			barnPrefix[x2][y2] += 1;
		}
		
		int[][] barn = new int[length][length];
		barn[0][0] = barnPrefix[0][0];
		for (int x = 1; x < length; x++) {	
			barn[x][0] = barnPrefix[x][0] + barn[x-1][0];
		}
		for (int y = 1; y < length; y++) {
			int delta = 0;
			for (int x = 0; x < length; x++) {
				delta += barnPrefix[x][y];
				barn[x][y] = delta + barn[x][y-1];
			}
		}
		s.close();
		
//		for (int i = 0; i < length; i++) {
//			System.out.println(Arrays.toString(barnPrefix[i]));
//		}
//		System.out.println();
//		for (int i = 0; i < length; i++) {
//			System.out.println(Arrays.toString(barn[i]));
//		}
		int result = 0;
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length; y++) {
				if (barn[x][y] == bestCoats) {
					result++;
				}
			}
		}
//		System.out.println(result);
		PrintWriter pw = new PrintWriter("paintbarn.out");
		pw.println(result);
		pw.close();

	}

}
