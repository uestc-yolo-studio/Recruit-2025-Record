package Tree;

import java.util.Scanner;

public class BinaryTreeTraversal {
    // 构建一个样本智慧核心
    public static Scanner scanner = new Scanner(System.in);
    public static TreeNode buildSampleTree() {

       if(!scanner.hasNextInt()){
           return null;
       }
       int val = scanner.nextInt();
       if(val == -1){
           return null;
       }
       TreeNode root = new TreeNode(val);
       root.left = buildSampleTree();
       root.right = buildSampleTree();
       return root;
    }

    // 前序遍历（核心 -> 左分支 -> 右分支）
    public static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);

    }
    // 中序遍历（左分支 -> 核心 -> 右分支）
    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);

    }
    // 后序遍历（左分支 -> 右分支 -> 核心）
    public static void postorder(TreeNode node) {
         if (node == null) {
            return;
        }
         postorder(node.left);
         postorder(node.right);
         System.out.print(node.val + " ");
    }

    // 魔法测试
    public static void main(String[] args) {
        TreeNode root = buildSampleTree();
        System.out.print("前序探知：");
        preorder(root); // 预期输出: 1 2 4 5 3 6
        System.out.println();

        System.out.print("中序探知：");
        inorder(root); // 预期输出: 4 2 5 1 3 6
        System.out.println();

        System.out.print("后序探知：");
        postorder(root); // 预期输出: 4 5 2 6 3 1
    }
}
