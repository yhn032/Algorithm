package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717_유니온파인트 {
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//0~n
		arr = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = i; 
		}
		
		for(int i=0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int ques = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(ques==0) {//union연산
				union(a,b);
			}else {
				if(find(a) == find(b)) {
					sb.append("YES").append('\n');
				}else {
					sb.append("NO").append('\n');
				}
			}
		}
		
		System.out.println(sb);
	}

	private static void union(int a, int b) { //대표 노드 끼리 연결하기 -> 대표노드는 find로 찾는다. 
		// TODO Auto-generated method stub
		a = find(a);
		b = find(b);
		if(a != b) {//같지 않다면,,, 이미 같은 집합이 아니라면,,, 합쳐라 뭘로 합치는지는 상관없음
			arr[b] = a;
		}
		
	}

	private static int find(int a) {
		// TODO Auto-generated method stub
		//base case
		if(a==arr[a]) return a;
		else {
			return arr[a] = find(arr[a]);
		}
	}

}

/*
	그래프 혹은 트리의 경로를 압축해야 하는 경우가 필요할 때 유니온 파인드를 사용한다. 
	유니온 -> 각 노드가 속한 집합을 1개로 합친다. 이 때 자식 노드가 아닌 부모 노드의 값을 기준으로 합친다. 
	파인드 -> 노드가 속한 집합의 부모 노드를 찾는다. 
	

*/


