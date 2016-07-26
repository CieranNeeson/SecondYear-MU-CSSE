package Labs;

////////////////////////////////////////////////////////////////
public class Tree implements Comparable<Tree>
   {
   		public Node root;             // first node of tree
   		public int frequency=0;

// -------------------------------------------------------------
	   public Tree()
	   	{
	   		root = null;
	   	}            // no nodes in tree yet
// -------------------------------------------------------------

		//the PriorityQueue needs to be able to somehow rank the objects in it
		//thus, the objects in the PriorityQueue must implement an interface called Comparable
		//the interface requires you to write a compareTo() method so here it is:

		 public int compareTo(Tree object){ //
		     if(frequency-object.frequency>0){ //compare the cumulative frequencies of the tree
		         return 1;
		      }else if(frequency-object.frequency<0){
		           return -1;   //return 1 or -1 depending on whether these frequencies are bigger or smaller
		      }else{
		           return 0;   //return 0 if they're the same
		      }
		   }

// -------------------------------------------------------------

   String path;     //this variable will track the path to the letter we're looking for

	public String getCode(char letter)
	{
		path = new String("");
		inOrder(root, letter, path);
		return path;
	}
   public void inOrder(Node localRoot, char letter, String path)
   	{

		if(localRoot != null)
		{
			if(localRoot.letter==letter){
				this.path=path;
			}
			else{
				inOrder(localRoot.rightChild, letter, "1"+path);
				inOrder(localRoot.leftChild, letter, "0"+path);

			}
		}
   }

}  // end class Tree
////////////////////////////////////////////////////////////////
