package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2908_상수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		//스트링빌더에 값을 추가하고, 뒤집은 결과를 string형태로 반환한다.
		a = sb.append(a).reverse().toString();
		
		//스트링빌더를 초기화 시킨다. 길이을 0으로 만들어버림
		//delete메소드를 사용하거나 생성자를 사용해 새로운 객체를 
		//만드는 방법도 있지만 시간이 더 오래 걸린다. 
		sb.setLength(0);
		b = sb.append(b).reverse().toString();
		
		int aa = Integer.valueOf(a);
		int bb = Integer.valueOf(b);
		
		
		System.out.println(aa>bb?aa:bb);
	}

}
