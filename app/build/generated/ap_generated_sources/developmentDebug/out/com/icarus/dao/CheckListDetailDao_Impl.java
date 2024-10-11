package com.icarus.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CheckListDetailDao_Impl implements CheckListDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AssignedCheckListPauseTimesEntity> __insertionAdapterOfAssignedCheckListPauseTimesEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingElementCount;

  public CheckListDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAssignedCheckListPauseTimesEntity = new EntityInsertionAdapter<AssignedCheckListPauseTimesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_checklist_pause_times` (`uuid`,`assigned_checklist_uuid`,`user_id`,`resumed_by_user_id`,`reason`,`is_paused`,`is_deleted`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedCheckListPauseTimesEntity value) {
        if (value.uuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uuid);
        }
        if (value.assigned_checklist_uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.assigned_checklist_uuid);
        }
        if (value.user_id == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.user_id);
        }
        if (value.resumed_by_user_id == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.resumed_by_user_id);
        }
        if (value.reason == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.reason);
        }
        if (value.is_paused == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.is_paused);
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getIs_deleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getModified());
        }
        if (value.getSync_status() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getSync_status());
        }
      }
    };
    this.__preparedStmtOfUpdateAssignedChecklistPendingElementCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET pending_elements_count = pending_elements_count + 1 where uuid = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertAssignedCheckListPauseTimesEntity(
      final AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedCheckListPauseTimesEntity.insert(assignedCheckListPauseTimesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
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
  public DataSource.Factory<Integer, ChecklistElementItem> getCheckListDetail(
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS (\n"
            + "        SELECT\n"
            + "            checklist_elements.id,\n"
            + "            checklist_elements.parent_id,\n"
            + "            checklist_elements.checklist_id,\n"
            + "            checklist_elements.item_id,\n"
            + "            checklist_elements.item_type_id,\n"
            + "            checklist_elements.item_uuid,\n"
            + "            checklist_elements.title,\n"
            + "            checklist_elements.description,\n"
            + "            checklist_elements.sequence_no,\n"
            + "            COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged, (SELECT \"action\" FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND \"action\" IN ( 17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1)) AS status,\n"
            + "            checklist_elements.sort_order,\n"
            + "            checklist_elements.id AS rootid,\n"
            + "            0 AS level\n"
            + "        FROM checklist_elements\n"
            + "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?)\n"
            + "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?)\n"
            + "        LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = ?)\n"
            + "        WHERE\n"
            + "            checklist_elements.checklist_id = ?\n"
            + "        AND checklist_elements.is_deleted = 0\n"
            + "        AND checklist_elements.item_type_id NOT IN ( 9 )\n"
            + "            UNION ALL\n"
            + "        SELECT \n"
            + "            checklist_elements.id,\n"
            + "            checklist_elements.parent_id,\n"
            + "            checklist_elements.checklist_id,\n"
            + "            checklist_elements.item_id,\n"
            + "            checklist_elements.item_type_id,\n"
            + "            checklist_elements.item_uuid,\n"
            + "            checklist_elements.title,\n"
            + "            checklist_elements.description,\n"
            + "            checklist_elements.sequence_no,\n"
            + "            COALESCE(assigned_steps.status, assigned_decisions.status) AS status,\n"
            + "            checklist_elements.sort_order,\n"
            + "            elements.rootid,\n"
            + "            level + 1 AS level\n"
            + "        FROM checklist_elements, elements\n"
            + "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?)\n"
            + "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?)\n"
            + "        WHERE checklist_elements.id = elements.parent_id\n"
            + ")\n"
            + "SELECT\n"
            + "    id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n"
            + "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title,\n"
            + "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description,\n"
            + "    sequence_no, status, sort_order,\n"
            + "    (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon,\n"
            + "    (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon,\n"
            + "    rootid, level,\n"
            + "    SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents,\n"
            + "    SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( 0, 1 ) OR status IS NULL) ) ) THEN 1 ELSE 0 END) AS total_executed_parents,\n"
            + "    SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent\n"
            + "FROM elements\n"
            + "LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.\"action\" = 19 AND placeholders_text.assigned_checklist_uuid = ?)\n"
            + "GROUP BY rootid\n"
            + "HAVING total_parents = total_executed_parents AND MIN(level) = 0\n"
            + "ORDER BY sort_order";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 8;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    return new DataSource.Factory<Integer, ChecklistElementItem>() {
      @Override
      public LimitOffsetDataSource<ChecklistElementItem> create() {
        return new LimitOffsetDataSource<ChecklistElementItem>(__db, _statement, false , "logs", "checklist_elements", "assigned_steps", "assigned_decisions", "assigned_ncw", "checklist_ppes", "ppes", "ncw_hazards", "hazards") {
          @Override
          protected List<ChecklistElementItem> convertRows(Cursor cursor) {
            final int _cursorIndexOfElementId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(cursor, "parent_id");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(cursor, "item_id");
            final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "item_type_id");
            final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(cursor, "item_uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfSequenceNo = CursorUtil.getColumnIndexOrThrow(cursor, "sequence_no");
            final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(cursor, "status");
            final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(cursor, "sort_order");
            final int _cursorIndexOfPpesIcon = CursorUtil.getColumnIndexOrThrow(cursor, "ppes_icon");
            final int _cursorIndexOfHazardsIcon = CursorUtil.getColumnIndexOrThrow(cursor, "hazards_icon");
            final int _cursorIndexOfRootId = CursorUtil.getColumnIndexOrThrow(cursor, "rootid");
            final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(cursor, "level");
            final int _cursorIndexOfTotalParents = CursorUtil.getColumnIndexOrThrow(cursor, "total_parents");
            final int _cursorIndexOfTotalExecutedParents = CursorUtil.getColumnIndexOrThrow(cursor, "total_executed_parents");
            final int _cursorIndexOfHasStepParent = CursorUtil.getColumnIndexOrThrow(cursor, "has_step_parent");
            final List<ChecklistElementItem> _res = new ArrayList<ChecklistElementItem>(cursor.getCount());
            while(cursor.moveToNext()) {
              final ChecklistElementItem _item;
              _item = new ChecklistElementItem();
              final int _tmpElementId;
              _tmpElementId = cursor.getInt(_cursorIndexOfElementId);
              _item.setElementId(_tmpElementId);
              final int _tmpParentId;
              _tmpParentId = cursor.getInt(_cursorIndexOfParentId);
              _item.setParentId(_tmpParentId);
              final int _tmpChecklistId;
              _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              _item.setChecklistId(_tmpChecklistId);
              final int _tmpItemId;
              _tmpItemId = cursor.getInt(_cursorIndexOfItemId);
              _item.setItemId(_tmpItemId);
              final int _tmpItemTypeId;
              _tmpItemTypeId = cursor.getInt(_cursorIndexOfItemTypeId);
              _item.setItemTypeId(_tmpItemTypeId);
              final String _tmpItemUuid;
              _tmpItemUuid = cursor.getString(_cursorIndexOfItemUuid);
              _item.setItemUuid(_tmpItemUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _item.setDescription(_tmpDescription);
              final String _tmpSequenceNo;
              _tmpSequenceNo = cursor.getString(_cursorIndexOfSequenceNo);
              _item.setSequenceNo(_tmpSequenceNo);
              final Integer _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getInt(_cursorIndexOfStatus);
              }
              _item.setStatus(_tmpStatus);
              final int _tmpSortOrder;
              _tmpSortOrder = cursor.getInt(_cursorIndexOfSortOrder);
              _item.setSortOrder(_tmpSortOrder);
              final String _tmpPpesIcon;
              _tmpPpesIcon = cursor.getString(_cursorIndexOfPpesIcon);
              _item.setPpesIcon(_tmpPpesIcon);
              final String _tmpHazardsIcon;
              _tmpHazardsIcon = cursor.getString(_cursorIndexOfHazardsIcon);
              _item.setHazardsIcon(_tmpHazardsIcon);
              final int _tmpRootId;
              _tmpRootId = cursor.getInt(_cursorIndexOfRootId);
              _item.setRootId(_tmpRootId);
              final int _tmpLevel;
              _tmpLevel = cursor.getInt(_cursorIndexOfLevel);
              _item.setLevel(_tmpLevel);
              final int _tmpTotalParents;
              _tmpTotalParents = cursor.getInt(_cursorIndexOfTotalParents);
              _item.setTotalParents(_tmpTotalParents);
              final int _tmpTotalExecutedParents;
              _tmpTotalExecutedParents = cursor.getInt(_cursorIndexOfTotalExecutedParents);
              _item.setTotalExecutedParents(_tmpTotalExecutedParents);
              final boolean _tmpHasStepParent;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfHasStepParent);
              _tmpHasStepParent = _tmp != 0;
              _item.setHasStepParent(_tmpHasStepParent);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, ChecklistDetailItems> getChecklistIncompleteElements(
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + "ChecklistElement.checklist_id,\n"
            + "ChecklistElement.id,\n"
            + "ChecklistElement.item_type_id,\n"
            + "ChecklistElement.item_id,\n"
            + "ChecklistElement.item_uuid,\n"
            + "ChecklistElement.parent_id,\n"
            + "ParentElement.item_type_id AS parent_type,\n"
            + "ParentStep.status AS parent_status,\n"
            + "ChecklistElement.sort_order,\n"
            + "ChecklistElement.sequence_no,\n"
            + "IFNULL(CASE WHEN ChecklistElement.item_type_id IN ( 1, 8, 12,10 ) THEN\n"
            + "coalesce(PlaceholderText.item_description, ChecklistElement.title) ELSE COALESCE(EmbeddedImage.file_md5_checksum, ChecklistElement.title)\n"
            + "END, '') AS title,\n"
            + "IFNULL(CASE WHEN ChecklistElement.item_type_id IN ( 1, 8, 12,10 ) THEN\n"
            + "coalesce(PlaceholderText.step_action, ChecklistElement.description) ELSE coalesce(PlaceholderText.item_description, ChecklistElement.description)\n"
            + "END, '') AS description,\n"
            + "AssignedNCW.acknowledged,\n"
            + "AssignedStep.status,\n"
            + "AssignedDecision.status AS decisionStatus,\n"
            + "(SELECT action FROM logs WHERE checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) AND action IN (12,13,17,18) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus,\n"
            + "(SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = ChecklistElement.item_id AND ChecklistElement.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon,\n"
            + "(SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = ChecklistElement.item_id AND ncw_hazards.item_type_id = ChecklistElement.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon\n"
            + "FROM\n"
            + "checklist_elements AS ChecklistElement\n"
            + "LEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = ChecklistElement.parent_id)\n"
            + "LEFT JOIN resources AS EmbeddedImage ON (EmbeddedImage.id = ChecklistElement.item_id AND ChecklistElement.item_type_id = 10 AND EmbeddedImage.is_resource = 1)\n"
            + "\n"
            + "LEFT JOIN assigned_ncw AS AssignedNCW ON ( AssignedNCW.checklist_element_id = ChecklistElement.id AND AssignedNCW.assigned_checklist_uuid = ? AND AssignedNCW.is_deleted = 0 )\n"
            + "LEFT JOIN assigned_steps AS AssignedStep ON ( AssignedStep.checklist_element_id = ChecklistElement.id AND AssignedStep.assigned_checklist_uuid = ? AND AssignedStep.is_deleted = 0 )\n"
            + "LEFT JOIN assigned_decisions AS AssignedDecision ON ( AssignedDecision.checklist_element_id = ChecklistElement.id AND AssignedDecision.assigned_checklist_uuid = ? AND AssignedDecision.is_deleted = 0 )\n"
            + "LEFT JOIN logs AS PlaceholderText ON ( PlaceholderText.checklist_element_id = ChecklistElement.id AND PlaceholderText.action = 19 AND PlaceholderText.assigned_checklist_uuid = ? )\n"
            + "LEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ParentElement.id AND ParentStep.assigned_checklist_uuid = ? AND ParentStep.is_deleted = 0 )\n"
            + "\n"
            + "WHERE\n"
            + "ChecklistElement.checklist_id = ?\n"
            + "AND ChecklistElement.is_deleted = 0\n"
            + "AND ChecklistElement.item_type_id NOT IN ( 9 )\n"
            + "AND (ChecklistElement.parent_id IS NULL OR parent_type = 2)\n"
            + "AND (imageTextStatus IS NULL OR imageTextStatus = 13)\n"
            + "AND (\n"
            + "(\n"
            + "WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n"
            + "SELECT id,parent_id,item_type_id\n"
            + "FROM checklist_elements g\n"
            + "WHERE id = ChecklistElement.id\n"
            + "UNION ALL\n"
            + "SELECT c.id,c.parent_id,c.item_type_id\n"
            + "FROM checklist_path AS cp\n"
            + "JOIN checklist_elements AS c ON cp.parent_id = c.id\n"
            + ")\n"
            + "SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id\n"
            + ") IS NULL OR\n"
            + "(\n"
            + "WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n"
            + "SELECT g.id,g.parent_id,g.item_type_id\n"
            + "FROM checklist_elements g\n"
            + "WHERE g.id = ChecklistElement.id\n"
            + "UNION ALL\n"
            + "SELECT c.id,c.parent_id,c.item_type_id\n"
            + "FROM checklist_path AS cp JOIN checklist_elements AS c ON cp.parent_id = c.id\n"
            + ")\n"
            + "SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id\n"
            + ") IN (SELECT checklist_element_id FROM assigned_decisions WHERE status = 1 AND assigned_decisions.assigned_checklist_uuid = ? AND is_deleted = 0))\n"
            + "AND COALESCE(acknowledged, AssignedStep.status, decisionStatus, -1) IN (-1, 3)\n"
            + "\n"
            + "ORDER BY\n"
            + "ChecklistElement.sort_order ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 8;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    return new DataSource.Factory<Integer, ChecklistDetailItems>() {
      @Override
      public LimitOffsetDataSource<ChecklistDetailItems> create() {
        return new LimitOffsetDataSource<ChecklistDetailItems>(__db, _statement, false , "logs", "checklist_ppes", "ppes", "ncw_hazards", "hazards", "checklist_elements", "resources", "assigned_ncw", "assigned_steps", "assigned_decisions") {
          @Override
          protected List<ChecklistDetailItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfElementId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "item_type_id");
            final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(cursor, "item_id");
            final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(cursor, "item_uuid");
            final int _cursorIndexOfParentItemId = CursorUtil.getColumnIndexOrThrow(cursor, "parent_id");
            final int _cursorIndexOfParentType = CursorUtil.getColumnIndexOrThrow(cursor, "parent_type");
            final int _cursorIndexOfParentStatus = CursorUtil.getColumnIndexOrThrow(cursor, "parent_status");
            final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(cursor, "sort_order");
            final int _cursorIndexOfSequenceNo = CursorUtil.getColumnIndexOrThrow(cursor, "sequence_no");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfAcknowledged = CursorUtil.getColumnIndexOrThrow(cursor, "acknowledged");
            final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(cursor, "status");
            final int _cursorIndexOfDecisionStatus = CursorUtil.getColumnIndexOrThrow(cursor, "decisionStatus");
            final int _cursorIndexOfImageTextStatus = CursorUtil.getColumnIndexOrThrow(cursor, "imageTextStatus");
            final int _cursorIndexOfPpesIcon = CursorUtil.getColumnIndexOrThrow(cursor, "ppes_icon");
            final int _cursorIndexOfHazardsIcon = CursorUtil.getColumnIndexOrThrow(cursor, "hazards_icon");
            final List<ChecklistDetailItems> _res = new ArrayList<ChecklistDetailItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final ChecklistDetailItems _item;
              _item = new ChecklistDetailItems();
              final int _tmpChecklistId;
              _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              _item.setChecklistId(_tmpChecklistId);
              final int _tmpElementId;
              _tmpElementId = cursor.getInt(_cursorIndexOfElementId);
              _item.setElementId(_tmpElementId);
              final int _tmpItemTypeId;
              _tmpItemTypeId = cursor.getInt(_cursorIndexOfItemTypeId);
              _item.setItemTypeId(_tmpItemTypeId);
              final int _tmpItemId;
              _tmpItemId = cursor.getInt(_cursorIndexOfItemId);
              _item.setItemId(_tmpItemId);
              final String _tmpItemUuid;
              _tmpItemUuid = cursor.getString(_cursorIndexOfItemUuid);
              _item.setItemUuid(_tmpItemUuid);
              final int _tmpParentItemId;
              _tmpParentItemId = cursor.getInt(_cursorIndexOfParentItemId);
              _item.setParentItemId(_tmpParentItemId);
              final Integer _tmpParentType;
              if (cursor.isNull(_cursorIndexOfParentType)) {
                _tmpParentType = null;
              } else {
                _tmpParentType = cursor.getInt(_cursorIndexOfParentType);
              }
              _item.setParentType(_tmpParentType);
              final Integer _tmpParentStatus;
              if (cursor.isNull(_cursorIndexOfParentStatus)) {
                _tmpParentStatus = null;
              } else {
                _tmpParentStatus = cursor.getInt(_cursorIndexOfParentStatus);
              }
              _item.setParentStatus(_tmpParentStatus);
              final int _tmpSortOrder;
              _tmpSortOrder = cursor.getInt(_cursorIndexOfSortOrder);
              _item.setSortOrder(_tmpSortOrder);
              final String _tmpSequenceNo;
              _tmpSequenceNo = cursor.getString(_cursorIndexOfSequenceNo);
              _item.setSequenceNo(_tmpSequenceNo);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _item.setDescription(_tmpDescription);
              final Integer _tmpAcknowledged;
              if (cursor.isNull(_cursorIndexOfAcknowledged)) {
                _tmpAcknowledged = null;
              } else {
                _tmpAcknowledged = cursor.getInt(_cursorIndexOfAcknowledged);
              }
              _item.setAcknowledged(_tmpAcknowledged);
              final Integer _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getInt(_cursorIndexOfStatus);
              }
              _item.setStatus(_tmpStatus);
              final Integer _tmpDecisionStatus;
              if (cursor.isNull(_cursorIndexOfDecisionStatus)) {
                _tmpDecisionStatus = null;
              } else {
                _tmpDecisionStatus = cursor.getInt(_cursorIndexOfDecisionStatus);
              }
              _item.setDecisionStatus(_tmpDecisionStatus);
              final Integer _tmpImageTextStatus;
              if (cursor.isNull(_cursorIndexOfImageTextStatus)) {
                _tmpImageTextStatus = null;
              } else {
                _tmpImageTextStatus = cursor.getInt(_cursorIndexOfImageTextStatus);
              }
              _item.setImageTextStatus(_tmpImageTextStatus);
              final String _tmpPpesIcon;
              _tmpPpesIcon = cursor.getString(_cursorIndexOfPpesIcon);
              _item.setPpesIcon(_tmpPpesIcon);
              final String _tmpHazardsIcon;
              _tmpHazardsIcon = cursor.getString(_cursorIndexOfHazardsIcon);
              _item.setHazardsIcon(_tmpHazardsIcon);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public LiveData<Integer> getPendingElementCount(final Integer checkListId,
      final String checkListUuid) {
    final String _sql = "SELECT \n"
            + " COUNT(ChecklistElement.id) \n"
            + "FROM \n"
            + " checklist_elements AS ChecklistElement \n"
            + " LEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = ChecklistElement.parent_id) \n"
            + " LEFT JOIN assigned_ncw AS AssignedNCW ON ( AssignedNCW.checklist_element_id = ChecklistElement.id AND AssignedNCW.assigned_checklist_uuid =  ? AND AssignedNCW.is_deleted = 0 ) \n"
            + " LEFT JOIN assigned_steps AS AssignedStep ON ( AssignedStep.checklist_element_id = ChecklistElement.id AND AssignedStep.assigned_checklist_uuid =  ? AND AssignedStep.is_deleted = 0 ) \n"
            + " LEFT JOIN assigned_decisions AS AssignedDecision ON ( AssignedDecision.checklist_element_id = ChecklistElement.id AND AssignedDecision.assigned_checklist_uuid =  ? AND AssignedDecision.is_deleted = 0 ) \n"
            + " LEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ParentElement.id AND ParentStep.assigned_checklist_uuid =  ? AND ParentStep.is_deleted = 0 ) \n"
            + "\n"
            + "WHERE \n"
            + " ChecklistElement.checklist_id =  ?\n"
            + " AND ChecklistElement.is_deleted = 0  \n"
            + " AND ChecklistElement.item_type_id NOT IN ( 9 )  \n"
            + " AND (ParentStep.status IN (1) OR ParentStep.checklist_element_id IS NULL) \n"
            + " AND (AssignedNCW.acknowledged IN (1,2) OR AssignedStep.status IN ( 1, 2 ) OR AssignedDecision.status IN (0, 1 ,2)  \n"
            + " OR (SELECT action FROM logs WHERE checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) AND assigned_checklist_uuid =  ? \n"
            + "   ORDER BY created DESC LIMIT 1) IN (12,17,18)) \n"
            + "  AND ( \n"
            + "    ( \n"
            + "     WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS ( \n"
            + " SELECT id,parent_id,item_type_id \n"
            + " FROM checklist_elements g \n"
            + "      WHERE id = ChecklistElement.id  \n"
            + "       UNION ALL \n"
            + "      SELECT c.id,c.parent_id,c.item_type_id \n"
            + " FROM checklist_path AS cp  \n"
            + "      JOIN checklist_elements AS c ON cp.parent_id = c.id \n"
            + "     ) \n"
            + " SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id  \n"
            + "   ) IS NULL OR  \n"
            + "   ( \n"
            + "    WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS ( \n"
            + "     SELECT g.id,g.parent_id,g.item_type_id \n"
            + " FROM checklist_elements g \n"
            + " WHERE g.id = ChecklistElement.id  \n"
            + "      UNION ALL \n"
            + "     SELECT c.id,c.parent_id,c.item_type_id \n"
            + "     FROM checklist_path AS cp JOIN checklist_elements AS c ON cp.parent_id = c.id \n"
            + "    ) \n"
            + "    SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id \n"
            + "   ) IN (SELECT checklist_element_id FROM assigned_decisions WHERE status = 1 AND assigned_decisions.assigned_checklist_uuid =  ? AND is_deleted = 0)) \n"
            + "ORDER BY \n"
            + " ChecklistElement.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 7);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"checklist_elements","assigned_ncw","assigned_steps","assigned_decisions","logs"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public LiveData<Integer> getTotalElementCount(final Integer checkListId,
      final String checkListUuid) {
    final String _sql = "SELECT\n"
            + "\tCOUNT(ChecklistElement.id)\n"
            + "FROM\n"
            + "\tchecklist_elements AS ChecklistElement\n"
            + "\tLEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = ChecklistElement.parent_id)\n"
            + "\tLEFT JOIN assigned_ncw AS AssignedNCW ON ( AssignedNCW.checklist_element_id = ChecklistElement.id AND AssignedNCW.assigned_checklist_uuid = ? AND AssignedNCW.is_deleted = 0 )\n"
            + "\tLEFT JOIN assigned_steps AS AssignedStep ON ( AssignedStep.checklist_element_id = ChecklistElement.id AND AssignedStep.assigned_checklist_uuid = ? AND AssignedStep.is_deleted = 0 )\n"
            + "\tLEFT JOIN assigned_decisions AS AssignedDecision ON ( AssignedDecision.checklist_element_id = ChecklistElement.id AND AssignedDecision.assigned_checklist_uuid = ? AND AssignedDecision.is_deleted = 0 )\n"
            + "\tLEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ParentElement.id AND ParentStep.assigned_checklist_uuid = ? AND ParentStep.is_deleted = 0 )\n"
            + "WHERE\n"
            + "\tChecklistElement.checklist_id = ? \n"
            + "\tAND ChecklistElement.is_deleted = 0 \n"
            + "\tAND ChecklistElement.item_type_id NOT IN ( 9 ) \n"
            + "\tAND (ParentStep.status IN (0, 1, 3) OR ParentStep.status\tIS NULL)\n"
            + " \tAND (\n"
            + "\t\t\t\t(\n"
            + "\t\t\t\t\tWITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n"
            + "            SELECT id,parent_id,item_type_id\n"
            + "            FROM checklist_elements g\n"
            + "\t\t\t\t\t\tWHERE id = ChecklistElement.id \n"
            + "\t\t\t\t\t\t\tUNION ALL\n"
            + "\t\t\t\t\t\tSELECT c.id,c.parent_id,c.item_type_id\n"
            + "            FROM checklist_path AS cp \n"
            + "\t\t\t\t\t\tJOIN checklist_elements AS c ON cp.parent_id = c.id\n"
            + "\t\t\t\t\t)\n"
            + "          SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id  \n"
            + "\t\t\t) IS NULL OR \n"
            + "\t\t\t(\n"
            + "\t\t\t\tWITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n"
            + "\t\t\t\t\tSELECT g.id,g.parent_id,g.item_type_id\n"
            + "          FROM checklist_elements g\n"
            + "          WHERE g.id = ChecklistElement.id \n"
            + "\t\t\t\t\t\tUNION ALL\n"
            + "\t\t\t\t\tSELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c ON cp.parent_id = c.id\n"
            + "\t\t\t\t)\n"
            + "\t\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id\n"
            + "\t\t\t) IN (SELECT checklist_element_id FROM assigned_decisions WHERE status = 1  AND assigned_decisions.assigned_checklist_uuid = ? AND is_deleted = 0))\n"
            + "ORDER BY\n"
            + "\tChecklistElement.sort_order ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 6);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"checklist_elements","assigned_ncw","assigned_steps","assigned_decisions"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public Integer getTotalElementCountInteger(final Integer checkListId,
      final String checkListUuid) {
    final String _sql = "SELECT\n"
            + "\tCOUNT(ChecklistElement.id)\n"
            + "FROM\n"
            + "\tchecklist_elements AS ChecklistElement\n"
            + "\tLEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = ChecklistElement.parent_id)\n"
            + "\tLEFT JOIN assigned_ncw AS AssignedNCW ON ( AssignedNCW.checklist_element_id = ChecklistElement.id AND AssignedNCW.assigned_checklist_uuid = ? AND AssignedNCW.is_deleted = 0 )\n"
            + "\tLEFT JOIN assigned_steps AS AssignedStep ON ( AssignedStep.checklist_element_id = ChecklistElement.id AND AssignedStep.assigned_checklist_uuid = ? AND AssignedStep.is_deleted = 0 )\n"
            + "\tLEFT JOIN assigned_decisions AS AssignedDecision ON ( AssignedDecision.checklist_element_id = ChecklistElement.id AND AssignedDecision.assigned_checklist_uuid = ? AND AssignedDecision.is_deleted = 0 )\n"
            + "\tLEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ParentElement.id AND ParentStep.assigned_checklist_uuid = ? AND ParentStep.is_deleted = 0 )\n"
            + "WHERE\n"
            + "\tChecklistElement.checklist_id = ? \n"
            + "\tAND ChecklistElement.is_deleted = 0 \n"
            + "\tAND ChecklistElement.item_type_id NOT IN ( 9 ) \n"
            + "\tAND (ParentStep.status IN (0, 1, 3) OR ParentStep.status\tIS NULL)\n"
            + " \tAND (\n"
            + "\t\t\t\t(\n"
            + "\t\t\t\t\tWITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n"
            + "            SELECT id,parent_id,item_type_id\n"
            + "            FROM checklist_elements g\n"
            + "\t\t\t\t\t\tWHERE id = ChecklistElement.id \n"
            + "\t\t\t\t\t\t\tUNION ALL\n"
            + "\t\t\t\t\t\tSELECT c.id,c.parent_id,c.item_type_id\n"
            + "            FROM checklist_path AS cp \n"
            + "\t\t\t\t\t\tJOIN checklist_elements AS c ON cp.parent_id = c.id\n"
            + "\t\t\t\t\t)\n"
            + "          SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id  \n"
            + "\t\t\t) IS NULL OR \n"
            + "\t\t\t(\n"
            + "\t\t\t\tWITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n"
            + "\t\t\t\t\tSELECT g.id,g.parent_id,g.item_type_id\n"
            + "          FROM checklist_elements g\n"
            + "          WHERE g.id = ChecklistElement.id \n"
            + "\t\t\t\t\t\tUNION ALL\n"
            + "\t\t\t\t\tSELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c ON cp.parent_id = c.id\n"
            + "\t\t\t\t)\n"
            + "\t\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id\n"
            + "\t\t\t) IN (SELECT checklist_element_id FROM assigned_decisions WHERE status = 1  AND assigned_decisions.assigned_checklist_uuid = ? AND is_deleted = 0))\n"
            + "ORDER BY\n"
            + "\tChecklistElement.sort_order ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 6);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(0);
        }
        _result = _tmp;
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
  public DataSource.Factory<Integer, ChecklistElementItem> getCheckListDetailSkippedDeferred(
      final Integer checklistId, final String assignedchecklistUuid, final Integer status) {
    final String _sql = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS (\n"
            + "        SELECT\n"
            + "            checklist_elements.id,\n"
            + "            checklist_elements.parent_id,\n"
            + "            checklist_elements.checklist_id,\n"
            + "            checklist_elements.item_id,\n"
            + "            checklist_elements.item_type_id,\n"
            + "            checklist_elements.item_uuid,\n"
            + "            checklist_elements.title,\n"
            + "            checklist_elements.description,\n"
            + "            checklist_elements.sequence_no,\n"
            + "            COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged, (SELECT \"action\" FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND \"action\" IN ( 17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1)) AS status,\n"
            + "            checklist_elements.sort_order,\n"
            + "            checklist_elements.id AS rootid,\n"
            + "            0 AS level\n"
            + "        FROM checklist_elements\n"
            + "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?)\n"
            + "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?)\n"
            + "        LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = ?)\n"
            + "        WHERE\n"
            + "            checklist_elements.checklist_id = ?\n"
            + "        AND checklist_elements.is_deleted = 0\n"
            + "            UNION ALL\n"
            + "        SELECT \n"
            + "            checklist_elements.id,\n"
            + "            checklist_elements.parent_id,\n"
            + "            checklist_elements.checklist_id,\n"
            + "            checklist_elements.item_id,\n"
            + "            checklist_elements.item_type_id,\n"
            + "            checklist_elements.item_uuid,\n"
            + "            checklist_elements.title,\n"
            + "            checklist_elements.description,\n"
            + "            checklist_elements.sequence_no,\n"
            + "            COALESCE(assigned_steps.status, assigned_decisions.status) AS status,\n"
            + "            checklist_elements.sort_order,\n"
            + "            elements.rootid,\n"
            + "            level + 1 AS level\n"
            + "        FROM checklist_elements, elements\n"
            + "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?)\n"
            + "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?)\n"
            + "        WHERE checklist_elements.id = elements.parent_id\n"
            + ")\n"
            + "SELECT\n"
            + "    id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n"
            + "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title,\n"
            + "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description,\n"
            + "    sequence_no, status, sort_order,\n"
            + "    (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon,\n"
            + "    (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon,\n"
            + "    rootid, level,\n"
            + "    SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents,\n"
            + "    SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( ? ) ) ) ) THEN 1 ELSE 0 END) AS total_executed_parents,\n"
            + "    SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent\n"
            + "FROM elements\n"
            + "LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.\"action\" = 19 AND placeholders_text.assigned_checklist_uuid = ?)\n"
            + "GROUP BY rootid\n"
            + "HAVING total_parents = total_executed_parents AND ( ( has_step_parent = 0 AND (CASE WHEN ?  = 2 THEN status IN ( 2, '12' ) ELSE  status IN ( 3, '13' ) END )) OR has_step_parent = 1 ) AND MIN(level) = 0\n"
            + "ORDER BY sort_order";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 10);
    int _argIndex = 1;
    if (assignedchecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedchecklistUuid);
    }
    _argIndex = 2;
    if (assignedchecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedchecklistUuid);
    }
    _argIndex = 3;
    if (assignedchecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedchecklistUuid);
    }
    _argIndex = 4;
    if (assignedchecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedchecklistUuid);
    }
    _argIndex = 5;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
    }
    _argIndex = 6;
    if (assignedchecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedchecklistUuid);
    }
    _argIndex = 7;
    if (assignedchecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedchecklistUuid);
    }
    _argIndex = 8;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, status);
    }
    _argIndex = 9;
    if (assignedchecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedchecklistUuid);
    }
    _argIndex = 10;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, status);
    }
    return new DataSource.Factory<Integer, ChecklistElementItem>() {
      @Override
      public LimitOffsetDataSource<ChecklistElementItem> create() {
        return new LimitOffsetDataSource<ChecklistElementItem>(__db, _statement, false , "logs", "checklist_elements", "assigned_steps", "assigned_decisions", "assigned_ncw", "checklist_ppes", "ppes", "ncw_hazards", "hazards") {
          @Override
          protected List<ChecklistElementItem> convertRows(Cursor cursor) {
            final int _cursorIndexOfElementId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(cursor, "parent_id");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(cursor, "item_id");
            final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "item_type_id");
            final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(cursor, "item_uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfSequenceNo = CursorUtil.getColumnIndexOrThrow(cursor, "sequence_no");
            final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(cursor, "status");
            final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(cursor, "sort_order");
            final int _cursorIndexOfPpesIcon = CursorUtil.getColumnIndexOrThrow(cursor, "ppes_icon");
            final int _cursorIndexOfHazardsIcon = CursorUtil.getColumnIndexOrThrow(cursor, "hazards_icon");
            final int _cursorIndexOfRootId = CursorUtil.getColumnIndexOrThrow(cursor, "rootid");
            final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(cursor, "level");
            final int _cursorIndexOfTotalParents = CursorUtil.getColumnIndexOrThrow(cursor, "total_parents");
            final int _cursorIndexOfTotalExecutedParents = CursorUtil.getColumnIndexOrThrow(cursor, "total_executed_parents");
            final int _cursorIndexOfHasStepParent = CursorUtil.getColumnIndexOrThrow(cursor, "has_step_parent");
            final List<ChecklistElementItem> _res = new ArrayList<ChecklistElementItem>(cursor.getCount());
            while(cursor.moveToNext()) {
              final ChecklistElementItem _item;
              _item = new ChecklistElementItem();
              final int _tmpElementId;
              _tmpElementId = cursor.getInt(_cursorIndexOfElementId);
              _item.setElementId(_tmpElementId);
              final int _tmpParentId;
              _tmpParentId = cursor.getInt(_cursorIndexOfParentId);
              _item.setParentId(_tmpParentId);
              final int _tmpChecklistId;
              _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              _item.setChecklistId(_tmpChecklistId);
              final int _tmpItemId;
              _tmpItemId = cursor.getInt(_cursorIndexOfItemId);
              _item.setItemId(_tmpItemId);
              final int _tmpItemTypeId;
              _tmpItemTypeId = cursor.getInt(_cursorIndexOfItemTypeId);
              _item.setItemTypeId(_tmpItemTypeId);
              final String _tmpItemUuid;
              _tmpItemUuid = cursor.getString(_cursorIndexOfItemUuid);
              _item.setItemUuid(_tmpItemUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _item.setDescription(_tmpDescription);
              final String _tmpSequenceNo;
              _tmpSequenceNo = cursor.getString(_cursorIndexOfSequenceNo);
              _item.setSequenceNo(_tmpSequenceNo);
              final Integer _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getInt(_cursorIndexOfStatus);
              }
              _item.setStatus(_tmpStatus);
              final int _tmpSortOrder;
              _tmpSortOrder = cursor.getInt(_cursorIndexOfSortOrder);
              _item.setSortOrder(_tmpSortOrder);
              final String _tmpPpesIcon;
              _tmpPpesIcon = cursor.getString(_cursorIndexOfPpesIcon);
              _item.setPpesIcon(_tmpPpesIcon);
              final String _tmpHazardsIcon;
              _tmpHazardsIcon = cursor.getString(_cursorIndexOfHazardsIcon);
              _item.setHazardsIcon(_tmpHazardsIcon);
              final int _tmpRootId;
              _tmpRootId = cursor.getInt(_cursorIndexOfRootId);
              _item.setRootId(_tmpRootId);
              final int _tmpLevel;
              _tmpLevel = cursor.getInt(_cursorIndexOfLevel);
              _item.setLevel(_tmpLevel);
              final int _tmpTotalParents;
              _tmpTotalParents = cursor.getInt(_cursorIndexOfTotalParents);
              _item.setTotalParents(_tmpTotalParents);
              final int _tmpTotalExecutedParents;
              _tmpTotalExecutedParents = cursor.getInt(_cursorIndexOfTotalExecutedParents);
              _item.setTotalExecutedParents(_tmpTotalExecutedParents);
              final boolean _tmpHasStepParent;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfHasStepParent);
              _tmpHasStepParent = _tmp != 0;
              _item.setHasStepParent(_tmpHasStepParent);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }
}
