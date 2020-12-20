package com.denisenko;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String input = "Present time - 2020/12/23 05:30 - valid, Present time - 2020/12/23 05:30 - valid";
        String input1 = "Present time - 2020/13/77 99:99 - invalid, Present time - 2020/13/77 99:99 - invalid";
        String input2 = "my mail is denisenko924@gmail.com la la la, my mail is denisenko924@gmail.com la la la";

        String regex1 = "\\d{4}/\\d[1-9]/[0-3][0-9]\\s\\d[0-59]:\\d[0-59]"; // формата даты "YYYY/MM/dd HH:mm"
        String regex2 = "@\\w{1,20}\\.\\w{1,10}\\w{1,10}?\\w{1,10}?";// домен почтового ящика

        System.out.println(input.matches(regex1));
        System.out.println(input1.matches(regex1));
        System.out.println(input2.matches(regex2));

        Pattern patern1 = Pattern.compile(regex1);
        Matcher dateOccurrence = patern1.matcher(input);
        System.out.println(dateOccurrence);

        while (dateOccurrence.find()) {
            System.out.print("Start index: " + dateOccurrence.start() + "\n");
            System.out.print("End index: " + dateOccurrence.end() + "\n");
            System.out.println(dateOccurrence.group());
        }

        Pattern patern2 = Pattern.compile(regex2);
        Matcher mailOccurrence = patern2.matcher(input2);
        System.out.println(mailOccurrence);

        while (mailOccurrence.find()) {
            System.out.println(mailOccurrence.group());
        }
    }
}
