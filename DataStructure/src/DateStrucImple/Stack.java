package DateStrucImple;

import java.util.Arrays;
import java.util.EmptyStackException;
import DataStrucInterface.StackInterface;

public class Stack<E> implements StackInterface<E> {

	//������ �����ϱ�
		private static final int DEFAULT_CAPACITY = 10;	// �ּ�(�⺻) ���� ũ�� = ������ ���� �Ҵ� ũ�� 
		private static final Object[] EMPTY_ARRAY = {};	// �� �迭 
		
		private Object[] array;	// ��Ҹ� ���� �迭  
		private int size;	// ��� ���� 
		
		
		// ������1 (�ʱ� ���� �Ҵ� X) ��ü�� �����ϰ� ���� ��
		public Stack() {
			this.array = EMPTY_ARRAY; //�ʱ� ���� �Ҵ��� �� �߱� ������ �� �迭�� �ʱ�ȭ
			this.size = 0;
		}
		
		// ������2 (�ʱ� ���� �Ҵ� O) 
		public Stack(int capacity) {
			this.array = new Object[capacity];
			this.size = 0;
		}
		
		
		//���� �Ҵ��� ���� resize�޼ҵ� ����
		private void resize(){
			//�� �迭�� ��� (capacity is 0)
			if(Arrays.equals(array, EMPTY_ARRAY)) {
				array = new Object[DEFAULT_CAPACITY];
				return;
			}
			
			
			int arrayCapacity = array.length; //���� ����
			
			//������ ���� �� ��� -> ����
			if(size == arrayCapacity){
				int newSize = arrayCapacity * 2;
				
				//������ ���ÿ� ��Ҹ� ���� 
				array = Arrays.copyOf(array, newSize);
				return;
			}
			
			//������ ���� �̻� ���� �� -> ����
			if(size < (arrayCapacity/2)) {
				int newCapacity = (arrayCapacity/2);
				
				//������ ���ÿ� ��� ����
				array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));// �� �� �� ū������ �ٲٱ�. �ּ� �������ٴ� Ŀ���ϱ� ��������
			}
		}
		@Override
		public E push(E item) {
			// TODO Auto-generated method stub
			if(size == array.length) {
				resize();
			}
			array[size] = item; //������ ��ġ�� ��� �߰� 
			size++; //������(��Ұ���) 1 ����h
			return item;
		}

		@Override
		public E pop() {
			// TODO Auto-generated method stub
			//������ ��Ұ� ���� ��� ������ ����ִٴ� ���� �߻���Ű�� 
			if(size == 0) {
				throw new EmptyStackException();
			}
			//size�� ���� ��Ұ����̰�, Object�迭�� �ִ� ���̱� ������ �迭�� �ε������� �����ؾ� �Ѵ�.
			@SuppressWarnings("unchecked")
			E obj = (E)array[size-1]; //������ ��Ҹ� ��ȯ�ϱ� ���� �ӽú���
			return null;
		}

		@Override
		public E peek() {
			// TODO Auto-generated method stub
			//������ ��Ұ� ���� ��� ������ ����ִٴ� ���� �߻���Ű�� 
			if(size == 0) {
				throw new EmptyStackException();
			}
			
			return (E) array[size-1]; //EŸ������ ĳ�����ؼ� ��ȯ -> EŸ���� ����ڰ� ������ ����Ŭ����, �ᱹ�� �迭 OBJ -> ����� ���� wrapper�� ĳ�����ϴ� ��
		}

		@Override
		public int search(Object value) {
			// TODO Auto-generated method stub
			//�������� �ֻ�ܺ��� �˻�����
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
				array[i] =null; //�迭 ���� ��ü�̹Ƿ� 0���� �ִ� �ͺ��� null�� �ִ°��� ����. 
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
			
			// ���ο� ���� ��ü ����
			//super�� ObjectŬ�����̴�. 
			Stack<?> cloneStack = (Stack<?>)super.clone();
			
			// ���ο� ������ �迭�� ������ �־�� ��(���� ��ü�� ���� ���簡 ���� ����)
			cloneStack.array = new Object[size];
			
			// ���� �迭�� ���ο� ������ �迭�� ���� ������; 
			System.arraycopy(array, 0, cloneStack.array, 0, size);
			return cloneStack;
		}

}
