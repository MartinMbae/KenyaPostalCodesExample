package studios.luxurious.kenyanpostalcodes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import studios.luxurious.kenyanpostalcodes.R;
import studios.luxurious.kenyanpostalcodes.models.PostalArea;

public class PostalAreaAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;

    private ArrayList<PostalArea> postalAreaArrayList;

    public PostalAreaAdapter(Context applicationContext, ArrayList<PostalArea> postalAreaArrayList) {
        this.context = applicationContext;
        inflter = (LayoutInflater.from(applicationContext));
        this.postalAreaArrayList = postalAreaArrayList;
    }

    @Override
    public int getCount() {
        return postalAreaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        PostalArea postalArea = postalAreaArrayList.get(i);

        view = inflter.inflate(R.layout.postal_area_layout, null);
        TextView postalName = view.findViewById(R.id.postalAreaName);
        TextView postalNumber = view.findViewById(R.id.postalNumber);
        postalName.setText(postalArea.getAreaName());
        postalNumber.setText(postalArea.getAreaCode());

        return view;
    }

}
