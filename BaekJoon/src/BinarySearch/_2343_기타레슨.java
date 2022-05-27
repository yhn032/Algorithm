package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2343_기타레슨 {
	static int blueray[];
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		blueray = new int[N];
		
		int min = 0; 
		int max = 0; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			blueray[i] = Integer.parseInt(st.nextToken());
			
			//변수명에 헷갈리지 말자 최댓값을 구하는 과정이다. 탐색의 시작점을 구하는 것일뿐
			min = min < blueray[i] ? blueray[i] : min; 
			max += blueray[i];
		}
		
		//이진탐색 시작 
		while(min < max) {
			
			int mid = (min+max)/2;
			
			if(cntBlue(mid) > M) {
				//블루레이의 크기가 mid일 때, 사용할 수 이쓴 최소 블루레이 개수가 M보다 크다면, 
				//블루레이가 덜 필요하다는 것이다. -> 블루레이의 크기를 키워라 -> 내가 찾는 값은 mid보다 오른쪽에 있음 
				min = mid+1;
			}else {
				//블루레이의 크기가 mid일 때, 사용할 수 있는 최소 블루레이 개수가 M보다 작거나 같다면
				//블루레이가 더 필요하다는 것이다. -> 블루레이의 크기를 줄여라 -> 내가 찾는 값은 mid보다 왼쪽에 있음
				max = mid;
			}
			
		}
		
		System.out.println(min);
	}

	private static int cntBlue(int mid) {
		// TODO Auto-generated method stub
		int sum = 0; 
		int count=0;
		
		for(int i=0; i<N; i++) {
			if(sum + blueray[i] >  mid) { //더하기 전에 검사 넘친다면 넘치기 전까지만 더한 값을 하나의 블루레이에 담고 초기화
				count++;
				sum = 0;
			}
			sum += blueray[i];
		}
		
		//배열에 있는 값을 모두 더했는데 sum에 값이 남아있다면 초과된것이므로 하나의 블루레이가 더 필요하다. 
		if(sum != 0) count++;
		
		return count;
	}

}


/*
	탐색 대상 -> 블루레이의 크기 중 최소 
	모든 M개의 블루레이의 크기(저장된 녹화본의 크기)는 같다.
	
	강의의 순서 바뀌면 안됨 함부로 정렬을 진행할 수 없다. 그렇다면 탐색의 인덱스를 어떻게 찾지? 
	
	
	강의의 길이를 기준으로 탐색한다 .
	최소 - 가장 긴 길이의 강의 
	최대 - 모든 레슨 길이의 합
	이 범위안에서 모든 강의를 저장할 수 있게 하는 블루레이 개수의 최솟값을 찾아라.
	
*/
