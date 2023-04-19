

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		try {
			String fileName = args[0];
			

			File file = new File(fileName);
			if (!fileName.endsWith(".arxml")) {
				throw new NotVaildAutosarFileException("Not Valid Extention");
			}
			if (!file.exists()) {
				throw new FileNotFoundException();
			}
			if (file.length() == 0) {
				throw new EmptyAutosarFileException("File is Empty");
			}
			FileInputStream inputStream = new FileInputStream(file);
			int d;
			StringBuilder stringBuilder = new StringBuilder();
			while ((d = inputStream.read()) != -1) {
				stringBuilder.append((char) d);
			}
			String data = stringBuilder.toString();
			Scanner scanner = new Scanner(data);
			ArrayList<Cont> containers = new ArrayList<>();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.contains("<CONTAINER")) {
					String contid = line.substring(line.indexOf("UUID="), line.indexOf(">"));
					String nametag = scanner.nextLine();

					String name = nametag.substring(nametag.indexOf(">") + 1, nametag.indexOf("</"));
                  //  System.out.println(name);
					String lnametag = scanner.nextLine();

					String lname = lnametag.substring(lnametag.indexOf(">") + 1, lnametag.indexOf("</"));
					Cont c = new Cont();
					// c.set_UUID(contid);
					// c.set_SHORT_NAME(name);
					// c.set_LONG_NAME(lname);
                    c.set_UUID(contid);
                    c.set_SHORT_NAME(name);
                    c.set_LONG_NAME(lname);
					containers.add(c);
				}

			}
			Collections.sort(containers);
			String outFileName = fileName.substring(0, fileName.indexOf(".a")) + "_mod.arxml";
			FileOutputStream outputStream = new FileOutputStream(outFileName);
			outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
			outputStream.write("<AUTOSAR>\n".getBytes());
			for (int j = 0; j < containers.size(); j++) {
				outputStream.write(containers.get(j).toString().getBytes());
			}
			outputStream.write("</AUTOSAR>\n".getBytes());

		} catch (NotVaildAutosarFileException e) {

		} catch (FileNotFoundException e) {
			System.out.println("File Not found");
		} catch (EmptyAutosarFileException e) {

		} catch (Exception e) {
			System.out.println("error");
		}
	}

}