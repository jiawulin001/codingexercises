package leetcodeday;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * 449. 序列化和反序列化二叉搜索树
 */
public class Day20220511 {

    public static void main(String[] args) {
        Codec c = new Codec();

        Codec.TreeNode nodef = new Codec.TreeNode('F');
        Codec.TreeNode nodec = new Codec.TreeNode('C');
        Codec.TreeNode nodee = new Codec.TreeNode('E');
        Codec.TreeNode nodea = new Codec.TreeNode('A');
        Codec.TreeNode noded = new Codec.TreeNode('D');
        Codec.TreeNode nodeh = new Codec.TreeNode('H');
        Codec.TreeNode nodeg = new Codec.TreeNode('G');
        Codec.TreeNode nodeb = new Codec.TreeNode('B');
        Codec.TreeNode nodem = new Codec.TreeNode('M');

        nodef.left = nodec;
        nodef.right = nodee;

        nodec.left = nodea;
        nodec.right = noded;

        nodee.left = nodeh;
        nodee.right = nodeg;

        noded.left = nodeb;

        nodeg.left = nodem;

        String str = c.serialize(nodef);
        Codec.TreeNode root = c.deserialize(str);
        System.out.println(c.serialize(root));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        getVal(root, sb);
        return sb.toString();
    }

    private void getVal(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        sb.append(",");
        if (root.left != null) {
            getVal(root.left, sb);
        }
        sb.append(",");
        if (root.right != null) {
            getVal(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }

        String[] nums = data.split(",");
        int[] index = {0};
        return createTree(nums, index);
    }

    private TreeNode createTree(String[] nums, int[] index) {
        if (index[0] >= nums.length || nums[index[0]].equals("")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nums[index[0]]));
        index[0]++;
        root.left = createTree(nums, index);
        index[0]++;
        root.right = createTree(nums, index);
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

