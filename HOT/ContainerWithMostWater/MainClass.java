package ContainerWithMostWater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1) return -1;
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            if (height[i] < height[j]) ++i;
            else --j;
        }
        return res;
    }

    public int maxArea2(int[] height) {
        // 最大
        int maxC = 0;
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 高度
                int thisHeight = height[i] > height[j] ? height[j] : height[i];
                // 容积
                int container = thisHeight * (j - i);
                if (container > maxC) {
                    System.out.println(i + " " + j);
                    System.out.println(height[i] + " " + height[j]);
                    maxC = container;
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        return maxC;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);

            int ret = new Solution().maxArea(height);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}