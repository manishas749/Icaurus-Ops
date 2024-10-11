package com.icarus.util;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/icarus/util/AppUtility;", "", "()V", "Companion", "app_developmentDebug"})
public final class AppUtility {
    @org.jetbrains.annotations.NotNull
    public static final com.icarus.util.AppUtility.Companion Companion = null;
    
    public AppUtility() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000bJ\b\u0010\u000e\u001a\u00020\u0006H\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/icarus/util/AppUtility$Companion;", "", "()V", "compairTwoDates", "", "currentTime", "", "previousTime", "formatDueDate", "time", "getTitleList", "", "T", "items", "getUtcTime", "getUtcTimeImageFileName", "getUuid", "getYMDTime", "parseDateToddMMMyyyy", "parseDateToddMMyyyy", "setBackgroundDrawable", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "color", "", "setTextColor", "Landroid/widget/TextView;", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @android.annotation.SuppressLint(value = {"NewApi"})
        public final void setBackgroundDrawable(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        android.view.View view, int color) {
        }
        
        public final void setTextColor(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        android.widget.TextView view, int color) {
        }
        
        @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUtcTime() {
            return null;
        }
        
        @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUtcTimeImageFileName() {
            return null;
        }
        
        @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getYMDTime() {
            return null;
        }
        
        public final boolean compairTwoDates(@org.jetbrains.annotations.NotNull
        java.lang.String currentTime, @org.jetbrains.annotations.NotNull
        java.lang.String previousTime) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final <T extends java.lang.Object>java.util.List<java.lang.String> getTitleList(@org.jetbrains.annotations.NotNull
        java.util.List<? extends T> items) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUuid() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String formatDueDate(@org.jetbrains.annotations.NotNull
        java.lang.String time) {
            return null;
        }
        
        /**
         * Date formating yyyy-MM-dd HH:mm:ss to dd MMM, yyyy HH:mm:ss
         *
         * @param time
         *
         * @return
         */
        @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
        @org.jetbrains.annotations.NotNull
        public final java.lang.String parseDateToddMMyyyy(@org.jetbrains.annotations.NotNull
        java.lang.String time) {
            return null;
        }
        
        /**
         * Date formating yyyy-MM-dd HH:mm:ss to dd MMM, yyyy HH:mm:ss
         *
         * @param time
         *
         * @return
         */
        @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
        @org.jetbrains.annotations.NotNull
        public final java.lang.String parseDateToddMMMyyyy(@org.jetbrains.annotations.NotNull
        java.lang.String time) {
            return null;
        }
    }
}