class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class mergesorted {
    public static ListNode mergeSortedEven(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (list1.val % 2 ==0) {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (list2.val % 2 == 0) {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            if (list1.val % 2 == 0) {
                current.next = list1;
                current = current.next;
            }
            list1 = list1.next;
        } 
        while (list2 != null) {
            if (list2.val % 2 == 0) {
                current.next = list2;
                current = current.next;
            }
            list2 = list2.next;
        }
        current.next = null;
        return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(6);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(8);
        list1.next.next.next = new ListNode(10);
        System.out.print("Merged Even List: ");
        printList(mergeSortedEven(list1, list2));
    }
}