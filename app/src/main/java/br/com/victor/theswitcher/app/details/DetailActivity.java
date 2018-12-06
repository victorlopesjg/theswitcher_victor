package br.com.victor.theswitcher.app.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.victor.theswitcher.R;
import br.com.victor.theswitcher.model.Room;
import br.com.victor.theswitcher.utils.Constants;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */
public class DetailActivity extends AppCompatActivity {

    private TextView labelText;
    private TextView labelStatus;
    private ImageView imageSatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setup();

        Room room = (Room) getIntent().getExtras().get(Constants.KEY_DETAIL);
        showInfo(room);
    }

    private void setup() {
        labelText = findViewById(R.id.label_text);
        labelStatus = findViewById(R.id.label_status);
        imageSatus = findViewById(R.id.image_lamp);
    }

    private void showInfo(Room room) {
        String textDetail = getString(R.string.text_detail);
        textDetail = textDetail.replace("%s", room.getName());

        labelText.setText(textDetail);

        if (room.isStatus()) {
            labelStatus.setText("ON");
            imageSatus.setImageDrawable(getDrawable(R.drawable.lamp_on));
        } else {
            labelStatus.setText("OFF");
            imageSatus.setImageDrawable(getDrawable(R.drawable.lamp_off));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
