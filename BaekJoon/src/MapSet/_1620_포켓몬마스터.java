package MapSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class _1620_���ϸ󸶽��� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		//������ ��
		int n = Integer.parseInt(st.nextToken());
		
		//������
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		String check[] = new String[n+1];
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			map.put(str, i);
			check[i] = str;
		}
		
		Set<Entry<String, Integer>> entry = map.entrySet();
		
		//���� check
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			
			
			if(Character.isDigit(str.charAt(0))) {//���ڶ�� -> value
				int temp = Integer.parseInt(str);
				
				sb.append(check[temp]).append('\n');
				
				
			}else {//���ڶ�� -> key
				sb.append(map.get(str)).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}

