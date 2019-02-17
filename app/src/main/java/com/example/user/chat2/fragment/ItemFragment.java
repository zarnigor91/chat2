package com.example.user.chat2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.chat2.ItemClickListener;
import com.example.user.chat2.R;
import com.example.user.chat2.activity.MessageActivity;
import com.example.user.chat2.activity.NavigationActivity;
import com.example.user.chat2.adapter.UserAdapter;
import com.example.user.chat2.model.User;

import java.util.ArrayList;

public class ItemFragment extends Fragment implements ItemClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_fragment, container, false);
    }
    ArrayList<User> list;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
        list = bundle.getParcelableArrayList("list");
            RecyclerView rv = view.findViewById(R.id.rv);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            UserAdapter adapter = new UserAdapter(list,this);
//            adapter.setClickListener(this);
            rv.setAdapter(adapter);
        }
    }

    public static ItemFragment getIntance(ArrayList<User> users) {
        ItemFragment itemFragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", users);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Override
    public void onClick(View view, int position) {
        final User user=list.get(position);
        Intent intent1=new Intent(getContext(), MessageActivity.class);
        intent1.putExtra("name",user.getUsername());
        intent1.putExtra("useImage", user.getImageURL());
        intent1.putExtra("Status", user.getStatus());
        startActivity(intent1);
    }
}
