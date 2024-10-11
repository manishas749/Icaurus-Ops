package com.icarus.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.UserSuggestionEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserSuggestionDao_Impl extends UserSuggestionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserSuggestionEntity> __insertionAdapterOfUserSuggestionEntity;

  private final EntityInsertionAdapter<UserSuggestionAttachmentsEntity> __insertionAdapterOfUserSuggestionAttachmentsEntity;

  public UserSuggestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserSuggestionEntity = new EntityInsertionAdapter<UserSuggestionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user_suggestions` (`uuid`,`user_id`,`assigned_checklist_uuid`,`checklist_id`,`description`,`is_deleted`,`created`,`modified`,`sync_status`,`checklist_element_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserSuggestionEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getUser_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUser_id());
        }
        if (value.getAssignedChecklistUuid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAssignedChecklistUuid());
        }
        if (value.getChecklistId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getChecklistId());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescription());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getIsDeleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getModified());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getSyncStatus());
        }
        if (value.getChecklistElementId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getChecklistElementId());
        }
      }
    };
    this.__insertionAdapterOfUserSuggestionAttachmentsEntity = new EntityInsertionAdapter<UserSuggestionAttachmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user_suggestion_attachments` (`uuid`,`user_suggestion_uuid`,`display_filename`,`filename`,`filesize`,`content_type`,`user_id`,`file_md5_checksum`,`is_uploaded`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
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
      }
    };
  }

  @Override
  public void insertUserSuggestion(final UserSuggestionEntity userSuggestionEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserSuggestionEntity.insert(userSuggestionEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertUserSuggestionAttachment(
      final UserSuggestionAttachmentsEntity userSuggestionAttachments) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserSuggestionAttachmentsEntity.insert(userSuggestionAttachments);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addUserSuggestions(final UserSuggestionEntity userSuggestionEntity,
      final UserSuggestionAttachmentsEntity userSuggestionAttachments) {
    __db.beginTransaction();
    try {
      UserSuggestionDao_Impl.super.addUserSuggestions(userSuggestionEntity, userSuggestionAttachments);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
