package zhenti.leetcode20220304;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();
        String password = main.getPassword("China", "zhongguo123456CHINA@");
        System.out.println("123456CHINA@".equals(password));
        password = main.getPassword("John", "John@huawei.com");
        System.out.println("empty".equals(password));
    }

    public String getPassword(String userName, String passwordStringPool) {
        char[] tsChar = {'.', '!', '@', '#', '$', '%'};
        int[] check;//大写字母(65-90)，小写字母或数字(97-122,48-54)，特殊字符(46, 33,64,35,36,37)
        List<String> result = new ArrayList<>();
        String[] pools = passwordStringPool.split(userName);
        int begin;
        int end;
        for (int i = 0; i < pools.length; i++) {
            if (pools[i].length() < 6) {
                continue;
            }

            begin = 0;
            end = 0;
            check = new int[3];
            while (end <= pools[i].length()) {
                if (check[0] > 0 && check[1] > 0 && check[2] > 0) {
                    if (end - begin >= 6 && end - begin <= 12) {
                        result.add(pools[i].substring(begin, end));
                    }
                    if (pools[i].charAt(begin) >= 'A' && pools[i].charAt(begin) <= 'Z') {
                        check[0] -= 1;
                        begin++;
                    } else if ((pools[i].charAt(begin) >= '0' && pools[i].charAt(begin) <= '9') || (pools[i].charAt(begin) >= 'a' && pools[i].charAt(begin) <= 'z')) {
                        check[1] -= 1;
                        begin++;
                    } else if ('.' == pools[i].charAt(begin) || '!' == pools[i].charAt(begin) || '@' == pools[i].charAt(begin) || '#' == pools[i].charAt(begin) || '$' == pools[i].charAt(begin) || '%' == pools[i].charAt(begin)) {
                        check[2] -= 1;
                        begin++;
                    }
                    continue;
                }

                if (end == pools[i].length()) {
                    break;
                }

                // if(true)符合大写字母 ，end+1
                if (pools[i].charAt(end) >= 'A' && pools[i].charAt(end) <= 'Z') {
                    check[0] += 1;
                    end++;
                } else if ((pools[i].charAt(end) >= '0' && pools[i].charAt(end) <= '9') || (pools[i].charAt(end) >= 'a' && pools[i].charAt(end) <= 'z')) {
                    // if(true)符合小写字母 ，end+1
                    check[1] += 1;
                    end++;
                } else if ('.' == pools[i].charAt(end) || '!' == pools[i].charAt(end) || '@' == pools[i].charAt(end) || '#' == pools[i].charAt(end) || '$' == pools[i].charAt(end) || '%' == pools[i].charAt(end)) {
                    // if(true)符合特殊字符 ，end+1
                    check[2] += 1;
                    end++;
                } else {
                    //如果都不是 begin和end都需要重置到当前
                    end++;
                    begin = end;
                }
            }
        }

        if (result.isEmpty()) {
            return "empty";
        }

        result.sort(String::compareTo);
        return result.get(0);
    }
}
