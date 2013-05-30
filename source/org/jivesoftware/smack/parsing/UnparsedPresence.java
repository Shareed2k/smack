/**
 * $RCSfile$
 * $Revision$
 * $Date$
 *
 * Copyright 2013 Florian Schmaus.
 *
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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

package org.jivesoftware.smack.parsing;

import org.jivesoftware.smack.packet.Presence;

/**
 * Representation of an unparsed IQ stanza.
 * 
 * @author Florian Schmaus
 *
 */
public class UnparsedPresence extends Presence {
    private String content;
    private Exception e;
    
    public UnparsedPresence(Type type) {
        super(type);
    }
    
    public UnparsedPresence(final String content, final Exception e) {
        super(Presence.Type.error);
        this.content = content;
        this.e = e;
    }

    /**
     * 
     * @return the exception that caused the parser to fail
     */
    public Exception getException() {
        return e;
    }

    /**
     * Retrieve the raw stanza data
     * 
     * @return
     */
    public String getContent() {
        return content;
    }
}
