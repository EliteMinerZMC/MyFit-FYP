package com.joshuamiddletonfyp.myfitandroidfitnesspackage.UIFragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.joshuamiddletonfyp.myfitandroidfitnesspackage.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GoalsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GoalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoalsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public SeekBar sb;
    public TextView units;
    public Spinner spinner;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GoalsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GoalsFragment newInstance(String param1, String param2) {
        GoalsFragment fragment = new GoalsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public GoalsFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_goals, container, false);
        spinner = (Spinner)rootView.findViewById(R.id.spinner);
        ArrayList<String> spinnerArray =  new ArrayList<String>();
        sb = (SeekBar)rootView.findViewById(R.id.seekBar);
        units = (TextView)rootView.findViewById(R.id.units);
        spinnerArray.add("Steps");
        spinnerArray.add("Distance");
        spinnerArray.add("Speed");
        spinnerArray.add("Calories");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(), android.R.layout.activity_list_item, spinnerArray);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem().equals("Speed")) {
                    sb.setMax(15);
                    units.setText("Miles Per Hour");
                } else if (spinner.getSelectedItem().equals("Steps")) {
                    sb.setMax(20000);
                    units.setText("Steps");
                } else if (spinner.getSelectedItem().equals("Distance")) {
                    sb.setMax(5);
                    units.setText("Distance");
                } else if (spinner.getSelectedItem().equals("Calories")) {
                    sb.setMax(1000);
                    units.setText("Miles");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button goalSet = (Button)rootView.findViewById(R.id.set_goal);
        goalSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGoal();
            }
        });
        return rootView;
    }

    private void setGoal() {
        SharedPreferences prefs = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("CurrentGoal", spinner.getSelectedItem().toString());
        editor.putInt("GoalValue",sb.getMax());
        editor.commit();
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
