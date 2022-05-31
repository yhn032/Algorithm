package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2004_����0�ǰ��� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int diff = n-m;
		
		long cnt_5 = five_pow(n) - five_pow(diff) - five_pow(m);
		long cnt_2 = two_pow(n) - two_pow(diff) - two_pow(m);
		
		long min = Math.min(cnt_5, cnt_2);
		
		System.out.println(min);
		
	}

	private static long five_pow(int n) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		/*
			n = 25��� 25!�� 25*24*23*...*3*2*1�̴�. �� ��� 5�� �¼��� ������ ����Ǽ��� 25 20 15 10 5�̴�. �̴� n/5�� 5�� ������ ��ġ
		*/
		while (n >= 5) {
			count += (n / 5);
			n /= 5;
		}
		return count;
	}
	
	private static long two_pow(int n) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		while (n >= 2) {
			count += (n / 2);
			n /= 2;
		}
		return count;
	}
}

/*
	C(n,m)���� ���ڸ� 0�� ������ ����Ͻÿ�
	
	�ش� ��(target)�� ��� �߿��� 10�� ����� ������ ���϶�.
	
	�Է¹���
	0<= m <= n <= 2,000,000,000     n!=0
	
	C(n,m) = n!/(m!*(n-m)!)
		   = (n*...*n-m+1)/m!
		   
	0! == 1! == 1
	
	"������ �ݵ�� ������ ��������." n >= m�̹Ƿ�
	
	
*/
