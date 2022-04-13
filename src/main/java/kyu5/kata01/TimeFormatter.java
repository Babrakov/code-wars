package main.java.kyu5.kata01;

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
