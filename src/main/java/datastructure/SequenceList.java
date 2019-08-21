package datastructure;

/**
 * 
 * @author kundy
 * @createTime:Nov 12, 2018 4:46:20 PM
 *
 * @param <T>
 */
public class SequenceList<T extends Object> {

	private int capacity;
	private Object datas[];
	private int length;

	public SequenceList() {
		this.capacity = 4;
		// 默认初始容量为4
		datas = new Object[capacity];
		length = 0;
	}

	public SequenceList(int capacity) {
		if (capacity > 0) {
			this.capacity = capacity;
			datas = new Object[capacity];
			length = 0;
		} else {
			throw new IllegalArgumentException("初始容量必须大于零");
		}

	}

	public int getLength() {
		return length;
	}

	public int getCapacity() {
		return capacity;
	}

	/**
	 * 
	 * Features:根据索引获取元素
	 *
	 * Time Complexity:
	 *
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(int index) {
		ensureIndexLegal(index);
		return (T) datas[index]; // 强转泛型
	}

	/**
	 * 
	 * Features:查找值为target的元素，返回首次出现的位置，不存在返回-1
	 *
	 * Time Complexity: 比较的次数与target在表中的位置有关，也与表长有关。当data[0]=target时，一次比较成功，
	 * 当data[n]=target时比较n次成功，平均比较次数为(n+1)/2；若检索不成功时循环n+1次。 时间复杂度为O(n)；
	 *
	 * @param target
	 * @return
	 */
	public int indexOf(Object target) {
		int i = 0;
		/*
		 * 编译时看起来调的是Object类的equal方法（比较的还是两个对象的地址）
		 * 但是运行时是调用实际传入的对象的equal方法（那就得看实际的对象是如何重写equal方法）很妙！
		 * 
		 */
		while (i < length && (!datas[i].equals(target))) {
			i++;
		}
		if (i < length) {
			return i;
		} else {
			return -1;
		}
	}

	/**
	 * 
	 * Features:在index的位置插入值为value的元素，插入成功返回index
	 *
	 * Time Complexity:时间主要消耗在数据的移动上，在第index个位置上插入value，从data[index]到data[length]
	 * 都需要向下移动一个位置，共需要移动length-i+1个元素，时间复杂度为O(n)
	 *
	 * @param index
	 *            待插入元素位置
	 * @param value
	 *            待插入元素的值
	 * @return
	 */
	public int insert(int index, T value) {
		ensureInsertIndexLegal(index);
		for (int j = length; j > index; j--) {
			datas[j] = datas[j - 1]; // move elements from the tail
		}
		datas[index] = value;
		length++;
		return index;
	}

	/**
	 * 
	 * Features:在顺序表的末尾添加值为value的元素，返回插入位置
	 *
	 * Time Complexity:
	 *
	 * @param value：待插入元素值
	 * @return
	 */
	public int add(T value) {
		if (length >= capacity) {
			throw new IndexOutOfBoundsException("顺序表已满：index=" + length + " capacity：" + capacity);
		}
		datas[length] = value;
		length++;
		return length - 1;
	}

	/**
	 * 
	 * Features:通过数组的形式添加元素
	 *
	 * Time Complexity:
	 *
	 * @param array
	 * @return
	 */
	public boolean addAsArray(T[] array) {
		int i = 0;
		boolean result = false;
		try {
			for (; i < array.length; i++) {
				this.add(array[i]);
			}
		} finally {
			if (i != array.length) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * 
	 * Features:根据元素索引删除元素，返回index
	 *
	 * Time Complexity:O(n)
	 *
	 * @param index
	 * @return
	 */
	public int delete(int index) {
		ensureIndexLegal(index);
		for (int j = index; j < length - 1; j++) {
			datas[j] = datas[j + 1];
		}
		datas[length - 1] = null; // 最后一位置空
		length--;
		return index;
	}

	/**
	 * 
	 * Features:求出集合A与集合B的并集
	 *
	 * Time Complexity:
	 *
	 * @param list
	 */
	public void union(SequenceList<T> list) {
		for (int i = 0; i < list.getLength(); i++) {
			T curValue = list.get(i);
			if (this.indexOf(curValue) == -1) {
				this.add(curValue);
			}
		}
	}

	/**
	 * 
	 * Features:求出当前集合A与集合B的交集，这里不能使用循环B集合，然后直接使用delete()方法删除A中不在B集合的元素，
	 * 因为调用delete()方法会导致元素的移动，删除第i个元素的时候，位置相对于上一次已经向前移动了。 （此算法不保证元素的唯一性）
	 *
	 * Time Complexity:
	 *
	 * @param list
	 * @return
	 */
	public boolean intersection(SequenceList<T> list) {
		int i = 0;
		int w = 0;
		boolean result = false;
		try {
			for (; i < this.length; i++) {
				T curValue = this.get(i);
				if (list.indexOf(curValue) != -1) {
					this.datas[w++] = this.datas[i];
				}
			}
		} finally {
			// 异常情况，list中的元素都没有比较完毕，需要处理异常
			if (i != this.length) {
				return false;
			}
			// 清空w位置后的所有元素
			if (w != this.length) {
				for (int k = w; k < this.length; k++) {
					this.datas[k] = null;
				}
			}
			this.length = w;
			result = true;
		}
		return result;

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("datas[" + i + "]=" + datas[i] + "\t");
		}
		return sb.toString();
	}

	/**
	 * 
	 * Features:打印所有的元素，包括null元素
	 *
	 * Time Complexity:
	 *
	 */
	public void printAllElement() {
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
	}

	/**
	 * 
	 * Features:确定索引是否合法
	 *
	 * Time Complexity:
	 *
	 * @param index
	 */
	private void ensureIndexLegal(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("位置非法：index=" + index + " length：" + length);
		}
	}

	/**
	 * 
	 * Features:确定插入索引是否合法
	 *
	 * Time Complexity:
	 *
	 * @param index
	 */
	private void ensureInsertIndexLegal(int index) {
		if (index < 0 || index >= capacity) {
			throw new IndexOutOfBoundsException("插入位置非法：index=" + index + " capacity：" + capacity);
		}
	}

	public static void main(String[] args) {
		SequenceList<Integer> list = new SequenceList<>(10);
		Integer[] array = { 1, 2, 3, 4 };
		list.addAsArray(array);

		list.insert(1, 123);

		System.out.println(list);

	}

}
