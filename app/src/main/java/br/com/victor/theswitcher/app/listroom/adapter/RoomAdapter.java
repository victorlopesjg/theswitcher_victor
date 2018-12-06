package br.com.victor.theswitcher.app.listroom.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.List;

import br.com.victor.theswitcher.R;
import br.com.victor.theswitcher.app.listroom.ListContract;
import br.com.victor.theswitcher.model.Room;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomViewHolder> {

    private List<Room> mValues;
    private ListContract.OnItemClickListener mOnItemClickListener;

    public RoomAdapter(ListContract.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RoomViewHolder holder, int position) {
        Room room = mValues.get(position);

        holder.mItem = room;

        holder.switchLabel.setText(room.getName());
        holder.switchButton.setChecked(room.isStatus());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.clickItem(holder.mItem);
            }
        });

        holder.switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mOnItemClickListener.onCheckedChanged(holder.mItem, isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mValues != null && !mValues.isEmpty()) ? mValues.size() : 0;
    }

    public void setValues(List<Room> values) {
        mValues = values;
        notifyDataSetChanged();
    }
}
