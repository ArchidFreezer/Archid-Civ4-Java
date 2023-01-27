package org.archid.civ4.main;

import java.io.FileNotFoundException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.archid.civ4.schema.JavaCodeGenerator;
import org.archid.civ4.schema.SchemaParser;
import org.archid.utils.IPropertyHandler;
import org.archid.utils.PropertyHandler;
import org.archid.utils.PropertyKeys;

public class JavaGenerator {

	/** Logging facility */
	static Logger log = Logger.getLogger(JavaGenerator.class.getName());
	
	/** Command line parser */
	private String[] args = null;
	private Options options = new Options();
	private CommandLine cmd = null;
	private IPropertyHandler props = PropertyHandler.getInstance();
	
	/** Schema parser */
	SchemaParser parser = new SchemaParser();
	
	public JavaGenerator(String[] args) {
		this.args = args;
		
		options.addOption(Option.builder("h").longOpt("help").hasArg(false).desc("Display this usage message").build());
		options.addOption(Option.builder("i").longOpt("schemaDir").hasArg(true).argName("Schema Dir").desc("Directory containing the schema file to parse").build());
		options.addOption(Option.builder("I").longOpt("schema").required().hasArg(true).argName("Schema File").desc("Name of schema file to parse").build());
		options.addOption(Option.builder("o").longOpt("output").required().hasArg(true).argName("Output Dir").desc("Directory to create the output in").build());
		options.addOption(Option.builder("s").longOpt("saveProps").hasArg(false).argName("Save Property Values").desc("Save properties on exit").build());
		options.addOption(Option.builder("t").longOpt("type").required().hasArg(true).argName("Info Type").desc("Type of info to process, such as Civ4EventTriggerInfos").build());
	}
	
	public void parse() {
		CommandLineParser cmdParser = new DefaultParser();
		
		try {
			cmd = cmdParser.parse(options, args);
			
			if (cmd.hasOption("h"))
				help();

			// Set the input info first
			if (cmd.hasOption("i"))
				props.setAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA_DIR, cmd.getOptionValue("i"));
			props.setAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA, cmd.getOptionValue("I"));
			props.setAppProperty(PropertyKeys.PROPERTY_KEY_JAVA_OUTPUT_DIR, cmd.getOptionValue("o"));
			
			// Now perform the action
			String schema = props.getAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA_DIR, ".") + "\\" + props.getAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA);
			processSchema(schema, cmd.getOptionValue("t"));
			
			exit(0);
			
			
		} catch (ParseException e) {
			log.error("Failed to parse comand line properties", e);
			help();
		}
	}

	private void processSchema(String schema, String tag) {
		try {
			parser.parse(schema);
			new JavaCodeGenerator(parser).createJavaCode(tag);
		} catch (FileNotFoundException e) {
			log.error("Could not find schema file", e);
		}
	}

	private void help() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("SchemaProcessor", options);
		exit(0);
	}
	
	private void exit(int exitCode) {
		exit(exitCode, cmd.hasOption("s"));
	}

	private void exit(int exitCode, boolean saveProperties) {
		if (saveProperties)	props.save();
		System.exit(exitCode);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		
		JavaGenerator app = new JavaGenerator(args);
		app.parse();

	}
	
}