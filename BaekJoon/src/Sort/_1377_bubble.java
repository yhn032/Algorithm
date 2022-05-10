package Sort;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1377_bubble {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//���������� �ϴٰ� swap�� �Ͼ�� ���� round(i)���ϱ�
		//���� ������ �ּ��� ��찡 �Ͼ �� �ֵ��� �����ؾ� �ϸ� 
		//���� ��� ����� ���� Ž���ϱ� ���� ���� ���ĸ� �����ϸ� 
		// N�� �ִ밪�� 500,000�̹Ƿ� �־��� ��� �ð� �ʰ� �߻�
		// �ٸ� �˰����� ������ ���� �Ѵ�. 
		/*
			�⺻������ ���� ������ ����(i)���� ������(n-1)���� �̵��ϸ鼭 
			������ �� ���� ��Ҹ� ���Ѵ�. 
			�� �� ���࿡ swap�� �߻��ϸ�, ū ���� ����������, ���� ���� �������� �̵��Ѵ�.(�������� ����)
			���࿡ ū ���� ����ؼ� �迭�� ������ �̵��� ���̱� ������ ������� �ʿ����,
			���ҵǾ��� ��, ���� ���� �������� �ִ� 1��ŭ�� idx�̵��� ��������.(���������� ���� �ݴ�)
			����, ���� ���� �������� 1��ŭ �̵��ߴٴ� ���� �ش� ���忡�� swap�� ��� �� ���� �Ͼ�ٴ� �ǹ��̴�. 
			���� idx - ���� �� idx =>�� �ִ��� ���忡�� ������ �Ϸ�Ǿ� swap�� �߻����� �ʾҴ�. 
			
			[����]
			swap�� �߻��ϸ� �ִ밪(���� ���������� ��)�� �ƴ� ���� ���� �������� �ִ� 1��ŭ �̵��Ѵ�. 
			�� ���� ���� �� �̻� �̵����� ���� ���� �̹� ������ �Ϸ�� �����̴�. 
			���� �ε��� - ������ �ε��� �� �ִ��� ���Ѵ�.
			
			
			
			idx  0  1  2  3  4
			arr  10 1  5  2  3
			
	round 1 arr  1  5  2  3  10
	
	����	idx  1  3  4  2   0
	���� 	idx	 0  1  2  3   4
	round 2 arr  1  2  3  5  10	-> ������ �Ϸ�� ����
	
	
	idx���� ���� �ִ밪 -> 1  2  2  1   
	
	
	round 3 arr  1  2  3  5  10 -> 3round���� swap�� �߻����� �ʾҴ�. 
	
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		bubble[] arr = new bubble[N];
		
		for(int i=0; i<N;i++) {
			arr[i] = new bubble(Integer.parseInt(br.readLine()), i);
			//System.out.println(arr[i]);
		}
		
		Arrays.sort(arr);
		
		/*
		 * for(int i=0; i<arr.length; i++) { System.out.print(arr[i].data + " "); }
		 */
		
		//���� idx�� ���� �� idx�� ������.
		int max = 0; 
		for(int i=0; i<N; i++) {
			//         ����        ������
			if(max < arr[i].index - i) {
				max  = arr[i].index - i;
			}
		}
		
		//���� ���ø� ���� round2���� ������ �������� swap�߻��մϴ�. 
		//round3������ ������ �Ǿ� �����Ƿ� swap�߻� x
		//�츮�� ã�� ���� swap�̹߻����� �ʴ� round�̹Ƿ� max + 1�ؾ��մϴ�
		System.out.println(max+1);
		
	}

}
class bubble implements Comparable<bubble>{
	int index;
	int data;
	
	public bubble() {
		
	}
	
	public bubble(int data, int index) {
		this.data = data;
		this.index = index;
	}

	@Override
	public int compareTo(bubble o) {
		// TODO Auto-generated method stub
		
		return this.data - o.data;
	}

	// �������� ���� - > 0, ���� �϶��� ��ȯ x  | ����϶��� ��ȯ
	
}

