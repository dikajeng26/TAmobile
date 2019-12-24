package com.example.takelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Kontak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        //untuk mengatur dropdown bahasa
        Spinner mLanguage = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter mAdapter = new ArrayAdapter<String>(Kontak.this,
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        //untuk menyimpan bahasa yang telah ditetapkan jika aplikasi di tutup
        if (LocaleHelper.getLanguage(Kontak.this).equalsIgnoreCase("en")) {
            mLanguage.setSelection(mAdapter.getPosition("English"));
        } else if (LocaleHelper.getLanguage(Kontak.this).equalsIgnoreCase("in")) {
            mLanguage.setSelection(mAdapter.getPosition("Indonesia"));
        }

        //mengatur bahasa default
        Context context = LocaleHelper.setLocale(Kontak.this, "en");
        Resources resources = context.getResources();

        //mengatur bahasa pada component secara default
        final TextView mTextView = (TextView) findViewById(R.id.textView11);
        final TextView mTextView2 = (TextView) findViewById(R.id.textView12);
        final TextView mTextView3 = (TextView) findViewById(R.id.textView13);
        final TextView mTextView4 = (TextView) findViewById(R.id.textView20);
        final TextView mTextView5 = (TextView) findViewById(R.id.textView14);

        //mengatur bahasa dari string.xml
        mTextView.setText(resources.getString(R.string.Post));
        mTextView2.setText(resources.getString(R.string.Following));
        mTextView3.setText(resources.getString(R.string.Follower));
        mTextView4.setText(resources.getString(R.string.bahasa));
        mTextView5.setText(resources.getString(R.string.Sosmed));

        //mengatur perubahan bahasa sesuai pilihan spinner
        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(Kontak.this, "en");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.Post));
                        mTextView2.setText(resources.getString(R.string.Following));
                        mTextView3.setText(resources.getString(R.string.Follower));
                        mTextView4.setText(resources.getString(R.string.bahasa));
                        mTextView5.setText(resources.getString(R.string.Sosmed));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(Kontak.this, "in");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.Post));
                        mTextView2.setText(resources.getString(R.string.Following));
                        mTextView3.setText(resources.getString(R.string.Follower));
                        mTextView4.setText(resources.getString(R.string.bahasa));
                        mTextView5.setText(resources.getString(R.string.Sosmed));
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
