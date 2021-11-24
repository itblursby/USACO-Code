import java.util.*;
import java.io.*;

public class Censoring526_2 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("censor.in"));
		String raw = scanner.next();
		String badword = scanner.next();
		ArrayList<Character> filtered = new ArrayList<Character>(raw.length());
		for (int i = 0; i < raw.length(); i++) {
			filtered.add(raw.charAt(i));
			if (filtered.size() >= badword.length()) {
				boolean detected = true;

				for (int j = 0; j < badword.length(); j++) {
					if (filtered.get(j + filtered.size() - badword.length()) != badword.charAt(j)) {
						detected = false;
						break;
					}
				}
				if (detected) {
					for (int j = 0; j < badword.length(); j++) {
						filtered.remove(filtered.size() - 1);
					}
				}
			}
		}
		PrintWriter writer = new PrintWriter("censor.out");
		for (int i = 0; i < filtered.size(); i++) {
			writer.print(filtered.get(i).charValue());
		}
		writer.print("\n");
		writer.close();
	}

}
