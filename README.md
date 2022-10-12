# The Huffman-Encoding
The Huffman-Encoding is a form of entropy encoding, developed by David A. Huffman in 1952. This encoding is used for compression.

The class HuffmanEncoding.java contains the main algorithm. It uses the class Node.java to create a graph data structure. This structure describes
the probability distribution of every occuring character of the encoded string. The key thought in this algorithm is the following: Characters occuring
more often than others get a smaller code than characters occuring less often. With this attachment you can achieve a trivial data compression.

For more informations take a look at wikipedia: https://en.wikipedia.org/wiki/Huffman_coding
