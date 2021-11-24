//package stray;

import java.util.*;
import java.io.*;

public class Censoring526 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("censor.in"));
		String word = scanner.next();
		char[] target = scanner.next().toCharArray();
		Letter sentinel = new Letter('.');
		Letter traveler = sentinel;
//		sentinel.next = traveler;
//		traveler.
		for (int i = 0; i < word.length(); i++) {
			traveler.next = new Letter(word.charAt(i));
			traveler.next.prev = traveler;
			traveler = traveler.next;
		}
		traveler.next = sentinel;
		sentinel.prev = traveler;

		scanner.close();
		traveler = sentinel.next;
//		System.out.println(word);
		while (traveler != sentinel) {
			Letter traveler2 = traveler;
			boolean found = true;
			for (int i = 0; i < target.length; i++) {
				if (traveler2.letter != target[i]) {
					found = false;
					break;
				} else {
					traveler2 = traveler2.next;
				}
			}
			if (found) {
				traveler = traveler.prev;
				traveler.next = traveler2;
				traveler2.prev = traveler;
//				System.out.println
//				Letter traveler3 = sentinel.next;
//				while (traveler3 != sentinel) {
////					System.out.print(traveler3.letter);
//					traveler3 = traveler3.next;
//				}
//				System.out.println();
				for (int i = 0; i < target.length - 1 && traveler != sentinel; i++) {
					traveler = traveler.prev;
				}
			}
			traveler = traveler.next;
		}
		traveler = sentinel.next;
		PrintWriter writer = new PrintWriter("censor.out");
		while (traveler != sentinel) {
			writer.print(traveler.letter);
			traveler = traveler.next;
		}
		writer.println();
		writer.close();

	}

	private static class Letter {
		public Letter prev;
		public Letter next;
		public char letter;

		public Letter(char a) {
			this.letter = a;
		}
	}
}
