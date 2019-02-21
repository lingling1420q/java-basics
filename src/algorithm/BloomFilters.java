package algorithm;

import sun.jvm.hotspot.utilities.Assert;

import java.util.BitSet;

/**
 * 布隆过滤器
 *
 * @author kundy
 * @create 2019/2/21 3:03 PM
 */
public class BloomFilters {

    private BitSet bitSet = new BitSet();

    public void add(String key) {
        bitSet.set(hashOne(key), true);
        bitSet.set(hashTwo(key), true);
        bitSet.set(hashThree(key), true);
    }

    public boolean check(String key) {
        if (!bitSet.get(hashOne(key))) return false;
        if (!bitSet.get(hashTwo(key))) return false;
        return bitSet.get(hashThree(key));
    }

    private int hashOne(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    private int hashTwo(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);

    }

    private int hashThree(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BloomFilters bloomFilters = new BloomFilters();
        for (int i = 0; i < 10000000; i++) {
            bloomFilters.add(i + "");
        }
        System.out.println(bloomFilters.check(1 + ""));
        System.out.println(bloomFilters.check(400230340 + ""));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start));
    }


}

