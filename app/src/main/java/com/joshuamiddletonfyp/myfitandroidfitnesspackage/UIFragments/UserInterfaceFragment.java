package com.joshuamiddletonfyp.myfitandroidfitnesspackage.UIFragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.DataManagment.DataDBManager;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.DataManagment.StepData;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.R;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserInterfaceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserInterfaceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */ public class UserInterfaceFragment extends Fragment implements SensorEventListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    protected String UserLogin = "Login To Go Here";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button start;
    Button stop;
    Boolean running;
    SensorManager stepManager;
    SharedPreferences prefs;
    TextView steps;

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
     * @return A new instance of fragment UserInterfaceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserInterfaceFragment newInstance(String param1, String param2) {
        UserInterfaceFragment fragment = new UserInterfaceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public UserInterfaceFragment() {
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user_interface, container, false);
        getActivity().setTitle("ManualRecord-NoBand");
        steps = (TextView)rootView.findViewById(R.id.stepCounter);
        prefs = getActivity().getSharedPreferences("prefs",Context.MODE_PRIVATE);
        running = false;
        start = (Button)rootView.findViewById(R.id.startSteps);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        stop = (Button)rootView.findViewById(R.id.stopSteps);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
        stepManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);

        return rootView;
    }

    private void start() {
        running = true;
        Sensor stepper = stepManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (stepper != null) {
            stepManager.registerListener(this, stepper, SensorManager.SENSOR_DELAY_UI);
        }
    }

    private void stop() {
        running = false;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onUserInterfaceFragment(uri);
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running){
            DataDBManager db = new DataDBManager();
            StepData data = new StepData();
            int iSteps = (int)event.values[0];
            data.setSteps(iSteps);
            data.setUsername(prefs.getString("LoginUser","test"));
            Calendar c = Calendar.getInstance();
            int month = c.get(Calendar.MONTH);
            int year = c.get(Calendar.YEAR);
            int day = c.get(Calendar.DAY_OF_MONTH);
            int hour = c.get(Calendar.HOUR_OF_DAY);
            data.setYear(year);
            data.setMonth(month);
            data.setDay(day);
            data.setHour(hour);
            db.writeToDB(data,getActivity().getApplicationContext());
            steps.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onUserInterfaceFragment(Uri uri);
    }

}
