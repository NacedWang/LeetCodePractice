package MedianOfTwoSortedArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * @author NacedWang
 * @version V1.0.0
 * @Package TwoSum
 * @date 2021/2/25 11:10
 */
class Solution {

    /**
     * 提交时间	提交结果	运行时间	内存消耗	语言
     * 6 分钟前	通过	3 ms	39.4 MB	Java
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int totalLength = num1Length + num2Length;
        int[] sumArray = new int[totalLength];
        // 构建合并数组
        int sumIndex = 0;
        int num1Index = 0;
        int num2Index = 0;
        while (num1Length > 0 && num2Length > 0 && num1Index < num1Length && num2Index < num2Length) {
            int num1 = nums1[num1Index];
            int num2 = nums2[num2Index];
            if (num1 <= num2) {
                sumArray[sumIndex] = num1;
                num1Index++;
                sumIndex++;
            } else {
                sumArray[sumIndex] = num2;
                num2Index++;
                sumIndex++;
            }
        }
        // 把剩下的数据填补进去
        if (sumIndex < totalLength) {
            // 数组1剩下了
            if (num1Index < num1Length) {
//                System.out.println("数组1剩下了");
                while (num1Index < num1Length) {
                    sumArray[sumIndex] = nums1[num1Index];
                    num1Index++;
                    sumIndex++;
                }
            }
            // 数组2剩下了
            if (num2Index < num2Length) {
//                System.out.println("数组2剩下了");
                while (num2Index < num2Length) {
                    sumArray[sumIndex] = nums2[num2Index];
                    num2Index++;
                    sumIndex++;
                }
            }
        }
        // 单数
        if (totalLength % 2 == 1) {
            int mid = sumArray[(totalLength - 1) / 2];
            return mid;
        } else {
            int mid1 = sumArray[totalLength / 2];
            int mid2 = sumArray[totalLength / 2 - 1];
            return (mid1 + mid2 + 0.0) / 2;
        }
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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            double ret = new Solution().findMedianSortedArrays(nums1, nums2);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}