Nicholas Gaston
nigaston - 2649642

###### HW8 README ######


Description:

The program receives a graph as a file from the command line. It reads through the file creating an adjacency list that represents the graph. The adjacency list, G, is created using the MyArrayList class with the type being the LinkedList class whose type is Integer. The graph is then sent to the shortestPath() (SP) method with the source being declared as 1. In the SP method, a MyArrayList of type Vertex, vSet, is created to hold the set of vertexes. The Vertex class constructs a vertex with the following attributes: index, been visited identifier, path distance, previous vertex. The SP method also creates a min-heap, Q, of the types Integer, representing the key, and Vertex, representing the value. Q is initialized by inserting all vertexes and setting their distance to Integer.MAX_VALUE. A source Vertex is then created and the source's distance is updated to 0. Following, a MyArrayList of type Vertex, called Vt, is created to hold the updated vertexes. Once Dijkstra's Shortest-Path Algorithm is completed, Vt is returned to the main() method and it is assigned to listOfPaths. The paths and distances are then printed to the screen.


Compilation Instruction:

cd nigaston/cis390/hw8
javac Dijkstras.java
java Dijkstras [filename here]


Sample Test Run:

Inserting: 1
Inserting: 2
Inserting: 3
Inserting: 4
Inserting: 5
Inserting: 6
Inserting: 7
Inserting: 8
Inserting: 9
Inserting: 10
Deleting: 1
Updating the distance (key/priority) of 2 in the min-heap
Updating the distance (key/priority) of 7 in the min-heap
Deleting: 2
Updating the distance (key/priority) of 5 in the min-heap
Deleting: 7
Updating the distance (key/priority) of 9 in the min-heap
Deleting: 9
Updating the distance (key/priority) of 6 in the min-heap
Updating the distance (key/priority) of 10 in the min-heap
Deleting: 10
Updating the distance (key/priority) of 4 in the min-heap
Deleting: 4
Updating the distance (key/priority) of 8 in the min-heap
Deleting: 8
Updating the distance (key/priority) of 5 in the min-heap
Deleting: 5
Updating the distance (key/priority) of 3 in the min-heap
Deleting: 3
Updating the distance (key/priority) of 6 in the min-heap
Deleting: 6
Shortest path to 1: 1; Distance: 0
Shortest path to 2: 1-2; Distance: 6
Shortest path to 3: 1-7-9-10-4-8-5-3; Distance: 35
Shortest path to 4: 1-7-9-10-4; Distance: 21
Shortest path to 5: 1-7-9-10-4-8-5; Distance: 28
Shortest path to 6: 1-7-9-10-4-8-5-3-6; Distance: 37
Shortest path to 7: 1-7; Distance: 6
Shortest path to 8: 1-7-9-10-4-8; Distance: 25
Shortest path to 9: 1-7-9; Distance: 11
Shortest path to 10: 1-7-9-10; Distance: 15

Existing Bugs:

No bugs, that I am aware of. However, the sample output given on the homework's website is different than mine and I want to state why:
	It is different because the algorithm used to create this output does not initialize the min-heap all at once. This algorithm that was used, creates the heap too ensure its number of nodes stay as small as possible at all times. This being said, what matters in the deleting of the nodes in the min-heap, which my program does identically to the one used for the sample.
 