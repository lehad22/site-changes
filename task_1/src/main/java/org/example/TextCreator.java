package org.example;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
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

    private static void appendUrls(StringBuilder reportBuilder, Set<URL> urls) {
        if (urls.isEmpty()) {
            reportBuilder.append(" - Нет изменений.\n");
        } else {
            for (URL url : urls) {
                reportBuilder.append(" - ").append(url).append("\n");
            }
        }
    }
    public void saveTextToFile(String text, String filePath) throws IOException, IOException {
        Path path = Path.of(filePath);
        Files.writeString(path, text);
    }
}
