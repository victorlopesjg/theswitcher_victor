package br.com.victor.theswitcher.app.listroom;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import br.com.victor.theswitcher.data.RoomDao;
import br.com.victor.theswitcher.model.Room;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
public class ListPresenter implements ListContract.Presenter {

    private ListContract.View mListView;
    private RoomDao dao;

    public ListPresenter(ListContract.View mListView, RoomDao dao) {
        this.mListView = mListView;
        this.dao = dao;
    }


    @Override
    public void listRoom() {
        dao.findAll().observeForever(new Observer<List<Room>>() {
            @Override
            public void onChanged(@Nullable List<Room> rooms) {
                if (rooms != null && !rooms.isEmpty()) {
                    mListView.showList(rooms);
                } else {
                    mListView.showEmptyMessage();
                }
            }
        });
    }

    @Override
    public void updateStatus(Room room, boolean status) {
        int value = 0;
        if (status) {
            value = 1;
        }

        room.setStatus(value);
        dao.update(room);
    }

    @Override
    public void openDetails(Room room) {
        mListView.showDetails(room);
    }
}
