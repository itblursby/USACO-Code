package stray;

import java.util.*;
import java.io.*;

public class BerryPicking990 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new BerryPicking990().solve();
	}
	public void solve() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("berries.in"));
		int treesTotal = scan.nextInt();
		int baskets = scan.nextInt();
		scan.close();
		PrintWriter writer = new PrintWriter("berries.out");
		writer.close();
	}

}
