package a0823.add;

import java.io.*;
import java.util.*;

public class Solution_d4_3234_준환이의양팔저울2 {
	static int N,result;
	static int[] weight;
	static boolean[] visit;
	
	static void perm(int cnt,int left,int right){
		if(left<right) return;
		if(cnt==N){
			result++;
			return;
		}
		for(int i=0; i<N; i++){
			if(visit[i]) continue;
			visit[i]=true;
			perm(cnt+1,left+weight[i],right);
			perm(cnt+1,left,          right+weight[i]);
			visit[i]=false;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
			N=Integer.parseInt(br.readLine());
			weight=new int[N];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++){
				weight[i]=Integer.parseInt(st.nextToken());
			}
			visit=new boolean[N];
			result=0;
			perm(0,0,0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
