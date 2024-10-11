package com.icarus.synchronization.kotlinworkers;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/SyncWorkerKot;", "Lcom/icarus/synchronization/kotlinworkers/common/CommonListenableWorker;", "Lcom/icarus/synchronization/syncmodels/SyncObject;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "createCallback", "Lretrofit2/Callback;", "completer", "Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;", "Landroidx/work/ListenableWorker$Result;", "finalPageCount", "", "getPageCountData", "Landroidx/work/Data;", "syncObject", "hitAPI", "", "pageNo", "callback", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "updateLastSyncTime", "lastSyncTime", "", "Companion", "app_developmentDebug"})
public final class SyncWorkerKot extends com.icarus.synchronization.kotlinworkers.common.CommonListenableWorker<com.icarus.synchronization.syncmodels.SyncObject> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private static long startTime = 0L;
    @org.jetbrains.annotations.Nullable
    private io.reactivex.disposables.CompositeDisposable disposables;
    @org.jetbrains.annotations.NotNull
    public static final com.icarus.synchronization.kotlinworkers.SyncWorkerKot.Companion Companion = null;
    
    public SyncWorkerKot(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters params) {
        super(null, null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public retrofit2.Callback<com.icarus.synchronization.syncmodels.SyncObject> createCallback(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, int finalPageCount) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker.Result> startWork() {
        return null;
    }
    
    @java.lang.Override
    public void hitAPI(int pageNo, @org.jetbrains.annotations.NotNull
    retrofit2.Callback<com.icarus.synchronization.syncmodels.SyncObject> callback) {
    }
    
    private final void updateLastSyncTime(java.lang.String lastSyncTime) {
    }
    
    private final androidx.work.Data getPageCountData(com.icarus.synchronization.syncmodels.SyncObject syncObject) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/SyncWorkerKot$Companion;", "", "()V", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final long getStartTime() {
            return 0L;
        }
        
        public final void setStartTime(long p0) {
        }
    }
}