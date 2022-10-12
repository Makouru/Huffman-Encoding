import java.util.ArrayList;

public class HuffmanEncoding {
	Node root = null;
	
	ArrayList<Node> Nodes = new ArrayList<Node>();
	ArrayList<Node> Leafs = new ArrayList<Node>();
	
	String[] characters;
	int character_length = 0;
	
	public ArrayList<Node> create_node_list(String data_string) {
		Boolean found = false;
		
		String[] characters = data_string.split("");
		this.character_length = characters.length;
		this.characters = characters;
		for(int i = 0; i < characters.length; i++) {
			found = false;
			for(int counter = 0; counter < Nodes.size(); counter++) {
				if(characters[i].equals(Nodes.get(counter).getCharacter())) {
					Nodes.get(counter).setProbability(Nodes.get(counter).getProbability() + 1);
					found = true;
				}
			}
			if(found == false) {
				Node newNode = new Node(1, characters[i]);
				Nodes.add(newNode);
			}
			
		}
		
		for(int counter = 0; counter < Nodes.size(); counter++) {
			Nodes.get(counter).setProbability(Nodes.get(counter).getProbability() / character_length);
		}
		
		return Nodes;
		
	}
	
	public String encode(String text) {
		
		this.Nodes = create_node_list(text);
		this.Leafs = create_leaf_array();
		create_encoding_graph();
		
		StringBuilder encoded_string = new StringBuilder();
		
		for(int counter = 0; counter < characters.length; counter++) {
			encoded_string.append(getCode(characters[counter]));
		}
		
		String final_string = encoded_string.toString();
		return final_string;
	}
	
	public String decode(String encoded_data) {
		Node start = root;
		
		String encoded_data_split[] = encoded_data.split("");
		StringBuilder decoded_string = new StringBuilder();
		
		for(int counter = 0; counter < encoded_data_split.length; counter++) {
			for(int counter2 = 0; counter2 < Leafs.size(); counter2++) {
				if(start == Leafs.get(counter2)) {
					decoded_string.append(start.getCharacter());
					start = root;
				}
			}
			
			if(encoded_data_split[counter].equals("1")) {
				start = start.getRight();
			} else  {
				start = start.getLeft();
			}
		}
		
		decoded_string.append(start.getCharacter());
		String final_output = decoded_string.toString();
		return final_output;	
	}
	
	
	public String getCode(String character) {
		Node start = new Node();
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int counter = 0; counter < Leafs.size(); counter++) {
			if(Leafs.get(counter).getCharacter().equals(character)) {
				start = Leafs.get(counter);
			}
		}
		
		while(start.getParent() != root) {
			if(start.isRightChild()) {
				stringBuilder.append("1");
			} else {
				stringBuilder.append("0");
			}
			
			start = start.getParent();
		}
		
		if(start.isRightChild()) {
			stringBuilder.append("1");
		} else {
			stringBuilder.append("0");
		}
		
		StringBuilder finalStringReversed = stringBuilder.reverse();
		String finalString = finalStringReversed.toString();
		return finalString;
	}
	
	public ArrayList<Node> create_leaf_array() {
		for(int counter = 0; counter < Nodes.size(); counter++) {
			Leafs.add(Nodes.get(counter));
		}
		return Leafs;
	}
	
	public void create_encoding_graph() {

		while(Nodes.size() != 1) {
			
			Node f_tv = Nodes.get(0);
			for(int counter = 0; counter < Nodes.size(); counter++) {
				if(Nodes.get(counter).getProbability() < f_tv.getProbability()) {
					f_tv = Nodes.get(counter);
				}
			}
			
			Nodes.remove(f_tv);
						
			Node s_tv = Nodes.get(0);
			for(int counter = 0; counter < Nodes.size(); counter++) {
				if(Nodes.get(counter).getProbability() < s_tv.getProbability()) {
					s_tv = Nodes.get(counter);
				}
			}
			
			Nodes.remove(s_tv);
			
			
			if(f_tv.getProbability() == s_tv.getProbability()) {
				Node newConnection = new Node(f_tv.getProbability() + s_tv.getProbability());
				
				newConnection.setRightNode(f_tv);
				f_tv.setRightChild();
				f_tv.setParent(newConnection);
				
				newConnection.setLeftNode(s_tv);
				s_tv.setLeftChild();
				s_tv.setParent(newConnection);
				
				Nodes.add(newConnection);
				
			} else if(f_tv.getProbability() < s_tv.getProbability()) {
				Node newConnection = new Node(f_tv.getProbability() + s_tv.getProbability());
				
				newConnection.setRightNode(f_tv);
				f_tv.setRightChild();
				f_tv.setParent(newConnection);
				
				newConnection.setLeftNode(s_tv);
				s_tv.setLeftChild();
				s_tv.setParent(newConnection);
				
				Nodes.add(newConnection);
				
			} else if(s_tv.getProbability() < f_tv.getProbability()) {
				Node newConnection = new Node(s_tv.getProbability() + f_tv.getProbability());
				
				newConnection.setRightNode(s_tv);
				s_tv.setRightChild();
				s_tv.setParent(newConnection);
				
				newConnection.setLeftNode(f_tv);
				f_tv.setLeftChild();
				f_tv.setParent(newConnection);
				
				Nodes.add(newConnection);
			}
			
		}
		
		this.root = Nodes.get(0);
		
	}
	
}