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
package org.n52.javaps.algorithm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.n52.javaps.commons.WPSConfig;

/**
 *
 * @author tkunicki
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface Algorithm {
    String identifier() default "";

    String title() default "";

    String abstrakt() default ""; // 'abstract' is java reserved keyword

    String version();

    boolean storeSupported() default true;

    boolean statusSupported() default true;

    String outputTransmissionMode() default WPSConfig.OUTPUT_TRANSMISSION_VALUE;// TODO
                                                                                // use
                                                                                // WPS200Constants

    String jobControlOption() default WPSConfig.JOB_CONTROL_OPTION_SYNC_EXECUTE;// TODO
                                                                                // use
                                                                                // WPS200Constants
}
