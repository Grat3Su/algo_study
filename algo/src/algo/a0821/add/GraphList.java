package algo.a0821.add;

import java.io.*;
import java.util.*;

public class GraphList {
static int N;
static List<List<Integer>> g;
static boolean[] v;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		g = new ArrayList<Integer>();
		int E = sc.nextInt();
		for(int i = 0; i<N; i++) {
			//g = new 
		}
		for(int i = 0; i<E; i++) {
			int from=sc.nextInt();
			int to = sc.nextInt();
			g[from].add(to);
			g[to].add(from);
		}
		for(int[]b:g) {
			System.out.println(Arrays.toString(b));
		}
		dfs(0);
		sc.close();
	}
	
	static void dfs(int i ) {
		v[i] = true;
		System.out.print((char)(i+'A')+" ");
		for(int j = 0; j<N; j++) {
			if(g[i][j]!=0&&!v[j]) {
				dfs(j);
			}
		}
	}
	static void bfs(int i) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		v[i] =true;
	}

}
/*
  A0
  /\
B1	C2
 /\	/
D3 E4
 \  |
   F5-G6
*/