/*
 * Copyright 1999-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cocoon.forms.transformation;

import org.apache.cocoon.xml.AbstractXMLPipe;
import org.apache.cocoon.xml.SaxBuffer;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

import java.util.LinkedList;

/**
 * Base class for XMLPipe's. Allows the structure of the source code of
 * the XMLPipe to match the structure of the data being transformed.
 *
 * @version $Id: EffectPipe.java 371545 2006-01-23 14:39:28Z jbq $
 */
public class EffectPipe extends AbstractXMLPipe {

    /**
     * Handler interface. Accepts SAX events, can return other handler
     * to replace self for further events.
     */
    protected interface Handler {
        public Handler startDocument()
        throws SAXException;

        public void endDocument()
        throws SAXException;

        public void startPrefixMapping(String prefix, String uri)
        throws SAXException;

        public void endPrefixMapping(String prefix)
        throws SAXException;

        public Handler startElement(String uri, String loc, String raw, Attributes attrs)
        throws SAXException;

        /**
         * Called before startElement, handler can decide what other handler should process
         * next startElement.
         */
        public Handler nestedElement(String uri, String loc, String raw, Attributes attrs)
        throws SAXException;

        public void endElement(String uri, String loc, String raw)
        throws SAXException;

        public Handler characters(char ch[], int start, int length)
        throws SAXException;

        public Handler ignorableWhitespace(char ch[], int start, int length)
        throws SAXException;

        public Handler processingInstruction(String target, String data)
        throws SAXException;

        public Handler skippedEntity(String name)
        throws SAXException;

        public Handler startDTD(String name, String publicId, String systemId)
        throws SAXException;

        public Handler endDTD()
        throws SAXException;

        public Handler startEntity(String name)
        throws SAXException;

        public Handler endEntity(String name)
        throws SAXException;

        public Handler startCDATA()
        throws SAXException;

        public Handler endCDATA()
        throws SAXException;

        public Handler comment(char c[], int start, int len)
        throws SAXException;
    }

    /**
     * Ignores all events
     */
    protected class NullHandler implements Handler {
        public Handler startDocument() throws SAXException {
            return this;
        }

        public void endDocument() throws SAXException {
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {
        }

        public void endPrefixMapping(String prefix) throws SAXException {
        }

        public Handler nestedElement(String uri, String loc, String raw, Attributes attrs) throws SAXException {
            return this;
        }

        public Handler startElement(String uri, String loc, String raw, Attributes attrs) throws SAXException {
            return this;
        }

        public void endElement(String uri, String loc, String raw) throws SAXException {
        }

        public Handler characters(char ch[], int start, int length) throws SAXException {
            return this;
        }

        public Handler ignorableWhitespace(char ch[], int start, int length) throws SAXException {
            return this;
        }

        public Handler processingInstruction(String target, String data) throws SAXException {
            return this;
        }

        public Handler skippedEntity(String name) throws SAXException {
            return this;
        }

        public Handler startDTD(String name, String publicId, String systemId) throws SAXException {
            return this;
        }

        public Handler endDTD() throws SAXException {
            return this;
        }

        public Handler startEntity(String name) throws SAXException {
            return this;
        }

        public Handler endEntity(String name) throws SAXException {
            return this;
        }

        public Handler startCDATA() throws SAXException {
            return this;
        }

        public Handler endCDATA() throws SAXException {
            return this;
        }

        public Handler comment(char c[], int start, int len) throws SAXException {
            return this;
        }
    }

    /**
     * Buffers content into the pipe's SAX buffer.
     */
    protected class BufferHandler extends NullHandler {
        public Handler startDocument() throws SAXException {
            if (buffer != null) buffer.startDocument();
            return this;
        }

        public void setDocumentLocator(Locator paramLocator) {
            locator = new LocatorImpl(paramLocator);
            if (buffer != null) buffer.setDocumentLocator(paramLocator);
        }

        public void endDocument() throws SAXException {
            if (buffer != null) buffer.endDocument();
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            if (buffer != null) buffer.startPrefixMapping(prefix, uri);
        }

        public void endPrefixMapping(String prefix) throws SAXException {
            if (buffer != null) buffer.endPrefixMapping(prefix);
        }

        public Handler startElement(String uri, String loc, String raw, Attributes attrs) throws SAXException {
            if (buffer != null) buffer.startElement(uri, loc, raw, attrs);
            return this;
        }

        public void endElement(String uri, String loc, String raw) throws SAXException {
            if (buffer != null) buffer.endElement(uri, loc, raw);
        }

        public Handler characters(char ch[], int start, int length) throws SAXException {
            if (buffer != null) buffer.characters(ch, start, length);
            return this;
        }

        public Handler ignorableWhitespace(char ch[], int start, int length) throws SAXException {
            if (buffer != null) buffer.ignorableWhitespace(ch, start, length);
            return this;
        }

