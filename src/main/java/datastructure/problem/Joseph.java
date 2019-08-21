package datastructure.problem;

import datastructure.SequenceList;

/**
 *
 * 约瑟夫问题：设由n个人围坐在一个圆桌周围，现从第s个人开始从1报数，数到m的人出列，然后从出列的下
 * 一个人重新开始从1报数，数到m的人在出列。。。。如此反复，知道所有的人都出列，求出出列的次序
 *
 * @author kundy
 * @createTime:Nov 14, 2018 2:58:07 PM
 *
 */
public class Joseph {

	public static void josephSequence(SequenceList<?> list, int s, int m) {
		// 顺序表的下标从0开始
		s -= 1;
		System.out.print("输出约瑟夫序列：");
		for (int i = list.getLength(); i > 0; i--) {
			// 从顺序表中的第s个元素开始寻找s+m-1的元素，找到最后输出（在寻找过程中若到表尾，则跳到开始位置，通过取模实现）
			s = (s + m - 1) % i;
			System.out.print(list.get(s) + "\t");
			list.delete(s);
		}
	}

	public static void main(String[] args) {
		int s = 1;
		int m = 3;
		SequenceList<Integer> list = new SequenceList<>(10);
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		list.addAsArray(array);

		josephSequence(list, s, m);

	}

}
