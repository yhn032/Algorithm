package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10819_차이를최대로 {

	static int nums[];
	static boolean[] visited;
	static int n;
	static int result = Integer.MIN_VALUE;
	static List<Integer> list;

	public static void main(String[] args) throws Exception { // TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		nums = new int[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<Integer>();
		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int depth) { 
		// TODO Auto-generated method stub //깊이 depth가n일때 n+1개의 요소를 갖고 있는다.
  
		//base case 
		if(depth == n) { //가장 깊은 곳까지 오면서 모아온 숫자들의 차이합을 구해서 최댓값 갱신 
			int sum = 0; 
			for(int i=1; i<n; i++) { 
				sum += Math.abs(list.get(i-1)-list.get(i)); }
				result = Math.max(sum, result); 
				return; 
			}

		// recursive case 
		for(int i=0; i<n; i++) { 
			if(!visited[i]) {//방문하지 않았다면,,,
			visited[i]=true;// 방문 처리 해주고 
			list.add(nums[i]); 
			dfs(depth+1);//배열 하나를 list에넣어준다.
			list.remove(list.size()-1);// basecase를 한 번찍고 왔으면 다른 경우의 수를 넣어보기 위해 마지막값을 삭제한다.
			visited[i]=false;// 다른 경우의 수에서 방문할 수 있도록 방문표시를 지운다. } }

			}
		}
	}
}


/*
 * 인접한 두수의 크기의 차이가 최대가 되도록 순서를 바꿔라 배열의 값으로 음수가 있다는 것에 유의. 모든 경우의 수를 다 검사해도 8!이므로
 * 시간초과날일은 없겠다. 8중 중첩 쓸거 아니면 재귀를 쓰자. 각 요소를 배열의 값으로 받되, 재귀를 깊이가 n일때까지 반복하고 배열의
 * 인덱스를 기준으로 방문 배열을 만들자. 깊이의 끝에 도달했을때, 차이의 합을 구해서 최댓값을 갱신ㄴ하다.
 */