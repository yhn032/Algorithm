package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_연산자끼워넣기 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	static int arr[];
	static int op[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//수열의 개수 
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		//수열 초기화
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		op = new int[4];
		
		//연산자 개수 초기화 
		//op[0] = +, op[1] = -, op[2] = *, op[3] = /
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int idx, int num) {
		// TODO Auto-generated method stub
		if(idx == n) {
			max = max < num ? num : max;
			min = min > num ? num : min;
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				//연산자가 한 개 이상 존재한다면 
				op[i]--;
				
				switch(i) {
				case 0: dfs(idx+1,num + arr[idx]); break;
				case 1: dfs(idx+1,num - arr[idx]); break;
				case 2: dfs(idx+1,num * arr[idx]); break;
				case 3: dfs(idx+1,num / arr[idx]); break;
				}
				
				//백트레킹의 기본 -> 재귀 호출이 종료되면 방금 탐색했던 경로에 대해서는 복구를 해야한다.
				op[i]++;
			}
		}
	}

}

/*
	주어진 수열의 순서는 바꿀 수 없다. 
	전체 경우의 수 -> 전체 연산자의 개수 m 일때, 연산자가 중복 된다면 
	m!/(중복된연산자개수)!...
	계산은 무조건 앞에서 부터 진행한다. 
	나눗셈은 정수 나눗셈으로 몫만 취한다. 
	음수 나눗셈은 -> 양수를 기준으로 나누고 결과값에 음수를 취한다. 
	만들수 있는 식의 결과가 최대인 것과 최소인 것을 구하라
*/


