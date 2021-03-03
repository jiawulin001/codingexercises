package nowcoder.hj17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            point(in.nextLine());
        }
    }

    private static void point(String str) {
        int x = 0, y = 0;
        // A表示向左移动,D表示向右移动，W表示向上移动，S表示向下移动
        String[] points = str.split(";");
        for (int i = 0; i < points.length; i++) {
            if (points[i].matches("^[ADWS]\\d{0,2}$")) {
                switch (points[i].charAt(0)) {
                    case 'A':
                        x -= Integer.valueOf(points[i].substring(1));
                        break;
                    case 'D':
                        x += Integer.valueOf(points[i].substring(1));
                        break;
                    case 'W':
                        y += Integer.valueOf(points[i].substring(1));
                        break;
                    case 'S':
                        y -= Integer.valueOf(points[i].substring(1));
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println(x + "," + y);
    }
}
