package ru.otus.fibonacci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.fibonacci.FibonacciCalculator;

import java.math.BigInteger;

public class FibonacciCalculatorTest {

    private static final BigInteger FIBONACCI_100 = new BigInteger("354224848179261915075");
    private static final BigInteger FIBONACCI_1000 = new BigInteger("43466557686937456435688527675040625802564" +
            "66051737178040248172908953655541794905189040387984007925516929592259308032263477520968962323987332247" +
            "1161642996440906533187938298969649928516003704476137795166849228875");

    private static final BigInteger FIBONACCI_10_000 = new BigInteger("33644764876431783266621612005" +
            "10754331030214846068006390656476997468008144216666236815559551363373402558206533268083615937" +
            "37347904838652682630408924630564318873545443695598274916066020998841839338646527313000888302" +
            "69235673613135117579297437854413752130520504347701602264758318906527890855154366159582987279" +
            "68298751063120057542878345321551510387081829896979161312785626503319548714021428753269818796" +
            "20469360978799003509623022910263681314931952756302278376284415403605844025721143349611800230" +
            "91208287046088923962328835461505776583271252546093591128203925285393434620904245248929403901" +
            "70623388899108584106518317336043747073790855263176432573399371287193758774689747992630583706" +
            "574283016163740896917842637862421283525811282051637029808933209990570792006436742620238978311147005407499845925036063356093" +
            "3883831923386783056136435351892133279732908133732642652633989763922723407882928177953580570" +
            "9936910491754708089318410561463223382174656373212482263830921032977016480547262438423748624" +
            "1145309381220656491403275108664339451751216152654536133311131404243685480510676584349352383" +
            "6959653428071768775328348234345557366719731392746273629108210679280784718035329131176778924" +
            "6590899386354593278945237776744061922403376386740040213303432974969020283281459334188268176" +
            "8389307200363479562311710310129195316979460763273758925353077255237594378843450406771555577" +
            "9056450443016640119462580972216729758615026968443146952034614932291105970676243268515992834" +
            "7098912847067408620085871350162603120719031720860940812983215810772820763531866246112782455" +
            "3720853236530577595643007251774431505153960090516860322034916322264088524885243315805153484" +
            "9622434848299380905070483482449327453732624567755879089187190803662058009594743150052402532" +
            "7097469953187707243768259074199396322659841474981936092852239450397071654431564213281576889" +
            "0805878318340491743455627052022356484649519611246026831397097506938264870661326450766507461" +
            "1512677522748621598642530711298441182622661057163515069260029861704945425047491378115154139" +
            "9415506712562711971332527636319396069028956502882686083622410820505624307017949761711212330" +
            "66073310059947366875");


    FibonacciCalculator fibonacciCalculator;

    @Before
    public void init() {
        fibonacciCalculator = new FibonacciCalculator();
    }

