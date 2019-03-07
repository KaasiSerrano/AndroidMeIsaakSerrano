/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import butterknife.ButterKnife;
import butterknife.OnClick;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {
    BodyPartFragment headPartFragment;
    BodyPartFragment bodyPartFragment;
    BodyPartFragment legPartFragment;


    //TODO(1) Create a layout that displays the one body part image named fragment_body_part.xml
    // This layout should contain one single ImageView
    //TODO(2) Create a new class called BodyPartFargment to display  an image of an Android-Me body part
    // in this class, you'll need to implement an empty constructor and the onCreateView()
    //TODO(3) Show the first image in the list of head  image
    //Soon, you'll update this image display code to show any image you want
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        ButterKnife.bind(AndroidMeActivity.this);

        // TODO (4) Create a new instance of BodyPartFragment and display it using FragmentManager


        headPartFragment = new BodyPartFragment();
        headPartFragment.setDisplayIndex(1);
        headPartFragment.setImageids(AndroidImageAssets.getHeads());
        FragmentManager headFragmentManager = getSupportFragmentManager();
        headFragmentManager.beginTransaction().add(R.id.head_container, headPartFragment).commit();


        bodyPartFragment  = new BodyPartFragment();
        bodyPartFragment.setDisplayIndex(1);
        bodyPartFragment.setImageids(AndroidImageAssets.getBodies());
        FragmentManager bodyFragmentManager = getSupportFragmentManager();
        bodyFragmentManager.beginTransaction().add(R.id.body_container2, bodyPartFragment).commit();


        legPartFragment  = new BodyPartFragment();
        legPartFragment.setDisplayIndex(2);
        legPartFragment.setImageids(AndroidImageAssets.getLegs());
        FragmentManager legFragmentManager = getSupportFragmentManager();
        legFragmentManager.beginTransaction().add(R.id.leg_containe3, legPartFragment).commit();


    }

    @OnClick(R.id.head_container)
    public void onClick_head_container(View v) {
        // Get current index and add 1
        int index = headPartFragment.getDisplayIndex() + 1;

        // If index is less than heads size update display index
        // else set display index to 0
        if (index < AndroidImageAssets.getHeads().size()) {
            headPartFragment.setDisplayIndex(index);
        } else {
            headPartFragment.setDisplayIndex(0);
        }
        headPartFragment.refresh();
        Toast.makeText(this, "This is the Head that was Clicked", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.body_container2)
    public void onClick_body_container(View v) {
        // Get current index and add 1
        int index1 = bodyPartFragment.getDisplayIndex() + 1;

        // If index is less than heads size update display index
        // else set display index to 0
        if (index1 < AndroidImageAssets.getBodies().size()) {
            bodyPartFragment.setDisplayIndex(index1);
        } else {
            bodyPartFragment.setDisplayIndex(0);
        }
        bodyPartFragment.refresh();
        Toast.makeText(this, "This is the body that was Clicked", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.leg_containe3)
    public void onClick_leg_container(View v) {
        // Get current index and add 1
        int index2 = legPartFragment.getDisplayIndex() + 1;

        // If index is less than heads size update display index
        // else set display index to 0
        if (index2 < AndroidImageAssets.getLegs().size()) {
            legPartFragment.setDisplayIndex(index2);
        } else {
            legPartFragment.setDisplayIndex(0);
        }
        legPartFragment.refresh();
        Toast.makeText(this, "This is the leg that was Clicked", Toast.LENGTH_SHORT).show();
    }
}