package LongestSubstringWithoutRepeatingCharacters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author NacedWang
 * @version V1.0.0
 * @Package TwoSum
 * @date 2021年2月26日16:42:53
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer startIndex = 0;
        Integer currentIndex = 0;
        Integer maxLength = 0;
        char[] array = s.toCharArray();
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                currentIndex = i;
                String thisString = s.substring(startIndex, currentIndex);
//                System.out.println(thisString);
                char thisChar = array[i];
//                System.out.println(thisChar);
                if (thisString.indexOf(thisChar) >= 0) {
                    startIndex = startIndex + thisString.indexOf(thisChar) + 1;
                } else {
                    if (currentIndex - startIndex > maxLength) {
                        maxLength = thisString.length();
                    }
                }
            }
            return maxLength + 1;
        } else {
            return 0;
        }
    }
}

public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;

            int ret = new Solution().lengthOfLongestSubstring(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}