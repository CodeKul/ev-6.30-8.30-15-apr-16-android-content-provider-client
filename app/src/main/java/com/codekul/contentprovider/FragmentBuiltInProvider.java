package com.codekul.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBuiltInProvider extends Fragment {


    public FragmentBuiltInProvider() {
        // Required empty public constructor
    }

    public static FragmentBuiltInProvider getInstance(){

        FragmentBuiltInProvider fragment = new FragmentBuiltInProvider();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_built, container, false);
        ListView listViewContacts = (ListView) rootView.findViewById(R.id.listContacts);
        ArrayList<String> arrContacts = new ArrayList<>();
        //Cursor cursorContacts = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        Uri uri = Uri.parse("content://com.codekul.content.provider/Bmw/1");
        Cursor cursorContacts = getActivity().getContentResolver().query(uri,null,null,null,null);

        while(cursorContacts.moveToNext()){

            //String contactName = cursorContacts.getString(cursorContacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //String number = cursorContacts.getString(cursorContacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            //arrContacts.add(contactName+"\n"+number);

            //String settingName = cursorContacts.getString(cursorContacts.getColumnIndex(Settings.System.NAME));
            //String settingValue = cursorContacts.getString(cursorContacts.getColumnIndex(Settings.System.VALUE));
            //arrContacts.add(settingName+"\n"+settingValue);

            String carName = cursorContacts.getString(cursorContacts.getColumnIndex("car_name"));
           String carVer = cursorContacts.getString(cursorContacts.getColumnIndex("car_ver"));
           arrContacts.add(carName+"\n"+carVer);
        }
        ArrayAdapter<String> adapterContacts = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrContacts);
        listViewContacts.setAdapter(adapterContacts);

        return rootView;
    }
}
