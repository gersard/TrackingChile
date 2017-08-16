package cl.gersard.trackingchile.uii.adapter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cl.gersard.trackingchile.R;
import cl.gersard.trackingchile.domain.Tracking;
import cl.gersard.trackingchile.uii.adapter.ItemOffsetDecoration;
import cl.gersard.trackingchile.uii.adapter.TrackingListAdapter;

/**
 * Created by criga on 15/08/2017.
 */

public class TrackingListFragment extends Fragment /*implements Callback<TopArtistResponse>*/ {

    public static final int NUM_COLUMN = 2;
    @BindView(R.id.tracking_list)
    RecyclerView mTrackingList;
    Unbinder unbinder;

    //m = memberClass
    private TrackingListAdapter adapter;
    //private TrackingResponse call;
    //private Response<TrackingResponse> response;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new TrackingListAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_tracking_list, container, false);
        unbinder = ButterKnife.bind(this, root);

        //A la vista inflada busca otra vista

        setupTrackingList();
        setTrackingContent();
        return root;
    }

    private void setupTrackingList() {
        mTrackingList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMN));
        mTrackingList.setAdapter(adapter);
        mTrackingList.addItemDecoration(new ItemOffsetDecoration(getContext(), R.integer.offset));
    }

    private void setTrackingContent() {
        ArrayList<Tracking> trackings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            trackings.add(new Tracking("Tracking" + i, "4564ALS0091", "25/08/2015"));
        }

        adapter.addTrackings(trackings);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
