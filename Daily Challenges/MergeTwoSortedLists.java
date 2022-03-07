/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


METHOD:(USING TWO POINTER)

TIME: O(L1 + L2), where L1 and L2 is the length of list1 and list2.

SPACE: O(1).
*/


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     
        if(list1 == null) return list2;
        
        if(list2 == null) return list1;
        
        ListNode dummyHead = new ListNode(-101);
        ListNode prev = dummyHead;
        
        while(list1 != null && list2 != null){
            
            if(list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }
            else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        
        prev.next = list1 != null ? list1 : list2;
        
        return dummyHead.next;
    }
}