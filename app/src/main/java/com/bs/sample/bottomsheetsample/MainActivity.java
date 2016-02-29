package com.bs.sample.bottomsheetsample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.bs.sample.bottomsheetsample.adapter.SimpleRecyclerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycler_bottom)
    RecyclerView recyclerBottom;
    @Bind(R.id.btn_create)
    Button btnCreate;

    private SimpleRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        adapter = new SimpleRecyclerAdapter(this);
        recyclerBottom.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerBottom.setAdapter(adapter);

        BottomSheetBehavior behavior = BottomSheetBehavior.from(recyclerBottom);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.i("FF", "BottomSheet Collapsed!");
                        break;

                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.i("FF", "BottomSheet Dragging!");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.i("FF", "BottomSheet Expanded!");
                        break;

                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.i("FF", "BottomSheet Hidden!");
                        break;

                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.i("FF", "BottomSheet Settling!");
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                ViewCompat.setScaleX(bottomSheet, slideOffset);
//                ViewCompat.setScaleY(bottomSheet, slideOffset);
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerBottom.setVisibility(View.GONE);

                View sheet = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_bottom_dialog, null);

                RecyclerView recyclerDialog = (RecyclerView) sheet.findViewById(R.id.recycler_dialog);
                recyclerDialog.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                recyclerDialog.setAdapter(adapter);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                bottomSheetDialog.setContentView(sheet);
                bottomSheetDialog.show();
            }
        });
    }

}
