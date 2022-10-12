public class main {

	public static void main(String[] args) {
		
		HuffmanEncoding encoding = new HuffmanEncoding();
		
		String unserText = "This text is going to be encoded!";
		
		System.out.println("Initial text: " + unserText);
		
		String encoded = encoding.encode(unserText);
		System.out.println("Huffman code: " + encoded);
		
		String decoded = encoding.decode(encoded);
		System.out.println("Huffman code turned back initial text: " + decoded);
	}

}
