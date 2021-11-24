//http://www.usaco.org/index.php?page=viewproblem2&cpid=786

package stray;

import java.util.*;
import java.io.*;

public class Lifeguards786 {
	public static String testinput = "3\n" + "5 9\n" + "1 4\n" + "3 7";
	Scanner s;
	int totalLg; // total lifeguards
	lgEvent786[] events; //POSITIVE FOR ARRIVAL, NEGATIVE FOR BYE BYE
	int[] timeAlone;
	int totalDuty = 0;
	HashSet<Integer> onDuty = new HashSet<Integer>(500);
	public static void main(String[] args) throws FileNotFoundException {
		new Lifeguards786().solve();
	}

	public void solve() throws FileNotFoundException {
//		Scanner s;
//		s = new Scanner(testinput);
		s = new Scanner(new File("lifeguards.in"));
		totalLg = s.nextInt();
		events = new lgEvent786[totalLg *2];
		timeAlone = new int[totalLg];
		
		for (int i = 0; i < totalLg; i++) {
//			int number = 
			timeAlone[i] = 0;
			events[i*2] = new lgEvent786(i,true,s.nextInt());
			events[i*2+1] = new lgEvent786(i,false,s.nextInt());

			
		}
		s.close();
		Arrays.sort(events);
//		System.out.println(Arrays.deepToString(events));
		int lastTime = events[0].time;
		for (int i = 0; i < totalLg*2; i++) {
			if (onDuty.size() > 0) {
				totalDuty += events[i].time - events[i-1].time;
				if (onDuty.size() == 1) {
					for (Integer a : onDuty) {
						timeAlone[a.intValue()] += events[i].time - events[i-1].time;
					}
				}
			}
			if (events[i].arrival) {
				onDuty.add(events[i].lifeguard);
			} else {
				onDuty.remove(events[i].lifeguard);
			}
//			System.out.println(onDuty.size());
		}
		
//		System.out.println("TOTAL TIME" +totalDuty);
//		System.out.println(Arrays.toString(timeAlone));
		int min = Integer.MAX_VALUE;
		for (int i : timeAlone) {
			min = Math.min(min, i);
		}
//		System.out.println(totalDuty - min);
		PrintWriter pw = new PrintWriter("lifeguards.out");
		pw.println(totalDuty - min);
		pw.close();

	}
}
class lgEvent786 implements Comparable{
	public final int lifeguard;
	public final boolean arrival;
	public final int time;
	public lgEvent786(int a, boolean b, int c) {
		lifeguard = a;
		arrival = b;
		time = c;
	}
//	@Override
	public int compareTo(Object other) {
		lgEvent786 o = (lgEvent786) other;
		return this.time - o.time;
	}
	@Override
	public String toString() {
		return "lg" + lifeguard + " " + arrival + "@" + time;
	}
//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
