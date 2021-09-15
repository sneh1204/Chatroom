package com.example.chatroom.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatroom.R;
import com.example.chatroom.databinding.TripLayoutBinding;
import com.example.chatroom.models.Trip;
import com.example.chatroom.models.User;
import com.example.chatroom.models.Utils;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.UViewHolder> {

    ArrayList<Trip> trips;

    String type;

    User user;

    TripLayoutBinding binding;

    public TripAdapter(String type, User user, ArrayList<Trip> trips) {
        this.type = type;
        this.user = user;
        this.trips = trips;
    }

    @NonNull
    @Override
    public UViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = TripLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UViewHolder holder, int position) {
        Trip trip = trips.get(position);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        holder.binding.textView25.setText("Trip #" + trip.getNumber());
        holder.binding.textView33.setText(trip.getType() + "r");

        if (trip.getDriverId().equals(user.getId())) {
            holder.binding.textView30.setText("Rider: " + trip.getRiderName());
        } else {
            holder.binding.textView30.setText("Driver: " + trip.getDriverName());
        }

        holder.binding.textView32.setText(Utils.getDateString(trip.getStarted_at()));
        holder.binding.textView31.setText(trip.getStatus());

        if (trip.isOngoing()) {
            holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Utils.DB_TRIP, trip);
                    Navigation.findNavController(holder.itemView).navigate(R.id.action_tripListFragment_to_tripInfoFragment, bundle);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.trips.size();
    }

    public static class UViewHolder extends RecyclerView.ViewHolder {

        TripLayoutBinding binding;

        public UViewHolder(@NonNull TripLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}
