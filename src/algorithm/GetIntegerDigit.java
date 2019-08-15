package algorithm;

/**
 * 获取整数的每一位
 *
 * @author kundy
 * @date 2019/8/15 9:14 PM
 */
public class GetIntegerDigit {

    public static void main(String[] args) {
        Integer[] eachDigit = getEachDigit(6421);
        for (Integer anEachDigit : eachDigit) {
            System.out.print(anEachDigit + " ");
        }
    }

    public static Integer[] getEachDigit(Integer num) {
        if (num < 0) {
            throw new RuntimeException("num 不能为负数");
        }
        Integer[] digits = new Integer[getNumberOfDigits(num)];
        for (int i = 0; i < digits.length; i++) {
            if (i == 0) {
                digits[i] = num % 10;
            } else {
                digits[i] = num / (int) Math.pow(10, i) % 10;
            }
        }
        return digits;
    }

    /**
     * 获取整数一共有多少位
     */
    private static Integer getNumberOfDigits(Integer num) {
        return (int) Math.log10(num) + 1;
    }

}
