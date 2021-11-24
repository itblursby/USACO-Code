package stray;

import java.util.*;
import java.io.*;

public class CowRouting512_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("cowroute.in"));
		int start = scanner.nextInt() - 1;
		int end = scanner.nextInt() - 1;
		int routesTotal = scanner.nextInt();
		long[][] costsflights = new long[1000][1000]; // [src][dst] costs * 100000 + flights
		int[] temproute = new int[1000];
		for (int i = 0; i < routesTotal; i++) {
			int cost = scanner.nextInt();
			int cities = scanner.nextInt();
//			System.out.println()
			for (int j = 0; j < cities; j++) {
				temproute[j] = scanner.nextInt() - 1;
				System.out.print(temproute[j] + ",");
			}
			System.out.println();
			for (int src = 0; src < cities; src++) {
				for (int dst = src + 1; dst < cities; dst++) {
					long currentcost = costsflights[temproute[src]][temproute[dst]] / 100000;
					long currentflights = costsflights[temproute[src]][temproute[dst]] % 100000;
					if (cost < currentcost || (cost == currentcost && (dst-src) < currentflights) || costsflights[src][dst] == 0l) {
						costsflights[temproute[src]][temproute[dst]] = cost * 100000 + (dst - src);
						System.out.println("[" + temproute[src] + "," + temproute[dst] + "]:" + cost + ":" + (dst-src));
//						System.out.println()
					}
				}
			}
			System.out.print("\n");
		}
//		System.out.println(Arrays.deepToString(costsflights));
		scanner.close();
		System.out.println(costsflights[0][4]);
	}

}
