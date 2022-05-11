package leetcodeday;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 388. 文件的最长绝对路径
 */
public class Day20220420 {
    public static void main(String[] args) {
        Day20220420 test = new Day20220420();
        System.out.println(133 == test.lengthLongestPath("skd\n\talskjv\n\t\tlskjf\n\t\t\tklsj.slkj\n\t\tsdlfkj" +
                ".sdlkjf\n\t\tslkdjf.sdfkj\n\tsldkjf\n\t\tlskdjf\n\t\t\tslkdjf" + ".sldkjf\n\t\t\tslkjf\n\t\t\tsfdklj"
                + "\n\t\t\tlskjdflk" + ".sdkflj\n\t\t\tsdlkjfl\n\t\t\t\tlskdjf\n\t\t\t\t\tlskdjf" + ".sdlkfj\n\t\t\t" +
                "\t" + "\tlsdkjf\n\t\t\t\t\t\tsldkfjl" + ".sdlfkj\n\t\t\t\tsldfjlkjd\n\t\t\tsdlfjlk\n\t\t\tlsdkjf\n\t"
                + "\tlsdkjfl\n\tskdjfl\n\t\tsladkfjlj\n\t" +
                "\tlskjdflkjsdlfjsldjfljslkjlkjslkjslfjlskjgldfjlkfdjbljdbkjdlkjkasljfklasjdfkljaklwejrkljewkljfslkjflksjfvsafjlgjfljgklsdf.a"));
        System.out.println(20 == test.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(32 == test.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1" + ".ext\n\t\tsubsubdir1" + "\n" + "\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    //每个目录名由字母、数字和/或空格组成，每个文件名遵循 name.extension 的格式，其中 name 和 extension由字母、数字和/或空格组成
    public int lengthLongestPath(String input) {
        LinkedList<String> stack = new LinkedList<>();
        String[] files = input.split("\\n");

        int tabCount = 0;
        int preTabCount = 0;
        int currLength = 0;
        int maxLength = 0;
        String dir;
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
            tabCount = 0;
            while (files[i].charAt(0) == '\t') {
                tabCount += 1;
                files[i] = files[i].substring(1);
            }

            for (int j = 0; !stack.isEmpty() && j < preTabCount - tabCount + 1; j++) {
                dir = stack.poll();
                currLength -= dir.length();
            }
            preTabCount = stack.size() - 1;
            //目录
            if (files[i].indexOf(".") == -1) {
                currLength += files[i].length() + 1;
                stack.push(files[i] + "\\");
                preTabCount = tabCount;
            } else {
                maxLength = Math.max(maxLength, currLength + files[i].length());
            }
        }
        return maxLength;
    }
}
