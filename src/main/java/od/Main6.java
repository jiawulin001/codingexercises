package od;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main6 {
    /**
     * 1.输入字符串，例如1/N 2/Y 3/N 4/Y;
     * 2.前边是N，后边是Y表示同一个班；后边是N，表示跟 前边一个不是同一个班；如1和2是一个班，3和 4是一个班
     * 3.学生编号从1~999，不符合格式的输出“ERROR”
     * 4.输出两个班是序号并按从小到大的顺序排序：如：
     * 1 2
     * 3 4
     */
    public static void main(String[] args) {
        String input = "1/N 2/Y 3/N 4/Y 5/N 6/Y 7/N 8/Y 9/N 10/Y 11/N 12/Y 13/N 14/Y 15/N 16/Y";
        String[] clazz = input.split(" ");

        List<Set<String>> sets = new ArrayList<>();
        String[] preStudent = null;
        String[] currStudent;
        Set<String> temp;
        for (int i = 0; i < clazz.length; i++) {
            currStudent = clazz[i].split("/");
            if ("N" == currStudent[1]) {
                temp = new HashSet<>();
                temp.add(currStudent[0]);
                sets.add(temp);
            } else if (null != preStudent) {
                for (int j = 0; j < sets.size(); j++) {
                    if (sets.get(j).contains(preStudent[0])) {
                        temp = sets.get(j);
                        temp.add(currStudent[0]);
                    }
                }
            }
            preStudent = currStudent;
        }

        for (int i = 0; i < sets.size(); i++) {
            sets.get(i).forEach(str -> {
                System.out.print(str + " ");
            });
            System.out.println();
        }
    }
}

