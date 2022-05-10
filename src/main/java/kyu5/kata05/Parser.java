package main.java.kyu5.kata05;

/*
In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.

Examples:

"one" => 1
"twenty" => 20
"two hundred forty-six" => 246
"seven hundred eighty-three thousand nine hundred and nineteen" => 783919
Additional Notes:

The minimum number is "zero" (inclusively)
The maximum number, which must be supported is 1 million (inclusively)
The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it"s present and in others it"s not
All tested numbers are valid, you don"t need to validate them
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    static Map<String,Integer> numbersMap = new HashMap<>() {{
        put("zero", 0);
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
        put("ten", 10);
        put("eleven", 11);
        put("twelve", 12);
        put("thirteen", 13);
        put("fourteen", 14);
        put("fifteen", 15);
        put("sixteen", 16);
        put("seventeen", 17);
        put("eighteen", 18);
        put("nineteen", 19);
        put("twenty", 20);
        put("thirty", 30);
        put("forty", 40);
        put("fifty", 50);
        put("sixty", 60);
        put("seventy", 70);
        put("eighty", 80);
        put("ninety", 90);
        put("hundred", 100);
        put("thousand", 1000);
        put("million", 1000000);
    }};
    public static int parseInt(String numStr) {
        System.out.println(numStr);
        String[] numbers = numStr.split(" ");
        numbers = Arrays.stream(numbers).filter(v -> !v.equals("and")).toArray(String[]::new);
        return numbers.length == 1 ? getSimpleNumber(numbers[0]) : getComplexNumber(numbers);
    }

    public static Integer getSimpleNumber (String number) {
        return numbersMap.containsKey(number)
                ? numbersMap.get(number)
                : Arrays.stream(number.split("-"))
                    .map(v -> numbersMap.get(v))
                    .reduce(0, (a, b) -> a + b);
    }

    public static Integer getComplexNumber (String[] numbers) {
        Integer res = 0;
        String[] decs = {"hundred", "thousand", "million"};
        for(int i = 0, length = numbers.length; i < length;) {
            if ((i + 1)<length && numbers[i + 1].equals("hundred") && (
                ((i + 3)<length && Arrays.asList(decs).contains(numbers[i + 3]))
                ||
                ((i + 2)<length && Arrays.asList(decs).contains(numbers[i + 2]))
            )) {
                String value;
                if ((i + 3)<length && Arrays.asList(decs).contains(numbers[i + 3])) value = numbers[i + 3];
                else value = numbers[i + 2];
                if (value.equals("thousand")) {
                    res += getSimpleNumber(numbers[i]) * numbersMap.get("thousand") * numbersMap.get("hundred");
                } else {
                    res += getSimpleNumber(numbers[i]);
                    res = res * numbersMap.get(numbers[i + 1]);
                }
                if ((i + 2)<length && Arrays.asList(decs).contains(numbers[i + 2])) i += 3;
                else i += 2;
                continue;
            } else if ((i + 1)<length && Arrays.asList(decs).contains(numbers[i + 1])){
                res += getSimpleNumber(numbers[i]) * numbersMap.get(numbers[i + 1]);
                i += 2;
                continue;
            } else {
                res += getSimpleNumber(numbers[i]);
            }
            i += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(parseInt("seven hundred thousand three"));
    }

    public static int bestParseInt(String numStr) {
        String[] numArray = numStr.split("[ |-]");
        int number = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);

        for (int i = 0; i < numArray.length; i++) {
            for (String key : map.keySet()) {
                if (numArray[i].toLowerCase().equals(key)) {
                    if (map.get(key) == 100) {
                        int temp = number % 100;
                        number -= temp;
                        number += temp * (map.get(key));
                    }
                    else if (map.get(key) > 100)
                        number *= (map.get(key));
                    else
                        number += map.get(key);
                    break;
                }
            }
        }
        return number;
    }


}
