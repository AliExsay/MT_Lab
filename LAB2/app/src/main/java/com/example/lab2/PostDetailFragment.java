package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class PostDetailFragment extends Fragment {
    private TextView userNameTextView;
    private TextView postTitleTextView;
    private TextView postTextView;
    private ImageView avatarImageView;
    private ImageView likeImageView;
    private ImageButton closeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);

        closeButton = view.findViewById(R.id.buttonClose);
        userNameTextView = view.findViewById(R.id.detailUserName);
        postTitleTextView = view.findViewById(R.id.detailPostTitle);
        postTextView = view.findViewById(R.id.detailPostText);
        avatarImageView = view.findViewById(R.id.detailAvatar);
        likeImageView = view.findViewById(R.id.detailLike);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Закрываем текущий фрагмент и возвращаемся к предыдущему фрагменту (если есть)
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            String userName = bundle.getString("userName");
            String postTitle = bundle.getString("postTitle");
            String postText = bundle.getString("postText");
            String avatarUrl = bundle.getString("avatarUrl");
            boolean isLiked = bundle.getBoolean("isLiked");

            userNameTextView.setText(userName);
            postTitleTextView.setText(postTitle);
            postTextView.setText(postText);

            // Загрузка изображения с использованием Picasso
            Picasso.get().load(avatarUrl).into(avatarImageView);

            // Устанавливаем иконку лайка/дизлайка в зависимости от статуса
            if (isLiked) {
                likeImageView.setImageResource(R.drawable.like);
            } else {
                likeImageView.setImageResource(R.drawable.dislike);
            }
        }

        return view;
    }
}
