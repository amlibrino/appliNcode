package arg.afpa.applincode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_deux extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deux);
    }

    public void lanchRecherche(View view) {
        Intent intent1 = new Intent(this, Recherche.class);
        startActivity(intent1);
    }

    public void lanchPlanning(View view) {
        Intent intent = new Intent(this, Planning.class);
        startActivity(intent);
    }
}
