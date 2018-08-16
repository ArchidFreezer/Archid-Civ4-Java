package org.archid.civ4.techinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class TechUpdater {
	
	private static String newline = System.getProperty("line.separator");
	
	private String filePath;
	
	public TechUpdater(String FilePath) {
		this.filePath = FilePath;
	}
	
	public void addColumn(int col, int count) {
		Pattern pattern = Pattern.compile("\\s*?<iGridX>(\\d+).*");
		try {
			BufferedReader reader = getInputFile();
			BufferedWriter writer = getOutputFile();
			String line = "";
			while((line = reader.readLine()) != null)
			{
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches())
				{
					int currX = Integer.parseInt(matcher.group(1));
					if (currX >= col) {
						line = line.replaceAll(Integer.toString(currX), Integer.toString(currX + count));
					}
				}
				writer.write(line + newline);
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addRow(int row, int count) {
		Pattern pattern = Pattern.compile("\\s*?<iGridY>(\\d+).*");
		try {
			BufferedReader reader = getInputFile();
			BufferedWriter writer = getOutputFile();
			String line = "";
			while((line = reader.readLine()) != null)
			{
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches())
				{
					int currY = Integer.parseInt(matcher.group(1));
					if (currY >= row) {
						line = line.replaceAll(Integer.toString(currY), Integer.toString(currY + count));
					}
				}
				writer.write(line + newline);
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addElement(int col, int row) {
		Pattern patternX = Pattern.compile("\\s*?<iGridX>(\\d+).*");
		Pattern patternY = Pattern.compile("\\s*?<iGridY>(\\d+).*");
		try {
			BufferedReader reader = getInputFile();
			BufferedWriter writer = getOutputFile();
			String line = "";
			boolean checkedBoth = false;
			boolean foundX = false;
			int currX = 0;
			String lineX = "";
			while((line = reader.readLine()) != null)
			{
				Matcher matcherX = patternX.matcher(line);
				if (matcherX.matches())
				{
					currX = Integer.parseInt(matcherX.group(1));
					if (currX >= col) {
						lineX = line.replaceAll(Integer.toString(currX), Integer.toString(++currX));
						foundX = true;
					} else {
						lineX = line;
					}
				}
				if (foundX) {
					checkedBoth = true;
					Matcher matcherY = patternY.matcher(line);
					if (matcherY.matches())
					{
						int currY = Integer.parseInt(matcherY.group(1));
						if (currY >= row) {
							line = line.replaceAll(Integer.toString(currY), Integer.toString(++currY));
						}
					}
				}
				if (checkedBoth)
				{
					writer.write(lineX + newline);
					writer.write(line + newline);
					foundX = false;
					checkedBoth = false;
				} else if (!foundX) {
					writer.write(line + newline);
				}
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private BufferedReader  getInputFile() throws IOException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String copyFile = filePath + "." + sdf.format(cal.getTime());

		File source = new File(copyFile);
		FileUtils.moveFile(new File(filePath), source);
		FileReader reader = new FileReader(source);
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}
	
	private BufferedWriter getOutputFile() throws IOException {
		File file = new File(filePath);
		FileUtils.touch(file);
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		return bufferedWriter;
		
	}
	
}
