package cl.gersard.trackingchile.uii.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.gersard.trackingchile.R;
import cl.gersard.trackingchile.domain.Tracking;

/**
 * Created by criga on 15/08/2017.
 */

public class TrackingListAdapter extends RecyclerView.Adapter<TrackingListAdapter.TrackingListViewHolder> {

    ArrayList<Tracking> trackings;
    Context context;

    public TrackingListAdapter(Context context) {
        this.context = context;
        //para evitar null pointer exception
        this.trackings = new ArrayList<>();
    }

    @Override
    public TrackingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_tracking_list, parent, false);

        return new TrackingListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrackingListViewHolder holder, int position) {
        Tracking currentTracking = trackings.get(position);

        holder.setTrackingName(currentTracking.getName());
    }

    @Override
    public int getItemCount() {
        return trackings.size();
    }

    public void addTrackings(@NonNull ArrayList<Tracking> trackings) {
        if (trackings == null) {
            throw new NullPointerException("Tracking no puede ser un array nulo");
        }

        this.trackings.addAll(trackings);
        notifyDataSetChanged();
    }

    public class TrackingListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_code)
        TextView txtCode;
        @BindView(R.id.txt_date)
        TextView txtDate;


        public TrackingListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setTrackingName(String name) {
            txtName.setText(name);
        }
    }
}