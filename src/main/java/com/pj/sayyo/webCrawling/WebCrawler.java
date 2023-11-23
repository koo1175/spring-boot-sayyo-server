package com.pj.sayyo.webCrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/scrape")
public class WebCrawler {
    @GetMapping("/google")
    public List<Map<String, String>> getGoogleData(@RequestParam String search) throws Exception {
        if(search == null || search.isEmpty()){
            throw new IllegalArgumentException("검색어를 입력하세요");
        }

        String url = "https://www.google.com/search?q=" + search + "&sca_esv=579408689&tbm=nws&ei=xB9GZfncK9rg2roPypWnqAU&start=10&sa=N&ved=2ahUKEwj5zv2RlKqCAxVasFYBHcrKCVUQ8tMDegQIAhAE&biw=1005&bih=945&dpr=1";
        Document doc = Jsoup.connect(url).get();

        List<Map<String, String>> results = new ArrayList<>();

        doc.select("div.iRPxbe").forEach(element -> {
            Map<String, String> result = new HashMap<>();
            result.put("title", element.select("div.n0jPhd").text());
            result.put("content", element.select("div.GI74Re").text());
            result.put("image", element.select("div.vJOb1e img").attr("src"));
            result.put("link", element.select("a.SoaBEf").attr("href"));
            result.put("pressInfo", element.select("span.MgUUmf").text());
            result.put("time", element.select("span.OSrXXb").text());
            System.out.println("url"+element.select("div.vJOb1e img").attr("src"));
            results.add(result);
        });

        return results;
    }
}
