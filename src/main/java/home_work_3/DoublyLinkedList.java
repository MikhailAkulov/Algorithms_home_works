package home_work_3;

public class DoublyLinkedList {

    private DoublyNode head;
    private DoublyNode tail;

    public DoublyNode getHead() {
        return head;
    }

    public DoublyNode getTail() {
        return tail;
    }

    public void addLast(int value) {
        DoublyNode node = new DoublyNode(value);
        if (head == null) {
            head = node;
        }
        else {
            DoublyNode last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    public void reverse() {
        if (head != null && head.getNext() != null) {
            DoublyNode temp = head;
            reverse(head.getNext(), head);
            temp.setNext(null);
            tail = temp;
        }
    }

    private void reverse(DoublyNode currentNode, DoublyNode previousNode) {
        if (currentNode.getNext() != null) {
            reverse(currentNode.getNext(), currentNode);
        }
        else {
            head = currentNode;
        }
        currentNode.setNext(previousNode);
        previousNode.setPrevious(currentNode);
    }

    public void addFirst(int value) {
        DoublyNode node = new DoublyNode(value);
        if (head != null) {
            node.setNext(head);
            head.setPrevious(node);
            //head = node;
        }
        else {
            //head = node;
            tail = node;
        }
        head = node;
    }

    public void removeFirst(int value) {
        if (head != null && head.getNext() != null) {
            head.getNext().setPrevious(null);
            head = head.getNext();
        }
        else {
            head = null;
            tail = null;
        }
    }
}
