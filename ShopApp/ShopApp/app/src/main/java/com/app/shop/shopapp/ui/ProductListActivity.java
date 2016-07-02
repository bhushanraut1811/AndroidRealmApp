package com.app.shop.shopapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.adapter.ProductListAdapter;
import com.app.shop.shopapp.model.Product;
import com.app.shop.shopapp.utils.RealmWrapper;
import com.app.shop.shopapp.utils.SharedPrefUtility;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProductListActivity extends AppCompatActivity {

    private Realm mRealm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        mRealm = RealmWrapper.createRealmInstance(this);

        SharedPrefUtility prefUtility = new SharedPrefUtility(this);
        if (!prefUtility.getPrefData("load_data").equals("false")) {
            prepareDataBase();
            prefUtility.editPrefData("load_data", "done");
        }
        prepareDataBase();

        RealmResults<Product> result =
                mRealm.where(Product.class).findAll();

        //setting data into list
        ProductListAdapter productListAdapter = new ProductListAdapter(this, result);
        ListView listView = (ListView) findViewById(R.id.lv_list);
        listView.setAdapter(productListAdapter);


    }

    private void prepareDataBase() {
        // Create an object
        mRealm.beginTransaction();
        Product product = mRealm.createObject(Product.class);
        product.setmProductId(1);
        product.setmProductName("shoes1");
        product.setmCategory("below 1000");
        product.setmPrice(700);
        product.setmImage(R.drawable.sports_shoes);
        mRealm.commitTransaction();

        // Create an object
        mRealm.beginTransaction();
        product = mRealm.createObject(Product.class);
        product.setmProductId(2);
        product.setmProductName("shoes2");
        product.setmCategory("below 1000");
        product.setmPrice(900);
        product.setmImage(R.drawable.sports_shoes);
        mRealm.commitTransaction();

        // Create an object
        mRealm.beginTransaction();
        product = mRealm.createObject(Product.class);
        product.setmProductId(3);
        product.setmProductName("shoes3");
        product.setmCategory("between 1000-3000");
        product.setmPrice(2000);
        product.setmImage(R.drawable.sports_shoes);
        mRealm.commitTransaction();

        // Create an object
        mRealm.beginTransaction();
        product = mRealm.createObject(Product.class);
        product.setmProductId(4);
        product.setmProductName("shoes4");
        product.setmCategory("between 1000-3000");
        product.setmPrice(2000);
        product.setmImage(R.drawable.sports_shoes);
        mRealm.commitTransaction();

        // Create an object
        mRealm.beginTransaction();
        product = mRealm.createObject(Product.class);
        product.setmProductId(5);
        product.setmProductName("shoes5");
        product.setmCategory("between 1000-3000");
        product.setmPrice(2000);
        product.setmImage(R.drawable.sports_shoes);
        mRealm.commitTransaction();

    }


}
