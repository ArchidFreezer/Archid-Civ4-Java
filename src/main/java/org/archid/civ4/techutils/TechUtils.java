package org.archid.civ4.techutils;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 *
 */
public class TechUtils {

	public static void main(String[] args) {
		OptionGroup actions = new OptionGroup();
		actions.setRequired(true);
		actions.addOption(Option.builder("c").longOpt("col").hasArg(true).argName("X").desc("column (X) to insert").build());
		actions.addOption(Option.builder("r").longOpt("row").hasArg(true).argName("Y").desc("row (Y) to insert").build());
		actions.addOption(Option.builder("e").longOpt("element").numberOfArgs(2).argName("X Y").desc("x and y position of new element - not currently implemented").build());
		actions.addOption(Option.builder("x").longOpt("xlsx").hasArg(false).desc("Create XLSX file").build());

		Options options = new Options();
		options.addOption(Option.builder("f").longOpt("file").required().hasArg(true).argName("FILE").desc("Civ4TechInfos.xml path").build());
		options.addOption(Option.builder("n").longOpt("count").hasArg(true).argName("#").desc("number of rows/columns").build());
		options.addOptionGroup(actions);
		options.addOption("h", "help", false, "display usage");
		
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			
			TechUpdater updater = new TechUpdater(cmd.getOptionValue("f"));
			
			int count = 1;
			if (cmd.hasOption("n")) {
				count = Integer.parseInt(cmd.getOptionValue("n"));
			}
			if (cmd.hasOption("c")) {
				updater.addColumn(Integer.parseInt(cmd.getOptionValue("c")), count);
			}
			else if (cmd.hasOption("r")) {
				updater.addRow(Integer.parseInt(cmd.getOptionValue("r")), count);
			}
			else if (cmd.hasOption("e")) {
				System.out.println("Functionality not implemented yet");
			}
			if (cmd.hasOption("x")) {
				TechExporter exporter = new TechExporter(TechReader.parse(cmd.getOptionValue("f")));
				exporter.createXLSX();
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
