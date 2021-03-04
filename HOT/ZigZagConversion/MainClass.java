package ZigZagConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author NacedWang
 * @version V1.0.0
 * @Package ZigZagConversion
 * @date 2021/2/25 11:10
 */
class Solution {

    /**
     * 提交时间	提交结果	运行时间	内存消耗	语言
     * 几秒前	通过	4 ms	38.7 MB	Java
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 86.02%
     * 的用户
     * 内存消耗：
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 84.13%
     * 的用户
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        char[] sArray = s.toCharArray();
        int length = s.length();
        if (length == 1) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        // 0,4,8
        // 1,3,5,7,9
        // 2,6,10

        // 0,    6,12
        // 1,  5,7,11,13
        // 2,4,  8,10
        // 3,    9
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < length) {
                result.append(sArray[j]);
                // 首行或尾行
                if (i == 0 || i == numRows - 1) {
//                    j = j + numRows * 2 - 2;
//                    j = j + numRows + numRows - 2;
                } else {
                    // 存在一个中间值  ,为 j + 剩下的行数  + 剩下的有中间值的数
//                    int tempIndex = j + (numRows - i - 1) + (numRows - i - 1);
                    int tempIndex = j + numRows * 2 - i * 2 - 2;
                    if (tempIndex < length) {
                        result.append(sArray[tempIndex]);
                    }
                    // j = j + numRows * 2 - 2;
                }
                // 下一个Z部分
                j = j + numRows * 2 - 2;
            }
        }
        return result.toString();
    }
}

public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;
            line = in.readLine();
            int numRows = Integer.parseInt(line);

            String ret = new Solution().convert(s, numRows);

            String out = (ret);

            System.out.print(out);
        }
    }
}