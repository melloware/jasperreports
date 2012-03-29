/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2011 Jaspersoft Corporation. All rights reserved.
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
package net.sf.jasperreports.components.sort.actions;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.repo.JasperDesignCache;
import net.sf.jasperreports.repo.JasperDesignReportResource;
import net.sf.jasperreports.web.actions.AbstractAction;
import net.sf.jasperreports.web.commands.CommandStack;
import net.sf.jasperreports.web.commands.CommandTarget;
import net.sf.jasperreports.web.commands.ResetInCacheCommand;

/**
 * @author Narcis Marcu (narcism@users.sourceforge.net)
 * @version $Id: FieldDateComparator.java 4707 2011-10-18 08:58:14Z narcism $
 */
public class SortAction extends AbstractAction 
{
	
	private SortData sortData;

	public SortAction() {
	}

	public SortData getSortData() {
		return sortData;
	}

	public void setSortData(SortData sortData) {
		this.sortData = sortData;
	}

	public void performAction() 
	{
		if (sortData != null) 
		{
			CommandTarget target = getCommandTarget(UUID.fromString(sortData.getUuid()));
			if (target != null)
			{
				JasperDesignCache cache = JasperDesignCache.getInstance(getJasperReportsContext(), getReportContext());

				JasperDesign jasperDesign = cache.getJasperDesign(target.getUri());
				JRDesignDataset dataset = (JRDesignDataset)jasperDesign.getMainDataset();
				
				// obtain command stack
				CommandStack commandStack = getCommandStack();
				
				// execute command
				commandStack.execute(
					new ResetInCacheCommand(
						new SortCommand(getJasperReportsContext(), dataset, sortData),
						getJasperReportsContext(),
						getReportContext(),
						target.getUri()
						)
					);
			}
		}
	}
	
	/**
	 * 
	 */
	public CommandTarget getCommandTarget(UUID uuid)
	{
		JasperDesignCache cache = JasperDesignCache.getInstance(getJasperReportsContext(), getReportContext());

		Map<String, JasperDesignReportResource> cachedResources = cache.getCachedResources();
		Set<String> uris = cachedResources.keySet();
		for (String uri : uris)
		{
			CommandTarget target = new CommandTarget();
			target.setUri(uri);
			return target;
		}
		return null;
	}
}
