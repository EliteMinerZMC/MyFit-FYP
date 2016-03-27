package com.joshuamiddletonfyp.myfitandroidfitnesspackage.GraphFragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LineGraphStat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LineGraphStat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LineGraphStat extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LineChart chart2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LineGraphStat.
     */
    // TODO: Rename and change types and number of parameters
    public static LineGraphStat newInstance(String param1, String param2) {
        LineGraphStat fragment = new LineGraphStat();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public LineGraphStat() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_statistics, container, false);

        chart2 = (LineChart) rootView.findViewById(R.id.linechart1);
        ArrayList<Entry> valsComp1 = new ArrayList<Entry>();

        Entry c1e1 = new Entry(0, 0); // 0 == quarter 1
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(600, 1); // 1 == quarter 2 ...
        valsComp1.add(c1e2);
        Entry c1e3 = new Entry(700, 2); // 1 == quarter 2 ...
        Entry c1e4 = new Entry(750, 3); // 1 == quarter 2 ...
        Entry c1e5 = new Entry(1200, 4); // 1 == quarter 2 ...
        Entry c1e6 = new Entry(1250, 5); // 1 == quarter 2 ...
        Entry c1e7 = new Entry(1280, 6); // 1 == quarter 2 ...
        valsComp1.add(c1e3);
        valsComp1.add(c1e4);
        valsComp1.add(c1e5);
        valsComp1.add(c1e6);
        valsComp1.add(c1e7);

        LineDataSet setComp1 = new LineDataSet(valsComp1, "My Steps");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);

        // use the interface ILineDataSet
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("6:00"); xVals.add("10:00"); xVals.add("11:00"); xVals.add("15:00"); xVals.add("18:00"); xVals.add("20:00"); xVals.add("23:00");
        LineData data = new LineData(xVals, dataSets);
        chart2.setData(data);
        chart2.invalidate(); // refresh
        return rootView;
         }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
