package org.lzh.framework.updateplugin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.model.Update;
import org.lzh.framework.updatepluginlib.strategy.UpdateStrategy;

public class MainActivity extends Activity {

    private String apkFile = "http://apk.hiapk.com/web/api.do?qt=8051&id=721";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UpdateBuilder中可设置的配置与UpdateConfig中一致。检查更新入口调用check方法
                // 对于UpdateBuilder中未设置的参数。会默认使用UpdateConfig中的配置
                UpdateBuilder.create()
                        .strategy(new UpdateStrategy() {
                            @Override
                            public boolean isShowUpdateDialog(Update update) {
                                return false;
                            }

                            @Override
                            public boolean isAutoInstall() {
                                return true;
                            }

                            @Override
                            public boolean isShowInstallDialog() {
                                return false;
                            }

                            @Override
                            public boolean isShowDownloadDialog() {
                                return false;
                            }
                        })
                        .check(MainActivity.this);
            }
        });
    }
}
