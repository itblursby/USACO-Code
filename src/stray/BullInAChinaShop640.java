package stray;

import java.util.*;
import java.io.*;

public class BullInAChinaShop640 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("bcs.in"));
		int size = scanner.nextInt();
		int pieces = scanner.nextInt();
		scanner.nextLine();
		int[] figurine = new int[8];
		for (int y = 0; y < size; y++) {
			String line = scanner.nextLine();
//			System.out.println(line);
			for(int x = 0; x < size; x++) {
				if (line.charAt(x) == '#') {
					figurine[y] = figurine[y] | (1 << x);
				}
			}
			System.out.println(binStr(figurine[y]));
		}
		int[][] pieces = new int


		
		scanner.close();
		PrintWriter writer = new PrintWriter("bcs.out");
		writer.close();
	}
	private static String binStr(int n) {
		String output = "";
		for (int i = 0; i < 32; i++) {
			output = output + ((n & (1 << (31-i))) >> (31-i));
		}
		return output;
	}

}
