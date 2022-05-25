package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _9375_�мǿ� {

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
				
				//���� �̸��� �ʿ����. 
				st.nextToken();
				
				//���� ����
				String cloth = st.nextToken();
				
				if(clothes.containsKey(cloth)) {//�ʿ� ���� ������ �ִٸ� +1�ϱ�
					clothes.put(cloth, clothes.get(cloth)+1);
					
				}else { //�ʿ� ���� ������ ���ٸ� 1�� ���ϱ� 
					clothes.put(cloth,1);
				}
				
			}//end-while n �� ���� �ʱ�ȭ �Ϸ� 
			
			
			//���� �ߺ� ������ �̾ƾ� �Ѵ�.
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


//�ߺ����� 
//3C1 -> 3�� �߿� 1�� �̱� 
//��, ���Դ� ��쵵 ����(�� ������ ���� ������ 2����� �� �Դ� ��� null�� ������ 3���� ����ؾ� �Ѵ�.)
//�Ѵ� �� �Դ� ���� �˸��̹Ƿ� -1����� �� 


//3C1 * 2C1 - 1 



//nCr => n * n-1 * n-2 ... 1 / r * r-1 * r-2...1
//n * n-1 * ... * n-r+1
//��, ����Ʈ �� �ϳ��� ���� ������ ������ nC1�� ����� �䱸�Ѵ�, 
//nC1 = n;

//�ڹٿ��� ������ ����ϱ�
