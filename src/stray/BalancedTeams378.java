package stray;

import java.util.*;
import java.io.*;

public class BalancedTeams378 {

	private static int[] skills;
	private static int totalTrials = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("bteams.in"));
		int[] skills = new int[12];
		for (int i = 0; i < 12; i++) {
			skills[i] = scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(skills);
		int[][] teams = new int[4][3];
		int[] teamindexes = new int[4];
//		PrintWriter writer = new PrintWriter("bteams.out");
//		writer.println(solve(teams,teamindexes,skills,0));
//		writer.close();
		System.out.println(solve(teams,teamindexes,skills,0));
		System.out.println(totalTrials);


	}

	private static int solve(int[][] teams, int[] teamindexes, int[] skills, int current) {
		if (current == 12) {
			totalTrials++;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				int sum = teams[i][0] + teams[i][1] + teams[i][2];
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			return max - min;
		} else {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				if (teamindexes[i] < 3) {
					teams[i][teamindexes[i]] = skills[current];
					teamindexes[i]++;
					min = Math.min(min, solve(teams,teamindexes,skills,current+1));
					teamindexes[i]--;
				}
			}
			return min;
		}
//		return -1;
	}

}
