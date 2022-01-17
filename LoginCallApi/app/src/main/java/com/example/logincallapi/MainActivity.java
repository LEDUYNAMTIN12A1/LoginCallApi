package com.example.logincallapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout txtsdt;
    Button btnlogin;
    public static final String BUNDLE = "BUNDLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ các đối tượng này
        txtsdt = (TextInputLayout) findViewById(R.id.sdt);
        btnlogin = (Button) findViewById(R.id.btndn);

        //viết sự kiện cho nút đăng nhập
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!vavidatePhone()){
                    return;
                }
                String sDT = txtsdt.getEditText().getText().toString().trim();
                byBundleSigninScreen(sDT);
            }
        });
    }

    private void byBundleSigninScreen(String sDT) {
        Intent intent =  new Intent(getApplicationContext(),FormLoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("sdt",sDT);
        intent.putExtra(BUNDLE,bundle);

        startActivity(intent);
    }

    //Hàm sử lý sdt nhập vào
    public boolean vavidatePhone(){
        String val = txtsdt.getEditText().getText().toString().trim();

        if(val.isEmpty()){
            txtsdt.setError("không được để trống ");
            return false;
        }
        else if(val.length() != 10){
            txtsdt.setError("Số điện thoại không hợp lệ !");
            return false;
        }
        else{
            txtsdt.setError(null);
            txtsdt.setEnabled(false);
            return true;
        }
    }
}