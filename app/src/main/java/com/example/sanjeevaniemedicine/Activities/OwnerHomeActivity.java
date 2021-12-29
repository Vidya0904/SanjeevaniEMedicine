package com.example.sanjeevaniemedicine.Activities;

import android.Manifest;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sanjeevaniemedicine.DataModels.OwnerModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.SharedPreferenceManager;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.ActivityOwnerHomeBinding;
import com.google.android.material.navigation.NavigationView;

public class OwnerHomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityOwnerHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOwnerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        setSupportActionBar(binding.appBarOwnerHome.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mn_owner_dashboard, R.id.mn_owner_orders, R.id.mn_owner_addmedicine,R.id.mn_owner_profile)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_owner_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        View view = binding.navView.getHeaderView(0);

        ImageView imgOwner = view.findViewById(R.id.head_imageView);
        TextView textOwnName = view.findViewById(R.id.head_ownName);
        TextView textOwnEmail = view.findViewById(R.id.head_ownEmail);

        OwnerModel ownerModel = DataBaseClient.getInstance(this)
                .getAppDatabaseClient()
                .ownerModelDAOs()
                .getOwnerProfile(SharedPreferenceManager.getUser_Id(this));

        imgOwner.setImageBitmap(UtilsMethod.imgConvertFromByteArrayToBitmap(ownerModel.getOwnerImage()));
        textOwnName.setText(ownerModel.getUserName());
        textOwnEmail.setText(SharedPreferenceManager.getUser_Email(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.owner_home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_owner_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}