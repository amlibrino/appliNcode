package arg.afpa.applincode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dal.NcodeApi;
import dal.UserData;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Recherche extends AppCompatActivity {

    private TextView textViewResult;
    private TextView text_nom;
    private View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        text_nom = findViewById(R.id.text_nom);
        textViewResult = findViewById(R.id.textResult);


    }

    public void rechercheNom(View view) {

        //view.setVisibility();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/api_Ncode/")//base url du site de l'api
                .addConverterFactory(GsonConverterFactory.create())//creer le convertor gson
                .build();//le contruire
        NcodeApi ncodeApi = retrofit.create(NcodeApi.class);
        String nom2 = (String) text_nom.getText();

        Call<List<UserData>> call = ncodeApi.getUserDataNom(nom2);
        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {

                //qlq groupe mal lié dans la base (j'affiche une alete pour l'eereur) ERREUR 404 jason
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<UserData> posts = response.body();
                for (UserData post : posts) {
                    String content = "";
                    content += "Nom :" + post.getNom() + "\n";
                    content += "Prénom : " + post.getPrenom() + "\n";
                    content += "Numéro du groupe : " + post.getNumeroOffre() + "\n";
                    content += "Type de formation : " + post.getNomOffre() + "\n";
                    content += "Date début de formation : " + post.getDateDebut() + "\n";
                    content += "Date din de formation :" + post.getDateFin() + "\n";
                    content += "Email : " + post.getEmail() + "\n";
                    content += "Numéro de téléphone : " + post.getTelephone() + "\n";
                    content += "Fonction : " + post.getRole() + "\n\n\n";
                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

}
