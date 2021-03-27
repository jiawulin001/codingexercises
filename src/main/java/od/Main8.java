package od;

import java.util.*;

public class Main8 {
    /**
     * <h1>目录删除</h1>
     * <p>
     * 某文件系统种有N个目录，每个目录都有一个独一无二的ID。<br>
     * 每个目录只有一个父目录，但每个父目录下可以有零个或者多个子目录，目录结构呈树状结构。<br>
     * 假设，根目录的ID位0，且根目录没有父目录，其他所有目录的ID用唯一的正整数表示，并统一编号。<br>
     * </p>
     * <p>
     * 现给定目录ID和其父目录ID 的对应父子关系表【子目录ID，父目录ID】，以及一个待删除的目录ID，<br>
     * 请计算并返回一个ID序列，表示因为删除指定目录后剩下的所有目录，返回的ID序列以递增序输出。<br>
     * 注意：<br>
     * <li>被删除的目录或文件编号一定在输入的ID序列种；</li>
     * <li>当一个目录删除时，它所有的子目录都会被删除。</li>
     * </p>
     * <h2>输入描述：</h2>
     * 输入的第一行位父子关系表的长度M；<br>
     * 接下来的M行为m个父子关系对；<br>
     * 最后一行为待删除的ID。<br>
     * 序列中的元素已空格分隔，
     * <h2>输出描述：</h2>
     * 输出一个序列，表示因为删除指定目录后，剩余的目录ID
     *
     * <h2>示例1</h2>
     * <h3>输入</h3>
     * <P>5<br>
     * 8 6<br>
     * 10 8<br>
     * 6 0<br>
     * 20 8<br>
     * 2 6<br>
     * 8</P>
     * <h3>输出：</h3>
     * 2 6
     */
    public static void main(String[] args) {
        String input = "5\n8 6\n10 8\n6 0\n20 8\n2 6\n8";
        Scanner in = new Scanner(input);

        int length;
        Map<Integer, Set<Integer>> dirs;
        Set<Integer> subs;
        int delDir;
        int subId, parentId;
        while (in.hasNext()) {
            length = in.nextInt();
            //dirs = new Integer[length];
            dirs = new HashMap<>(length);
            for (int i = 0; i < length; i++) {
                subId = in.nextInt();
                parentId = in.nextInt();
                subs = dirs.getOrDefault(parentId, new HashSet<>());
                subs.add(subId);
                dirs.put(parentId, subs);
            }
            delDir = in.nextInt();
            subs = new HashSet<>();
            getValues(dirs, 0, subs, delDir);

            subs.stream().sorted().forEach(id -> {
                if (id == 0) {
                    return;
                }
                System.out.print(id + " ");
            });
        }
    }

    private static void getValues(Map<Integer, Set<Integer>> dirs, int currDir, Set<Integer> result, int delDir) {
        if (delDir == currDir) {
            return;
        }
        result.add(currDir);
        if (dirs.containsKey(currDir)) {
            dirs.get(currDir).forEach(id -> {
                getValues(dirs, id, result, delDir);
            });
        }
    }

}

