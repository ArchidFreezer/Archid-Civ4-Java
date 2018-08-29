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
import org.archid.civ4.info.techinfo.TechExporter;
import org.archid.civ4.info.techinfo.TechImporter;
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
	
	public InfoUtils(String[] args) {
		this.args = args;
		
		OptionGroup actions = new OptionGroup();
		actions.setRequired(true);
		actions.addOption(Option.builder("i").longOpt("import").hasArg(true).argName("XLSX").desc("Import XLSX file").build());
		actions.addOption(Option.builder("x").longOpt("export").hasArg(false).desc("Create XLSX file").build());

		options.addOption(Option.builder("f").longOpt("file").required().hasArg(true).argName("FILE").desc("Civ4xxxInfos.xml path").build());
		options.addOption(Option.builder("o").longOpt("outputDir").hasArg(true).argName("Dir").desc("Directory to create the output in").build());
		options.addOption(Option.builder("p").longOpt("prefix").hasArg(true).argName("Prefix").desc("Prefix of output file").build());
		options.addOptionGroup(actions);
		options.addOption("h", "help", false, "display usage");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		Logger.getRootLogger().setLevel(Level.INFO);
		
		InfoUtils app = new InfoUtils(args);
		app.parse();

	}
	
	public void parse() {
		
		CommandLineParser parser = new DefaultParser();
		try {
			cmd = parser.parse(options, args);
			
			if (cmd.hasOption("f"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_INFOS_FILE, cmd.getOptionValue("f"));
			if (cmd.hasOption("p"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_PREFIX, cmd.getOptionValue("p"));

			if (cmd.hasOption("x")) {
				if (cmd.hasOption("o")) {
					props.setAppProperty(PropertyKeys.PROPERTY_KEY_OUTPUT_DIR, cmd.getOptionValue("o"));
					new TechExporter().createXLSX();
				} else {
					log.error("An output dir must be provided using the 'o' argument to export to xlsx");
				}
			}	else if (cmd.hasOption("i")) {
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_IMPORT_XLSX, cmd.getOptionValue("i"));
				new TechImporter().importXLSX();					
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
