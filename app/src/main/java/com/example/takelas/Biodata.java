package com.example.takelas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Biodata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        //untuk mengatur dropdown bahasa
        Spinner mLanguage = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter mAdapter = new ArrayAdapter<String>(Biodata.this,
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        //untuk menyimpan bahasa yang telah ditetapkan jika aplikasi di tutup
        if (LocaleHelper.getLanguage(Biodata.this).equalsIgnoreCase("en")) {
            mLanguage.setSelection(mAdapter.getPosition("English"));
        } else if (LocaleHelper.getLanguage(Biodata.this).equalsIgnoreCase("in")) {
            mLanguage.setSelection(mAdapter.getPosition("Indonesia"));
        }

        //mengatur bahasa default
        Context context = LocaleHelper.setLocale(Biodata.this, "en");
        Resources resources = context.getResources();

        //mengatur bahasa pada component secara default
        final TextView mTextView = (TextView) findViewById(R.id.textView5);
        final TextView mTextView2 = (TextView) findViewById(R.id.textView6);
        final TextView mTextView3 = (TextView) findViewById(R.id.textView7);
        final TextView mTextView4 = (TextView) findViewById(R.id.textView8);
        final TextView mTextView5 = (TextView) findViewById(R.id.textView9);
        final TextView mTextView6 = (TextView) findViewById(R.id.textView18);
        final EditText mEditText1 = (EditText) findViewById(R.id.editText2);
        final EditText mEditText2 = (EditText) findViewById(R.id.editText3);

        //mengatur bahasa dari string.xml
        mTextView.setText(resources.getString(R.string.nama_lengkap));
        mTextView2.setText(resources.getString(R.string.ttl));
        mTextView3.setText(resources.getString(R.string.jenis_kelamin));
        mTextView4.setText(resources.getString(R.string.alamat));
        mTextView5.setText(resources.getString(R.string.kota_kelahiran));
        mTextView6.setText(resources.getString(R.string.bahasa));
        mEditText1.setText(resources.getString(R.string.tgl));
        mEditText2.setText(resources.getString(R.string.perempuan));

        //mengatur perubahan bahasa sesuai pilihan spinner
        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(Biodata.this, "en");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.nama_lengkap));
                        mTextView2.setText(resources.getString(R.string.ttl));
                        mTextView3.setText(resources.getString(R.string.jenis_kelamin));
                        mTextView4.setText(resources.getString(R.string.alamat));
                        mTextView5.setText(resources.getString(R.string.kota_kelahiran));
                        mTextView6.setText(resources.getString(R.string.bahasa));
                        mEditText1.setText(resources.getString(R.string.tgl));
                        mEditText2.setText(resources.getString(R.string.perempuan));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(Biodata.this, "in");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.nama_lengkap));
                        mTextView2.setText(resources.getString(R.string.ttl));
                        mTextView3.setText(resources.getString(R.string.jenis_kelamin));
                        mTextView4.setText(resources.getString(R.string.alamat));
                        mTextView5.setText(resources.getString(R.string.kota_kelahiran));
                        mTextView6.setText(resources.getString(R.string.bahasa));
                        mEditText1.setText(resources.getString(R.string.tgl));
                        mEditText2.setText(resources.getString(R.string.perempuan));
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

}
