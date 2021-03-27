package od;

public class Main5 {

    /**
     * 作者：KernelDev
     * 链接：https://www.nowcoder.com/discuss/607416?type=0&order=0&page=0&channel=-1&source_id=discuss_center_0_nctrack
     * 来源：牛客网
     * <p>
     * 1.已知：偏移量 a[0] = 1, a[1] = 2, a[2] = 4, a[3] = 7,......., a[i] = a[i-1] + a[i-2] + a[i-3]
     * 2.输入小写字符串，str = "abc"，每个字符根据数组 a进行偏移，输出"bdg"；（a偏移1为b，b偏移2为d，c偏移4为g；）
     * 3.输入整数n，表示n组测试 字符串；
     * 4.输出加密 后的字符串；
     */
    public static void main(String[] args) {
        String str = "abcdefghijklmnoabcdefghijklmnopqrstuvwxyzpqrstuvwxyz";
        change(str);
    }

    public static void change(String str) {
        Long[] a = new Long[str.length()];
        a[0] = 1L;
        a[1] = 2L;
        a[2] = 4L;
        a[3] = 7L;
        for (int i = 4; i < str.length(); i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) (((str.charAt(i) - 97 + a[i]) % 26) + 97));
        }
        System.out.println(sb.toString());
    }
}

