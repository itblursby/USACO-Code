package stray;

import java.util.*;
import java.io.*;

public class MooBuzz966 {
	private final static int[] numbers = new int[] { 1, 2, 4, 7, 8, 11, 13, 14 };

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int N = 1;
		Scanner s = new Scanner(new File("moobuzz.in"));
		N = s.nextInt();
		s.close();
		N -= 1;
//		N = 0;
//		for (N = 0; N < 100; N++) {
		System.out.println(N / 8 * 15 + numbers[N % 8]);
//		}
		PrintWriter pw = new PrintWriter("moobuzz.out");
		pw.println(N / 8 * 15 + numbers[N % 8]);
		pw.close();

	}

}
