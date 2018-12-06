package br.com.victor.theswitcher.app.listroom;

import java.util.List;

import br.com.victor.theswitcher.model.Room;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
public interface ListContract {

    interface Presenter {

        void listRoom();

        void updateStatus(Room room, boolean status);

        void openDetails(Room room);
    }

    interface View {

        void showList(List<Room> result);

        void showEmptyMessage();

        void showDetails(Room room);
    }

    interface OnItemClickListener {

        void clickItem(Room room);

        void onCheckedChanged(Room room, boolean status);
    }
}
