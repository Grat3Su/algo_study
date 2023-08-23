package algo.a0821.add;

import java.util.*;
import java.io.*;

public class sw_0823_4013_magnet {
	static int[][] a = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
					int n = Integer.parseInt(st.nextToken()) - 1;// 인덱스화
					int d = Integer.parseInt(st.nextToken());// 1 : 시계 -1 : 반시계\
					int[] dir = new int[4];
					dir[n] = d;
					for (int r = n; r < 3; r++) {// 우측
						if (a[i][2] != a[i + 1][6]) {// 9시 방향
							/////
							if (a[i + 1][2] != a[i + 1][6]) {// 9시 방향
								dir[i + 1] = -dir[i];
							}
							if (a[i][2] != a[i + 1][6]) {// 9시 방향
								dir[i + 1] = -dir[i];
							}
							if (a[i][2] != a[i + 1][6]) {// 9시 방향
								dir[i + 1] = -dir[i];
							}
						}
					}
				}

				sb.append("#").append(t + 1).append(1 * a[0][0] + 2 * a[1][0] + 4 * a[2][0] + 8 * a[3][0]).append("\n");
				br.close();
			}
		}

	}

	static void rotate(int n, int d) {
		if (d == 1) {//시계 : 0 1 2 3 4 5 6 7 -> 7 0 1 2 3 4 5 6
			int T =a[n][7];
			for(int i = 7; i>0; i--) a[n][i] = a[n][i-1];
			a[n][0] = T;//백업한거 받기
		} else {//반시계 : 1 2 3 4 5 6 7 0
			int T =a[n][7];
			for(int i = 0; i<8; i++) a[n][i] = a[n][i-1];
			a[n][0] = T;//백업한거 받기
		}
	}

}
