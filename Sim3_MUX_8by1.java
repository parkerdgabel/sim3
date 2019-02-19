/** Implements an 8-bit multiplexer
 *
 */
public class Sim3_MUX_8by1 {
    public RussWire[] control;
    public RussWire[] in;
    public RussWire out;

    /** Returns true if the input is zero.
     * @return      a boolean
     */
    private boolean isZero() {
        if (!this.control[0].get() && !this.control[1].get() && !this.control[2].get()) {
            return true;
        }
        return false;
    }

    /** Returns true if the input is one.
     * @return      a boolean
     */
    private boolean isOne() {
        if (this.control[0].get() && !this.control[1].get() && !this.control[2].get()) {
            return true;
        }
        return false;
    }

    /** Returns true if the input is two.
     * @return      a boolean
     */
    private boolean isTwo() {
        if (!this.control[0].get() && this.control[1].get() && !this.control[2].get()) {
            return true;
        }
        return false;
    }

    /** Returns true if the input is three.
     * @return      a boolean
     */
    private boolean isThree() {
        if (this.control[0].get() && this.control[1].get() && !this.control[2].get()) {
            return true;
        }
        return false;
    }

    /** Returns true if the input is four.
     * @return      a boolean
     */
    private boolean isFour() {
        if (!this.control[0].get() && !this.control[1].get() && this.control[2].get()) {
            return true;
        }
        return false;
    }

    /** Returns true if the input is five.
     * @return      a boolean
     */
    private boolean isFive() {
        if (this.control[0].get() && !this.control[1].get() && this.control[2].get()) {
            return true;
        }
        return false;
    }

    /** Returns true if the input is six.
     * @return      a boolean
     */
    private boolean isSix() {
        if (!this.control[0].get() && this.control[1].get() && this.control[2].get()) {
            return true;
        }
        return false;
    }

    /**
     * Executes the multiplex.
     */
    public void execute() {
        if (this.isZero()) {
            this.out.set(this.in[0].get());
        } else if (this.isOne()) {
            this.out.set(this.in[1].get());
        } else if (this.isTwo()) {
            this.out.set(this.in[2].get());
        } else if (this.isThree()) {
            this.out.set(this.in[3].get());
        } else if (this.isFour()) {
            this.out.set(this.in[4].get());
        } else if (this.isFive()) {
            this.out.set(this.in[5].get());
        } else if (this.isSix()) {
            this.out.set(this.in[6].get());
        } else {
            this.out.set(this.in[7].get());
        }
    }

    public Sim3_MUX_8by1() {
        this.out = new RussWire();
        this.in = new RussWire[8];
        this.control = new RussWire[3];
        for (int i = 0; i < 8; i++) {
            if (2 < i) {
                this.in[i] = new RussWire();
            } else {
                this.in[i] = new RussWire();
                this.control[i] = new RussWire();
            }
        }
    }
}
