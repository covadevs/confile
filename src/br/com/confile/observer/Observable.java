package br.com.confile.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<O extends Observer<P>, P> {

    protected List<O> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    public void add(O observer) {
        this.observers.add(observer);
    }

    public void remove(O observer) {
        this.observers.remove(observer);
    }

    public abstract void notify(P param);

}
