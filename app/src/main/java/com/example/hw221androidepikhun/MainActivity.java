package com.example.hw221androidepikhun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mInputNote;
    private Button mBtnSaveNote;

    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";
    //private  String mystrdatasave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {
        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);
        String myNoteSharName = getString(R.string.myNoteSharedPrefName);

        myNoteSharedPref = getSharedPreferences(myNoteSharName, MODE_PRIVATE);

        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                String noteTxt = mInputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                String mystrdatasave = getString(R.string.datasave);
                Toast.makeText(MainActivity.this, mystrdatasave, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  void getDateFromSharedPref(){
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
    }

}