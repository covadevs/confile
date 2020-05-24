package br.com.confile.handler;

public abstract class BaseHandler<H extends Handler, R> implements Handler<H, R> {

    protected H next;

}
