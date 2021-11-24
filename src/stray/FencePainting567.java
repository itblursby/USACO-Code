//http://www.usaco.org/index.php?page=viewproblem2&cpid=567

package stray;

import java.util.*;
import java.io.*;

public class FencePainting567 {
	final static String input = "7 10 4 8";
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("paint.in"));
//		Scanner s = new Scanner(input);
		int a,b,c,d;
		a = s.nextInt();
		b = s.nextInt();
		c = s.nextInt();
		d = s.nextInt();
		s.close();
		PrintWriter pw = new PrintWriter("paint.out");
		if ((b < c) || (a > d)) {
			pw.println(d-c + b-a);
//			System.out.println(d-c + b-a);
		}else  {
			int begin = Math.max(a,c);
			int end = Math.min(b,d);
			pw.println(d-c+b-a - (end - begin));
//			System.out.println(d-c+b-a - (end - begin));

		}
		pw.close();
		
	}

}
