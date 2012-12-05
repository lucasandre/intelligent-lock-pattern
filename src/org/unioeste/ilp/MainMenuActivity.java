package org.unioeste.ilp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Main menu of the application.
 * 
 * Some elements have permitions to be showed.
 * 
 * @author Lucas Andr� de Alencar
 *
 */
public class MainMenuActivity extends BaseActivity {
	
	Button buttonInsertPattern;
	Button buttonShowPatterns;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        buttonInsertPattern = (Button) findViewById(R.id.button_insert_pattern);
        buttonShowPatterns = (Button) findViewById(R.id.button_show_patterns);
        
        setPermitions();
    }
    
    private void setPermitions () {
    	if (ilp.prefs.getBoolean("admin_mode", false)) {
    		buttonInsertPattern.setVisibility(View.VISIBLE);
    		buttonShowPatterns.setVisibility(View.VISIBLE);
    	} else {
    		buttonInsertPattern.setVisibility(View.GONE);
    		buttonShowPatterns.setVisibility(View.GONE);
    	}
    }
    
    public void gotoStartExperimentActivity (View view) {
    	Intent i = new Intent(this, StartExperimentActivity.class);
    	startActivity(i);
    }
    
    public void gotoInsertPatternActivity (View view) {
    	Intent i = new Intent(this, InsertPatternActivity.class);
    	startActivity(i);
    }
    
    public void gotoShowPatternsActivity (View view) {
    	Intent i = new Intent(this, ShowPatternsActivity.class);
    	startActivity(i);
    }
    
    public void gotoTestAuthActivity(View view) {
    	Intent i = new Intent(this, ShowPatternsActivity.class);
    	i.putExtra(ShowPatternsActivity.activity_flux, ShowPatternsActivity.TEST_AUTH_FLUX);
    	startActivity(i);
    }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		super.onSharedPreferenceChanged(sharedPreferences, key);
		if (key.equals("admin_mode"))
			setPermitions();
	}
}