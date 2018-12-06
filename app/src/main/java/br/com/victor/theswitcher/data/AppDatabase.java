package br.com.victor.theswitcher.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import java.util.List;

import br.com.victor.theswitcher.model.Room;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */

@Database(entities = {Room.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract RoomDao roomDao();

    /**
     * Gets the singleton instance of AppDatabase.
     *
     * @param context The context.
     * @return The singleton instance of AppDatabase.
     */
    public static synchronized AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    android.arch.persistence.room.Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "room-database")
                            .allowMainThreadQueries()
                            .build();

            INSTANCE.populateInitialData();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Inserts the dummy data into the database if it is currently empty.
     */
    private void populateInitialData() {
        if (roomDao().count() == 0) {
            Room room = new Room();
            beginTransaction();
            try {
                for (int i = 0; i < Room.ROOMS.length; i++) {
                    room.setName(Room.ROOMS[i]);
                    room.setStatus(0);

                    List<Long> ids = roomDao().insertAll(room);
                    Log.d("ID", ids.get(0) + "");
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }
}
