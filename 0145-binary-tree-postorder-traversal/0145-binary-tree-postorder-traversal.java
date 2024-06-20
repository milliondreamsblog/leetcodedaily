/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //###############using 1 stack ##################
        TreeNode current  = root;
        List <Integer> result  = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();

        while(!s1.isEmpty() || current != null){
            if(current!= null){
                s1.push(current);
                current  = current.left;

            }else{
                TreeNode temp = s1.peek().right;
                if(temp == null){
                    temp  =s1.pop();
                    result.add(temp.val);
                    while(!s1.isEmpty() && temp == s1.peek().right){
                        temp = s1.pop();
                        result.add(temp.val);
                    }
                }else{
                    current  = temp;
                }

            }

        }
        return result;


        // //############using 2 stacks#####################

        // List<Integer> result = new ArrayList<>();
        // Stack<TreeNode> s1 = new Stack<>();
        // Stack<TreeNode> s2 = new Stack<>();

        // if(root == null){
        //     return result;
        // }

        // s1.add(root);

        // while(!s1.isEmpty()){
        //     root = s1.pop();

        //     s2.add(root);
        //     if(root.left != null){
        //         s1.add(root.left);
        //     }
        //     if(root.right != null){
        //         s1.add(root.right);
        //     }

        // }

        // while(!s2.isEmpty()){
        //     result.add(s2.pop().val);
        // }

        // return result;
    }
}