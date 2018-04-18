import java.util.*;

public class Dijkstras {
  private static class Vertex {
    private int index;
    private boolean visited;
    private int pathLength;
    private Vertex previous;

    public Vertex(int i) {
      index = i;
      visited = false;
      pathLength = 2147483647;
      previous = null;
    }

    public int getIndex() { return index; }
    public boolean checkVisited() { return visited; }
    public void beenVisited() { visited = true; }
    public int getPath() { return pathLength; }
    public void setPath(int d) { pathLength = d; }
    public Vertex getPrevious() { return previous; }
    public void setPrevious(Vertex p) { previous = p; }
    public void buildPath(Vertex v, String p) {
      if (v.getPrevious() == null) {
        p = Integer.toString(v.getIndex()) + "-" + p;
        System.out.print(p);
      } else {
        p = Integer.toString(v.getIndex()) + "-" + p;
        buildPath(v.getPrevious(), p);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    java.io.File file = new java.io.File(args[0]);
    try (
      Scanner input = new Scanner(file);
    ) {
      int n = input.nextInt();
      input.nextLine();

      MyArrayList<LinkedList<Integer>> G = new MyArrayList<LinkedList<Integer>>(n+1);
      G.insert(0, null);

      for (int i=1; i <= n; i++) {
        Scanner buffer = new Scanner(input.nextLine());
        int name = buffer.nextInt();
        LinkedList<Integer> node = new LinkedList<Integer>();

        if (buffer.hasNext()) {
          int vertex = buffer.nextInt();
          int weight = buffer.nextInt();
          node.insertAtHead(vertex, weight);
        }
        while (buffer.hasNext()) {
          int vertex = buffer.nextInt();
          int weight = buffer.nextInt();

          node.insertAtTail(vertex, weight);
          continue;
        }

        G.insert(name, node);
        buffer.close();
      }

      input.close();


      MyArrayList<Vertex> listOfPaths = shortestPath(G, 1);

      String vertexPath;
      for (int j=1; j < listOfPaths.size(); j++) {
        vertexPath = "";
        System.out.print("Shortest path to " + j + ": ");
        if (j > 1) {
          listOfPaths.get(j).getPrevious().buildPath(listOfPaths.get(j).getPrevious(), vertexPath);
        }
        System.out.println(j+ "; Distance: " +listOfPaths.get(j).getPath());
      }
    }
    catch (Exception e) {
      System.out.println("Error: file " +args[0]+ " cannot be found.");
    }
  }

  private static MyArrayList<Vertex> shortestPath(MyArrayList<LinkedList<Integer>> graph, int s) {
    MyArrayList<Vertex> vSet = new MyArrayList<Vertex>(graph.size());
    vSet.insert(0, null);
    MinHeap<Integer,Vertex> Q = new MinHeap<Integer,Vertex>(graph.size());

    for (int i=1; i < graph.size(); i++) {
      Vertex v = new Vertex(i);
      vSet.insert(i, v);
      Q.insert(v.getPath(), v);
      System.out.println("Inserting: " +i);
    }

    Vertex source = vSet.get(s);
    source.setPath(0);
    Q.changeKey(source, source.getPath());
    MyArrayList<Vertex> Vt = new MyArrayList<Vertex>(graph.size());
    Vt.insert(0, null);

    for (int i=0; i < graph.size() - 1; i++) {
      Vertex uStar = Q.removeMin();
      System.out.println("Deleting: " +uStar.getIndex());
      Vt.insert(uStar.getIndex(), uStar);
      uStar.beenVisited();

      for (int j=1; j < graph.size(); j++) {
        if (graph.get(uStar.getIndex()).search(j)) {
          Vertex u = vSet.get(j);
          int possiblePath = uStar.getPath() + (int)(graph.get(uStar.getIndex()).getWeight(u.getIndex()));

          if (possiblePath < u.getPath()) {
            u.setPath(possiblePath);
            u.setPrevious(uStar);
            Q.changeKey(u, u.getPath());
            System.out.println("Updating the distance (key/priority) of " +u.getIndex()+ " in the min-heap");
          }
        }
      }
    }

    return Vt;
  }
}
