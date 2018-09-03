package org.archid.civ4.main;

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

		options.addOption(Option.builder("f").longOpt("file").required().hasArg(true).argName("XML").desc("Civ4xxxInfos.xml file to process").build());
		options.addOption(Option.builder("o").longOpt("output").hasArg(true).argName("Output Dir").desc("Directory to create output files").build());
		options.addOption(Option.builder("p").longOpt("prefix").hasArg(true).argName("Prefix").desc("Prefix to new output file").build());
		options.addOption(Option.builder("t").longOpt("type").required().hasArg(true).argName("Info Type").desc("Valid values are: Tech & Era").build());
		options.addOption(Option.builder("x").longOpt("xlsx").hasArg(true).argName("XLSX").desc("XLSX file to use, required for import action").build());
	}

	private void parse() {		
		CommandLineParser parser = new DefaultParser();
		try {
			EInfos infoType = null;
			cmd = parser.parse(options, args);
			
			if (cmd.hasOption("f"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_FILE_INFOS, cmd.getOptionValue("f"));
			if (cmd.hasOption("o"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_OUTPUT_DIR, cmd.getOptionValue("o"));
			else
				props.removeAppProperty(PropertyKeys.PROPERTY_KEY_OUTPUT_DIR);
			if (cmd.hasOption("p"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_FILE_PREFIX, cmd.getOptionValue("p"));
			if (cmd.hasOption("t")) {
				if (cmd.getOptionValue("t").equalsIgnoreCase("tech"))
					infoType = EInfos.TECH_INFOS;
				else if (cmd.getOptionValue("t").equalsIgnoreCase("era"))
					infoType = EInfos.ERA_INFOS;
				else
					log.error("Processing of type " + cmd.getOptionValue("t") + " is not implemented yet");	
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
