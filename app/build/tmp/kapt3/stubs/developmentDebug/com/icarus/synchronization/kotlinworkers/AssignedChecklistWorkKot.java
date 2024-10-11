package com.icarus.synchronization.kotlinworkers;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0004\b\u0000\u0010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001b\u0010\u001f\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010 \u001a\u00020\u001eH\u0016\u00a2\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0#H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/icarus/synchronization/kotlinworkers/AssignedChecklistWorkKot;", "Lcom/icarus/synchronization/kotlinworkers/common/CommonListenableWorker;", "Lcom/icarus/synchronization/syncmodels/RetrieveAssignedChecklist;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "assignRoomEquipmentsEntityList", "Ljava/util/ArrayList;", "Lcom/icarus/entities/AssignRoomEquipmentsEntity;", "assignedChecklistEntityList", "Lcom/icarus/entities/AssignCheckListEntity;", "assignedDepartmentsEntityList", "Lcom/icarus/entities/AsssignedDepartmentsEntity;", "assignedLogoEntityList", "Lcom/icarus/entities/AssignedLogoEntity;", "assignedUserEntityList", "Lcom/icarus/entities/AssignedUserEntity;", "finalList", "", "lastSyncTime", "", "createSuccessConsumer", "Lio/reactivex/functions/Consumer;", "T", "completer", "Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;", "Landroidx/work/ListenableWorker$Result;", "noOfCalls", "", "getApisCalls", "finalPageCount", "(I)Ljava/lang/Object;", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "app_developmentDebug"})
public final class AssignedChecklistWorkKot extends com.icarus.synchronization.kotlinworkers.common.CommonListenableWorker<com.icarus.synchronization.syncmodels.RetrieveAssignedChecklist> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Object> finalList = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String lastSyncTime;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.icarus.entities.AssignCheckListEntity> assignedChecklistEntityList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.icarus.entities.AssignedLogoEntity> assignedLogoEntityList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.icarus.entities.AssignRoomEquipmentsEntity> assignRoomEquipmentsEntityList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.icarus.entities.AssignedUserEntity> assignedUserEntityList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.icarus.entities.AsssignedDepartmentsEntity> assignedDepartmentsEntityList = null;
    
    public AssignedChecklistWorkKot(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters params) {
        super(null, null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker.Result> startWork() {
        return null;
    }
    
    @java.lang.Override
    public <T extends java.lang.Object>T getApisCalls(int finalPageCount) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public <T extends java.lang.Object>io.reactivex.functions.Consumer<T> createSuccessConsumer(@org.jetbrains.annotations.NotNull
    androidx.concurrent.futures.CallbackToFutureAdapter.Completer<androidx.work.ListenableWorker.Result> completer, int noOfCalls) {
        return null;
    }
}