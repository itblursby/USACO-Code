package usopen2021;

import java.util.*;

public class MazeTacToe1122 {
	private static String testinput = "7\n" + "#####################\n" + "###O11###...###M13###\n"
			+ "###......O22......###\n" + "###...######M22######\n" + "###BBB###M31###M11###\n"
			+ "###...O32...M33O31###\n" + "#####################";
	private Cell[][] grid;
	private int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MazeTacToe1122().solve();
	}

	public void solve() {
		Scanner s = new Scanner(testinput);
		N = s.nextInt();
		grid = new Cell[N][N];
		Cell bessie;
		for (int i = 0; i < N; i++) {
			String line = s.next();
			for (int j = 0; j < N; j++) {
				String sub = line.substring(j * 3, j * 3 + 3);
				Cell c = new Cell(sub);
				if (sub.equals("BBB")) {
					bessie = c;
				}
				grid[i][j] = c;
			}
		}
		System.out.println(Arrays.deepToString(grid));
		s.close();
	}

}

class Cell {
	static final int WALL = 0;
	static final int MOVE = 1;
	static final int EMPTY = 2;
	Cell left;
	Cell right;
	Cell down;
	Cell up;
	int state;
	char moveMO;
	int x, y;

	public Cell(String move) {
		if (move.equals("###")) {
			this.state = WALL;
		} else if (move.equals("BBB") || move.equals("...")) {
			this.state = EMPTY;
		} else {
			this.state = MOVE;
			moveMO = move.charAt(0);
			x = move.charAt(1) - '0';
			y = move.charAt(2) - '0';
		}
	}

	@Override
	public String toString() {
		switch (state) {
		case (WALL):
			return "###";
		case (MOVE):
			return Character.toString(moveMO) + x + y;
		default:
			return "...";
		}
	}
}

class Ttp {
	static final int DEAD = 0;
	static final int CONTINUE = 1;
	static final int WIN = 2;
	char[] board = new char[9];

	/*
	 * 0 1 2 3 4 5 6 7 8
	 * 
	 * values are -1 for nothing 0 for M, 1 for O
	 */
	Ttp() {
		for (int i = 0; i < 9; i++) {
			board[i] = '.';
		}
	}

	int add(char a, int b, int c) {
		board[3*c+b] = a;
		if ()
	}

	public String toString() {
		return "" + board[0] + board[1] + board[2] + "\n" + board[3] + board[4] + board[5] + "\n" + board[6] + board[7]
				+ board[8];
	}
	boolean evalWin(int x, int y) {
		int index = x + 3 * y;
		if (board[0+y*3] == 'M' && board[1+y*3] == 'O' && board[2+y*3] == 'O') {
			return true;
		}
		if (board[0+y*3] == 'O' && board[1+y*3] == 'O' && board[2+y*3] == 'M') {
			return true;
		}
		return false;
	}
	boolean evalDead() {
		boolean dead = true;
		for (int i = 0; i < 3; i++) {
			if (!(board[i*3+0] == board[i*3+2] && (board[i*3+0] == 'M' || board[i*3+0] == 'O')) && !(board[i*3+1] == 'M')) {
				return false;
			}
			if (!(board[i] == board[6+i] && board[i] == 'M' || board[i+6] == 'O') && !(board[3+1] == 'M')) {
				return false;
			}
		}
		if (!(board[0] == board[8] || ) && !(board[4] == 'M')){
			return false;
		}

		if (!(board[2] == board[4]) && !(board[6] == 'M')){
			return false;
		}
		return true;
		
	}
}
