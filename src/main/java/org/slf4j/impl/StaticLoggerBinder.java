/**
 * Copyright 2016, RadiantBlue Technologies, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * SLF4J Logger Binder implementation. This will establish the hooks to the PiazzaLogger implementation.
 * 
 * @author Patrick.Doody
 *
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

	public static final StaticLoggerBinder getSingleton() {
		return SINGLETON;
	}

	/**
	 * Declaring the version of the SLF4J API this implementation is compiled
	 * against. The value of this field is modified with each major release.
	 */
	public static String REQUESTED_API_VERSION = "1.7";

	private static final String factoryClassName = PiazzaLoggerFactory.class.getName();

	/**
	 * From SLF4J Implementation - The ILoggerFactory instance returned by the
	 * {@link #getLoggerFactory} method should always be the same object
	 */
	private final ILoggerFactory loggerFactory;

	public String getLoggerFactoryClassStr() {
		return factoryClassName;
	}

	public ILoggerFactory getLoggerFactory() {
		return loggerFactory;
	}

	private StaticLoggerBinder() {
		loggerFactory = new PiazzaLoggerFactory();
	}
}
