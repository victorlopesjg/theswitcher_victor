package br.com.victor.theswitcher.db;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import br.com.victor.theswitcher.data.AppDatabase;
import br.com.victor.theswitcher.data.RoomDao;
import br.com.victor.theswitcher.model.Room;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private RoomDao mRoomDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = android.arch.persistence.room.Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mRoomDao = mDb.roomDao();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {

        mDb.roomDao().deleteAll();

        List<Room> rooms = mDb.roomDao().getAllRoom();
        assertThat(rooms.size(), equalTo(0));

        Room person = addRoom(mDb, "Room 1", 1);
        addRoom(mDb, "Room 2", 1);
        addRoom(mDb, "Room 3", 0);

        rooms = mRoomDao.getAllRoom();
        assertThat(rooms.size(), equalTo(3));
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    private static Room addRoom(AppDatabase db, String name, int status) {
        Room room = new Room();
        room.setName(name);
        room.setStatus(status);

        List<Long> ids = db.roomDao().insertAll(room);
        Log.d("ID", ids.get(0) + "");
        return room;
    }

}
