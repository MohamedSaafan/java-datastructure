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
//        String myPattern = "{{}}(())[[]]{";
//        System.out.println("is Matched = : " + isBalanced(myPattern
        String infixExpression = "2*2+8";
        System.out.println(toPostFix(infixExpression));
    }
    
    
    public static String toPostFix(String infixExperission){
        LinkedStack<CharNode> operandsStack = new LinkedStack<>();
        String postFixExpression = "";
        for (int i = 0; i<infixExperission.length(); i++){
            if(isOperand(infixExperission.charAt(i))){
                if(operandsStack.isEmpty()){
                    operandsStack.push(new CharNode(infixExperission.charAt(i)));
                } else if(isOperatorGreaterThanTheOther(operandsStack.peek().value,infixExperission.charAt(i))){

                    postFixExpression += operandsStack.pop().value;
                    operandsStack.push(new CharNode(infixExperission.charAt(i)));
                  }else{
                    
                    operandsStack.push(new CharNode(infixExperission.charAt(i)));
                }
            }else{
                postFixExpression += infixExperission.charAt(i);
            }
          
          
        }

        for(int i = 0 ; i<operandsStack.length;i++){
            postFixExpression += operandsStack.pop().value;
        }
        
        return postFixExpression;
        
    }
    public static boolean isOperatorGreaterThanTheOther(char operator1,char operator2){
        return getPerisidenceValue(operator1)> getPerisidenceValue(operator2);
    }
    public static boolean isOperand(char character){
        if(character == '+' || character == '-'|| character == '*' || character == '/')
            return true;
        return false;
    }
    
    
    public static int getPerisidenceValue (char operator){
        if(operator == '+' || operator =='-'){
            return 1;
        }
        if(operator == '*' || operator == '/'){
            return 2;
        }
        return 0;
        
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
