/*
 * $Id$
 * 
 * Created: [Apr 6, 2004]
 *
 * Copyright (c) 2004, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 	o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * 	o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 	o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.model.property;

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.util.UtcOffsetFormat;

/**
 * Defines a TZOFFSETFROM iCalendar component property.
 *
 * @author benf
 */
public class TzOffsetFrom extends Property {

    private long offset;

    /**
     * @param aValue
     *            a value string for this component
     */
    public TzOffsetFrom(final String aValue) {
        this(UtcOffsetFormat.getInstance().parse(aValue));
    }

    /**
     * @param aList
     *            a list of parameters for this component
     * @param aValue
     *            a value string for this component
     */
    public TzOffsetFrom(final ParameterList aList, final String aValue) {
        this(aList, UtcOffsetFormat.getInstance().parse(aValue));
    }

    /**
     * @param anOffset
     *            a timezone offset in milliseconds
     */
    public TzOffsetFrom(final long anOffset) {
        super(TZOFFSETFROM);

        offset = anOffset;
    }

    /**
     * @param aList
     *            a list of parameters for this component
     * @param anOffset
     *            a timezone offset in milliseconds
     */
    public TzOffsetFrom(final ParameterList aList, final long anOffset) {
        super(TZOFFSETFROM, aList);

        offset = anOffset;
    }

    /**
     * @return Returns the offset.
     */
    public final long getOffset() {
        return offset;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.fortuna.ical4j.model.Property#getValue()
     */
    public String getValue() {
        return UtcOffsetFormat.getInstance().format(getOffset());
    }
}