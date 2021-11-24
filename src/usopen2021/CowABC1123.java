package usopen2021;

import java.util.Arrays;
import java.util.Scanner;

public class CowABC1123 {
	private static String testinput = "10\n" + "7\n" + "1 2 3 4 5 6 7\n" + "4\n" + "4 5 7 8\n" + "4\n" + "4 5 7 9\n"
			+ "4\n" + "4 5 7 10\n" + "4\n" + "4 5 7 11\n" + "4\n" + "4 5 7 12\n" + "4\n" + "4 5 7 13\n" + "4\n"
			+ "4 5 7 14\n" + "4\n" + "4 5 7 15\n" + "4\n" + "4 5 7 16";

	private int N;
	private int count = -1;
	private int[] numbers = new int[7];
	private int[] numbers2 = new int[7];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CowABC1123().solve();

	}

	private void solve() {
		Scanner s = new Scanner(testinput);
		N = s.nextInt();
		for (int i = 0; i < N; i++) {
			count = s.nextInt();
			for (int j = 0; j < count; j++) {
				numbers[j] = s.nextInt();
			}
			System.out.println("------");
			
			System.out.println(count);
			System.out.println(Arrays.toString(numbers));
			System.out.println(solveArr());
		}
		s.close();
	}

	private int solveArr() {
		for (int i = 0; i < 7; i++) {
			numbers2[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < count; i++) {
			numbers2[i] = numbers[i];
		}
		Arrays.sort(numbers2);
		System.out.println(Arrays.toString(numbers2));
		int max = numbers2[count-1];
		return 0;
	}

}
