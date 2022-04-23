package DataStrucInterface;

public interface List<E> {
	//리스트에 요소를 추가합니다.
	//리스트에서 중복을 허용하지 않을 경우, 이미 리스트에 중복되는 요소가 있다면 false, 업다면 true
	boolean add(E value);
	
	//리스트의 특정 위치에 요소를 추가합니다. 
	//특정위치 이우의 요소들은 한 칸씩 뒤로 밀립니다. 
	void add(int idx, E value);
	
	//리스트의 idx위치에 있는 요소를 삭제합니다. 
	//삭제된 요소를 반환합니다.
	E remove(int idx);
	
	//리스트에서 특정 요소를 삭제합니다. 만약 중복을 허용한 경우, 가장 처음 발견한 요소만 삭제됩니다. 
	//리스트에 삭제할 요소가 없거나 삭제에 실패한 경우 -> false, 삭제 성공 -> true
	boolean remove(Object value);
	
	//리스트의 특정 위치의 요소를 반환 
	E get(int idx);
	
	//특정 위치의 요소를 새 요소로 대체
	void set(int idx, E value);
	
	//특정요소가 존재하는지 확인 
	//존재 -> true, 존재x -> false
	boolean contains(Object value);
	
	//리스트에 특정 요소가 몇 번째 위치에 있는지를 반환합니다. 
	//가장 처음으로 만난 요소의 위치를 반환, 없을 경우 -1 반환
	int indexOf(Object value);
	
	//리스트에 저장된 요소의 개수 반환 
	int size();
	
	//리스트가 비어있는지 확인 
	boolean isEmpty();
	
	//리스트에 있는 모든 요소 삭제
	public void clear();
	
}
