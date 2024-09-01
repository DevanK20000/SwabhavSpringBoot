package com.aurionpro.mapping.utils;

import java.lang.reflect.Field;
import java.util.List;

public class HtmlTableBuilder {

    public static <T> String buildHtmlTable(List<T> objects) {
        if (objects == null || objects.isEmpty()) {
            return "<table></table>";
        }

        StringBuilder html = new StringBuilder();
        html.append("<table border='1'>");

        // Add table headers
        html.append("<tr>");
        Field[] fields = objects.get(0).getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            html.append("<th>").append(field.getName()).append("</th>");
        }
        html.append("</tr>");

        // Add table rows
        for (T obj : objects) {
            html.append("<tr>");
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    html.append("<td>").append(field.get(obj)).append("</td>");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            html.append("</tr>");
        }

        html.append("</table>");
        return html.toString();
    }
  }