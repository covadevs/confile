package br.com.confile.handler;

public interface Handler<H extends Handler, R> {
    void setNext(H h);
    void handle(R request);
}
