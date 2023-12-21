package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewClass> {
    private ArrayList<Post> posts;
    private Context context;

    public Adapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        MyViewClass myViewClass = new MyViewClass(view);
        return myViewClass;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        Post post = posts.get(position);

        holder.userName.setText(post.getUserName());
        holder.postTitle.setText(post.getPostTitle());

        // Загрузка изображения с использованием Picasso
        Picasso.get().load(post.getAvatarUrl()).into(holder.avatarImageView);

        // Устанавливаем иконку лайка/дизлайка в зависимости от статуса
        if (post.isLiked()) {
            holder.likeImageView.setImageResource(R.drawable.like);
        } else {
            holder.likeImageView.setImageResource(R.drawable.dislike);
        }

        // Нажатие на кнопку "Подробности"
        holder.buttonOpenDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPostDetailFragment(post);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder {
        TextView userName;
        TextView postTitle;
        ImageView avatarImageView;
        ImageView likeImageView;
        ImageView buttonOpenDetails;

        public MyViewClass(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.textViewUserName);
            postTitle = itemView.findViewById(R.id.textViewTitle);
            avatarImageView = itemView.findViewById(R.id.imageView);
            likeImageView = itemView.findViewById(R.id.imageViewLike);
            buttonOpenDetails = itemView.findViewById(R.id.buttonOpenDetails);
        }
    }

    private void openPostDetailFragment(Post post) {

        PostDetailFragment fragment = new PostDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("userName", post.getUserName());
        bundle.putString("postTitle", post.getPostTitle());
        bundle.putString("postText", post.getPostText());
        bundle.putString("avatarUrl", post.getAvatarUrl());
        bundle.putBoolean("isLiked", post.isLiked());

        fragment.setArguments(bundle);
        FragmentActivity activity = (FragmentActivity) context;
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
