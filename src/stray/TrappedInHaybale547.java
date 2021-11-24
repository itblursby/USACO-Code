//package stray;

import java.util.*;
import java.io.*;

public class TrappedInHaybale547 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("trapped.in"));
		int balesTotal = scanner.nextInt();
		int[][] bales = new int[balesTotal][2]; // pos, size
		for (int i = 0; i < balesTotal; i++) {
			bales[i][1] = scanner.nextInt();
			bales[i][0] = scanner.nextInt();
		}
		scanner.close();
//		for (int )
		Arrays.sort(bales, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		int answer = 0;
		for (int i = 0; i < balesTotal - 1; i++) {
			int left = i;
			int right = i + 1;
			while (left >= 0 && right < balesTotal) {
				int distance = bales[right][0] - bales[left][0];
				if (distance > bales[left][1]) {
					left--;
				} else if (distance > bales[right][1]) {
					right++;
				} else {
					break;
				}
			}
			if (left >= 0 && right < balesTotal) {
				answer += bales[i + 1][0] - bales[i][0];
			}
		}
		PrintWriter writer = new PrintWriter("trapped.out");
		writer.println(answer);
		writer.close();

	}
}
