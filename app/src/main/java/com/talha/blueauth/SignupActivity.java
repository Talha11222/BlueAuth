
package com.talha.blueauth;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText nameInput, emailInput;
    EditText passwordInput, confirmPasswordInput;
    CheckBox termsCheckbox;
    Button createAccountButton;
    TextView backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.signupEmailInput);
        passwordInput = findViewById(R.id.signupPasswordInput);
        confirmPasswordInput =
                findViewById(R.id.confirmPasswordInput);
        termsCheckbox = findViewById(R.id.termsCheckbox);
        createAccountButton =
                findViewById(R.id.createAccountButton);
        backToLogin = findViewById(R.id.backToLogin);

        createAccountButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();
            String confirmPassword =
                    confirmPasswordInput.getText().toString();

            if (TextUtils.isEmpty(name)) {
                nameInput.setError("Enter your full name");
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.setError("Enter a valid email");
                return;
            }

            if (password.length() < 8) {
                passwordInput.setError(
                        "Password must be at least 8 characters");
                return;
            }

            if (!password.equals(confirmPassword)) {
                confirmPasswordInput.setError(
                        "Passwords do not match");
                return;
            }

            if (!termsCheckbox.isChecked()) {
                Toast.makeText(this,
                        "Please accept the Terms and Conditions",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this,
                    "Form validated successfully! Demo only.",
                    Toast.LENGTH_LONG).show();
        });

        backToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(
                    SignupActivity.this, LoginActivity.class);
            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
                            | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}
