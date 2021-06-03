import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode
    {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data)
        {
            this.data = data;
        }
    }

    // Constructor of DoublyLinkedList class
    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty()
    {
        return length == 0 || head == null;
    }

    // Insert the First Node
    public void insertFirst(int value)
    {
        ListNode newNode = new ListNode(value);
        if (isEmpty())
        {
            tail = newNode;
        }
        else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // Insert Node at the End
    public void insertLast(int value)
    {
        ListNode newNode = new ListNode(value);
        if (isEmpty())
        {
            head = newNode;
        }
        else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    // Display Nodes in Forward Order
    public void displayForward()
    {
        if (head == null)
        {
            return;
        }
        ListNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display Nodes in Backward order
    public void displayBackward()
    {
        if (head == null)
        {
            return;
        }
        ListNode temp = tail;
        while(temp != null)
        {
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // Delete the First Node
    public ListNode deleteFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if (head == tail)
        {
            tail = null;
        }
        else{
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    // Delete the Last Node
    public ListNode deleteLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if (head == tail)
        {
            head = null;
        }
        else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(10);
        dll.insertFirst(20);
        dll.insertFirst(30);
        dll.insertFirst(40);

        dll.insertLast(50);
        dll.insertLast(60);
        dll.insertLast(70);
        dll.insertLast(80);

        dll.deleteFirst();
        dll.deleteFirst();

        dll.deleteLast();
        dll.deleteLast();

        dll.displayForward();
        dll.displayBackward();

        System.out.println("The Length is " + dll.length);

    }
}
