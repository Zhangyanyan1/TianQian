package com.example.lenovo.tianqishujuku.callback;

import java.util.ArrayList;


/**
 * Created by yinm_pc on 2017/4/23.
 */

public interface HttpCallBack {

    ArrayList ok(ArrayList list);

    void no(String noStr);

    void err(String str);
}
