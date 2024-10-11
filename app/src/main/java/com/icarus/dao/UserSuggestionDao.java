package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Transaction;

import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.UserSuggestionEntity;

@Dao
public abstract class UserSuggestionDao {

    @Insert
    public abstract void insertUserSuggestion(UserSuggestionEntity userSuggestionEntity);

    @Insert
    public abstract void insertUserSuggestionAttachment(UserSuggestionAttachmentsEntity userSuggestionAttachments);

    @Transaction
    public void addUserSuggestions(UserSuggestionEntity userSuggestionEntity,UserSuggestionAttachmentsEntity userSuggestionAttachments){
        insertUserSuggestion(userSuggestionEntity);
        insertUserSuggestionAttachment(userSuggestionAttachments);
    }




}
