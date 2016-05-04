package demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import demo.zhh.com.mvp_retrofit_dragger2_rx.R;
import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;
import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;

/**
 * 首页数据适配器
 * Created by admin on 2016/5/4.
 */
public class MainDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ImageLoader imageLoader;
    private ArrayList<PaperInfo.Data> datas;
    public MainDataAdapter(){
        imageLoader = ImageLoader.getInstance();
        datas = new ArrayList<>();
    }

    /**
     * 设置数据
     * @param data 数据集合
     */
    public void setDatas(List<PaperInfo.Data> data){
        datas.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainDataHolder( View.inflate(parent.getContext(),R.layout.main_item_layout, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        imageLoader.displayImage(datas.get(position).getImage().getSmall(), ((MainDataHolder) holder).imageView, App.options);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public final class MainDataHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.show_pic)
        ImageView imageView;

        public MainDataHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
