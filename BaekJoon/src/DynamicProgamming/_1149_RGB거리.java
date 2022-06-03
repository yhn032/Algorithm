package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149_RGB�Ÿ� {
	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//bottom-up���� Ǯ��� 
		
		int n = Integer.parseInt(br.readLine());
		
		int cost[][] = new int[n][3];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3 ; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//�޸������̼� -> ��Ϳ� ���� ���� ��� ������ ������, �迭�� ȣ���Ҷ�, ���� �ε����� ����� �������� ������ Ȱ���ϱ� ������ �� ���� �޸������̼��̶�� ���� �˾Ƶξ��
		
		//�ʱ갪�� �״�� �ΰ� �����Ѵ�. 
		for(int i=1; i<n; i++) {
			cost[i][RED]   += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
			cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
			cost[i][BLUE]  += Math.min(cost[i-1][GREEN], cost[i-1][RED]);
		}
		
		System.out.println(Math.min(Math.min(cost[n-1][RED], cost[n-1][GREEN]),cost[n-1][BLUE]));
	}

}


/*
	������ ���� �ٸ� ������ ĥ�ؾ� �Ѵ�.
	
	
	  3
	  r  g  b
	1 26 40 83
	2 49 60 57
	3 13 89 99
	
	3���� ���� ���� ��, 1������ r�� ĥ�ϴ� ����� 26, g�� 40, b�� 83�̴�.
	
	�ߺ��� ������� �ʰ� 3���� �̴� ����� ���� ã�ƺ��� 
	�ٷ� ������ ���� ���� ���� ������ �ȴ�. r b r �̷����� ���� 
	
	1 2 3
	r g b		26 + 60 + 99
	r b g		26 + 57 + 13 
	g r b		40 + 49 + 99
	g b r		...
	b r g		...
	b g r		...
	
	�ּڰ��� ���ϱ� ���ؼ��� �� �������� ����� �ּ��� ���� ���� �Ѵ�. 
	�̶� ������ ���� ĥ������ ���� ������ �ȵȴ�. 
	
	��ȭ���� ��� ���� �� ������? D[N]
	D[1] = r, g, b �� �ּ� ���
	D[2] = D[1]���� ������ ���� ������ ��� �� �ּ�
	D[3] = D[2]���� ������ ���� ������ ��� �� �ּ�
	D[N] = D[N-1]���� ������ ���� ������ ��� �� �ּ� 
	
	���� �ٷ� ���� ���� ���� ���� �����ϰ� ����ϸ� �ȴ�.
	
	
	��ȭ���� �߸��Ǿ���. �ٽ� Ǯ����
	
	�� �������� �ּڰ��� ���ϰ��� �ϸ� ��Ȯ�� �ּڰ��� �������� �ʴ´�. 
	���Ʈ ���� ������� �ʱ갪�� �ʱ�ȭ �ϰ� �� ���� ���� ��� ����Ǽ��� ���Ѵ��� �� �� �ּڰ��� ������ ������� ���ؾ� �Ѵ�. 
*/
