package com.example.logincallapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.logincallapi.api.ApiService;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormLoginActivity<isHasUser> extends AppCompatActivity {
    TextInputLayout txtmk;
    Button btnlogin;
    String sDT;
    private User mUser;
    //private List<User> mListUser;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{6,}" +                // at least 4 characters
                    "$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        txtmk = (TextInputLayout) findViewById(R.id.mk);
        btnlogin = (Button) findViewById(R.id.btndangnhap);

        //mListUser = new ArrayList<>();
        senduser();

        //Lấy dữ liệu từ bundle của form 1
        Bundle bundle = getIntent().getBundleExtra(MainActivity.BUNDLE);
        if(bundle != null){
            sDT = bundle.getString("sdt");
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String strmk = txtmk.getEditText().getText().toString().trim();
        String strsdt = sDT;

        if(!validatePassWord()){
            return;
        }
        if(mUser == null ){
            return;
        }

        boolean isHasUser = false;

        if(strsdt.equals(mUser.getSoDienThoai()) && strmk.equals(mUser.getPassWord())) {
                isHasUser = true;
        }

        if(isHasUser){
            Intent intent = new Intent(FormLoginActivity.this,HomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object user", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            Toast.makeText(FormLoginActivity.this, "giá trị của sdt và pass không tồn tại !", Toast.LENGTH_SHORT).show();
        }
    }

    private void senduser(){

        User user = new User("0943813049","Bmis@3049",171,"12","Android","auto");

        ApiService.apiservice.senduser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(FormLoginActivity.this, "Call API thành công!", Toast.LENGTH_SHORT).show();
                //Log.e("List User",mListUser.size()+"");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(FormLoginActivity.this, "Call API ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean validatePassWord() {
        String val = txtmk.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            txtmk.setError("không được để trống");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(val).matches()){
            txtmk.setError("Mật khẩu ít nhất 6 ký tự");
            return false;
        }
        else{
            txtmk.setError(null);
            txtmk.setEnabled(false);
            return true;
        }
    }
}