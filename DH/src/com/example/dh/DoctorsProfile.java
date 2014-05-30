package com.example.dh;

import com.example.asyctask.DoctorsProfileTask;
import com.example.datamodels.DoctorsModel;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorsProfile extends Fragment {

	ImageView photo ;
	TextView userName, address, specialization, experience, contact;
	Button showOnamp;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.activity, null);
		photo = (ImageView)v.findViewById(R.id.imageViewUserPhoto);
		userName = (TextView)v.findViewById(R.id.textViewUserName);
		address = (TextView)v.findViewById(R.id.textViewAddressUser);
		specialization = (TextView)v.findViewById(R.id.textViewSpecialization);
		experience = (TextView)v.findViewById(R.id.textViewExperience);
		contact = (TextView)v.findViewById(R.id.textViewContactInfo);
		showOnamp = (Button)v.findViewById(R.id.showOnMApDoctorsProfile);

		return v;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		//Adjust as per your db----------
		String userId="1";
		
		DoctorsModel objDoctorsModel = new DoctorsModel();
		objDoctorsModel.setDoctorId(userId);
		
		new DoctorsProfileTask(getActivity()).execute(objDoctorsModel);
		
	}

}
