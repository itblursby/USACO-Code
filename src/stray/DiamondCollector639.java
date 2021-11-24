package stray;

import java.util.*;
import java.io.*;

public class DiamondCollector639 {
	private static String testinput = "5 3\n" + "1\n" + "6\n" + "4\n" + "3\n" + "1";

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan;
//		scan = new Scanner(testinput);
		scan = new Scanner(new File("diamond.in"));
		
		int diamondsTotal = scan.nextInt(); // N
		int sizeDif = scan.nextInt(); // k
		
		int[] diamondSpace = new int[10000]; //histogram of all possible diamonds
		
		for (int i = 0; i < diamondsTotal; i++) {
			int size = scan.nextInt();
			diamondSpace[size - 1]++;
		}
		
		scan.close();
//		int indexDif = sizeDif - 1;
//		System.out.println(Arrays.toString(diamondSpace));
		
		int result = -1;
		for (int i = 0; i < (10000 - sizeDif); i++) {
			int window = 0;
			for (int j = 0; j <= sizeDif; j++) {
				window += diamondSpace[i + j];
//				System.out.println(i + j);
			}
//			System.out.println();
			result = Math.max(result, window);
		}
//		System.out.println(result);
		PrintWriter printer = new PrintWriter("diamond.out");
		printer.println(result);
		printer.close();

	}

}
