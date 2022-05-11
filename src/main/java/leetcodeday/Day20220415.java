package leetcodeday;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/mini-parser/
 * 385. 迷你语法分析器
 */
public class Day20220415 {
    public static void main(String[] args) {
        Day20220415 test = new Day20220415();
        NestedInteger result = test.deserialize("324");
        System.out.println("{\"integer\":324,\"list\":[]}".equals(JSON.toJSONString(result)));
        result = test.deserialize("[123,[456,[789]]]");
        System.out.println(("{\"list\":[{\"integer\":123,\"list\":[]},{\"list\":[{\"integer\":456,\"list\":[]}," +
                "{\"list\":[{\"integer\":789,\"list\":[]}]}]}]}").equals(JSON.toJSONString(result)));

        result = test.deserialize("[123,456,[788,799,833],[[],[]],10,[]]");

        //result = test.deserialize("[[[],[]],10,[]]");
    }

    //[123,[456,[789]]]
    //数字以后只能是， ]   还有结束
    public NestedInteger deserialize(String s) {
        LinkedList<NestedInteger> queue = new LinkedList();
        StringBuffer nums = new StringBuffer();

        NestedInteger temp;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                //遇到[  new一个list
                queue.add(new NestedInteger());
            } else if (s.charAt(i) == ',' || s.charAt(i) == ']') {
                if (s.charAt(i - 1) == '[' && s.charAt(i) == ']') {
                    //空节点没什么东西可以放入
                    continue;
                }
                //遇到,当前放进去,前面可能是数字  [xxx],
                if (nums.length() > 0) {
                    queue.add(new NestedInteger(Integer.valueOf(nums.toString())));
                    nums.delete(0, nums.length());
                }
                temp = queue.pollLast();
                queue.peekLast().add(temp);
            } else {
                //遇到数字  new一个数字
                nums.append(s.charAt(i));
            }
        }

        if (nums.length() > 0) {
            queue.add(new NestedInteger(Integer.valueOf(nums.toString())));
            nums.delete(0, nums.length());
        }
        return queue.pop();
    }


    static class NestedInteger {
        private Integer value;
        private List<NestedInteger> list;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this();
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return this.list.size() == 0;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            this.list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return this.list;
        }
    }
}
