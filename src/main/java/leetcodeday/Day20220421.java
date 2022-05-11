package leetcodeday;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/goat-latin/
 * 824. 山羊拉丁文
 *

 //如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 //例如，单词 "goat" 变为 "oatgma"
 //如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 //例如，单词 "apple" 变为 "applema" 。
 //根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 //例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。

 */
public class Day20220421 {

    public static void main(String[] args) {
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//

        Day20220421 test = new Day20220421();
        String result = test.toGoatLatin("I speak Goat Latin");
        System.out.println(result.equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));

        result = test.toGoatLatin("The quick brown fox jumped over the lazy dog");
        System.out.println(result.equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa " +
                "hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
    }

    public String toGoatLatin(String sentence) {
        Set yuan = new HashSet();
        yuan.add('a');
        yuan.add('e');
        yuan.add('i');
        yuan.add('o');
        yuan.add('u');
        yuan.add('A');
        yuan.add('E');
        yuan.add('I');
        yuan.add('O');
        yuan.add('U');

        String[] strs = sentence.split(" ");
        StringBuffer suffix = new StringBuffer("a");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            if (!yuan.contains(strs[i].charAt(0))) {
                result.append(strs[i].substring(1));
                result.append(strs[i].charAt(0));
            } else {
                result.append(strs[i]);
            }
            result.append("ma");
            result.append(suffix.toString());
            result.append(" ");
            suffix.append("a");
        }
        return result.substring(0, result.length() - 1);
    }
}
