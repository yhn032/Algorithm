package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _9375_패션왕 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int t = Integer.parseInt(br.readLine());
		
		
		
		while(t-->0) {
			Map<String, Integer> clothes = new HashMap<String, Integer>();
			int n = Integer.parseInt(br.readLine());
			
			while(n-->0) {
				
				st = new StringTokenizer(br.readLine());
				
				//옷의 이름은 필요없다. 
				st.nextToken();
				
				//옷의 종류
				String cloth = st.nextToken();
				
				if(clothes.containsKey(cloth)) {//맵에 옷의 종류가 있다면 +1하기
					clothes.put(cloth, clothes.get(cloth)+1);
					
				}else { //맵에 옷의 종류가 없다면 1로 셋하기 
					clothes.put(cloth,1);
				}
				
			}//end-while n 옷 종류 초기화 완료 
			
			
			//이제 중복 조합을 뽑아야 한다.
			int tcase = 1; 
			
			//3*2
			for(int clo : clothes.values()) {
				tcase *= (clo+1);
			}
			
			//3*2-1
			tcase -= 1;
			
			sb.append(tcase).append('\n');
		}//end - while t
		
		System.out.println(sb);
	}

}


//중복조합 
//3C1 -> 3개 중에 1개 뽑기 
//단, 안입는 경우도 있음(한 종류의 옷의 개수가 2개라면 안 입는 경우 null을 포함해 3개로 계산해야 한다.)
//둘다 안 입는 경우는 알몸이므로 -1해줘야 함 


//3C1 * 2C1 - 1 



//nCr => n * n-1 * n-2 ... 1 / r * r-1 * r-2...1
//n * n-1 * ... * n-r+1
//단, 리스트 중 하나만 고르기 때문에 무조건 nC1의 결과를 요구한다, 
//nC1 = n;

//자바에서 순열을 계산하기
