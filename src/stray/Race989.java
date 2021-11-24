//package stray;

import java.util.*;
import java.io.*;

public class Race989 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("race.in"));
		int raceLen = scanner.nextInt();
		int xTotal = scanner.nextInt();
		int[] xVals = new int[xTotal];
		for (int i = 0; i < xTotal; i++) {
			xVals[i] = scanner.nextInt();
		}
		scanner.close();
		PrintWriter writer = new PrintWriter("race.out");
		for (int i = 0; i < xTotal; i++) {
			int tri = tri(xVals[i] - 1);
			if (tri(xVals[i] - 1) >= raceLen) {
				double best = (-1. + Math.sqrt(1. + 8. * raceLen)) / 2.;
				System.out.println((int) Math.ceil(best));
				writer.println((int) Math.ceil(best));

			} else {
//				System.out.println(-1);
				int d = raceLen - tri;
				// (2m+1)x + m^2
				// 2mx+x+m^2 = d
				// m^2+2mx+m-d=0

//				double best = (-2.*xVals[i] + Math.sqrt(4*xVals[i]*xVals[i]-4*(xVals[i]-d)))/2.;
//				double best2 = (-2.*xVals[i] + Math.sqrt(4*xVals[i]*xVals[i]-4*(xVals[i]-d)))/2.;
				int a = 1;
				int b = 4 * xVals[i] - 2;
				int c = 1 - 4 * d;
				double best1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2. * a);
//				a = 1;
				b = 4 * xVals[i] - 2;
				c = -4 * d;
				double best2 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2. * a);

//				writer.println(xVals[i] - 1 + 2 * (int) Math.ceil((best + 1) * .5) - 1);
				int bestw1 = xVals[i] - 1 + 2*(int) Math.ceil((best1 + 1) * .5) - 1;
				int bestw2 = xVals[i] - 1 + 2*(int) Math.ceil((best2) * .5);
//				System.out.print(xVals[i] - 1 + 2*(int) Math.ceil((best1 + 1) * .5) - 1 + " ");
//				System.out.println(xVals[i] - 1 + 2*(int) Math.ceil((best2) * .5));
//				System.out.println(best);
				writer.println(Math.min(bestw1, bestw2));
			}
		}
		writer.close();
	}

	private static int tri(int a) {
		return (a * (a + 1)) >> 1;
	}

}
