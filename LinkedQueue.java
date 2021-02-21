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
class LinkedQueueNode<T> {

    private T value;

    private LinkedQueueNode<T> next;

    public LinkedQueueNode(T element) {

        this.value = element;
    }

    public void setNext(LinkedQueueNode<T> node) {
        this.next = node;
    }

    public LinkedQueueNode<T> getNext() {
        return this.next;

    }

    public T getValue() {
        return value;
    }
}

public class LinkedQueue<T> {

    LinkedQueueNode<T> front;
    LinkedQueueNode<T> rear;
    int length;

    public LinkedQueue() {
        this.length = 0;
    }

    public T enqueue(T element) {
        LinkedQueueNode<T> newNode = new LinkedQueueNode<>(element);

        // this is a special case in which the queue is empty
        if (isEmpty()) {
            front = rear = newNode;
            length++;
            return element;
        }

        // the normal case
        rear.setNext(newNode);
        rear = newNode;
        length++;
        return element;

    }

    public T dequeue() {

        checkIfEmpty();
        LinkedQueueNode<T> previousFront = front;
        front = previousFront.getNext();
        length--;
        return previousFront.getValue();
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new Error("the Queue is empty");
        }
    }

    public int search(T element) {

        checkIfEmpty();

        int position = -1;
        boolean isFound = false;

        LinkedQueueNode<T> currentItem = front;

        for (int i = 0; i < length; i++) {
            position++;

            if (currentItem.getValue() == element) {
                isFound = true;
                break;
            }

            currentItem = currentItem.getNext();

        }

        return isFound ? position : -1;
    }

    @Override
    public String toString() {

        String output = " ";

        LinkedQueueNode<T> current = front;
        for (int i = 0; i < length; i++) {
            output += current.getValue() + " | ";
            current = current.getNext();

        }

        return output;

    }
}
