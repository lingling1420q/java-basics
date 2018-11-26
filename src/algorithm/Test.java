package algorithm;

/**
 *
 * @author kundy
 * @createTime:Nov 23, 2018 7:08:29 PM
 *
 */
public class Test {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		thread1.setStr("hi");
		thread1.start();
	}

	private static class Thread1 extends Thread {
		private String str;

		public void setStr(String str) {
			this.str = str;
		}

		@Override
		public void run() {
			System.out.println("hi" + str);
		}

	}

}
