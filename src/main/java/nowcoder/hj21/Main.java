package nowcoder.hj21;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    //大写字母则变成小写之后往后移一位
    //abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9
    // a==97 z==122
    //数字和其他的符号都不做变换
    //密码长度不超过100个字符


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char c;
        int[] nums = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        StringBuffer sb = new StringBuffer();
        while ((c = (char) in.read()) != -1) {
            if (c == '\n' || c == '\r') {
                System.out.println(sb.toString());
                sb = new StringBuffer();
                break;
            }

            if (c >= 'a' && c <= 'z') {
                sb.append(nums[c - 97]);
            } else if (c >= 'A' && c <= 'Z') {
                if ('Z' == c) {
                    sb.append('a');
                    continue;
                }
                sb.append((char) (c + 32 + 1));
            } else {
                sb.append(c);
            }
        }
    }
}
