//package stray;

import java.util.*;
import java.io.*;

public class JustStalling1085 {
	private static String testinput = "4\n"
			+ "1 2 3 4\n"
			+ "2 4 3 4";
	public static void main(String[] args) throws Exception{
//		Scanner scanner = new Scanner(testinput);
		Scanner scanner = new Scanner(System.in);
		int cowsTotal = scanner.nextInt();
		int[] cows = new int[cowsTotal];
		int[] stalls = new int[cowsTotal];
		for (int i = 0; i < cowsTotal; i++) {
			cows[i] = scanner.nextInt();
		}
		for (int i = 0; i < cowsTotal; i++) {
			stalls[i] = scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(cows);
		Arrays.sort(stalls);

		long answer = 1;
		int eligible = 0;
		for (int i = 0; i < cowsTotal; i++) {
			while(eligible < cowsTotal && cows[eligible] <= stalls[i]) {
				eligible++;
			}
			answer *= (long)(eligible - i);
		}
		System.out.println(answer);
			

	}

}
