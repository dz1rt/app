package com.example.fitnes.fitnes.ListProgram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.example.fitnes.fitnes.R;
import com.example.fitnes.fitnes.service.ClickListener;
import com.example.fitnes.fitnes.service.RecyclerAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;

import java.util.List;

public class ListProgram extends AppCompatActivity {

    private RecyclerAdapter recyclerAdapter;
//    private List<ProgramItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_program);



        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

//        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_home);
//        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(true)
                .build();

        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        //TODO: Intent intent = getIntent(); Получаем result, заполняем listItems
        Bundle arguments = getIntent().getExtras();
        List<ProgramItem> result = (List<ProgramItem>) arguments.get("result");
        recyclerAdapter = new RecyclerAdapter(result, this, true, new ClickListener() {
            @Override
            public void onPositionClicked(int position, View v) {

            }
        });
        rv.setAdapter(recyclerAdapter);
}

}
