package demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import demo.zhh.com.mvp_retrofit_dragger2_rx.R;
import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;
import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.DisplayImage;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.LayoutParamsUtils;

/**
 * 首页数据适配器
 * Created by admin on 2016/5/4.
 */
public class MainDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<PaperInfo.Data> data;
    private Context mContext;
    public MainDataAdapter(Context context){
        mContext = context;
        data = new ArrayList<>();
    }

    /**
     * 设置数据
     * @param data 数据集合
     */
    public void setData(ArrayList<PaperInfo.Data> data){
        int index = this.data.size();
        this.data.addAll(data);
        notifyItemRangeInserted(index, this.data.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainDataHolder( View.inflate(parent.getContext(),R.layout.main_item_layout, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PaperInfo.Data dataImage = data.get(position);
        if(dataImage != null && dataImage.getImage() != null){
            DisplayImage.display(((MainDataHolder) holder).imageView, dataImage.getImage().getSmall(), App.options);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public final class MainDataHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.show_pic)
        ImageView imageView;

        public MainDataHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            LayoutParamsUtils.layout(imageView, 380, 0 , mContext, null);

        }
    }
}
