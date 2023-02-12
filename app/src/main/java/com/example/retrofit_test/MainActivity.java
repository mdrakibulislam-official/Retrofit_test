package com.example.retrofit_test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit_test.databinding.ActivityMainBinding;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = binding.inputFirstName.getText().toString().trim();
                String lName = binding.inputLastName.getText().toString().trim();
                String email = binding.inputEmail.getText().toString().trim();

                if (fName.isEmpty()){
                    binding.inputFirstName.setError("Enter your First Name");
                    binding.inputFirstName.requestFocus();
                }
                if (fName.isEmpty()){
                    binding.inputLastName.setError("Enter your Last Name");
                    binding.inputLastName.requestFocus();
                }
                if (fName.isEmpty()){
                    binding.inputEmail.setError("Enter your Email");
                    binding.inputEmail.requestFocus();
                }
                Log.d("Main",fName+" "+lName+" "+email);

                Call<ResponseBody> call = RetrofitClient.getInstance().getAPI().createUSer(fName,lName,email);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(MainActivity.this, "Registration Successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}