package edu.sjsu.izzymoriguchi.travelmap;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements CreateTripDialogFragment.EditNameDialogListener {
    private static final String TAG = "MainActivity";
    private ArrayList<Trip> trips;
    private TripAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        trips = Trip.createContactsList();

        // Create adapter passing in the sample user data
        adapter = new TripAdapter(trips);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button clicked", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                CreateTripDialogFragment dialogFragment = new CreateTripDialogFragment();
                dialogFragment.show(fragmentManager, "test");
            }
        });
    }

    @Override
    public void onFinishEditDialog(String tripName) {
        Trip newTrip = new Trip(tripName);

        int tripSize = adapter.getItemCount();
        trips.add(newTrip);
        adapter.notifyItemInserted(tripSize);

    }
}
