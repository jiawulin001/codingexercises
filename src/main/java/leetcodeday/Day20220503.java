package leetcodeday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * 937. 重新排列日志文件
 */
public class Day20220503 {

    public static void main1(String[] args) {
        String[] logs = new String[]{"act car", "off key dog", "act zoo"};
        Arrays.sort(logs);
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public static void main(String[] args) {
        Day20220503 test = new Day20220503();
        String[] logs;
        logs = new String[]{"wpylev6cnqv8 447241070789889321113517804297550370", "2syod 60098540876848105552318 " +
                "69698830167476212 2", "iuw2x1r qmxealfvosqgkv yunonsq nxcuwudndrpsroty h", "vclnqwkdr7h 5515 " +
                "892770977116949342793820104705 3", "5y08u4f5ba swixvlwipfhtxavvzrdyxtnronckklvh f kzd",
                "2k63p1p " + "542447297738584 22237063423417308275099706", "qrj 467859 382 451796621324556 12022 " +
                "72631305 0429", "vopck4 huqziggmwvcsermnujnpplihttviwei lsrqmbw b n", "s " +
                "7257018672440110203152567646 " + "961657508453405583",
                "94j 1800907 54116251858 19612167 218608 1 " + "504204 4", "u34lvgmoh " +
                "631217074786612695089137448 5635620839 5", "dsrojn8aeojx " + "27159799084241651870 76594680 195 051"
                , "kteuav 77685739 6366458436088787165747310 78 3849", "dg8gco0sc2 10811560194867165521681 718 42498 "
                + "1 " + "52", "gdg 900670532316533434070453812 " + "9115641245822 122", "ytlmfg 658910166131 " +
                "170942932" + " 70238 " + "0783568 64777", "gi6d2lg8 " + "ekwbnzeqrrzijgexvpcgfnhrkfhtmegaqon hsa u",
                "y8zhzn " + "jjtbwpfrbcsuj zmseejb " + "vcsovstaewtgtj " + "nbsnlj", "cp1qsk5 dstuzhik " +
                "alqxnmztxnwdve" + " " + "simoynsfffwyacl nr", "a11zjdza15gi " + "zuighjavkfidjjx " + "kgmbriwxbjcsv "
                + "shtfjz", "3dpx3f28wa1 dhe" + " jb uatgwooxclfj w t qaahvyiy lthj", "9ymabvjk4xq " + "waujeijoltuy "
                + "heoekaqmggmpdkynngne sl x", "n3l09gzpppgc dfnfxeaskknllixe " + "tvtbemewtkwd " + "bfbhm l",
                "one " + "143245418564431590 " + "555274555077126490673 23406", "2dlvtxq57 11 " +
                "0399853766553806651446400571374174 7", "l0xsyrtf9foe jcsjyzbux " + "hpxxwwsyxwjcdqbuzrxuvdf n n", "o"
                + " " + "ufjxgmiohhacgwhprzqklpbleggurqygvmyrqtiwwusaa fq",
                "gr " + "jmhsaanfrndkvkrdepfqvnathkheq " + "bjtvzacabyfch " + "xw", "12hrfmpyxql " +
                "509513107446443470266800090 " + "12" + " 36792 5", "ei " + "mfmrujazj " +
                "hvcaeoejhbvsxlnbcofdparedjvuqoigbwv h",
                "158mo1 fxwvcxyaz " + "gimthvk t " + "tbkpxnyomitu i foi t " + "i", "1mpnz91abn8 857526216042344 529 "
                + "86 555850 074136 6", "gvf69aycgz vd " + "wzshq " + "vqqcoscdfgtclfpoqz kcnbk " + "yqrta",
                "05tv1dyuuln 3010253552744498232332 " + "86540056 " + "5488 0", "1kjt2sp" + " " +
                "76661129172454994454966100212569762 877775",
                "k8fq " + "mhahouacluusiypbhmbxknagj " + "nrenkpsijov " + "tspqd" + " s", "a " +
                "05783356043073570183098305205075240023467 24" + " 63", "0c 821 " +
                "1288302446431573478713998604686702" + " " + "0584599", "e 02985850443721 356058 " + "49996149758367 "
                + "64432663 32", "1zayns7ifztd " + "kwmwsthxzxvvctzoejspeobtavhzxzpot u n", "o0sh3 qn " +
                "nqjaghnmkckhvuauuknqbuxwalgva nt gfhqm en", "094qnly wgkmupkjobuup gshx wcblufmjumyuahsx n ai k",
                "j69r2ugwa6 zuoywue chhwsfdprfygvliwzmohqgrxn " + "ubwtm", "2mkuap uqfwog jqzrkoorsompgkdlql " +
                "wpauhkzvig ftb l", "x 929 " + "4356109428379557082235487428356570127401 832", "jns07q8 " +
                "idnlfsaezcojuafbgmancqpegbzy q qwesz rmy n", "phk1cna 086 027760883273 64658492093523655560824 2",
                "jbemfs9l9bs0 8147538504741452659388775 5 32 " + "180 09", "ac9cwb9 524689619771630155 " +
                "8125241949139653850678", "9eke perwsfqykyslfmcwnovenuiy " + "urstqeqaezuankek czq"};
        logs = test.reorderLogFiles(logs);
        System.out.println("----------------------");
        for (String log : logs) {
            System.out.println(log);
        }

        logs = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        logs = test.reorderLogFiles(logs);
        System.out.println("----------------------");
        for (String log : logs) {
            System.out.println(log);
        }

        logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        logs = test.reorderLogFiles(logs);
        System.out.println("--------------------");
        for (String log : logs) {
            System.out.println(log);
        }
    }


    //自己做，先预先把数字的挑出去和把字符串拆分开来，避免排序重复拆分字符串
    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        List<String[]> list = new ArrayList<>();

        int index;
        for (int i = logs.length - 1, j = i; i >= 0; i--) {
            if (Character.isDigit(logs[i].charAt(logs[i].length() - 1))) {
                result[j] = logs[i];
                j--;
                continue;
            }

            index = logs[i].indexOf(" ");
            list.add(new String[]{logs[i].substring(0, index), logs[i].substring(index), logs[i]});
        }

        list.sort(Comparator.comparing((String[] str) -> str[1]).thenComparing(str -> str[0]));

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i)[2];
        }

        return result;
    }

    //Arrays.sort方式，会报错Comparison method violates its general contract!
    //因为数字之间没有严格的大小比较，每次都是ture，导致排序逆转和之前不相等报错
    //解决办法，要不记录index,数字时候，比较index，要不就预先挑出数字
    public String[] reorderLogFiles1(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            boolean log1IsDig = Character.isDigit(log1.charAt(log1.length() - 1));
            boolean log2IsDig = Character.isDigit(log2.charAt(log2.length() - 1));

            if ((log1IsDig && log2IsDig) || (log1IsDig && !log2IsDig)) {
                return 1;
            } else if (!log1IsDig && log2IsDig) {
                return -1;
            }

            String str1 = log1.substring(log1.indexOf(" "));
            String str2 = log2.substring(log2.indexOf(" "));
            int result = str1.compareTo(str2);
            if (result == 0) {
                str1 = log1.substring(0, log1.indexOf(" "));
                str2 = log2.substring(0, log2.indexOf(" "));
                return str1.compareTo(str2);
            }
            return result;
        });
        return logs;
    }

}

