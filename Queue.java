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

    public Queue(int n) {
        this.queue = new QueueNode[n];
    }

    public QueueNode enqueue(QueueNode item) {
        queue[back++] = item;
        size++;
        return item;
    }

    public QueueNode dequeue() {
        QueueNode front = queue[0];

        for (int i = 0; i <= size; i++) {
            queue[i] = queue[i - 1];

        }
        back--;
        return front;

    }

}
