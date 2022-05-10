package Sort;

public class BubbleSortWorst {
	
	/*
	
	 	BubbleSort 
	 	두 개의 인접한 원소를 비교하면서 정렬하는 방식
	 	비교   정렬 : 데이터를 "비교"하면서 찾는다.
	 	제자리 정렬 : 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 하지 않는다.(swap하는 과정에서 사용하는 임시변수는 충분히 무시할 만큼 작다.)
	 	안정   정렬 : 앞에서부터 차례대로 비교한다.
	 	
	 	정렬방법
	 	1. 앞에서부터 현재 원소와 바로 다음의 원소를 비교한다. 
	 	2. 현재 원소가 다음 원소보다 크면 원소를 교환한다. 
	 	3. 다음 원소로 이동하여 해당 원소와 그 다음 원소를 비교한다. 
	 	
	 	이때, 각 라운드를 진행할 때마다 맨 뒤에서 부터 한 개씩 정렬되기 때문에, 라운드가 진행될 때마다 비교횟수가 한 번씩 줄어든다.
	 	총 라운드는 배열의 크기 - 1번 진행되고, 각 라운드별 비교횟수는 (배열의 크기 - 라운드 횟수)
	 	
	 	[장점]
	 	추가적인 메모리 소비가 작다
	 	구현이 매우 쉽다 
	 	안정정렬이 가능하다 
	 	
	 	[단점]
	 	다른 정렬 알고리즘에 비해 교환 과정이 많아 많은 시간을 소비한다.
	 	
	 	정렬대상인 데이터 수 N, 라운드 i
	 	i=1일 때, 데이터 비교 횟수 N-1번 
	 	i=2일 때, 데이터 비교 횟수 N-2번 
	 	i=3일 때, 데이터 비교 횟수 N-3번 
	 		.
	 		.
	 		.
	 	i=N-1일 때, 데이터 비교 횟수 1번 
	 	
	 	일반화
	 	ㄴ> i=K일 때, 데이터 비교 횟수 N-K번

	 	
	 	평균 시간 복잡도 O(N^2) - 일반적인 구현 -> 정렬 되어 있더라도 각 라운드 별로 위의 반복 비교를 하기 때문
	 	
	 	최선 시간 복잡도 O(N) - 최선의 경우로 바꾸기 -> 비교수행을 할 때, 원소가 교환되지 않는다면, 이미 정렬된 데이터라는 의미이기 때문에 정렬을 종료하면 최선의 경우를 유도할 수 있다.
	 							즉, 각 라운드에서 비교수행을 했는지를 판단할 수 있는 상태변수를 하나 두면 되는 것이다. 
	 	
	 	
	 	삽입 정렬이나 선택정렬과 같은 시간복잡도를 가지지만, 평균적인 교환횟수는 거품 정렬이 더 많기 때문에, 
	 	실질적으로는 삽입, 선택 정렬보다 더 많은 시간이 걸린다.
	 	
	 	"""최선의 경우를 구현하라"""
	*/

	public static void bubble_sort(int[] a) {
		bubble_sort(a, a.length);
	}
	private static void bubble_sort(int[] a, int length) {
		// TODO Auto-generated method stub
		for(int i=1; i<length; i++) {
			for(int k =0; k<length-i; k++) {
				if(a[k] > a[k+1]) {
					swap(a, k, k+1);
				}
			}
		}
	}
								//          k      k+1
	private static void swap(int[] a, int i, int j)  {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
