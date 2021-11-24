//package stray;

import java.util.*;
import java.io.*;

public class BlockedBillboard {
	private static String testinput = "1 2 3 5\n"
			+ "6 0 10 4\n"
			+ "2 1 8 3";
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("billboard.in"));
//		Scanner s = new Scanner(testinput);
		int x1,y1,x2,y2,x3,y3,x4,y4,sx1,sy1,sx2,sy2;
		x1 = s.nextInt() + 1000;
		y1 = s.nextInt()+ 1000;
		x2 = s.nextInt()+ 1000;
		y2 = s.nextInt()+ 1000;
		x3 = s.nextInt()+ 1000;
		y3 = s.nextInt()+ 1000;
		x4 = s.nextInt()+ 1000;
		y4 = s.nextInt()+ 1000;
		sx1 = s.nextInt()+ 1000;
		sy1 = s.nextInt()+ 1000;
		sx2 = s.nextInt()+ 1000;
		sy2 = s.nextInt()+ 1000;
		int[][] space = new int[2000][2000];
		s.close();
		for (int x = x1; x < x2; x++) {
			for (int y = y1; y < y2; y++) {
				space[x][y] = 1;
			}
		}
		for (int x = x3; x < x4; x++) {
			for (int y = y3; y < y4; y++) {
				space[x][y] = 1;
			}
		}
		for (int x = sx1; x < sx2; x++) {
			for (int y = sy1; y < sy2; y++) {
				space[x][y] = 0;
			}
		}
		int count = 0;
		for (int x = 0; x < 2000; x++) {
			for (int y = 0; y < 2000; y++) {
				count += space[x][y];
			}
		}
		System.out.println(count);
		PrintWriter pw = new PrintWriter("billboard.out");
		pw.println(count);
		pw.close();
		
		
	}

}
