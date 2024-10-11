package com.icarus.synchronization.kotlinworkers;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0016J$\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/WorkOrderAssociatedWorkKot;", "Lcom/icarus/synchronization/kotlinworkers/common/CommonListenableWorker;", "Lcom/icarus/synchronization/syncmodels/RetrieveAllWorkorderElements;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "finalList", "Ljava/util/ArrayList;", "", "workOrdersIdList", "", "", "createSuccessConsumer", "Lio/reactivex/functions/Consumer;", "T", "completer", "Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;", "Landroidx/work/ListenableWorker$Result;", "noOfCalls", "getWorkOrdersApiList", "Lio/reactivex/Single;", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "app_developmentDebug"})
public final class WorkOrderAssociatedWorkKot extends com.icarus.synchronization.kotlinworkers.common.CommonListenableWorker<com.icarus.synchronization.syncmodels.RetrieveAllWorkorderElements> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Object> finalList = null;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.Integer> workOrdersIdList;
    
    public WorkOrderAssociatedWorkKot(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters params) {
        super(null, null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker.Result> startWork() {
        return null;
    }
    
    private final java.util.List<io.reactivex.Single<com.icarus.synchronization.syncmodels.RetrieveAllWorkorderElements>> getWorkOrdersApiList(java.util.List<java.lang.Integer> workOrdersIdList) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public <T extends java.lang.Object>io.reactivex.functions.Consumer<T> createSuccessConsumer(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, int noOfCalls) {
        return null;
    }
}