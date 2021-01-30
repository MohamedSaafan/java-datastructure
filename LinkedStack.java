/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author mohame_saafan
 */
class StackNode<T> {

    T value;
    StackNode next;

    public StackNode(T item, StackNode next) {
        this.value = item;
        this.next = next;
    }

}

public class LinkedStack<T> {

    StackNode<T> top = null;
    int length = 0;

    public void push(T item) {
        StackNode newItem = new StackNode<T>(item, top);
        top = newItem;
        length++;

    }

    public T pop() {
        if (isEmpty()) {
            System.out.println(length + ": from length");
            throw new Error("the stack doesn't contain any  elements");
        }
        T value = top.value;
        top = top.next;
        length--;
        return value;
    }

    public T peek() {
        return top.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }

}
