package leetcodeday;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 * 1305. 两棵二叉搜索树中的所有元素
 */
public class Day20220501 {

    public static void main(String[] args) {
        Day20220501 test = new Day20220501();
        TreeNode node2 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node = new TreeNode(2, node1, node2);

        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1, node3, node4);
        test.getAllElements(node, node5).forEach(System.out::println);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {


        List<Integer> result = new ArrayList<>();
        getVal(root1, result);
        getVal(root2, result);

        result.sort(Comparator.naturalOrder());
        return result;
    }

    private void getVal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.left != null) {
            getVal(node.left, result);
        }
        if (node.right != null) {
            getVal(node.right, result);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}