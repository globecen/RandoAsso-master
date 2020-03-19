package com.example.test.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.test.Interfaces.MyStatutRandonneur;
import com.example.test.Interfaces.OneRandoRequeteInterface;
import com.example.test.R;
import com.example.test.models.RandonnneEtAssoModele;
import com.example.test.models.StatutModele;
import com.example.test.randomember.randomember_main_activity;
import com.example.test.randomember.randomember_read_active_event_activity;
import com.example.test.statut_page;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.test.Interfaces.OneRandoRequeteInterface.norandonnee;

public class MainActivity extends AppCompatActivity {
    String norandonneur = "";
    String noStatut = "";
    String libelleStatut = "";
    final String regex = "login";
    final String regex2 = "\\d";
    ProgressBar loadingPanel;
    EditText etEmail, etPassword;
    Button btnLogin;
    //Button btnCreer;
    final String url_Login = "https://globecen.freeboxos.fr/backendAndroid/login_user.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etIdentifiant);
        etPassword = (EditText) findViewById(R.id.etMdp);
        btnLogin = (Button) findViewById(R.id.btnValid);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = etEmail.getText().toString();
                String Password = etPassword.getText().toString();

                new LoginUser().execute(Email, Password);
            }
        });
    }

    public class LoginUser extends AsyncTask<String, Void, String> {

        String etat = "";

        @Override
        protected String doInBackground(String... strings) {
            findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
            String Email = strings[0];
            String Password = strings[1];

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("user_id", Email)
                    .add("user_password", Password)
                    .build();

            Request request = new Request.Builder()
                    .url(url_Login)
                    .post(formBody)
                    .build();

            Response response = null;
            try {
                response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    String result = response.body().string();

                    final Pattern pattern2 = Pattern.compile(regex2);
                    final Matcher matcher2 = pattern2.matcher(result);
                    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                    final Matcher matcher = pattern.matcher(result);
                    while (matcher.find()) {
                        etat = matcher.group(0);
                        for (int i = 1; i <= matcher.groupCount(); i++) {
                        }

                    }
                    while (matcher2.find()) {
                        norandonneur = matcher2.group(0);
                        for (int i = 1; i <= matcher2.groupCount(); i++) {
                        }
                    }
                    if (etat.equals("login")) {
                        SystemClock.sleep(1000);
                        RecupererStatut();
                        SystemClock.sleep(1000);
                        Intent i = new Intent(MainActivity.this,
                                randomember_main_activity.class);
                        i.putExtra("norandonneur", norandonneur);
                        i.putExtra("statut", libelleStatut);
                        i.putExtra("nostatut", noStatut);
                        startActivity(i);
                    } else {
                        showToast("Email ou mot de passe incorrect !");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    public void showToast(final String Text) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,
                        Text, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void RecupererStatut() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://globecen.freeboxos.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyStatutRandonneur requestInteface = retrofit.create(MyStatutRandonneur.class);
        Call<List<StatutModele>> call = requestInteface.getMyStatutRandonneur(norandonneur);
        call.enqueue(new Callback<List<StatutModele>>() {
            @Override
            public void onResponse(Call<List<StatutModele>> call, retrofit2.Response<List<StatutModele>> response) {

                List<StatutModele> Infos = response.body();
                for (StatutModele post : Infos) {
                    libelleStatut = post.getLibelle();
                    noStatut = post.getNo_statut();
                }
            }

            @Override
            public void onFailure(Call<List<StatutModele>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.e("erreur", t.getMessage());
            }
        });
    }

    public void CreerCompte(View view) {
        startActivity(new Intent(this, statut_page.class));
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
