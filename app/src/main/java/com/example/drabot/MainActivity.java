package com.example.drabot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigation;
    Toolbar toolbar;
    FrameLayout main;
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navigation=findViewById(R.id.bottom_navigation);
        main=findViewById(R.id.main);
        toolbar=findViewById(R.id.toolbar);
        drawer = (DrawerLayout)findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawer,toolbar,R.string.open, R.string.close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigation = (NavigationView)findViewById(R.id.navigation);
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home",Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main,new FirstFragment());
                        fragmentTransaction.commit();
                        // getSupportFragmentManager().beginTransaction().replace(R.id.main,new FirstFragment());
                        break;
                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.main,new ProfileFragment());
                        fragmentTransaction1.commit();
                        break;
                    case R.id.setting:
                        Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.main,new SettingFragment());
                        fragmentTransaction2.commit();
                        break;
                    case R.id.logout:
                        Toast.makeText(MainActivity.this, "Logout",Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        FragmentTransaction fragmentTransaction3=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.main,new LogoutFragment());
                        fragmentTransaction3.commit();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home",Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                    FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main,new FirstFragment());
                    fragmentTransaction.commit();
                   // getSupportFragmentManager().beginTransaction().replace(R.id.main,new FirstFragment());
                    break;
                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.main,new ProfileFragment());
                        fragmentTransaction1.commit();
                        break;
                    case R.id.setting:
                        Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.main,new SettingFragment());
                        fragmentTransaction2.commit();
                        break;
                    case R.id.logout:
                        Toast.makeText(MainActivity.this, "Logout",Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        FragmentTransaction fragmentTransaction3=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.main,new LogoutFragment());
                        fragmentTransaction3.commit();
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}