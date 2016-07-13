package me.cassiano.randompeopledatabindingexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.cassiano.randompeopledatabindingexample.R;
import me.cassiano.randompeopledatabindingexample.holder.PersonViewHolder;
import me.cassiano.randompeopledatabindingexample.model.Result;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final List<Result> results = new ArrayList<>();

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View statusContainer = inflater.inflate(R.layout.user_item, parent, false);
        return new PersonViewHolder(statusContainer);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {

        Result status = results.get(position);
        holder.bind(status);

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Result> results) {
        this.results.clear();
        this.results.addAll(results);
        notifyDataSetChanged();
    }

}
