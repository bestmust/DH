package com.example.dh;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends Activity {

	EditText usernameR, emailR, phoneR, addressR, passwordR;
	Button registerR;
	SharedPreferences sp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		init();
		registerR.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// -----------------------------------user name and password save  locally
				Editor ed = sp.edit();
				ed.putString("user_name_login", emailR.getText().toString());
				ed.putString("password_login", passwordR.getText().toString());
				ed.commit();
				
				// ------------------------------------------run a task to update details on db
				
				
				// -------------------------------------------navigate user to main page
				Intent i = new Intent(Registration.this, MainActivity.class);
				startActivity(i);
				overridePendingTransition(R.anim.side_down, R.anim.slide_up);
			}
		});
	}

	private void init() {
		// TODO Auto-generated method stub
		sp = PreferenceManager.getDefaultSharedPreferences(Registration.this);
		usernameR = (EditText)findViewById(R.id.editTextUserNameRegister);
		emailR = (EditText)findViewById(R.id.editTextEmailRegister);
		phoneR = (EditText)findViewById(R.id.editTextPhoneRegister);
		addressR = (EditText)findViewById(R.id.editTextAddressRegister);
		passwordR = (EditText)findViewById(R.id.editTextPassword);
		registerR = (Button)findViewById(R.id.buttonRegisterRegistration);
	}

	

}
