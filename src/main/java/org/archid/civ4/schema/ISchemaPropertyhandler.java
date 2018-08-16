/**
 * 
 */
package org.archid.civ4.schema;

import java.util.Set;

import org.archid.civ4.utils.IPropertyHandler;

/**
 * @author Jim
 *
 */
public interface ISchemaPropertyhandler extends IPropertyHandler {
	
	Set<String> getIgnores();
	Set<String> getManuals();

}
