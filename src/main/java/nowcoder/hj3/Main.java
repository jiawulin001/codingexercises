package nowcoder.hj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main1(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            int[] random;
            while ((str = bread.readLine()) != null) {
                random = new int[Integer.valueOf(str)];
                for (int i = 0; i < random.length; i++) {
                    random[i] = Integer.valueOf(bread.readLine());
                }
                handler(random).forEach(System.out::println);
            }
        }
    }


    private static Set<Integer> handler(int[] random) {
        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 0; i < random.length; i++) {
            result.add(random[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            int length;
            TreeSet<Integer> result;
            while ((str = bread.readLine()) != null) {
                length = Integer.valueOf(str);
                result = new TreeSet<>();
                for (int i = 0; i < length; i++) {
                    result.add(Integer.valueOf(bread.readLine()));
                }
                result.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
