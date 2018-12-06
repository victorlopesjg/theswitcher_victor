package br.com.victor.theswitcher.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.victor.theswitcher.app.listroom.ListContract;
import br.com.victor.theswitcher.model.Room;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
public class ListPresenterFake implements ListContract.Presenter {

    private ListContract.View mListView;

    ListPresenterFake(ListContract.View mListView) {
        this.mListView = mListView;
    }

    @Override
    public void listRoom() {

        Room room = new Room();
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < Room.ROOMS.length; i++) {
            room.setId(i + 1);
            room.setName(Room.ROOMS[i]);
            room.setStatus(0);

            list.add(room);
        }

        mListView.showList(list);

    }

    @Override
    public void updateStatus(Room room, boolean status) {

    }

    @Override
    public void openDetails(Room room) {

    }
}
