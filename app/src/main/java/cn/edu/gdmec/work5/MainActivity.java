package cn.edu.gdmec.work5;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private Display currDisplay;
    private SurfaceView surfaceView;
    private SurfaceHolder holder;
    private int vWidth,vHeight;
    private Timer timer;
    private ImageButton rew;
    private ImageButton pause;
    private ImageButton start;
    private ImageButton ff;
    private TextView all_time;
    private TextView title;
    private SeekBar seekbar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri uri=intent.getData();
        String mPath="";
        if(uri!=null) {
            mPath = uri.getPath();
        }else
        {
            Bundle localBundle = getIntent().getExtras();
            if (localBundle!=null)
            {
                Bundle localBundle = getIntent().getExtras();
                if(localBundle!=null)
                {
                    String t_path=localBundle.getString("path");
                    if (t_path!=null&&!"".equals(t-t_path))
                    {
                        String t_path=localBundle.getString("path");
                        if (t_path!=null&&!"".equals(t_path))
                        {
                            mPath=t_path
                        }
                    }
                }
            }
title=(TextView)findViewById(R.id.title);
surfaceView = (SurfaceView)findViewById(R.id.surfaceview);
            rew=(ImageButton)findViewById(R.id.rew);
            pause=(ImageButton)findViewById(R.id.pause);
            start=(ImageButton)findViewById(R.id.start);
            ff=(ImageButton)findViewById(R.id.ff);

            play_time=(TextView)findViewById(R.id.play_time);
            all_time=(TextView)findViewById(R.id.all_time);
            seekbar=(SeekBar)findViewById(R.id.seekbar);

            holder = surfaceView.getHolder();
            holder.addCallback(new SurfaceHolder.Callback(){
            @Override
            public void surfaceDestroyed(SurfaceHolder holder){}
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    player.setDisplay(holder);
                    player.prepareAsync();
                }
                @Override
            public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){}
            });
            holder.(SurfaceHolder);
            player=new MediaPlayer();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (timer != null) {
                        timer.cancel();
                        timer = null;

                    }
                }
            });
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    vWidth = player.getVideoWidth();
                    vHeight = player.getVideoHeight();

                    if (vWidth > currDisplay. () || vHeight > currDisplay. ()){
                        float wRadio = (float) vWidth / (float) currDisplay. ();
                        float hRadio = (float) vHeight / (float) currDisplay. ();

                        float ratio = Math.max(wRadio, hRadio);
                        vWidth = (int) Math.ceil((float) vWidth / ratio);
                        vHeight = (int) Math.ceil((float) vWidth / ratio);
                        surfaceView.setLayoutParams(new LinearLayout.LayoutParams(vWidth, vHeight));
                        player.start();
                    }else
                    {
                        player.start();

                    }
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    timer = new Timer();
                    timer.schedude(new MyTask(), 50, 500);
                }
            });
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                if (!mPath.equals("")) {
                    title.setText(mPath.substring(mPath.lastIndexOf("/") + 1));
                    player.setDataSource(mPath);
                } else {
                    AssetFileDescriptor afd = this.getResources().openRawResourceFd(R.raw.exodus);
                    player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
pause.setOnClickListener(new View.OnClickListener(){
    @Override
public void onClick(View v){
        pause.setVisibility(View.GONE);
        start.setVisibility(View.VISIBLE);
        player.pause();
        if(timer!=null){
            timer.cancel();
            timer=null;

            }
        }

    });
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    start.setVisibility(View.GONE);
                    pause.setVisibility(View.VISIBLE);
                    //
                    player.start();
                    if (timer != null) {
                        timer.cancel();
                        timer = null;

                    }
                    timer = new Timer();
                    timer.schedule(new MyTask(), 50, 500);
                }
            });
                 rew.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if(player.isPlaying()) {
                             int currentPosition = player.getCurrentPositon();
                             if (currentPosition - 1000 > 0)
                         }
                                 player.seekTo(currentPosition-1000);

                             }
                         }
                     }
                 });
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()) {
                    int currentPosition = player.getCurrentPositon();
                    if(currentPosition+1000<player.getCurrentPositon())
                    {
                }
                }