        public Handler processingInstruction(String target, String data) throws SAXException {
            if (buffer != null) buffer.processingInstruction(target, data);
            return this;
        }

        public Handler skippedEntity(String name) throws SAXException {
            if (buffer != null) buffer.skippedEntity(name);
            return this;
        }

        public Handler startDTD(String name, String publicId, String systemId) throws SAXException {
            if (buffer != null) buffer.startDTD(name, publicId, systemId);
            return this;
        }

        public Handler endDTD() throws SAXException {
            if (buffer != null) buffer.endDTD();
            return this;
        }

        public Handler startEntity(String name) throws SAXException {
            if (buffer != null) buffer.startEntity(name);
            return this;
        }

        public Handler endEntity(String name) throws SAXException {
            if (buffer != null) buffer.endEntity(name);
            return this;
        }

        public Handler startCDATA() throws SAXException {
            if (buffer != null) buffer.startCDATA();
            return this;
        }

        public Handler endCDATA() throws SAXException {
            if (buffer != null) buffer.endCDATA();
            return this;
        }

        public Handler comment(char c[], int start, int len) throws SAXException {
            if (buffer != null) buffer.comment(c, start, len);
            return this;
        }
    }

    /**
     * Copies events over into the contentHandler
     */
    protected class CopyHandler extends NullHandler {
        public Handler startDocument() throws SAXException {
            contentHandler.startDocument();
            return this;
        }

        public void endDocument() throws SAXException {
            contentHandler.endDocument();
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            contentHandler.startPrefixMapping(prefix, uri);
        }

        public void endPrefixMapping(String prefix) throws SAXException {
            contentHandler.endPrefixMapping(prefix);
        }

        public Handler startElement(String uri, String loc, String raw, Attributes attrs) throws SAXException {
            contentHandler.startElement(uri, loc, raw, attrs);
            return this;
        }

        public void endElement(String uri, String loc, String raw) throws SAXException {
            contentHandler.endElement(uri, loc, raw);
        }

        public Handler characters(char ch[], int start, int length) throws SAXException {
            contentHandler.characters(ch, start, length);
            return this;
        }

        public Handler ignorableWhitespace(char ch[], int start, int length) throws SAXException {
            contentHandler.ignorableWhitespace(ch, start, length);
            return this;
        }

        public Handler processingInstruction(String target, String data) throws SAXException {
            contentHandler.processingInstruction(target, data);
            return this;
        }

        public Handler skippedEntity(String name) throws SAXException {
            contentHandler.skippedEntity(name);
            return this;
        }

        public Handler startDTD(String name, String publicId, String systemId) throws SAXException {
            if (lexicalHandler != null) lexicalHandler.startDTD(name, publicId, systemId);
            return this;
        }

        public Handler endDTD() throws SAXException {
            if (lexicalHandler != null) lexicalHandler.endDTD();
            return this;
        }

        public Handler startEntity(String name) throws SAXException {
            if (lexicalHandler != null) lexicalHandler.startEntity(name);
            return this;
        }

        public Handler endEntity(String name) throws SAXException {
            if (lexicalHandler != null) lexicalHandler.endEntity(name);
            return this;
        }

        public Handler startCDATA() throws SAXException {
            if (lexicalHandler != null) lexicalHandler.startCDATA();
            return this;
        }

        public Handler endCDATA() throws SAXException {
            if (lexicalHandler != null) lexicalHandler.endCDATA();
            return this;
        }

        public Handler comment(char c[], int start, int len) throws SAXException {
            if (lexicalHandler != null) lexicalHandler.comment(c, start, len);
            return this;
        }
    }

    /**
     * Throws exception on most events, with the exception of ignorableWhitespace.
     */
    protected class ErrorHandler extends NullHandler {
        protected String getName() {
            return "<unknown>";
        }

        public Handler startDocument() throws SAXException {
            throw new SAXException("Unexpected startDocument in '" + getName() + "' (" + getLocation() + ")");
        }

        public void endDocument() throws SAXException {
            throw new SAXException("Unexpected endDocument in '" + getName() + "' (" + getLocation() + ")");
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            throw new SAXException("Unexpected startPrefixMapping in '" + getName() + "' (" + getLocation() + ")");
        }

