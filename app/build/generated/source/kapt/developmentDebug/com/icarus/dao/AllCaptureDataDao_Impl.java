package com.icarus.dao;

import android.database.Cursor;
import androidx.paging.DataSource;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.DBUtil;
import com.icarus.models.ElementAttributesItems;
import com.icarus.models.ElementWithCaptureDataItems;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AllCaptureDataDao_Impl implements AllCaptureDataDao {
  private final RoomDatabase __db;

  public AllCaptureDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public DataSource.Factory<Integer, ElementWithCaptureDataItems> getElementsWithAttributes(
      final String assignedChecklistUUID, final Integer checklistID) {
    final String _sql = "SELECT \n"
            + "    ChecklistElement.id AS checklist_element_id,\n"
            + "    ChecklistElement.item_type_id,\n"
            + "    ChecklistElement.sequence_no,\n"
            + "    CASE\n"
            + "\t\tWHEN Log.item_description IS NULL OR Log.item_description = '' THEN ChecklistElement.title\n"
            + "\t\tELSE Log.item_description\n"
            + "\tEND AS title,\n"
            + "    CASE\n"
            + "\t\tWHEN Log.step_action IS NULL OR Log.step_action = '' THEN ChecklistElement.description\n"
            + "\t\tELSE Log.step_action\n"
            + "\tEND AS description,\n"
            + "    ChecklistElement.description,\n"
            + "    AssignedStep.status,\n"
            + "    COUNT(StepAttribute.id) AS attributes_count\n"
            + "FROM\n"
            + "\t\tchecklist_elements AS ChecklistElement\n"
            + "\tLEFT JOIN\n"
            + "\t\tassigned_steps AS AssignedStep ON (AssignedStep.assigned_checklist_uuid = ?\n"
            + "        AND AssignedStep.checklist_element_id = ChecklistElement.id)\n"
            + "\tINNER JOIN\n"
            + "\t\tstep_attributes AS StepAttribute ON (StepAttribute.step_id = ChecklistElement.item_id)\n"
            + "    LEFT JOIN\n"
            + "        logs Log ON (Log.checklist_element_id = ChecklistElement.id AND Log.assigned_checklist_uuid = ? AND Log.action = 19)\n"
            + "WHERE\n"
            + "    ChecklistElement.checklist_id = ?\n"
            + "\tAND ChecklistElement.item_type_id IN (1, 8, 12)\n"
            + "    AND ChecklistElement.is_deleted = 0\n"
            + "    AND (AssignedStep.is_deleted IS NULL OR AssignedStep.is_deleted = 0)\n"
            + "GROUP BY ChecklistElement.id\n"
            + "HAVING COUNT(StepAttribute.id) > 0\n"
            + "ORDER BY ChecklistElement.sort_order ASC\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (assignedChecklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUUID);
    }
    _argIndex = 2;
    if (assignedChecklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUUID);
    }
    _argIndex = 3;
    if (checklistID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistID);
    }
    return new DataSource.Factory<Integer, ElementWithCaptureDataItems>() {
      @Override
      public LimitOffsetDataSource<ElementWithCaptureDataItems> create() {
        return new LimitOffsetDataSource<ElementWithCaptureDataItems>(__db, _statement, false, true , "checklist_elements", "assigned_steps", "step_attributes", "logs") {
          @Override
          protected List<ElementWithCaptureDataItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistElementId = 0;
            final int _cursorIndexOfItemTypeId = 1;
            final int _cursorIndexOfSequenceNo = 2;
            final int _cursorIndexOfTitle = 3;
            final int _cursorIndexOfDescription = 4;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAttributesCount = 7;
            final List<ElementWithCaptureDataItems> _res = new ArrayList<ElementWithCaptureDataItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final ElementWithCaptureDataItems _item;
              _item = new ElementWithCaptureDataItems();
              final Integer _tmpChecklistElementId;
              if (cursor.isNull(_cursorIndexOfChecklistElementId)) {
                _tmpChecklistElementId = null;
              } else {
                _tmpChecklistElementId = cursor.getInt(_cursorIndexOfChecklistElementId);
              }
              _item.setChecklistElementId(_tmpChecklistElementId);
              final Integer _tmpItemTypeId;
              if (cursor.isNull(_cursorIndexOfItemTypeId)) {
                _tmpItemTypeId = null;
              } else {
                _tmpItemTypeId = cursor.getInt(_cursorIndexOfItemTypeId);
              }
              _item.setItemTypeId(_tmpItemTypeId);
              final String _tmpSequenceNo;
              if (cursor.isNull(_cursorIndexOfSequenceNo)) {
                _tmpSequenceNo = null;
              } else {
                _tmpSequenceNo = cursor.getString(_cursorIndexOfSequenceNo);
              }
              _item.setSequenceNo(_tmpSequenceNo);
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              _item.setTitle(_tmpTitle);
              final String _tmpDescription;
              if (cursor.isNull(_cursorIndexOfDescription)) {
                _tmpDescription = null;
              } else {
                _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              }
              _item.setDescription(_tmpDescription);
              final Integer _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getInt(_cursorIndexOfStatus);
              }
              _item.setStatus(_tmpStatus);
              final Integer _tmpAttributesCount;
              if (cursor.isNull(_cursorIndexOfAttributesCount)) {
                _tmpAttributesCount = null;
              } else {
                _tmpAttributesCount = cursor.getInt(_cursorIndexOfAttributesCount);
              }
              _item.setAttributesCount(_tmpAttributesCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public List<ElementAttributesItems> getAttributes(final String assignedChecklistUUID,
      final int elementId) {
    final String _sql = "SELECT\n"
            + "\tStepAttribute.label,\n"
            + "\tStepAttribute.description,\n"
            + "\tStepAttribute.sort_order,\n"
            + "\tStepAttribute.id,\n"
            + "\tCustomField.type,\n"
            + "\tNULL AS captured_uuid,\n"
            + "\tLog.step_action AS captured_value,\n"
            + "\tNULL AS captured_file,\n"
            + "\tNULL AS content_type,\n"
            + "\tNULL AS file_md5_checksum,\n"
            + "\tNULL AS is_downloaded,\n"
            + "\tLog.username AS captured_by,\n"
            + "\tLog.created AS captured_at\n"
            + "FROM\n"
            + "    assigned_step_attributes AS AssignedStepAttribute\n"
            + "\tINNER JOIN\n"
            + "\t\tstep_attributes AS StepAttribute ON (StepAttribute.id = AssignedStepAttribute.step_attribute_id)\n"
            + "\tINNER JOIN\n"
            + "\t\tcustom_fields AS CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n"
            + "\tLEFT JOIN\n"
            + "\t\tlogs AS Log ON (\n"
            + "\t\t\t(Log.item_uuid = AssignedStepAttribute.item_uuid OR Log.item_uuid = AssignedStepAttribute.uuid)\n"
            + "\t\t\t\tAND \n"
            + "\t\t\tLog.item_description = StepAttribute.label\n"
            + "\t\t)\n"
            + "WHERE\n"
            + "    AssignedStepAttribute.assigned_checklist_uuid = ?\n"
            + "    AND AssignedStepAttribute.checklist_element_id = ?\n"
            + "\tAND AssignedStepAttribute.is_deleted = 0\n"
            + "    AND CustomField.type NOT IN ('file', 'qr')\n"
            + "GROUP BY AssignedStepAttribute.step_attribute_id\n"
            + "HAVING MAX(Log.created)\n"
            + "UNION ALL\n"
            + "SELECT\n"
            + "\tStepAttribute.label,\n"
            + "\tStepAttribute.description,\n"
            + "\tStepAttribute.sort_order,\n"
            + "\tStepAttribute.id,\n"
            + "\tCustomField.type,\n"
            + "\tAssignedStepResource.uuid AS captured_uuid,\n"
            + "\tAssignedStepResource.display_file_name AS captured_value,\n"
            + "\tAssignedStepResource.file_name AS captured_file,\n"
            + "\tAssignedStepResource.content_type,\n"
            + "\tAssignedStepResource.file_md5_checksum,\n"
            + "\tAssignedStepResource.is_downloaded,\n"
            + "\tLog.username AS captured_by,\n"
            + "\tLog.created AS captured_at\n"
            + "FROM\n"
            + "\t\tassigned_step_attributes AS AssignedStepAttribute\n"
            + "\tINNER JOIN\n"
            + "\t\tstep_attributes AS StepAttribute ON (StepAttribute.id = AssignedStepAttribute.step_attribute_id)\n"
            + "\tINNER JOIN\n"
            + "\t\tcustom_fields AS CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n"
            + "\tINNER JOIN\n"
            + "\t\tassigned_step_resources AS AssignedStepResource ON (\n"
            + "\t\t\tAssignedStepResource.uuid = AssignedStepAttribute.value\n"
            + "\t\t\tAND AssignedStepResource.checklist_element_id = AssignedStepAttribute.checklist_element_id\n"
            + "\t\t\tAND AssignedStepResource.assigned_checklist_uuid = AssignedStepAttribute.assigned_checklist_uuid\n"
            + "\t\t\tAND AssignedStepResource.is_deleted = 0\n"
            + "\t\t)\n"
            + "    INNER JOIN\n"
            + "    \tlogs AS Log ON (\n"
            + "        \tAssignedStepResource.uuid = Log.step_action\n"
            + "        \tAND Log.assigned_checklist_uuid = AssignedStepResource.assigned_checklist_uuid\n"
            + "        \tAND Log.checklist_element_id = AssignedStepResource.checklist_element_id\n"
            + "            AND Log.action = 7\n"
            + "    \t)\n"
            + "WHERE\n"
            + "\t\tAssignedStepAttribute.assigned_checklist_uuid = ?\n"
            + "AND AssignedStepAttribute.checklist_element_id = ?\n"
            + "AND AssignedStepAttribute.is_deleted = 0\n"
            + "AND AssignedStepResource.is_deleted = 0\n"
            + "AND CustomField.type = 'file'\n"
            + "GROUP BY Log.step_action\n"
            + "HAVING MAX(Log.created)\n"
            + "UNION ALL\n"
            + "SELECT\n"
            + "\tStepAttribute.label,\n"
            + "\tStepAttribute.description,\n"
            + "\tStepAttribute.sort_order,\n"
            + "\tStepAttribute.id,\n"
            + "\tCustomField.type,\n"
            + "\tNULL AS captured_uuid,\n"
            + "\tLog.step_action AS captured_value,\n"
            + "\tNULL AS captured_file,\n"
            + "\tNULL AS content_type,\n"
            + "\tNULL AS file_md5_checksum,\n"
            + "\tNULL AS is_downloaded,\n"
            + "\tLog.username AS captured_by,\n"
            + "\tLog.created AS captured_at\n"
            + "FROM\n"
            + "\t\tassigned_step_attributes AS AssignedStepAttribute\n"
            + "\tINNER JOIN\n"
            + "\t\tstep_attributes AS StepAttribute ON (StepAttribute.id = AssignedStepAttribute.step_attribute_id)\n"
            + "\tINNER JOIN\n"
            + "\t\tcustom_fields AS CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n"
            + "\tLEFT JOIN\n"
            + "\t\tlogs AS Log ON (\n"
            + "\t\t\t(Log.item_uuid = AssignedStepAttribute.item_uuid OR Log.item_uuid = AssignedStepAttribute.uuid)\n"
            + "\t\t\tAND\n"
            + "\t\t\tLog.assigned_to_name = AssignedStepAttribute.uuid\n"
            + "\t\t)\n"
            + "WHERE\n"
            + "\t\tAssignedStepAttribute.assigned_checklist_uuid = ?\n"
            + "AND AssignedStepAttribute.checklist_element_id = ?\n"
            + "AND AssignedStepAttribute.is_deleted = 0\n"
            + "AND CustomField.type = 'qr'\n"
            + "GROUP BY AssignedStepAttribute.value\n"
            + "HAVING MAX(Log.created);";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 6);
    int _argIndex = 1;
    if (assignedChecklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUUID);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, elementId);
    _argIndex = 3;
    if (assignedChecklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUUID);
    }
    _argIndex = 4;
    _statement.bindLong(_argIndex, elementId);
    _argIndex = 5;
    if (assignedChecklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUUID);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, elementId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLabel = 0;
      final int _cursorIndexOfDescription = 1;
      final int _cursorIndexOfSortOrder = 2;
      final int _cursorIndexOfId = 3;
      final int _cursorIndexOfType = 4;
      final int _cursorIndexOfCapturedUUID = 5;
      final int _cursorIndexOfCapturedValue = 6;
      final int _cursorIndexOfCapturedFile = 7;
      final int _cursorIndexOfContentType = 8;
      final int _cursorIndexOfFileMD5Checksum = 9;
      final int _cursorIndexOfIsDownloaded = 10;
      final int _cursorIndexOfCapturedBy = 11;
      final int _cursorIndexOfCapturedAt = 12;
      final List<ElementAttributesItems> _result = new ArrayList<ElementAttributesItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ElementAttributesItems _item;
        _item = new ElementAttributesItems();
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        _item.setLabel(_tmpLabel);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _item.setSortOrder(_tmpSortOrder);
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _item.setType(_tmpType);
        final String _tmpCapturedUUID;
        if (_cursor.isNull(_cursorIndexOfCapturedUUID)) {
          _tmpCapturedUUID = null;
        } else {
          _tmpCapturedUUID = _cursor.getString(_cursorIndexOfCapturedUUID);
        }
        _item.setCapturedUUID(_tmpCapturedUUID);
        final String _tmpCapturedValue;
        if (_cursor.isNull(_cursorIndexOfCapturedValue)) {
          _tmpCapturedValue = null;
        } else {
          _tmpCapturedValue = _cursor.getString(_cursorIndexOfCapturedValue);
        }
        _item.setCapturedValue(_tmpCapturedValue);
        final String _tmpCapturedFile;
        if (_cursor.isNull(_cursorIndexOfCapturedFile)) {
          _tmpCapturedFile = null;
        } else {
          _tmpCapturedFile = _cursor.getString(_cursorIndexOfCapturedFile);
        }
        _item.setCapturedFile(_tmpCapturedFile);
        final String _tmpContentType;
        if (_cursor.isNull(_cursorIndexOfContentType)) {
          _tmpContentType = null;
        } else {
          _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
        }
        _item.setContentType(_tmpContentType);
        final String _tmpFileMD5Checksum;
        if (_cursor.isNull(_cursorIndexOfFileMD5Checksum)) {
          _tmpFileMD5Checksum = null;
        } else {
          _tmpFileMD5Checksum = _cursor.getString(_cursorIndexOfFileMD5Checksum);
        }
        _item.setFileMD5Checksum(_tmpFileMD5Checksum);
        final boolean _tmpIsDownloaded;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDownloaded);
        _tmpIsDownloaded = _tmp != 0;
        _item.setDownloaded(_tmpIsDownloaded);
        final String _tmpCapturedBy;
        if (_cursor.isNull(_cursorIndexOfCapturedBy)) {
          _tmpCapturedBy = null;
        } else {
          _tmpCapturedBy = _cursor.getString(_cursorIndexOfCapturedBy);
        }
        _item.setCapturedBy(_tmpCapturedBy);
        final String _tmpCapturedAt;
        if (_cursor.isNull(_cursorIndexOfCapturedAt)) {
          _tmpCapturedAt = null;
        } else {
          _tmpCapturedAt = _cursor.getString(_cursorIndexOfCapturedAt);
        }
        _item.setCapturedAt(_tmpCapturedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
