package stray;

import java.util.*;
import java.io.*;

public class AngryCows597 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("angry.in"));
		int balesTotal = scan.nextInt();
		int[] bales = new int[balesTotal];
		for (int i = 0; i < balesTotal; i++) {
			bales[i] = scan.nextInt();
		}
		System.out.println("total"+balesTotal);
		scan.close();
		Arrays.sort(bales);
		int Dleft = 0;
		int Dright = 1000000000; //binary search on 2R
		while (Dleft < Dright-1) {
			int Dtest = (Dleft + Dright)/2;
			System.out.println("Checking R: " + Dtest);
			System.out.println(Dleft + " " + Dright);
			int Pleft = 0;
			int Pright = balesTotal;
			while (Pleft < Pright-1) {
				int Ptest = (Pleft + Pright) / 2;
				System.out.println("Checking P: " + Ptest + " for R: " + Dtest);
				System.out.println(Pleft + " " + Pright);
				int walkIndex = Ptest;
				int explodeIndex = Ptest-1;
				int currRad = Dtest-1;
				while(explodeIndex >= 0) {
					if (bales[walkIndex] - bales[explodeIndex] <= currRad) {
						explodeIndex--;
					}else {
						if (walkIndex == explodeIndex + 1) {
							break;
						}
						walkIndex = explodeIndex + 1;
						currRad--;
					}
				}
				if (explodeIndex == -1) {
					Pleft = Ptest;
				} else {
					Pright = Ptest;
				}
			}
			int walkIndex = Pleft;
			while(walkIndex < balesTotal && bales[walkIndex] - bales[Pleft] <= Dtest*2) {
				walkIndex++;
			}
			int explodeIndex = walkIndex+1;
			while(explodeIndex < balesTotal) {
				if (bales[explodeIndex] - bales[walkIndex] <= Dtest) {
					explodeIndex++;
				}else {
					if (walkIndex == explodeIndex-1) {
						break;
					}
					walkIndex = explodeIndex-1;
				}
			}
//			System.out.println("explodeindex" + explodeIndex);
			if (explodeIndex >= balesTotal) {
				Dright = Dtest;
			}else {
				Dleft = Dtest;
			}
			if (Dtest >= 5) {
				Dright = Dtest;
			}else {
				Dleft = Dtest;
			}
			
		}
		System.out.println(Dright);

	}

}
