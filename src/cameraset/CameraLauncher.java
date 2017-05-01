package cameraset;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CameraLauncher {

	public static void main(String[] args) {

		CameraLauncher obj = new CameraLauncher();
		
		/**
		 * to be completed by executing Shell
		 * @parm Shoot
		 * @parm CameraId 
		 */
		
		String command = "sudo " + "gphoto2 --auto-detect && gphoto2 --capture-image-and-download"; 

	
		String output = obj.executeCommand(command);

		System.out.println(output);

	}

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

}
