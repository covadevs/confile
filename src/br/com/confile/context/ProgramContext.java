package br.com.confile.context;

public class ProgramContext {

    private static ProgramContext instance = new ProgramContext();

    private Boolean run;

    private ProgramContext() {
        this.run = Boolean.TRUE;
    }

    public Boolean getRun() {
        return run;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }

    public boolean isRunning() {
        return Boolean.TRUE.equals(run);
    }

    public void exit() {
        this.run = Boolean.FALSE;
    }

    public static ProgramContext getInstance() {
        return instance;
    }

}
