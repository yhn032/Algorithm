package Sort;

public class MergeSort_bottom_up {
	
	/*
		@param a		������ �迭
		@param left		�迭�� ������
		@param mid		�迭�� �߰���
		@param right	�迭�� ��  ��
	*/

	private static int[] sorted;
	
	public static void merge_sort(int[] a) {
		sorted = new int[a.length];
		merge_sort(a, 0, a.length);
		sorted = null;//�ʱ�ȭ
	}
	
	//�߰������� ���� ���ϸ鼭 �����ϴ� �޼ҵ�
	private static void merge_sort(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		for(int size = 1; size<=right; size+= size) {
			
			/*
			 * �� �κи���Ʈ�� ������� �������ش�.
			 * ���ε�� ���� �κи���Ʈ�� ũ�Ⱑ 1(size=1)�� ��
			 * ���� �κи���Ʈ(low ~ mid)�� ������ �κи���Ʈ(mid + 1 ~ high)�� �����ϸ�
			 * ���� �κи���Ʈ�� low = mid = 0 �̰�,
			 * ������ �κи���Ʈ�� mid + 1���� low + (2 * size) - 1 = 1 �� �ȴ�.
			 *  
			 * �� �� high�� �迭�� �ε����� �Ѿ �� �����Ƿ� right�� �� �� ���� ����
			 * ���յǵ��� �ؾ��Ѵ�. 
			 */
			for(int l=0; l<=right-size; l+=(2*size) ) {
				int low = l;
				int mid = l + size -1;
				int high = Math.min(l+(2*size)-1, right);
				merge(a, low, mid, high); //����
			}
		}
	}
	
	
	
	//�պ��ϸ鼭 ����
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int idx = left; //���� �� ä������ �迭�� �ε��� ���� ������������ set
		
		while(l <= mid && r <= right) { //�� �κи���Ʈ�� �������� ������ ������ ������ �ݺ�
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			} else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
			
			
			if(l > mid) { //���� �κи���Ʈ�� ��� ä�����ٸ�, ������ ������ �κи���Ʈ�� ū ���� �ִٴ� ���̹Ƿ� �������� ��� ä���.(���� ���� �������� �ö�Ա� ������ �̹� ���� �Ǿ� �ִ� ������)
				while(r <= right) {
					sorted[idx] = a[r];
					idx++;
					r++;
				}
			}else {
				while(l <= mid) {
					sorted[idx] = a[l];
					idx++;
					l++;
				}
				
			}
			
		}
		
		//���ĵ� �� �迭�� �����Ѵ�. 
		for(int i=left; i<=right; i++) {
			a[i] = sorted[i];
		}
	}
}

/*
	�������� 
	
	������ �����ϰ�, ������ ������ �����Ͽ� ��ġ�� �����̴�. 
	�⺻������ ���� ���� �˰����� ������� ���ĵǴ� ����̴�.
	�����ؾ� �� ����Ʈ�� �־����� �ش� ����Ʈ�� ������ �ݺ��Ͽ� �ִ��� �۰� �ɰ��� ������ �κи���Ʈ���� ������ ���ҵ鳢�� ���Ϸ� �����ϴ� ����̴�. 
	
	��   ���� : �����͸� "��"�ϸ鼭 ã�´�.
	���ڸ� ����x: ������ ����� �Ǵ� ������ �ܿ� �߰����� ������ �ʿ�� �Ѵ�.(���ڸ� ���ķ� ������ ���� ������ �� ��� ������ �Ϻ� �����ؾ� �Ѵ�.)
	����   ���� : �ִ��� �۰� ������ �ɰ��� ���� �κ� ����Ʈ���� ���ʴ�� ���ĳ����� ������ ���������̴�.
	
	���� ���(two-way���. �ݵ�� �ΰ��� �κи���Ʈ�� ���� �ʿ�� ����.)
	1. �־��� ����Ʈ�� �������� �����Ͽ� �κ� ����Ʈ�� ������. (����)
	2. �ش� �κ� ����Ʈ�� ���̰� 1�� �ƴ϶�� 1�� ������ ��Ǯ���Ѵ�. 
	3. ������ �κи���Ʈ���� �����Ͽ� ��ģ��.(����)
		
*/
