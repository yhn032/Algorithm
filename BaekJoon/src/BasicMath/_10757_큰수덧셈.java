package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10757_큰수덧셈 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		
		String str_A = st.nextToken();
		String str_B = st.nextToken();
		
		//큰 수를 문자열로 읽어와서 문자열의 길이만큼의 배열을 생성한다. 단, 이때 길이가 더 긴 문자열의 길이로 배열의 크기를 지정한다. 그렇지 않으면 인덱스끼리 연산을 진행했을 때, 길이가 짧은것은 outofindex발생 가능
		int str_length = str_A.length() > str_B.length() ? str_A.length() : str_B.length();
		
		int A[] = new int[str_length+1];
		int B[] = new int[str_length+1];
		int result[] = new int[str_length+1];
		
		
		//계산의 편의성을 위해서 문자열의 뒤에서 부터값을 입력한다. 
		/*
			1234 + 123을 진행하려 하는데 
			
			이렇게 넣으면 자릿수에 대한 오류를 범한다.
			1234
		+	123
			
			4321
		+	321
		그래서 이렇게 넣을 거다.
		*/
		
		//숫자 A 초기화하기 //초기화 하지 않은 인덱스는 0으로 초기화 됨
		for(int i=(str_A.length()-1), k =0 ; i>=0; i--, k++) {
			A[k] = str_A.charAt(i) - '0';
		}
		
		//숫자 B 초기화하기 //초기화 하지 않은 인덱스는 0으로 초기화 됨
		for(int i=(str_B.length()-1), k =0 ; i>=0; i--, k++) {
			B[k] = str_B.charAt(i) - '0';
		}
		
		
		//올림수를 어떻게 올릴 것인가
		for(int i=0; i < str_length; i++) {
			int hap = A[i] + B[i];
			
			if(hap>=10) {
				//0~9사이의 두 정수를 더해서 나올 수 있는 최대 캐리의 크기는 1이다. 
				result[i+1] += 1;
				result[i]   += hap%10;
				
			}else { //캐리가 발생하지 않으면 나머지값을 넣는다. 어차피 몫은 0임
				result[i] += hap%10;
				if(result[i] >= 10) {
					result[i+1] += 1;
					result[i]   = result[i]%10;
					
				}
				
			}
			
		}
		
		
		
		
		
		/*
		 * for(int i=0; i<str_length; i++) { System.out.print(A[i]); }
		 * System.out.println(); for(int i=0; i<str_length; i++) {
		 * System.out.print(B[i]); } System.out.println();
		 */
		for(int i=result.length-1; i>=0; i--) {
			if(i==result.length-1 && result[i]==0) continue;
			System.out.print(result[i]);
		}
		
	}

}

