package com.dsa.leetcodePractice.easy.mergeSortedLists;

/*
 * Class to provide the solution to merge two sorted lists (single linked list)
 * @author Amol Binwade 
 */
		
		

public class SolutionForMergeSortedLists {

	public static void main(String[] args) {

		// create list-1 [1, 3, 4]
		
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3, n1);
		ListNode n3 = new ListNode(1, n2);
		
		//create list-2 [1, 2, 4]
		
		ListNode ln1 = new ListNode(4);
		ListNode ln2 = new ListNode(2, ln1);
		ListNode ln3 = new ListNode(1, ln2);

		//Initiate this class and call methods to merge sorted lists
		
		SolutionForMergeSortedLists solution = new SolutionForMergeSortedLists();
		ListNode head = solution.mergeTwoLists(ln3, n3);

		//Print merged list to validate solution
		
		ListNode itr = head;
		while (itr != null) {
			System.out.println(itr.val);
			itr = itr.next;
		}

	}

	/*
	 * logic to merge to sorted lists in sorted order 
	 * Steps:
	 * 1. Declare a head node and current node. Head to hold the head node of merged list. Current to maintain tail of merged list to keep adding elements.
	 * 2. Compare element in list1 to element in list2 and add small element to merged list/
	 * 3.  move pointer of list from which smaller element selected to next.
	 * 
	 */
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		//Create new ListNode to act as head
		
		ListNode head = new ListNode(-1, null);
		
		//create ListNode variable to act as a current pointer
		
		ListNode current = head;
		
		//loop till either list has some elements
		
		while (list1 != null || list2 != null) {
			
			//if list1 node is empty, then add list2 node to merged list and move list2 pointer to next
			
			if (list1 == null) {
				current.next = list2;
				list2 = list2.next;
			} else if (list2 == null) {					// if list2 node is null, then add list1 to merged list and move list1 pointer to next
				current.next = list1;
				list1 = list1.next;
			} else if (list1.val <= list2.val) {		// if list1 <= list2, add list1 to merged list and move list1 pointer to next
				current.next = list1;
				list1 = list1.next;
			} else {									//if list2 >= list1, add list2 to merged list and move list2 pointer to neext
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;						// move current pointer to next
		}
		
		
		
		return head.next;								// return head.next which is starting element of sorted list
	}

	
	

}

/***Definition for singly-linked list.*/

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
