//package stray;

import java.util.*;
import java.io.*;

public class Cownvention {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("convention.in"));
		int cowsTotal = scanner.nextInt();
		int busesTotal = scanner.nextInt();
		int busCapacity = scanner.nextInt();
//		cowsTotal = 7
		int[] cows = new int[cowsTotal];
		for (int i = 0; i < cowsTotal; i++) {
			cows[i] = scanner.nextInt();
		}
//		System.out.println("total bales: " + balesTotal);
//		System.out.println("total cows: " + cowsTotal);
		Arrays.sort(cows);
//		System.out.println(Arrays.toString(cows));

		scanner.close();
//		System.out.println(Arrays.toString(bales));
		int leftWait = -1;
		int rightWait = 1500000000;
//		left = 9;
//		right = 11;
		while (leftWait < rightWait - 1) {
			int middleWait = (leftWait + rightWait) / 2;
			int numBuses = 1;
			int passengers = 0;
			int lastCow = 0;
			int cowIndex = 0;
			for (; cowIndex < cowsTotal && numBuses <= busesTotal; cowIndex++) {
				
				if (cows[cowIndex] - cows[lastCow] <= middleWait && passengers < busCapacity) {
					passengers += 1;
				}else {
					numBuses++;
					passengers = 0;
					lastCow = cowIndex;
					cowIndex--;
				}
//				System.out.println(baleIndex + " " + lastBale);
			}
//			System.out.println(middle + " " + baleIndex);
			if (cowIndex == cowsTotal && numBuses <= busesTotal) {
				rightWait = middleWait;
			}else {
				leftWait = middleWait;
			}
			
		}
		
		PrintWriter writer = new PrintWriter("convention.out");
		writer.println(rightWait);
		writer.close();
//		System.out.println(rightWait);
	}

}
