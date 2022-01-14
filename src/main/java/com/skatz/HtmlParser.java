package com.skatz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.xsoup.Xsoup;

public class HtmlParser {
    public static String Parse(String html, String xpath) {
        Document doc = Jsoup.parse(html);
        Elements elements = Xsoup.compile(xpath).evaluate(doc).getElements();
        StringBuilder sb = new StringBuilder();

        for (Element element : elements) {
            sb.append(element.text());
        }

        return sb.toString();
    }
}
