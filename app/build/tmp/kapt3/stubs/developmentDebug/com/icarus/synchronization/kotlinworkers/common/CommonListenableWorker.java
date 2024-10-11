package com.icarus.synchronization.kotlinworkers.common;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 J*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0001JB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015JM\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u001a0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00190\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0013H\u0002J&\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\'H\u0016J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J,\u0010/\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u001c\"\u0004\b\u0001\u0010\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u00100\u001a\u00020\'H\u0016J\u001d\u00101\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\u0006\u0010&\u001a\u00020\'H\u0016\u00a2\u0006\u0002\u00102J \u00103\u001a\u00020\u00132\n\u00104\u001a\u000605j\u0002`62\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u0006\u00107\u001a\u00020\u0013J\u001c\u00108\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u00109\u001a\u00020\u001eJ\u001e\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\'2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016Jb\u0010=\u001a\u00020\u0017\"\u0004\b\u0001\u0010\u00012\u0006\u0010>\u001a\u00020,2\u0006\u0010&\u001a\u00020\'2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u001a0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00190\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001cJ*\u0010@\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u001a\u0010A\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020\u0013H\u0016J\u001e\u0010G\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010H\u001a\u00020IR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006K"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/common/CommonListenableWorker;", "T", "Landroidx/work/ListenableWorker;", "Lcom/icarus/synchronization/InternetConnectionListener;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getSynchronizationDao", "Lcom/icarus/dao/GetSynchronizationDaoKot;", "getGetSynchronizationDao", "()Lcom/icarus/dao/GetSynchronizationDaoKot;", "mContext", "postSynchronizationDao", "Lcom/icarus/dao/PostSynchronizationDao;", "getPostSynchronizationDao", "()Lcom/icarus/dao/PostSynchronizationDao;", "apiHitTime", "", "milliSec", "", "callAPIsIn1to9", "Lkotlinx/coroutines/Job;", "source", "", "Lio/reactivex/Single;", "success", "Lio/reactivex/functions/Consumer;", "error", "", "(Ljava/util/List;Lio/reactivex/functions/Consumer;Lio/reactivex/functions/Consumer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelCalls", "createCallback", "Lretrofit2/Callback;", "completer", "Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;", "Landroidx/work/ListenableWorker$Result;", "finalPageCount", "", "createErrorConsumer", "createForegroundInfo", "Landroidx/work/ForegroundInfo;", "notificationMsg", "", "createNotification", "Landroid/app/Notification;", "createSuccessConsumer", "noOfCalls", "getApisCalls", "(I)Ljava/lang/Object;", "handleException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleFailure", "handleFailureResponse", "t", "hitAPI", "pageNo", "callback", "hitApi", "key", "apiCalls", "launchScope", "logObject", "obj", "", "show", "", "onInternetUnavailable", "setCompleterStatusSuccess", "inputData", "Landroidx/work/Data;", "Companion", "app_developmentDebug"})
public abstract class CommonListenableWorker<T extends java.lang.Object> extends androidx.work.ListenableWorker implements com.icarus.synchronization.InternetConnectionListener {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull
    private final com.icarus.dao.PostSynchronizationDao postSynchronizationDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.icarus.dao.GetSynchronizationDaoKot getSynchronizationDao = null;
    public static final int MAX_BATCH_SIZE = 5;
    public static final long MAX_DELAY = 400L;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOTIFICATION_CHANNEL_ID = "2";
    @org.jetbrains.annotations.NotNull
    private static final androidx.lifecycle.MutableLiveData<java.lang.String> notificationMessage = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.jvm.functions.Function1<java.lang.Long, java.lang.String> getTotalTime = null;
    @org.jetbrains.annotations.NotNull
    public static final com.icarus.synchronization.kotlinworkers.common.CommonListenableWorker.Companion Companion = null;
    
    public CommonListenableWorker(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters params) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.icarus.dao.PostSynchronizationDao getPostSynchronizationDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.icarus.dao.GetSynchronizationDaoKot getGetSynchronizationDao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public retrofit2.Callback<T> createCallback(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, int finalPageCount) {
        return null;
    }
    
    public void hitAPI(int pageNo, @org.jetbrains.annotations.NotNull
    retrofit2.Callback<T> callback) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.work.ForegroundInfo createForegroundInfo(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String notificationMsg) {
        return null;
    }
    
    private final android.app.Notification createNotification(android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job launchScope(int finalPageCount, @org.jetbrains.annotations.NotNull
    retrofit2.Callback<T> callback, @org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer) {
        return null;
    }
    
    public final void apiHitTime(long milliSec) {
    }
    
    @java.lang.Override
    public void onInternetUnavailable() {
    }
    
    public final void handleException(@org.jetbrains.annotations.NotNull
    java.lang.Exception e, @org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer) {
    }
    
    public final void handleFailureResponse(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, @org.jetbrains.annotations.NotNull
    java.lang.Throwable t) {
    }
    
    public final void handleFailure() {
    }
    
    private final void cancelCalls() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final <T extends java.lang.Object>kotlinx.coroutines.Job hitApi(@org.jetbrains.annotations.NotNull
    java.lang.String key, int finalPageCount, @org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, @org.jetbrains.annotations.NotNull
    java.util.List<? extends io.reactivex.Single<T>> apiCalls, @org.jetbrains.annotations.NotNull
    io.reactivex.functions.Consumer<java.util.List<T>> success, @org.jetbrains.annotations.NotNull
    io.reactivex.functions.Consumer<java.lang.Throwable> error) {
        return null;
    }
    
    private final <T extends java.lang.Object>java.lang.Object callAPIsIn1to9(java.util.List<? extends io.reactivex.Single<T>> source, io.reactivex.functions.Consumer<java.util.List<T>> success, io.reactivex.functions.Consumer<java.lang.Throwable> error, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public <T extends java.lang.Object>T getApisCalls(int finalPageCount) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public <T extends java.lang.Object>io.reactivex.functions.Consumer<T> createSuccessConsumer(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, int noOfCalls) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public io.reactivex.functions.Consumer<java.lang.Throwable> createErrorConsumer(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer) {
        return null;
    }
    
    public final void logObject(@org.jetbrains.annotations.Nullable
    java.lang.Object obj, boolean show) {
    }
    
    public final void setCompleterStatusSuccess(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, @org.jetbrains.annotations.NotNull
    androidx.work.Data inputData) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\b0\b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/common/CommonListenableWorker$Companion;", "", "()V", "MAX_BATCH_SIZE", "", "MAX_DELAY", "", "NOTIFICATION_CHANNEL_ID", "", "getTotalTime", "Lkotlin/Function1;", "getGetTotalTime", "()Lkotlin/jvm/functions/Function1;", "notificationMessage", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getNotificationMessage", "()Landroidx/lifecycle/MutableLiveData;", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.lifecycle.MutableLiveData<java.lang.String> getNotificationMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function1<java.lang.Long, java.lang.String> getGetTotalTime() {
            return null;
        }
    }
}