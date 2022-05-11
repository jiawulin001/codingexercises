package datastructure;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //栈结构，如果不改变栈大小，用ArrayDeque，改变用LinkedList
        //LinkedList和ArrayDeque
        //stack.push(i);放入最前面
        //stack.add(i);放入最后面


        //List<Integer> 转 int[]
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 20; i += 2) {
            numList.add(i);
        }
        //先通过mapToInt转成IntStream,在使用IntStream的.toArray就是int[]
        int[] nums = numList.stream().mapToInt(Integer::valueOf).toArray();


        //优先队列
        //PriorityQueue priorityQueue = new PriorityQueue(默认堆大小，比较函数)
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(11, (str1, str2) -> {
            return str1.compareTo(str2);
        });
        priorityQueue.add("a");//增加
        priorityQueue.remove("a");//删除
        priorityQueue.poll();//弹出队首
        priorityQueue.peek();//检查队首

        //队列
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.peek();
        list.pop();

        //双端队列
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addFirst("b");
        deque.addLast("a");
        deque.pollFirst();
        deque.pollLast();
        deque.peekFirst();
        deque.peekLast();

        TreeMap<Integer, String> map = new TreeMap();
        //TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < 10; i++)
            map.put(2 * i, "value" + i);//0,2,4,6,8,10
        //返回小于或等于给定键的最大键，如果没有这样的键，则null
        System.out.println(map.floorKey(3));
        //返回小于或等于，inclusive=false就不返回等于
        Map<Integer, String> map2 = map.headMap(4, false);


        //返回大于或等于给定键的最小键，如果没有这样的键，则null
        System.out.println(map.ceilingKey(3));
        //返回大于或者等于，inclusive=false就不返回等于
        map2 = map.tailMap(4, false);

        //LRU
        new LinkedHashMap();


        //BFS
        //队列  set可以记录是否访问过
        LinkedList<TreeNode> queur = new LinkedList();
        while (!queur.isEmpty()) {
            TreeNode node = queur.pop();
            //queur.add(//左子树)
            //queur.add(//右子树)
        }

        //DFS
        //递归
//        private void dfs(int row, Deque<Integer> path) {
//            if (row == n) {
//                List<String> board = convert2board(path);
//                res.add(board);
//                return;
//            }
//            // 针对每一列，尝试是否可以放置
//            for (int i = 0; i < n; i++) {
//                if (!col.contains(i) && !main.contains(row - i) && !sub.contains(row + i)) {
//                    path.addLast(i);
//                    col.add(i);
//                    main.add(row - i);
//                    sub.add(row + i);
//
//                    dfs(row + 1, path);
//
//                    sub.remove(row + i);
//                    main.remove(row - i);
//                    col.remove(i);
//                    path.removeLast();
//                }
//            }
//        }
    }

}
