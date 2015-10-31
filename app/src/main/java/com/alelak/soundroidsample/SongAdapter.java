package com.alelak.soundroidsample;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alelak.soundroid.Soundroid;
import com.alelak.soundroid.models.Track;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {
    private List<Track> tracks;
    private Context context;
    private MediaPlayer mediaPlayer;

    public SongAdapter(List<Track> tracks, Context context) {
        this.tracks = tracks;
        this.context = context;
        this.mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        final Track track = tracks.get(position);
        holder.title.setText(track.title);
        Glide.with(context).load(track.artwork_url).error(R.color.colorPrimary).into(holder.artwork);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mediaPlayer.isPlaying()) {
                    try {
                        mediaPlayer.setDataSource(track.stream_url + "?client_id=" + Soundroid.getClient_id());
                        mediaPlayer.prepareAsync();
                    } catch (IOException e) {
                        Toast.makeText(context, "Playback error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }


    protected static class SongViewHolder extends RecyclerView.ViewHolder {
        public final ImageView artwork;
        public final TextView title;

        public SongViewHolder(View view) {
            super(view);
            artwork = (ImageView) view.findViewById(R.id.artwork);
            title = (TextView) view.findViewById(R.id.title);
        }

    }
}
