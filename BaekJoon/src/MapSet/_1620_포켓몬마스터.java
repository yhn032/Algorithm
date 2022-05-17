package MapSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class _1620_포켓몬마스터 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		//도감의 수
		int n = Integer.parseInt(st.nextToken());
		
		//문제수
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		String check[] = new String[n+1];
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			map.put(str, i);
			check[i] = str;
		}
		
		Set<Entry<String, Integer>> entry = map.entrySet();
		
		//문제 check
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			
			
			if(Character.isDigit(str.charAt(0))) {//숫자라면 -> value
				int temp = Integer.parseInt(str);
				
				sb.append(check[temp]).append('\n');
				
				
			}else {//문자라면 -> key
				sb.append(map.get(str)).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}

