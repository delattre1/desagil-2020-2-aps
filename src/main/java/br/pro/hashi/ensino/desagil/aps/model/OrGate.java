package br.pro.hashi.ensino.desagil.aps.model;

public class OrGate extends Gate {
    private final NandGate[] nands;

    public OrGate() {
        super("OR", 2);

        nands = new NandGate[3];

        nands[0] = new NandGate();
        nands[1] = new NandGate();
        nands[2] = new NandGate();
    }

    @Override
    public boolean read() {
        return nands[2].read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 1) {
            throw new IndexOutOfBoundsException(inputIndex);
        }

        if (inputIndex == 0) {
            nands[0].connect(0, emitter);
            nands[0].connect(1, emitter);
            nands[2].connect(0, nands[0]);
        } else {
            nands[1].connect(0, emitter);
            nands[1].connect(1, emitter);
            nands[2].connect(1, nands[1]);
        }
    }
}