package com.trampcr.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTvHelloName;
    private Button mBtnBuyBook;
    private TextView mTvBookName;
    private Button mBtnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvHelloName = (TextView) findViewById(R.id.tv_hello_name);
        mBtnBuyBook = (Button) findViewById(R.id.btn_buy_book);
        mTvBookName = (TextView) findViewById(R.id.tv_book_name);
        mBtnReset = (Button) findViewById(R.id.btn_reset);

        mBtnBuyBook.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            mTvHelloName.setText("Hello " + name);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_buy_book:
                Intent intent = new Intent(MainActivity.this, BuyBookActitivy.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.btn_reset:
                mTvBookName.setText("");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 1) {
            String bookName = data.getStringExtra("bookname");
            mTvBookName.setText(bookName);
        }
    }
}
