/*
 * Copyright 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.mapping.tree;

import net.fabricmc.mapping.reader.v2.TinyMetadata;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class EmptyTinyTree implements TinyTree {
	static final class Metadata implements TinyMetadata {
		@Override
		public int getMajorVersion() {
			return 2;
		}

		@Override
		public int getMinorVersion() {
			return 0;
		}

		@Override
		public List<String> getNamespaces() {
			return Collections.emptyList();
		}

		@Override
		public Map<String, @Nullable String> getProperties() {
			return Collections.emptyMap();
		}

		@Override
		public int index(String namespace) throws IllegalArgumentException {
			throw new IllegalArgumentException("No namespace \"" + namespace + "\"");
		}
	}

	@Override
	public TinyMetadata getMetadata() {
		return TinyMappingFactory.EMPTY_METADATA;
	}

	@Override
	public Map<String, ClassDef> getDefaultNamespaceClassMap() {
		return Collections.emptyMap();
	}

	@Override
	public Collection<ClassDef> getClasses() {
		return Collections.emptyList();
	}
}
