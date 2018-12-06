package br.com.victor.theswitcher.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */

@Entity(tableName = Room.TABLE_NAME)
public class Room implements Serializable {

    /**
     * The name of the Cheese table.
     */
    public static final String TABLE_NAME = "room";

    /**
     * The name of the ID column.
     */
    public static final String COLUMN_ID = BaseColumns._ID;

    /**
     * The name of the name column.
     */
    public static final String COLUMN_NAME = "name";

    /**
     * The name of the status column.
     */
    public static final String COLUMN_STATUS = "status";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    private long id;

    @ColumnInfo(name = COLUMN_NAME)
    private String name;

    @ColumnInfo(name = COLUMN_STATUS)
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isStatus() {
        return this.status == 1;
    }

    /**
     * Dummy data.
     */
    public static final String[] ROOMS = {"Kitchen", "Living room", "Master bedroom", "Guest’s bedroom"};
}
