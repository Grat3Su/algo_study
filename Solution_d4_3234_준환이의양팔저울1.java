package a0823.add;

import java.io.*;
import java.util.*;

public class Solution_d4_3234_준환이의양팔저울1 {
	static int N,result;
	static int[] weight,arr;
	static boolean[] visit;
	
	static void subs(int cnt,int left,int right){
		if(left<right) return;
		if(cnt==N){
			result++;
			return;
		}
		subs(cnt+1,left+arr[cnt],right);
		subs(cnt+1,left,         right+arr[cnt]);
	}
	static void perm(int cnt){
		if(cnt==N){
			subs(0,0,0);
			return;
		}
		for(int i=0; i<N; i++){
			if(visit[i]) continue;
			visit[i]=true;
			arr[cnt]=weight[i];
			perm(cnt+1);
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
			arr=new int[N];
			visit=new boolean[N];
			result=0;
			perm(0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
