package stray;

import java.util.*;
import java.io.*;

public class AngryCows594_2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("angry.in"));
		int balesTotal = scanner.nextInt();
		int cowsTotal = scanner.nextInt();
//		cowsTotal = 7
		int[] bales = new int[balesTotal];
		for (int i = 0; i < balesTotal; i++) {
			bales[i] = scanner.nextInt();
		}
//		System.out.println("total bales: " + balesTotal);
//		System.out.println("total cows: " + cowsTotal);

		Arrays.sort(bales);
		scanner.close();
//		System.out.println(Arrays.toString(bales));
		int left = -1;
		int right = 500000001;
//		left = 9;
//		right = 11;
		while (left < right - 1) {
			int middle = (left + right) / 2;
			int numCows = 1;
			int lastBale = 0;
			int baleIndex = 0;
			for (; baleIndex < balesTotal && numCows <= cowsTotal; baleIndex++) {
				
				if (bales[baleIndex] - bales[lastBale] <= 2*middle) {
					
				}else {
					numCows++;
					lastBale = baleIndex;
				}
//				System.out.println(baleIndex + " " + lastBale);
			}
//			System.out.println(middle + " " + baleIndex);
			if (baleIndex == balesTotal && numCows <= cowsTotal) {
				right = middle;
			}else {
				left = middle;
			}
			
		}
		
		PrintWriter writer = new PrintWriter("angry.out");
		writer.println(right);
		writer.close();
//		System.out.println(right);
	}

}
