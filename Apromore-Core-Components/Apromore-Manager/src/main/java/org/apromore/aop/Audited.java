/*-
 * #%L
 * This file is part of "Apromore Core".
 *
 * Copyright (C) 2013 - 2017 Queensland University of Technology.
 * %%
 * Copyright (C) 2018 - 2020 The University of Melbourne.
 * %%
 *
 * "Apromore" is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * "Apromore" is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

package org.apromore.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a method to audit it using {@link org.apromore.aop.AuditAspect}.
 * Here is a code sample for method audit :
 * <pre>
 * <code>
 * &#064;(message = "save(#{args[0]}, #{args[1]}): #{returned}")
 *  public int save(String arg1, String arg2) { ... }
 * </code>
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD })
public @interface Audited {

    /**
     * <p>
     * Available variables
     * </p>
     * <ul>
     * <li><code>args</code></li>
     * <li><code>invokedObject</code></li>
     * <li><code>throwned</code></li>
     * <li><code>returned</code></li>
     * </ul>
     * <p>
     * Sample :<code>"save(#{args[0]}, #{args[1]}): #{returned}"</code>
     * </p>
     */
    String message() default "";
}
