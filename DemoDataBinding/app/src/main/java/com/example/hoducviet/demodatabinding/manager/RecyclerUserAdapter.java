package com.example.hoducviet.demodatabinding.manager;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hoducviet.demodatabinding.R;
import com.example.hoducviet.demodatabinding.databinding.UserItemBinding;
import com.example.hoducviet.demodatabinding.model.User;

import java.util.ArrayList;

/**
 * Created by HODUCVIET on 9/12/2017.
 */

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.ViewHolderUser> {
    private Context context ;
    private ArrayList<User> arrayList ;

    public RecyclerUserAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolderUser onCreateViewHolder(ViewGroup parent, int viewType) {
        UserItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.user_item,parent,false);
        return new ViewHolderUser(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolderUser holder, int position) {
        User user = arrayList.get(position);
        holder.setBinding(user);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolderUser extends RecyclerView.ViewHolder{
        public ObservableField<String> mName = new ObservableField<>();
        public ObservableField<String> mAddress = new ObservableField<>();
        public UserItemBinding binding;
        public ViewHolderUser(UserItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
        public void setBinding(User user){
            if(binding.getUser() == null) binding.setUser(this);
            mName.set(user.getName());
            mAddress.set(user.getAddress());
        }

    }
}
