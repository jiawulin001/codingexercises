package od;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/flipping-an-image/
 */
public class Main24 {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        Main24 m = new Main24();
        System.out.println(JSON.toJSONString(m.flipAndInvertImage(image)));
    }


    public int[][] flipAndInvertImage(int[][] image) {
        int[][] result = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = image[i].length - 1, k = 0; j >= 0; j--, k++) {
                //result[i][k] = image[i][j] == 1 ? 0 : 1;
                result[i][k] = 1 - image[i][j];
            }
        }
        return result;
    }

}

