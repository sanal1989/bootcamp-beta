package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {
    Map<String, Set<WebPage>> sites = new HashMap<>();
    public static void main(String[] args) {
        Main main = new Main();
        WebPage webPage1 = new WebPage("url1", "title1", "str1, str2. 2 3 12 3 32");
        WebPage webPage2 = new WebPage("url2", "title2", "str2, str3. str2 4 12 3 32");
        WebPage webPage3 = new WebPage("url4", "title4", "str7, st56. 2 3 12 3 32");
        main.indexing(webPage1);
        main.indexing(webPage2);
        main.indexing(webPage3);
        main.print();
        System.out.println("---remove url---");
        main.remove("url1");
        main.print();
        System.out.println("---find string---");
        System.out.println(main.find("12"));
    }

    public void indexing(WebPage webPage){
        String str = webPage.getContent();
        str = str.replaceAll("\\W\\s"," ");
        String[] ar = str.split(" ");
        System.out.println(Arrays.toString(ar));
        for (int i = 0; i < ar.length; i++) {
            if(!sites.containsKey(ar[i])) {
                Set<WebPage> webPages = new HashSet<>();
                webPages.add(webPage);
                sites.put(ar[i],webPages);
            }else{
                Set<WebPage> webPages = sites.get(ar[i]);
                webPages.add(webPage);
            }
        }
    }

    public Set<WebPage> find(String str){
        return sites.get(str);
    }

    public void remove(String url){
        for (Map.Entry<String, Set<WebPage>> i: sites.entrySet()) {
            Set<WebPage> webPages = i.getValue();
            Iterator<WebPage> iterator = webPages.iterator();
            while(iterator.hasNext()){
                WebPage webPage = iterator.next();
                if(webPage.getUrl().equals(url)){
                    iterator.remove();
                }
            }
        }
    }
    public void print(){
        for (Map.Entry<String, Set<WebPage>> i: sites.entrySet()) {
            System.out.println(i.getKey());
            for (WebPage j: i.getValue()) {
                System.out.println(j.getUrl() + " " + j.getTitle() + " " + j.getContent());
            }
        }
    }
}
