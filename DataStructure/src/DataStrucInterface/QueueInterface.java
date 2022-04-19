package DataStrucInterface;

public interface QueueInterface<E> {
		//큐의 가장 마지막에 요소를 추가한다. 
		//e는 큐에 추가할 요소. 큐에 요소가 정상적으로 추가되었을 때, true를 반환
		boolean offer(E e);
		
		//큐의 첫 번째 요소를 삭제하고 삭제 된 요소를 반환
		E poll();
		
		//큐의 첫 번째 요소를 삭제하지 않고 반환
		E peak();
}
