package hgm.asve.cnsrv.approxator.restructure;


import hgm.XaddVisualizer;
import org.junit.Test;
import xadd.XADD;

/**
 * Created by Hadi Afshar.
 * Date: 15/11/13
 * Time: 12:05 PM
 */
public class InnerNodeRestructurerTest {
    public static void main(String[] args) throws Exception {
        InnerNodeRestructurerTest instance = new InnerNodeRestructurerTest();
        instance.testRestructure();
    }

    String testXadd =
            //todo does not work for this!!!!
    /*        "( [(-1 + (0.06666667 * o_1)) > 0]\n" +
            "    ( [0] ) \n" +
            "    ( [(-1 + (0.2 * o_1)) > 0]\n" +
            "       ( [(-1 + (0.1 * o_1)) > 0]\n" +
            "          ( [(-1 + (-1 * o_1) + (1 * x_3)) > 0]\n" +
            "             ( [(1 + (-0.0625 * x_3)) > 0]\n" +
            "                ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                ( [0] ) )  \n" +
            "             ( [(1 * x_3) > 0]\n" +
            "                ( [(1 + (-0.2 * o_1) + (0.2 * x_3)) > 0]\n" +
            "                   ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                   ( [(1 + (0.09090909 * x_3) + (-0.09090909 * o_1)) > 0]\n" +
            "                      ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                      ( [0] ) )  )  \n" +
            "                ( [(1 + (0.16666667 * x_3)) > 0]\n" +
            "                   ( [(1 + (0.09090909 * x_3) + (-0.09090909 * o_1)) > 0]\n" +
            "                      ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                      ( [0] ) )  \n" +
            "                   ( [0] ) )  )  )  \n" +
            "          ( [(-1 + (-1 * o_1) + (1 * x_3)) > 0]\n" +
            "             ( [(1 + (0.09090909 * o_1) + (-0.09090909 * x_3)) > 0]\n" +
            "                ( [(1 + (-0.0625 * x_3)) > 0]\n" +
            "                   ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                   ( [0] ) )  \n" +
            "                ( [0] ) )  \n" +
            "             ( [(1 * x_3) > 0]\n" +
            "                ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                ( [(1 + (0.16666667 * x_3)) > 0]\n" +
            "                   ( [(1 + (0.09090909 * x_3) + (-0.09090909 * o_1)) > 0]\n" +
            "                      ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                      ( [0] ) )  \n" +
            "                   ( [0] ) )  )  )  )  \n" +
            "       ( [(1 + (0.2 * o_1)) > 0]\n" +
            "          ( [(-1 + (0.16666667 * x_3)) > 0]\n" +
            "             ( [(1 + (0.09090909 * o_1) + (-0.09090909 * x_3)) > 0]\n" +
            "                ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                ( [0] ) )  \n" +
            "             ( [(1 * x_3) > 0]\n" +
            "                ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                ( [(1 + (0.16666667 * x_3)) > 0]\n" +
            "                   ( [(0.00635132 + (0.00000648 * o_1 * o_1 * o_1 * o_1) + (0.00000044 * o_1 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00033526 * x_3 * x_3) + (0.00002084 * o_1 * o_1 * x_3) + (-0.00001833 * o_1 * o_1 * o_1 * x_3) + (0.00000017 * o_1 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000004 * o_1 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00000004 * x_3 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000032 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * o_1 * o_1 * x_3 * x_3) + (-0.00003866 * o_1 * o_1 * o_1) + (0.00000032 * o_1 * o_1 * x_3 * x_3 * x_3) + (-0.00001855 * o_1 * x_3 * x_3 * x_3) + (0.00000017 * o_1 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00000643 * x_3 * x_3 * x_3 * x_3) + (0.00107332 * o_1) + (-0.00000079 * o_1 * o_1 * o_1 * o_1 * x_3) + (-0.00000079 * o_1 * x_3 * x_3 * x_3 * x_3) + (0.00000029 * o_1 * o_1 * o_1 * o_1 * o_1) + (-0.00004082 * x_3 * x_3 * x_3) + (0.00000031 * x_3 * x_3 * x_3 * x_3 * x_3) + (0.00002851 * o_1 * o_1 * x_3 * x_3) + (0.0000241 * o_1 * x_3 * x_3) + (-0.00000035 * o_1 * o_1 * x_3 * x_3 * x_3 * x_3) + (-0.00033634 * o_1 * o_1) + (0.00056495 * o_1 * x_3) + (0.00115881 * x_3))] ) \n" +
            "                   ( [0] ) )  )  )  \n" +
            "          ( [0] ) )  )  ) ";
    */
            "( [(-1 + (0.06666667 * o_1)) > 0]\n" +
                    "    ( [0] ) \n" +
                    "    ( [(-1 + (0.2 * o_1)) > 0]\n" +
                    "       ( [(-1 + (0.1 * o_1)) > 0]\n" +
                    "          ( [(-1 + (-1 * o_1) + (1 * x_3)) > 0]\n" +
                    "             ( [(1 + (-0.16666667 * x_3) + (0.16666667 * o_1)) > 0]\n" +
                    "                ( [(1 + (-0.0625 * x_3)) > 0]\n" +
                    "                   ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                   ( [0] ) )  \n" +
                    "                ( [0] ) )  \n" +
                    "             ( [(1 * x_3) > 0]\n" +
                    "                ( [(1 + (-0.2 * o_1) + (0.2 * x_3)) > 0]\n" +
                    "                   ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                   ( [(1 + (0.09090909 * x_3) + (-0.09090909 * o_1)) > 0]\n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                      ( [0] ) )  )  \n" +
                    "                ( [(1 + (0.16666667 * x_3)) > 0]\n" +
                    "                   ( [(1 + (0.09090909 * x_3) + (-0.09090909 * o_1)) > 0]\n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                      ( [0] ) )  \n" +
                    "                   ( [0] ) )  )  )  \n" +
                    "          ( [(-1 + (-1 * o_1) + (1 * x_3)) > 0]\n" +
                    "             ( [(1 + (-0.1 * x_3)) > 0]\n" +
                    "                ( [(0.00784852 + (0.00096578 * x_3) + (-0.00047325 * x_3 * x_3) + (0.00085111 * o_1) + (-0.00046157 * o_1 * o_1) + (0.00075308 * o_1 * x_3))] ) \n" +
                    "                ( [(1 + (-0.16666667 * x_3) + (0.16666667 * o_1)) > 0]\n" +
                    "                   ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                   ( [(1 + (0.09090909 * o_1) + (-0.09090909 * x_3)) > 0]\n" +
                    "                      ( [(1 + (-0.0625 * x_3)) > 0]\n" +
                    "                         ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                         ( [0] ) )  \n" +
                    "                      ( [0] ) )  )  )  \n" +
                    "             ( [(1 * x_3) > 0]\n" +
                    "                ( [(1 + (-0.2 * o_1) + (0.2 * x_3)) > 0]\n" +
                    "                   ( [(1 + (-0.25 * x_3)) > 0]\n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                      ( [(1 + (-0.1 * x_3)) > 0]\n" +
                    "                         ( [(0.00784852 + (0.00096578 * x_3) + (-0.00047325 * x_3 * x_3) + (0.00085111 * o_1) + (-0.00046157 * o_1 * o_1) + (0.00075308 * o_1 * x_3))] ) \n" +
                    "                         ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) )  )  \n" +
                    "                   ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) )  \n" +
                    "                ( [(1 + (0.16666667 * x_3)) > 0]\n" +
                    "                   ( [(1 + (0.09090909 * x_3) + (-0.09090909 * o_1)) > 0]\n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                      ( [0] ) )  \n" +
                    "                   ( [0] ) )  )  )  )  \n" +
                    "       ( [(1 + (0.2 * o_1)) > 0]\n" +
                    "          ( [(1 * o_1) > 0]\n" +
                    "             ( [(-1 + (0.16666667 * x_3)) > 0]\n" +
                    "                ( [(1 + (-0.1 * x_3)) > 0]\n" +
                    "                   ( [(1 + (-0.16666667 * x_3) + (0.16666667 * o_1)) > 0]\n" +
                    "                      ( [(1 + (-0.2 * x_3) + (0.2 * o_1)) > 0]\n" +
                    "                         ( [(0.0083044 + (0.00019266 * o_1 * o_1) + (-0.00083074 * x_3) + (-0.00004586 * x_3 * x_3) + (0.00279028 * o_1) + (-0.00024904 * o_1 * x_3))] ) \n" +
                    "                         ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) )  \n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) )  \n" +
                    "                   ( [(1 + (-0.16666667 * x_3) + (0.16666667 * o_1)) > 0]\n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                      ( [(1 + (0.09090909 * o_1) + (-0.09090909 * x_3)) > 0]\n" +
                    "                         ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                         ( [0] ) )  )  )  \n" +
                    "                ( [(1 * x_3) > 0]\n" +
                    "                   ( [(1 + (-0.2 * x_3) + (0.2 * o_1)) > 0]\n" +
                    "                      ( [(0.00784852 + (0.00096578 * x_3) + (-0.00047325 * x_3 * x_3) + (0.00085111 * o_1) + (-0.00046157 * o_1 * o_1) + (0.00075308 * o_1 * x_3))] ) \n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) )  \n" +
                    "                   ( [(1 + (0.16666667 * x_3)) > 0]\n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                      ( [0] ) )  )  )  \n" +
                    "             ( [(-1 + (0.16666667 * x_3)) > 0]\n" +
                    "                ( [(1 + (0.09090909 * o_1) + (-0.09090909 * x_3)) > 0]\n" +
                    "                   ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                   ( [0] ) )  \n" +
                    "                ( [(1 * x_3) > 0]\n" +
                    "                   ( [(0.0083044 + (0.00019266 * o_1 * o_1) + (-0.00083074 * x_3) + (-0.00004586 * x_3 * x_3) + (0.00279028 * o_1) + (-0.00024904 * o_1 * x_3))] ) \n" +
                    "                   ( [(1 + (0.16666667 * x_3)) > 0]\n" +
                    "                      ( [(0.00292504 + (0.00006387 * o_1 * x_3) + (-0.00005584 * x_3 * x_3) + (-0.00005982 * o_1 * o_1) + (0.00023469 * x_3) + (0.00029368 * o_1))] ) \n" +
                    "                      ( [0] ) )  )  )  )  \n" +
                    "          ( [0] ) )  )  ) ";

    @Test
    public void testRestructure() throws Exception {
        XADD context = new XADD();
        String[] vars = new String[]{"o_1", "x_3"};
        for (String var : vars) {
            context._hmMinVal.put(var, -10d);
            context._hmMaxVal.put(var, 20d);
        }
        int rootId = context.buildCanonicalXADDFromString(testXadd);
        XADD.XADDNode root = context._hmInt2Node.get(rootId);
        XaddVisualizer.visualize(root, "original", context);

    }
}
