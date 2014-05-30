package com.example.asyctask;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.example.datamodels.LoginModel;
import com.example.dh.Login;
import com.example.dh.util.Constants;
import com.google.gson.Gson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class LoginTask extends AsyncTask<LoginModel, String, String> {

	Activity  mLogin;
	ProgressDialog pd;
	String jsonResponseString;
	
	public LoginTask(Login login) {
	mLogin  = login;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pd = new ProgressDialog(mLogin);
		pd.setMessage("Please Wait..");
		pd.setCancelable(false);
	}

	@Override
	protected String doInBackground(LoginModel... params) {
	
		LoginModel objLoginModel = params[0];
		
		Log.d("username", ""+objLoginModel.getUserName());
		Log.d("password", ""+objLoginModel.getPassword());
		
		Gson gson = new Gson();
		String request = gson.toJson(params[0]);
		Log.d("gson is", ""+request);
		
		HttpResponse response;

		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();

		//Creating HttpPost
		//Modify your url
	/*	HttpPost httpPost = new HttpPost(Constants.SERVER_URL +"/controllername");
		
		Log.d("Call to servlet", "Call servlet");

		// Building post parameters, key and value pair
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		nameValuePair.add(new BasicNameValuePair("jsondata", request));

		Log.d("cac", "NameValuePair"+nameValuePair);
		// Url Encoding the POST parameters
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
		}
		catch (UnsupportedEncodingException e) {
			// writing error to Log
			e.printStackTrace();
		}
		try {

			System.out.println("Executing...");
			response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			jsonResponseString = EntityUtils.toString(entity);
			Log.d("Http Response:",jsonResponseString);

		}catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return jsonResponseString;
	}

}