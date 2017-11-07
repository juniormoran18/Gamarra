package com.example.junior.gamarra_app.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.junior.gamarra_app.R;

public class MenuActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Inhabilitar las opciones del menu
        String rol = this.getIntent().getExtras().getString("Ingresado");
        if (rol.equals("cliente")) {
            itemsCliente();
        }else {
            itemsComerciante();
        }

        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set drawer toggle icon
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu1);
            ab.setDisplayHomeAsUpEnabled(true);
        }


        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()){
                    case R.id.nav_registrar:
                        Toast.makeText(MenuActivity.this, "resgistrar", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_calificaciones:
                        Toast.makeText(MenuActivity.this, "Ver estado", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(MenuActivity.this, "Perfil", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(MenuActivity.this, "Configuración", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(MenuActivity.this, "Cerrar Sesión", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MenuActivity.this, MainActivity.class));
                        break;

                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }



    private void itemsCliente() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu miMenu= navigationView.getMenu();
        miMenu.findItem(R.id.nav_calificaciones).setVisible(false);
        //Colocas todos los items que deseas esconder
    }

    private void itemsComerciante() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu miMenu= navigationView.getMenu();
        miMenu.findItem(R.id.nav_registrar).setVisible(false);

        //Colocas todos los items que deseas esconder
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
