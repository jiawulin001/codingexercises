package nowcoder.hj74;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String cmdStr = in.nextLine();
            String[] result = explanation(cmdStr);
            System.out.println(result.length);
            Arrays.stream(result).forEach(System.out::println);
        }
    }

    //逐行扫描
    //testcase: xcopy /s c:\ d:\，
    private static String[] explanation(String cmdStr) {
        Map<Integer, String> args = new HashMap<>();
        boolean isQuatation = false;
        int index = 0;
        for (int i = 0; i < cmdStr.length(); i++) {
            if ('"' == cmdStr.charAt(i)) {
                isQuatation = !isQuatation;
            } else if (' ' == cmdStr.charAt(i) && !isQuatation) {
                index++;
            } else {
                args.put(index, args.getOrDefault(index, "") + cmdStr.charAt(i));
            }
        }

        String[] result = new String[args.size()];
        for (int key : args.keySet()) {
            result[key] = args.get(key);
        }
        return result;
    }


    //直接使用StringBuffer
    private static void explanation2(String cmdStr) {
        StringBuffer buffer = new StringBuffer();
        boolean isQuatation = false;
        int count = 1;
        for (int i = 0; i < cmdStr.length(); i++) {
            if ('"' == cmdStr.charAt(i)) {
                isQuatation = !isQuatation;
            } else if (' ' == cmdStr.charAt(i) && !isQuatation) {
                buffer.append(System.lineSeparator());
                count++;
            } else {
                buffer.append(cmdStr.charAt(i));
            }
        }

        System.out.println(count);
        System.out.println(buffer.toString());
    }

    //正则表达式
    private static String[] explanation3(String cmdStr) {

        return null;
    }

}
