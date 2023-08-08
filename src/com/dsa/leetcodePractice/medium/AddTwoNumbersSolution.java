package com.dsa.leetcodePractice.medium;

public class AddTwoNumbersSolution {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = null;
        ListNode outputHead = null;
        int reminder = 0;
        while(!(l1 == null && l2 == null && reminder == 0)){
            int sum = getSum((l1==null?0:l1.val)+reminder, (l2==null?0:l2.val));
            ListNode node = new ListNode();
            node.val = getRightDigit(sum);
            reminder = getLeftDigit(sum);

            if(output != null){
                output.next = node;
            } else {
                outputHead = node;
            }
            output = node;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;

        }
        return outputHead;
    }


    private int getSum(int a, int b){
       return a+b;
    }

    private int getRightDigit(int a){
        if(a<10)
            return a;
        else {
            return a%10;
        }
    }

    private int getLeftDigit(int a) {
        if(a<10)
            return 0;
        else {
            return a/10;
        }
    }

}
