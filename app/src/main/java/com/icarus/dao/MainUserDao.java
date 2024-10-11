package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.icarus.entities.Login;

@Dao
public interface MainUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(Login entity);

    @Query("SELECT * FROM users WHERE LOWER(username) = :username AND password = :password AND is_deleted = 0 AND group_id NOT IN ( 1 ,7 )")
    Login validateUser(String username, String password);

    @Query("UPDATE users SET terms_accepted = :isTermsAccepted WHERE id = :userId")
    void updateUserTerms(Integer userId, boolean isTermsAccepted);

    @Query("Select terms_accepted FROM users WHERE id = :userId")
    boolean isTermsAccepted(Integer userId);

    @Query("delete From users WHERE id = :userId")
    void deleteUser(int userId);
}
