package home_work_3;

public class SinglyLinkedList {

    private SinglyNode head; // Ссылка на первый элемент

    public SinglyNode getHead() {
        return head;
    }

    public void reverse(){
        if(head != null && head.getNext() != null){
            SinglyNode buf = head;
            reverse(head.getNext(), head);
            buf.setNext(null);
        }
    }
    private void reverse(SinglyNode currentSinglyNode, SinglyNode previousSinglyNode){
        if(currentSinglyNode.getNext() != null){
            reverse(currentSinglyNode.getNext(), currentSinglyNode);
        } else {
            head = currentSinglyNode;
        }
        currentSinglyNode.setNext(previousSinglyNode);
    }

    public void addFirst(int value){
        SinglyNode singlyNode = new SinglyNode(value);
        if (head != null)
            singlyNode.setNext(head);
        head = singlyNode;
    }

    public void removeFirst(){
        if (head != null)
            head = head.getNext();
    }


    public SinglyNode contains(int value){
        SinglyNode singlyNode = head;
        while (singlyNode != null){
            if (singlyNode.getValue() == value)
                return singlyNode;
            singlyNode = singlyNode.getNext();
        }
        return null;
    }

    public void addLast(int value){
        SinglyNode singlyNode = new SinglyNode(value);
        if (head == null){
            head = singlyNode;
        }
        else {
            SinglyNode last = head;
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(singlyNode);
        }
    }

    public void removeLast(){
        if (head == null)
            return;

        SinglyNode singlyNode = head;

        while (singlyNode.getNext() != null){
            if (singlyNode.getNext().getNext() == null)
            {
                singlyNode.setNext(null);
                return;
            }
            singlyNode = singlyNode.getNext();
        }
        head = null;
    }
}
