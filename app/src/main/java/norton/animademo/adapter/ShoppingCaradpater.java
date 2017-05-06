package norton.animademo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import norton.animademo.R;

/**
 * Created by Norton on 2017/5/4.
 */

public class ShoppingCaradpater extends RecyclerView.Adapter<ShoppingCaradpater.ViewHolder> {

    private List<String> datas = new ArrayList<>();
    private Context mContext;


    public onItemClickListenter mOnItemClickListenter;

    public ShoppingCaradpater(Context context) {
        mContext = context;
        for (int i = 0; i < 20; i++) {
            datas.add(i+"");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_shopping_car,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv.setText(datas.get(position));
        if (mOnItemClickListenter != null) {
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListenter.onItemClick(v,holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{
         TextView tv;
         ImageView img;
         public ViewHolder(View itemView) {
             super(itemView);
             tv = (TextView) itemView.findViewById(R.id.tv);
             img = (ImageView) itemView.findViewById(R.id.img);

         }
     }

     public static interface onItemClickListenter{
         void onItemClick(View view,int position);
     }

     public void setOnItemClickListenter(onItemClickListenter onImteClickListener){
         this.mOnItemClickListenter = onImteClickListener;
     }

}
