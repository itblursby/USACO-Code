//package stray;

import java.util.*;
import java.io.*;

public class Moocast668 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("moocast.in"));
		int cowsTotal = scanner.nextInt();
		int[][] cows = new int[cowsTotal][3]; // x,y, power
		for (int i = 0; i < cowsTotal; i++) {
			cows[i][0] = scanner.nextInt();
			cows[i][1] = scanner.nextInt();
			cows[i][2] = scanner.nextInt();
		}
		scanner.close();
//		System.out.println(Arrays.deepToString(cows));
		ArrayList<Integer>[] adjacency = new ArrayList[cowsTotal];
		for (int i = 0; i < cowsTotal; i++) {
			adjacency[i] = new ArrayList<Integer>(cowsTotal);
		}
		for (int i = 0; i < cowsTotal; i++) {
			for (int j = 0; j < cowsTotal; j++) {
				if (j == i) {
					continue;
				}
				if ((cows[j][0] - cows[i][0]) * (cows[j][0] - cows[i][0])
						+ (cows[j][1] - cows[i][1]) * (cows[j][1] - cows[i][1]) <= cows[i][2] * cows[i][2]) {
					adjacency[i].add(j);
				}
			}
		}
//		System.out.println(Arrays.deepToString(adjacency));
		int visitedToken = 1;
		int[] visited = new int[cowsTotal];
		Queue<Integer> queue = new LinkedList<Integer>();
		int maxCows = -1;
		for (int i = 0; i < cowsTotal; i++) {
			int cowsReached = 0;
			queue.add(i);
			while (queue.size() > 0) {
				int other = queue.remove();
				if (visited[other] == visitedToken) {
					continue;
				} else {
					cowsReached++;
					visited[other] = visitedToken;
					for (int j = 0; j < adjacency[other].size(); j++) {
						queue.add(adjacency[other].get(j));
					}
				}
			}
			visitedToken++;
//			System.out.println(cowsReached);

			maxCows = Math.max(maxCows, cowsReached);
		}
		PrintWriter writer = new PrintWriter("moocast.out");
		writer.println(maxCows);
		writer.close();
	}

}
