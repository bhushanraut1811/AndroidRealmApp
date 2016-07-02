package com.app.shop.shopapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.model.Product;

import io.realm.RealmResults;

/**
 * Created by bhushan.raut on 4/14/2016.
 */
public class ProductListAdapter extends BaseAdapter {


    private Context context;
    private RealmResults<Product> mList;


    public ProductListAdapter(Context context, RealmResults<Product> list) {
        this.context = context;
        this.mList = list;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row;
        final ListViewHolder listViewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = layoutInflater.inflate(R.layout.item_product, parent, false);
            listViewHolder = new ListViewHolder();
            listViewHolder.name = (TextView) row.findViewById(R.id.tv_details);

            listViewHolder.addTocart = (Button) row.findViewById(R.id.btn_add_to_cart);

            listViewHolder.image = (ImageView) row.findViewById(R.id.iv_product_image);
            row.setTag(listViewHolder);
        } else {
            row = convertView;
            listViewHolder = (ListViewHolder) row.getTag();
        }


        listViewHolder.name.setText(mList.get(position).getmProductName() + " " + mList.get(position).getmPrice());


        listViewHolder.image.setImageResource(mList.get(position).getmImage());


        //button long press
        listViewHolder.addTocart.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return true;
            }
        });


        listViewHolder.addTocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        return row;
    }


    public static class ListViewHolder {

        ImageView image;
        TextView name;
        Button addTocart;

    }

}
