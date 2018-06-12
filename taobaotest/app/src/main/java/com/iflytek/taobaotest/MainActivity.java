package com.iflytek.taobaotest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn_taobao);
        btn2=findViewById(R.id.btn_tianmao);
        btn3=findViewById(R.id.btn_taobaoshop);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"try",Toast.LENGTH_SHORT).show();
                totaoBao();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totianmao("https://detail.tmall.com/item.htm?spm=a1z0d.6639537.1997196601.3.45d07484uw9hPZ&id=565570128470");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                toshop("https://swarovski.tmall.com/shop/view_shop.htm?shop_id=126434207");
            }
        });


    }



    void totaoBao(){
        if (!checkPackage("com.taobao.taobao")){
//            Toast.makeText(MainActivity.this,"请安装淘宝app！",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("url","https://item.taobao.com/item.htm?spm=a1z0d.6639537.1997196601.14.45d07484uw9hPZ&id=565080000925");
            startActivity(intent);
            return;
        }


        String tbPath="https://item.taobao.com/item.htm?spm=a1z0d.6639537.1997196601.14.45d07484uw9hPZ&id=565080000925";

//        String tbPath="https://detail.tmall.com/item.htm?spm=a1z0d.6639537.1997196601.3.45d07484uw9hPZ&id=565570128470";
        Intent intent = new Intent();
        intent.setAction("Android.intent.action.VIEW");
        Uri uri = Uri.parse(tbPath); // 商品地址
        intent.setData(uri);
        intent.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
        startActivity(intent);
    }

    void totianmao( String tbPath){
        Intent intent = new Intent();
        intent.setAction("Android.intent.action.VIEW");
        Uri uri = Uri.parse(tbPath); // 商品地址
        intent.setData(uri);
        intent.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
        startActivity(intent);
    }

    void toshop(String tbPath){

//        String tbPath="https://detail.tmall.com/item.htm?spm=a1z0d.6639537.1997196601.3.45d07484uw9hPZ&id=565570128470";
        Intent intent = new Intent();
        intent.setAction("Android.intent.action.VIEW");
        Uri uri = Uri.parse(tbPath); // 商品地址
        intent.setData(uri);
        intent.setClassName("com.taobao.taobao", "com.taobao.android.shop.activity.ShopHomePageActivity");
        startActivity(intent);
    }


    public boolean checkPackage(String packageName)
    {
        if (packageName == null || "".equals(packageName))
            return false;
        try
        {
            this.getPackageManager().getApplicationInfo(packageName, PackageManager
                    .GET_UNINSTALLED_PACKAGES);
            return true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            return false;
        }
    }

}
