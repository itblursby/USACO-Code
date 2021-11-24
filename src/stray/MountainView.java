//package stray;

import java.util.*;
import java.io.*;

public class MountainView {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("mountains.in"));
		int mountainsTotal = s.nextInt();
		int[][] mountains = new int[mountainsTotal][2];
		for (int i = 0; i < mountainsTotal; i++) {
			mountains[i][0] = s.nextInt();
			mountains[i][1] = s.nextInt();
		}
		s.close();
		Arrays.sort(mountains, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
//		System.out.println(Arrays.deepToString(mountains));
		LinkedList<Integer> stack = new LinkedList<Integer>();
		// addFirst(Integer a)
		// peek()
		// remove()
		for (int i = 0; i < mountainsTotal; i++) {
			int xc = mountains[i][0];
			int yc = mountains[i][1];
			if (stack.size() == 0) {
				stack.addFirst(i);
				continue;
			}
			int top = stack.peek().intValue();
			int x1 = mountains[top][0];
			int y1 = mountains[top][1];
			if (!overlapR(x1, y1, xc, yc)) {
				while (stack.size() > 0) {
					top = stack.peek().intValue();
					x1 = mountains[top][0];
					y1 = mountains[top][1];
					if (overlapL(x1,y1,xc,yc)) {
						stack.pop();
					}else {
						break;
					}
				}
				stack.addFirst(i);
			}
		}

		PrintWriter pw = new PrintWriter("mountains.out");
		pw.println(stack.size());
		pw.close();
	}

	// assumption: x1 <= x2
	private static boolean overlapR(int x1, int y1, int x2, int y2) {
		return y2 <= (y1 - (x2 - x1));
	}

	// assumption: x1 <= x2
	private static boolean overlapL(int x1, int y1, int x2, int y2) {
		return y2 >= (y1 + (x2 - x1));
	}

}
