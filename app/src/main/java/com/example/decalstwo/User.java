package com.example.decalstwo;

import androidx.databinding.BaseObservable;

/**
 * @author chenhong
 * @Date 2020/8/29:58
 * @package com.example.decalstwo
 * @Desciption
 */
public class User extends BaseObservable {

    //java 映射


    private int image;

    //图片的状态 0：未下载，1:下载
    private int statue ;


    private boolean isLoad;

    public boolean isLoad() {
        return isLoad;
    }

    public void setLoad(boolean load) {
        isLoad = load;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
