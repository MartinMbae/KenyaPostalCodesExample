package studios.luxurious.kenyanpostalcodes.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import studios.luxurious.kenyanpostalcodes.R;
import studios.luxurious.kenyanpostalcodes.adapters.PostalAreaAdapter;
import studios.luxurious.kenyanpostalcodes.models.PostalArea;

public class KenyaPostalCodes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void showAllPostalAreas(Context context, boolean sortByPostalName, String listTitle, final PostalAreaSelected postalAreaSelected) {

        final ArrayList<PostalArea> postalAreas = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open(
                    "postal.json")));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            JSONObject jsonObjMain = new JSONObject(sb.toString());
            Iterator<?> keys = jsonObjMain.keys();
            while (keys.hasNext()) {
                String postalCode = (String) keys.next();
                String postalName = jsonObjMain.getString(postalCode);
                postalAreas.add(new PostalArea(postalName, postalCode));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        if (sortByPostalName) Collections.sort(postalAreas, new MyComparator());
        PostalAreaAdapter customAdapter = new PostalAreaAdapter(context, postalAreas);

        new AlertDialog.Builder(context)
                .setTitle(listTitle)
                .setAdapter(customAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        postalAreaSelected.OnPostalAreaSelected(postalAreas.get(which));
                        dialog.dismiss();
                    }
                }).create().show();
    }



    static class MyComparator implements Comparator<PostalArea> {
        @Override
        public int compare(PostalArea o1, PostalArea o2) {
            return o1.getAreaName().compareTo(o2.getAreaName());

        }
    }
}
