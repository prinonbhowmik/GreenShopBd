package com.greenshopbd.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.greenshopbd.Fragments.HomeFragment;
import com.greenshopbd.Models.Login.LoginResponse;
import com.greenshopbd.R;
import com.greenshopbd.Retrofit.ApiInterface;
import com.greenshopbd.Retrofit.Apiutils;
import com.greenshopbd.Utils.SharedPref;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences sharedPreferences;
    private BottomNavigationView chipNavigationBar;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initt();

        FragmentTransaction home = getSupportFragmentManager().beginTransaction();
        home.replace(R.id.fragment_container, new HomeFragment());
        home.commit();

        chipNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.home:
                        FragmentTransaction home = getSupportFragmentManager().beginTransaction();
                        home.replace(R.id.fragment_container, new HomeFragment());
                        home.commit();
                        break;
                    case R.id.wishlist:
               /* if (loggedIn == 0) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));

                } else {
                    FragmentTransaction favourite = getSupportFragmentManager().beginTransaction();
                    favourite.replace(R.id.fragment_container, new FavouriteFragment());
                    favourite.commit();
                }*/

                        break;
                    case R.id.recently:
                        Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();

                        break;
                    case R.id.account:
                        if (SharedPref.read("loggedin","").equals("yes")){

                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            View view = getLayoutInflater().inflate(R.layout.login_popup, null);
                            builder.setView(view);
                            AlertDialog alert = builder.create();

                            TextView forgotTv = view.findViewById(R.id.forgotTv);
                            TextView signup = view.findViewById(R.id.signUp);
                            TextView loginTv = view.findViewById(R.id.loginTv);
                            EditText emailEt = view.findViewById(R.id.emailEt);
                            EditText passwordEt = view.findViewById(R.id.passwordEt);

                            loginTv.setOnClickListener(v -> {
                                String email = emailEt.getText().toString();
                                String pass = passwordEt.getText().toString();

                                if (!email.equals("") || !pass.equals("")){
                                    apiInterface.doSignIn(email,pass).enqueue(new Callback<LoginResponse>() {
                                        @Override
                                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                            if (response.isSuccessful()){
                                                if (response.body().getError()==false){
                                                    SharedPref.write("loggedin","yes");
                                                    Toast.makeText(MainActivity.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                                                    alert.dismiss();
                                                }
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                                        }
                                    });
                                }

                            });

                            alert.show();
                        }

                }
                return false;
            }
        });
    }

    private void initt() {
        SharedPref.init(this);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        apiInterface = Apiutils.getUserService();
        chipNavigationBar = findViewById(R.id.bottom_menu);
        chipNavigationBar.getMenu().clear();
        chipNavigationBar.inflateMenu(R.menu.bottom_drawer_menu);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.home_navigation_drawer);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.home:
                FragmentTransaction home = getSupportFragmentManager().beginTransaction();
                home.replace(R.id.fragment_container, new HomeFragment());
                home.commit();
                break;
            case R.id.wishlist:
               /* if (loggedIn == 0) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));

                } else {
                    FragmentTransaction favourite = getSupportFragmentManager().beginTransaction();
                    favourite.replace(R.id.fragment_container, new FavouriteFragment());
                    favourite.commit();
                }*/

                break;
            case R.id.recently:
                Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();

                break;
            case R.id.account:
              if (SharedPref.read("loggedin","").equals("yes")){

              }else{
                  AlertDialog.Builder builder = new AlertDialog.Builder(this);
                  View view = getLayoutInflater().inflate(R.layout.login_popup, null);
                  builder.setView(view);
                  AlertDialog alert = builder.create();

                  TextView forgotTv = view.findViewById(R.id.forgotTv);
                  TextView signup = view.findViewById(R.id.signUp);
                  TextView loginTv = view.findViewById(R.id.loginTv);
                  EditText emailEt = view.findViewById(R.id.emailEt);
                  EditText passwordEt = view.findViewById(R.id.passwordEt);

                  loginTv.setOnClickListener(v -> {
                      String email = emailEt.getText().toString();
                      String pass = passwordEt.getText().toString();

                      if (!email.equals("") || !pass.equals("")){
                          apiInterface.doSignIn(email,pass).enqueue(new Callback<LoginResponse>() {
                              @Override
                              public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                  if (response.isSuccessful()){
                                      if (response.body().getError()==false){
                                          SharedPref.write("loggedin","yes");
                                          Toast.makeText(MainActivity.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                                          alert.dismiss();
                                      }
                                  }
                              }

                              @Override
                              public void onFailure(Call<LoginResponse> call, Throwable t) {

                              }
                          });
                      }

                  });

                  alert.show();
              }

        }
        return false;
    }
}