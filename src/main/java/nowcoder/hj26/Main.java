package nowcoder.hj26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Main {
    public static void main1(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        LinkedHashMap<Character, String> map;

        char chr;
        char[] strs;

        while ((str = in.readLine()) != null) {
            map = new LinkedHashMap();
            strs = str.toCharArray();

            for (int i = 0; i < str.length(); i++) {
                chr = str.charAt(i);
                if (chr >= 'A' && chr <= 'Z') {
                    chr += 32;
                    map.put(chr, map.getOrDefault(chr, "") + str.charAt(i));
                    strs[i] = (char) -1;
                } else if (chr >= 'a' && chr <= 'z') {
                    map.put(chr, map.getOrDefault(chr, "") + chr);
                    strs[i] = (char) -1;
                }
            }

            Integer lastIndex = 0;
            Iterator<Character> it = map.keySet().stream().sorted().iterator();
            while (it.hasNext()) {
                chr = it.next();
                str = map.get(chr);
                for (int i = 0; i < str.length(); ) {
                    if (strs[lastIndex] == (char) -1) {
                        strs[lastIndex] = str.charAt(i);
                        i++;
                    }
                    lastIndex++;
                }
            }
            System.out.println(new String(strs));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            char[] ch = s.toCharArray();
            char[] chars = new char[ch.length];
            int flag = 65, j = 0;
            while (flag <= 90) {
                for (int i = 0; i < ch.length; i++) {
                    if ((ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122)) {
                        if (ch[i] == flag || ch[i] == flag + 32) {
                            chars[j] = ch[i];
                            j++;
                        }
                    }
                }
                flag++;
            }
            j = 0;
            for (int i = 0; i < ch.length; i++) {
                if ((ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122)) {
                    ch[i] = chars[j];
                    j++;
                }
            }
            System.out.println(String.valueOf(ch));
        }
    }
}
