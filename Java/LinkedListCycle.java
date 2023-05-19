import java.util.Objects;
import java.lang.NullPointerException;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {

        // When we hit null next we are at end of list
        ListNode curr = head;
        Boolean flag = false;

        while (!flag) {

            try {
                // This should break when null leaving us to the catch block
                ListNode checker = curr.next;
            } 
            
            catch (NullPointerException e){
                break;
            }

            // We use pos inf as a 'visited tag'
            if (curr.val == -12343){
                return true;
            }

            else {
                curr.val = -12343;
                curr = curr.next;
            }

        }

        // Extra check for last node!
        //if (curr.val == -12343) {
        //    return true;
        //}

        return false;

    }
}