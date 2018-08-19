package org.archid.civ4.techinfo;

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
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;

/**
 * Hello world!
 *
 */
public class TechUtils {

	/** Logging facility */
	static Logger log = Logger.getLogger(TechUtils.class.getName());

	/** Command line parser */
	private String[] args = null;
	private Options options = new Options();
	private CommandLine cmd = null;
	private IPropertyHandler props = PropertyHandler.getInstance();
	
	public TechUtils(String[] args) {
		this.args = args;
		
		OptionGroup actions = new OptionGroup();
		actions.setRequired(true);
		actions.addOption(Option.builder("c").longOpt("col").hasArg(true).argName("X").desc("column (X) to insert").build());
		actions.addOption(Option.builder("r").longOpt("row").hasArg(true).argName("Y").desc("row (Y) to insert").build());
		actions.addOption(Option.builder("e").longOpt("element").numberOfArgs(2).argName("X Y").desc("x and y position of new element - not currently implemented").build());
		actions.addOption(Option.builder("x").longOpt("xlsx").hasArg(false).desc("Create XLSX file").build());

		options.addOption(Option.builder("f").longOpt("file").required().hasArg(true).argName("FILE").desc("Civ4TechInfos.xml path").build());
		options.addOption(Option.builder("o").longOpt("outputDir").hasArg(true).argName("Dir").desc("Directory to create the output in").build());
		options.addOption(Option.builder("n").longOpt("count").hasArg(true).argName("#").desc("number of rows/columns").build());
		options.addOptionGroup(actions);
		options.addOption("h", "help", false, "display usage");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		Logger.getRootLogger().setLevel(Level.INFO);
		
		TechUtils app = new TechUtils(args);
		app.parse();

	}
	
	public void parse() {
		
		CommandLineParser parser = new DefaultParser();
		try {
			cmd = parser.parse(options, args);
			
			if (cmd.hasOption("f"))
				props.setAppProperty(TechExporterPropertyKeys.PROPERTY_KEY_REF_SCHEMA, cmd.getOptionValue("f"));
			if (cmd.hasOption("o"))
				props.setAppProperty(TechExporterPropertyKeys.PROPERTY_KEY_OUTPUT_DIR, cmd.getOptionValue("o"));
			if (cmd.hasOption("n"))
				props.setAppProperty(TechExporterPropertyKeys.PROPERTY_KEY_COUNT, cmd.getOptionValue("n"));

			if (cmd.hasOption("c")) {
				props.setAppProperty(TechExporterPropertyKeys.PROPERTY_KEY_INSERT_COL, cmd.getOptionValue("c"));
				new TechUpdater().addColumn();
			}
			else if (cmd.hasOption("r")) {
				props.setAppProperty(TechExporterPropertyKeys.PROPERTY_KEY_INSERT_ROW, cmd.getOptionValue("r"));
				new TechUpdater().addRow();
			}
			else if (cmd.hasOption("e")) {
				System.out.println("Functionality not implemented yet");
			}
			if (cmd.hasOption("x")) {
				new TechExporter(TechReader.parse()).createXLSX();
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
