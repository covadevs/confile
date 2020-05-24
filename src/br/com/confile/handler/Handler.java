package br.com.confile.handler;

public interface Handler<H extends Handler> {
    void setNext(H h);
    void handle();
}
