package org.archid.civ4.techutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;

public class TechReader {
	
	private static String filePath;

	public static List<TechInfo> parse(String filePath) {
		TechReader.filePath = filePath;
		List<TechInfo> techInfos = new Vector<TechInfo>();

		Pattern patternStartTag = Pattern.compile("\\s*?<TechInfo>.*");
		Pattern patternX = Pattern.compile("\\s*?<iGridX>(\\d+).*");
		Pattern patternY = Pattern.compile("\\s*?<iGridY>(\\d+).*");
		Pattern patternEra = Pattern.compile("\\s*?<Era>([a-zA-Z_]+).*");
		Pattern patternType = Pattern.compile("\\s*?<Type>([a-zA-Z_]+).*");
		Pattern patternOrTechPrereq = Pattern.compile("\\s*?<OrPreReqs>.*");
		Pattern patternAndTechPrereq = Pattern.compile("\\s*?<AndPreReqs>.*");
		Pattern patternEndTag = Pattern.compile("\\s*?</TechInfo>.*");
		try {
			
			BufferedReader reader = getInputFile();

			int gridX = 0;
			int maxGridX = 0; // Used to autosize all the cols
			int gridY = 0;
			int maxGridY = 0; // Used to create all the rows at one go
			String type = "";
			String era = "";
			
			List<String> eras = new ArrayList<String>();

			TechInfo info = null;
			boolean bInTech = false;
			String line = "";
			while((line = reader.readLine()) != null)
			{
				Matcher matcherStartTag = patternStartTag.matcher(line);
				if (matcherStartTag.matches() && !bInTech)
				{
					info = new TechInfo();
					bInTech = true;
				}
				Matcher matcherType = patternType.matcher(line);
				if (matcherType.matches() && bInTech)
				{
					type = matcherType.group(1);
					info.setType(type);
				}
				Matcher matcherEra = patternEra.matcher(line);
				if (matcherEra.matches() && bInTech)
				{
					era = matcherEra.group(1);
					info.setEra(era);
					if (!eras.contains(era))
						eras.add(era);
				}
				Matcher matcherX = patternX.matcher(line);
				if (matcherX.matches() && bInTech)
				{
					gridX = Integer.parseInt(matcherX.group(1));
					info.setGridX(gridX);
					if (gridX > maxGridX) maxGridX = gridX;
				}
				Matcher matcherY = patternY.matcher(line);
				if (matcherY.matches() && bInTech)
				{
					gridY = Integer.parseInt(matcherY.group(1));
					info.setGridY(gridY);
					if (gridY > maxGridY) maxGridY = gridY;
				}
				Matcher matcherOrTechPrereq = patternOrTechPrereq.matcher(line);
				if (matcherOrTechPrereq.matches() && bInTech)
				{
					setOrPrereqTechs(reader, info);
				}
				Matcher matcherAndTechPrereq = patternAndTechPrereq.matcher(line);
				if (matcherAndTechPrereq.matches() && bInTech)
				{
					setAndPrereqTechs(reader, info);
				}
				Matcher matcherEndTag = patternEndTag.matcher(line);
				if (matcherEndTag.matches() && bInTech)
				{
					techInfos.add(info);
					bInTech = false;
				}
			}
			reader.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return techInfos;
	}
	
	private static void setOrPrereqTechs(BufferedReader reader, TechInfo info) throws IOException {
		Pattern patternTag = Pattern.compile("\\s*?<PrereqTech>([a-zA-Z_]+).*");
		Pattern patternEnd = Pattern.compile("\\s*?</OrPreReqs>.*");
		boolean bFinished = false;
		String line = "";
		while(!bFinished && (line = reader.readLine()) != null)
		{
			Matcher matcherTag = patternTag.matcher(line);
			if (matcherTag.matches())
			{
				info.addOrTechPrereq(matcherTag.group(1));
			}
			Matcher matcherEnd = patternEnd.matcher(line);
			if (matcherEnd.matches())
			{
				bFinished = true;
			}
		}		
	}

	private static void setAndPrereqTechs(BufferedReader reader, TechInfo info) throws IOException {
		Pattern patternTag = Pattern.compile("\\s*?<PrereqTech>([a-zA-Z_]+).*");
		Pattern patternEnd = Pattern.compile("\\s*?</AndPreReqs>.*");
		boolean bFinished = false;
		String line = "";
		while(!bFinished && (line = reader.readLine()) != null)
		{
			Matcher matcherTag = patternTag.matcher(line);
			if (matcherTag.matches())
			{
				info.addAndTechPrereq(matcherTag.group(1));
			}
			Matcher matcherEnd = patternEnd.matcher(line);
			if (matcherEnd.matches())
			{
				bFinished = true;
			}
		}		
	}

	private static BufferedReader  getInputFile() throws IOException {
		FileReader reader = new FileReader(new File(filePath));
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}
	
	public static String getFileDir() {
		return FilenameUtils.getFullPath(filePath);
	}
	
	public static String getFileBaseName() {
		return FilenameUtils.getBaseName(filePath);
	}
	
	public static String getFilePathWithNewExtension(String ext) {
		return getFileDir() + getFileBaseName() + "." + ext;
	}
	
}
