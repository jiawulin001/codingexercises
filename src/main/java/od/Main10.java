package od;

import java.util.Scanner;

public class Main10 {

    /**
     * <h1>最小传输时延</h1>
     * 某通信网络中有N个网络结点，用1到N进行标识。<br>
     * 网络通过一个有向无环图表示，其中图的边值表示结点之间的消息传递时延。<br>
     * 先给定相连节点之间的时延列表times[i]={u,v,w}，<br>
     * 其中u表示源结点，v表示目标结点，w表示u和v之间的消息传递时延。<br>
     * 请计算给定源结点的最小时传输时延，如果目的结点不可达，返回-1.<br>
     * 注：
     * <li>N的取值范围为【1，100】</li>
     * <li>时延列表times的长度不超过6000，且1<=u,v<=N,0<=w<=100;</li>
     *
     * <h2>输入描述：</h2>
     * 输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表长度M，用空格分隔；<br>
     * 接下来的M行为两个结点间的时延列表【u v w】;<br>
     * 输入的最后一行为两个正整数u和v,分别表示源结点和目的结点；<br>
     *
     * <h2>输出描述：</h2>
     * 输出一个整数，表示源结点到目的结点的最小时延。
     *
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 3 3<br>
     * 1 2 11<br>
     * 2 3 13<br>
     * 1 3 50<br>
     * 1 3<br>
     * <h3>输出</h3>
     * 24
     */
    public static void main(String[] args) {
        String input = "3 3\n1 2 11\n2 3 13\n1 3 50\n1 3";
        //String input = "6 6\n1 3 1\n3 6 2\n6 4 2\n6 2 3\n5 4 5\n2 4 1\n1 4";
        //String input = "6 6\n1 3 1\n3 6 2\n6 4 2\n6 2 3\n5 4 5\n2 4 1\n1 5";

        Scanner in = new Scanner(input);

        int[][] graph;
        int n, m;
        while (in.hasNext()) {
            n = in.nextInt() + 1;
            m = in.nextInt();
            graph = new int[n][n];

            for (int i = 0; i < m; i++) {
                graph[in.nextInt()][in.nextInt()] = in.nextInt();
            }

            int time = getTimes(graph, in.nextInt(), in.nextInt(), 0);

            System.out.println(time == 100 ? -1 : time);
        }
    }

    private static int getTimes(int[][] graph, int begin, int end, int time) {
        if (end == begin) {
            return time;
        }
        int min = 100;
        int num;
        for (int i = 0; i < graph[begin].length; i++) {
            if (graph[begin][i] != 0) {
                num = getTimes(graph, i, end, graph[begin][i] + time);
                min = Math.min(min, num);
            }

        }
        return min;
    }


}

