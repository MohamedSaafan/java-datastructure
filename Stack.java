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
    private int top = 0 ;
    public Stack(){
        this(100);
    }
    public Stack(int numberOfElement) {
        stack = new int[numberOfElement];
        
    }
    public void push (int i){

        stack[top++] = i;
    }
    public  int pop(){
    

        return stack[top-- -1];
    }
    public int peek(){
        return stack[top -1 ];
    }
    public boolean isEmpty(){
        return top ==0;
    }
    public int [] getStack(){
        return stack;
    }

}
