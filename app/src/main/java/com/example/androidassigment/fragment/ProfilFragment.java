package com.example.androidassigment.fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.androidassigment.R;
import com.example.androidassigment.Utils;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.text.Format;

import io.reactivex.annotations.NonNull;

public class ProfilFragment extends Fragment {
    TextView fNa;
    TextView sNa;
    TextView eMa;
    TextView pic;
    ImageView imView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profil, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        Button b = (Button)view.findViewById(R.id.buttonProfil);
        String url = Utils.PROFILE_URL;
        fNa = (TextView) view.findViewById(R.id.fnameView);
        sNa = (TextView) view.findViewById(R.id.snameView);
        eMa = (TextView) view.findViewById(R.id.emailView);
        pic = (TextView) view.findViewById(R.id.urlView);
        imView = (ImageView) view.findViewById(R.id.imageView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new background().execute(Utils.PROFILE_URL);
            }
        });
    }

    class background extends AsyncTask<String,String,String> {

    protected String doInBackground(String ... params){
        HttpURLConnection connection = null;
        BufferedReader br = null;
        try {
            URL url = new URL(params[0]);

            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String satir;
            String dosya = "";
            while ((satir=br.readLine()) != null){
                dosya += satir;
            }
            return dosya;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    protected void onPostExecute(String s){
        try {
            String fName="";
            String sName="";
            String eMail="";
            String pUrl="";
            JSONObject json = new JSONObject(s);
            fName = json.getJSONArray("results").get(0).toString();
            json = new JSONObject(fName);
            fName = json.getJSONObject("name").getString("first");
            sName = json.getJSONObject("name").getString("last");
            eMail = json.getString("email");
            pUrl = json.getJSONObject("picture").getString("large");
            fNa.setText(fName);
            sNa.setText(sName);
            eMa.setText(eMail);
            pic.setText(pUrl);
            Picasso.get().load(pUrl).into(imView);


        }catch (Exception e){
            System.out.println("error on parse");
            e.printStackTrace();
        }

    }
    }

}