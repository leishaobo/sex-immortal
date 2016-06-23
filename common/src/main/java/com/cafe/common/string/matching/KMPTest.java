package com.cafe.common.string.matching;

/**
 *
 * @author hzleishaobo
 * @version 2016年6月21日
 */
public class KMPTest {

    /**
     * 参考文章：http://www.cnblogs.com/c-cloud/p/3224788.html
     * @param args
     */
    public static void main(String[] args) {
        String needSearchString = "BBC ABCDAB ABCDABCDABDE";
        String seachString = "ABCDABD";
        markNext(seachString);
    }

    /**
     * <pre>
     *   搜索词：ABCDABD
     *   A--数组下标0，前缀：无 ，后缀：无  ,重复0
     *   AB--数组下标1，前缀：A ，后缀：B ,重复0
     *   ABC--数组下标2，前缀：[A][AB] ，后缀：[C][BC] ,重复0
     *   ABCD--数组下标3，前缀：[A][AB][ABC] ，后缀：[D][CD][BCD] ,重复0
     *   ABCDA--数组下标4，前缀：[A][AB][ABC][ABCD] ，后缀：[A][DA][CDA][BCDA] ,重复1
     * </pre>
     * 
     * @param seachString
     */
    public static int[] markNext(String seachString) {
        char[] seachStringArry = seachString.toCharArray();
        int length = seachStringArry.length;
        int[] next = new int[length];//
        next[0] = 0;
        for (int i = 1; i < length; i++) {
            System.out.print(seachStringArry[i]);
            int k = 0;

        }
        return next;
    }

    /**
    * 获得字符串的next函数值**
    *            字符串 
    * @return next函数值 
    */
    public static int[] next(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {
                i++;
                j++;
                if (t[i] != t[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /** 
     * KMP匹配字符串 
     *  
     * @param s 
     *            主串 
     * @param t 
     *            模式串 
     * @return 若匹配成功，返回下标，否则返回-1 
     */
    public static int KMP_Index(char[] s, char[] t) {
        int[] next = next(t);
        int i = 0;
        int j = 0;
        while (i <= s.length - 1 && j <= t.length - 1) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < t.length) {
            return -1;
        } else
            return i - t.length; // 返回模式串在主串中的头下标
    }

}
