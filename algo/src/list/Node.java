package list;

/**
 * @author kinden
 */
public class Node {

    private int var;

    private Node next;

    public Node(int var) {
        this.var = var;
        this.next = null;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
