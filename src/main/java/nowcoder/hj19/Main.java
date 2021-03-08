package nowcoder.hj19;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String, Integer> list = new LinkedHashMap();
        String str;
        String rownum;
        String key;
        while (in.hasNext()) {
            str = in.next();
            rownum = in.next();
            if ("exit".equals(str)) {
                break;
            }

            str = str.substring(str.lastIndexOf("\\") + 1);
            if (str.length() > 16) {
                str = str.substring(str.length() - 16);
            }

            key = str + "###" + rownum;
            list.put(key, list.getOrDefault(key, 0) + 1);
        }


        String[] keys = list.keySet().toArray(new String[0]);
        StringBuffer sb = new StringBuffer();

        int length = keys.length - 8;
        if (length <= 0) {
            length = 0;
        }

        String[] strs;
        for (int i = length; i < keys.length; i++) {
            strs = keys[i].split("###");
            sb.append(strs[0]);
            sb.append(" ");
            sb.append(strs[1]);
            sb.append(" ");
            sb.append(list.get(keys[i]));
            sb.append("\n");
        }

        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }
}
