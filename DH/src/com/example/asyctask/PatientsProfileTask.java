package com.example.asyctask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.datamodels.PatientsParameterModel;
import com.example.dh.PatientsLogin;
import com.example.dh.PatientsProfile;
import com.google.gson.Gson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class PatientsProfileTask extends AsyncTask<PatientsParameterModel, String, String>{

	Activity _patiensProfile;
	String jsonResponseString;
	ProgressDialog pd;

	public PatientsProfileTask(Activity activity) {
		// TODO Auto-generated constructor stub
		_patiensProfile = activity;
	}



	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}



	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pd= new ProgressDialog(_patiensProfile);
		pd.setMessage("Please Wait..");
		pd.setCancelable(false);
		//	 pd.show();
	}



	@Override
	protected String doInBackground(PatientsParameterModel... params) {

		PatientsParameterModel objPatientsParameterModel  = params[0];


		Log.d("PatiensId", ""+objPatientsParameterModel.getPatientsId());

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