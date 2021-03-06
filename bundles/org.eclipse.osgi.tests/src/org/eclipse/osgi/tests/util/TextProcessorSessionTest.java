/*******************************************************************************
 * Copyright (c) 2011, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.osgi.tests.util;

import org.eclipse.core.tests.session.*;
import org.eclipse.core.tests.session.SetupManager.SetupException;
import org.eclipse.osgi.tests.OSGiTest;

public class TextProcessorSessionTest extends ConfigurationSessionTestSuite {
	private String lang = null;

	/**
	 * Create a session test for the given class.  
	 * @param pluginId tests plugin id
	 * @param clazz the test class to run
	 * @param language the language to run the tests under (the -nl parameter value)
	 */
	public TextProcessorSessionTest(String pluginId, Class clazz, String language) {
		super(pluginId, clazz);
		lang = language;
		String[] ids = ConfigurationSessionTestSuite.MINIMAL_BUNDLE_SET;
		for (int i = 0; i < ids.length; i++)
			addBundle(ids[i]);
		addBundle(OSGiTest.PI_OSGI_TESTS);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.tests.session.SessionTestSuite#newSetup()
	 */
	protected Setup newSetup() throws SetupException {
		Setup base = super.newSetup();
		// the base implementation will have set this to the host configuration
		base.setEclipseArgument("nl", lang); // Setup.NL is private
		return base;
	}

}
