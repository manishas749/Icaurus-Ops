package com.icarus.synchronization.kotlinworkers;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J,\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001d0\t2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0 H\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/ChecklistLocationWorkKot;", "Lcom/icarus/synchronization/kotlinworkers/common/CommonListenableWorker;", "Lcom/icarus/synchronization/syncmodels/ChecklistLocationObject;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "checklistIdArray", "", "", "checklistLocationEntityList", "Ljava/util/ArrayList;", "Lcom/icarus/entities/ChecklistLocationEntity;", "finalList", "", "pageNo", "", "remainingPageChecklistId", "roomEquipmentList", "Lcom/icarus/entities/ChecklistRoomEquipmentsEntity;", "createSuccessConsumer", "Lio/reactivex/functions/Consumer;", "T", "completer", "Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;", "Landroidx/work/ListenableWorker$Result;", "noOfCalls", "getChecklistAPI", "Lio/reactivex/Single;", "checklistIdList", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "app_developmentDebug"})
public final class ChecklistLocationWorkKot extends com.icarus.synchronization.kotlinworkers.common.CommonListenableWorker<com.icarus.synchronization.syncmodels.ChecklistLocationObject> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Object> finalList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.String> remainingPageChecklistId = null;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> checklistIdArray;
    private int pageNo = 1;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.icarus.entities.ChecklistLocationEntity> checklistLocationEntityList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.icarus.entities.ChecklistRoomEquipmentsEntity> roomEquipmentList = null;
    
    public ChecklistLocationWorkKot(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters params) {
        super(null, null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker.Result> startWork() {
        return null;
    }
    
    private final java.util.List<io.reactivex.Single<com.icarus.synchronization.syncmodels.ChecklistLocationObject>> getChecklistAPI(java.util.List<java.lang.String> checklistIdList, int pageNo) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public <T extends java.lang.Object>io.reactivex.functions.Consumer<T> createSuccessConsumer(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, int noOfCalls) {
        return null;
    }
}