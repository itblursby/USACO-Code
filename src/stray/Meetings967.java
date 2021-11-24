package stray;

import java.util.*;
import java.io.*;

public class Meetings967 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Meetings967().solve();
		} catch (FileNotFoundException e) {
		}
	}
	public void solve() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("meetings.in"));
		int cowsTotal = scan.nextInt();
		int fieldLength = scan.nextInt();
		int weightTotal = 0;
		Cow[] cows = new Cow[cowsTotal];
		for (int i = 0; i < cowsTotal; i++) {
			cows[i] = new Cow();
			cows[i].weight = scan.nextInt();
			weightTotal += cows[i].weight;
			cows[i].loc = scan.nextInt();
			cows[i].dir = scan.nextInt() == 1;
		}
		scan.close();
		Arrays.sort(cows);
		System.out.println(Arrays.deepToString(cows));
		PrintWriter writer = new PrintWriter("meetings.out");
		writer.close();
		int indexL = 0;
		int indexR = cowsTotal-1;
		int weights = 0;
		int time = -1;
		for (int i = 0; i < cowsTotal && weights*2 < weightTotal; i++) {
			if (!cows[i].dir) {
				weights += cows[indexL].weight;
			} else {
				
			}
		}
	}
	private class Cow implements Comparable<Cow>{
		public int weight;
		public int loc;
		public boolean dir;
		@Override
		public int compareTo(Cow other) {
			return this.loc - other.loc;
		}
		@Override
		public String toString() {
			return "Cow(W"+weight+"L"+loc+"R"+dir+")";
		}
	}

}
