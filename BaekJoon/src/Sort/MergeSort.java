package Sort;

public class MergeSort {
	
	/*
		@param a		������ �迭
		@param left		�迭�� ������
		@param mid		�迭�� �߰���
		@param right	�迭�� ��  ��
	*/

	private static int[] sorted;
	
	public static void merge_sort(int[] a) {
		sorted = new int[a.length];
		merge_sort(a, 0, a.length-1);
		sorted = null;//�ʱ�ȭ
	}
	
	//�߰������� ���� ���ϸ鼭 �����ϴ� �޼ҵ�
	private static void merge_sort(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		if(left == right) {//�ִ������� �� �ɰ�
			return;
		}
		
		int mid = (left+right)/ 2; //������ġ
		
		merge_sort(a, left, mid);		//���� �� ����   �κ� ����Ʈ
		merge_sort(a, mid+1, right);	//���� �� ������ �κ� ����Ʈ
		
		merge(a, left, mid, right);
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
		
		//���ĵ� �� �迭�� �����Ѵ�. 
		for(int i=left; i<=right; i++) {
			a[i] = sorted[i];
		}
	}
	public static void main(String[] args) {
		int arr[] = {8, 7, 6, 5, 4, 3, 2, 1};
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		merge_sort(arr);
		
		for(int i : arr) {
			System.out.print(i + " ");
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
	
	
	����
	�׻� �� �κи���Ʈ�� �ɰ��� ���� ������ �־��� ��쿡�� O(NlongN)���� ������ �ȴ�. 
	���� �����̴�. 
	
	����
	���İ������� �߰����� ���� �迭������ ����ϱ� ������ �޸� ��뷮�� ����. 
	���� �迭���� ���� �迭�� �����ϴ� ������ �ſ� ���� �ð��� �Һ��ϱ� ������ �����Ͱ� ���� ��� ��������� �ð��� ���� �ҿ�ȴ�.
		
*/
