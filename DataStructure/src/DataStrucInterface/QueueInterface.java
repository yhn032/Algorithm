package DataStrucInterface;

public interface QueueInterface<E> {
		//ť�� ���� �������� ��Ҹ� �߰��Ѵ�. 
		//e�� ť�� �߰��� ���. ť�� ��Ұ� ���������� �߰��Ǿ��� ��, true�� ��ȯ
		boolean offer(E e);
		
		//ť�� ù ��° ��Ҹ� �����ϰ� ���� �� ��Ҹ� ��ȯ
		E poll();
		
		//ť�� ù ��° ��Ҹ� �������� �ʰ� ��ȯ
		E peak();
}
