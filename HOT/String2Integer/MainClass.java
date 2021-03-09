package String2Integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author NacedWang
 * @version V1.0.0
 * @Package String2Integer
 * @date sj
 */
class Solution {
    /**
     * 提交时间	提交结果	运行时间	内存消耗	语言
     * 几秒前	通过	5 ms	38.8 MB	Java
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        while (s.startsWith(" ") && !s.equals("")) {
            s = s.substring(1);
        }
        if (s.equals("")) {
            return 0;
        }
        if (s.startsWith("-") || s.startsWith("+") || (s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
            // 正负号
            Integer flag = 1;
            if (s.startsWith("-")) {
                flag = -1;
            }
            if (s.startsWith("-") || s.startsWith("+")) {
                s = s.substring(1);
            }
            char[] charArray = s.toCharArray();
            Long result = 0L;
            for (int i = 0; i < charArray.length; i++) {
                // 超出限制
                if (result > Long.valueOf(Integer.MAX_VALUE) + 1) {
                    break;
                }
                char item = charArray[i];
                if (item >= '0' && item <= '9') {
                    // 拼接数据
                    result = Long.valueOf(s.substring(0, i + 1));
                } else {
                    break;
                }
            }
            if (result * flag >= Integer.MIN_VALUE && result * flag <= Integer.MAX_VALUE) {
                return result.intValue() * flag;
            }
            if (result * flag > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * flag < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else {
            return 0;
        }
        return 0;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;

            int ret = new Solution().myAtoi(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}