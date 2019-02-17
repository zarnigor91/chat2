package com.example.user.chat2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.chat2.ItemClickListener;
import com.example.user.chat2.R;
import com.example.user.chat2.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.VH> {

    private ArrayList<User> users;
    private ItemClickListener clickListener;

    public UserAdapter(ArrayList<User> users,ItemClickListener clickListener) {
        this.users = users;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, viewGroup, false),clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.bindData(users.get(i));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener=itemClickListener;
    }

    class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ItemClickListener itemClickListener;

        VH(@NonNull View itemView,ItemClickListener listener) {
            super(itemView);
            this.itemClickListener = listener;
            textView = itemView.findViewById(R.id.username);
            itemView.setOnClickListener(this);
        }

        void bindData(User user) {
            textView.setText(user.getUsername());
        }

        @Override
        public void onClick(View v) {
           if (itemClickListener!=null) itemClickListener.onClick(v, getAdapterPosition());
        }
    }
}
