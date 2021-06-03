public class SinglyLinkedList {
    private ListNode head;
    private static class ListNode
    {
        private int data;
        private ListNode next;

        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // Displaying the Nodes
    public void display()
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Finding the Length of SinglyLinkedList
    public int length()
    {
        if (head == null)
        {
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Insert the First Node
    public void insertFirst(int value)
    {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //Insert the Last Node
    public void insertLast(int value)
    {
        ListNode newNode = new ListNode(value);
        if (head == null)
        {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete the First Node
    public ListNode deleteFirst()
    {
        if (head == null)
        {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return  temp;
    }

    // Delete the Last Node
    public ListNode deleteLast()
    {
        if (head == null || head.next == null)
        {
            return  head;
        }
        ListNode temp = head;
        ListNode previous = null;
        while (temp.next != null)
        {
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
        return temp;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.insertFirst(15);
        sll.insertFirst(20);

        sll.insertLast(40);
        sll.insertLast(50);

        sll.deleteFirst();
        sll.deleteFirst();

        sll.deleteLast();
        sll.deleteLast();

        sll.display();

        System.out.println("The Length is " + sll.length());
    }
}
