/** Implements an 8-bit multiplexer
 *
 */
public class Sim3_MUX_8by1 {
    public RussWire[] control;
    public RussWire[] in;
    public RussWire out;

    /**
     * Executes the multiplex.
     */
    public void execute() {
                                            // LSB                                              MSB
        boolean zero = this.in[0].get() && !this.control[0].get() && !this.control[1].get() && !this.control[2].get();
        boolean one = this.in[1].get() && this.control[0].get() && !this.control[1].get() && !this.control[2].get();
        boolean two = this.in[2].get() && !this.control[0].get() && this.control[1].get() && !this.control[2].get();
        boolean three = this.in[3].get() && this.control[0].get() && this.control[1].get() && !this.control[2].get();
        boolean four = this.in[4].get() && !this.control[0].get() && !this.control[1].get() && this.control[2].get();
        boolean five = this.in[5].get() && this.control[0].get() && !this.control[1].get() && this.control[2].get();
        boolean six = this.in[6].get() && !this.control[0].get() && this.control[1].get() && this.control[2].get();
        boolean seven = this.in[7].get() && this.control[0].get() && this.control[1].get() && this.control[2].get();
        boolean result = zero || one || two || three || four || five || six || seven;
        this.out.set(result);
    }

    public Sim3_MUX_8by1() {
        this.out = new RussWire();
        this.in = new RussWire[8];
        this.control = new RussWire[3];
        this.control[0] = new RussWire();
        this.control[1] = new RussWire();
        this.control[2] = new RussWire();
        this.in[0] = new RussWire();
        this.in[1] = new RussWire();
        this.in[2] = new RussWire();
        this.in[3] = new RussWire();
        this.in[4] = new RussWire();
        this.in[5] = new RussWire();
        this.in[6] = new RussWire();
        this.in[7] = new RussWire();
    }
}
