import static org.junit.jupiter.api.Assertions.*;

class Sim3_MUX_8by1Test {

    @org.junit.jupiter.api.Test
    void execute_0_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(false);
        mux.control[1].set(false);
        mux.control[2].set(false);
        mux.in[0].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }

    @org.junit.jupiter.api.Test
    void execute_1_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(true);
        mux.control[1].set(false);
        mux.control[2].set(false);
        mux.in[1].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }

    @org.junit.jupiter.api.Test
    void execute_2_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(false);
        mux.control[1].set(true);
        mux.control[2].set(false);
        mux.in[2].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }

    @org.junit.jupiter.api.Test
    void execute_3_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(true);
        mux.control[1].set(true);
        mux.control[2].set(false);
        mux.in[3].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }

    @org.junit.jupiter.api.Test
    void execute_4_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(false);
        mux.control[1].set(false);
        mux.control[2].set(true);
        mux.in[4].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }

    @org.junit.jupiter.api.Test
    void execute_5_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(true);
        mux.control[1].set(false);
        mux.control[2].set(true);
        mux.in[5].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }

    @org.junit.jupiter.api.Test
    void execute_6_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(false);
        mux.control[1].set(true);
        mux.control[2].set(true);
        mux.in[6].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }

    @org.junit.jupiter.api.Test
    void execute_7_control() {
        Sim3_MUX_8by1 mux = new Sim3_MUX_8by1();
        mux.control[0].set(true);
        mux.control[1].set(true);
        mux.control[2].set(true);
        mux.in[7].set(true);
        mux.execute();
        assertTrue(mux.out.get());
    }
}