package BinarySearch;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

고려사항
아까 풀었던 이분탐색 문제와 비슷하지만, 같은 숫자가 나온다면 같은 위치에 append해야한다.
+) 원래 이진탐색은 중복되지않은 값들을 가지고 진행한다.

1. 중복값까지 count해야하니까 target과 일치하더라도 계속 탐색하는 조건 찾기
2. 시간초과

*/

public class _10816_숫자카드2 {

	
	//왼쪽 탐색
	public static int leftBound(int target) {
		
		int start = 0;
		int end   = n;
		
		while(start<end) {
			
			int mid = (start+end)/2;
			
			if(arr[mid]>=target) {
				end = mid;
			}else {
				start = mid+1;
			}
		}//while end
	
		return start;
	}
	
	//오른쪽 이분 탐색
	public static int rightBound(int target) {
		
		int start = 0;
		int end   = n;
		
		while(start<end) {
			
			int mid = (start+end)/2;
			
			if(arr[mid] > target) {
				end = mid;
			}else if(arr[mid]<=target) {
				start = mid+1;
			}
			
		}//while end
		return end;
	}
	//	0	1 2 3 4 5 6  7  8  9
	//-10 -10 2 3 3 6 7 10 10 10
	
	public static int count(int target) {
	
		int start = leftBound(target);
		int end   = rightBound(target);
		
		return end-start;
	}
	
	
	//static 변수 선언 -> 클래스 내 어디서든 선언 없이 바로 사용 가능 -> 1회만 생성
	static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder   sb = new StringBuilder();
	static int n;
	static int t;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		t  = Integer.parseInt(st.nextToken());
		
		
		//-------------[예제입력완료]--------------
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<t; i++) { //for문 안에서 binary메소드 호출해야 target을 t만큼 보냄
			int target = Integer.parseInt(st.nextToken());
			sb.append(count(target)).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		br.close();
		out.close();
	}
}