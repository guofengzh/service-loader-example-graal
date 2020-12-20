package com.avic.license.server.ssl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.security.KeyStore;
import java.net.spi.URLStreamHandlerProvider;

public class SslStoreURLStreamHandlerProvider extends URLStreamHandlerProvider {
    private static final String PROTOCOL = "springbootssl";
    private static final String KEY_STORE_PATH = "keyStore";
    static final String KEY_STORE_URL = PROTOCOL + ":" + KEY_STORE_PATH;
    private static final String TRUST_STORE_PATH = "trustStore";
    static final String TRUST_STORE_URL = PROTOCOL + ":" + TRUST_STORE_PATH;

    public SslStoreURLStreamHandlerProvider() {
        System.out.println("-----SslStoreURLStreamHandlerProvider----constructor-----") ;
    }

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        System.out.println("=============protocol:" + protocol);
        try {
            if (PROTOCOL.equals(protocol)) {
                return new URLStreamHandler() {
                    @Override
                    protected URLConnection openConnection(URL url) throws IOException {
                        try {
                            if (KEY_STORE_PATH.equals(url.getPath())) {
                                return new SslStoreURLStreamHandlerProvider.KeyStoreUrlConnection(url, null) ;
                            }
                            if (TRUST_STORE_PATH.equals(url.getPath())) {
                                return new SslStoreURLStreamHandlerProvider.KeyStoreUrlConnection(url, null ) ;
                            }
                        } catch (Exception ex) {
                            throw new IOException(ex);
                        }
                        throw new IOException("Invalid path: " + url.getPath());
                    }
                };
            }
        } catch (Throwable t ) {
            t.printStackTrace();
        }
        return null;
    }
    private static final class KeyStoreUrlConnection extends URLConnection {
        private final KeyStore keyStore;
        private KeyStoreUrlConnection(URL url, KeyStore keyStore) {
            super(url);
            this.keyStore = keyStore;
        }

        @Override
        public void connect() throws IOException {
        }

        @Override
        public InputStream getInputStream() throws IOException {
            try {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                //this.keyStore.store(stream, new char[0]);
                return new ByteArrayInputStream(stream.toByteArray());
            }
            catch (Exception ex) {
                throw new IOException(ex);
            }
        }
    }
}
