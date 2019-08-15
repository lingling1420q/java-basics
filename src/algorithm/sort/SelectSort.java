package algorithm.sort;

/**
 * 选择排序：
 * 一遍一遍的遍历数组，把最小的元素放在第一位，次小的放在第二位，以此类推。
 *
 * @author kundy
 * @date 2019/8/15 11:08 PM
 */
public class SelectSort {

    public void go(Integer[] array) {

        // i < array.length - 1：最后一个数肯定是最大的，所以最后一个元素不用比较
        for (int i = 0; i < array.length - 1; i++) {
            int currentIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[currentIndex]) {
                    currentIndex = j;
                }
            }
            this.swap(array, i, currentIndex);
        }
    }

    private void swap(Integer[] array, Integer num1, Integer num2) {
        Integer tmp = array[num1];
        array[num1] = array[num2];
        array[num2] = tmp;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 2, 3, 1, 4};
        new SelectSort().go(array);
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
    }

}
