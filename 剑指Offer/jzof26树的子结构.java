package 剑指Offer;

class Solution {
    /*
    *   先判断根是否包含子树
    *       不包含就深度遍历
    *       DFS判断传入a结点是否包含b结点
    *       不包含则返回false继续判断a的左右子树
    *       返回true 短路||直接返回true
    * */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (DFS(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean DFS(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return DFS(a.left, b.left) && DFS(a.right, b.right);

    }
}
