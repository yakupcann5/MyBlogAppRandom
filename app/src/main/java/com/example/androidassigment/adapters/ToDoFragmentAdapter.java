package com.example.androidassigment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidassigment.R;
import com.example.androidassigment.model.Post;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ToDoFragmentAdapter extends RecyclerView.Adapter<ToDoFragmentAdapter.ViewHolder> {
    ArrayList<Post> post;
    Context context;
    public String textViewCompleted  ;

    public ToDoFragmentAdapter(ArrayList<Post> post, Context context){
        this.post=post;
        this.context=context;
    }
    @NonNull
    @Override
    public ToDoFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_todo_row, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ToDoFragmentAdapter.ViewHolder holder, int position) {
        holder.textViewId.setText(Integer.toString(post.get(position).getId()));
        holder.textViewTitle.setText(post.get(position).getTitle());
        holder.textViewCompleted.setText(post.get(position).getComplate());
        holder.textViewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view , "Completed "+textViewCompleted, Snackbar.LENGTH_SHORT)
                        .setAction("Action" , null)
                        .show();
            }
        });
    }
    @Override
    public int getItemCount() {
       return post.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewId;
        TextView textViewTitle;
        TextView textViewCompleted;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewCompleted = itemView.findViewById(R.id.textViewComplate);
        }
    }

}
