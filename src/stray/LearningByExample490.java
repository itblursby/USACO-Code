//package stray;

import java.util.*;
import java.io.*;

public class LearningByExample490 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("learning.in"));
		int cowsTotal = scanner.nextInt();
		int low = scanner.nextInt();
		int high = scanner.nextInt()+1;
//		int[] weights = new int[cowsTotal];
//		boolean[] spots = new boolean[cowsTotal];
		Cow[] cows = new Cow[cowsTotal + 2];
		for (int i = 0; i < cowsTotal; i++) {
			cows[i] = new Cow();
			cows[i].spots = scanner.next().length() == 1;
			cows[i].weight = scanner.nextInt();
		}
		cows[cowsTotal] = new Cow();
		cows[cowsTotal].spots = false;
		cows[cowsTotal].weight = Integer.MIN_VALUE;
		cows[cowsTotal + 1] = new Cow();
		cows[cowsTotal + 1].spots = false;
		cows[cowsTotal + 1].weight = Integer.MAX_VALUE;
		scanner.close();
		Arrays.sort(cows, new Comparator<Cow>() {
			public int compare(Cow a, Cow b) {
				return (a.weight > b.weight) ? 1 : -1;
			}
		});
//		System.out.println(Arrays.deepToString(cows));
		int answer = 0;
		for (int i = 0; i < cows.length - 1; i++) {
			if (cows[i].spots && cows[i + 1].spots) {
//				System.out.println(overlap(low, high, cows[i].weight, cows[i + 1].weight));
				answer += overlap(low, high, cows[i].weight, cows[i + 1].weight);
				continue;
			} else if ((!cows[i].spots) && (!cows[i + 1].spots)) {
				continue;
			} else {
				int middle = (int) (((long) cows[i].weight + (long) cows[i + 1].weight) / 2l);
//				System.out.println("mid: " + middle);
				if ((cows[i].weight % 2 + cows[i+1].weight % 2) % 2 == 0) {
					if (cows[i].spots) {
//						System.out.println("A");

//						System.out.println(overlap(low, high, cows[i].weight, middle + 1));
						answer += overlap(low, high, cows[i].weight, middle + 1);
					} else {
//						System.out.println("B");

//						System.out.println(overlap(low, high, middle, cows[i + 1].weight));
						answer += overlap(low, high, middle, cows[i + 1].weight);
					}
				}else {
//					System.out.println("doop");
					if (cows[i].spots) {
//						System.out.println("C");

//						System.out.println(overlap(low, high, cows[i].weight, middle + 1));
						answer += overlap(low, high, cows[i].weight, middle + 1);
					} else {
//						System.out.println("D:"+overlap(low, high, middle, cows[i + 1].weight));
//						System.out.println("D");
						answer += overlap(low, high, middle+1, cows[i + 1].weight);
					}
				}
			}
//			System.out.println(answer);
		}
		PrintWriter writer = new PrintWriter("learning.out");
		writer.println(answer);
		writer.close();

	}

	private static int overlap(int left1, int right1, int left2, int right2) {
		return Math.max(0, Math.min(right1, right2) - Math.max(left1, left2));
	}

	private static class Cow {
		public boolean spots;
		public int weight;

		@Override
		public String toString() {
			return "(" + weight + "," + spots + ")";
		}

	}
}
