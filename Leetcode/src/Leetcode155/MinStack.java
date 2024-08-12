package Leetcode155;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> minStack = new ArrayDeque<>();
    Deque<Integer> minStackCheck = new ArrayDeque<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        if (minStack.isEmpty()){
            min=val;
        }else {
            min=minStackCheck.getLast();
            min=Math.min(val,min);
        }
        minStack.addLast(val);
        minStackCheck.addLast(min);
    }

    public void pop() {
        minStack.removeLast();
        minStackCheck.removeLast();
    }

    public int top() {
        return minStack.getLast();
    }

    public int getMin() {
        System.out.println(minStack);
        System.out.println(minStackCheck);
        return minStackCheck.getLast();
    }
}
