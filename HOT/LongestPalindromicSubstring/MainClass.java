package LongestPalindromicSubstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author NacedWang
 * @version V1.0.0
 * @Package LongestPalindromicSubstring
 * @date 2021年3月2日16:23:01
 */
class Solution {

    /**
     * 提交时间	提交结果	运行时间	内存消耗	语言
     * 几秒前	通过	25 ms	38.9 MB	Java
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 记录最长回文串
        char[] res = {};
        char[] sArray = s.toCharArray();

        // 穷举以所有点（奇数一个点，偶数两个点）为中心的回文串
        for (int i = 0; i < s.length(); i++) {
            // 当回文串是奇数时，由一个中心点向两边扩散
            char[] s1 = palindrome(sArray, i, i);
            // 当回文串是偶数时，由中间的两个中心点向两边扩散
            char[] s2 = palindrome(sArray, i, i + 1);

            // 三元运算符：判断为真时取冒号前面的值，为假时取冒号后面的值
            res = res.length > s1.length ? res : s1;
            res = res.length > s2.length ? res : s2;
        }
        return String.valueOf(res);
    }

    // 辅助函数：寻找回文串
    private char[] palindrome(char[] sArray, int left, int right) {
        // 在区间 [0, s.length() - 1] 中寻找回文串，防止下标越界
        while (left >= 0 && right < sArray.length) {
            // 是回文串时，继续向两边扩散
            if (sArray[left] == sArray[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        left++;
        int resLength = right - left;
        char[] res = new char[resLength];
        for (int i = 0; i < resLength; i++) {
            res[i] = sArray[left];
            left++;
        }
        return res;
    }

}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;

            String ret = new Solution().longestPalindrome(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}