public class Sim3_ALU {
    public RussWire[] aluOp;
    public RussWire bNegate;
    public RussWire[] a;
    public RussWire[] b;
    public RussWire[] result;

    // Components
    private Sim3_ALUElement[] elements;

    public Sim3_ALU(int num) {
        this.aluOp = new RussWire[3];
        this.a = new RussWire[num];
        this.b = new RussWire[num];
        this.result = new RussWire[num];
        this.elements = new Sim3_ALUElement[num];
        this.aluOp[0] = new RussWire();
        this.aluOp[1] = new RussWire();
        this.aluOp[2] = new RussWire();
        this.bNegate = new RussWire();
        for (int i = 0; i < num; i++) {
            this.elements[i] = new Sim3_ALUElement();
            this.a[i] = new RussWire();
            this.b[i] = new RussWire();
            this.result[i] = new RussWire();
        }
    }

    public void execute() {
        boolean carryIn = this.bNegate.get();
        for (int i = 0; i < this.a.length; i++) {
            this.elements[i].aluOp = this.aluOp;
            this.elements[i].bInvert = this.bNegate;
            this.elements[i].a.set(this.a[i].get());
            this.elements[i].b.set(this.b[i].get());
            this.elements[i].carryIn.set(carryIn);
            this.elements[i].execute_pass1();
            carryIn = this.elements[i].carryOut.get();
        }
        this.elements[0].less.set(this.elements[this.elements.length - 1].addResult.get());
        for (int i = 1; i < this.a.length; i++) {
            this.elements[i].less.set(false);
        }
        for (int i = 0; i < this.a.length; i++) {
            this.elements[i].execute_pass2();
            this.result[i].set(this.elements[i].result.get());
        }
    }
}
