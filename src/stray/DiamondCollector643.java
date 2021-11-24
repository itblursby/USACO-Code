package stray;

import java.util.*;
import java.io.*;

public class DiamondCollector643 {
	private static String testinput = "7 3\n" + "10\n" + "5\n" + "1\n" + "12\n" + "9\n" + "5\n" + "14";
	private int[] diamonds;
	private int[] maxWindow;
	private int[] windows1max;
	private int diamondsTtl;
	private int sizeDif;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new DiamondCollector643().solve();

	}

	public void solve() throws FileNotFoundException {
		Scanner s;
		s = new Scanner(new File("diamond.in"));
//		s = new Scanner(testinput);
		int diamondsTtl = s.nextInt();
		int sizeDif = s.nextInt();
		diamonds = new int[diamondsTtl];
		maxWindow = new int[diamondsTtl];
		windows1max = new int[diamondsTtl];
		for (int i = 0; i < diamondsTtl; i++) {
			diamonds[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(diamonds);
		System.out.println(diamondsTtl);
		System.out.println(sizeDif);
		int begin = 0;
		int end = 0;
		while(begin < diamondsTtl) {
			while(end < diamondsTtl && diamonds[end] - diamonds[begin] <= sizeDif) {
				end++;
			}
			maxWindow[begin] = end-begin;
			begin++;
			
		}
		windows1max[diamondsTtl-1] = maxWindow[diamondsTtl-1];
		for(int i = diamondsTtl-2; i >= 0; i--) {
			windows1max[i] = Math.max(maxWindow[i],windows1max[i+1]);
			
		}
		int max = -48;
		for (int i = 0; i < diamondsTtl; i++) {
			if (i + maxWindow[i] >= diamondsTtl) {
				max = Math.max(max, maxWindow[i]);
			} else {
				max = Math.max(max, maxWindow[i] + windows1max[i + maxWindow[i]]);
			}
		}
		System.out.println(Arrays.toString(diamonds));
		System.out.println(Arrays.toString(maxWindow));
		System.out.println(Arrays.toString(windows1max));
		System.out.println(max);
		PrintWriter pw = new PrintWriter("diamond.out");
			pw.println(max);
		pw.close();


	}

}
