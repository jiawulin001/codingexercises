package nowcoder.hj66;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String command = in.nextLine();
            System.out.println(executeCommand(command));
        }
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(s.matches("^jia\\S*\\Ww\\S*"));
        }
    }

    private static String executeCommand(String shortCommand) {
        Map<String, String> commandMap = new HashMap<>();
        final String unknown = "unknown command";
        //commandMap.put("reset", "reset what");
        commandMap.put("reset board", "board fault");
        commandMap.put("board add", "where to add");
        commandMap.put("board delete", "no board at all");
        commandMap.put("reboot backplane", "impossible");
        commandMap.put("backplane abort", "install first");

        String[] commands = shortCommand.split(" ");
        if (commands.length == 1) {
            if ("reset".matches("^" + commands[0])) {
                return "reset what";
            } else {
                return unknown;
            }
        }

        String result = null;
        for (String key : commandMap.keySet()) {
            if (key.matches("^" + commands[0] + "\\S*\\W" + commands[1] + "\\S*")) {
                if (result == null) {
                    result = commandMap.get(key);
                } else {
                    return unknown;
                }
            }
        }

        if (result == null) {
            result = unknown;
        }

        return result;
    }

}
