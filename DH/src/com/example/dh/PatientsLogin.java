package com.example.dh;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class PatientsLogin extends Fragment {
	
	EditText patientsId;
	Button find, newUser;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_patients_login, null);
		
		patientsId = (EditText)v.findViewById(R.id.editTextPatientsUserName);
		find = (Button)v.findViewById(R.id.buttonFindPatient);
		newUser = (Button)v.findViewById(R.id.buttonAddNewPatient);
		find.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(getView().getContext(), PatientsProfile.class);
				startActivity(i);
			}
		});
		newUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getView().getContext(), "New Patient", Toast.LENGTH_LONG).show();
				Intent i = new Intent(getView().getContext(), AddPatient.class);
				startActivity(i);

			}
		});

		return v;
	}
	
	
	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_patients_login);
//		
//		getActionBar().setDisplayHomeAsUpEnabled(true);
//		getActionBar().setHomeButtonEnabled(true);
//		
//		patientsId = (EditText)findViewById(R.id.editTextPatientsUserName);
//		find = (Button)findViewById(R.id.buttonFindPatient);
//		newUser = (Button)findViewById(R.id.buttonAddNewPatient);
//		find.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//				Toast.makeText(PatientsLogin.this, "Find Patient", Toast.LENGTH_LONG).show();
//				Intent i = new Intent(PatientsLogin.this, PatientsProfile.class);
//				startActivity(i);
//				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//			}
//		});
//		newUser.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(PatientsLogin.this, "New Patient", Toast.LENGTH_LONG).show();
//				Intent i = new Intent(PatientsLogin.this, AddPatient.class);
//				startActivity(i);
//				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//
//			}
//		});
//	}

//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.patients_login, menu);
//		return true;
//	}

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setHasOptionsMenu(true);
	}

	public void onCreateOptionsMenu(Menu menu) {
	    // Do something that differs the Activity's menu here
	//    super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
//	    case R.id.activity_menu_item:
//	        // Not implemented here
//	        return false;
//	    case R.id.fragment_menu_item:
//	        // Do Fragment menu item stuff here
//	        return true;
	    default:
	        break;
	    }

	    return false;
	}
	
	
}
