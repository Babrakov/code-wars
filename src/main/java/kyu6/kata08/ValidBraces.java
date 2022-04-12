package main.java.kyu6.kata08;

/*
Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

Examples
"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False
 */

import java.util.Stack;

public class ValidBraces {

    public boolean myIsValid(String braces) {
        int len = braces.length();
        for(int i=0;i<len/2;i++) {
            braces = braces.replaceAll("\\(\\)", "");
            braces = braces.replaceAll("\\[\\]", "");
            braces = braces.replaceAll("\\{\\}", "");
            if(braces.length() == 0)
                return true;
        }
        return false;
    }

    public boolean isValid(String braces) {
        Stack<Character> s = new Stack<>();
        for (char c : braces.toCharArray())
            if (s.size() > 0 && isClosing(s.peek(), c)) s.pop();
            else s.push(c);
        return s.size() == 0;
    }

    public boolean isClosing(char x, char c) {
        return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
    }
}
