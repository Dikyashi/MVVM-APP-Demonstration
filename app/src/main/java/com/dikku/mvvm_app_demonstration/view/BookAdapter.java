package com.dikku.mvvm_app_demonstration.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dikku.mvvm_app_demonstration.R;
import com.dikku.mvvm_app_demonstration.model.Volume;
import com.dikku.mvvm_app_demonstration.model.VolumeResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dikyashitamang on 26/02/22
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    List<Volume> mVolumeResponses = new ArrayList<>();

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.book_item, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Volume volume = mVolumeResponses.get(position);

        holder.mTitle.setText(volume.getVolumeInfo().getTitle());
        holder.mPublished.setText(volume.getVolumeInfo().getPublishedDate());

        if (volume.getVolumeInfo().getSmallThumbnail() != null) {
            String image = volume.getVolumeInfo().getSmallThumbnail().getSmallThumbnail()
                    .replace("http://", "https://");

                    Glide.with(holder.itemView)
                    .load(image).into(holder.bookImageView);

        }

        if(volume.getVolumeInfo().getAuthors()!=null){

            for(String author: volume.getVolumeInfo().getAuthors()) {
                holder.mAuthor.append(author+"\n");
            }
        }

    }

    @Override
    public int getItemCount() {
        return mVolumeResponses.size();

    }

    public void setVolumeResponses(List<Volume> volumeResponses) {
        mVolumeResponses = volumeResponses;
        notifyItemInserted(mVolumeResponses.size() - 1);
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private ImageView bookImageView;
        private TextView mTitle, mAuthor, mPublished;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImageView = itemView.findViewById(R.id.book_imageView);
            mTitle = itemView.findViewById(R.id.book_item_title);
            mAuthor = itemView.findViewById(R.id.book_item_authors);
            mPublished = itemView.findViewById(R.id.book_item_publishedDate);
        }
    }
}
