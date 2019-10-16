package com.example.entregavel2.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.entregavel2.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static com.example.entregavel2.views.RegisterActivity.EMAIL_KEY;
//import static com.example.entregavel2.views.RegisterActivity.SENHA_KEY;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout inputEmail;
    private TextInputLayout inputSenha;
   // private TextInputEditText inputEditEmail;
   // private TextInputEditText inputEditSenha;
    private Button btnLogin;
    private Button btnRegistrar;

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    private String email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
//        receberDados();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCampos();
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        receberDados();
//    }

    public void initViews() {
        inputEmail = findViewById(R.id.textInputLayout_login_email);
        inputSenha = findViewById(R.id.textInputLayout_login_senha);
      // inputEditEmail=findViewById(R.id.textInputEditText_register_email);
       // inputEditSenha=findViewById(R.id.textInputEditText_register_senha);
        btnLogin = findViewById(R.id.btn_login_login);

        btnRegistrar = findViewById(R.id.btn_login_register);
    }

    public void validarCampos() {
        email = inputEmail.getEditText().getText().toString().trim();
        senha = inputSenha.getEditText().getText().toString().trim();

        if (validarEmail(email) && !validateSenha(senha)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));
            inputSenha.setError(getString(R.string.senha_numero_caracteres));
        } else if (!validateSenha(senha)) {
            inputSenha.setError(getString(R.string.senha_numero_caracteres));
            inputEmail.setErrorEnabled(false);
        } else if (validarEmail(email)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));
            inputSenha.setErrorEnabled(false);
        } else {
            inputEmail.setErrorEnabled(false);
            inputSenha.setErrorEnabled(false);

            startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
        }
    }

    public boolean validarEmail(String email) {
        matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    public boolean validateSenha(String senha) {
        return senha.length() > 3;
    }

//    public void receberDados(){
//
//        Intent intent = getIntent();
//
//            Bundle bundle = intent.getExtras();
//
//            String emailRecebido = bundle.getString(EMAIL_KEY);
//            String senhaRecebida = bundle.getString(SENHA_KEY);
//
//            inputEditEmail.setText(emailRecebido);
//            inputEditSenha.setText(senhaRecebida);
//
//    }
//

}