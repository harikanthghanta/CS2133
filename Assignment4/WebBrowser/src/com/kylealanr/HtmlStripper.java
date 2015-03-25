package com.kylealanr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kyle on 3/24/15.
 */
public class HtmlStripper {

    public HtmlStripper(){}

    public String stripTitle(String rawHTML){
        String title;
        Matcher matcher;

        matcher = Pattern.compile("<title[^>]*>(.*?)</title>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(rawHTML);

        return "";
    }
}
