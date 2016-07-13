package com.trampcr.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by zxm on 2016/7/12.
 */
public class BuyBookActitivy extends AppCompatActivity implements View.OnClickListener{

    private EditText mEtBookName;
    private Button mBtnCommit;
    private Button mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_book);
        setTitle("买书界面");
        mEtBookName = (EditText) findViewById(R.id.et_book_name);
        mBtnCommit = (Button) findViewById(R.id.btn_commit);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);

        mBtnCommit.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_commit:
                Intent intent = new Intent(BuyBookActitivy.this, MainActivity.class);
                String bookName = mEtBookName.getText().toString();
                if (!TextUtils.isEmpty(bookName)) {
                    intent.putExtra("bookname", bookName);
                    setResult(1, intent);
                    finish();
                }else {
                    Toast.makeText(BuyBookActitivy.this, "书名不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancel:
                finish();
        }
    }
}
