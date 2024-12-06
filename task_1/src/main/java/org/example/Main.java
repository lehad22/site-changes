package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        Map<URL, String> yesterday = new HashMap<>();
        yesterday.put(new URL("http://test1.com/page1"), "Old Content Page 1");
        yesterday.put(new URL("http://test1.com/page2"), "Old Content Page 2");
        yesterday.put(new URL("http://test1.com/page3"), "Old Content Page 3");


        Map<URL, String> today = new HashMap<>();
        today.put(new URL("http://test1.com/page1"), "New Content Page 1");
        today.put(new URL("http://test1.com/page3"), "Old Content Page 3");
        today.put(new URL("http://test1.com/page4"), "New Content Page 4");

        ChangeDetector detector = new ChangeDetector();
        Changes changes = detector.detectChanges(yesterday, today);

        TextCreator formatter = new TextCreator();
        String report = formatter.createText(changes);

        System.out.println(report);
    }
}
