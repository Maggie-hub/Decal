package com.example.decalstwo;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.decalstwo.databinding.LayoutImageItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenhong
 * @Date 2020/8/214:46
 * @package com.example.decalstwo
 * @Desciption
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int HEAD = 0;

    public static final int CONTENT = 1;

    private List<User> list;

    private Activity activity;


    public MyAdapter(List<User> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == HEAD) {
            //把layout转化为view
            View head = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_head, null);
            //DataBindingUtil.bind(head);
            return new HeadHolder(head);
        } else {

            //把layout转化为view
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_item, null);
            return new MyHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyHolder) {

           // ((MyHolder) holder).bind.setUser(list.get(position));

            //设置图片圆角角度
            RoundedCorners roundedCorners = new RoundedCorners(20);
            //通过RequestOptions扩展功能
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);//.override(300, 300);

            Glide.with(activity).load(list.get(position - 1).getImage()).apply(options).into(((MyHolder) holder).viewById);

            ((MyHolder) holder).viewById.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setSelset(position);
                }
            });

            if (list.get(position - 1).getStatue() == 0) {
                ((MyHolder) holder).load.setVisibility(View.VISIBLE);
            } else
                ((MyHolder) holder).load.setVisibility(View.INVISIBLE);

        } else {
            //设置图片圆角角度
            RoundedCorners roundedCorners = new RoundedCorners(20);
            //通过RequestOptions扩展功能
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);//.override(300, 300);

            Glide.with(activity).load(R.mipmap.sq).apply(options).into(((HeadHolder) holder).head);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD;
        } else
            return CONTENT;
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        final RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {

            ((GridLayoutManager) manager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (getItemViewType(position) == HEAD) {
                        return ((GridLayoutManager) manager).getSpanCount();
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    /**
     * 设置被点中的view
     */
    public void setSelset(int pos) {
        User user = list.get(pos - 1);
        user.setStatue(1);


        //刷新适配器
        notifyDataSetChanged();
    }


    static class MyHolder extends RecyclerView.ViewHolder {
        ImageView viewById;

        ImageView load;


       // LayoutImageItemBinding bind;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

           // bind = DataBindingUtil.bind(itemView);

            viewById = itemView.findViewById(R.id.image);

            load = itemView.findViewById(R.id.iv_load);

        }

    }

    static class HeadHolder extends RecyclerView.ViewHolder {
        ImageView head;

        public HeadHolder(@NonNull View itemView) {
            super(itemView);

            head = itemView.findViewById(R.id.head);
        }
    }


}
