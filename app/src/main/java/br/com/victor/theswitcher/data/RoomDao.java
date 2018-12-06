package br.com.victor.theswitcher.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.victor.theswitcher.model.Room;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
@Dao
public interface RoomDao {

    @Query("SELECT * FROM " + Room.TABLE_NAME)
    LiveData<List<Room>> findAll();

    @Query("SELECT * FROM " + Room.TABLE_NAME)
    List<Room> getAllRoom();

    @Query("SELECT COUNT(*) FROM " + Room.TABLE_NAME)
    int count();

    @Insert
    List<Long> insertAll(Room... rooms);

    @Update
    void update(Room room);

    @Query("DELETE FROM " + Room.TABLE_NAME)
    void deleteAll();

}
