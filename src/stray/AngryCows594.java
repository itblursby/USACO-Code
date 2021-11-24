//package stray;

import java.util.*;
import java.io.*;

public class AngryCows594 {
	public static String testinput = "7 2\n" + "20\n" + "25\n" + "18\n" + "8\n" + "10\n" + "3\n" + "1";
	private int balesTotal;
	private int cowsTotal;
	private int[] baleMap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new AngryCows594().solve();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void solve() throws FileNotFoundException {
//		Scanner scan = new Scanner(testinput);
		Scanner scan = new Scanner(new File("angry.in"));
		balesTotal = scan.nextInt();
		cowsTotal = scan.nextInt();
		baleMap = new int[balesTotal];
		for (int i = 0; i < balesTotal; i++) {
			baleMap[i] = scan.nextInt();
		}
		Arrays.sort(baleMap);
//		System.out.println(Arrays.toString(baleMap));
		scan.close();
		int smallrange = -1;
		int bigrange = 1000000005;
		while(bigrange - smallrange > 1) {
			int testrange = (bigrange + smallrange)/2;
//			int currentbale = 0;
			int lastbale = 0;
			int cowsneeded = 1;
			for (int i = 0; i < balesTotal; i++) {
				if (baleMap[i] - baleMap[lastbale] > testrange * 2) {
					cowsneeded++;
					lastbale = i;
//					if (cowsneeded > cowsTotal) {
//						break;
//					}
				}
			}
//			System.out.println("test: " + testrange + ";" + cowsneeded + ";    " + bigrange + ":" + smallrange);
			if (cowsneeded > cowsTotal) {
				smallrange = testrange;
			}else {
				bigrange = testrange;
			}
		}
		int answer = bigrange;
//		System.out.println(answer);
		PrintWriter writer = new PrintWriter("angry.out");
		writer.println(answer);
		writer.close();

	}

}
