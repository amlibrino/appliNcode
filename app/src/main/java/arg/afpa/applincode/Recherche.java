package arg.afpa.applincode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dal.NcodeApi;
import dal.RetrofitInstance;
import dal.UserData;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Recherche extends AppCompatActivity {

    private TextView textResult;
    private EditText text_nom;
    private String nom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);



    }

    public void rechercheNom(View view) {

        text_nom = findViewById(R.id.text_nom);
        textResult = findViewById(R.id.textResult);
        textResult.setText("");//pour vider la recherche précedente
        nom = String.valueOf(text_nom.getText());//dans un editetext on peut pas recuperer la valeur du string d'ou String.valueOf

        //appler l'instance retrofit
        NcodeApi ncodeApi = RetrofitInstance.getRetrofitInstance().create(NcodeApi.class);

        Call<List<UserData>> call = ncodeApi.getUserDataNom(nom);

        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {

                //qlq groupe mal lié dans la base (j'affiche une alete pour l'eereur) ERREUR 404 jason
                if (!response.isSuccessful()) {
                    textResult.setText("Code : " + response.code() + "  Aucun résultat trouvé pour cette recherche");
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
                    textResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                textResult.setText(t.getMessage());

            }
        });
    }

}
