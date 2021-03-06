/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nosan.boot.autoconfigure.embedded.cassandra;

import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import com.github.nosan.embedded.cassandra.Cassandra;

/**
 * Configuration properties for an embedded {@link Cassandra}.
 *
 * @author Dmytro Nosan
 * @since 4.0.0
 */
@ConfigurationProperties(prefix = "cassandra.embedded")
public class EmbeddedCassandraProperties {

	/**
	 * Cassandra environment variables.
	 */
	private final Map<String, String> environmentVariables = new LinkedHashMap<>();

	/**
	 * Cassandra native Java Virtual Machine (JVM) Options.
	 */
	private final List<String> jvmOptions = new ArrayList<>();

	/**
	 * Cassandra native Java Virtual Machine (JVM) system parameters.
	 */
	private final Map<String, String> systemProperties = new LinkedHashMap<>();

	/**
	 * Config properties, that should be merged with properties from cassandra.yaml.
	 */
	private final Map<String, Object> configProperties = new LinkedHashMap<>();

	/**
	 * Additional resources, that should be copied into the working directory.
	 */
	private final Map<String, Resource> workingDirectoryResources = new LinkedHashMap<>();

	/**
	 * Sets if the created Cassandra should have a shutdown hook registered.
	 */
	private Boolean registerShutdownHook;

	/**
	 * Logger name, that consumes Cassandra STDOUT and STDERR outputs.
	 */
	private String logger;

	/**
	 * Startup timeout.
	 */
	private Duration startupTimeout;

	/**
	 * Cassandra instance name.
	 */
	private String name;

	/**
	 * Cassandra version.
	 */
	private String version;

	/**
	 * Cassandra working directory.
	 */
	private Path workingDirectory;

	/**
	 * Cassandra config file.
	 */
	private Resource configFile;

	public Map<String, String> getEnvironmentVariables() {
		return this.environmentVariables;
	}

	public List<String> getJvmOptions() {
		return this.jvmOptions;
	}

	public Map<String, String> getSystemProperties() {
		return this.systemProperties;
	}

	public Map<String, Object> getConfigProperties() {
		return this.configProperties;
	}

	public Boolean getRegisterShutdownHook() {
		return this.registerShutdownHook;
	}

	public void setRegisterShutdownHook(Boolean registerShutdownHook) {
		this.registerShutdownHook = registerShutdownHook;
	}

	public String getLogger() {
		return this.logger;
	}

	public void setLogger(String logger) {
		this.logger = logger;
	}

	public Duration getStartupTimeout() {
		return this.startupTimeout;
	}

	public void setStartupTimeout(Duration startupTimeout) {
		this.startupTimeout = startupTimeout;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Path getWorkingDirectory() {
		return this.workingDirectory;
	}

	public void setWorkingDirectory(Path workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	public Resource getConfigFile() {
		return this.configFile;
	}

	public void setConfigFile(Resource configFile) {
		this.configFile = configFile;
	}

	public Map<String, Resource> getWorkingDirectoryResources() {
		return this.workingDirectoryResources;
	}

}
