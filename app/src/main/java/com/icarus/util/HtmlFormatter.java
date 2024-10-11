package com.icarus.util;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.sufficientlysecure.htmltextview.ClickableTableSpan;
import org.sufficientlysecure.htmltextview.DrawTableLinkSpan;
import org.sufficientlysecure.htmltextview.HtmlFormatterBuilder;
import org.sufficientlysecure.htmltextview.HtmlTagHandler;

import static org.sufficientlysecure.htmltextview.HtmlTagHandler.LIST_ITEM;
import static org.sufficientlysecure.htmltextview.HtmlTagHandler.ORDERED_LIST;
import static org.sufficientlysecure.htmltextview.HtmlTagHandler.UNORDERED_LIST;

public class HtmlFormatter {
    private HtmlFormatter() {
    }

    public static Spanned formatHtml(@NonNull HtmlFormatterBuilder builder) {
        return formatHtml(builder.getHtml(), builder.getImageGetter(), builder.getClickableTableSpan(), builder.getDrawTableLinkSpan(), builder.getIndent(), builder.isRemoveTrailingWhiteSpace());
    }

    private static Spanned formatHtml(@Nullable String html, Html.ImageGetter imageGetter, ClickableTableSpan clickableTableSpan, DrawTableLinkSpan drawTableLinkSpan, float indent, boolean removeTrailingWhiteSpace) {
        final HtmlTagHandler htmlTagHandler = new HtmlTagHandler();
        htmlTagHandler.setClickableTableSpan(clickableTableSpan);
        htmlTagHandler.setDrawTableLinkSpan(drawTableLinkSpan);
        htmlTagHandler.setListIndentPx(indent);

        html = overrideTags(html);

        Spanned formattedHtml;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            formattedHtml = Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT, imageGetter, htmlTagHandler);
        } else {
            formattedHtml = Html.fromHtml(html, imageGetter, htmlTagHandler);
        }

        if (removeTrailingWhiteSpace) {
            formattedHtml = removeHtmlBottomPadding(formattedHtml);
        }

        return formattedHtml;
    }

    /**
     * Newer versions of the Android SDK's {@link Html.TagHandler} handles &lt;ul&gt; and &lt;li&gt;
     * tags itself which means they never get delegated to this class. We want to handle the tags
     * ourselves so before passing the string html into Html.fromHtml(), we can use this method to
     * replace the &lt;ul&gt; and &lt;li&gt; tags with tags of our own.
     *
     * @param html String containing HTML, for example: "<b>Hello world!</b>"
     * @return html with replaced <ul> and <li> tags
     * @see <a href="https://github.com/android/platform_frameworks_base/commit/8b36c0bbd1503c61c111feac939193c47f812190">Specific Android SDK Commit</a>
     */
    private static String overrideTags(@Nullable String html) {
        if (html == null) {
            return null;
        }

        html = html.replace("<ul", "<" + UNORDERED_LIST);
        html = html.replace("</ul>", "</" + UNORDERED_LIST + ">");
        html = html.replace("<ol", "<" + ORDERED_LIST);
        html = html.replace("</ol>", "</" + ORDERED_LIST + ">");
        html = html.replace("<li", "<" + LIST_ITEM);
        html = html.replace("</li>", "</" + LIST_ITEM + ">");

        return html;
    }

    /**
     * Html.fromHtml sometimes adds extra space at the bottom.
     * This method removes this space again.
     * See https://github.com/SufficientlySecure/html-textview/issues/19
     */
    @Nullable
    private static Spanned removeHtmlBottomPadding(@Nullable Spanned text) {
        if (text == null) {
            return null;
        }

        while (text.length() > 0 && text.charAt(text.length() - 1) == '\n') {
            text = (Spanned) text.subSequence(0, text.length() - 1);
        }

        return text;
    }
}
