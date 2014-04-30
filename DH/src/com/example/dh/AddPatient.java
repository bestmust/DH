package com.example.dh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class AddPatient extends Activity {
Button donee, setimage;
EditText username, address, contact,  DOB;
RadioGroup PatientGender;
ImageView imgUserPhoto;
String nameP, addressP, contactP, dOBP, sexP, imageP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stube
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_adddpatient);
		
		donee = (Button)findViewById(R.id.buttonAddPatient);
		setimage = (Button)findViewById(R.id.buttonSetImagePatient);
		username = (EditText)findViewById(R.id.UserNamePatientAdd);
		address = (EditText)findViewById(R.id.UserAddressPatientAdd);
		contact = (EditText )findViewById(R.id.UserContactPatientAdd);
		DOB= (EditText)findViewById(R.id.UserDOBPatientAdd);
		PatientGender = (RadioGroup)findViewById(R.id.radioGroupGender);
		
		donee.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(AddPatient.this, PatientsProfile.class);
				startActivity(i);
			}
		});
		
		setimage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// capture from camera
				
			}
		});
	}

}
