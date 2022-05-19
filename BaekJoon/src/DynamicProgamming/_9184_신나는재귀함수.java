package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9184_신나는재귀함수 {
	static int w[][][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		//문제에서 입력조건은 50이지만 하나라도 21이 넘어가면 어차피 w(20, 20, 20)을 반환하기 때문에 고려할 필요가 없다.
		w = new int[21][21][21];
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b== -1 && c ==-1) break;
			
			//찾고자 하는 값이 범위 안에 있고, DP테이블에 있다면 가져오고 없다면 재귀를 통해 새로 생성한다.
			sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, w(a,b,c))).append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static int w(int a, int b, int c) {
		// TODO Auto-generated method stub
		
		//범위 안에 있고, 
		if(isInner(a,b,c) && w[a][b][c] != 0 )
			return w[a][b][c];
		
		if(a <= 0 || b <=0 || c<=0 ) {
			return 1;
		}
		
		if(a>20 || b>20 || c>20) {
			w[20][20][20] = w(20, 20, 20);
			return w[20][20][20];
		}
		
		if(a < b && b < c) {
			w[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a, b-1, c);
			return w[a][b][c];
		}
		
		w[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
		return w[a][b][c];
	}

	private static boolean isInner(int a, int b, int c) {
		// TODO Auto-generated method stub
		
		if(a >= 0 && a <= 20 && b >=0 && b <= 20 && c>=0 && c<=20) {
			return true;
		}else {
			return false;
		}
	}

}

/*
	문제에 제시된 재귀함수의 종류 
	1. 셋 중 하나 이상이  0이하 -> return 1
	2. 셋 중 하나 이상이 20초과 -> return w(20,20,20) 값이 20 이상인 경우는 생각할 필요 없음 바로 w(20, 20,20)으로 온다. 
	3. 세 값이 오름차순
	
	//동적 계획법을 Top Down 방식으로 풀이하는 경우
	 * 메모이제이션만을 기억하여 적용하면 된다.
*/
