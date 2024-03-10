package romano.ds;

/**
 * A sequence of values of type {@code T}
 */
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
    }

    public LinkedList(T initialValue) {
        head = tail = new Node<>(initialValue, null);
        size++;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        Node<T> temp = head;
        while (temp != null) {
            str.append(temp.value).append(" -> ");
            temp = temp.next;
        }

        return str.length() == 0 ? "[ ]" : str.delete(str.length() - 4, str.length()).toString(); // We must remove the last ->
    }

    public int size() {
        return size;
    }

    public static class Node<T> {

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        private final T value;
        private Node<T> next;
    }
}
