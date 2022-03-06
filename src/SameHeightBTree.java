import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class SameHeightBTree{
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

	    public TreeNode sortedArrayToBST(int[] nums) {
	        int n = nums.length;
	        TreeNode lTree = new TreeNode(nums[0]);
	        TreeNode rTree = new TreeNode(nums[n-1]);
	        
	        return sortedArrayToBST(nums,lTree,rTree,1);
	    }
	    
	    public TreeNode sortedArrayToBST(int[] arr,TreeNode lTree, TreeNode rTree, int i) {
	        if(i==arr.length-i-1){
	            TreeNode l = new TreeNode(arr[i]);
	            l.left = lTree;
	            l.right = rTree;
	            return l;
	            
	        }else if(i==arr.length-i-2){
	            TreeNode l = new TreeNode(arr[i]);
	            l.left = new TreeNode(arr[arr.length-i-1]);
	            l.right =  rTree;
	            l.left.left = lTree;
	            return l;
	            
	        }
	  
	            
	            TreeNode l = new TreeNode(arr[i]);
	            TreeNode r = new TreeNode(arr[arr.length-i-1]);
	            l.left = lTree;
	            r.right =  rTree;
	            return sortedArrayToBST(arr,l,r,++i);

	        
	    }
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        Deque<TreeNode> bfs = new LinkedList<>();
	        bfs.addLast(root);
			return null;
	    }
	    public static void main(String[] args) {
			SameHeightBTree sameHeightBTree = new SameHeightBTree();
			int[] arr = {-10,-3,0,5,9};
			sameHeightBTree.sortedArrayToBST(arr);
		}
	}