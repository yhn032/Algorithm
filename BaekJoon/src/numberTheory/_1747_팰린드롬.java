package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1747_팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1~1000000사이에 존재하는 소수를 먼저 구하자 
		//투포인터를 사용해 소수중 팰린드롬 수가 있는지 확인하자 
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[10000001]; //N이 최댓값 100000인 경우에 가장작은 팰린드롬 10000001
		for(int i=2; i<arr.length;i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) continue;
			for(int k=i+i;k<arr.length; k+=i) {
				arr[k] = 0;
			}
			
		}
		
		int k = N;
		while(true) {//가장 먼저 발견하는 펠린드롬이 최소이다.
			if(arr[k] != 0) {//소수라면,,,
				int result = arr[k];
				
				if(ispalindrom(result)) {
					System.out.println(result);
					break;
				}
			}
			k++;
		}
	}

	private static boolean ispalindrom(int result) {
		// TODO Auto-generated method stub
		char temp[] = String.valueOf(result).toCharArray();
		int start = 0; 
		int end = temp.length-1;
		
		while(start < end) {
			if(temp[start] != temp[end]) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}

}
