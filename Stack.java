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
class Stack{
    private int [] stack;
    private int top = -1 ;

    public Stack(){
        this(100);
    }

    public Stack(int numberOfElement) {
        stack = new int[numberOfElement];
    }

    public void push (int element){
        stack[++top] = element;
    }

    public  int pop(){

        if(!this.isEmpty()){
            throw new Error("the Stack doesn't contain any elements");
        }
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return top >=0;
    }

    public int [] getStack(){
        return stack;
    }

}
