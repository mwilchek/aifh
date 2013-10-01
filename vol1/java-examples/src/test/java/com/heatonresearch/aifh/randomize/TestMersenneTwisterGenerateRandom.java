/*
 * Artificial Intelligence for Humans
 * Volume 1: Fundamental Algorithms
 * Java Version
 * http://www.aifh.org
 * http://www.jeffheaton.com
 *
 * Code repository:
 * https://github.com/jeffheaton/aifh

 * Copyright 2013 by Jeff Heaton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * For more information on Heaton Research copyrights, licenses
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */

package com.heatonresearch.aifh.randomize;

import com.heatonresearch.aifh.AIFH;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Mersenne twister random.
 */
public class TestMersenneTwisterGenerateRandom {

    public static final boolean[] BOOLEAN_TEST = {
            false, true, false, false, false, false, false, false, false, true,
            false, true, false, true, false, true, false, true, false, false,
            true, true, false, true, true, true, false, false, false, true,
            false, false, true, true, true, false, true, true, false, true,
            true, true, false, true, false, false, true, false, false, false,
            false, true, false, false, false, false, true, false, true, true,
            false, false, true, false, false, true, true, true, true, true,
            true, false, false, true, false, false, true, false, true, true,
            true, true, true, false, false, true, false, true, true, true,
            false, true, false, true, false, false, true, true, false, true
    };

    public static final double[] DOUBLE_RANGE_TEST = {
            -0.16595599063680155, 0.44064900078050373, -0.9997712633572684, -0.3953348398494567, -0.706488214847774, -0.8153228045528911, -0.6274795714643377, -0.308878550835072, -0.2064650375980417, 0.07763346571656804,
            -0.16161098142643238, 0.37043900860989565, -0.5910954939290021, 0.7562348613016967, -0.94522480564076, 0.34093501907473867, -0.16539038845286358, 0.11737964840825099, -0.7192261237165991, -0.6037970251325002,
            0.6014891480198654, 0.936523163400814, -0.3731516571998357, 0.3846452390597028, 0.7527783174818827, 0.7892133244617852, -0.8299115648983908, -0.9218904294654735, -0.6603391748892309, 0.7562850019493115,
            -0.803306323496535, -0.1577847399814698, 0.9157790664371215, 0.06633055798861065, 0.38375423221676463, -0.3689687507712802, 0.37300186703546245, 0.6692513350408924, -0.9634234597035853, 0.5002886242875451,
            0.9777221876572288, 0.49633131320760526, -0.4391120241244286, 0.5785586602128907, -0.7935479857515046, -0.10421295555715204, 0.8171910076192694, -0.41277170469253766, -0.4244493210467557, -0.7399428628444857,
            -0.9612660979144871, 0.35767107954208055, -0.5767437544331437, -0.46890669170230304, -0.016853672731246938, -0.8932749162342541, 0.14823522013241996, -0.706542850836049, 0.17861107769545836, 0.3995167085830993,
            -0.7953311343953464, -0.1718880251068433, 0.38880030790148945, -0.17164145289061938, -0.9000930856023699, 0.07179281250672709, 0.3275892776240741, 0.029778235924350582, 0.8891895124257014, 0.1731100941635808,
            0.806803838634139, -0.7250505850321001, -0.7214472922046224, 0.6147825830454927, -0.2046463329069408, -0.6692915960461236, 0.8550171661752766, -0.30446828690145744, 0.5016242157768154, 0.4519959725831413,
            0.7666121926964695, 0.2473444237634359, 0.5018848584276165, -0.3022033046712562, -0.46014421115721116, 0.7917724476095542, -0.1438176071243935, 0.9296800795694944, 0.32688300305929974, 0.24339142661666902,
            -0.7705080572679202, 0.898978503467659, -0.10017572774558192, 0.1567792279075666, -0.1837263888179277, -0.5259460281455497, 0.8067590526221691, 0.14735896293403195, -0.9942593344229715, 0.23428982952027977
    };

