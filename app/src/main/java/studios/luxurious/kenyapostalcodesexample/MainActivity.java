package studios.luxurious.kenyapostalcodesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import studios.luxurious.kenyanpostalcodes.activities.KenyaPostalCodes;
import studios.luxurious.kenyanpostalcodes.activities.PostalAreaSelected;
import studios.luxurious.kenyanpostalcodes.models.PostalArea;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void sortByName(View view) {
        KenyaPostalCodes.showAllPostalAreas(MainActivity.this,
                true,
                "Show Post Codes",
                new PostalAreaSelected() {
            @Override
            public void OnPostalAreaSelected(PostalArea selectedPostalArea) {

                String name =  selectedPostalArea.getAreaName();
                String code = selectedPostalArea.getAreaCode();
                Toast.makeText(MainActivity.this, "You've selected "+ selectedPostalArea.getAreaName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sortbyCode(View view) {
        KenyaPostalCodes.showAllPostalAreas(MainActivity.this, false,"Show Post Codes", new PostalAreaSelected() {
            @Override
            public void OnPostalAreaSelected(PostalArea selectedPostalArea) {
                Toast.makeText(MainActivity.this, "You've selected "+ selectedPostalArea.getAreaName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
