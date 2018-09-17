package org.archid.civ4.info.bonusclass;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface IBonusClassWorkbook extends IInfoWorkbook {

	public static final String SHEETNAME_LIST = "BonusClassList";
	
	public enum SheetHeaders {
		TYPE, UNIQUE;
		
		/**
		 * The value returned is in mixed case and better suited for the display of the value.
		 * 
		 * @return Mixed case representation of the value
		 */
		@Override
		public String toString() {
			return StringUtils.startCaseSpace(this.name(), '_');
		}
		
	}
}
