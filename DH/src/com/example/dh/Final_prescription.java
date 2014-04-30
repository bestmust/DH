package com.example.dh;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Final_prescription extends Fragment {
Button save , exitPatient;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {

	View v = inflater.inflate(R.layout.activity_patients_final_prescription, null);
	save = (Button)v.findViewById(R.id.buttonSavePrescription);
	exitPatient = (Button)v.findViewById(R.id.buttonLogoutPrescription);
	exitPatient.setOnClickListener(new  OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(getView().getContext(), MainActivity.class);
			startActivity(i);
		}
	});
	
	save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(save.getText().equals("Save"))
			{
				save.setText("Print");
			}
		}
	});

	return v;
}

	
}