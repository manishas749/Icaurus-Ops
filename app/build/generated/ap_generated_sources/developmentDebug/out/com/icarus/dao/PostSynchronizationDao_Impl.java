package com.icarus.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.UserSuggestionEntity;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PostSynchronizationDao_Impl implements PostSynchronizationDao {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<UserSuggestionAttachmentsEntity> __updateAdapterOfUserSuggestionAttachmentsEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusAssignedCheclist;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusAssignedChecklistComment;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusAssignedDecision;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusLogs;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusPauseTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusRoomEquipments;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusLogo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusStep;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusStepStepAttributes;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusStepResources;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusNCW;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusUserFavorite;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusUserSuggestion;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusUserSuggestionAttachment;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusWorkorder;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusWorkorder_1;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusWorkorderNotes;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusWorkorderAttachments;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusWorkorderAttachments_1;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatusWorkorderNotesDetail;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWorkorderAttachmentMd5Checksum;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssigednStepMd5Checksum;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserSuggestionAttachmentMd5Checksum;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingElementCount;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingResourceCount;

  public PostSynchronizationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__updateAdapterOfUserSuggestionAttachmentsEntity = new EntityDeletionOrUpdateAdapter<UserSuggestionAttachmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user_suggestion_attachments` SET `uuid` = ?,`user_suggestion_uuid` = ?,`display_filename` = ?,`filename` = ?,`filesize` = ?,`content_type` = ?,`user_id` = ?,`file_md5_checksum` = ?,`is_uploaded` = ?,`created` = ?,`modified` = ?,`sync_status` = ? WHERE `uuid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserSuggestionAttachmentsEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getUser_suggestion_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUser_suggestion_uuid());
        }
        if (value.getDisplay_filename() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDisplay_filename());
        }
        if (value.getFilename() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFilename());
        }
        if (value.getFilesize() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getFilesize());
        }
        if (value.getContent_type() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getContent_type());
        }
        if (value.getUser_id() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getUser_id());
        }
        if (value.getFile_md5_checksum() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFile_md5_checksum());
        }
        if (value.getIs_uploaded() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getIs_uploaded());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getModified());
        }
        if (value.getSync_status() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getSync_status());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuid());
        }
      }
    };
    this.__preparedStmtOfUpdateSyncStatusAssignedCheclist = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists set sync_status = 1, execution_status = 1 where uuid = ?;";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusAssignedChecklistComment = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklist_comments set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusAssignedDecision = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_decisions set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusLogs = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update logs set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusPauseTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklist_pause_times set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusRoomEquipments = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_room_equipments set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusLogo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_logos set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusStep = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_steps set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusStepStepAttributes = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_attributes set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusStepResources = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_resources set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusNCW = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_ncw set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusUser = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_users set sync_status = 1 where uuid = ?;";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusUserFavorite = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update user_favorites set sync_status = 1 where uuid = ?;";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusUserSuggestion = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update user_suggestions set sync_status = 1 where uuid = ?;";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusUserSuggestionAttachment = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update user_suggestion_attachments set sync_status = 1 where uuid = ?;";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update locations set last_sync_time = ? where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update locations set last_sync_status = ? where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusWorkorder = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorders set sync_status = 1, id = ? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusWorkorder_1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorders set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusWorkorderNotes = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorder_notes set sync_status = 1 , workorder_id = ?,  id = ? where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusWorkorderAttachments = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorder_attachments set sync_status = 1, workorder_id = ? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusWorkorderAttachments_1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorder_attachments set sync_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatusWorkorderNotesDetail = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorder_note_details set sync_status = 1, workorder_note_id = ?,  id = ? where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWorkorderAttachmentMd5Checksum = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorder_attachments set is_uploaded = 1 AND file_md5_checksum = ?  WHERE uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssigednStepMd5Checksum = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_resources set is_uploaded = 1 AND file_md5_checksum = ? WHERE uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUserSuggestionAttachmentMd5Checksum = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update user_suggestion_attachments set is_uploaded = 1 AND file_md5_checksum = ?  WHERE uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedChecklistPendingElementCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET pending_elements_count = pending_elements_count - 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedChecklistPendingResourceCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET pending_resources_count = pending_resources_count - 1 where uuid = ?";
        return _query;
      }
    };
  }

  @Override
  public void updateSyncStatus(
      final UserSuggestionAttachmentsEntity userSuggestionAttachmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUserSuggestionAttachmentsEntity.handle(userSuggestionAttachmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSyncStatusAssignedCheclist(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusAssignedCheclist.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusAssignedCheclist.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusAssignedChecklistComment(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusAssignedChecklistComment.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusAssignedChecklistComment.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusAssignedDecision(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusAssignedDecision.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusAssignedDecision.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusLogs(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusLogs.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusLogs.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusPauseTime(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusPauseTime.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusPauseTime.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusRoomEquipments(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusRoomEquipments.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusRoomEquipments.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusLogo(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusLogo.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusLogo.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusStep(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusStep.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusStep.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusStepStepAttributes(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusStepStepAttributes.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusStepStepAttributes.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusStepResources(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusStepResources.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusStepResources.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusNCW(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusNCW.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusNCW.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusUser(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusUser.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusUser.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusUserFavorite(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusUserFavorite.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusUserFavorite.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusUserSuggestion(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusUserSuggestion.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusUserSuggestion.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusUserSuggestionAttachment(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusUserSuggestionAttachment.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusUserSuggestionAttachment.release(_stmt);
    }
  }

  @Override
  public int updateSyncTime(final String lastSyncTime, final Integer locationId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncTime.acquire();
    int _argIndex = 1;
    if (lastSyncTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, lastSyncTime);
    }
    _argIndex = 2;
    if (locationId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, locationId);
    }
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncTime.release(_stmt);
    }
  }

  @Override
  public int updateSyncStatus(final Integer lastSyncStatus, final Integer locationId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatus.acquire();
    int _argIndex = 1;
    if (lastSyncStatus == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, lastSyncStatus);
    }
    _argIndex = 2;
    if (locationId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, locationId);
    }
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatus.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusWorkorder(final Integer id, final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusWorkorder.acquire();
    int _argIndex = 1;
    if (id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, id);
    }
    _argIndex = 2;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusWorkorder.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusWorkorder(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusWorkorder_1.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusWorkorder_1.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusWorkorderNotes(final Integer workorderId, final Integer id,
      final Integer oldId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusWorkorderNotes.acquire();
    int _argIndex = 1;
    if (workorderId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, workorderId);
    }
    _argIndex = 2;
    if (id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, id);
    }
    _argIndex = 3;
    if (oldId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, oldId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusWorkorderNotes.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusWorkorderAttachments(final Integer workorderId, final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusWorkorderAttachments.acquire();
    int _argIndex = 1;
    if (workorderId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, workorderId);
    }
    _argIndex = 2;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusWorkorderAttachments.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusWorkorderAttachments(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusWorkorderAttachments_1.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusWorkorderAttachments_1.release(_stmt);
    }
  }

  @Override
  public void updateSyncStatusWorkorderNotesDetail(final Integer workorderNoteId, final Integer id,
      final Integer oldId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatusWorkorderNotesDetail.acquire();
    int _argIndex = 1;
    if (workorderNoteId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, workorderNoteId);
    }
    _argIndex = 2;
    if (id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, id);
    }
    _argIndex = 3;
    if (oldId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, oldId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSyncStatusWorkorderNotesDetail.release(_stmt);
    }
  }

  @Override
  public void updateWorkorderAttachmentMd5Checksum(final String fileMd5Checksum,
      final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWorkorderAttachmentMd5Checksum.acquire();
    int _argIndex = 1;
    if (fileMd5Checksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fileMd5Checksum);
    }
    _argIndex = 2;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateWorkorderAttachmentMd5Checksum.release(_stmt);
    }
  }

  @Override
  public void updateAssigednStepMd5Checksum(final String fileMd5Checksum, final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssigednStepMd5Checksum.acquire();
    int _argIndex = 1;
    if (fileMd5Checksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fileMd5Checksum);
    }
    _argIndex = 2;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssigednStepMd5Checksum.release(_stmt);
    }
  }

  @Override
  public void updateUserSuggestionAttachmentMd5Checksum(final String fileMd5Checksum,
      final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserSuggestionAttachmentMd5Checksum.acquire();
    int _argIndex = 1;
    if (fileMd5Checksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fileMd5Checksum);
    }
    _argIndex = 2;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUserSuggestionAttachmentMd5Checksum.release(_stmt);
    }
  }

  @Override
  public void updateAssignedChecklistPendingElementCount(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedChecklistPendingElementCount.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedChecklistPendingElementCount.release(_stmt);
    }
  }

  @Override
  public void updateAssignedChecklistPendingResourceCount(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedChecklistPendingResourceCount.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedChecklistPendingResourceCount.release(_stmt);
    }
  }

  @Override
  public List<AssignCheckListEntity> getNonSyncedAssignedChecklist() {
    final String _sql = "select * from assigned_checklists where sync_status = 0 AND execution_status = 0;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_at");
      final int _cursorIndexOfAssigneeType = CursorUtil.getColumnIndexOrThrow(_cursor, "assignee_type");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "department_id");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "due_date");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStartedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "started_at");
      final int _cursorIndexOfStartedByUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "started_by_user_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfExecutionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "execution_status");
      final int _cursorIndexOfPendingElementsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_elements_count");
      final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_resources_count");
      final List<AssignCheckListEntity> _result = new ArrayList<AssignCheckListEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignCheckListEntity _item;
        _item = new AssignCheckListEntity();
        _item.assignedAt = _cursor.getString(_cursorIndexOfAssignedAt);
        if (_cursor.isNull(_cursorIndexOfAssigneeType)) {
          _item.assigneeType = null;
        } else {
          _item.assigneeType = _cursor.getInt(_cursorIndexOfAssigneeType);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _item.checklistId = null;
        } else {
          _item.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistStatus)) {
          _item.checklistStatus = null;
        } else {
          _item.checklistStatus = _cursor.getInt(_cursorIndexOfChecklistStatus);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfDepartmentId)) {
          _item.departmentId = null;
        } else {
          _item.departmentId = _cursor.getInt(_cursorIndexOfDepartmentId);
        }
        _item.dueDate = _cursor.getString(_cursorIndexOfDueDate);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _item.locationId = null;
        } else {
          _item.locationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        _item.startedAt = _cursor.getString(_cursorIndexOfStartedAt);
        if (_cursor.isNull(_cursorIndexOfStartedByUserId)) {
          _item.startedByUserId = null;
        } else {
          _item.startedByUserId = _cursor.getInt(_cursorIndexOfStartedByUserId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        if (_cursor.isNull(_cursorIndexOfExecutionStatus)) {
          _item.executionStatus = null;
        } else {
          _item.executionStatus = _cursor.getInt(_cursorIndexOfExecutionStatus);
        }
        if (_cursor.isNull(_cursorIndexOfPendingElementsCount)) {
          _item.pendingElementsCount = null;
        } else {
          _item.pendingElementsCount = _cursor.getInt(_cursorIndexOfPendingElementsCount);
        }
        if (_cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
          _item.pendingResourcesCount = null;
        } else {
          _item.pendingResourcesCount = _cursor.getInt(_cursorIndexOfPendingResourcesCount);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedUserEntity> getNonSyncedAssignedUsers() {
    final String _sql = "select AssociatedTable.* from assigned_users AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedCheklistUUID = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfAssignedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_by");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<AssignedUserEntity> _result = new ArrayList<AssignedUserEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedUserEntity _item;
        _item = new AssignedUserEntity();
        _item.assignedCheklistUUID = _cursor.getString(_cursorIndexOfAssignedCheklistUUID);
        if (_cursor.isNull(_cursorIndexOfAssignedBy)) {
          _item.assignedBy = null;
        } else {
          _item.assignedBy = _cursor.getInt(_cursorIndexOfAssignedBy);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedChecklistCommentsEntity> getNonSyncedAssignedChecklistComments() {
    final String _sql = "select AssociatedTable.* from assigned_checklist_comments AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final List<AssignedChecklistCommentsEntity> _result = new ArrayList<AssignedChecklistCommentsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedChecklistCommentsEntity _item;
        _item = new AssignedChecklistCommentsEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUserId(_tmpUserId);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        _item.setComment(_tmpComment);
        final Integer _tmpIsDeleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIsDeleted = null;
        } else {
          _tmpIsDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIsDeleted(_tmpIsDeleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        final Integer _tmpChecklistId;
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _tmpChecklistId = null;
        } else {
          _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        _item.setChecklistId(_tmpChecklistId);
        final Integer _tmpChecklistElementId;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklistElementId = null;
        } else {
          _tmpChecklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.setChecklistElementId(_tmpChecklistElementId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedCheckListPauseTimesEntity> getNonSyncedAssignedChecklistPauseTime() {
    final String _sql = "select AssociatedTable.* from assigned_checklist_pause_times AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfResumedByUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "resumed_by_user_id");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfIsPaused = CursorUtil.getColumnIndexOrThrow(_cursor, "is_paused");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<AssignedCheckListPauseTimesEntity> _result = new ArrayList<AssignedCheckListPauseTimesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedCheckListPauseTimesEntity _item;
        _item = new AssignedCheckListPauseTimesEntity();
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _item.assigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.user_id = null;
        } else {
          _item.user_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfResumedByUserId)) {
          _item.resumed_by_user_id = null;
        } else {
          _item.resumed_by_user_id = _cursor.getInt(_cursorIndexOfResumedByUserId);
        }
        _item.reason = _cursor.getString(_cursorIndexOfReason);
        if (_cursor.isNull(_cursorIndexOfIsPaused)) {
          _item.is_paused = null;
        } else {
          _item.is_paused = _cursor.getInt(_cursorIndexOfIsPaused);
        }
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIs_deleted(_tmpIs_deleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSync_status(_tmpSync_status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedDecisionEntity> getNonSyncedAssignedDecision() {
    final String _sql = "select AssociatedTable.* from assigned_decisions AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfDecisionId = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<AssignedDecisionEntity> _result = new ArrayList<AssignedDecisionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedDecisionEntity _item;
        _item = new AssignedDecisionEntity();
        _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _item.checklistElementId = null;
        } else {
          _item.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfDecisionId)) {
          _item.decisionId = null;
        } else {
          _item.decisionId = _cursor.getInt(_cursorIndexOfDecisionId);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _item.status = null;
        } else {
          _item.status = _cursor.getInt(_cursorIndexOfStatus);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserFavouritesEntity> getNonSyncedUserFavorites() {
    final String _sql = "select * from user_favorites where sync_status = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<UserFavouritesEntity> _result = new ArrayList<UserFavouritesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserFavouritesEntity _item;
        _item = new UserFavouritesEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUserId(_tmpUserId);
        final Integer _tmpChecklistId;
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _tmpChecklistId = null;
        } else {
          _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        _item.setChecklistId(_tmpChecklistId);
        final Integer _tmpIsDeleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIsDeleted = null;
        } else {
          _tmpIsDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIsDeleted(_tmpIsDeleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedNCWEntity> getNonSyncedAssignedNCW(final Integer ncwtype) {
    final String _sql = "select AssociatedTable.* from assigned_ncw  AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1 and AssociatedTable.item_type_id = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ncwtype == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, ncwtype);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfAcknowledged = CursorUtil.getColumnIndexOrThrow(_cursor, "acknowledged");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<AssignedNCWEntity> _result = new ArrayList<AssignedNCWEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedNCWEntity _item;
        _item = new AssignedNCWEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUserId(_tmpUserId);
        final Integer _tmpItemId;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItemId = null;
        } else {
          _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        _item.setItemId(_tmpItemId);
        final Integer _tmpItemTypeId;
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _tmpItemTypeId = null;
        } else {
          _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        _item.setItemTypeId(_tmpItemTypeId);
        final Integer _tmpChecklistElementId;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklistElementId = null;
        } else {
          _tmpChecklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.setChecklistElementId(_tmpChecklistElementId);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _item.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIs_deleted(_tmpIs_deleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSync_status(_tmpSync_status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedStepEntity> getNonSyncedAssignedStep() {
    final String _sql = "select AssociatedTable.* from assigned_steps  AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1 and AssociatedTable.status IN (0,1)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<AssignedStepEntity> _result = new ArrayList<AssignedStepEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedStepEntity _item;
        _item = new AssignedStepEntity();
        _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _item.checklistElementId = null;
        } else {
          _item.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _item.status = null;
        } else {
          _item.status = _cursor.getInt(_cursorIndexOfStatus);
        }
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _item.stepId = null;
        } else {
          _item.stepId = _cursor.getInt(_cursorIndexOfStepId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedStepEntity> getNonSyncedAssignedStepSkipDefer() {
    final String _sql = "select AssociatedTable.* from assigned_steps AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1 and AssociatedTable.status IN (2,3)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<AssignedStepEntity> _result = new ArrayList<AssignedStepEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedStepEntity _item;
        _item = new AssignedStepEntity();
        _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _item.checklistElementId = null;
        } else {
          _item.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _item.status = null;
        } else {
          _item.status = _cursor.getInt(_cursorIndexOfStatus);
        }
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _item.stepId = null;
        } else {
          _item.stepId = _cursor.getInt(_cursorIndexOfStepId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedLogoEntity> getNonSyncedAssignedLogo() {
    final String _sql = "select AssociatedTable.* from assigned_logos AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistLogoId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_logo_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<AssignedLogoEntity> _result = new ArrayList<AssignedLogoEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedLogoEntity _item;
        _item = new AssignedLogoEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpAssignedChecklistUuid;
        _tmpAssignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.setAssignedChecklistUuid(_tmpAssignedChecklistUuid);
        final Integer _tmpChecklistLogoId;
        if (_cursor.isNull(_cursorIndexOfChecklistLogoId)) {
          _tmpChecklistLogoId = null;
        } else {
          _tmpChecklistLogoId = _cursor.getInt(_cursorIndexOfChecklistLogoId);
        }
        _item.setChecklistLogoId(_tmpChecklistLogoId);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedChecklistCommentsEntity> getNonSyncedAssignedComment() {
    final String _sql = "select AssociatedTable.* from assigned_checklist_comments AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final List<AssignedChecklistCommentsEntity> _result = new ArrayList<AssignedChecklistCommentsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedChecklistCommentsEntity _item;
        _item = new AssignedChecklistCommentsEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUserId(_tmpUserId);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        _item.setComment(_tmpComment);
        final Integer _tmpIsDeleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIsDeleted = null;
        } else {
          _tmpIsDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIsDeleted(_tmpIsDeleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        final Integer _tmpChecklistId;
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _tmpChecklistId = null;
        } else {
          _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        _item.setChecklistId(_tmpChecklistId);
        final Integer _tmpChecklistElementId;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklistElementId = null;
        } else {
          _tmpChecklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.setChecklistElementId(_tmpChecklistElementId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedStepAttributesEntity> getNonSyncedAssignedStepAttribute() {
    final String _sql = "select AssociatedTable.* from assigned_step_attributes AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStepAttributeId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_attribute_id");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final List<AssignedStepAttributesEntity> _result = new ArrayList<AssignedStepAttributesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedStepAttributesEntity _item;
        _item = new AssignedStepAttributesEntity();
        _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _item.checklistElementId = null;
        } else {
          _item.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStepAttributeId)) {
          _item.stepAttributeId = null;
        } else {
          _item.stepAttributeId = _cursor.getInt(_cursorIndexOfStepAttributeId);
        }
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _item.stepId = null;
        } else {
          _item.stepId = _cursor.getInt(_cursorIndexOfStepId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _item.value = _cursor.getString(_cursorIndexOfValue);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<LogsEntity> getNonSyncedAssignedLogs() {
    final String _sql = "select AssociatedTable.* from logs AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfAssignedTo = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfAssignedToName = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_name");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfItemDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "item_description");
      final int _cursorIndexOfStepAction = CursorUtil.getColumnIndexOrThrow(_cursor, "step_action");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<LogsEntity> _result = new ArrayList<LogsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LogsEntity _item;
        _item = new LogsEntity();
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _item.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _item.checklistId = null;
        } else {
          _item.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _item.checklistElementId = null;
        } else {
          _item.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.action = _cursor.getString(_cursorIndexOfAction);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedTo)) {
          _item.assignedTo = null;
        } else {
          _item.assignedTo = _cursor.getInt(_cursorIndexOfAssignedTo);
        }
        _item.username = _cursor.getString(_cursorIndexOfUsername);
        _item.assignedToName = _cursor.getString(_cursorIndexOfAssignedToName);
        _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.itemDescription = _cursor.getString(_cursorIndexOfItemDescription);
        _item.stepAction = _cursor.getString(_cursorIndexOfStepAction);
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedStepFileResourceEntity> getNonSyncedAssignedStepResources() {
    final String _sql = "select AssociatedTable.* from assigned_step_resources AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_file_name");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<AssignedStepFileResourceEntity> _result = new ArrayList<AssignedStepFileResourceEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedStepFileResourceEntity _item;
        _item = new AssignedStepFileResourceEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpChecklist_element_id;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklist_element_id = null;
        } else {
          _tmpChecklist_element_id = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.setChecklist_element_id(_tmpChecklist_element_id);
        final Integer _tmpItem_type_id;
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _tmpItem_type_id = null;
        } else {
          _tmpItem_type_id = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        _item.setItem_type_id(_tmpItem_type_id);
        final Integer _tmpItem_id;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItem_id = null;
        } else {
          _tmpItem_id = _cursor.getInt(_cursorIndexOfItemId);
        }
        _item.setItem_id(_tmpItem_id);
        final String _tmpDisplay_file_name;
        _tmpDisplay_file_name = _cursor.getString(_cursorIndexOfDisplayFileName);
        _item.setDisplay_file_name(_tmpDisplay_file_name);
        final String _tmpFile_name;
        _tmpFile_name = _cursor.getString(_cursorIndexOfFileName);
        _item.setFile_name(_tmpFile_name);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        _item.setContent_type(_tmpContent_type);
        final String _tmpFile_md5_checksum;
        _tmpFile_md5_checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFile_md5_checksum(_tmpFile_md5_checksum);
        final Integer _tmpUser_id;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUser_id = null;
        } else {
          _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUser_id(_tmpUser_id);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIs_deleted(_tmpIs_deleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpIs_uploaded;
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _tmpIs_uploaded = null;
        } else {
          _tmpIs_uploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _item.setIs_uploaded(_tmpIs_uploaded);
        final Integer _tmpIs_downloaded;
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _tmpIs_downloaded = null;
        } else {
          _tmpIs_downloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        _item.setIs_downloaded(_tmpIs_downloaded);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSync_status(_tmpSync_status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignRoomEquipmentsEntity> getNonSyncedRoomAssets() {
    final String _sql = "select AssociatedTable.* from assigned_room_equipments  AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "room_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<AssignRoomEquipmentsEntity> _result = new ArrayList<AssignRoomEquipmentsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignRoomEquipmentsEntity _item;
        _item = new AssignRoomEquipmentsEntity();
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfEquipmentId)) {
          _item.equipmentId = null;
        } else {
          _item.equipmentId = _cursor.getInt(_cursorIndexOfEquipmentId);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfRoomId)) {
          _item.roomId = null;
        } else {
          _item.roomId = _cursor.getInt(_cursorIndexOfRoomId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getLastSyncTime(final Integer locationId) {
    final String _sql = "select last_sync_time from locations where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<String> getLiveLastSyncTime(final Integer locationId) {
    final String _sql = "select last_sync_time from locations where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"locations"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            _result = _cursor.getString(0);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getLiveLastSyncStatus(final Integer locationId) {
    final String _sql = "select last_sync_status from locations where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"locations"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getInt(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int getLastSyncStatus(final Integer locationId) {
    final String _sql = "select last_sync_status from locations where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserSuggestionEntity> getNonSyncedUserSuggestion() {
    final String _sql = "select * from user_suggestions where sync_status = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final List<UserSuggestionEntity> _result = new ArrayList<UserSuggestionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserSuggestionEntity _item;
        _item = new UserSuggestionEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final Integer _tmpUser_id;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUser_id = null;
        } else {
          _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUser_id(_tmpUser_id);
        final String _tmpAssignedChecklistUuid;
        _tmpAssignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.setAssignedChecklistUuid(_tmpAssignedChecklistUuid);
        final Integer _tmpChecklistId;
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _tmpChecklistId = null;
        } else {
          _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        _item.setChecklistId(_tmpChecklistId);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final Integer _tmpIsDeleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIsDeleted = null;
        } else {
          _tmpIsDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIsDeleted(_tmpIsDeleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        final Integer _tmpChecklistElementId;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklistElementId = null;
        } else {
          _tmpChecklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.setChecklistElementId(_tmpChecklistElementId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserSuggestionAttachmentsEntity> getNonSyncedUserSuggestionAttachments() {
    final String _sql = "select * from user_suggestion_attachments where sync_status = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfUserSuggestionUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "user_suggestion_uuid");
      final int _cursorIndexOfDisplayFilename = CursorUtil.getColumnIndexOrThrow(_cursor, "display_filename");
      final int _cursorIndexOfFilename = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfFilesize = CursorUtil.getColumnIndexOrThrow(_cursor, "filesize");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<UserSuggestionAttachmentsEntity> _result = new ArrayList<UserSuggestionAttachmentsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserSuggestionAttachmentsEntity _item;
        _item = new UserSuggestionAttachmentsEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpUser_suggestion_uuid;
        _tmpUser_suggestion_uuid = _cursor.getString(_cursorIndexOfUserSuggestionUuid);
        _item.setUser_suggestion_uuid(_tmpUser_suggestion_uuid);
        final String _tmpDisplay_filename;
        _tmpDisplay_filename = _cursor.getString(_cursorIndexOfDisplayFilename);
        _item.setDisplay_filename(_tmpDisplay_filename);
        final String _tmpFilename;
        _tmpFilename = _cursor.getString(_cursorIndexOfFilename);
        _item.setFilename(_tmpFilename);
        final Integer _tmpFilesize;
        if (_cursor.isNull(_cursorIndexOfFilesize)) {
          _tmpFilesize = null;
        } else {
          _tmpFilesize = _cursor.getInt(_cursorIndexOfFilesize);
        }
        _item.setFilesize(_tmpFilesize);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        _item.setContent_type(_tmpContent_type);
        final Integer _tmpUser_id;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUser_id = null;
        } else {
          _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUser_id(_tmpUser_id);
        final String _tmpFile_md5_checksum;
        _tmpFile_md5_checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFile_md5_checksum(_tmpFile_md5_checksum);
        final Integer _tmpIs_uploaded;
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _tmpIs_uploaded = null;
        } else {
          _tmpIs_uploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _item.setIs_uploaded(_tmpIs_uploaded);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSync_status(_tmpSync_status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WorkOrderEntity> getNonSyncedWorkOrders(final Integer locationId) {
    final String _sql = "SELECT Workorder.* FROM workorders Workorder  LEFT JOIN workorder_attachments WorkorderAttachment ON (WorkorderAttachment.workorder_id = Workorder.id AND WorkorderAttachment.sync_status = 0)  LEFT JOIN workorder_notes WorkorderNote ON (WorkorderNote.workorder_id = Workorder.id AND WorkorderNote.sync_status = 0)  LEFT JOIN workorder_note_details WorkorderNoteDetail ON (WorkorderNoteDetail.workorder_note_id = WorkorderNote.id AND WorkorderNoteDetail.sync_status = 0)  WHERE Workorder.location_id = ? AND (Workorder.sync_status = 0 OR WorkorderAttachment.sync_status = 0 OR WorkorderNote.sync_status = 0 OR WorkorderNoteDetail.sync_status = 0)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "due_date");
      final int _cursorIndexOfWorkorderStatusId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_status_id");
      final int _cursorIndexOfAssignedToId = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_id");
      final int _cursorIndexOfAssignedToType = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_type");
      final int _cursorIndexOfWorkorderPriorityId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_priority_id");
      final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "author_id");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfWorkorderBillingTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_billing_type_id");
      final int _cursorIndexOfLocationEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_equipment_id");
      final int _cursorIndexOfLocationRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_room_id");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
      final int _cursorIndexOfClosedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "closed_date");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfExecutionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "execution_status");
      final List<WorkOrderEntity> _result = new ArrayList<WorkOrderEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WorkOrderEntity _item;
        _item = new WorkOrderEntity();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _item.title = _cursor.getString(_cursorIndexOfTitle);
        _item.description = _cursor.getString(_cursorIndexOfDescription);
        _item.dueDate = _cursor.getString(_cursorIndexOfDueDate);
        if (_cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
          _item.workorderStatusId = null;
        } else {
          _item.workorderStatusId = _cursor.getInt(_cursorIndexOfWorkorderStatusId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedToId)) {
          _item.assignedToId = null;
        } else {
          _item.assignedToId = _cursor.getInt(_cursorIndexOfAssignedToId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedToType)) {
          _item.assignedToType = null;
        } else {
          _item.assignedToType = _cursor.getInt(_cursorIndexOfAssignedToType);
        }
        if (_cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
          _item.workorderPriorityId = null;
        } else {
          _item.workorderPriorityId = _cursor.getInt(_cursorIndexOfWorkorderPriorityId);
        }
        if (_cursor.isNull(_cursorIndexOfAuthorId)) {
          _item.authorId = null;
        } else {
          _item.authorId = _cursor.getInt(_cursorIndexOfAuthorId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _item.locationId = null;
        } else {
          _item.locationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _item.checklistId = null;
        } else {
          _item.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfWorkorderBillingTypeId)) {
          _item.workorderBillingTypeId = null;
        } else {
          _item.workorderBillingTypeId = _cursor.getInt(_cursorIndexOfWorkorderBillingTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationEquipmentId)) {
          _item.locationEquipmentId = null;
        } else {
          _item.locationEquipmentId = _cursor.getInt(_cursorIndexOfLocationEquipmentId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationRoomId)) {
          _item.locationRoomId = null;
        } else {
          _item.locationRoomId = _cursor.getInt(_cursorIndexOfLocationRoomId);
        }
        _item.startDate = _cursor.getString(_cursorIndexOfStartDate);
        _item.closedDate = _cursor.getString(_cursorIndexOfClosedDate);
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfExecutionStatus)) {
          _item.executionStatus = null;
        } else {
          _item.executionStatus = _cursor.getInt(_cursorIndexOfExecutionStatus);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WorkOrderAttachmentsEntity> getNonSyncedWorkOrdersAttachments(final Integer id) {
    final String _sql = "select * from workorder_attachments where workorder_id = ?  and sync_status = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfWorkorderId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_id");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_filename");
      final int _cursorIndexOfFilename = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfFilesize = CursorUtil.getColumnIndexOrThrow(_cursor, "filesize");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "author_id");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final List<WorkOrderAttachmentsEntity> _result = new ArrayList<WorkOrderAttachmentsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WorkOrderAttachmentsEntity _item;
        _item = new WorkOrderAttachmentsEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final Integer _tmpWorkorderId;
        if (_cursor.isNull(_cursorIndexOfWorkorderId)) {
          _tmpWorkorderId = null;
        } else {
          _tmpWorkorderId = _cursor.getInt(_cursorIndexOfWorkorderId);
        }
        _item.setWorkorderId(_tmpWorkorderId);
        final String _tmpDisplayFileName;
        _tmpDisplayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
        _item.setDisplayFileName(_tmpDisplayFileName);
        final String _tmpFilename;
        _tmpFilename = _cursor.getString(_cursorIndexOfFilename);
        _item.setFilename(_tmpFilename);
        final Long _tmpFilesize;
        if (_cursor.isNull(_cursorIndexOfFilesize)) {
          _tmpFilesize = null;
        } else {
          _tmpFilesize = _cursor.getLong(_cursorIndexOfFilesize);
        }
        _item.setFilesize(_tmpFilesize);
        final String _tmpContentType;
        _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
        _item.setContentType(_tmpContentType);
        final Integer _tmpAuthorId;
        if (_cursor.isNull(_cursorIndexOfAuthorId)) {
          _tmpAuthorId = null;
        } else {
          _tmpAuthorId = _cursor.getInt(_cursorIndexOfAuthorId);
        }
        _item.setAuthorId(_tmpAuthorId);
        final String _tmpFileMd5Checksum;
        _tmpFileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFileMd5Checksum(_tmpFileMd5Checksum);
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _item.isDownloaded = null;
        } else {
          _item.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _item.isUploaded = null;
        } else {
          _item.isUploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WorkOrderNotesEntity> getNonSyncedWorkOrdersNotes(final Integer id) {
    final String _sql = "select * from workorder_notes where workorder_id = ? and sync_status = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfWorkorderId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfWorkorderNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_notes");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final List<WorkOrderNotesEntity> _result = new ArrayList<WorkOrderNotesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WorkOrderNotesEntity _item;
        _item = new WorkOrderNotesEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final Integer _tmpWorkorderId;
        if (_cursor.isNull(_cursorIndexOfWorkorderId)) {
          _tmpWorkorderId = null;
        } else {
          _tmpWorkorderId = _cursor.getInt(_cursorIndexOfWorkorderId);
        }
        _item.setWorkorderId(_tmpWorkorderId);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUserId(_tmpUserId);
        final String _tmpWorkorderNotes;
        _tmpWorkorderNotes = _cursor.getString(_cursorIndexOfWorkorderNotes);
        _item.setWorkorderNotes(_tmpWorkorderNotes);
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WorkOrderNoteDetailEntity> getNonSyncedWorkOrdersNotesDetail(final Integer id) {
    final String _sql = "select * from workorder_note_details where workorder_note_id = ?  and sync_status = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfWorkorderNoteId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_note_id");
      final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "property");
      final int _cursorIndexOfPropertyKey = CursorUtil.getColumnIndexOrThrow(_cursor, "property_key");
      final int _cursorIndexOfOldValue = CursorUtil.getColumnIndexOrThrow(_cursor, "old_value");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final List<WorkOrderNoteDetailEntity> _result = new ArrayList<WorkOrderNoteDetailEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WorkOrderNoteDetailEntity _item;
        _item = new WorkOrderNoteDetailEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final Integer _tmpWorkorderNoteId;
        if (_cursor.isNull(_cursorIndexOfWorkorderNoteId)) {
          _tmpWorkorderNoteId = null;
        } else {
          _tmpWorkorderNoteId = _cursor.getInt(_cursorIndexOfWorkorderNoteId);
        }
        _item.setWorkorderNoteId(_tmpWorkorderNoteId);
        final String _tmpProperty;
        _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
        _item.setProperty(_tmpProperty);
        final String _tmpPropertyKey;
        _tmpPropertyKey = _cursor.getString(_cursorIndexOfPropertyKey);
        _item.setPropertyKey(_tmpPropertyKey);
        final String _tmpOldValue;
        _tmpOldValue = _cursor.getString(_cursorIndexOfOldValue);
        _item.setOldValue(_tmpOldValue);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        _item.setValue(_tmpValue);
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignedStepFileResourceEntity> getResourceForUpload() {
    final String _sql = "select * from assigned_step_resources  WHERE is_uploaded = 0 AND sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_file_name");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<AssignedStepFileResourceEntity> _result = new ArrayList<AssignedStepFileResourceEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedStepFileResourceEntity _item;
        _item = new AssignedStepFileResourceEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _item.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpChecklist_element_id;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklist_element_id = null;
        } else {
          _tmpChecklist_element_id = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.setChecklist_element_id(_tmpChecklist_element_id);
        final Integer _tmpItem_type_id;
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _tmpItem_type_id = null;
        } else {
          _tmpItem_type_id = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        _item.setItem_type_id(_tmpItem_type_id);
        final Integer _tmpItem_id;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItem_id = null;
        } else {
          _tmpItem_id = _cursor.getInt(_cursorIndexOfItemId);
        }
        _item.setItem_id(_tmpItem_id);
        final String _tmpDisplay_file_name;
        _tmpDisplay_file_name = _cursor.getString(_cursorIndexOfDisplayFileName);
        _item.setDisplay_file_name(_tmpDisplay_file_name);
        final String _tmpFile_name;
        _tmpFile_name = _cursor.getString(_cursorIndexOfFileName);
        _item.setFile_name(_tmpFile_name);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        _item.setContent_type(_tmpContent_type);
        final String _tmpFile_md5_checksum;
        _tmpFile_md5_checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFile_md5_checksum(_tmpFile_md5_checksum);
        final Integer _tmpUser_id;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUser_id = null;
        } else {
          _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUser_id(_tmpUser_id);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIs_deleted(_tmpIs_deleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpIs_uploaded;
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _tmpIs_uploaded = null;
        } else {
          _tmpIs_uploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _item.setIs_uploaded(_tmpIs_uploaded);
        final Integer _tmpIs_downloaded;
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _tmpIs_downloaded = null;
        } else {
          _tmpIs_downloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        _item.setIs_downloaded(_tmpIs_downloaded);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSync_status(_tmpSync_status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WorkOrderAttachmentsEntity> getWorkorderAttachmentForUpload() {
    final String _sql = "select * from workorder_attachments  WHERE is_uploaded = 0 AND sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfWorkorderId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_id");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_filename");
      final int _cursorIndexOfFilename = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfFilesize = CursorUtil.getColumnIndexOrThrow(_cursor, "filesize");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "author_id");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final List<WorkOrderAttachmentsEntity> _result = new ArrayList<WorkOrderAttachmentsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WorkOrderAttachmentsEntity _item;
        _item = new WorkOrderAttachmentsEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final Integer _tmpWorkorderId;
        if (_cursor.isNull(_cursorIndexOfWorkorderId)) {
          _tmpWorkorderId = null;
        } else {
          _tmpWorkorderId = _cursor.getInt(_cursorIndexOfWorkorderId);
        }
        _item.setWorkorderId(_tmpWorkorderId);
        final String _tmpDisplayFileName;
        _tmpDisplayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
        _item.setDisplayFileName(_tmpDisplayFileName);
        final String _tmpFilename;
        _tmpFilename = _cursor.getString(_cursorIndexOfFilename);
        _item.setFilename(_tmpFilename);
        final Long _tmpFilesize;
        if (_cursor.isNull(_cursorIndexOfFilesize)) {
          _tmpFilesize = null;
        } else {
          _tmpFilesize = _cursor.getLong(_cursorIndexOfFilesize);
        }
        _item.setFilesize(_tmpFilesize);
        final String _tmpContentType;
        _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
        _item.setContentType(_tmpContentType);
        final Integer _tmpAuthorId;
        if (_cursor.isNull(_cursorIndexOfAuthorId)) {
          _tmpAuthorId = null;
        } else {
          _tmpAuthorId = _cursor.getInt(_cursorIndexOfAuthorId);
        }
        _item.setAuthorId(_tmpAuthorId);
        final String _tmpFileMd5Checksum;
        _tmpFileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFileMd5Checksum(_tmpFileMd5Checksum);
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _item.isDownloaded = null;
        } else {
          _item.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _item.isUploaded = null;
        } else {
          _item.isUploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserSuggestionAttachmentsEntity> getUserSuggestionAttachmentForUpload() {
    final String _sql = "select * from user_suggestion_attachments  WHERE is_uploaded = 0 AND sync_status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfUserSuggestionUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "user_suggestion_uuid");
      final int _cursorIndexOfDisplayFilename = CursorUtil.getColumnIndexOrThrow(_cursor, "display_filename");
      final int _cursorIndexOfFilename = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfFilesize = CursorUtil.getColumnIndexOrThrow(_cursor, "filesize");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<UserSuggestionAttachmentsEntity> _result = new ArrayList<UserSuggestionAttachmentsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserSuggestionAttachmentsEntity _item;
        _item = new UserSuggestionAttachmentsEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpUser_suggestion_uuid;
        _tmpUser_suggestion_uuid = _cursor.getString(_cursorIndexOfUserSuggestionUuid);
        _item.setUser_suggestion_uuid(_tmpUser_suggestion_uuid);
        final String _tmpDisplay_filename;
        _tmpDisplay_filename = _cursor.getString(_cursorIndexOfDisplayFilename);
        _item.setDisplay_filename(_tmpDisplay_filename);
        final String _tmpFilename;
        _tmpFilename = _cursor.getString(_cursorIndexOfFilename);
        _item.setFilename(_tmpFilename);
        final Integer _tmpFilesize;
        if (_cursor.isNull(_cursorIndexOfFilesize)) {
          _tmpFilesize = null;
        } else {
          _tmpFilesize = _cursor.getInt(_cursorIndexOfFilesize);
        }
        _item.setFilesize(_tmpFilesize);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        _item.setContent_type(_tmpContent_type);
        final Integer _tmpUser_id;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUser_id = null;
        } else {
          _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUser_id(_tmpUser_id);
        final String _tmpFile_md5_checksum;
        _tmpFile_md5_checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFile_md5_checksum(_tmpFile_md5_checksum);
        final Integer _tmpIs_uploaded;
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _tmpIs_uploaded = null;
        } else {
          _tmpIs_uploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _item.setIs_uploaded(_tmpIs_uploaded);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSync_status(_tmpSync_status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
