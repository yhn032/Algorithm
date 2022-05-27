package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976_여행가좌 {
	static int[] travel;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		//도시번호 1 ~ n
		travel = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			travel[i] = i;
		}
		
		//주어진 연결 정보로 연결하기 
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp==1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		//여행의 출발지
		int start = find(Integer.parseInt(st.nextToken()));
		for(int i=1; i<m; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			//출발도시에서부터 연결되어 있지 않으면,,, -> 시작 노드의 부모노으듸 자식 노드가 아니라면 같은 경로가 아니다 .
			if(start != find(now)) {
				sb.append("NO").append('\n');
				System.out.println(sb);
				return;
			}
		}
		
		sb.append("YES").append('\n');
		
		System.out.println(sb);
	}

	private static void union(int x, int y) {
		// TODO Auto-generated method stub
		x = find(x);
		y = find(y);
		if(x!=y) {
			if(x<y) {
				travel[y]=x;
			}else {
				travel[x]=y;
			}
		}
	}

	private static int find(int x) {
		// TODO Auto-generated method stub
		if(x == travel[x]) {
			return x;
		}
		
		return travel[x] = find(travel[x]);
	}

}
