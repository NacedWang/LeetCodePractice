package ReverseInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author NacedWang
 * @version V1.0.0
 * @Package ReverseInteger
 * @date 2021年3月5日10:10:10
 */
class Solution {

    /**
     * 交时间	提交结果	运行时间	内存消耗	语言
     * 几秒前	通过	4 ms	35.5 MB	Java
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        Long data = Long.valueOf(x);
        Long result = 0L;
        // 正数和负数
        if (data == 0L) {
            return 0;
        } else if (data > 0) {
            result = Long.valueOf(new StringBuilder(data.toString()).reverse().toString());
        } else {
            result = Long.valueOf(new StringBuilder(data.toString().substring(1)).reverse().toString()) * -1;
        }
        // 判断翻转是否超过Int边界
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.valueOf(result.toString());
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}