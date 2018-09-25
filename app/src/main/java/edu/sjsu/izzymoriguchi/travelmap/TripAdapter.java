package edu.sjsu.izzymoriguchi.travelmap;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private List<Trip> tripList;

    public TripAdapter(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Trip trip = tripList.get(position);

        holder.tripName.setText(trip.getNameOfTrip());

    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tripName;
        public ImageView tripImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tripName = itemView.findViewById(R.id.trip_name);
            tripImage = itemView.findViewById(R.id.trip_image);
        }
    }


}
