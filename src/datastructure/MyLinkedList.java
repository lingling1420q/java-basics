package datastructure;

/**
 *
 * @author kundy
 * @createTime:Nov 14, 2018 4:54:51 PM
 *
 */
public class MyLinkedList<T> {

	private Node<T> firstNode;
	private int size;

	public MyLinkedList() {
		firstNode = new Node<T>(null, null);
		size = 0;
	}

	/**
	 * Features:销毁链表，如果是基于C语言实现，需要释放链表。但是在Java语言中，会有系统自动执行GC，不需要手动释放内存
	 */
	public void destroyLinkList() {
		Node<T> curNode = firstNode;
		while (curNode != null) {
			// 把当前的结点保存在tmpNode中
			@SuppressWarnings("unused")
			Node<T> tmpNode = curNode;
			// 把下一个结点当到curNode中
			curNode = curNode.nextNode;
			// 释放当前结点
			tmpNode = null;
		}
		size = 0;
	}

	/**
	 * Features: 按索引查找
	 */
	public T get(int index) {
		return this.getNodeByIndex(index).data;
	}

	/**
	 * Features:根据元素的值，返回元素首次出现的索引
	 */
	public int indexOf(Object value) {
		Node<T> curNode = firstNode.nextNode;
		int i = 0;
		while (curNode != null && !curNode.data.equals(value)) {
			curNode = curNode.nextNode;
			i++;
		}
		if (i == size) {
			i = -1;
		}
		return i;
	}

	/**
	 * Features:在链表的最后添加值
	 */
	public boolean add(T value) {
		return this.add(size, value);
	}

	/**
	 * Features:在第index位置插入值
	 */
	public boolean add(int index, T value) {
		// 寻找第i-1个结点
		Node<T> preNode = this.getNodeByIndex(index - 1);
		Node<T> insertNode = new Node<T>(value, preNode.nextNode);
		preNode.nextNode = insertNode;
		size++;
		return true;
	}

	/**
	 * Features:根据索引删除元素
	 */
	public boolean delete(int index) {
		// 寻找第i-1个结点
		Node<T> preNode = this.getNodeByIndex(index - 1);
		Node<T> deleteNode = preNode.nextNode;
		preNode.nextNode = deleteNode.nextNode;
		deleteNode = null;
		size -= 1;
		return true;
	}

	/**
	 * Features:按索引查找节点
	 */
	private Node<T> getNodeByIndex(int index) {
		// 如果index等于size还是允许查找，因为存在头结点。如果index合法，则必定可以得到结果
		if (index > size) {
			throw new IndexOutOfBoundsException("下标违法：index=" + index + " size=" + size);
		}
		Node<T> curNode = firstNode;
		int j = -1;
		while (curNode != null && j < index) {
			curNode = curNode.nextNode;
			j++;
		}
		return curNode;
	}

	/**
	 * Features:返回当前链表中的元素个数
	 */
	public int getSize() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				sb.append(this.get(i));
			} else {
				sb.append(this.get(i) + ",");
			}

		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 链表节点
	 */
	private static class Node<T> {
		private T data;
		private Node<T> nextNode;

		public Node(T data, Node<T> nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	}

}