        public void endPrefixMapping(String prefix) throws SAXException {
            throw new SAXException("Unexpected endPrefixMapping in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler startElement(String uri, String loc, String raw, Attributes attrs) throws SAXException {
            throw new SAXException("Unexpected startElement in '" + getName() + "' (" + getLocation() + ")");
        }

        public void endElement(String uri, String loc, String raw) throws SAXException {
            throw new SAXException("Unexpected endElement in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler characters(char ch[], int start, int length) throws SAXException {
            throw new SAXException("Unexpected characters in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler processingInstruction(String target, String data) throws SAXException {
            throw new SAXException("Unexpected processingInstruction in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler skippedEntity(String name) throws SAXException {
            throw new SAXException("Unexpected skippedEntity in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler startDTD(String name, String publicId, String systemId) throws SAXException {
            throw new SAXException("Unexpected startDTD in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler endDTD() throws SAXException {
            throw new SAXException("Unexpected endDTD in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler startEntity(String name) throws SAXException {
            throw new SAXException("Unexpected startEntity in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler endEntity(String name) throws SAXException {
            throw new SAXException("Unexpected endEntity in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler startCDATA() throws SAXException {
            throw new SAXException("Unexpected startCDATA in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler endCDATA() throws SAXException {
            throw new SAXException("Unexpected endCDATA in '" + getName() + "' (" + getLocation() + ")");
        }

        public Handler comment(char c[], int start, int len) throws SAXException {
            throw new SAXException("Unexpected comment in '" + getName() + "' (" + getLocation() + ")");
        }
    }

    protected final Handler hNull = new NullHandler();
    protected final Handler hBuffer = new BufferHandler();

    protected Locator locator;
    private LinkedList handlers;
    private Handler handler;

    private LinkedList buffers;
    private LinkedList locators;
    protected SaxBuffer buffer;


    /**
     * Initialize the pipe before starting processing
     */
    protected void init(Handler top) {
        locators = new LinkedList();
        handlers = new LinkedList();
        handler = top;
    }

    /**
     * Recycle the pipe after processing
     */
    public void recycle() {
        super.recycle();
        handlers = null;
        handler = null;
        buffers = null;
        buffer = null;
        locator = null;
        locators = null;
    }

    /**
     * @return current location (if known)
     */
    protected String getLocation() {
        if (locator == null) {
            return "unknown";
        }

        final String location = " (" + locator.getSystemId() + ":" +
                                       locator.getLineNumber() + ":" +
                                       locator.getColumnNumber() + ")";
        return location;
    }

    protected void pushHandler(Handler handler) {
        this.handlers.addFirst(this.handler);
        this.handler = handler;
    }

    protected void popHandler() {
        this.handler = (Handler) this.handlers.removeFirst();
    }

    protected void beginBuffer() {
        if (this.buffer != null) {
            if (this.buffers == null) {
                this.buffers = new LinkedList();
            }
            this.buffers.addFirst(this.buffer);
        }
        if (locator != null) {
            locators.addFirst(locator);
            locator = new LocatorImpl(locator);
        }
        this.buffer = new SaxBuffer();
    }

    protected SaxBuffer endBuffer() {
        SaxBuffer buffer = this.buffer;
        if (this.buffers != null && this.buffers.size() > 0) {
            this.buffer = (SaxBuffer) this.buffers.removeFirst();
        } else {
            this.buffer = null;
        }
        if (locator != null) {
            locator = (Locator)locators.removeFirst();
        }
        return buffer;
    }

    //
    // ContentHandler methods
    //

    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    public void startDocument() throws SAXException {
        pushHandler(handler.startDocument());
    }

    public void endDocument() throws SAXException {
        handler.endDocument();
        popHandler();
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        handler.startPrefixMapping(prefix, uri);
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        handler.endPrefixMapping(prefix);
    }

    public void startElement(String uri, String loc, String raw, Attributes attrs) throws SAXException {
        pushHandler(handler.nestedElement(uri, loc, raw, attrs));
        handler = handler.startElement(uri, loc, raw, attrs);
    }

    public void endElement(String uri, String loc, String raw) throws SAXException {
        handler.endElement(uri, loc, raw);
        popHandler();
    }

    public void characters(char ch[], int start, int len) throws SAXException {
        handler = handler.characters(ch, start, len);
    }

    public void ignorableWhitespace(char ch[], int start, int len) throws SAXException {
        handler = handler.ignorableWhitespace(ch, start, len);
    }

    public void processingInstruction(String target, String data) throws SAXException {
        handler = handler.processingInstruction(target, data);
    }

    public void skippedEntity(String name) throws SAXException {
        handler = handler.skippedEntity(name);
    }

    //
    // LexicalHandler methods
    //

    public void startDTD(String name, String publicId, String systemId) throws SAXException {
        handler = handler.startDTD(name, publicId, systemId);
    }

    public void endDTD() throws SAXException {
        handler = handler.endDTD();
    }

    public void startEntity(String name) throws SAXException {
        handler = handler.startEntity(name);
    }

    public void endEntity(String name) throws SAXException {
        handler = handler.endEntity(name);
    }

    public void startCDATA() throws SAXException {
        handler = handler.startCDATA();
    }

    public void endCDATA() throws SAXException {
        handler = handler.endCDATA();
    }

    public void comment(char ch[], int start, int len) throws SAXException {
        handler = handler.comment(ch, start, len);
    }
}