    public static final double[] DOUBLE_TEST = {
            0.4170220046815992, 0.7203245003902519, 1.1436832136579866E-4, 0.30233258007527164, 0.146755892576113, 0.09233859772355446, 0.18626021426783113, 0.345560724582464, 0.39676748120097916, 0.538816732858284,
            0.4191945092867838, 0.6852195043049478, 0.20445225303549897, 0.8781174306508484, 0.027387597179620027, 0.6704675095373693, 0.4173048057735682, 0.5586898242041255, 0.14038693814170045, 0.1981014874337499,
            0.8007445740099327, 0.968261581700407, 0.31342417140008216, 0.6923226195298514, 0.8763891587409414, 0.8946066622308926, 0.0850442175508046, 0.03905478526726325, 0.16983041255538456, 0.8781425009746557,
            0.09834683825173252, 0.4211076300092651, 0.9578895332185607, 0.5331652789943053, 0.6918771161083823, 0.3155156246143599, 0.6865009335177312, 0.8346256675204462, 0.01828827014820733, 0.7501443121437725,
            0.9888610938286144, 0.7481656566038026, 0.2804439879377857, 0.7892793301064454, 0.10322600712424768, 0.447893522221424, 0.9085955038096347, 0.2936141476537312, 0.28777533947662215, 0.13002856857775713,
            0.01936695104275643, 0.6788355397710403, 0.21162812278342813, 0.2655466541488485, 0.49157316363437653, 0.05336254188287293, 0.57411761006621, 0.14672857458197552, 0.5893055388477292, 0.6997583542915496,
            0.10233443280232679, 0.41405598744657834, 0.6944001539507447, 0.4141792735546903, 0.049953457198815054, 0.5358964062533635, 0.663794638812037, 0.5148891179621753, 0.9445947562128507, 0.5865550470817904,
            0.9034019193170695, 0.13747470748394996, 0.13927635389768878, 0.8073912915227464, 0.3976768335465296, 0.16535420197693818, 0.9275085830876383, 0.3477658565492713, 0.7508121078884077, 0.7259979862915706,
            0.8833060963482348, 0.623672211881718, 0.7509424292138083, 0.3488983476643719, 0.2699278944213944, 0.8958862238047771, 0.42809119643780325, 0.9648400397847472, 0.6634415015296499, 0.6216957133083345,
            0.11474597136603992, 0.9494892517338295, 0.44991213612720904, 0.5783896139537833, 0.40813680559103616, 0.23702698592722515, 0.9033795263110845, 0.573679481467016, 0.0028703327885142293, 0.6171449147601399
    };

    public static final long[] LONG_TEST = {
            7692698078264393963l, -5159102570077350840l, 2109959069025161l, 5577051502419189381l, 2707168392203228096l, 1703346441743126657l, 3435894450290564679l, 6374470256055056892l, 7319067950818753817l, -8507329718584355564l,
            7732774011439067493l, -5806675312401397292l, 3771478314293010684l, -2248336445561007460l, 505211971622099342l, -6078801552385414588l, 7697914927906512855l, -8140735810476293391l, 2589681897007918558l, 3654327361836713046l,
            -3675613990726543383l, -585470662529678329l, 5781655721804417853l, -5675645944811117255l, -2280217787501512832l, -1944163899850688303l, 1568788721696826072l, 720433610630797939l, 3132818342174953450l, -2247874038898116152l,
            1814178919768859719l, 7768064505119081926l, -776801024770118095l, -8611580431754415613l, -5683864043590964456l, 5820236150515825707l, -5783037211452158950l, -3050617875898555056l, 337359223002198899l, -4609023926297661998l,
            -205476670031827904l, -4645523745188204519l, 5173278553645899490l, -3887110229885900921l, 1904183826989973145l, 8262177221521703958l, -1686115335777894717l, 5416224956960949374l, 5308518104502300029l, 2398603735146774683l,
            357257325660623161l, -5924438774192313178l, 3903849603498452256l, 4898471233857171210l, 9067924279430645391l, 984365197678320727l, -7856143515650420793l, 2706664419540043100l, -7575975645032774466l, -5538480663593495648l,
            1887737046274938007l, 7637984807505306945l, -5637322071995766963l, 7640258922210970496l, 921478669639537917l, -8561200173968275706l, -6201894068577578539l, -8948716481259309566l, -1022046309007159333l, -7626713388108447029l,
            -1781920192927819699l, 2535960658708452427l, 2569195061717959723l, -3553003567916163554l, 7335842777111343975l, 3050246494649913133l, -1337230695894115783l, 6415147800697085436l, -4596705371622916000l, -5054445000904528886l,
            -2152622667894538372l, -6942022501793601657l, -4594301118869421928l, 6436038359241670108l, 4979290776174700960l, -1920560340467794751l, 7896888626974268988l, -648586614796402536l, -6208408544584920205l, -6978482236821337982l,
            2116689539026495196l, -931758696069417118l, 8299413977603350198l, -7777339011913467415l, 7528795174340315606l, 4372375963003960002l, -1782333333430648857l, -7864225374133684682l, 52948145395612549l, -7062429743103711062l
    };

