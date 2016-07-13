package me.cassiano.randompeopledatabindingexample.holder;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.cassiano.randompeopledatabindingexample.databinding.UserItemBinding;
import me.cassiano.randompeopledatabindingexample.model.Result;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private UserItemBinding binding;

    public PersonViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(Result status) {
        binding.setUser(status);
    }
}