package DateStrucImple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _20291_treemap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		
		
		TreeMap<String, Integer> map = new TreeMap<>();
		
		for(int i=0; i<N;i++) {
			String str = br.readLine();
			//					beginindex -> '.'���� ��ġ����
			str = str.substring(str.indexOf('.')+1);
			
			if(map.containsKey(str)) {
				int count = map.get(str);
				//count++���ϸ� �������ϰ� ++�ϱ� ������ ���� �������� ����
				map.replace(str, ++count);
			} else {
				map.put(str, 1);
			}
		}
		
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		
	}

}

