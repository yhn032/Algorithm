package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _2108_통계학 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		
		//1. 산술평균
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		double avg = (sum*1.0)/N;
		System.out.println((int)Math.round(avg));
		
		//2. 중앙값
		System.out.println(arr[N/2]);
		
		//3. 최빈값
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {//기본적으로 1을 주고 이후부터는 +1을 해서 계수한다.
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		List<Integer> list = new ArrayList<Integer>();
		
		int num = 0;
		//여기에서는 빈도수의 "최댓값"만 구한다. 
		//value값으로는 키를 구할 수 없다.
		for(int v : map.values()) { //v는 수가 등장한 빈도수이다. 빈도수의 최대값을 구한다.
			num = num > v ? num : v; 
		}
		
		//빈도수가 최대인 key를 찾는다.
		for(int key : map.keySet()) {
			if(map.get(key) == num) {
				list.add(key);
			}
		}
		
		//정렬하기 
		Collections.sort(list);
		if(list.size()>=2) {//자주 나온 값 최빈값이 여러개라면 2번째값 출력,1개일경우는 첫 번째 값 출력
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}
		
		
		//4. 범위
		int range = arr[N-1] - arr[0];
		System.out.println(range);
	}

}
