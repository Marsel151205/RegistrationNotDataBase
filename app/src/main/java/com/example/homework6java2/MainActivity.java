package com.example.homework6java2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.homework6java2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showCustomUI();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        binding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.etEmail.getText().toString().equals("")) {
                    binding.btnEnter.setBackgroundColor(0xFFBDBDBD);
                } else {
                    binding.btnEnter.setBackgroundColor(0xFFFF5722);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.etPassword.getText().toString().equals("")) {
                    binding.btnEnter.setBackgroundColor(0xFFBDBDBD);
                } else {
                    binding.btnEnter.setBackgroundColor(0xFFFF5722);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.etEmail.getText().toString();
                String password = binding.etPassword.getText().toString();
                if (!email.equals("admin") || !password.equals("admin")) {
                    if (!email.equals("admin")){
                        binding.etEmail.setError("Вы неверно ввели логин");
                    }else if (!password.equals("admin")){
                        binding.etPassword.setError("Вы неверно ввели пароль");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Вы успешно вошли в аккаунт", Toast.LENGTH_SHORT).show();
                    binding.constraint.removeAllViews();
                    binding.constraint.addView(binding.tvWelcome);
                }
            }
        });

        binding.tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri web = Uri.parse("https://ru.wargaming.net/personal/password_reset/");
                Intent intent = new Intent(Intent.ACTION_VIEW, web);
                startActivity(intent);
            }
        });
    }

    private void showCustomUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}