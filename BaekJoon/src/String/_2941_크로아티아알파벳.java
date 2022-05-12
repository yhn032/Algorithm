package String;

/*
	다음의 문자는 1개로 카운트한다.
	c=
	c-
	dz=
	d-
	lj
	nj
	s=
	z=
	
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		//반복횟수 - 글자의 길이
		int r = str.length();
		//크로아티아 문자를 계수할 변수
		int count = 0;
		
		//i < r-1인경우만 검사해야 outofindex가 나오지 않음
		for(int i=0; i<r;i++) {
			if(str.charAt(i) == 'c' && i < r-1) {
				if(str.charAt(i+1) == '-' || str.charAt(i+1) == '=') {
					i++;
				}
			}else if(str.charAt(i) == 'd' && i < r-1) {
				if(str.charAt(i+1) == '-') {//d-인경우
					i++;
				}else if(str.charAt(i+1)=='z' && i < r-2) {
					if(str.charAt(i+2) == '=') {//dz=인경우
						i+=2;
					}
					
				}
			}else if((str.charAt(i) == 'l' || str.charAt(i) == 'n') && i < r-1) {
				if(str.charAt(i+1) == 'j') {
					i++;
				}
			}else if((str.charAt(i) == 's' || str.charAt(i) == 'z') && i < r-1) {
				if(str.charAt(i+1) == '=') {
					i++;
				}
			}
			
			count++;
		}
		System.out.println(count);
	}

}