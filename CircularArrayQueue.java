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
class CircularQueueNode<T> {

    private T value;

    public CircularQueueNode(T val) {
        this.value = val;
    }

    public T getValue() {
        return this.value;
    }

}

public class CircularQueue<T> {

    CircularQueueNode<T>[] queue;
    private int front;
    private int rear;
    // don't forget to maintain that size
    private int maxSize;
    private int size;

    public CircularQueue() {
        this(10);
    }

    public CircularQueue(int n) {
        queue = new CircularQueueNode[n];
        rear = n - 1;
        front = 0;
        maxSize = n;
        size = 0;
    }

    public T enqueue(T item) {

        if (isFull()) {
            // create new array and move the items into it
            CircularQueueNode<T>[] newQueue = new CircularQueueNode[maxSize * 2];

            for (int i = 0; i < maxSize; i++) {

                newQueue[i] = new CircularQueueNode(dequeue());

            }
            queue = newQueue;
            front = 0;
            rear = maxSize - 1;
            size = maxSize;
            maxSize = maxSize * 2;

        }

        CircularQueueNode<T> queueNode = new CircularQueueNode<>(item);

        rear = (rear + 1) % maxSize;
        queue[rear] = queueNode;
        size++;

        return item;
    }

    public T dequeue() {

        if (isEmpty()) {
            throw new Error("Queue is empty");
        }

        T item = queue[front].getValue();

        front = (front + 1) % maxSize;
        size--;
        return item;

    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int length() {
        return this.size;
    }

    @Override
    public String toString() {
        String output = " ";

        int iterator = front;

        do {

            output += queue[iterator].getValue() + " | ";

            iterator = (iterator + 1) % maxSize;

        } while (iterator != front);

        return output;

    }

}
