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

class StackNode {
     int value;
    StackNode next;
    public StackNode(int number, StackNode next){
        this.value = number;
        this.next = next;
    }
   
    
}
public class LinkedStack {
    StackNode top = null;
    int numberOfItems =0;
    
    
    public void push(int number) {
     StackNode item = new StackNode(number,top);
     top  = item;
     numberOfItems++;
     
    }
    public int  pop(){
        if(isEmpty()){
           return throw new Error("the stack doesn't contain any  elements");
        }else{
            int value = top.value;
            top = top.next;
            numberOfItems--;
            return value;
        }
       
    }
    
    public int peek(){
     return top.value;
    }
    
    public boolean isEmpty(){
        return numberOfItems>0;
    }
    
}