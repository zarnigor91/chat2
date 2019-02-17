package com.example.user.chat2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.chat2.R;
import com.example.user.chat2.model.User;

import java.util.ArrayList;

public class MessagAdapter  extends  RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private ArrayList<User> userArrayList;

    public MessagAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public int getItemViewType(int position) {
        User item = userArrayList.get(position);
        if (item.getType() == User.ItemType.ONE_ITEM) {
            return TYPE_ONE;
        } else if (item.getType() == User.ItemType.TWO_ITEM) {
            return TYPE_TWO;
        } else {
            return -1;
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==TYPE_ONE) {
            View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_left,viewGroup,false);
            return new VHone(view);
        } else if (i == TYPE_TWO) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_right, viewGroup, false);
            return new VHTwo(view);
        } else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case TYPE_ONE:
                initLayoutOne((VHone) viewHolder, i);
                break;
            case TYPE_TWO:
                initLayoutTwo((VHTwo) viewHolder, i);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    private void initLayoutOne(VHone holder, int pos) {
        holder.tvLeft.setText(userArrayList.get(pos).getUsername());
    }

    private void initLayoutTwo(VHTwo holder, int pos) {
        holder.tvRight.setText(userArrayList.get(pos).getUsername());
    }

  static   class VHone extends RecyclerView.ViewHolder{

      public TextView tvLeft;
      public VHone(View itemView) {
          super(itemView);
          tvLeft = (TextView) itemView.findViewById(R.id.tvLeft);
      }
    }
    static class VHTwo extends RecyclerView.ViewHolder{
        public TextView  tvRight;
        public VHTwo(@NonNull View itemView) {
            super(itemView);
            tvRight = (TextView) itemView.findViewById(R.id.tvRight);

        }
    }
}
