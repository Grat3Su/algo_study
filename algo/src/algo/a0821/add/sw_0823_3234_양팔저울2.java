package algo.a0821.add;

import java.io.*;
import java.util.*;

public class sw_0823_3234_양팔저울2 {
	static int N, result;
	static int[] weight, arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(t + 1).append(" ").append(result).append("\n");
		}


		br.close();
	}
	static void perm(int cnt) {
		if(cnt == N) {
			subs(0,0,0);
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visit[i])continue;
			visit[i] = true;
			arr[cnt] = weight[i];
			visit[i] = false;
			
			perm(cnt+1);
		}
	}
	private static void subs(int cnt, int left, int right) {
		if(left<right)return;
		if(cnt == N) {
			return;
		}
		subs(cnt+1,left+arr[cnt],right);
		subs(cnt+1,left,right+arr[cnt]);		
	}
}
