package dal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NcodeApi {
     /*
    @GET("offre/read.php")
    Call<List<GlobalData>> getGlobalData();

   La requête pour avoir uniquement l'offre qui nous intéresse
    @GET("offre/readOne.php/")
    Call<List<GroupeData>> getGroupeData(@Query("numero") int numero);*/

    //recherche par nom
    @GET("user/userNom.php/")
    Call<List<UserData>> getUserDataNom(@Query("nom") String nom);

}
