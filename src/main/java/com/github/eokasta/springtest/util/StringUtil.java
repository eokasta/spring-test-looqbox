package com.github.eokasta.springtest.util;

public class StringUtil {

    public static String formatWithHighlight(final String pokemonName, final String query) {
        return pokemonName.replaceFirst("(?i)" + query, "<pre>" + query + "</pre>");
    }

}
