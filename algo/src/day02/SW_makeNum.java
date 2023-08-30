package day02;
import java.io.*;
import java.util.*;
public class SW_makeNum {
	static int T, ansMin, ansMax, N;
	static int[] num;
	static int[] op;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ansMin = Integer.MAX_VALUE;
			ansMax = Integer.MIN_VALUE;
			
			N = sc.nextInt();
			num = new int[N];
			op = new int[4];
			
			for(int i = 0; i<4; i++) {
				op[i] = sc.nextInt();
			}
			for(int i = 0; i<N; i++) {
				num[i] = sc.nextInt();				
			}
			
			recursive(0,0);
			
			System.out.println("#"+tc+" "+(ansMax-ansMin));
		}
		
	}
	
	static void recursive(int idx, int val) {
		if(idx==N-1) {
			ansMax = Math.max(ansMax, val);
			ansMin = Math.min(ansMin, val);
		}
		
		//연산자 종류만큼 반복
		for(int i = 0; i<4; i++) {
			//사용할 수 있는 연산자가 있다면
			if(op[i]>0) {
				op[i]--;
				recursive(idx+1, calc(idx, i, val));
				op[i]++;
			}
			
		}
	}
	static int calc(int idx, int op, int val) {
		//if(idx==0) {
			val = num[idx];
		//}
		switch(op) {
		case 0:
			return val+num[idx+1];
		case 1:
			return val-num[idx+1];
		case 2:
			return val*num[idx+1];
		case 3:
			return val/num[idx+1];
		default:
			return val;
		}
	}
}
