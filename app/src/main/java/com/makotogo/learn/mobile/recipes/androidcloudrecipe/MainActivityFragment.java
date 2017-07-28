/*
 *  Copyright 2017 Makoto Consulting Group, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.makotogo.learn.mobile.recipes.androidcloudrecipe;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String SERVER_URL = "http://androidrecipe.mybluemix.net/OdotWrapper/ItemRestService/FindAll";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // TextView - Bluemix URL
        final TextView serverUrl = view.findViewById(R.id.textViewServerUrl);
        serverUrl.setText(SERVER_URL);

        // Button - refresh from the Bluemix URL
        Button buttonRefreshFromServer = view.findViewById(R.id.buttonRefreshFromServer);
        buttonRefreshFromServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ItemRestServicePingTask().execute(serverUrl.getText().toString());
            }
        });

        return view;
    }

    /**
     * AsyncTask - need to make the Web Service call off the UI thread
     * or the Android runtime will have a fit.
     */
    private class ItemRestServicePingTask extends AsyncTask<String, Void, Item[]> {
        @Override
        protected Item[] doInBackground(String... params) {
            try {
                //
                // Instantiate the RestTemplate.
                RestTemplate restTemplate = new RestTemplate();
                //
                // Add the Jackson mapping converter
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                //
                // Make the server call
                Item[] items = restTemplate.getForObject(params[0], Item[].class);
                //
                // Return the Item array
                return items;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Item[] items) {
            //
            // TextView - JSON Message - get a reference
            final ListView listViewItems = getActivity().findViewById(R.id.listViewItems);
            //
            // Display the message
            String[] adapterItems = new String[items.length];
            int aa = 0;
            for (Item item : items) {
                adapterItems[aa++] = item.getDescription() + "(Id: " + item.getId() + "(Category: " + ((item.getCategory() == null) ? "(NO CATEGORY)" : item.getCategory().getName()) + ")";
            }
            ArrayAdapter<String> listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, adapterItems);
            listViewItems.setAdapter(listAdapter);
            listAdapter.notifyDataSetChanged();
        }

    }

}
