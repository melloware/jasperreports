/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2013 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.export.ooxml;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.export.DocxExporterConfiguration;


/**
 * @deprecated Replaced by {@link DocxExporterConfiguration}.
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public class JRDocxExporterParameter extends JRExporterParameter
{


	/**
	 *
	 */
	protected JRDocxExporterParameter(String name)
	{
		super(name);
	}


	/**
	 * @deprecated Replaced by {@link DocxExporterConfiguration#isFramesAsNestedTables()}.
	 */
	public static final JRDocxExporterParameter FRAMES_AS_NESTED_TABLES = new JRDocxExporterParameter("Export Frames as Nested Tables");
	

	/**
	 * @deprecated Replaced by {@link DocxExporterConfiguration#PROPERTY_FRAMES_AS_NESTED_TABLES}.
	 */
	public static final String PROPERTY_FRAMES_AS_NESTED_TABLES = DocxExporterConfiguration.PROPERTY_FRAMES_AS_NESTED_TABLES;
	

	/**
	 * @deprecated Replaced by {@link DocxExporterConfiguration#isFlexibleRowHeight()}.
	 */
	public static final JRDocxExporterParameter FLEXIBLE_ROW_HEIGHT = new JRDocxExporterParameter("Flexible Row Height");
	

	/**
	 * @deprecated Replaced by {@link DocxExporterConfiguration#PROPERTY_FLEXIBLE_ROW_HEIGHT}.
	 */
	public static final String PROPERTY_FLEXIBLE_ROW_HEIGHT = DocxExporterConfiguration.PROPERTY_FLEXIBLE_ROW_HEIGHT;
	

}