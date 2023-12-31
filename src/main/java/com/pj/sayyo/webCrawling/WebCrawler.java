package com.pj.sayyo.webCrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/scrape")
public class WebCrawler {
    @GetMapping("/google")
    public List<Map<String, String>> getGoogleData(@RequestParam String search) throws Exception {
        if(search == null || search.isEmpty()){
            throw new IllegalArgumentException("검색어를 입력하세요");
        }
        String url = "https://www.google.com/search?q=" + search + "&sca_esv=584847290&tbm=nws&sxsrf=AM9HkKnENX7iCeetmMUAlcfgwwd0F0-sZA:1700742380307&ei=7ERfZbywEq7c2roP3eGdmAQ&start=10&sa=N&ved=2ahUKEwi81rqLj9qCAxUurlYBHd1wB0MQ8tMDegQIAxAE&biw=707&bih=919&dpr=1";
        Document doc = Jsoup.connect(url).get();

        List<Map<String, String>> results = new ArrayList<>();

        doc.select("div.SoaBEf").forEach(element -> {
            Map<String, String> result = new HashMap<>();
            result.put("title", element.select("div.n0jPhd").text());
            result.put("content", element.select("div.GI74Re").text());
            result.put("link", element.select("a.WlydOe").attr("href"));
            result.put("pressInfo", element.select("div.MgUUmf span").text());
            result.put("time", element.select("div.OSrXXb span").text());
            result.put("image", element.select("div.FAkayc img").attr("src"));

            System.out.println("title : "+element.select("div.n0jPhd").text());
            System.out.println("content : "+element.select("div.GI74Re").text());
            System.out.println("link : "+element.select("a.WlydOe").attr("href"));
            System.out.println("pressInfo : "+element.select("div.MgUUmf span").text());
            System.out.println("time : "+element.select("div.OSrXXb span").text());
            String base64Image = element.select("div.FAkayc img").attr("src");
            String base64ImagePure = base64Image.split(",")[1];
            System.out.println("image : "+ element.select("div.vJOb1e img").attr("src"));
            results.add(result);
        });

        return results;
    }
}
