import java.awt.Canvas;

import javax.swing.JFrame;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Player {
	private MediaPlayerFactory mpf =null;
	private EmbeddedMediaPlayer emp=null;
	private CanvasVideoSurface videoSurface=null;
	public Player(){
		if(System.getProperty("os.arch").equals("amd64"))
			NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "./lib/64");
		else if(System.getProperty("os.arch").equals("x86"))
			NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "./lib/32");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		mpf= new MediaPlayerFactory();
	}
	public void setJFrame(JFrame frame){
		emp=mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(frame));
	}
	public void setCanvas(Canvas canvas){
		videoSurface= mpf.newVideoSurface(canvas);
		emp.setVideoSurface(videoSurface);
	}
	public EmbeddedMediaPlayer getMediaController(){
		return emp;
	}
	public void disableKeyboardAndMouse(){
		emp.setEnableMouseInputHandling(false);
		emp.setEnableKeyInputHandling(false);
	}
	public void initVideoFile(String file){
		emp.prepareMedia(file);
	}
	public void playVideo(){
		//emp.toggleFullScreen();
		emp.play();
	}
	public void setSize(int width, int height){
		videoSurface.canvas().setSize(width, height);
	}
	public void setPosition(int x,int y){
		videoSurface.canvas().setLocation(x, y);
	}
}
