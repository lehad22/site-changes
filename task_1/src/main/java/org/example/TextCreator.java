package org.example;

import java.net.URL;
import java.util.Set;

public class TextCreator {

    public static String createText(Changes changes) {
        StringBuilder reportBuilder = new StringBuilder();

        reportBuilder.append("Здравствуйте, дорогая и.о. секретаря,\n\n");
        reportBuilder.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n");

        reportBuilder.append("Исчезли следующие страницы:\n");
        appendUrls(reportBuilder, changes.getDisappeared());

        reportBuilder.append("\nПоявились следующие новые страницы:\n");
        appendUrls(reportBuilder, changes.getAppeared());

        reportBuilder.append("\nИзменились следующие страницы:\n");
        appendUrls(reportBuilder, changes.getChanged());

        reportBuilder.append("\nС уважением,\nавтоматизированная система мониторинга.\n");
        return reportBuilder.toString();
    }

    private static void appendUrls(StringBuilder report, Set<URL> urls) {
        if (urls.isEmpty()) {
            report.append(" - Нет изменений.\n");
        } else {
            for (URL url : urls) {
                report.append(" - ").append(url).append("\n");
            }
        }
    }
}
