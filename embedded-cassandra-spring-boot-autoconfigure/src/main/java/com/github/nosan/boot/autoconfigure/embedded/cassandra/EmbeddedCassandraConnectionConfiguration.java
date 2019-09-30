/*
 * Copyright 2019 the original author or authors.
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

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.github.nosan.embedded.cassandra.api.Cassandra;
import com.github.nosan.embedded.cassandra.api.connection.CassandraConnection;
import com.github.nosan.embedded.cassandra.api.connection.CassandraConnectionFactory;
import com.github.nosan.embedded.cassandra.api.connection.DefaultCassandraConnectionFactory;

/**
 * {@link Configuration @Configuration} for an embedded {@link CassandraConnection}.
 *
 * @author Dmytro Nosan
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnSingleCandidate(Cassandra.class)
@Conditional(OnCassandraAnyClientCondition.class)
class EmbeddedCassandraConnectionConfiguration {

	@Lazy
	@Bean(destroyMethod = "close")
	@ConditionalOnMissingBean
	CassandraConnection embeddedCassandraConnection(CassandraConnectionFactory embeddedCassandraConnectionFactory,
			Cassandra embeddedCassandra) {
		return embeddedCassandraConnectionFactory.create(embeddedCassandra);
	}

	@Bean
	@ConditionalOnMissingBean
	CassandraConnectionFactory embeddedCassandraConnectionFactory() {
		return new DefaultCassandraConnectionFactory();
	}

}
