package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149_RGB거리 {
	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//bottom-up으로 풀어보자 
		
		int n = Integer.parseInt(br.readLine());
		
		int cost[][] = new int[n][3];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3 ; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//메모이제이션 -> 재귀에 비해 눈에 띄게 보이진 않지만, 배열을 호출할때, 이전 인덱스에 저장된 누적합을 가져와 활용하기 때문에 이 또한 메모이제이션이라는 것을 알아두어라
		
		//초깃값은 그대로 두고 실행한다. 
		for(int i=1; i<n; i++) {
			cost[i][RED]   += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
			cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
			cost[i][BLUE]  += Math.min(cost[i-1][GREEN], cost[i-1][RED]);
		}
		
		System.out.println(Math.min(Math.min(cost[n-1][RED], cost[n-1][GREEN]),cost[n-1][BLUE]));
	}

}


/*
	인접한 집은 다른 색으로 칠해야 한다.
	
	
	  3
	  r  g  b
	1 26 40 83
	2 49 60 57
	3 13 89 99
	
	3개의 집이 있을 때, 1번집을 r로 칠하는 비용이 26, g는 40, b는 83이다.
	
	중복을 허용하지 않고 3개를 뽑는 경우의 수를 찾아보자 
	바로 인접한 집의 색만 같지 않으면 된다. r b r 이런식은 가능 
	
	1 2 3
	r g b		26 + 60 + 99
	r b g		26 + 57 + 13 
	g r b		40 + 49 + 99
	g b r		...
	b r g		...
	b g r		...
	
	최솟값을 구하기 위해서는 각 순서에서 비용이 최소인 것을 골라야 한다. 
	이때 인접한 집에 칠해지는 색이 같으면 안된다. 
	
	점화식을 어떻게 구할 수 있을까? D[N]
	D[1] = r, g, b 중 최소 비용
	D[2] = D[1]에서 선택한 색을 제외한 비용 중 최소
	D[3] = D[2]에서 선택한 색을 제외한 비용 중 최소
	D[N] = D[N-1]에서 선택한 색을 제외한 비용 중 최소 
	
	색은 바로 이전 집에 대한 색만 제외하고 고려하면 된다.
	
	
	점화식이 잘못되었다. 다시 풀어보라능
	
	각 집에대한 최솟값을 구하고자 하면 정확한 최솟값이 구해지지 않는다. 
	브루트 포스 방식으로 초깃값만 초기화 하고 각 집에 대해 모든 경우의수를 구한다음 그 중 최솟값을 누적합 방식으로 구해야 한다. 
*/
