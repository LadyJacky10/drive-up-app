package com.driveup.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.driveup.app.ui.dashboard.DashboardFragmentHome;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    public static FragmentManager fragmentManager;
    private TextView myUsername;
    private TextView myUserPassword;
    public static HomeActivity HomeContextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomeActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        myUsername = (TextView) headerView.findViewById(R.id.profile_username);
        myUserPassword = (TextView) headerView.findViewById(R.id.profile_password);
        myUsername.setText(getIntent().getExtras().getString("name"));
        myUserPassword.setText(getIntent().getExtras().getString("role"));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_dashboard:
                        fragment = new DashboardFragmentHome();
                        toolbar.setTitle("Tableau de bord");
                        setMyFragment(fragment);
                    default:
                        fragment = new DashboardFragmentHome();
                        setMyFragment(fragment);
                }
                // Close the navigation drawer
                drawer.closeDrawers();

                return true;
            }
        });
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_frame, new DashboardFragmentHome()).commit();
        HomeActivity.HomeContextActivity = HomeActivity.this;

    }

    private void setMyFragment(Fragment fragment) {
        // Récupérer le fragment en cours
        fragmentManager = getSupportFragmentManager();
        // Récupérer la transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Remplace le nouveau fragment dans le conteneur
        fragmentTransaction.replace(R.id.nav_frame, fragment, "CURRENT");
        fragmentTransaction.commit();
    }

}