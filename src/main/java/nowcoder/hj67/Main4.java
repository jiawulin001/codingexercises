package nowcoder.hj67;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            Double[] ds = new Double[4];
            ds[0] = (double) in.nextInt();
            ds[1] = (double) in.nextInt();
            ds[2] = (double) in.nextInt();
            ds[3] = (double) in.nextInt();

            // 罗列出Double[]数组的多种放法（数字的不同排列顺序
            ArrayList<Double[]> as = permutation(ds);

            // 计算每一个数列 的结果
            System.out.println(cal(as));

        }

    }

    private static String cal(ArrayList<Double[]> as) {
        for (Double[] ss : as) {
            Set<Double> res = new HashSet<>();
            res.add(ss[0]);
            // 这里十分简单，以第一个数字为基础，依次加减乘除后面的数字，结果放在Set中
            for (int i = 1; i < 4; i++) {
                // 第i个数
                List<Double> tmpRes = new ArrayList<>(res);
                res.clear();
                for (Double d : tmpRes) {
                    // 原来的结果+-*/第i个数
                    res.add(d + ss[i]);
                    res.add(d - ss[i]);
                    res.add(d * ss[i]);
                    res.add(d / ss[i]);
                }
            }
            if (res.contains(24d)) {
                return "true";
            }
        }
        return "false";
    }

    private static ArrayList<Double[]> permutation(Double[] ds) {
        ArrayList<Double[]> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) // 这里的if语句都是用来去除重复的排列
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (j == k || k == i)
                        continue;
                    for (int m = 0; m < 4; m++) {
                        if (m == k || m == j || m == i)
                            continue;
                        Double[] b = new Double[]{ds[i], ds[j], ds[k], ds[m]};
                        // 给出一个数组来保存这一次循环的排列
                        arrayList.add(b);
                    }
                }
            }
        }
        return arrayList;
    }

}