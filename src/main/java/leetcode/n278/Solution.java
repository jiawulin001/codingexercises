package leetcode.n278;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.firstBadVersion(2126753390);
    }
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        int mid;
        while (l < r){
            mid = (int)(((long)l + r) / 2);
            if (isBadVersion(mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }
    public boolean isBadVersion(int v){
        return v >= 1702766719;
    }
}