    public static final float[] FLOAT_TEST = {
            0.4170219898223877f, 0.7203245162963867f, 1.1436831846367568E-4f, 0.3023325800895691f, 0.1467558890581131f, 0.09233859926462173f, 0.18626020848751068f, 0.3455607295036316f, 0.3967674672603607f, 0.5388167500495911f,
            0.4191945195198059f, 0.6852195262908936f, 0.204452246427536f, 0.8781174421310425f, 0.027387596666812897f, 0.6704674959182739f, 0.4173048138618469f, 0.5586898326873779f, 0.1403869390487671f, 0.1981014907360077f,
            0.8007445931434631f, 0.9682615995407104f, 0.31342417001724243f, 0.6923226118087769f, 0.8763891458511353f, 0.8946066498756409f, 0.08504422008991241f, 0.039054784923791885f, 0.16983041167259216f, 0.8781424760818481f,
            0.09834683686494827f, 0.42110762000083923f, 0.9578895568847656f, 0.5331652760505676f, 0.6918771266937256f, 0.3155156373977661f, 0.6865009069442749f, 0.8346256613731384f, 0.018288269639015198f, 0.7501443028450012f,
            0.988861083984375f, 0.7481656670570374f, 0.2804439961910248f, 0.7892793416976929f, 0.10322600603103638f, 0.44789353013038635f, 0.9085955023765564f, 0.29361414909362793f, 0.28777533769607544f, 0.13002857565879822f,
            0.019366951659321785f, 0.6788355112075806f, 0.21162812411785126f, 0.26554664969444275f, 0.49157315492630005f, 0.053362540900707245f, 0.5741176009178162f, 0.14672857522964478f, 0.5893055200576782f, 0.6997583508491516f,
            0.10233443230390549f, 0.4140559732913971f, 0.6944001317024231f, 0.414179265499115f, 0.04995345696806908f, 0.5358964204788208f, 0.6637946367263794f, 0.514889121055603f, 0.9445947408676147f, 0.5865550637245178f,
            0.9034019112586975f, 0.13747470080852509f, 0.13927635550498962f, 0.8073912858963013f, 0.39767682552337646f, 0.16535420715808868f, 0.9275085926055908f, 0.34776586294174194f, 0.7508121132850647f, 0.7259979844093323f,
            0.883306086063385f, 0.6236721873283386f, 0.7509424090385437f, 0.34889835119247437f, 0.26992788910865784f, 0.895886242389679f, 0.4280911982059479f, 0.9648400545120239f, 0.6634414792060852f, 0.6216956973075867f,
            0.11474597454071045f, 0.9494892358779907f, 0.4499121308326721f, 0.578389585018158f, 0.4081368148326874f, 0.23702698945999146f, 0.903379499912262f, 0.573679506778717f, 0.00287033268250525f, 0.6171449422836304f
    };

    public static final double[] GAUSSIAN_TEST = {
            -0.6117563856609114, 1.6243453401602888, -1.0729686233570592, -0.528171766135125, -2.3015387338610633, 0.8654076761335936, -0.7612069161929403, 1.7448117256182272, -0.24937041765509987, 0.3190391487416782,
            -2.060140764260887, 1.4621079304700162, -0.38405434483371775, -0.3224171971139128, -1.0998912518657833, 1.1337694080962435, -0.8778584480362436, -0.17242820442522358, 0.5828151947421639, 0.04221373744858673,
            1.1447236765569715, -1.1006191709671034, 0.5024943583324569, 0.9015907154495308, -0.6837278536207408, 0.9008559301691065, -0.9357694331752002, -0.12289023487202973, 0.5303554602228503, -0.2678880767997565,
            -0.39675351505669804, -0.691660740676098, -0.8452056336374916, -0.6871727252020841, -0.012664591889473558, -0.6712461099494427, 0.23441571021653584, -1.1173103398044957, 0.7420442008839823, 1.6598021835231498,
            -0.887628983654886, -0.19183555934098684, 1.692454632271207, -0.747158286994186, -0.6369956343252882, 0.05080775408036164, 2.100255162556456, 0.19091557020896008, 0.6172030978360935, 0.12015895924479604,
            -0.352249864855594, 0.30017034388137426, -0.34934274288419687, -1.1425182099813955, 0.5866231661570084, -0.2088942275340459, 0.9311020728626463, 0.8389833938658553, 0.8851411297369843, 0.2855873214252353,
            1.2528681896098024, -0.7543979477758688, -0.29809281637114515, 0.5129298013756143, -0.07557171833978238, 0.4885182177907035, 1.5198168642240575, 1.1316293331790652, -1.3964962965510797, 2.1855754490259787,
            -0.5044658685659535, -1.4441138347860922, 0.8761688980912522, 0.16003705165518284, -2.0222012574574, 0.3156348754607274, 0.8279746427299662, -0.30620402285494513, 0.76201118203118, 0.2300947433667075,
            -0.20075808542633305, -0.22232815482150572, 0.4100516229553294, 0.1865613826162478, 0.11900866822786582, 0.19829976226305301, 0.3775637902399256, -0.6706622787021754, 1.1294839380703958, 0.12182125808044389,
            0.18515642339247018, 1.1989179047800431, -0.6387303913753821, -0.3752849538843168, 0.07734006486929293, 0.42349431684660077, 0.04359686393782602, -0.34385375380735395, 0.698032021856466, -0.6200008335345772
    };

