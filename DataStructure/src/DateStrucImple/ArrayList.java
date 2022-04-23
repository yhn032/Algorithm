package DateStrucImple;

import DataStrucInterface.List;

public class ArrayList<E> implements List<E> {
	/*
		Object[]배열, 즉 객체배열을 두고 사용한다. 
		동적할당을 한다
		데이터 사이에 빈 공간을 허용하지 않는다. -> 리스트 계열 자료구조는 데이터들이 "연속"되어 있어야 한다.
	*/
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ARRAY = {}; // 빈 배열
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(E value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int idx, E value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int idx, E value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
