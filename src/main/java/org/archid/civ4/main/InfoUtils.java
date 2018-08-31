package org.archid.civ4.main;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.archid.civ4.info.ExporterFactory;
import org.archid.civ4.info.ImporterFactory;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;
import org.archid.civ4.utils.PropertyKeys;

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
		Logger.getRootLogger().setLevel(Level.INFO);
		
		InfoUtils app = new InfoUtils(args);
		app.parse();
	}
	
	private InfoUtils(String[] args) {
		this.args = args;
		
		OptionGroup actions = new OptionGroup();
		actions.setRequired(true);
		actions.addOption(Option.builder("i").longOpt("import").hasArg(true).argName("XLSX").desc("Import XLSX file").build());
		actions.addOption(Option.builder("x").longOpt("export").hasArg(false).desc("Create XLSX file").build());

		options.addOption(Option.builder("f").longOpt("file").required().hasArg(true).argName("FILE").desc("Civ4xxxInfos.xml path").build());
		options.addOption(Option.builder("t").longOpt("type").required().hasArg(true).argName("Info Type").desc("Tech, Building or Unit").build());
		options.addOptionGroup(actions);
		options.addOption("h", "help", false, "display usage");
	}

	private void parse() {		
		CommandLineParser parser = new DefaultParser();
		try {
			EInfos infoType = null;
			cmd = parser.parse(options, args);
			
			if (cmd.hasOption("f"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_INFOS_FILE, cmd.getOptionValue("f"));
			if (cmd.hasOption("t")) {
				if (cmd.getOptionValue("t").equalsIgnoreCase("tech"))
					infoType = EInfos.TECH_INFOS;
				if (cmd.getOptionValue("t").equalsIgnoreCase("era"))
					infoType = EInfos.ERA_INFOS;
				else
					log.error("Processing of type " + cmd.getOptionValue("t") + " is not implemented yet");	
			}

			if (cmd.hasOption("x") && infoType != null) {
				ExporterFactory.getExporter(infoType).createXLSX();
			}	else if (cmd.hasOption("i") && infoType != null) {
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_IMPORT_XLSX, cmd.getOptionValue("i"));
				ImporterFactory.getImporter(infoType).importXLSX();
			}
			
			if (cmd.hasOption("h")) {
				printHelp(options);
			}
			
		} catch (ParseException exp) {
			System.out.println( "Parsing exception: " + exp.getMessage() );
			printHelp(options);
		}
	}
	
	private static void printHelp(final Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("UpdateTechs", options, true);		
	}

}
