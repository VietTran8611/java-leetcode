package session2_q4;


import java.util.Arrays;
import java.util.Collections;

public class vtran86_session2_q4 {

    public class ListNode {
        int data;
        ListNode next;
        ListNode(int d) {
            data = d; next = null;
        }
    }

    ListNode head ;
    public static void main(String[] args) {
        vtran86_session2_q4 linkedList = new vtran86_session2_q4();
        Integer[] in = {1,2,2,1,2,0,2,2};
        linkedList.SortedLinkedList(in);
        //output:
//        Original Linked List: 1 2 2 1 2 0 2 2
//        Sorted Linked List: 0 1 1 2 2 2 2 2
    }

    public  void SortedLinkedList(Integer[] data){
        Collections.reverse(Arrays.asList(data));

        //push data in the list
        for (int i=0;i<data.length;i++){
            ListNode newNode= new ListNode(data[i]);
            newNode.next=head;
            head = newNode;
        }

        int[] count = {0,0,0};
        ListNode temp = head;

        //print original list
        System.out.print("Original Linked List: ");
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

        //count the number of 0,1,2 in the list
        temp = head;
        while (temp != null){
            count[temp.data]++;
            temp= temp.next;
        }

        //sort the list and print it out
        System.out.print("Sorted Linked List: ");
        temp=head;
        while (temp != null){
            if (count[0]>0){
                temp.data=0;
                count[0]--;
            }else {
                if (count[1]>0){
                    temp.data=1;
                    count[1]--;
                }else {
                    temp.data=2;
                    count[2]--;
                }
            }
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
        System.out.println();
    }

}
