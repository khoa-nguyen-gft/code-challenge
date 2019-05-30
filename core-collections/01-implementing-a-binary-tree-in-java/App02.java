public class App02 {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.create();
		System.out.println(bt.isContain(6));
		System.out.println(bt.isContain(4));
		System.out.println(bt.isContain(1));

		System.out.println(bt.delete(6));

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
	
	//delete an Element
	public Node delete(int value) {
		return BinaryTreeRecurte.deleteRecrute(node, value);
	}
}	



class BinaryTreeRecurte {
	
	public static int findLeftValue(Node node) {
		if(node.getLeft() == null) {
			return node.getValue();
		}
		
		return findLeftValue(node.getLeft());		
	}
	
	
	public static Node deleteRecrute(Node current, int value) {
		if (current == null) {
			return null;
		}
		
		if (current.getValue() == value) {
			if(current.getLeft() == null && current.getRight() == null) {
				return null;
			}
			
			if (current.getLeft() == null) {
				return current.getRight();
			}
			
			if (current.getRight() == null) {
				return current.getLeft();
			}
			
			if (current.getLeft() != null && current.getRight() != null) {
				int leftValue = findLeftValue(current.getRight());
				current.setValue(leftValue);
				current.setRight(deleteRecrute(current.getRight(), leftValue));
				return current;
			}
			
			
		}
		
		return (current.getValue() > value) ? deleteRecrute(current.getLeft(), value): 
			deleteRecrute(current.getRight(), value);
		
	}
	
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
	
	@Override
	public String toString() {
		
		return String.valueOf(value);
	}
	
	
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