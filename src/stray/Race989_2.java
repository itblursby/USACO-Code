//package stray;

import java.io.*;
import java.util.*;

public class Race989_2 {

	public static void main(String[] args) throws Exception{
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
			int x = xVals[i];
			int dist = 0;
			int t = 0;
			for (int j = 1; j < x; j++) {
				dist+=j;
				t++;
				if (dist >= raceLen) {
					writer.println(t);
					break;
				}
			}
			int s = x;
			while(true && dist < raceLen) {
				dist += s;
				t++;
				if (dist >= raceLen) {
					writer.println(t);
					break;
				}
				dist += s;
				t++;
				if (dist >= raceLen) {
					writer.println(t);
					break;
				}
				s++;
			}
		}
		writer.close();
	}

}
