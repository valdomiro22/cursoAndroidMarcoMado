package com.santos.valdomiro.applistacursojava.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.santos.valdomiro.applistacursojava.databinding.ActivityMainBinding;
import com.santos.valdomiro.applistacursojava.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Pessoa pessoa;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTextTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inicializarElementos();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Valdomiro");
        pessoa.setSobrenome("Santos");
        pessoa.setCursoDesejado("Java");
        pessoa.setTelefoneContato("19 2 9283-8274");

        Log.d("log", "onCreate: \n" +
                pessoa.getPrimeiroNome() + "\n" +
                pessoa.getSobrenome() + "\n" +
                pessoa.getCursoDesejado() + "\n" +
                pessoa.getTelefoneContato());

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTextTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaNovaPessoa();
            }
        });

    }

    private void criaNovaPessoa() {
        Pessoa pessoa2 = new Pessoa();

        pessoa2.setPrimeiroNome(editPrimeiroNome.getText().toString());
        pessoa2.setSobrenome(editSobrenome.getText().toString());
        pessoa2.setCursoDesejado(editCursoDesejado.getText().toString());
        pessoa2.setTelefoneContato(editTextTelefoneContato.getText().toString());

        Log.d("log", "onCreate: \n" +
                pessoa2.getPrimeiroNome() + "\n" +
                pessoa2.getSobrenome() + "\n" +
                pessoa2.getCursoDesejado() + "\n" +
                pessoa2.getTelefoneContato());
    }

    private void inicializarElementos() {
        editPrimeiroNome = binding.editPrimeiroNome;
        editSobrenome = binding.editSobrenome;
        editCursoDesejado = binding.editCursoDesejado;
        editTextTelefoneContato = binding.editContato;

        btnFinalizar = binding.btnFinalizar;
        btnSalvar = binding.btnSalvar;
        btnLimpar = binding.btnLimpar;
    }

    private void limparCampos() {
        editPrimeiroNome.setText("");
        editSobrenome.setText("");
        editCursoDesejado.setText("");
        editTextTelefoneContato.setText("");

    }
}