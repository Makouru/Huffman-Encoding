public class Node {	
	
	Node(double probability, String character) {
		this.probability = probability;
		this.character = character;
	}
	
	Node(double probability) {
		this.probability = probability;
	}
	
	Node() {}
	
	private double probability = 0;
	private String character;
	
	private Node left_node = null;
	private Node right_node = null;
	private Node parent = null;
	
	public Boolean LeftChild = false;
	public Boolean RightChild = false;
	
	public Node getParent() {return parent;}
	public void setParent(Node e) {this.parent = e;}
		
	public void setProbability(double pb) {this.probability = pb;}
	public void setCharacter(String ch) {this.character = ch;}
	
	public double getProbability() {return probability;}
	public String getCharacter() {return character;}
	
	public Boolean isLeftChild() {return LeftChild;}
	public Boolean isRightChild() {return RightChild;}
	
	public void setRightChild() {this.RightChild = true;}
	public void setLeftChild() {this.LeftChild = true;}
			
	public Node getLeft() {return left_node;}
	public Node getRight() {return right_node;}
		
	public void setLeftNode(Node e) {this.left_node = e;}
	public void setRightNode(Node e) {this.right_node = e;}
	
	}



