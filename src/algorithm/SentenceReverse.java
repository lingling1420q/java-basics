package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 将句子中的单词反转输出（利用栈的后进先出特点）
 *
 * @author kundy
 * @date 2019/7/3 11:09 AM
 */
public class SentenceReverse {

    public static void main(String[] args) {
        reverse("i am a little boy");
    }

    private static void reverse(String sentence) {

        String[] words = sentence.split(" ");
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            // 压栈
            stack.push(word);
        }

        for (String word : words) {
            // 出栈
            System.out.print(stack.pop() + " ");
        }

    }
}
