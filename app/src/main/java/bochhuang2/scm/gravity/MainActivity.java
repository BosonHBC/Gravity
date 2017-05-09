package bochhuang2.scm.gravity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private GameView gv;

    private SensorManager mgr;
    private Sensor sensor;
    private float[] g = {0, 0, SensorManager.GRAVITY_EARTH};
    private float[] a = {0, 0, 0};
    public static final String PREFS_NAME = "MyPrefsFile";
    int highScore = 0;
    Player player;

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            //event.values[1], event.values[0]
            gv.player.setSpeed(event.values[1],event.values[0]);

            //Log.d("Game", "x:" + event.values[1]+ " y: " + event.values[0]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide(); // hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   // full screen
        //setContentView(R.layout.activity_main);
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        gv = new GameView(this);
        setContentView(gv);

        mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        sensor = mgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensor == null) {
            Log.d("Game", "sensor of interest not detected.");
        }

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        highScore = settings.getInt("HIGH_SCORE",0);
        gv.setHighScore(highScore);
    }


    @Override
    protected void onResume() {
        // make it landscape
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        if (sensor != null)
            mgr.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_GAME);

        super.onResume();
    }

    @Override
    protected void onPause() {
        if (sensor != null) mgr.unregisterListener(listener, sensor);
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        highScore = gv.getHighScore();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("HIGH_SCORE", highScore);
        // Commit the edits!
        editor.commit();
    }
}
