package datastructure.problem.stack;

import datastructure.MyStack;

/**
 * 进制转换，都是从低位到高位的顺序产生，而通常的输出应该是从高位到低位，与计算过程正好相反，
 * <p>
 * 因此转换过程中每得到一位结果则进栈保存，转换完毕后一次出栈则正好是转换结果
 * 
 * @author kundy
 * @createTime:Dec 4, 2018 12:06:07 PM
 *
 */
public class BinaryConversion {

	/**
	 * 
	 * Features: 打印转换的结果，因为srcNum是int类型参数，在方法里面对srcNum进行操作，并不会影响到srcNum原本的值
	 * 
	 * @param srcNum
	 *            带转换的数字
	 * @param r
	 *            转换目标进制
	 */
	public static void convert(int srcNum, int r) {
		if (srcNum <= 0) {
			throw new IllegalArgumentException("待转换参数必须大于零");
		}
		MyStack<String> stack = new MyStack<>();
		calReuslt(stack, srcNum, r);
		printStack(stack);
	}

	private static void calReuslt(MyStack<String> stack, int srcNum, int r) {
		while (srcNum != 0) {
			// 余数入栈
			stack.push(formatNum(srcNum % r));
			// 商作为被除数继续与r相除
			srcNum = srcNum / r;
		}
		switch (r) {
		case 2:
			stack.push("0b");
			break;
		case 8:
			stack.push("0");
			break;
		case 16:
			stack.push("0x");
			break;
		default:
			break;
		}
	}

	private static void printStack(MyStack<String> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	/**
	 * 
	 * Features:格式化十六进制下的10~16
	 * 
	 * @param num
	 * @return
	 */
	private static String formatNum(int num) {
		switch (num) {
		case 10:
			return "A";
		case 11:
			return "B";
		case 12:
			return "C";
		case 13:
			return "D";
		case 14:
			return "E";
		case 15:
			return "F";
		default:
			return num + "";
		}
	}

	public static void main(String[] args) {
		// 打印126转换成16进制的结果
		convert(35, 2);
	}

}
