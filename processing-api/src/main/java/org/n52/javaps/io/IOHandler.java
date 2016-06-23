/*
 * Copyright 2016 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.javaps.io;

import java.util.Set;

import org.n52.javaps.io.data.IComplexData;
import org.n52.javaps.ogc.wps.Format;

public interface IOHandler {

    String DEFAULT_ENCODING = "UTF-8";

    String ENCODING_BASE64 = "base64";

    // String DEFAULT_MIMETYPE = "text/xml";

    String MIME_TYPE_ZIPPED_SHP = "application/x-zipped-shp";


    boolean isSupportedFormat(Format format);

    boolean isSupportedBinding(Class<? extends IComplexData> binding);

    Set<Format> getSupportedFormats();

    Set<Class<? extends IComplexData>> getSupportedBindings();

}