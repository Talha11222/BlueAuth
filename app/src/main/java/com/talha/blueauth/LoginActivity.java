
package com.talha.blueauth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button loginButton, googleButton;
    TextView forgotPassword, signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        googleButton = findViewById(R.id.googleButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        signupLink = findViewById(R.id.signupLink);

        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();

            if (TextUtils.isEmpty(email) ||
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.setError("Enter a valid email address");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                passwordInput.setError("Enter your password");
                return;
            }

            Toast.makeText(this,
                    "Login form validated (demo only)",
                    Toast.LENGTH_SHORT).show();
        });

        googleButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "Google sign-in is a UI demo only",
                        Toast.LENGTH_SHORT).show()
        );

        forgotPassword.setOnClickListener(v ->
                Toast.makeText(this,
                        "Password reset is not configured",
                        Toast.LENGTH_SHORT).show()
        );

        signupLink.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginActivity.this,
                    SignupActivity.class
            );
            startActivity(intent);
        });
    }
}
