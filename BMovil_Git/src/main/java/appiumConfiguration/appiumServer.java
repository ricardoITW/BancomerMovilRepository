package appiumConfiguration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;

import com.github.genium_framework.appium.support.command.CommandManager;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;

public class appiumServer {
	public static void Start(){
		ServerArguments serverArguments = new ServerArguments();
		serverArguments.setArgument("--address","127.0.0.1");//CRUZR
		serverArguments.setArgument("--port","4723");
		serverArguments.setArgument("--no-reset",true);
		serverArguments.setArgument("--log","C:/Users/Administrator/Documents/logs.txt");
		
		//********************************* Ruta para Mac ***************************************
		//AppiumServer appiumS = new AppiumServer(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"),
		//		new File("/usr/local/lib/node_modules/appium/build/lib/main.js"),serverArguments);
		//appiumS.startServer();
		//***************************************************************************************
		
		AppiumServer appiumS = new AppiumServer(new File("C:/node/node.exe"),
				new File("C:/Users/Administrator/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"),serverArguments);
		//"C:/Users/Administrator/AppData/Roaming/npm/node_modules/appium/build/lib/main.js
		appiumS.startServer();
	}
	
	public static void Stop(){
		//*********************************Stop para Mac ***********************************
		
		/*String[] stopServerCommand = null;
		stopServerCommand = new String[]{"/bin/sh", "-c",
        "PID=\"$(lsof -i -P | pgrep -f node)\";kill -9 $PID"};
		try{
			CommandManager.executeCommandUsingJavaRuntime(stopServerCommand, true);
			System.out.println("Servidor appium detenido");
		}catch(Exception e){
			System.out.println("Error al detener al servidor Appium");
		}*/
		//**********************************************************************************
		
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			System.out.println("Servidor appium detenido");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error al detener al servidor Appium");
		}	
	}
	
	
}
