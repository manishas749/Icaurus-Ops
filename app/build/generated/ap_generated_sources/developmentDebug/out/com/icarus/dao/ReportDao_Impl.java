package com.icarus.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.icarus.models.AssignedChecklistSummary;
import com.icarus.models.AssignmentHistory;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.LogsSummary;
import com.icarus.models.PausedHistory;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ReportDao_Impl implements ReportDao {
  private final RoomDatabase __db;

  public ReportDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public AssignedChecklistSummary getSummary(final String assignedChecklistUuid) {
    final String _sql = "SELECT    StartedBy.full_name AS started_by,    AssignedChecklist.started_at,    StatusLog.\"action\",    coalesce(StatusLog.username, PerformedBy.full_name) AS last_performed_by,    coalesce(StatusLog.created, AssignedChecklist.modified) AS last_performed_at,    StatusLog.item_description AS reason,    ClosedLog.username AS closed_by,    ClosedLog.created AS closed_at,    Department.name AS department,    Location.name AS location,    RoomEquipmentLog.step_action AS room,    RoomEquipmentLog.item_description AS equipment FROM    assigned_checklists AS AssignedChecklist LEFT JOIN users AS StartedBy ON(    AssignedChecklist.started_by_user_id = StartedBy.id ) LEFT JOIN users AS PerformedBy ON(    AssignedChecklist.user_id = PerformedBy.id ) LEFT JOIN logs AS RoomEquipmentLog ON (\n"
            + "   RoomEquipmentLog.assigned_checklist_uuid = AssignedChecklist.uuid    AND RoomEquipmentLog.\"action\" = 16    AND RoomEquipmentLog.checklist_element_id IS NULL ) LEFT JOIN logs AS StatusLog ON(    StatusLog.assigned_checklist_uuid = AssignedChecklist.uuid    AND StatusLog.\"action\" IN (3, 4)    AND StatusLog.checklist_element_id IS NULL ) LEFT JOIN logs AS ClosedLog ON(    ClosedLog.assigned_checklist_uuid = AssignedChecklist.uuid    AND ClosedLog.\"action\" = 24    AND ClosedLog.checklist_element_id IS NULL ) LEFT JOIN locations AS Location ON(    AssignedChecklist.location_id = Location.id ) LEFT JOIN departments AS Department ON(    AssignedChecklist.department_id = Department.id ) WHERE\n"
            + "   AssignedChecklist.uuid = ? ORDER BY    StatusLog.created DESC,    ClosedLog.created DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStartedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "started_by");
      final int _cursorIndexOfStartedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "started_at");
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfLastPerformedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "last_performed_by");
      final int _cursorIndexOfLastPerformedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "last_performed_at");
      final int _cursorIndexOfActionReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfClosedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "closed_by");
      final int _cursorIndexOfClosedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "closed_at");
      final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfRoom = CursorUtil.getColumnIndexOrThrow(_cursor, "room");
      final int _cursorIndexOfEquipment = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment");
      final AssignedChecklistSummary _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedChecklistSummary();
        final String _tmpStartedBy;
        _tmpStartedBy = _cursor.getString(_cursorIndexOfStartedBy);
        _result.setStartedBy(_tmpStartedBy);
        final String _tmpStartedAt;
        _tmpStartedAt = _cursor.getString(_cursorIndexOfStartedAt);
        _result.setStartedAt(_tmpStartedAt);
        final Integer _tmpAction;
        if (_cursor.isNull(_cursorIndexOfAction)) {
          _tmpAction = null;
        } else {
          _tmpAction = _cursor.getInt(_cursorIndexOfAction);
        }
        _result.setAction(_tmpAction);
        final String _tmpLastPerformedBy;
        _tmpLastPerformedBy = _cursor.getString(_cursorIndexOfLastPerformedBy);
        _result.setLastPerformedBy(_tmpLastPerformedBy);
        final String _tmpLastPerformedAt;
        _tmpLastPerformedAt = _cursor.getString(_cursorIndexOfLastPerformedAt);
        _result.setLastPerformedAt(_tmpLastPerformedAt);
        final String _tmpActionReason;
        _tmpActionReason = _cursor.getString(_cursorIndexOfActionReason);
        _result.setActionReason(_tmpActionReason);
        final String _tmpClosedBy;
        _tmpClosedBy = _cursor.getString(_cursorIndexOfClosedBy);
        _result.setClosedBy(_tmpClosedBy);
        final String _tmpClosedAt;
        _tmpClosedAt = _cursor.getString(_cursorIndexOfClosedAt);
        _result.setClosedAt(_tmpClosedAt);
        final String _tmpDepartment;
        _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
        _result.setDepartment(_tmpDepartment);
        final String _tmpLocation;
        _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        _result.setLocation(_tmpLocation);
        final String _tmpRoom;
        _tmpRoom = _cursor.getString(_cursorIndexOfRoom);
        _result.setRoom(_tmpRoom);
        final String _tmpEquipment;
        _tmpEquipment = _cursor.getString(_cursorIndexOfEquipment);
        _result.setEquipment(_tmpEquipment);
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
  public List<String> getAssignees(final String assignedChecklistUuid) {
    final String _sql = "SELECT  User.full_name FROM  assigned_users AS AssignedUser LEFT JOIN users AS User ON(  AssignedUser.user_id = User.id ) WHERE    AssignedUser.assigned_checklist_uuid = ? AND AssignedUser.is_deleted = 0 ORDER BY    User.full_name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignmentHistory> getAssignmentHistory(final String assignedChecklistUuid) {
    final String _sql = "SELECT  Log.created AS performed_at,  Log.\"action\",  Log.username AS assigned_by,  group_concat(assigned_to_name, ', ') AS assigned_to FROM  logs AS Log WHERE  assigned_checklist_uuid = ? AND checklist_element_id IS NULL AND(    \"action\" IN (0, 1, 15, 21)    OR(        \"action\" = 20        AND user_id <> assigned_to    ) ) GROUP BY    created,    \"action\",    username ORDER BY    created DESC,    \"action\" ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPerformedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "performed_at");
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfAssignedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_by");
      final int _cursorIndexOfAssignedTo = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to");
      final List<AssignmentHistory> _result = new ArrayList<AssignmentHistory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignmentHistory _item;
        _item = new AssignmentHistory();
        final String _tmpPerformedAt;
        _tmpPerformedAt = _cursor.getString(_cursorIndexOfPerformedAt);
        _item.setPerformedAt(_tmpPerformedAt);
        final Integer _tmpAction;
        if (_cursor.isNull(_cursorIndexOfAction)) {
          _tmpAction = null;
        } else {
          _tmpAction = _cursor.getInt(_cursorIndexOfAction);
        }
        _item.setAction(_tmpAction);
        final String _tmpAssignedBy;
        _tmpAssignedBy = _cursor.getString(_cursorIndexOfAssignedBy);
        _item.setAssignedBy(_tmpAssignedBy);
        final String _tmpAssignedTo;
        _tmpAssignedTo = _cursor.getString(_cursorIndexOfAssignedTo);
        _item.setAssignedTo(_tmpAssignedTo);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PausedHistory> getPauseHistory(final String assignedChecklistUuid,
      final int resumeAction, final int pauseAction) {
    final String _sql = "SELECT    Log.uuid,    Log.username AS paused_by,    Log.created AS paused_at,    Log.item_description AS pause_reason,    NLog.created AS resumed_at,    NLog.username AS resumed_by FROM  logs AS Log  LEFT JOIN logs AS NLog ON(    NLog.assigned_checklist_uuid = ?    AND NLog.\"action\" = ?    AND NLog.created > Log.created ) LEFT JOIN logs AS NNLog ON(    NNLog.assigned_checklist_uuid = ?    AND NNLog.\"action\" = ?    AND NNLog.created > Log.created    AND NNLog.created < NLog.created ) WHERE    Log.assigned_checklist_uuid = ? AND Log.\"action\" = ? AND NNLog.created IS NULL ORDER BY    Log.created ASC,    NLog.created ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 6);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, resumeAction);
    _argIndex = 3;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 4;
    _statement.bindLong(_argIndex, resumeAction);
    _argIndex = 5;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, pauseAction);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfPausedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "paused_by");
      final int _cursorIndexOfPausedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "paused_at");
      final int _cursorIndexOfPauseReason = CursorUtil.getColumnIndexOrThrow(_cursor, "pause_reason");
      final int _cursorIndexOfResumedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "resumed_at");
      final int _cursorIndexOfResumedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "resumed_by");
      final List<PausedHistory> _result = new ArrayList<PausedHistory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PausedHistory _item;
        _item = new PausedHistory();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpPausedBy;
        _tmpPausedBy = _cursor.getString(_cursorIndexOfPausedBy);
        _item.setPausedBy(_tmpPausedBy);
        final String _tmpPausedAt;
        _tmpPausedAt = _cursor.getString(_cursorIndexOfPausedAt);
        _item.setPausedAt(_tmpPausedAt);
        final String _tmpPauseReason;
        _tmpPauseReason = _cursor.getString(_cursorIndexOfPauseReason);
        _item.setPauseReason(_tmpPauseReason);
        final String _tmpResumedAt;
        _tmpResumedAt = _cursor.getString(_cursorIndexOfResumedAt);
        _item.setResumedAt(_tmpResumedAt);
        final String _tmpResumedBy;
        _tmpResumedBy = _cursor.getString(_cursorIndexOfResumedBy);
        _item.setResumedBy(_tmpResumedBy);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<LogsSummary> getLogsSummary(final String checklistUUID) {
    final String _sql = "SELECT \n"
            + "Log.uuid, \n"
            + "Log.item_uuid, \n"
            + "Log.action, \n"
            + "Log.username, \n"
            + "Log.item_description, \n"
            + "Log.created, \n"
            + "Log.checklist_element_id, \n"
            + "Log.step_action, \n"
            + "Log.assigned_checklist_uuid, \n"
            + "AssignedStepResource.uuid AS assignedStepResourceUUID, \n"
            + "AssignedStepResource.file_md5_checksum, \n"
            + "AssignedStepResource.display_file_name,\n"
            + "CustomField.type\n"
            + "FROM logs AS Log \n"
            + "LEFT JOIN step_attributes AS StepAttribute ON (\n"
            + "StepAttribute.id = Log.assigned_to\n"
            + ")\n"
            + "LEFT JOIN custom_fields AS CustomField ON (\n"
            + "       CustomField.id = StepAttribute.custom_field_id\n"
            + ")\n"
            + "LEFT JOIN assigned_step_resources AS AssignedStepResource ON \n"
            + "    (\n"
            + "        Log.assigned_checklist_uuid = AssignedStepResource.assigned_checklist_uuid \n"
            + "            AND \n"
            + "        Log.action = '7' \n"
            + "            AND \n"
            + "        (\n"
            + "            (Log.step_action = AssignedStepResource.uuid) \n"
            + "                OR \n"
            + "            (Log.step_action = AssignedStepResource.file_name)\n"
            + "        )\n"
            + "    ) \n"
            + "WHERE \n"
            + "Log.assigned_checklist_uuid = ? \n"
            + "AND Log.checklist_element_id IS NOT NULL \n"
            + "AND Log.action != '19' \n"
            + "ORDER BY Log.checklist_element_id ASC, Log.created DESC,\n"
            + "CASE\n"
            + "    WHEN action = 0 THEN 0 \n"
            + "    WHEN action = 1 THEN 1\n"
            + "    WHEN action = 4 THEN 2\n"
            + "    WHEN action = 5 THEN 3\n"
            + "    WHEN action = 12 THEN 4\n"
            + "    WHEN action = 13 THEN 5\n"
            + "    WHEN action = 15 THEN 6\n"
            + "    WHEN action = 17 THEN 7\n"
            + "    WHEN action = 18 THEN 8\n"
            + "    WHEN action = 6 THEN 9\n"
            + "    WHEN action = 7 THEN 10\n"
            + "    WHEN action = 8 THEN 11\n"
            + "END ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (checklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUUID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfItemUUID = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfItemDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "item_description");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfStepAction = CursorUtil.getColumnIndexOrThrow(_cursor, "step_action");
      final int _cursorIndexOfAssignedChecklistUUID = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfAssignedStepResourceUUID = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedStepResourceUUID");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_file_name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final List<LogsSummary> _result = new ArrayList<LogsSummary>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LogsSummary _item;
        _item = new LogsSummary();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpItemUUID;
        _tmpItemUUID = _cursor.getString(_cursorIndexOfItemUUID);
        _item.setItemUUID(_tmpItemUUID);
        final int _tmpAction;
        _tmpAction = _cursor.getInt(_cursorIndexOfAction);
        _item.setAction(_tmpAction);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item.setUsername(_tmpUsername);
        final String _tmpItemDescription;
        _tmpItemDescription = _cursor.getString(_cursorIndexOfItemDescription);
        _item.setItemDescription(_tmpItemDescription);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _item.setCreated(_tmpCreated);
        final String _tmpChecklistElementId;
        _tmpChecklistElementId = _cursor.getString(_cursorIndexOfChecklistElementId);
        _item.setChecklistElementId(_tmpChecklistElementId);
        final String _tmpStepAction;
        _tmpStepAction = _cursor.getString(_cursorIndexOfStepAction);
        _item.setStepAction(_tmpStepAction);
        final String _tmpAssignedChecklistUUID;
        _tmpAssignedChecklistUUID = _cursor.getString(_cursorIndexOfAssignedChecklistUUID);
        _item.setAssignedChecklistUUID(_tmpAssignedChecklistUUID);
        final String _tmpAssignedStepResourceUUID;
        _tmpAssignedStepResourceUUID = _cursor.getString(_cursorIndexOfAssignedStepResourceUUID);
        _item.setAssignedStepResourceUUID(_tmpAssignedStepResourceUUID);
        final String _tmpFileName;
        _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        _item.setFileName(_tmpFileName);
        final String _tmpDisplayFileName;
        _tmpDisplayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
        _item.setDisplayFileName(_tmpDisplayFileName);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ChecklistDetailItems>> getCheckList(final Integer checkListId,
      final String checkListUuid) {
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
    return __db.getInvalidationTracker().createLiveData(new String[]{"logs","checklist_elements","assigned_steps","assigned_decisions","assigned_ncw","checklist_ppes","ppes","ncw_hazards","hazards"}, false, new Callable<List<ChecklistDetailItems>>() {
      @Override
      public List<ChecklistDetailItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfParentItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_id");
          final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
          final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
          final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
          final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSequenceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sequence_no");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sort_order");
          final int _cursorIndexOfPpesIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "ppes_icon");
          final int _cursorIndexOfHazardsIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "hazards_icon");
          final List<ChecklistDetailItems> _result = new ArrayList<ChecklistDetailItems>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChecklistDetailItems _item;
            _item = new ChecklistDetailItems();
            final int _tmpElementId;
            _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
            _item.setElementId(_tmpElementId);
            final int _tmpParentItemId;
            _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
            _item.setParentItemId(_tmpParentItemId);
            final int _tmpChecklistId;
            _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
            _item.setChecklistId(_tmpChecklistId);
            final int _tmpItemId;
            _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
            _item.setItemId(_tmpItemId);
            final int _tmpItemTypeId;
            _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
            _item.setItemTypeId(_tmpItemTypeId);
            final String _tmpItemUuid;
            _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
            _item.setItemUuid(_tmpItemUuid);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item.setTitle(_tmpTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpSequenceNo;
            _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
            _item.setSequenceNo(_tmpSequenceNo);
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
            final int _tmpSortOrder;
            _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
            _item.setSortOrder(_tmpSortOrder);
            final String _tmpPpesIcon;
            _tmpPpesIcon = _cursor.getString(_cursorIndexOfPpesIcon);
            _item.setPpesIcon(_tmpPpesIcon);
            final String _tmpHazardsIcon;
            _tmpHazardsIcon = _cursor.getString(_cursorIndexOfHazardsIcon);
            _item.setHazardsIcon(_tmpHazardsIcon);
            _result.add(_item);
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
}
