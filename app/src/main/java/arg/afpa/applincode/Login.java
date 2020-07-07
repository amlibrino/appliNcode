package arg.afpa.applincode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //conteur pour le nombre de saisie érronée
    int count =4;

    //textview pour afficher un message d'erreur
    TextView text_erreur;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);
        text_erreur = (TextView)findViewById(R.id.text_erreur);
        btn_login = (Button)findViewById(R.id.btn_login);

        if (username.getText().toString().equals("afpa") && password.getText().toString().equals("apicode")){
            Toast.makeText(this, "Vous etes bien authentifié", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Activity_deux.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Login ou mot de passe incorrect", Toast.LENGTH_LONG).show();

            //rendre le text-erreur visible
            text_erreur.setVisibility(View.VISIBLE);
            text_erreur.setTextColor(Color.RED);
            count--;//incrementation
            text_erreur.setText("il vous reste ".concat(Integer.toString(count)).concat(" tentatives"));

            //désactiver de boutton si tentative epuisée
            if (count == 0) {
                btn_login.setEnabled(false);
            }
        }
    }
}
