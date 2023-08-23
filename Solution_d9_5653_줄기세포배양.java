package a0821.add;

import java.io.*;
import java.util.*;

public class Solution_d9_5653_줄기세포배양 {
	static int[] di={-1,0,1,0};//상우하좌
	static int[] dj={0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_5653.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
        	StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            int R=K+N+K;
            int C=K+M+K;
            boolean[][] v=new boolean[R][C];
            PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->-Integer.compare(o1[2],o2[2]));
            for(int i=K; i<K+N; i++){
                st=new StringTokenizer(br.readLine()," ");
                for(int j=K; j<K+M; j++){
                    int L=Integer.parseInt(st.nextToken());
                    if(L!=0){
                        v[i][j]=true;
                        pq.offer(new int[]{i,j,L,L*2});
                    }
                }
            }
			ArrayDeque<int[]> q=new ArrayDeque<>();
			for(int k=1; k<=K; k++){
				while(!pq.isEmpty()){
					int[] ij=pq.poll();
					ij[3]--;//curr
					if(ij[2]>ij[3]){//활성화(=)후 다음(>)
						for(int d=0; d<4; d++){
							int ni=ij[0]+di[d];
							int nj=ij[1]+dj[d];
							//if(ni<0||R<=ni || nj<0||C<=nj) continue;
							if(!v[ni][nj]){
								v[ni][nj]=true;
								q.offer(new int[]{ni,nj,ij[2],ij[2]*2});//i,j,life,curr
							}
						}
					}
					if(ij[3]!=0) q.offer(ij);//안죽은경우					
				}
				while(!q.isEmpty()) pq.offer(q.poll());
			}
			sb.append("#").append(tc).append(" ").append(pq.size()).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
