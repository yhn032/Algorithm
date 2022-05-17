package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _14425_문자열집합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//집합S의 요소 개수
		int n = Integer.parseInt(st.nextToken());
		
		//검증이 필요한 테스트 케이스
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> hs = new HashSet<String>();
		
		int cnt=0;
		for(int i=0; i<m+n; i++) {
			if(i < n ) {
				hs.add(br.readLine());
				continue;
			}
			
			if(hs.contains(br.readLine())) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
