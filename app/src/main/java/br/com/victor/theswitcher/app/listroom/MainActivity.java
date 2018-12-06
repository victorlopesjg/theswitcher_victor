package br.com.victor.theswitcher.app.listroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import br.com.victor.theswitcher.R;
import br.com.victor.theswitcher.app.details.DetailActivity;
import br.com.victor.theswitcher.app.listroom.adapter.RoomAdapter;
import br.com.victor.theswitcher.data.AppDatabase;
import br.com.victor.theswitcher.model.Room;
import br.com.victor.theswitcher.utils.Constants;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
public class MainActivity extends AppCompatActivity implements ListContract.View, ListContract.OnItemClickListener {

    private ListContract.Presenter mPresenter;
    private RoomAdapter mRoomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.listRoom();
    }

    private void setup() {
        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRoomAdapter = new RoomAdapter(this);
        recyclerView.setAdapter(mRoomAdapter);

        AppDatabase db = AppDatabase.getAppDatabase(getApplication());
        mPresenter = new ListPresenter(this, db.roomDao());
    }

    @Override
    public void showList(List<Room> result) {
        mRoomAdapter.setValues(result);
    }

    @Override
    public void showEmptyMessage() {
        Toast.makeText(this, "List Empty", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDetails(Room room) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Constants.KEY_DETAIL, room);

        startActivity(intent);
    }

    @Override
    public void clickItem(Room room) {
        mPresenter.openDetails(room);
    }

    @Override
    public void onCheckedChanged(Room room, boolean status) {
        mPresenter.updateStatus(room, status);
    }
}
