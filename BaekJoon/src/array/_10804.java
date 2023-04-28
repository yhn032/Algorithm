package src.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _10804 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int n = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n ; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int goal = Integer.parseInt(br.readLine());
		
		int cnt = arr.stream()
				.filter(m -> m==goal)
				.collect(Collectors.toList())
				.size();
		
		System.out.println(cnt);
	}
}
