package br.com.confile.handler;

public abstract class BaseHandler<H extends Handler, R> implements Handler<H> {

    public BaseHandler(R request) {
        this.request = request;
    }

    protected H next;
    protected R request;

    public R getRequest() {
        return request;
    }
}
