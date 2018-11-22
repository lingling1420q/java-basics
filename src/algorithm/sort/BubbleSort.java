package algorithm.sort;

import java.util.List;

/**
 *
 * @author kundy
 * @createTime:Nov 22, 2018 3:47:37 PM
 *
 */
public class BubbleSort {

	/**
	 * Features:降序
	 * 
	 * @param list
	 */
	public static void byDesc(List<Integer> list) {
		sort(list, true);
	}

	/**
	 * Features:升序
	 * 
	 * @param list
	 */
	public static void byAsc(List<Integer> list) {
		sort(list, false);
	}

	/**
	 * Features:根据flag值进行升序or降序排列
	 * 
	 * @param list
	 * @param flag
	 *            true=升序 false=降序
	 */
	private static void sort(List<Integer> list, boolean flag) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				boolean condiction = list.get(i) < list.get(j);
				if (condiction == flag) {
					// 交换两个元素的位置
					int tmp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tmp);
				}
			}
		}
	}

}
