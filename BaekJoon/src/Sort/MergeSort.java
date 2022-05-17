package Sort;

public class MergeSort {
	
	/*
		@param a		정렬할 배열
		@param left		배열의 시작점
		@param mid		배열의 중간점
		@param right	배열의 끝  점
	*/

	private static int[] sorted;
	
	public static void merge_sort(int[] a) {
		sorted = new int[a.length];
		merge_sort(a, 0, a.length-1);
		sorted = null;//초기화
	}
	
	//중간지점을 새로 구하면서 분할하는 메소드
	private static void merge_sort(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		if(left == right) {//최대한으로 다 쪼갬
			return;
		}
		
		int mid = (left+right)/ 2; //절반위치
		
		merge_sort(a, left, mid);		//절반 중 왼쪽   부분 리스트
		merge_sort(a, mid+1, right);	//절반 중 오른쪽 부분 리스트
		
		merge(a, left, mid, right);
	}
	
	//합병하면서 정복
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int idx = left; //정렬 후 채워넣을 배열의 인덱스 가장 왼쪽지점으로 set
		
		while(l <= mid && r <= right) { //각 부분리스트의 시작점이 끝점에 도달할 때까지 반복
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
		
		if(l > mid) { //왼쪽 부분리스트가 모두 채워졌다면, 나머지 오른쪽 부분리스트는 큰 수만 있다는 뜻이므로 나머지를 모두 채운다.(제일 작은 단위부터 올라왔기 때문에 이미 정렬 되어 있는 상태임)
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
		
		//정렬된 새 배열을 복사한다. 
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
	병합정렬 
	
	문제를 분할하고, 분할한 문제를 정복하여 합치는 과정이다. 
	기본적으로 분할 정복 알고리즘을 기반으로 정렬되는 방식이다.
	정렬해야 할 리스트가 주어지면 해당 리스트를 분할을 반복하여 최대한 작게 쪼개진 시점에 부분리스트에서 인접한 원소들끼리 비교하려 정렬하는 방식이다. 
	
	비교   정렬 : 데이터를 "비교"하면서 찾는다.
	제자리 정렬x: 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 한다.(제자리 정렬로 구현할 수도 있지만 그 대신 성능을 일부 포기해야 한다.)
	안정   정렬 : 최대한 작게 문제를 쪼개어 앞의 부분 리스트부터 차례대로 합쳐나가기 때문에 안정정렬이다.
	
	정렬 방법(two-way방식. 반드시 두개의 부분리스트로 나눌 필요는 없다.)
	1. 주어진 리스트를 절반으로 분할하여 부분 리스트로 나눈다. (분할)
	2. 해당 부분 리스트의 길이가 1이 아니라면 1번 과정을 되풀이한다. 
	3. 인접한 부분리스트끼리 정렬하여 합친다.(정복)
	
	
	장점
	항상 두 부분리스트로 쪼개어 들어가기 때문에 최악의 경우에도 O(NlongN)으로 유지가 된다. 
	안정 정렬이다. 
	
	단점
	정렬과정에서 추가적인 보조 배열공간을 사용하기 때문에 메모리 사용량이 많다. 
	보조 배열에서 원본 배열로 복사하는 과정은 매우 많은 시간을 소비하기 때문에 데이터가 많을 경우 상대적으로 시간이 많이 소요된다.
		
*/
