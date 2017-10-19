package genericCases;

import java.io.IOException;

public class desbloquearPantalla {
	public static void main(String args []){
		Runtime rt = Runtime.getRuntime();
		try {
			Process pr = rt.exec("/Users/itworkers/Android/platform-tools/adb shell input keyevent KEYCODE_POWER;");
			Thread.sleep(1000);
			pr=rt.exec("/Users/itworkers/Android/platform-tools/adb shell input touchscreen swipe 230 380 230 880;");
			Thread.sleep(000);
			pr=rt.exec("/Users/itworkers/Android/platform-tools/adb shell input tap 200 700;");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
