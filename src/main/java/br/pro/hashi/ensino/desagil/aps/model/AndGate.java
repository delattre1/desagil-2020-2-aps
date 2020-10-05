package br.pro.hashi.ensino.desagil.aps.model;

public class AndGate extends Gate {
    private final NandGate nands;

    public NotGate() {
        super("AND", 2);
        nands = new NandGate[2];
        nands[0] = new NandGate();
        nands[1] = new NandGate();


    }

    @Override
    public boolean read() {
        return nands[1].read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex != 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        nands.connect(0, emitter);
        nands.connect(1, emitter);
        nands.connect(0, nands[0]);
        nands.connect(1, nands[0]);
    }
}



}