    @Test
    public void checkCalculateFibonacciCycle() {
        Assert.assertEquals(BigInteger.valueOf(0), fibonacciCalculator.calculateFibonacciCycle(0));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciCycle(1));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciCycle(2));
        Assert.assertEquals(BigInteger.valueOf(2), fibonacciCalculator.calculateFibonacciCycle(3));
        Assert.assertEquals(BigInteger.valueOf(3), fibonacciCalculator.calculateFibonacciCycle(4));
        Assert.assertEquals(BigInteger.valueOf(5), fibonacciCalculator.calculateFibonacciCycle(5));
        Assert.assertEquals(BigInteger.valueOf(8), fibonacciCalculator.calculateFibonacciCycle(6));
        Assert.assertEquals(BigInteger.valueOf(13), fibonacciCalculator.calculateFibonacciCycle(7));
        Assert.assertEquals(BigInteger.valueOf(21), fibonacciCalculator.calculateFibonacciCycle(8));
        Assert.assertEquals(BigInteger.valueOf(55), fibonacciCalculator.calculateFibonacciCycle(10));
        Assert.assertEquals(FIBONACCI_100, fibonacciCalculator.calculateFibonacciCycle(100));
        Assert.assertEquals(FIBONACCI_1000, fibonacciCalculator.calculateFibonacciCycle(1000));
        Assert.assertEquals(FIBONACCI_10_000, fibonacciCalculator.calculateFibonacciCycle(10_000));
    }

    @Test(timeout = 2000)
    public void checkCalculateFibonacciRecursive() {
        Assert.assertEquals(BigInteger.valueOf(0), fibonacciCalculator.calculateFibonacciRecursive(0));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciRecursive(1));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciRecursive(2));
        Assert.assertEquals(BigInteger.valueOf(2), fibonacciCalculator.calculateFibonacciRecursive(3));
        Assert.assertEquals(BigInteger.valueOf(3), fibonacciCalculator.calculateFibonacciRecursive(4));
        Assert.assertEquals(BigInteger.valueOf(5), fibonacciCalculator.calculateFibonacciRecursive(5));
        Assert.assertEquals(BigInteger.valueOf(8), fibonacciCalculator.calculateFibonacciRecursive(6));
        Assert.assertEquals(BigInteger.valueOf(13), fibonacciCalculator.calculateFibonacciRecursive(7));
        Assert.assertEquals(BigInteger.valueOf(21), fibonacciCalculator.calculateFibonacciRecursive(8));
        Assert.assertEquals(BigInteger.valueOf(55), fibonacciCalculator.calculateFibonacciRecursive(10));
        //Assert.assertEquals(FIBONACCI_100, fibonacciCalculator.calculateFibonacciRecursive(100));
    }

    @Test
    public void checkCalculateFibonacciGoldenRatio() {
        Assert.assertEquals(BigInteger.valueOf(0), fibonacciCalculator.calculateFibonacciGoldenRation(0));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciGoldenRation(1));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciGoldenRation(2));
        Assert.assertEquals(BigInteger.valueOf(2), fibonacciCalculator.calculateFibonacciGoldenRation(3));
        Assert.assertEquals(BigInteger.valueOf(3), fibonacciCalculator.calculateFibonacciGoldenRation(4));
        Assert.assertEquals(BigInteger.valueOf(5), fibonacciCalculator.calculateFibonacciGoldenRation(5));
        Assert.assertEquals(BigInteger.valueOf(8), fibonacciCalculator.calculateFibonacciGoldenRation(6));
        Assert.assertEquals(BigInteger.valueOf(13), fibonacciCalculator.calculateFibonacciGoldenRation(7));
        Assert.assertEquals(BigInteger.valueOf(21), fibonacciCalculator.calculateFibonacciGoldenRation(8));
        Assert.assertEquals(BigInteger.valueOf(55), fibonacciCalculator.calculateFibonacciGoldenRation(10));
        Assert.assertEquals(BigInteger.valueOf(55), fibonacciCalculator.calculateFibonacciGoldenRation(10));
        Assert.assertNotEquals(FIBONACCI_100, fibonacciCalculator.calculateFibonacciGoldenRation(100));
        Assert.assertNotEquals(FIBONACCI_1000, fibonacciCalculator.calculateFibonacciGoldenRation(1000));
    }

    @Test
    public void checkCalculateFibonacciMatrix() {
        Assert.assertEquals(BigInteger.valueOf(0), fibonacciCalculator.calculateFibonacciMatrix(0));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciMatrix(1));
        Assert.assertEquals(BigInteger.valueOf(1), fibonacciCalculator.calculateFibonacciMatrix(2));
        Assert.assertEquals(BigInteger.valueOf(2), fibonacciCalculator.calculateFibonacciMatrix(3));
        Assert.assertEquals(BigInteger.valueOf(3), fibonacciCalculator.calculateFibonacciMatrix(4));
        Assert.assertEquals(BigInteger.valueOf(5), fibonacciCalculator.calculateFibonacciMatrix(5));
        Assert.assertEquals(BigInteger.valueOf(8), fibonacciCalculator.calculateFibonacciMatrix(6));
        Assert.assertEquals(BigInteger.valueOf(13), fibonacciCalculator.calculateFibonacciMatrix(7));
        Assert.assertEquals(BigInteger.valueOf(21), fibonacciCalculator.calculateFibonacciMatrix(8));
        Assert.assertEquals(BigInteger.valueOf(55), fibonacciCalculator.calculateFibonacciMatrix(10));
        Assert.assertEquals(FIBONACCI_100, fibonacciCalculator.calculateFibonacciMatrix(100));
        Assert.assertEquals(FIBONACCI_1000, fibonacciCalculator.calculateFibonacciMatrix(1000));
        Assert.assertEquals(FIBONACCI_10_000, fibonacciCalculator.calculateFibonacciMatrix(10_000));
    }
}
