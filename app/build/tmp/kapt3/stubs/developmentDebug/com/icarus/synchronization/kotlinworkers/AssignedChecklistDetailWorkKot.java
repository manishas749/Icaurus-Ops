package com.icarus.synchronization.kotlinworkers;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00180\u00172\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0002J?\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001a2\f\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/AssignedChecklistDetailWorkKot;", "Lcom/icarus/synchronization/kotlinworkers/common/CommonListenableWorker;", "Lcom/icarus/synchronization/syncmodels/ReteriveAssignedChecklistDetail;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "finalList", "Ljava/util/ArrayList;", "", "latestChecklists", "", "", "createSuccessConsumer", "Lio/reactivex/functions/Consumer;", "T", "completer", "Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;", "Landroidx/work/ListenableWorker$Result;", "noOfCalls", "", "getAssignedChecklistDetailApiCalls", "", "Lio/reactivex/Single;", "parseResponse", "Lkotlinx/coroutines/Deferred;", "retrieveAssignedChecklistDetailData", "Lcom/icarus/synchronization/syncmodels/ReteriveAssignedChecklistDetail$Data;", "assignedChecklistUuid", "(Lcom/icarus/synchronization/syncmodels/ReteriveAssignedChecklistDetail$Data;Ljava/lang/String;Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "app_developmentDebug"})
public final class AssignedChecklistDetailWorkKot extends com.icarus.synchronization.kotlinworkers.common.CommonListenableWorker<com.icarus.synchronization.syncmodels.ReteriveAssignedChecklistDetail> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> latestChecklists;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Object> finalList = null;
    
    public AssignedChecklistDetailWorkKot(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters params) {
        super(null, null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker.Result> startWork() {
        return null;
    }
    
    private final java.util.List<io.reactivex.Single<com.icarus.synchronization.syncmodels.ReteriveAssignedChecklistDetail>> getAssignedChecklistDetailApiCalls(java.util.List<java.lang.String> latestChecklists) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public <T extends java.lang.Object>io.reactivex.functions.Consumer<T> createSuccessConsumer(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, int noOfCalls) {
        return null;
    }
    
    private final java.lang.Object parseResponse(com.icarus.synchronization.syncmodels.ReteriveAssignedChecklistDetail.Data retrieveAssignedChecklistDetailData, java.lang.String assignedChecklistUuid, androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Deferred<? extends java.lang.Object>> $completion) {
        return null;
    }
}