package br.pro.hashi.ensino.desagil.aps.model;

public class XorGate extends Gate {
    private final NandGate[] nands;

    public XorGate() {
        super("XOR", 2);

        nands = new NandGate[4];

        nands[0] = new NandGate();
        nands[1] = new NandGate();
        nands[2] = new NandGate();
        nands[3] = new NandGate();
    }

    @Override
    public boolean read() {
        return nands[3].read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 1) {
            throw new IndexOutOfBoundsException(inputIndex);
        }

        nands[1].connect(1, nands[0]);
        nands[2].connect(0, nands[0]);
        nands[3].connect(0, nands[1]);
        nands[3].connect(1, nands[2]);

        if (inputIndex == 0) {
            nands[0].connect(0, emitter);
            nands[1].connect(0, emitter);
        } else {
            nands[0].connect(1, emitter);
            nands[2].connect(1, emitter);
        }
    }
}