package com.example.wuzhiming.xutilsdemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @ViewInject(R.id.btn_click)
    Button btn;
    @ViewInject(R.id.image)
    ImageView image;

    int index=0;

    String[] urls = {
            "http://img4.imgtn.bdimg.com/it/u=3182769660,1810895318&fm=23&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1278435851,1308167727&fm=23&gp=0.jpg",
            "http://img2.3lian.com/2014/f4/199/d/6.jpg",
            "http://pic1.win4000.com/wallpaper/4/584b9ea3a511c.jpg"};

    String[] urlsGif={
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534877199482&di=dcaaa86cf477e8f91d8a980ab760c868&imgtype=0&src=http%3A%2F%2Fimg0.pconline.com.cn%2Fpconline%2F1512%2F27%2F7380681_12_thumb.gif"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535472022&di=af11e077725c561921017b8556bc113f&imgtype=jpg&er=1&src=http%3A%2F%2Fimgq.duitang.com%2Fuploads%2Fitem%2F201505%2F16%2F20150516120714_hPJWS.gif"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534877303405&di=5085907963350f592492e8128748024f&imgtype=0&src=http%3A%2F%2Fs9.rr.itc.cn%2Fr%2FwapChange%2F20163_31_10%2Fa151df4242188977362.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534877303404&di=4a35baa355e721a81abe8f8988b4b356&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2F3ZFYCJ8pkA7Ndz7F-MBrrA%3D%3D%2F6631983658887411605.gif"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);


    }


    @Event(R.id.btn_click)
    private void click(View v){
//        Toast.makeText(this,"csdcsd",Toast.LENGTH_SHORT).show();

        final ImageOptions options=new ImageOptions.Builder()
                .setIgnoreGif(false).build();
//        x.image().bind(image,urlsGif[(index++)%4],options);


        x.image().loadFile(urlsGif[(index++) % 4], options, new Callback.CacheCallback<File>() {
            @Override
            public boolean onCache(File result) {
                Toast.makeText(MainActivity.this,result.getPath()+result.getName(),Toast.LENGTH_LONG).show();
                                Log.e("MainActivity",result.getPath()+result.getName()+".gif");
                                x.image().bind(image,result.getPath(),options);


                return false;
            }

            @Override
            public void onSuccess(File result) {
//                x.image().bind(image,result.getPath()+result.getName()+".gif",options);
//                Log.e("MainActivity",result.getPath()+result.getName()+".gif");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


//        x.image().loadDrawable(urlsGif[(index++) % 4], options, new Callback.CommonCallback<Drawable>() {
//            @Override
//            public void onSuccess(Drawable result) {
//                image.setImageDrawable(result);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
    }
}
