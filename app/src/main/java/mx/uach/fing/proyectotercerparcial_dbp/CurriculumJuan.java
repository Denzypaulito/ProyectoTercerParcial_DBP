package mx.uach.fing.proyectotercerparcial_dbp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CurriculumJuan extends AppCompatActivity {
    private TextView txtNombreCompleto;
    private TextView txtBiografia;
    private TextView txtEducacion;
    private TextView txtHabilidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curriculum_d);

        txtNombreCompleto = findViewById(R.id.txtNombreCompleto);
        txtBiografia = findViewById(R.id.txtBiografia);
        txtEducacion = findViewById(R.id.txtEducacion);
        txtHabilidades = findViewById(R.id.txtHabilidades);

        obtenerDatosCurriculum();
    }

    private void obtenerDatosCurriculum() {

        String url = "https://raw.githubusercontent.com/Denzypaulito/Curriculums/main/348637.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String nombreCompleto = response.getString("nombreCompleto");
                            String biografia = response.getString("biografia");
                            JSONArray educacionArray = response.getJSONArray("educacion");
                            JSONArray habilidadesArray = response.getJSONArray("habilidades");


                            txtNombreCompleto.setText(nombreCompleto);
                            txtBiografia.setText(biografia);
                            txtEducacion.setText(obtenerTextoArray(educacionArray));
                            txtHabilidades.setText(obtenerTextoArray(habilidadesArray));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });


        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

    private String obtenerTextoArray(JSONArray jsonArray) throws JSONException {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            texto.append(jsonArray.getString(i));
            if (i < jsonArray.length() - 1) {
                texto.append(", ");
            }
        }
        return texto.toString();
    }
}