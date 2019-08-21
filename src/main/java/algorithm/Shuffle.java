package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 带权重洗牌
 * 
 * @author kundy
 * @createTime: Nov 22, 2018 3:47:09 PM
 *
 */
public class Shuffle {

	private static final String[] POKER_FANCY = { "方砖", "梅花", "红桃", "黑桃" };
	private static final String[] POKER_NUM = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
	private static final Integer TOTAL_NUM = 52;

	public static void getShufflePoker() {
		List<Poker> pokers = initPoker();
		shufflePoker(pokers, 100);
	}

	/**
	 * Features:初始化扑克
	 */
	private static List<Poker> initPoker() {
		List<Poker> list = new ArrayList<>(16);
		for (int i = 0; i < POKER_NUM.length; i++) {
			for (int j = 0; j < POKER_FANCY.length; j++) {
				// 设置花色之余还要设置权重
				list.add(new Poker(POKER_FANCY[j] + POKER_NUM[i], i * 4 + j));
			}
		}
		return list;
	}

	/**
	 * Features:洗num次牌
	 */
	private static void shufflePoker(List<Poker> pokers, int num) {
		for (int i = 0; i < num; i++) {
			Random random = new Random();
			int position1 = random.nextInt(TOTAL_NUM);
			int position2 = random.nextInt(TOTAL_NUM);

			// 随机两个位置的牌互换
			Poker tmpPoker = pokers.get(position1);
			pokers.set(position1, pokers.get(position2));
			pokers.set(position2, tmpPoker);
		}
	}

	/**
	 * 扑克实体
	 */
	private static class Poker {
		// 花式和序号
		@SuppressWarnings("unused")
		private String symbol;
		// 权重（标志该花式值的大小）
		@SuppressWarnings("unused")
		private Integer weight;

		public Poker(String symbol, Integer weight) {
			this.symbol = symbol;
			this.weight = weight;
		}
	}

}
