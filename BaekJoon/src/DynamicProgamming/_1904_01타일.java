package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1904_01타일 {
	static int[] N;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		//(A+B)%C == ((A%C)+(B%C))%C
		N = new int[1000001];
		
		//TOP-Down 방식의 구현
		Arrays.fill(N, -1);
		
		N[0] = 0;
		N[1] = 1;
		N[2] = 2;
		
		System.out.println(dp(n));
		
	}
	private static int dp(int i) {
		// TODO Auto-generated method stub
		
		if(N[i] == -1) {//아직 메모이제이션 된 값이 아니라면
			
			//N[i] = dp(i-1) + dp(i-2);
			//값을 구해주고 출력할 때만 15476으로 나눠서 나머지를 출력하고자 했지만 
			//스택오버플로우가 발생하여, 제출이 안될 것 같다. 
			//나머지 연산의 분배 법칙을 사용해야 할 것 같다. 
			//(A+B)%C = ((A%C) + (B%C))%C
			//위의 식을 적용하면 배열값에 나머지값이 저장되고, 차후에 나머지 값으로 또 연산을 하다보니 
			//내가 정한 피보나치 점화식이 제대로 적용 안되는게 아닌가 하는 생각이 들 수 있기에 단위를 작게 쪼개어 예를 들어보자 
			
			
			
			/*
				일단 재귀를 사용했기 때문에 top-down방식을 사용한다. 
				경우의 수가 하나기 때문에 메모이 제이션을 할 필요가 있을까?하는 생각을 할 수 도 있지만
				하나의 배열 값을 완성하기 위해서 두개의 재귀를 호출하기 때문에 반드시 중복호출 되는 경우의 수가 생긴다. 
				그런 경우 이미 배열값을 채웠기 때문에(!= -1)계산을 수행하지 않고(재귀의 호출을 줄이고), 바로 값을 리턴하도록 하면서 
				연산 횟수를 줄여야 한다. 기본적으로 DP에서 재귀를 쓸때 메모이제이션은 기본으로 쓰고간다.
				
				EX) n==5인 경우 
				값을 위에서 모두 -1로 초기화 하고 0 1 2만 초기화 했으니 3과 4, 5는 아직 -1인 상태이다. 
				N[5] == -1이므로 아래의 연산을 수행하게 된다. 
				
				N[5] = (dp(4) + dp(3))%15746이 된다. 
				
				dp(4)를 수행하러 왔더니 N[4] == -1이기에 연산을 해야한다. 
				
				N[4] = (dp(3) + dp(2))%15746
				
				마찬가지로 dp(3)을 수행하면 다음과 같다. 
				
				N[3] = (dp(2) + dp(1))%15746
				
				자 이제부터는 dp(2), dp(1) 모두 초기화가 되어 -1이 아니기 때문에 값을 들고 호출당한 지점으로 나간다. 
				
				현재 DP테이블에는 다음과 같은 데이터가 저장되어 있을 것이다, 
				
				N[0] = 0;
				N[1] = 1;
				N[2] = 2;
				N[3] = (dp(2) + dp(1))%15746;
				N[4] = (dp(3) + dp(2))%15746; ==  ( (dp(2) + dp(1))%15746; + dp(2) )%15746;
				N[5] = (dp(4) + dp(3))%15746; ==  ( (dp(3) + dp(2))%15746; + (dp(2) + dp(1))%15746; )%15746 == ( dp(3) + dp(2) + dp(2) + dp(1)   )%15746 
				
				위와 같이 나머지 연산을 취해서 배열에 값을 저장하긴 하지만 분배 법칙에 의해서 각 재귀의 반환값을 연산하고 나머지를 취할 수 있도록 적용이 된다.
				즉, 나머지값으로 또 나머지를 구하는 것이 아니라, 분배법칙으로 인해 보이는 것만 그렇게 보일뿐이다.
			*/
			N[i] = (dp(i-1) + dp(i-2))%15746;
			
		}
		return N[i];
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
