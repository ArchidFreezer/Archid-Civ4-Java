package org.archid.civ4.main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.archid.civ4.info.ExporterFactory;
import org.archid.civ4.info.ImporterFactory;
import org.archid.civ4.info.InfosFactory;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.utils.IPropertyHandler;
import org.archid.utils.PropertyHandler;
import org.archid.utils.PropertyKeys;

/**
 * Hello world!
 *
 */
public class InfoUtils {

	/** Logging facility */
	static Logger log = Logger.getLogger(InfoUtils.class.getName());

	/** Command line parser */
	private String[] args = null;
	private Options options = new Options();
	private CommandLine cmd = null;
	private IPropertyHandler props = PropertyHandler.getInstance();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		
		InfoUtils app = new InfoUtils(args);
		app.parse();
	}
	
	private InfoUtils(String[] args) {
		this.args = args;
		
		OptionGroup actions = new OptionGroup();
		actions.setRequired(true);
		actions.addOption(Option.builder("i").longOpt("import").hasArg(false).desc("Import from XLSX file").build());
		actions.addOption(Option.builder("e").longOpt("export").hasArg(false).desc("Export to XLSX file").build());
		actions.addOption(Option.builder("h").longOpt("help").hasArg(false).desc("Display this usage message").build());
		options.addOptionGroup(actions);

		options.addOption(Option.builder("f").longOpt("file").required().hasArg(true).argName("XML").desc("Path to Civ4xxxInfos.xml file to process. Filename must be provided if it is non standard").build());
		options.addOption(Option.builder("o").longOpt("output").hasArg(true).argName("Output Dir").desc("Directory to create output files").build());
		options.addOption(Option.builder("p").longOpt("prefix").hasArg(true).argName("Prefix").desc("Prefix to new output file").build());
		options.addOption(Option.builder("t").longOpt("type").required().hasArg(true).argName("Info Type").desc("Valid values are: Era, Tech & Unit").build());
		options.addOption(Option.builder("x").longOpt("xlsx").hasArg(true).argName("XLSX").desc("XLSX file to use, required for import action").build());
	}

	private void parse() {		
		CommandLineParser parser = new DefaultParser();
		try {
			EInfos infoType = null;
			cmd = parser.parse(options, args);
			
			if (cmd.hasOption("o"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_OUTPUT_DIR, cmd.getOptionValue("o"));
			else
				props.removeAppProperty(PropertyKeys.PROPERTY_KEY_OUTPUT_DIR);
			if (cmd.hasOption("p"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_FILE_PREFIX, cmd.getOptionValue("p"));
			if (cmd.hasOption("t")) {
				if (cmd.getOptionValue("t").equalsIgnoreCase("building"))
					infoType = EInfos.BUILDING_INFOS;
				else if (cmd.getOptionValue("t").equalsIgnoreCase("buildingclass"))
					infoType = EInfos.BUILDING_CLASS_INFOS;
				else if (cmd.getOptionValue("t").equalsIgnoreCase("era"))
					infoType = EInfos.ERA_INFOS;
				else if (cmd.getOptionValue("t").equalsIgnoreCase("tech"))
					infoType = EInfos.TECH_INFOS;
				else if (cmd.getOptionValue("t").equalsIgnoreCase("unit"))
					infoType = EInfos.UNIT_INFOS;
				else
					log.error("Processing of type " + cmd.getOptionValue("t") + " is not implemented yet");	
			}
			if (cmd.hasOption("f")) {
				// If this is a folder then append the OOB filename for the info type
				String pathVal = cmd.getOptionValue("f");
				Path file = Paths.get(pathVal);
				if (!Files.exists(file))
					throw new ParseException("Path contained in 'f' argument does not exist");
				else if (Files.isDirectory(file))
					pathVal = Paths.get(pathVal, InfosFactory.getDefaultInfoFilename(infoType)).toString();
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_FILE_INFOS, pathVal);
			}
			if (cmd.hasOption("x")) {
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_FILE_XSLX, cmd.getOptionValue("x"));
			}

			if (cmd.hasOption("e") && infoType != null) {
				ExporterFactory.getExporter(infoType).createXLSX();
			}	else if (cmd.hasOption("i") && infoType != null) {
				if (cmd.hasOption("x")) {
					ImporterFactory.getImporter(infoType).importXLSX();
				} else {
					throw new ParseException("xlsx file to process not provided");
				}
			}
			
			if (cmd.hasOption("h")) {
				printHelp();
			}
			
		} catch (ParseException e) {
			log.error(e.getMessage() + System.lineSeparator());
			printHelp();
		}
	}
	
	private void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(120, "UpdateTechs", "", options, "", true);		
	}

}
