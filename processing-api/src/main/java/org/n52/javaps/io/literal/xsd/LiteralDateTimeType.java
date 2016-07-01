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
package org.n52.javaps.io.literal.xsd;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.n52.iceland.exception.ows.InvalidParameterValueException;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.ogc.ows.OwsCode;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class LiteralDateTimeType extends AbstractXSDLiteralType<LocalDateTime> {

    private static final long serialVersionUID = 4633193913270532243L;

    @Override
    public String getName() {
        return DATE_TIME;
    }

    @Override
    public LocalDateTime parse(OwsCode name, String value) throws OwsExceptionReport {
        try {
            return LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(value));
        } catch (DateTimeException ex) {
            throw new InvalidParameterValueException(name.getValue(), value).causedBy(ex);
        }
    }

    @Override
    public Class<LocalDateTime> getPayloadType() {
        return LocalDateTime.class;
    }

    @Override
    public String generate(OwsCode name, LocalDateTime value) throws OwsExceptionReport {
        return value.atOffset(ZoneOffset.UTC).toString();
    }

}