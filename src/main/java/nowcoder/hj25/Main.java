package nowcoder.hj25;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int iLength;
        int rLength;

        //int[] arrayR;
        Set<Integer> arrayR;
        while (in.hasNext()) {
            iLength = in.nextInt();
            String[] arrayI = new String[iLength];
            for (int i = 0; i < iLength; i++) {
                arrayI[i] = in.next();
            }
            rLength = in.nextInt();
            //arrayR = new int[rLength];
            arrayR = new HashSet<>();
            for (int i = 0; i < rLength; i++) {
                arrayR.add(in.nextInt());
            }

            StringBuffer sb = new StringBuffer();
            AtomicInteger numberCount = new AtomicInteger();

            arrayR.stream().sorted().forEach(r -> {
                StringBuffer subStr = new StringBuffer();
                int count = 0;
                for (int i = 0; i < arrayI.length; i++) {
                    if (-1 != arrayI[i].indexOf(r + "")) {
                        subStr.append(i);
                        subStr.append(" ");
                        subStr.append(arrayI[i]);
                        subStr.append(" ");
                        count++;
                    }
                }
                if (count > 0) {
                    numberCount.addAndGet(count * 2 + 2);
                    sb.append(r);
                    sb.append(" ");
                    sb.append(count);
                    sb.append(" ");
                    sb.append(subStr);
                }
            });

            sb.insert(0, numberCount.get() + " ");
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
