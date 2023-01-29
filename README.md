# Huffman-Encoding

Huffman entropy encoding is a lossless data compression algorithm that (in this case) utilizes a graph data structure to compress data efficiently. The algorithm works by assigning variable-length codes to characters based on their frequency of occurrence in a given data. The goal of the encoding is to assign shorter codes to more frequently occurring characters and longer codes to less frequent ones, thereby achieving higher compression.

A Huffman code tree is created to represent the characters and their corresponding frequencies. The tree is implemented using a graph data structure where each node represents a character or a combination of characters. The root of the tree is the node that represents the entire data, and the leaves represent the individual characters. The weight of a node is equal to the frequency of occurrence of the characters it represents.

To create a Huffman code tree, the following steps are followed:

1. Create a leaf node for each character in the data, along with its frequency.
2. Combine two nodes with the lowest frequency into a new node, with the sum of their frequencies as its weight.
3. Repeat step 2 until there is only one node left, which will be the root of the tree.
4. Starting from the root node, assign a 0-bit to the left child and a 1-bit to the right child, working your way down to the leaves. The code for a character is the sequence of 0s and 1s from the root to its corresponding leaf node.

The final result of the Huffman entropy encoding is a compact representation of the data, where the more frequently occurring characters are assigned shorter codes. The graph data structure used in the encoding makes the process efficient, fast, and easy to implement. The algorithm is widely used in various applications, such as image, audio, and text compression, and is considered one of the most effective methods for data compression.

For more informations take a look at [Wikipedia](https://en.wikipedia.org/wiki/Huffman_coding).

* The main-class encodes an example string and decodes the result to show the usage
* The node-class defines a node object for the graph data structure with the needed information about the entropy and its connected nodes
* The HuffmanEncoding-class implements the algorithm and uses the node-class to create the graph data structure
