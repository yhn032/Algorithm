package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_N과M2 {
	static int n,m;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//입력값 배열 초기화
		arr   = new int[m];//출력할 결과를 담을 배열
		
		dfs(0,1); //시작 깊이 0
		
		
		System.out.println(sb);
		//depth변수를 추가하여 한 번의 dfs로 값을 조건에 맞는 답을 찾았으면
		//+1해서 탐색 깊이와 동시에 조합을 이루는 수의 개수를 같이 카운트 해준다. 
		//즉 4개의 수를 조합해야 할때 깊이가 1이면 1개의 숫자를 고른 것이고, 
		//깊이가 4이면 탐색이 끝난 것
		//탐색을 마치고 깊이를 +1해야 한다.
		
	}
	private static void dfs(int depth, int pos) {
		// TODO Auto-generated method stub
		//재귀를 사용할 때는 base영역과 recursion영역을 명시해서 나누어 주어야 한다. 
		//이번 문제에서 베이스는 따로 주지 않고, 조합을 모두 구한 경우 출력을 하고 다시 호출한 지점으로 돌아가서 다른 수를 조합해볼 수 있도록 
		//재귀함수 내부에 반복문을 구현할 것이다 .
		
		
		//base
		if(depth == m) {
			for(int k : arr) {
				sb.append(k).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		//recursion 
		for(int k=pos; k<=n; k++) { 
			arr[depth] = k;
			dfs(depth+1, k+1);
			
			
		}
		
	}

}
