package com.example.dh;

import com.example.asyctask.RegistrationTask;
import com.example.datamodels.RegistrationModel;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends Activity implements OnClickListener {

	EditText usernameR, emailR, phoneR, addressR, passwordR;
	Button registerR;
	SharedPreferences sp;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		init();

		registerR.setOnClickListener(this);

	}

	private void init() {
		sp = PreferenceManager.getDefaultSharedPreferences(Registration.this);
		usernameR = (EditText)findViewById(R.id.editTextUserNameRegister);
		emailR = (EditText)findViewById(R.id.editTextEmailRegister);
		phoneR = (EditText)findViewById(R.id.editTextPhoneRegister);
		addressR = (EditText)findViewById(R.id.editTextAddressRegister);
		passwordR = (EditText)findViewById(R.id.editTextPassword);
		registerR = (Button)findViewById(R.id.buttonRegisterRegistration);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){

		case R.id.buttonRegisterRegistration:

			
			if(usernameR.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(Registration.this,"Warning", "Please Enter UserName");
			}else if(emailR.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(Registration.this,"Warning", "Please Enter Email");
			}else if(phoneR.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(Registration.this,"Warning", "Please Enter Phone number");
			}else if(addressR.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(Registration.this,"Warning", "Please Enter Address");
			}else if(passwordR.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(Registration.this,"Warning", "Please Enter Password");
			}else{
			
				Editor ed = sp.edit();
				ed.putString("user_name_login", emailR.getText().toString());
				ed.putString("password_login", passwordR.getText().toString());
				ed.commit();

				// ------------------------------------------run a task to update details on db
				RegistrationModel rModel = new RegistrationModel();
				rModel.setUserName(usernameR.getText().toString());
				rModel.setPhone(phoneR.getText().toString());
				rModel.setAddress(addressR.getText().toString());
				rModel.setPassword(passwordR.getText().toString());
				rModel.setEmail(emailR.getText().toString());

				new RegistrationTask(Registration.this).execute(rModel);
			}
			// -------------------------------------------navigate user to main page
			Intent i = new Intent(Registration.this, MainActivity.class);
			startActivity(i);
			overridePendingTransition(R.anim.side_down, R.anim.slide_up);

			break;
		}
	}
}
