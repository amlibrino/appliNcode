package dal;


import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("role")
    private String role;

    @SerializedName("nom_offre")
    private String nomOffre;

    @SerializedName("date_debut")
    private String dateDebut;

    @SerializedName("date_fin")
    private String dateFin;

    @SerializedName("telephone")
    private String telephone;

    @SerializedName("nom")
    private String nom;

    @SerializedName("prenom")
    private String prenom;

    @SerializedName("numero_offre")
    private String numeroOffre;

    @SerializedName("email")
    private String email;

    public String getRole(){
        return role;
    }

    public String getNomOffre(){
        return nomOffre;
    }

    public String getDateDebut(){
        return dateDebut;
    }

    public String getDateFin(){
        return dateFin;
    }

    public String getTelephone(){
        return telephone;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getNumeroOffre(){
        return numeroOffre;
    }

    public String getEmail(){
        return email;
    }
}
