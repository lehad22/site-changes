package org.example;

import java.util.Set;

public class TextCreator {

    public String createText(Changes changes) {
        StringBuilder report = new StringBuilder();

        report.append("Здравствуйте, дорогая и.о. секретаря,\n\n");
        report.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n");

        report.append("Исчезли следующие страницы:\n");
        appendUrls(report, changes.getDisappeared());

        report.append("\nПоявились следующие новые страницы:\n");
        appendUrls(report, changes.getAppeared());

        report.append("\nИзменились следующие страницы:\n");
        appendUrls(report, changes.getChanged());

        report.append("\nС уважением,\nавтоматизированная система мониторинга.\n");
        return report.toString();
    }

    private void appendUrls(StringBuilder report, Set<String> urls) {
        if (urls.isEmpty()) {
            report.append(" - Нет изменений.\n");
        } else {
            for (String url : urls) {
                report.append(" - ").append(url).append("\n");
            }
        }
    }
}
