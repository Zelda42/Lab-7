class Main {
  public static void main(String[] args) {
    // list vertices representing buildings
    String[] vertices = {
      "Liberal Arts", 
      "Student Services", 
      "Health Careers & Sciences", 
      "Health Technologies Center", 
      "Recreation Center", 
      "Technology Learning Center", 
      "Business & Technology", 
      "Theatre"
    };

    // Edges based on connections between buildings
    int[][] edges = {
    {0, 7}, // Liberal Arts -> Theatre
    {0, 1}, // Liberal Arts -> Student Services
    {1, 5}, // Student Services -> Technology Learning
    {1, 2}, // Student Services -> Health Careers
    {2, 3}, // Health Careers -> Health Technologies
    {2, 4}, // Health Careers -> Recreation Center
    {4, 1}, // Recreation Center -> Student Services
    {6, 7}, // Business & Technology -> Theatre
    {6, 1}  // Business & Technology -> Student Services
};

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this is you called it something different in your vertices!

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));

    // call printPath() to display paths from Business & Technology
    System.out.println("\nPath from Business & Technology to Health Technologies Center:");
    dfs.printPath(graph.getIndex("Health Technologies Center"));
    
    System.out.println("\nPath from Business & Technology to Student Services:");
    dfs.printPath(graph.getIndex("Student Services"));
    
    System.out.println("\nPath from Business & Technology to Recreation Center:");
    dfs.printPath(graph.getIndex("Recreation Center"));

    // print entire DFS tree
    System.out.println("\nEntire DFS Tree:");
    dfs.printTree();      

    
  }
}