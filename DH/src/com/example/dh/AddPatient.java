package com.example.dh;

import com.example.asyctask.AddNewPatienTask;
import com.example.datamodels.NewPatientModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class AddPatient extends Activity implements OnClickListener {
	
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

		init();
		
		donee.setOnClickListener(this);
		
	
		setimage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// capture from camera

			}
		});
	}

	private void init() {
		
		donee = (Button)findViewById(R.id.buttonAddPatient);
		setimage = (Button)findViewById(R.id.buttonSetImagePatient);
		username = (EditText)findViewById(R.id.UserNamePatientAdd);
		address = (EditText)findViewById(R.id.UserAddressPatientAdd);
		contact = (EditText )findViewById(R.id.UserContactPatientAdd);
		DOB= (EditText)findViewById(R.id.UserDOBPatientAdd);
		PatientGender = (RadioGroup)findViewById(R.id.radioGroupGender);

		
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()){
		
		case R.id.buttonAddPatient:
			
			if(username.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(AddPatient.this,"Warning", "Please Enter UserName");
			}else if(address.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(AddPatient.this,"Warning", "Please Enter Address");
			}else if(contact.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(AddPatient.this,"Warning", "Please Enter Contact number");
			}else if(DOB.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(AddPatient.this,"Warning", "Please Enter DOB");
			}else{
				
				NewPatientModel objNewPatientModel = new NewPatientModel();
				objNewPatientModel.setPatientsName(username.getText().toString());
				objNewPatientModel.setPatientsAddress(address.getText().toString());
				objNewPatientModel.setPatientsContact(contact.getText().toString());
				objNewPatientModel.setPatientsDOB(DOB.getText().toString());
				
				
				new AddNewPatienTask(AddPatient.this).execute(objNewPatientModel);
			}
		
			
			
			Intent i = new Intent(AddPatient.this, PatientsProfile.class);
			startActivity(i);

			
			break;
			
		}
		
	}

}
