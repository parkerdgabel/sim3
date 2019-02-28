public class Sim3_ALUElement {
    // Inputs
    public RussWire[] aluOp;
    public RussWire bInvert;
    public RussWire a;
    public RussWire b;
    public RussWire carryIn;
    public RussWire less;
    // Outputs
    public RussWire result;
    public RussWire addResult;
    public RussWire carryOut;
    // Components
    private Sim3_MUX_8by1 mux;
    private AND and;
    private OR or;
    private FullAdder adder;
    private XOR xor;
    private XOR bInvertXOR;

    public void execute_pass1() {
        // Get b-value
        this.bInvertXOR.a.set(this.b.get());
        this.bInvertXOR.b.set(this.bInvert.get());
        this.bInvertXOR.execute();
        // set adder
        this.adder.a.set(this.a.get());
        this.adder.b.set(this.bInvertXOR.out.get());
        this.adder.carryIn.set(this.carryIn.get());
        // execute add
        this.adder.execute();
        this.addResult.set(this.adder.sum.get());
        this.carryOut.set(this.adder.carryOut.get());
        this.mux.in[2].set(this.addResult.get());
        // set and
        this.and.a.set(this.a.get());
        this.and.b.set(this.bInvertXOR.out.get());
        // execute and
        this.and.execute();
        this.mux.in[0].set(this.and.out.get());
        // set or
        this.or.a.set(this.a.get());
        this.or.b.set(this.bInvertXOR.out.get());
        // execute or
        this.or.execute();
        this.mux.in[1].set(this.or.out.get());
        // set xor
        this.xor.a.set(this.a.get());
        this.xor.b.set(this.bInvertXOR.out.get());
        // execute xor
        this.xor.execute();
        this.mux.in[4].set(this.xor.out.get());
    }

    public void execute_pass2() {
        this.mux.control = this.aluOp;
        this.mux.in[3].set(this.less.get());
        this.mux.in[5].set(false);
        this.mux.in[6].set(false);
        this.mux.in[7].set(false);
        this.mux.execute();
        this.result.set(this.mux.out.get());
    }

    public Sim3_ALUElement() {
       this.a = new RussWire();
       this.b = new RussWire();
       this.bInvert = new RussWire();
       this.carryIn = new RussWire();
       this.less = new RussWire();
       this.result = new RussWire();
       this.addResult = new RussWire();
       this.carryOut = new RussWire();
       this.aluOp = new RussWire[3];
       this.aluOp[0] = new RussWire();
       this.aluOp[1] = new RussWire();
       this.aluOp[2] = new RussWire();
       this.mux = new Sim3_MUX_8by1();
       this.and = new AND();
       this.or = new OR();
       this.adder = new FullAdder();
       this.xor = new XOR();
       this.bInvertXOR = new XOR();
    }
}
