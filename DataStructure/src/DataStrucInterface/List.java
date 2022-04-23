package DataStrucInterface;

public interface List<E> {
	//����Ʈ�� ��Ҹ� �߰��մϴ�.
	//����Ʈ���� �ߺ��� ������� ���� ���, �̹� ����Ʈ�� �ߺ��Ǵ� ��Ұ� �ִٸ� false, ���ٸ� true
	boolean add(E value);
	
	//����Ʈ�� Ư�� ��ġ�� ��Ҹ� �߰��մϴ�. 
	//Ư����ġ �̿��� ��ҵ��� �� ĭ�� �ڷ� �и��ϴ�. 
	void add(int idx, E value);
	
	//����Ʈ�� idx��ġ�� �ִ� ��Ҹ� �����մϴ�. 
	//������ ��Ҹ� ��ȯ�մϴ�.
	E remove(int idx);
	
	//����Ʈ���� Ư�� ��Ҹ� �����մϴ�. ���� �ߺ��� ����� ���, ���� ó�� �߰��� ��Ҹ� �����˴ϴ�. 
	//����Ʈ�� ������ ��Ұ� ���ų� ������ ������ ��� -> false, ���� ���� -> true
	boolean remove(Object value);
	
	//����Ʈ�� Ư�� ��ġ�� ��Ҹ� ��ȯ 
	E get(int idx);
	
	//Ư�� ��ġ�� ��Ҹ� �� ��ҷ� ��ü
	void set(int idx, E value);
	
	//Ư����Ұ� �����ϴ��� Ȯ�� 
	//���� -> true, ����x -> false
	boolean contains(Object value);
	
	//����Ʈ�� Ư�� ��Ұ� �� ��° ��ġ�� �ִ����� ��ȯ�մϴ�. 
	//���� ó������ ���� ����� ��ġ�� ��ȯ, ���� ��� -1 ��ȯ
	int indexOf(Object value);
	
	//����Ʈ�� ����� ����� ���� ��ȯ 
	int size();
	
	//����Ʈ�� ����ִ��� Ȯ�� 
	boolean isEmpty();
	
	//����Ʈ�� �ִ� ��� ��� ����
	public void clear();
	
}
