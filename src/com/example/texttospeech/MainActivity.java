package com.example.texttospeech;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	EditText et;
	Button btn;
	TextToSpeech ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       et=(EditText)findViewById(R.id.editText1);
       btn=(Button)findViewById(R.id.button1);
       btn.setOnClickListener(this);
       
       ts=new TextToSpeech(this, new ConvertActivity());
    }

    @Override
    public void onClick(View arg0) {
    	// TODO Auto-generated method stub
    	String text=et.getText().toString();
    	ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    class ConvertActivity implements OnInitListener{
    	@Override
    	public void onInit(int arg0) {
    		// TODO Auto-generated method stub
    		ts.setLanguage(Locale.US);
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

