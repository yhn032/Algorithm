package Sort;

public class MergeSort_bottom_up {
	
	/*
		@param a		정렬할 배열
		@param left		배열의 시작점
		@param mid		배열의 중간점
		@param right	배열의 끝  점
	*/

	private static int[] sorted;
	
	public static void merge_sort(int[] a) {
		sorted = new int[a.length];
		merge_sort(a, 0, a.length);
		sorted = null;//초기화
	}
	
	//중간지점을 새로 구하면서 분할하는 메소드
	private static void merge_sort(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		for(int size = 1; size<=right; size+= size) {
			
			/*
			 * 두 부분리스트을 순서대로 병합해준다.
			 * 예로들어 현재 부분리스트의 크기가 1(size=1)일 때
			 * 왼쪽 부분리스트(low ~ mid)와 오른쪽 부분리스트(mid + 1 ~ high)를 생각하면
			 * 왼쪽 부분리스트는 low = mid = 0 이고,
			 * 오른쪽 부분리스트는 mid + 1부터 low + (2 * size) - 1 = 1 이 된다.
			 *  
			 * 이 때 high가 배열의 인덱스를 넘어갈 수 있으므로 right와 둘 중 작은 값이
			 * 병합되도록 해야한다. 
			 */
			for(int l=0; l<=right-size; l+=(2*size) ) {
				int low = l;
				int mid = l + size -1;
				int high = Math.min(l+(2*size)-1, right);
				merge(a, low, mid, high); //병합
			}
		}
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
			
		}
		
		//정렬된 새 배열을 복사한다. 
		for(int i=left; i<=right; i++) {
			a[i] = sorted[i];
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
		
*/
