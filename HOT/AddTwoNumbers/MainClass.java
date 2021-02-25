package AddTwoNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author NacedWang
 * @version V1.0.0
 * @Package TwoSum
 * @date 2021/2/25 11:10
 */
class Solution {
    /**
     * 提交时间	提交结果	运行时间	内存消耗	语言
     * 几秒前	通过	16 ms	39.2 MB	Java
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder l1s = new StringBuilder();
        ListNode l1Temp = l1;
        while (l1Temp != null) {
            l1s.insert(0, l1Temp.val);
            l1Temp = l1Temp.next;
        }
        StringBuilder l2s = new StringBuilder();
        ListNode l2Temp = l2;
        while (l2Temp != null) {
            l2s.insert(0, l2Temp.val);
            l2Temp = l2Temp.next;
        }
        // lowB直接转string 相加
        BigDecimal result = new BigDecimal(l1s.toString()).add(new BigDecimal(l2s.toString()));
        char[] resArr = result.toString().toCharArray();
        ListNode resultNode = new ListNode(0);
        ListNode ptr = resultNode;
        // string倒序构建结果
        for (int i = resArr.length - 1; i >= 0; i--) {
            ptr.val = resArr[i] - '0';
            if (i > 0) {
                ptr.next = new ListNode(0);
                ptr = ptr.next;
            }
        }
        return resultNode;
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

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}