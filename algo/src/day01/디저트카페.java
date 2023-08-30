package day01;


import java.io.*;
import java.util.*;


public class 디저트카페 {
	static int T, N;
	static int[][] map;
	static int ans = -1;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int startR, startC;

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(디저트카페.class.getResourceAsStream("1.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = -1;
			N = sc.nextInt();
			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			//print(map);
			// solving
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					startR = r;
					startC = c;
					boolean[][] v = new boolean[N][N];
					v[r][c]=true;
					boolean[] dessert = new boolean[100+1];
					dessert[map[r][c]] = true;
					
					dfs(r, c,dessert,v,1,0);
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}

	
	private static void dfs(int r, int c, boolean[] dessert, boolean[][] v, int cnt, int sd) {
		// 갈수 있는데 까지 쭉간다
		// 지도의 경계이거나 
		// 먹었던 디저트가 나오면 방향전환
		// 언제까지 시작점이 나오거나 더이상 갈수없을때 까지
		for(int d = sd; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dr[d];
			
			if(nr<0||nr>=N|| nc<0||nc>=N) continue;
			
			//현재 위치가 출발점과 같다면 도착
			if(nr==startR&&nc==startC&&cnt>2){
				ans = Math.max(ans, cnt);
				return;
			}
			//한번 지나간 길은 다시 갈 수 없다.
			if(v[nr][nc])continue;
			
			//한번 먹어본 디저트가 또 나오면 더 이상 갈 수 없다.
			if(dessert[map[nr][nc]])continue;
			
			v[nr][nc] = true;
			dessert[map[nr][nc]] = true;
			dfs(nr,nc,dessert,v,cnt+1,d);
			v[nr][nc] = false;
			dessert[map[nr][nc]] = false;
		}
	}


	private static void print(boolean[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	private static void print(int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
