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

public class profileActivity extends AppCompatActivity {


    private TextInputLayout inputEmailProfile;
    private TextInputLayout inputNameProfile;
    private TextInputLayout inputSenhaProfile;
    private TextInputLayout inputRepeateSenhaProfile;
    private Button btnSalvarProfile;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    private String email, senha, name, senhaRepetida;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();


        btnSalvarProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCampos();


            }
        });


    }


    public void validarCampos() {
        email = inputEmailProfile.getEditText().getText().toString().trim();
        senha = inputSenhaProfile.getEditText().getText().toString().trim();
        name = inputNameProfile.getEditText().getText().toString().trim();
        senhaRepetida = inputRepeateSenhaProfile.getEditText().getText().toString().trim();

        if (!validarEmail(email) && !validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));
            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));
            inputNameProfile.setError(getString(R.string.nome_vazio));
            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));
        } else if (!validarEmail(email) && !validateSenha(senha) && !validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));
            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));
            inputNameProfile.setError(getString(R.string.nome_vazio));
        } else if (!validarEmail(email) && !validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));
            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));
            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));
        } else if (!validarEmail(email) && !validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));
            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));

        } else if (!validarEmail(email) && validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));
            inputNameProfile.setError(getString(R.string.nome_vazio));
            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));

        } else if (!validarEmail(email) && validateSenha(senha) && !validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));

            inputNameProfile.setError(getString(R.string.nome_vazio));

        } else if (!validarEmail(email) && validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));

            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));

        } else if (!validarEmail(email) && validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {
            inputEmailProfile.setError(getString(R.string.cadastro_email_invalido));

        } else if (validarEmail(email) && !validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {

            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));
            inputNameProfile.setError(getString(R.string.nome_vazio));
            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));

        } else if (validarEmail(email) && !validateSenha(senha) && !validateNome(name) && senha.equals(senhaRepetida)) {

            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));
            inputNameProfile.setError(getString(R.string.nome_vazio));


        } else if (validarEmail(email) && !validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {

            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));

            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));


        } else if (validarEmail(email) && !validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {

            inputSenhaProfile.setError(getString(R.string.senha_numero_caracteres));


        } else if (validarEmail(email) && validateSenha(senha) && !validateNome(name) && !senha.equals(senhaRepetida)) {

            inputNameProfile.setError(getString(R.string.nome_vazio));
            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));


        } else if (validarEmail(email) && validateSenha(senha) && validateNome(name) && !senha.equals(senhaRepetida)) {

            inputRepeateSenhaProfile.setError(getString(R.string.senhas_diferentes));


        } else if (validarEmail(email) && validateSenha(senha) && validateNome(name) && senha.equals(senhaRepetida)) {
            startActivity(new Intent(profileActivity.this, PrincipalActivity.class));
        }
    }


    public void initViews() {

        inputNameProfile = findViewById(R.id.textInputLayout_profile_nome);
        inputEmailProfile = findViewById(R.id.textInputLayout_profile_email);
        inputSenhaProfile = findViewById(R.id.textInputLayout_profile_senha);
        inputRepeateSenhaProfile = findViewById(R.id.textInputLayout_profile_repetirSenha);
        btnSalvarProfile = findViewById(R.id.btn_profile_salvarProfile);
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



}
