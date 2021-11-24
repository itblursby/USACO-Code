//package usopen2021;

import java.util.Arrays;
import java.util.Scanner;

public class Acowdemia1124 {
	public static String testinput = "4 4 1\n" + "1 100 1 1";
	private int PAPERS;
	private int SURVEYS;
	private int CITES;
	private int[] papers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Acowdemia1124().solve();
		// System.out.println("ASDLJALSDKJ";)
	}

	private void solve() {
//		Scanner s = new Scanner(testinput);
		 Scanner s = new Scanner(System.in);

		PAPERS = s.nextInt();
		SURVEYS = s.nextInt();
		CITES = s.nextInt();
		papers = new int[PAPERS];
		for (int i = 0; i < PAPERS; i++) {
			papers[i] = s.nextInt();
		}
		Arrays.sort(papers);
		int maxH = PAPERS + 1;
		int minH = 0;

		s.close();
		while (maxH > minH + 1) {
//			System.out.println("-----------");
//			System.out.println(minH);
//			System.out.println(maxH);
			int testH = (maxH + minH) / 2;
			int citesneeded = 0;
			int needed = 0;
			for (int i = papers.length - 1; i >= (papers.length - testH) && i >= 0; i--) {
				if (testH <= papers[i]) {
					continue;
				}
				needed++;
				citesneeded += testH - papers[i];

			}
//			System.out.println(testH);
//			System.out.println(citesneeded);
			//if (needed >= SURVEYS) {
				if (citesneeded > SURVEYS * Math.min(CITES, needed)) {
					maxH = testH;
					continue;
				}
				if (testH-papers[papers.length - testH] > SURVEYS) {
					maxH = testH;
					continue;
				}
			//}
			
			minH = testH;
		}
		System.out.println(minH);
	}

}
