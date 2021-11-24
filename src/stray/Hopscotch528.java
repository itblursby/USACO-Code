//package stray;

import java.util.*;
import java.io.*;

public class Hopscotch528 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("hopscotch.in"));
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		int[][] ways = new int[rows][cols];
		ways[0][0] = 1;
		boolean[][] reds = new boolean[rows][cols];
		for (int r = 0; r < rows; r++) {
			String line = scanner.next();
			for (int c = 0; c < cols; c++) {
				reds[r][c] = (line.charAt(c) == 'R');
			}
		}
		scanner.close();
//		System.out.println(Arrays.deepToString(color));
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				for (int r2 = r+1; r2 < rows; r2++) {
					for (int c2 = c+1; c2 < cols; c2++) {
						if (reds[r][c] ^ reds[r2][c2]) {
							ways[r2][c2] += ways[r][c];
						}
					}
				}
			}
		}
		PrintWriter writer = new PrintWriter("hopscotch.out");
		writer.println(ways[rows-1][cols-1]);
		writer.close();
		System.out.println(":)");
		
	}

}
