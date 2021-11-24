//http://www.usaco.org/index.php?page=viewproblem2&cpid=808

package stray;

import java.util.*;
import java.io.*;

public class Hoofball {

	private static String testinput = "5\n" + "7 1 3 11 4\n" + "";
	private static String testinput2 = "10 1 3 6 8 9 14 15 17 20 25";
	private static String testinput3 = "1 4";
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("hoofball.in"));
//		Scanner s = new Scanner(testinput);
		int N = s.nextInt();

		int[] space = new int[1000];
		for (int i = 0; i < 1000; i++) {
			space[i] = 0; // DEFAULT VALUE
		}
		for (int i = 0; i < N; i++) {
			int cow = s.nextInt();
			space[cow - 1] = -2;
		}
		s.close();

		System.out.println(Arrays.toString(space));
//
		for (int i = 0; i < 1000; i++) {
			if (space[i] != 0) {
				for (int j = 1; j < 1000; j++) {
//					System.out.println(j);
					if (i - j >= 0) {
						if (space[i - j] != 0) {
							space[i] = -1;
							break;
						}
					}
					if (i + j < 1000) {
						if (space[i + j] != 0) {
							space[i] = 1;
							break;
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(space));
		//DETECT LOOPS

		
		int current = 1;
//		int last = 1;
		int index = 0;
		List<Integer> lengths = new ArrayList<Integer>(1000);
		lengths.add(0);
		for (int i = 0; i < 1000; i++) {
			if (space[i] != 0) {
				
				if (space[i] != current) {
					current = space[i];
					index++;
					lengths.add(0);
					
				}
				lengths.set(index, lengths.get(index)+1);


//				System.out.println("-----");
//
//				System.out.println(flag);
//
//				System.out.println(last);
//				System.out.println(i);
				
			}
		}
		System.out.println(lengths);
		int answer = 0;
		for (int i = 0; i < lengths.size()/2; i++) {
			int left = lengths.get(i*2);
			int right = lengths.get(i*2+1);
			if (left == 1 || right == 1) {
				answer += 1;
			}else {
				answer += 2;
			}
		}
//		int loops = (flips+1)/l;
//		System.out.println(loops);
		PrintWriter p = new PrintWriter("hoofball.out");
		if (N <= 2) {
			p.println(1);
		}else {
			p.println(answer);
		}
		System.out.println(answer);
		p.close();
	}

}
