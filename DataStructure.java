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
class CharNode {

    char value;

    public CharNode() {
        this(' ');
    }

    public CharNode(char value) {
        this.value = value;
    }

}

public class DataStructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String myPattern = "{{}}(())[[]]{";
        System.out.println("is Matched = : " + isBalanced(myPattern));
    }

    public static boolean isMatched(char open, char close) {

        if (open == '(' && close == ')') {
            return true;
        }
        if (open == '{' && close == '}') {
            return true;
        }
        if (open == '[' && close == ']') {
            return true;
        }

        return false;
    }

    public static boolean isBalanced(String pattern) {

        LinkedStack<CharNode> parantheseStack = new LinkedStack<>();
        for (int i = 0; i < pattern.length(); i++) {

            if (pattern.charAt((i)) == '(' || pattern.charAt((i)) == '{' || pattern.charAt((i)) == '[') {

                parantheseStack.push(new CharNode(pattern.charAt(i)));

            } else if (pattern.charAt((i)) == ')' || pattern.charAt((i)) == '}' || pattern.charAt((i)) == ']') {

                if ( parantheseStack.isEmpty() || !isMatched(parantheseStack.peek().value, pattern.charAt(i))  ) {
                    return false;

                } else {
                    parantheseStack.pop();
                }
            }

        }

        if (parantheseStack.isEmpty()) {
            return true;

        }
        return false;

    }

}
