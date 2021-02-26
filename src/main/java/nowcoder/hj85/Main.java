package nowcoder.hj85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;

            int maxSize = 0;
            while ((str = bread.readLine()) != null && !"".equals(str)) {
                for (int i = 0; i < str.length() - 1; i++) {
                    if (str.charAt(i) == str.charAt(i + 1)) {
                        maxSize = Math.max(maxSize, maxSubStringLength(str, i));
                    }
                }
                System.out.println(maxSize);
            }
        }
    }

    private static int maxSubStringLength(String str, int middleIndex) {
        int i = 1;
        int beforeIndex, afterIndex;
        while (true) {
            beforeIndex = middleIndex - i;
            afterIndex = middleIndex + i + 1;

            if (beforeIndex < 0 || afterIndex >= str.length()) {
                return (afterIndex - 1) - (beforeIndex + 1) + 1;
            }

            if (str.charAt(beforeIndex) == str.charAt(afterIndex)) {
                i++;
                continue;
            }
            return (afterIndex - 1) - (beforeIndex + 1) + 1;
        }
    }
}
