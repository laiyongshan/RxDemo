package com.yeohe.rxdemo.ui.share;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/18
 * creator:  LYS
 * 功能描述：
 */

public class ShareDemoActivity extends BaseActivity {

    @BindViews({R.id.share_txt_btn,R.id.share_img_btn,R.id.share_file_btn,R.id.share_wx_btn,R.id.share_qq_btn})
    Button shares[];


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_share_demo);
//        ButterKnife.bind(this);
        setBackArrow();
        setTitle("Android 系统分享功能");

    }


    @OnClick({R.id.share_txt_btn,R.id.share_img_btn,R.id.share_file_btn,R.id.share_wx_btn,R.id.share_qq_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.share_txt_btn:
                Intent textIntent=new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                textIntent.putExtra(Intent.EXTRA_TEXT,"这是一个text分享的Demo");
                startActivity(Intent.createChooser(textIntent,"分享text"));
                break;

            case R.id.share_img_btn:
                String path = getResourcesUri(R.drawable.ic_launcher_background);
                Intent imageIntent = new Intent(Intent.ACTION_SEND);
                imageIntent.setType("image/jpeg");
                imageIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
                startActivity(Intent.createChooser(imageIntent, "分享"));
                break;

            case R.id.share_file_btn:
                ArrayList<Uri> imageUris = new ArrayList<>();
                Uri uri1 = Uri.parse(getResourcesUri(R.drawable.ic_launcher_background));
                Uri uri2 = Uri.parse(getResourcesUri(R.drawable.ic_launcher_background));
                imageUris.add(uri1);
                imageUris.add(uri2);
                Intent mulIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                mulIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                mulIntent.setType("image/jpeg");
                startActivity(Intent.createChooser(mulIntent,"多文件分享"));
                break;

            case R.id.share_wx_btn:
                Intent wechatIntent = new Intent(Intent.ACTION_SEND);
                wechatIntent.setPackage("com.tencent.mm");
                wechatIntent.setType("text/plain");
                wechatIntent.putExtra(Intent.EXTRA_TEXT, "分享到微信的内容");
                startActivity(wechatIntent);
                break;

            case R.id.share_qq_btn:
                Intent qqIntent = new Intent(Intent.ACTION_SEND);
                qqIntent.setPackage("com.tencent.mobileqq");
                qqIntent.setType("text/plain");
                qqIntent.putExtra(Intent.EXTRA_TEXT, "分享到QQ的内容");
                startActivity(qqIntent);
                break;
        }
    }

    private String getResourcesUri(@DrawableRes int id) {
        Resources resources = getResources();
        String uriPath = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resources.getResourcePackageName(id) + "/" +
                resources.getResourceTypeName(id) + "/" +
                resources.getResourceEntryName(id);
        Toast.makeText(this, "Uri:" + uriPath, Toast.LENGTH_SHORT).show();
        return uriPath;
    }

}