    public static final int[] INT_TEST = {
            -12091157, -289663928, 550290313, -4120955, 1013994432, 1703301249, 1666063943, -1418429956, -276857575, -660089580,
            1345499493, -2042050092, 1904615676, 986026652, -1999677042, -369530300, 1963679703, 1849836273, -261444130, -951810986,
            -1219897367, -847150073, 398576445, -2069519047, -579733632, -733808431, -731847976, 1172740723, 254447594, -1415071288,
            -1747770297, -1410234938, 1768615473, 848474627, 1243949848, 610401323, -930657254, 1771840848, 146764659, -1614778926,
            -1457558464, 1282027545, 1916133090, 954017671, 315096729, 2015364118, 413056707, -415021954, 513207677, -2040971109,
            359158073, -357077850, -384621280, 1283895050, -1785035121, -1864393641, -1658122297, -186677924, 1120896190, 992203680,
            -2003823465, -215014079, 2117674829, -1973105792, -1007233795, 194758406, 601149909, -891619838, 127995867, -501972277,
            -1972299699, 1924060235, -463272917, 1621712414, -1982450841, -1493364947, 1551604281, -1842504196, -1555480480, 542518282,
            -1330561156, -1512904825, 1520156824, -1016906276, 1531292064, -1061765951, -509632964, 50118808, 2139362163, 316934274,
            -915036452, 275167074, 1526046390, -249808407, 1631242710, -1018250558, -980992025, 1294333494, -976077947, 656828586
    };

    public static final int[] INT_RANGE_TEST = {
            4, 7, 0, 3, 1, 0, 1, 3, 3, 5,
            4, 6, 2, 8, 0, 6, 4, 5, 1, 1,
            8, 9, 3, 6, 8, 8, 0, 0, 1, 8,
            0, 4, 9, 5, 6, 3, 6, 8, 0, 7,
            9, 7, 2, 7, 1, 4, 9, 2, 2, 1,
            0, 6, 2, 2, 4, 0, 5, 1, 5, 6,
            1, 4, 6, 4, 0, 5, 6, 5, 9, 5,
            9, 1, 1, 8, 3, 1, 9, 3, 7, 7,
            8, 6, 7, 3, 2, 8, 4, 9, 6, 6,
            1, 9, 4, 5, 4, 2, 9, 5, 0, 6
    };

    @Test
    public void testBasic() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);

        assertEquals(4.1702200468159925, rnd.nextDouble(10), AIFH.DEFAULT_PRECISION);


    }

    @Test
    public void testBasic2() {
        final int[] seed = {1, 2, 3};
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(seed);

        assertEquals(6.09861274980219, rnd.nextDouble(10), AIFH.DEFAULT_PRECISION);
    }

    @Test
    public void testGenerateBoolean() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final boolean aBOOLEAN_TEST : BOOLEAN_TEST) {
            final boolean g = rnd.nextBoolean();
            assertEquals(g, aBOOLEAN_TEST);
        }
    }

    @Test
    public void testDoubleRange() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final double aDOUBLE_RANGE_TEST : DOUBLE_RANGE_TEST) {
            final double g = rnd.nextDouble(-1, 1);
            assertEquals(g, aDOUBLE_RANGE_TEST, AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testDouble() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final double aDOUBLE_TEST : DOUBLE_TEST) {
            final double g = rnd.nextDouble();
            assertEquals(g, aDOUBLE_TEST, AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testLong() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final long aLONG_TEST : LONG_TEST) {
            final long l = rnd.nextLong();
            assertEquals(l, aLONG_TEST, AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testFloat() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final float aFLOAT_TEST : FLOAT_TEST) {
            final float l = (float) rnd.nextFloat();
            assertEquals(l, aFLOAT_TEST, AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testGaussianFloat() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final double aGAUSSIAN_TEST : GAUSSIAN_TEST) {
            final double g = rnd.nextGaussian();
            assertEquals(g, aGAUSSIAN_TEST, AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testInt() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final int aINT_TEST : INT_TEST) {
            final int g = rnd.nextInt();
            assertEquals(g, aINT_TEST, AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testIntRange() {
        final MersenneTwisterGenerateRandom rnd = new MersenneTwisterGenerateRandom(1);
        for (final int aINT_RANGE_TEST : INT_RANGE_TEST) {
            final int g = rnd.nextInt(0, 10);
            assertEquals(g, aINT_RANGE_TEST);
        }
    }
}
