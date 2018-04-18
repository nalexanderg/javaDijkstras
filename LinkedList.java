public class LinkedList<T extends Comparable<T>> {
  private static class Node<T> {
    private T vertex;
    private T edge;
    private Node<T> next;

    public Node(T v, T e, Node<T> n) {
      vertex = v;
      edge = e;
      next = n;
    }

    public T getVertex() { return vertex; }
    public T getEdge() { return edge; }
    public Node<T> getNext() { return next; }
    public void setNext(Node<T> n) { next = n; }
    // public boolean equals(T v) { vertex.equals(v); }
  }

  private int size;

  private Node<T> head, tail;

  public LinkedList() {
    size = 0;
    head = null;
    tail = null;
  }

  public LinkedList(T v, T e) {
    this();
    insertAtHead(v, e);
  }

  public int size() { return size; }

  public boolean isEmpty() { return (size == 0); }

  public void insertAtHead(T v, T e) {
    Node<T> newNode = new Node<>(v, e, head);
    if (isEmpty()) {
      tail = newNode;
    }
    head = newNode;
    size++;
  }

  public void insertAtTail(T v, T e) {
    Node<T> newNode = new Node<>(v, e, null);
    if (isEmpty()) {
      head = newNode;
    } else {
      tail.setNext(newNode);
    }
    tail = newNode;
    size++;
  }

  public boolean removeAtHead() {
    if (isEmpty()) {
      return false;
    }
    if (size == 1) {
      head = null;
      tail = null;
    } else {
      head = head.getNext();
    }
    size--;
    return true;
  }

  public boolean search(T v) {
    Node<T> node = head;
    for (int i=0; i < size(); i++) {
      if (node.getVertex().equals(v)) {
        return true;
      }
      node = node.getNext();
    }
    return false;
  }

  public T getWeight(T v) {
    Node<T> node = head;
    for (int i=0; i < size(); i++) {
      if (node.getVertex().equals(v)) {
        return node.getEdge();
      }
      node = node.getNext();
    }
    return null;
  }
}
