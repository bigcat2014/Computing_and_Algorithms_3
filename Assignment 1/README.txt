This program reads in undirected graphs from the text file and prints out 1 cycle in the graph
or "Acyclic" if the graph is acyclic

Input format:
    Number of nodes in the graph, followed by a list of edges describing connections between 2 nodes (1 based)
    1 <= j <= num_nodes, 1 <= k <= num_nodes, j != k
    num_nodes (node_1, node_2) (node_3, node_4) ... (node_j, node_k)

Ex:
Input:
    4 (1,2) (2,3) (1,4)

    Describes a graph of 4 nodes, where nodes 1 and 2 are connected,
    2 and 3 are connected, and 1 and 4 are connected.

Output format:
    Graph 1
    connected_components_of_graph_1
    cycle_detected_in_graph_1
        .
        .
        .
    Graph n
    connected_components_of_graph_n
    cycle_detected_in_graph_n

Ex:
    Input:
        5 (1,2) (3,4) (3,5) (4,5) (1,3)
        4 (1,2) (2,3) (1,4)

    Output:
        Graph 1
        {2,5,4,3,1} 
        Cycle: 3-5-4-3

        Graph 2
        {3,2,4,1} 
        Acyclic

Compile Edge.java, Graph.java, Prog1.java, and UndirectedGraph.java
Run Prog1 with "test.txt" as the run arguments
