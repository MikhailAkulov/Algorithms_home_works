package home_work_3;

public class App {
    public static void main(String[] args) {

        SinglyLinkedList singleLinkedList = new SinglyLinkedList();

        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);

        System.out.println("Первоначальный однонаправленный список: ");
        print(singleLinkedList);
        singleLinkedList.reverse();
        System.out.println("Развернутый однонаправленный список: ");
        print(singleLinkedList);

        System.out.println();

        DoublyLinkedList doubleLinkedList = new DoublyLinkedList();

        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(7);
        doubleLinkedList.addLast(8);
        doubleLinkedList.addLast(9);
        doubleLinkedList.addLast(10);

        System.out.println("Первоначальный двунаправленный список: ");
        print(doubleLinkedList);
        doubleLinkedList.reverse();
        System.out.println("Развернутый двунаправленный список: ");
        print(doubleLinkedList);
    }

    public static void print(SinglyLinkedList myLinkedList) {
        SinglyNode singlyNode = myLinkedList.getHead();
        while (singlyNode != null) {
            System.out.print(singlyNode + " ");
            singlyNode = singlyNode.getNext();
        }
        System.out.println('\n' + "----------");
    }

    public static void print(DoublyLinkedList myLinkedList) {
        DoublyNode doublyNode = myLinkedList.getHead();
        while (doublyNode != null) {
            System.out.print(doublyNode + " ");
            doublyNode = doublyNode.getNext();
        }
        System.out.println('\n' + "----------");
    }
}
