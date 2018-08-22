package org.archid.civ4.techinfo;

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
import org.apache.log4j.Logger;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;

public class TechReader {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(TechReader.class.getName());

	private static String filePath;

	private static IPropertyHandler props = PropertyHandler.getInstance();

	public static List<TechInfo> parse() {
		TechReader.filePath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE);
		List<TechInfo> techInfos = new Vector<TechInfo>();

		Pattern patternStartTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECH_TAG_START);
		Pattern patternAsset = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_ASSET_VALUE);
		Pattern patternAdvStartCost = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_ADV_START_COST_VALUE);
		Pattern patternCost = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_COST_VALUE);
		Pattern patternX = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_IGRIDX_VALUE);
		Pattern patternY = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_IGRIDY_VALUE);
		Pattern patternEra = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_ERA_VALUE);
		Pattern patternType = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TYPE_VALUE);
		Pattern patternOrTechPrereq = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_OR_TECH_PREREQ_TAG_START);
		Pattern patternAndTechPrereq = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_AND_TECH_PREREQ_TAG_START);
		Pattern patternEndTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECH_TAG_END);
		try {
			
			BufferedReader reader = getInputFile();

			int gridX = 0;
			int maxGridX = 0; // Used to autosize all the cols
			int gridY = 0;
			int maxGridY = 0; // Used to create all the rows at one go
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
					continue;
				}
				Matcher matcherType = patternType.matcher(line);
				if (matcherType.matches() && bInTech)
				{
					info.setType(matcherType.group(1));
					continue;
				}
				Matcher matcherCost = patternCost.matcher(line);
				if (matcherCost.matches() && bInTech)
				{
					info.setCost(Integer.parseInt(matcherCost.group(1)));
					continue;
				}
				Matcher matcherAdvStartCost = patternAdvStartCost.matcher(line);
				if (matcherAdvStartCost.matches() && bInTech)
				{
					info.setAdvancedStartCost(Integer.parseInt(matcherAdvStartCost.group(1)));
					continue;
				}
				Matcher matcherEra = patternEra.matcher(line);
				if (matcherEra.matches() && bInTech)
				{
					era = matcherEra.group(1);
					info.setEra(era);
					if (!eras.contains(era))
						eras.add(era);
					continue;
				}
				Matcher matcherAsset = patternAsset.matcher(line);
				if (matcherAsset.matches() && bInTech)
				{
					info.setAsset(Integer.parseInt(matcherAsset.group(1)));
					continue;
				}
				Matcher matcherX = patternX.matcher(line);
				if (matcherX.matches() && bInTech)
				{
					gridX = Integer.parseInt(matcherX.group(1));
					info.setGridX(gridX);
					if (gridX > maxGridX) maxGridX = gridX;
					continue;
				}
				Matcher matcherY = patternY.matcher(line);
				if (matcherY.matches() && bInTech)
				{
					gridY = Integer.parseInt(matcherY.group(1));
					info.setGridY(gridY);
					if (gridY > maxGridY) maxGridY = gridY;
					continue;
				}
				Matcher matcherOrTechPrereq = patternOrTechPrereq.matcher(line);
				if (matcherOrTechPrereq.matches() && bInTech)
				{
					setOrPrereqTechs(reader, info);
					continue;
				}
				Matcher matcherAndTechPrereq = patternAndTechPrereq.matcher(line);
				if (matcherAndTechPrereq.matches() && bInTech)
				{
					setAndPrereqTechs(reader, info);
					continue;
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
		log.info("Reading input file: " + filePath);
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
	
	public static String getFileWithNewExtension(String ext) {
		StringBuilder prefix = new StringBuilder(props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_PREFIX, ""));
		if (prefix.length() > 0)
			prefix.append("_");
		String path = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_OUTPUT_DIR, getFileDir());
		return path + prefix.toString() + getFileBaseName() + "." + ext;
	}
	
}
