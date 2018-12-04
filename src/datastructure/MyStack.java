package datastructure;

/**
 *
 * @author kundy
 * @createTime:Dec 3, 2018 5:13:15 PM
 *
 */
public class MyStack<T extends Object> {

	private int capacity;
	private Object datas[];
	private int length;
	private int top;// 记录栈顶位置

	public MyStack() {
		this.capacity = 16; // 默认初始容量为16
		this.length = 0; // 元素个数初始化为0
		top = -1; // 栈顶置为-1，表示空栈
		datas = new Object[capacity];
	}

	public MyStack(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("初始容量必须大于零");
		}
		this.capacity = capacity;
		this.length = 0;
		top = -1;
		datas = new Object[capacity];
	}

	/**
	 * Features:判断当前栈是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	/**
	 * Features:入栈
	 * 
	 * @return 当前栈顶索引
	 */
	public int push(T element) {
		if (top == capacity - 1) {
			throw new RuntimeException("栈已满，不能再进行入栈操作");
		}
		top++;
		length++;
		datas[top] = element;
		return top;
	}

	/**
	 * Features:出栈
	 * 
	 * @return 返回出栈元素
	 */
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈已空，不能再进行出栈操作");
		}
		@SuppressWarnings("unchecked")
		T tmp = (T) datas[top];
		datas[top--] = null;
		length--;
		return tmp;
	}

	/**
	 * Features:获取栈顶元素
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getTop() {
		if (isEmpty()) {
			throw new RuntimeException("栈已空");
		}
		return (T) datas[top];
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < length; i++) {
			if (i == length - 1) {
				sb.append(datas[i]);
			} else {
				sb.append(datas[i] + ",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
