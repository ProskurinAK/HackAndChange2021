package microsofc.app.mha2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Button btnConfirmRegister;
    EditText nameEditText;
    EditText emailEditText;
    EditText passEditText;
    EditText passConfirmEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnConfirmRegister = findViewById(R.id.btnConfReg);

        nameEditText = findViewById(R.id.editTextLoginReg);
        emailEditText = findViewById(R.id.editTextEmailReg);
        passEditText = findViewById(R.id.editTextPassReg);
        passConfirmEditText = findViewById(R.id.editTextPassConfirmReg);

        View.OnClickListener btnListener = view -> {
            if(passEditText.getText().toString().equals(passConfirmEditText.getText().toString())){

                UserRegOrLogData user = new UserRegOrLogData(nameEditText.getText().toString(),
                        passEditText.getText().toString(),
                        emailEditText.getText().toString(), null, null, null); //getting user-data from edit text

                ServerAPI serverAPI = NetworkSingleton.getInstance().getServerAPI(); //Connection part
                Call<UserRegOrLogData> stringCall = serverAPI.tryRegister(user);

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                stringCall.enqueue(new Callback<UserRegOrLogData>() {
                    @Override
                    public void onResponse(Call<UserRegOrLogData> call, Response<UserRegOrLogData> response) {
                        if(response.body() != null)
                        {
                            Toast toast2 = Toast.makeText(getApplicationContext(), "Registration successful!"/*gson.toJson(user)*/, Toast.LENGTH_LONG);
                            toast2.show();
                            finish();
                        }
                        else{
                            Toast toast2 = Toast.makeText(getApplicationContext(), "Такой пользователь существует", Toast.LENGTH_LONG);
                            toast2.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserRegOrLogData> call, Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error:"+t.toString()/*gson.toJson(user)*/, Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }

        };
        btnConfirmRegister.setOnClickListener(btnListener);
    }

    private void onWrongData(){

    }
}

//TODO ChekData