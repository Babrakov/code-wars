package main.java.kyu5.kata01;

/*
Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
It is much easier to understand with an example:

* For seconds = 62, your function should return
    "1 minute and 2 seconds"
* For seconds = 3662, your function should return
    "1 hour, 1 minute and 2 seconds"
For the purpose of this Kata, a year is 365 days and a day is 24 hours.

Note that spaces are important.

Detailed rules
The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.
A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TimeFormatter {

    public static void main(String[] args) {
        System.out.println(formatDuration(5323000));
    }

    public static final int inYear = 31536000;
    public static final int inDay = 86400;
    public static final int inHour = 3600;
    public static final int inMinute = 60;

    public static String formatDuration(int seconds) {
        System.out.println(seconds);
        var list = new ArrayList<String>();
        if (seconds==0) return "now";
        int years = seconds/inYear;
        int days = (seconds-(years*inYear))/inDay;
        int hours = (seconds-(years*inYear)-(days*inDay))/inHour;
        int minutes = (seconds-(years*inYear)-(days*inDay)-(hours*inHour))/inMinute;
        int secs = seconds%inMinute;

        addToList(years,"year", list);
        addToList(days,"day", list);
        addToList(hours,"hour", list);
        addToList(minutes,"minute", list);
        addToList(secs,"second", list);

        if (list.size()>1) {
            String last = list.get(list.size()-1);
            list.remove(last);
            return list.stream().collect(Collectors.joining(", ")) + " and " + last;
        } else {
            return list.get(0);
        }

    }

    public static void addToList(int num, String name, List<String> list){
        String current = "";
        if (num>0) {
            current = (num == 1) ? "1 " + name : num + " " + name + "s";
            list.add(current);
        }
    }

    public static String bestFormatDuration(int seconds) {
        return seconds == 0 ? "now" :
                Arrays.stream(
                                new String[]{
                                        formatTime("year",  (seconds / 31536000)),
                                        formatTime("day",   (seconds / 86400)%365),
                                        formatTime("hour",  (seconds / 3600)%24),
                                        formatTime("minute",(seconds / 60)%60),
                                        formatTime("second",(seconds%3600)%60)})
                        .filter(e->e!="")
                        .collect(Collectors.joining(", "))
                        .replaceAll(", (?!.+,)", " and ");
    }

    public static String formatTime(String s, int time){
        return time==0 ? "" : Integer.toString(time)+ " " + s + (time==1?"" : "s");
    }

}
