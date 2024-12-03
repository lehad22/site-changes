package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> yesterday = new HashMap<>();
        yesterday.put("http://test1.com/page1", "Old Content Page 1");
        yesterday.put("http://test1.com/page2", "Old Content Page 2");
        yesterday.put("http://test1.com/page3", "Old Content Page 3");


        Map<String, String> today = new HashMap<>();
        today.put("http://test1.com/page1", "New Content Page 1");
        today.put("http://test1.com/page3", "Old Content Page 3");
        today.put("http://test1.com/page4", "New Content Page 4");

        ChangeDetector detector = new ChangeDetector();
        Changes changes = detector.detectChanges(yesterday, today);

        TextCreator formatter = new TextCreator();
        String report = formatter.createText(changes);

        System.out.println(report);
    }
}
