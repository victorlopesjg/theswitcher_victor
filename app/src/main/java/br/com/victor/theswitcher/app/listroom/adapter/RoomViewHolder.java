package br.com.victor.theswitcher.app.listroom.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import br.com.victor.theswitcher.R;
import br.com.victor.theswitcher.model.Room;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
public class RoomViewHolder extends RecyclerView.ViewHolder {
    View mView;
    TextView switchLabel;
    Switch switchButton;
    Room mItem;

    public RoomViewHolder(@NonNull View view) {
        super(view);

        mView = view;
        switchLabel = view.findViewById(R.id.switch_label);
        switchButton = view.findViewById(R.id.switch_button);
    }
}
