package com.icarus.util;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by Monika Rana on 2/18/2019.
 */
//com.icarus.models
public class SearchContentProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.icarus.search";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchContentProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}