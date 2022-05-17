package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[n];
		int sorted[] = new int[n];		
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sorted[i] = arr[i];
		}
		
		Arrays.sort(sorted);
		
		
		//숫자와 빈도수를 저장한다.
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		//  0  1 2 3 4
		//-10 -9 2 4 4
		int rank=0;
		for(int i=0; i<n; i++) {
			if(!map.containsKey(sorted[i])) { //없으면 추가해라
				map.put(sorted[i], rank);
				rank++;
			}
		}
		
		//원본 배열 갱신
		for(int i=0; i<n; i++) {
			sb.append(map.get(arr[i])).append(' ');
		}
		
		System.out.println(sb);
	}

}
