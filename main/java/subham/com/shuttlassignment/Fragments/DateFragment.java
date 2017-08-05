package subham.com.shuttlassignment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import subham.com.shuttlassignment.R;


public class DateFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "date";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String date;
    TextView tvDate1;
    public DateFragment() {
        // Required empty public constructor
    }

    public static DateFragment newInstance(String date) {
        DateFragment fragment = new DateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            date=getArguments().getString(ARG_PARAM1);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView= inflater.inflate(R.layout.fragment_date, container, false);
        tvDate1=(TextView)itemView.findViewById(R.id.tvDate1);
        tvDate1.setText(date);
        return itemView;
    }

}
