public class App {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.create();
		System.out.println(bt.isContain(6));
		System.out.println(bt.isContain(4));
		System.out.println(bt.isContain(1));


	}

}


class BinaryTree {
	private Node node;

	
	public static BinaryTree create() {
		BinaryTree bt = new BinaryTree();
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(5);
		bt.add(9);
		
		return bt;
	}
	
	// Inserting Elements
	public Node add(int value) {
		node = BinaryTreeRecurte.addRecrute(node, value);
		return node;
	}
	
	// Finding an Element
	public boolean isContain(int value) {
		return BinaryTreeRecurte.isContainRecrute(node, value);
	}
	
	// Deleting an Element
}	



class BinaryTreeRecurte {
	
	public static boolean isContainRecrute(Node node, int value) {
		if (node == null) {
			return false;
		}
		
		if (node.getValue() == value) {
			return true;
		}	
		
		if (node.getValue() > value) {
			return isContainRecrute(node.getLeft(), value);
		}
		
		if (node.getValue() < value) {
			return isContainRecrute(node.getRight(), value);
		}
				
		return false;
	}
	
	public static Node addRecrute(Node node, int value){
		if(node == null) {
			return new Node(value);
		}
		
		if (node.getValue() > value && node.getLeft() == null) {
			node.setLeft(new Node(value));
			return node;
		}
		
		if (node.getValue() < value && node.getRight() == null) {
			node.setRight(new Node(value));
			return node;
		}
			
		if (node.getValue() > value && node.getLeft() != null) {
			addRecrute(node.getLeft(), value);
		}
		
		if (node.getValue() < value && node.getRight() != null) {
			addRecrute(node.getRight(), value);
		}
		
		return node;
	}
	
}


class Node {
	
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}	
	
}