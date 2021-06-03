import java.util.List;
import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    // Constructor of CircularLinkedList class
    public CircularLinkedList()
    {
        last = null;
        length = 0;
    }

    public int length()
    {
        return length;
    }

    public boolean isEmpty()
    {
        return length == 0;
    }

    public void createCircularLinkedList()
    {
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        last = fourth; // Fourth is not equal to null in CircularLinkedList
    }

    // Displaying the Nodes
    public void display()
    {
        if (last == null)
        {
            return;
        }
        ListNode first = last.next;
        while (first.next != last)
        {
            System.out.println(first.data + "-->");
            first = first.next;
        }
        System.out.println(first.data);
    }

    // Insert the First Node
    public void insertFirst(int data)
    {
        ListNode temp = new ListNode(data);
        if (last == null)
        {
            last = temp;
        }
        else
        {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    // Insert the Last Node
    public void insertLast(int data)
    {
        ListNode temp = new ListNode(data);
        if (last == null)
        {
            last = temp; // Empty / once
            last.next = last; // Empty / Once
        }
        else
        {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    // Delete the First Node
    public ListNode deleteFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if (last.next == last)
        {
            last = null;
        }
        else
        {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }


    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();

        cll.insertFirst(100);
        cll.insertFirst(200);

        cll.insertLast(300);
        cll.insertLast(400);

        cll.deleteFirst();
        cll.deleteFirst();

        cll.display();

    }
}
