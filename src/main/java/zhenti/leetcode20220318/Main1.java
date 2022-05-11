package zhenti.leetcode20220318;

public class Main1 {
    public static void main(String[] args) {
        int materialNum = 3;
        int[][] products = {{0, 2, 0}, {2, 1, 1}, {0, 1, 1}};
        InventorySystem is = new InventorySystem(materialNum, products);
        is.purchase(new int[][]{{1, 5}, {2, 4}});
        is.purchase(new int[][]{{0, 9}, {1, 3}});
        System.out.println(is.produce(new int[]{0, 1}));

        System.out.println(2 == is.queryMin());

        System.out.println(is.produce(new int[]{1, 1, 2}));

        is.purchase(new int[][]{{2, 2}});

        System.out.println(1 == is.queryMin());


    }
}

class InventorySystem {
    private int materialsNum;
    private int[] materials;
    private int[][] products;//物料编号0开始

    InventorySystem(int materialsNum, int[][] products) {
        this.materialsNum = materialsNum;
        this.materials = new int[materialsNum];
        this.products = products;
    }

    public void purchase(int[][] materials) {
        for (int i = 0; i < materials.length; i++) {
            this.materials[materials[i][0]] += materials[i][1];
        }
    }

    public boolean produce(int[] productIds) {
        int[] useMaterials = new int[materialsNum];
        for (int i = 0; i < productIds.length; i++) {
            for (int j = 0; j < products[productIds[i]].length; j++) {
                //是否有材料
                //已使用+本次使用比剩余的多
                if (useMaterials[j] + products[productIds[i]][j] > materials[j]) {
                    //不够生产，退出
                    return false;
                } else {
                    useMaterials[j] += products[productIds[i]][j];
                }
            }
        }
        //材料足够，开始扣减
        for (int i = 0; i < useMaterials.length; i++) {
            this.materials[i] -= useMaterials[i];
        }

        return true;
    }

    public int queryMin() {
        int minMaterialsNum = 0;
        for (int i = 1; i < materials.length; i++) {
            if (this.materials[i] < this.materials[minMaterialsNum]) {
                minMaterialsNum = i;
            }
        }
        return minMaterialsNum;
    }
}
