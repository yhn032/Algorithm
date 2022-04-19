package DateStrucImple;

import java.util.Arrays;
import java.util.EmptyStackException;
import DataStrucInterface.StackInterface;

public class Stack<E> implements StackInterface<E> {

	//생성자 구현하기
		private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기 = 생성시 최초 할당 크기 
		private static final Object[] EMPTY_ARRAY = {};	// 빈 배열 
		
		private Object[] array;	// 요소를 담을 배열  
		private int size;	// 요소 개수 
		
		
		// 생성자1 (초기 공간 할당 X) 객체만 생성하고 싶을 때
		public Stack() {
			this.array = EMPTY_ARRAY; //초기 공간 할당을 안 했기 때문에 빈 배열로 초기화
			this.size = 0;
		}
		
		// 생성자2 (초기 공간 할당 O) 
		public Stack(int capacity) {
			this.array = new Object[capacity];
			this.size = 0;
		}
		
		
		//동적 할당을 위한 resize메소드 구현
		private void resize(){
			//빈 배열일 경우 (capacity is 0)
			if(Arrays.equals(array, EMPTY_ARRAY)) {
				array = new Object[DEFAULT_CAPACITY];
				return;
			}
			
			
			int arrayCapacity = array.length; //현재 용적
			
			//용적이 가득 찰 경우 -> 증축
			if(size == arrayCapacity){
				int newSize = arrayCapacity * 2;
				
				//증축한 스택에 요소를 복사 
				array = Arrays.copyOf(array, newSize);
				return;
			}
			
			//용적이 절반 이상 사용될 때 -> 감축
			if(size < (arrayCapacity/2)) {
				int newCapacity = (arrayCapacity/2);
				
				//감축한 스택에 요소 복사
				array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));// 둘 중 더 큰값으로 바꾸기. 최소 용적보다는 커야하기 때문이지
			}
		}
		@Override
		public E push(E item) {
			// TODO Auto-generated method stub
			if(size == array.length) {
				resize();
			}
			array[size] = item; //마지막 위치에 요소 추가 
			size++; //사이즈(요소개수) 1 증가h
			return item;
		}

		@Override
		public E pop() {
			// TODO Auto-generated method stub
			//삭제할 요소가 없는 경우 스택이 비어있다는 예외 발생시키기 
			if(size == 0) {
				throw new EmptyStackException();
			}
			//size는 실제 요소개수이고, Object배열에 넣는 것이기 때문에 배열의 인덱스값을 참조해야 한다.
			@SuppressWarnings("unchecked")
			E obj = (E)array[size-1]; //삭제될 요소를 반환하기 위한 임시변수
			return null;
		}

		@Override
		public E peek() {
			// TODO Auto-generated method stub
			//삭제할 요소가 없는 경우 스택이 비어있다는 예외 발생시키기 
			if(size == 0) {
				throw new EmptyStackException();
			}
			
			return (E) array[size-1]; //E타입으로 캐스팅해서 변환 -> E타입은 사용자가 정의한 래퍼클래스, 결국은 배열 OBJ -> 사용자 정의 wrapper로 캐스팅하는 것
		}

		@Override
		public int search(Object value) {
			// TODO Auto-generated method stub
			//데이터의 최상단부터 검색시작
			for(int i=size-1; i>=0; i++) {
				if(array[i].equals(value))
					return size - i;
			}
			return -1;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			for(int i=0; i< size; i++) {
				array[i] =null; //배열 또한 객체이므로 0값을 주는 것보단 null을 주는것이 좋다. 
			}
			size = 0;
			resize();
		}

		@Override
		public boolean empty() {
			// TODO Auto-generated method stub
			return size ==0;
		}
		@Override
		public Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			
			// 새로운 스택 객체 생성
			//super는 Object클래스이다. 
			Stack<?> cloneStack = (Stack<?>)super.clone();
			
			// 새로운 스택의 배열도 생성해 주어야 함(내부 객체는 깊은 복사가 되지 않음)
			cloneStack.array = new Object[size];
			
			// 현재 배열을 새로운 스택의 배열에 값을 복사함; 
			System.arraycopy(array, 0, cloneStack.array, 0, size);
			return cloneStack;
		}

}
