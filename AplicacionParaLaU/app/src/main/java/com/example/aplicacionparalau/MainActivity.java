package com.example.aplicacionparalau;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SimpleAdapter adapter;
    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new SimpleAdapter(new ArrayList<Product>(), this);
        listView = findViewById(R.id.wListView);
        listView.setAdapter(adapter);
        (new AsyncListViewLoader()).execute("http://fakeapi.jsonparseronline.com/posts?_page=1&_limit=20");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ImageView imageView = view.findViewById(R.id.wImage);
                TextView description = view.findViewById(R.id.wTitle);
                TextView likes = view.findViewById(R.id.wLikes);
                imageView.buildDrawingCache();
                Bundle extras = new Bundle();
                extras.putParcelable("image", imageView.getDrawingCache());
                extras.putString("description", String.valueOf(description.getText()));
                extras.putString("likes", String.valueOf(likes.getText()));
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    private class AsyncListViewLoader extends AsyncTask<String, Void, List<Product>>{
        private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPostExecute(List<Product> products) {
            super.onPostExecute(products);
            dialog.dismiss();
            adapter.setItemList(products);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Descargando datos...");
            dialog.show();
        }

        @Override
        protected List<Product> doInBackground(String... params) {
            List<Product> result = new ArrayList<Product>();
            try {
                URL u = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) u.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                // leemos los datos
                byte[] bytes = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (inputStream.read(bytes) != -1){
                    byteArrayOutputStream.write(bytes);
                }
                String JSONResponse = new String(byteArrayOutputStream.toByteArray());
                JSONResponse = JSONResponse.substring(JSONResponse.indexOf('['), JSONResponse.indexOf(']')+1);
                JSONResponse = JSONResponse.replaceAll("\n", "");
                JSONResponse = JSONResponse.replaceAll(" {2}", "");
                //System.out.println(JSONResponse.substring(JSONResponse.length()/2)+"}]");
                JSONArray arr = new JSONArray(JSONResponse);
                for(int i=0 ; i<arr.length(); i++){
                    result.add(convertUser(arr.getJSONObject(i)));
                }
                return result;
            }catch (Throwable throwable){
                throwable.printStackTrace();
            }
            return null;
        }
        private Product convertUser(JSONObject obj) throws JSONException {
            String title = obj.getString("title");
            String likes = obj.getString("likes");
            String img = obj.getString("imageUrl");

            return new Product(title, Integer.parseInt(likes), img);
        }
    }
}