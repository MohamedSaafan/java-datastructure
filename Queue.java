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
class QueueNode<T> {

    private T value;

    public QueueNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

}

public class Queue<T> {

    QueueNode<T>[] queue;
    int back;
    int size;

    public Queue() {
        this(10);
    }

    public Queue(int n) {
        this.queue = new QueueNode[n];
    }

    public T enqueue(T item) {
        if (size == queue.length) {
            // duplicate the array and 
            QueueNode<T>[] newQueue = new QueueNode[size * 2];
            for (int i = 0; i < size; i++) {
                newQueue[i] = queue[i];

            }
            queue = newQueue;
        }
        QueueNode<T> newNode = new QueueNode(item);
        queue[back++] = newNode;
        size++;
        return item;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new Error("Queue is empty");
        }
        T front = queue[0].getValue();
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];

        }
        back--;

        return front;

    }

    public boolean isEmpty() {
        return back <= 0;
    }
}
