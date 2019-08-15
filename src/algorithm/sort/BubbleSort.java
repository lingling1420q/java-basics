package algorithm.sort;

/**
 * 冒泡排序
 * <p>
 * 当前最大或者最小的数会一直往上冒泡。。。【一直做交换，所以一直冒泡】
 *
 * @author kundy
 * @date 2019/8/15 12:29 PM
 */
public class BubbleSort implements Sort {


    @Override
    public void go(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    this.swap(array, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 2, 3, 1, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.go(array);
        bubbleSort.print(array);
    }

}
