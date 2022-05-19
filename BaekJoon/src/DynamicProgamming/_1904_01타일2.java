package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1904_01타일2 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//(A+B)%C == ((A%C)+(B%C))%C
		
		//Bottom-up 방식의 구현
		System.out.println(dp(n));
	}
	
	private static int dp(int i) {
		// TODO Auto-generated method stub
			
		if(i == 1) return 1;
		if(i == 2) return 2;
		
		
		int val1 = 1;
		int val2 = 2;
		int sum  = 0;
		
		for(int k=3; k<=i; k++) {
			sum = (val1 + val2)%15746; //n=3일때부터 채우면서 up하기 시작 i가 10이라면 3~10까지 8번을 반복해야함
			val1 = val2;
			val2 = sum;
		}
		//val1이 점화식에서 N[i-2];
		//val2가 점화식에서 N[i-1]이다. 
		//따라서 현재 반복 첨자에서 점화식을 이용해서 값을 구했다면 바틈업은 재귀를 사용하지 않고 반복으로 하기 때문에 val1의 값을 val2로 val2는 sum의 값을 넣어줌으로써 갱신해줘야 다음 반복에서도 정확한 값이 누적합 
		//되면서 해결된다.
		
		return sum;
	}

}

/*
	N = 1	1		1
	N = 2	11, 00	2
	N = 3   111, 100, 001	3
	N = 4	0000, 0011, 1001, 1100, 1111	5
	N = 5	11111, 11100, 11001, 10011, 00111, 10000, 00001, 00100	8
	
	
	
	N[i] = N개길이의 타일을 주어진 조건에 맞는 모든 가짓 수를 계산
	
	
	피보나치와 같은 로직
	N[i] = N[i-1] + N[i-2]
	
	N[2] = 2
	N[1] = 1
*/
