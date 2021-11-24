//package stray;

import java.util.*;
import java.io.*;

public class MooParticle {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("moop.in"));
		int particlesTotal = scanner.nextInt();
		int[][] particles = new int[particlesTotal][2];
		for (int i = 0; i < particlesTotal; i++) {
			particles[i][0] = scanner.nextInt();
			particles[i][1] = scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(particles, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				}
				return a[1] - b[1];
			}
		});
		System.out.println(Arrays.deepToString(particles));
		LinkedList<Integer> maxs = new LinkedList<Integer>();
		LinkedList<Integer> mins = new LinkedList<Integer>();
		for (int i = 0; i < particlesTotal; i++) {
			maxs.addFirst(particles[i][1]);
			mins.addFirst(particles[i][1]);
//			System.out.println("---");
//			System.out.println(maxs);
//			System.out.println(mins);

			while (maxs.size() >= 2) {
				int maxcur1 = maxs.get(0);
				int maxcur2 = maxs.get(1);
				int mincur1 = mins.get(0);
				int mincur2 = mins.get(1);
				if (mincur2 <= maxcur1) {
					maxs.pop();
					mins.pop();
					maxs.set(0, Math.max(maxcur1, maxcur2));
					mins.set(0, Math.min(mincur1, mincur2));
//					System.out.println("---");
//					System.out.println(maxs);
//					System.out.println(mins);
				} else {
					break;
				}
			}
		}
		PrintWriter writer = new PrintWriter("moop.out");
		writer.println(maxs.size());
		writer.close();
	}

}
