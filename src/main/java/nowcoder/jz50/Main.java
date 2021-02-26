package nowcoder.jz50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <b>题目描述</b><br/>
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 <br/>
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。<br/>
 * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。 <br/>
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。<br/>
 * <b>返回描述：</b><br/>
 * 如果数组中有重复的数字，函数返回true，否则返回false。<br/>
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）<br/>
 * </p>
 */


public class Main {


    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!set.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] numbers = {6, 3, 2, 0, 2, 5, 0};
        // int[] numbers = {0, 6, 3, 2, 2, 5, 4};

        int[] duplication = {0};
        Main m = new Main();
        m.duplicate(numbers, numbers.length, duplication);
        Arrays.stream(duplication).forEach(System.out::println);
    }


    public boolean duplicate(int numbers[], int length, int[] duplication) {
        int i = 0;
        int temp;


        while (i < length) {
            if (numbers[i] != i && numbers[numbers[i]] != numbers[i]) {
                temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            } else if (numbers[i] != i && numbers[numbers[i]] == numbers[i]) {
                duplication[0] = numbers[i];
                return true;
            } else {
                i++;
            }
        }

        return false;
    }
}
