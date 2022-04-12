package main.java.kyu6.kata09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.

Example:

Given an input string of:

apples, pears # and bananas
grapes
bananas !apples
The output expected would be:

apples, pears
grapes
bananas
The code would be called like so:

var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"
 */

public class StripComments {

    public static void main(String[] args) {
        System.out.println(stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } ));
    }

    public static String myStripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\\n");

        List<String> result = new ArrayList<>();
        for (String line:lines) {
            char[] arr = line.toCharArray();
            List<String> newLine = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (Arrays.asList(commentSymbols).contains(String.valueOf(arr[i]))) {
                    break;
                }
                newLine.add(String.valueOf(arr[i]));
            }
            result.add(String.join("",newLine).replaceAll("\\s+$", ""));
        }

        return String.join("\n",result);
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String pattern = String.format(
                "[ ]*([%s].*)?$",
                Arrays.stream( commentSymbols ).collect( Collectors.joining() )
        );
        return Arrays.stream( text.split( "\n" ) )
                .map( x -> x.replaceAll( pattern, "" ) )
                .collect( Collectors.joining( "\n" ) );
    }

}
