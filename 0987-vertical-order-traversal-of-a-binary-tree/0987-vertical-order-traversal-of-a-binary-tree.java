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
    TreeMap <Integer , TreeMap<Integer , ArrayList<Integer> >> map  =  new TreeMap<>(); 
    //{VERTICAL --> ({LEVEL --> })}
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result  = new ArrayList<>();
            if(root == null){
                return result;
            }

            dfs(root,0,0);//dfs call to fill the map
            //col wise sorting 
            for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : map.entrySet()) {
                TreeMap<Integer, ArrayList<Integer>> levelMap = entry.getValue();
                ArrayList <Integer> list  = new ArrayList<>();
                //level wise sorting
                for (Map.Entry < Integer, ArrayList<Integer>> subEntry : levelMap.entrySet( )) {
                    ArrayList <Integer> sublist  =  subEntry.getValue();
                    Collections.sort(sublist);
                    list.addAll(sublist);

                }
                result.add(list);
            }
            return result;


    }
    public  void dfs (TreeNode root , int col , int level){
            if(root == null){
                return ;
            }
            //insert in mapp
            if(!map.containsKey(col)){
                map.put(col,new TreeMap<>());
            }
            if(!map.get(col).containsKey(level)){
                map.get(col).put(level, new ArrayList<>());

            }

            map.get(col).get(level).add(root.val);

            dfs(root.left ,  col - 1, level + 1 );
            dfs(root.right ,  col + 1, level + 1 );
    }





        // // A map to store nodes according to their horizontal and vertical levels
        // Map<Integer, Map<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();

        // // A queue to perform BFS. Stores pairs of (node, (horizontal level, vertical level))
        // Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();

        // // Start BFS with the root node at horizontal level 0 and vertical level 0
        // queue.add(new Pair<>(root, new Pair<>(0, 0)));

        // while (!queue.isEmpty()) {
        //     Pair<TreeNode, Pair<Integer, Integer>> p = queue.poll();
        //     TreeNode temp = p.getKey();
        //     int x = p.getValue().getKey();
        //     int y = p.getValue().getValue();

        //     // Add the current node to the nodes map
        //     nodes.computeIfAbsent(x, k -> new TreeMap<>())
        //          .computeIfAbsent(y, k -> new PriorityQueue<>())
        //          .add(temp.val);

        //     // If there is a left child, add it to the queue with the updated levels
        //     if (temp.left != null) {
        //         queue.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
        //     }

        //     // If there is a right child, add it to the queue with the updated levels
        //     if (temp.right != null) {
        //         queue.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
        //     }
        // }

        // // Prepare the result list
        // List<List<Integer>> ans = new ArrayList<>();
        // for (Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> entry : nodes.entrySet()) {
        //     List<Integer> col = new ArrayList<>();
        //     for (PriorityQueue<Integer> pq : entry.getValue().values()) {
        //         while (!pq.isEmpty()) {
        //             col.add(pq.poll());
        //         }
        //     }
        //     ans.add(col);
        // }
        // return ans;
    
}