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

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout inputEmail;
    private TextInputLayout inputName;
    private TextInputLayout inputSenha;
    private TextInputLayout inputRepeateSenha;
    private Button btnCriarRegistro;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    private String email, senha, name, senhaRepetida;

    //public static final String EMAIL_KEY = "email";
   // public static final String SENHA_KEY = "senha";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();


        btnCriarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCampos();


            }
        });


    }


    public void validarCampos() {
        email = inputEmail.getEditText().getText().toString().trim();
        senha = inputSenha.getEditText().getText().toString().trim();
        name = inputName.getEditText().getText().toString().trim();
        senhaRepetida = inputRepeateSenha.getEditText().getText().toString().trim();

        if (!validarEmail(email) && !validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));
            inputSenha.setError(getString(R.string.senha_numero_caracteres));
            inputName.setError(getString(R.string.nome_vazio));
            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));
        } else if (!validarEmail(email) && !validateSenha(senha) && !validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));
            inputSenha.setError(getString(R.string.senha_numero_caracteres));
            inputName.setError(getString(R.string.nome_vazio));
        } else if (!validarEmail(email) && !validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));
            inputSenha.setError(getString(R.string.senha_numero_caracteres));
            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));
        } else if (!validarEmail(email) && !validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));
            inputSenha.setError(getString(R.string.senha_numero_caracteres));

        } else if (!validarEmail(email) && validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));
            inputName.setError(getString(R.string.nome_vazio));
            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));

        } else if (!validarEmail(email) && validateSenha(senha) && !validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));

            inputName.setError(getString(R.string.nome_vazio));

        } else if (!validarEmail(email) && validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));

            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));

        } else if (!validarEmail(email) && validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmail.setError(getString(R.string.cadastro_email_invalido));

        } else if (validarEmail(email) && !validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {

            inputSenha.setError(getString(R.string.senha_numero_caracteres));
            inputName.setError(getString(R.string.nome_vazio));
            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));

        } else if (validarEmail(email) && !validateSenha(senha) && !validateNome(name) && senha.equals(senhaRepetida)) {

            inputSenha.setError(getString(R.string.senha_numero_caracteres));
            inputName.setError(getString(R.string.nome_vazio));


        } else if (validarEmail(email) && !validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {

            inputSenha.setError(getString(R.string.senha_numero_caracteres));

            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));


        } else if (validarEmail(email) && !validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {

            inputSenha.setError(getString(R.string.senha_numero_caracteres));


        } else if (validarEmail(email) && validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {

            inputName.setError(getString(R.string.nome_vazio));
            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));


        } else if (validarEmail(email) && validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {

            inputRepeateSenha.setError(getString(R.string.senhas_diferentes));


        } else if (validarEmail(email) && validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {
            startActivity(new Intent(RegisterActivity.this, PrincipalActivity.class));
     //       enviarDados();
        }
    }


    public void initViews() {

        inputName = findViewById(R.id.textInputLayout_register_nome);
        inputEmail = findViewById(R.id.textInputLayout_register_email);
        inputSenha = findViewById(R.id.textInputLayout_register_senha);
        inputRepeateSenha = findViewById(R.id.textInputLayout_register_repetirSenha);
        btnCriarRegistro = findViewById(R.id.btn_register_registrar);
    }


    public boolean validarEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateSenha(String senha) {
        return senha.length() > 3;
    }

    public boolean validateNome(String nome) {
        return nome.length() > 0;
    }

//    public void enviarDados(){
//        String emailEnviardo = Objects.requireNonNull(inputName.getEditText()).getText().toString();
//        String senhaEnviada = Objects.requireNonNull(inputSenha.getEditText()).getText().toString();
//
//        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//
//        Bundle bundle = new Bundle();
//
//
//        bundle.putString(EMAIL_KEY, emailEnviardo);
//        bundle.putString(SENHA_KEY, senhaEnviada);
//
//        intent.putExtras(bundle);
//
//        startActivity(intent);
//    }



}
