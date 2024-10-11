package com.icarus.dao;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChecklistUndoDao_Impl implements ChecklistUndoDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedNCW;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedStep;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedResources;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedStepAttribute;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedDecision;

  public ChecklistUndoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfUpdateAssignedNCW = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_ncw set is_deleted = 1 , modified = ? , sync_status = 0 where checklist_element_id = ? and is_deleted = 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedStep = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_steps set is_deleted = 1 , modified = ? , sync_status = 0 where checklist_element_id = ? and is_deleted = 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedResources = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_resources  set is_deleted = 1 , modified = ? , sync_status = 0 where checklist_element_id = ? and is_deleted = 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedStepAttribute = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_attributes  set is_deleted = 1 , modified = ? , sync_status = 0 where checklist_element_id = ? and is_deleted = 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedDecision = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_decisions set is_deleted = 1 , modified = ? , sync_status = 0 where checklist_element_id = ? and is_deleted = 0";
        return _query;
      }
    };
  }

  @Override
  public void updateAssignedNCW(final Integer checklistElementId, final String date) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedNCW.acquire();
    int _argIndex = 1;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    _argIndex = 2;
    if (checklistElementId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistElementId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedNCW.release(_stmt);
    }
  }

  @Override
  public void updateAssignedStep(final Integer checklistElementId, final String date) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedStep.acquire();
    int _argIndex = 1;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    _argIndex = 2;
    if (checklistElementId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistElementId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedStep.release(_stmt);
    }
  }

  @Override
  public void updateAssignedResources(final Integer checklistElementId, final String date) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedResources.acquire();
    int _argIndex = 1;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    _argIndex = 2;
    if (checklistElementId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistElementId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedResources.release(_stmt);
    }
  }

  @Override
  public void updateAssignedStepAttribute(final Integer checklistElementId, final String date) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedStepAttribute.acquire();
    int _argIndex = 1;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    _argIndex = 2;
    if (checklistElementId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistElementId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedStepAttribute.release(_stmt);
    }
  }

  @Override
  public void updateAssignedDecision(final Integer checklistElementId, final String date) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedDecision.acquire();
    int _argIndex = 1;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    _argIndex = 2;
    if (checklistElementId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistElementId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedDecision.release(_stmt);
    }
  }
}
