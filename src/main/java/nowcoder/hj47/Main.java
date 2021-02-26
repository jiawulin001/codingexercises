package nowcoder.hj47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedHashMap;

public class Main {
    public static void main1(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int m, n, length, temp, j;
        LinkedHashMap<Integer, Integer> data;
        Integer[] numbers;
        int[] result;
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            m = (int) st.nval;
            st.nextToken();
            n = (int) st.nval;
            length = n - m - 1;
            data = new LinkedHashMap();

            for (int i = 0; i < m; i++) {
                st.nextToken();
                temp = (int) st.nval;
                st.nextToken();
                if (!data.containsKey(temp)) {
                    data.put(temp, (int) st.nval);
                }
            }

            numbers = data.keySet().stream().sorted().toArray(Integer[]::new);
            result = new int[length + m];
            j = 0;

            for (int i = 0; i < length; ) {
                if (numbers[i] - numbers[i + 1] == 1) {
                    result[j] = numbers[i];
                    j++;
                } else {
                    //A+( (B-A)/(N-M) )*i
                    temp = data.get(numbers[i]) + ((data.get(numbers[i + 1] - data.get(numbers[i]))) / (numbers[i + 1] - numbers[i])) * i + 1;
                    data.put(numbers[i] + 1, temp);
                    result[j] = numbers[i] + 1;
                    j++;
                    i++;
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
                sb.append(" ");
                sb.append(data.get(result[i]));
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }


    public static void main2(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String[] temp = new String[2];
        int length;
        int[][] values = new int[2][2];//values[0][0]开始编号 values[0][1] 开始值   values[1][0] 结束编号 values[1][1] 结束值
        values[1][0] = -1;
        values[1][1] = -1;
        int count, tempNum;
        boolean isBreak = false;
        StringBuffer sb = new StringBuffer();
        while ((str = in.readLine()) != null) {
            length = Integer.parseInt(str.split(" ")[0]);
            str = null;
            for (int i = 0; i < length; ) {
                if (str == null) {
                    temp = in.readLine().split(" ");
                }
                values[0][0] = Integer.parseInt(temp[0]);
                values[0][1] = Integer.parseInt(temp[1]);
//                if (values[1][0] != -1 && values[0][0] == values[1][0]) {
//                    i++;
//                    continue;
//                }


                sb.append(values[0][0]);
                sb.append(" ");
                sb.append(values[0][1]);
                sb.append("\n");

                isBreak = true;
                while (i + 1 < length) {
                    str = in.readLine();
                    temp = str.split(" ");
                    values[1][0] = Integer.parseInt(temp[0]);
                    values[1][1] = Integer.parseInt(temp[1]);
                    i++;
                    if (values[0] == values[1]) {
                        continue;
                    } else {
                        isBreak = false;
                        break;
                    }
                }

                if (isBreak) {
                    break;
                }

                count = values[1][0] - values[0][0] - 1;
                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        //A+((B-A)/(N-M))*i
                        tempNum = values[0][1] + ((values[1][1] - values[0][1]) / (values[1][0] - values[0][0])) * (j + 1);
                        sb.append(values[0][0] + j + 1);
                        sb.append(" ");
                        sb.append(tempNum);
                        sb.append("\n");
                    }
//                    sb.append(values[1][0]);
//                    sb.append(" ");
//                    sb.append(values[1][1]);
//                    sb.append("\n");
//                    str = null;
//                    i++;
                }//  else {
//                    values[1][0] = -1;
//                    values[1][1] = -1;
//                }
            }

            System.out.println(sb.toString());
            sb = new StringBuffer();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String[] temp = new String[2];
        int length;
        int[][] values = new int[2][2];//values[0][0]开始编号 values[0][1] 开始值   values[1][0] 结束编号 values[1][1] 结束值
        values[1][0] = -1;
        values[1][1] = -1;
        int count, tempNum;
        boolean isBreak = false;
        StringBuffer sb = new StringBuffer();
        while ((str = in.readLine()) != null) {
            length = Integer.parseInt(str.split(" ")[0]);
            str = null;
            for (int i = 0; i < length; i++) {
                if (str == null) {
                    temp = in.readLine().split(" ");
                }
                values[0][0] = Integer.parseInt(temp[0]);
                values[0][1] = Integer.parseInt(temp[1]);

                sb.append(values[0][0]);
                sb.append(" ");
                sb.append(values[0][1]);
                sb.append("\n");

                isBreak = true;
                while (i + 1 < length) {
                    str = in.readLine();
                    temp = str.split(" ");
                    values[1][0] = Integer.parseInt(temp[0]);
                    values[1][1] = Integer.parseInt(temp[1]);
                    if (values[0][0] == values[1][0]) {
                        i++;
                        continue;
                    } else {
                        isBreak = false;
                        break;
                    }
                }

                if (isBreak) {
                    break;
                }

                count = values[1][0] - values[0][0] - 1;
                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        //A+((B-A)/(N-M))*i
                        tempNum = values[0][1] + ((values[1][1] - values[0][1]) / (values[1][0] - values[0][0])) * (j + 1);
                        sb.append(values[0][0] + j + 1);
                        sb.append(" ");
                        sb.append(tempNum);
                        sb.append("\n");
                    }
                }
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb.toString());
            sb = new StringBuffer();
        }
    }
}
