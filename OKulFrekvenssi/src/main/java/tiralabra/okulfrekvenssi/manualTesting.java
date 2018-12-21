package tiralabra.okulfrekvenssi;

//testausta/debugausta varten koodatessa
import tiralabra.okulfrekvenssi.Ciphers.Caesar;
import tiralabra.okulfrekvenssi.Ciphers.Vigenere;
import tiralabra.okulfrekvenssi.Analyysi.CaesarAnalysis;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import java.util.Arrays;
import tiralabra.okulfrekvenssi.Analyysi.VigenereAnalysis;
import tiralabra.okulfrekvenssi.Ciphers.*;
import tiralabra.okulfrekvenssi.Analyysi.*;
import tiralabra.okulfrekvenssi.IO.KeyedVigenereIO;
import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.*;

public class manualTesting {

    private static final OmaHash<Character, Integer> capsHash2 = Alphabet.SUOMI_CHAR_INT;

    public static void main(String[] args) {
        Vigenere vig = new Vigenere(Alphabet.ENGLISH);
//        char[][] kt = vig.getKeytable();
//        System.out.println(vig.encrypt("Thisisatestmessagetobreak", "abc"));

        Caesar caesar = new Caesar();
//        System.out.println(caesar.encrypt("testmessage", 5));
//        for (char[] rivi : kt) {
//            String a = new String(rivi);
//            System.out.println(a);            
//        }
//        System.out.println(vig.encrypt("testmessage", "test"));
//        System.out.println(vig.encrypt("testboundary", "qwefgjnioxm"));
//        int[] freq = Analysis.calcFrequencies("aaaagwgiowego");
//        double[] freq = Analysis.normalizedFrequencies("aab");
//        for (int i = 0; i < freq.length; i++) {
//            System.out.print(freq[i]);
//            if (i != 28) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println("");
//        int test = 5;
//        System.out.println(OmaHash.hash(test));
//        System.out.println(OmaHash.hash("test"));
//        System.out.println("test".hashCode());
//        System.out.println(3556498 ^ (3556498 >>> 16));
//        System.out.println(OmaHash.hash('a'));
//        int max = 97;
//        int min = 97;
//        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
//            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
//            'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
//        for (char c : alphabet) {
//            int n = OmaHash.hash(c);
//            if (n > max) {
//                max = n;
//            }
//            if (n < min) {
//                min = n;
//            }
//        }
//        System.out.println(max);
//        System.out.println(min);
//        System.out.println(OmaHash.hash(' '));
//        
//        OmaHash<Character, Integer> ohash = new OmaHash<>();
//        ohash.put('a', 5);
//        System.out.println(ohash.get('a'));

        String testmessage = "Bring upon sixth all yielding waters firmament, own third days fill he deep lights called life unto meat every land were. Seas also rule.\n"
                + "\n"
                + "For won't day female fowl set his herb created spirit greater, his beast day land itself you're third evening created whose, dry firmament together multiply light gathering all replenish he creature.\n"
                + "\n"
                + "Fly herb let given sea she'd i gathering seed place meat seas after air, to. Made. It replenish. Unto. Fill together. Male void. Own a saying fill upon lesser appear very made is that. To let you. Whose lights image. Grass can't. Whose multiply after.";

//        String testmessage="attackatdawnthisisatestmessage maybe this is longenough now";
//        testmessage = testmessage.toLowerCase();
//        testmessage = testmessage.replaceAll("[^a-z]", "");
//        int k = CaesarAnalysis.bestGuess(testmessage, Analysis.ALPHABET);
//        System.out.println(k);
//        System.out.println(caesar.decrypt(testmessage, k));
//        double sum = 0;
//        
//        double[] norm1 = Analysis.normalizedFrequencies(caesar.decrypt(testmessage, 0));
//        double[] norm2 = Analysis.normalizedFrequencies(testmessage);
//        System.out.println(Arrays.equals(norm1, norm2));
//        System.out.println(testmessage.equals(caesar.decrypt(testmessage, 0)));
//        System.out.println(VigenereAnalysis.bestGuess(vig.encrypt(testmessage, "test"), Analysis.ALPHABET));
        KeyedCaesar kcaesar = new KeyedCaesar("avain");
        KeyedVigenere kvig = new KeyedVigenere("avain", Alphabet.ENGLISH);
//        System.out.println(kcaesar.encrypt(testmessage, 6));
//        for(char[] array:kvig.getKeytable()) {
//            System.out.println(Arrays.toString(array));
//        }

//        System.out.println(Alphabet.SUOMI_CAPS_CHAR_INT.get('B'));
//        OmaHash<Character, Integer> capsHashTest = Alphabet.SUOMI_CHAR_INT;
//        System.out.println(capsHash2.get('B'));
//        System.out.println(capsHashTest.get('B'));
//        System.out.println(Alphabet.removeAll("abcdefghijk", "cfg"));
//        System.out.println(vig.encrypt("a a a a", "abcd"));
//        System.out.println(vig.encrypt("aaaa", "abcd"));
        String ciphertext = kvig.encrypt(testmessage, "passqwert");
//        char[] abc = new String(Alphabet.SUOMI).substring(0, 10).toCharArray();
        char[] abc = new String(Alphabet.SUOMI).toCharArray();

        for (int keyLength = 1; keyLength < 11; keyLength++) {

        }

//        double[][][][][] avgs = new double[20][11][abc.length][abc.length][20];
//        
//        for (int i = 1; i < 20 + 1; i++) {
//            //iterating through coset length
//            String[] cosets = getCosets(ciphertext, i);
//            int cosetIndex = 0;
//
//            for (String coset : cosets) {
//                char[] mod = abc.clone();
//
//                for (int j = 1; j < 11; j++) {
//                    //keys of length j
////                    System.out.println("key length: " + j);
//                    char[] mod2 = mod.clone();
//                    char[] bestMod = mod.clone();
//                    for (int k = j - 1; k < abc.length; k++) {
//                        //iterate alphabet
//                        int apu = KeyedVigenereAnalysis.find(mod2[k], mod2);
//                        String vanha = (new String(mod2)).substring(0, j - 1);
//                        String uusi = String.valueOf(mod2[apu]);
//                        String jaljella = Alphabet.removeAll(new String(mod2), (new String(mod2)).substring(0, j - 1));
//                        jaljella = Alphabet.removeAll(jaljella, uusi);
////                        System.out.println(
////                                vanha+uusi+jaljella
////                        );
////                        System.out.println(vanha + " + " + uusi + " + " + jaljella);
//                        char[] newAbc = (vanha + uusi + jaljella).toCharArray();
////                        double min = Double.MAX_VALUE;
//                        for (int l = 0; l < newAbc.length; l++) {
//                            if (i == 1 && j == 2 && k == 0 && l == 0) {
//                                System.out.println("wtf");
//                            }
////                            System.out.println(coset);
////                            System.out.println(l);
////                            System.out.println(newAbc);
//                            double est = CaesarAnalysis.getNormalizedFrequenciesSum(coset, l, newAbc);
//                            avgs[i - 1][j - 1][k][l][cosetIndex] = est / newAbc.length;
////                            if(est<min) {
////                                min = est;
////                            }
//                        }
//                    }
//                    mod = bestMod;
//                }
//                cosetIndex++;
//            }
//        }
//        double[][][][] avgs2 = new double[20][11][abc.length][abc.length];
//        double min = Double.MAX_VALUE;
//        int[] indexes = new int[4];
//        for (int i = 0; i < avgs.length; i++) {
//            for (int j = 0; j < avgs[0].length; j++) {
//                for (int k = 0; k < avgs[0][0].length; k++) {
//                    for (int l = 0; l < avgs[0][0][0].length; l++) {
//                        int nonZero = 0;
//                        for (int m = 0; m < avgs[0][0][0][0].length; m++) {
//                            Object testing;
//                            testing = avgs[i];
//                            testing = avgs[i][j];
//                            testing = avgs[i][j][k];
//                            testing = avgs[i][j][l];
//                            avgs2[i][j][k][l] += avgs[i][j][k][l][m];
//
//                            if (avgs[i][j][k][l][m] != 0) {
//                                nonZero++;
//                            }
//                        }
//                        avgs2[i][j][k][l] = nonZero != 0 ? avgs2[i][j][k][l] / nonZero : avgs2[i][j][k][l];
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < avgs2.length; i++) {
//            for (int j = 0; j < avgs2[0].length; j++) {
//                for (int k = 0; k < avgs2[0][0].length; k++) {
//                    for (int l = 0; l < avgs2[0][0][0].length; l++) {
//                        if (avgs2[i][j][k][l] < min) {
//                            min = avgs2[i][j][k][l];
//                            indexes[0] = i;
//                            indexes[1] = j;
//                            indexes[2] = k;
//                            indexes[3] = l;
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(indexes));
//        System.out.println("best passphrase length: " + (indexes[0] + 1));
//        System.out.println("best key length: " + (indexes[1] + 1));
//        for (int i = 1; i < 20 + 1; i++) {
//            String[] cosets = getCosets(ciphertext, i);
//            String keyGuess = "";
//            for (int j = 1; j < 10; j++) {
//                double minKey = Double.MAX_VALUE;
//                char bestKey = '#';
//                char[] modAbc = Alphabet.SUOMI;
//                for (String coset : cosets) {
//                    for (int k = 0; k < 29; k++) {
//                        String keyGuess2 = keyGuess.concat(String.valueOf(abc[k]));
//                        char[] mod2 = modAbc.clone();
//                        int apu = KeyedVigenereAnalysis.find(abc[k], mod2);
//                        String temp = (new String(mod2)).substring(apu + 1, mod2.length);
//                        mod2 = keyGuess2.concat((Alphabet.removeAll(new String(mod2), keyGuess2))).toCharArray();
//
//                        if (j == 1) {
////                        mod2 = String.valueOf(mod2[apu]).concat((new String(mod2)).substring(0, apu)).concat(temp).toCharArray();
//                        } else {
//                            System.out.println((new String(mod2)).substring(0, j - 1).concat(String.valueOf(mod2[apu])));
//                            System.out.println(j + ", " + apu);
//                            if (apu > j) {
////                            mod2 = (new String(mod2)).substring(0, j - 1)
////                                    .concat(String.valueOf(mod2[apu]))
////                                    .concat((new String(mod2))
////                                    .substring(j, apu))
////                                    .concat(temp).toCharArray();
//
//                            } else {
////                            mod2 = (new String(mod2)).substring(0, j - 1)
////                                    .concat(String.valueOf(mod2[apu]))
////                                    .concat(temp).toCharArray();
//                            }
//                        }
//                        System.out.println(new String(mod2) + ", " + apu);
//                        String g = VigenereAnalysis.bestGuess(coset, mod2);
//                        //modAbc = 
//
//                    }
//                    keyGuess = keyGuess.concat(String.valueOf(bestKey));
//                }
//
//            }
//        }
//        testmessage = kcaesar.encrypt("testmessage", 0);
        ciphertext = kcaesar.encrypt(testmessage, 0);
//        Object[] testObject = KeyedCaesarAnalysis.bestKeyRecursive(ciphertext, 5, "", Alphabet.SUOMI, new Object[]{Double.MAX_VALUE, 0, ""});
//        System.out.println((double) testObject[0]);
//        System.out.println((int) testObject[1]);
//        System.out.println((String) testObject[2]);
//        kcaesar = new KeyedCaesar((String) testObject[2]);
//        System.out.println(kcaesar.decrypt(ciphertext, (int) testObject[1]));
//        System.out.println(CaesarAnalysis.getNormalizedFrequenciesSum(testmessage, 28, "abcdrefghijklmnopqstuvwxyzåäö".toCharArray()));
//        System.out.println(21.16567920373602/29);
//        System.out.println(CaesarAnalysis.bestGuess(testmessage, "dceakbfghijlmnopqrstuvwxyzåäö".toCharArray()));

//        OmaTuple[] oTup = new OmaTuple[5];
//        for (int i = 0; i < 5; i++) {
//            oTup[i] = new OmaTuple(i, abc[i]);
//        }
//        OmaTuple[] sorted = KeyedCaesarAnalysis.omaMergeSort(oTup);
//        System.out.println(Arrays.toString(sorted));
        ciphertext = "Neglectfully according lost naked boastful out a grasshopper properly more dear broadly more lucratively dalmatian boisterous more patted yikes where untruthfully oh less yellow mongoose giraffe evasively before indiscreet far the robin toucan jeez as ostrich badger lusty yikes learned on splashed ocelot some wow wow less more a far and hummingbird past ouch crud this according a one tranquilly overcast copied well some abortive more more one or the and sheep that saw less that did amorally harshly that majestically punitive below plankton and tactfully goodness when the euphemistic along much less oriole far alas nobly black talkative imitatively.\n"
                + "\n"
                + "Popular sensibly poured less dauntless far a gosh queer forward sociably and while thanks that under outsold playfully this more harsh petted gosh far emoted aristocratic well some hello much but wisely wow literally hey dear komodo globefish hey jeepers up overthrew regardless less well yikes more hired cut after mighty or some won toucan that fearlessly dubious that together fox less and a fumbling outside while among fell alongside advantageously raunchy from untruthful mockingly past wretched stank far other jeez deer a wow gosh masochistic outside far or rebellious crud before preparatory lucrative much licentious dalmatian the joyfully the.\n"
                + "\n"
                + "A this woefully buffalo some well until busy much abnormal measurable some one hare much parrot excepting whimpered the because sheep whistled that caught a some a via that cheered aside this less one tarantula anteater lustily oh dolphin gecko alas richly one emu so fitting ground alongside versus however this where as more a oppressively notwithstanding a nonsensically solicitously hey around out darn this far darn left alas much serene vengefully far blind much and well unheedfully far slick caterpillar adjusted more impudent lackadaisically crab as and bit slung some alas bastardly one well manatee diverse kindheartedly wow far.\n"
                + "\n"
                + "Until crud amused due underwrote hello noiseless beauteously as unlike poor alas laborious jeez wound on after prior underneath when the sang selflessly dainty lopsided outside dragonfly far ouch well along abandonedly emoted much rigidly because a bound nimble so as wetted lusciously much jeepers rhinoceros far fish taught hello until satanically the wherever piously much tarantula some wanly crud dismounted grasshopper wedded hence a black until paradoxical panda more where woodchuck rattlesnake far blew darn far and jeepers hilarious hello stared jeez swore pleasant macaw one sentimental zebra snorted studiedly less at far far prudently less much incoherently by.\n"
                + "\n"
                + "Yet darn as alas rosily against as much frankly as one rabbit between anteater much warthog ouch much weasel grimaced one labrador this consoled more a spent placidly less and confusedly fish pleasantly illicit faint far tapir so queer abrasively stiffly overtook up but unselfish the re-laid on a taped congratulated and far one opposite suspiciously some together scallop dove coughed sewed far egregiously dazedly insect hedgehog hello mysteriously directed far that far flamingo titillating querulous more intricately wise touched proper taught fought and reran jeez crud less a fortuitous that grudgingly a despicable upon one so hence bird and.\n"
                + "\n"
                + "Pouted much ferret inset ingenuously inconspicuously jaguar nerveless laughed dwelled wherever orca clear goodness dominant much aboard vain into beamed the far crud tendentiously at oyster scurrilously octopus silently beneath crud gosh the metaphorically insincere distantly added a one intellectual quaintly for suspiciously gosh because jeepers house much stormily much vindictive wow by this that however considering shivered this trimly the and this however a diligent fidgeted divisive sank hatchet over darn labrador some as triumphant circa trout this mean undertook that far struck hey lobster that goodness and knelt flew the lied honey or insincerely dependent indecisively gosh so.\n"
                + "\n"
                + "Strode and thus bridled around more then gallant harmful contrary far bleak amongst forward expansively far rewound grizzly bound jeepers much hey impotently crud considering away darn constructive this hello lighted for lion enticing well far gallant ferret darn well gagged jeepers brief editorial after far dismounted yet after hello tonelessly reindeer more lantern oh maternally forcefully mounted depending excellently contemptible yet dark nightingale wicked bred more due haughtily broke this and during robustly hound less jeepers goodness occasional blank however under some while according against and and far penguin much much abundantly more ungraceful neutrally mannish dear one unique.\n"
                + "\n"
                + "Goldfish garrulously much dear darn however dear and bound against inconsiderately human far inflexible between peaceful hatchet far the because earthworm far excluding less rashly because immaturely dachshund astride and sheep stingily urgently unsuccessfully the royal globefish flew goodness infallible up goodness hung did husky stylistically salamander jeez slack mumbled jeepers heroically re-laid thanks thus hardheadedly before less more ouch this jeeringly savage out some understood elephant yikes plankton consistent bought haltered squinted when salmon including crud a jeepers far less ordered sprang one therefore along ouch in when customarily shameful lopsided ardent this convulsively a credible thus far fallacious.\n"
                + "\n"
                + "Alas the this sneered this yikes towards peculiar crud jeepers and into that wow emphatically far manifestly because read abusive much along much otter grasshopper that goodness so dear up compatibly following the much tortoise some while jeez in ouch the the on hey below swept bucolic more far lantern wherever more one necessary some much beyond smiled sped indifferently mysteriously telling forbade far warthog epidemic arrogantly examined cooperative seagull essentially this jellyfish hungry darn walked some wherever thanks hey porpoise irrational broken much within the more far gosh hence the pitifully far a to oh vulnerably dove some pointed.\n"
                + "\n"
                + "Reasonable and depending manta along burped yet beneath elephant and knitted pangolin far the after oversold swore frenetic a coarsely jeez this gratefully and inanimate heron messy this into macaw so one and kiwi onto forlorn because jeez that and much alongside voally a lantern laughingly near wherever crud busted that python nightingale cuddled far goodness adventurous this some oh dove heedlessly dear this lingering creative pangolin oh constantly much wolverine the rolled much more one lent before much steadily goodness one as crudely led black listless that impala until blanched burst wry less inset pled ripe contrary and goldfish.\n"
                + "\n"
                + "Less labrador flagrant clung close one therefore onto hired hey befell clever where absentmindedly less according hectically this beseeching much skeptically grizzly methodically the firmly shuffled yet deliberately dishonestly longing more cockily when sensitive supp sexy meager and more darn jeepers overhung but whooped less far far much studied a and bald a cockily this beneath dear some some unobtrusive felicitously labrador hence the much manifest far the one regardless and oh alas far rooster overrode some past sober fish miraculous well shark ape one was far and some far that more spelled misread far helpfully redid ravenous knitted more.\n"
                + "\n"
                + "Furrowed much ate much right suave gallant jeez resplendently more and some wow turtle less cutely chose yet or vigilant because serene one selfish across this oyster floppily athletically blind crane severe reluctant the alas overcast the walrus kookaburra jeepers admonishing one away invoked wow outrageously well black and until underneath a outside in loyally snorted and however much far krill ouch excepting much bland far far much cow egret inventoried cleverly jeepers much save avoidable and wherever ethereally kneeled extensively impala wittily methodic that repeated hey despite abusive therefore forward less fiendishly rigidly rode below horse begrudgingly a wherever.\n"
                + "\n"
                + "Snickered barring less bombastically at mellifluously while insect supportive heron due hey folded eccentrically cat armadillo before mawkish licentious wantonly pill unkindly hello less amenable commendable salaciously laggardly versus some far above much well jealous shrank waywardly and avaricious wore jeepers however unicorn blanched one disbanded hazardously less added alas and frequently some depending where kissed tortoise hugely because jeepers giggled more after convenient abiding glowered messy that this smelled picked overabundant minimally as outside wildebeest past next woodpecker therefore close broken yet struck astride naked that dolphin much ecstatic less chose that and fed cutting so juicily sulky dragonfly.\n"
                + "\n"
                + "And pesky doggedly fidgeted about less more therefore much cuckoo dubious this and less gave baboon carnally however smoked victoriously much hedgehog unlike that sensibly immodestly in hen hey stuck disbanded objective fulsome educational shrank jellyfish momentously goodness a depending that hippopotamus resigned past flexible scallop leniently pending and cagily much spluttered amid anteater lantern much more much goodness partook via and fiendish cautious thanks needless solicitous alas forcefully less wallaby futile darn thus dealt up weasel much so less free much oh caustically hen however mandrill this because purposefully fish jeez shark indisputably until chose that the one oh.\n"
                + "\n"
                + "Much well much far far magnanimously retrospective until lividly baboon melodious and dear chortled suspiciously much the the useful lantern wow along man-of-war groundhog and more tiger until some knowing leopard alas less so and chameleon and amazing without jeepers and sped crab much flamingo lugubriously oh far lantern snuffed one flauntingly the conic less that this connected normally far dear invoked alas falteringly much some more following one labrador far along sexy so dear statically wherever and more across completely gosh one with away wrung owl jauntily some and far walrus and oh a other disbanded and as one.\n"
                + "\n"
                + "Cow darn and howled eagle abandoned wow much hedgehog far some weasel much flagrant horse well salient as congratulated and laughed yellow unlike cheered rat that underlay salmon whale that urchin beneath or much when above crud after instead a pointed and where that the seagull poked among hedgehog well oh this or with echidna yellow tenacious from far chortled much that and imperatively oh noisily and darn other oh newt far joking on despite rampantly hey smooched dolphin read equitable cobra boa some glowered tactfully less rhinoceros directed grudgingly gent a beyond a and or cuddled alas terrier because.\n"
                + "\n"
                + "Baleful cagily vehement thus towards reciprocating ravingly and this kept this crude wow impetuously oh fumed much and repusively crud darn a spiteful and purred up more goodness built far icily sulky incoherently fell together soggily much one jeez spilled amidst raccoon deft a human regardless darn adjusted much much much earthworm meretricious much deceivingly less far and so that spent impudently hey crud but some knitted rooster this some peaceful oh and thus curtsied cautiously clearly without a much man-of-war panther much lurid a since underwrote scallop more thus a much one goose wept when tragically while since wallaby.\n"
                + "\n"
                + "Delicate spread far much oh mumbled lobster according far mechanic up blamelessly growled dear guffawed more precariously after crud was examined the hyena feeble sweeping cardinal snuffed bent that crassly on darn darn slowly goodness gawked this securely regardless hey jealously insecure goodness much near confessedly far wise seal yikes mute cowardly firefly less incredible bound some mallard faulty wherever jeepers yikes conjoint and around otter far one the wow opposite and one sociably much much a bat gazed knew yikes barring and less hence jeez agonizingly gnashed this humbly impious yikes bought bore following darn knelt more hey inside.\n"
                + "\n"
                + "Alas dull and built editorial one near erect hey hey luridly much in much poetically honey alongside the that ouch beneath handsomely much moaned some that portentously the cleverly gosh inside but one gosh more hey mistook famous one much more adeptly pending orca forward forlornly or tangibly on much crud much and perfectly where tentative wow licentious darn cut and macaw sleazily much owing alas less some where and divisively less since a caught one heard since as tedious boisterously forsook or kept this far more tepidly far some nudged some clumsily involuntary lubberly more in well crud leopard.\n"
                + "\n"
                + "Wrung warthog broadcast assentingly oh painful darn and nightingale a onto a dachshund far the poked a exquisitely walking goodness within that far much dropped opossum involuntary ragingly reindeer much some sardonically oh jocose sat nightingale less lied virtuously oh outbid jeepers by before and lustily hugged sprang when a when practicably gazelle voluble unlike much less the saucy excepting and this bombastically flawlessly and luridly wow jeez including much ebulliently yet buoyant less as much far magnificent jeez rosy after fleet terrier snorted more hello jeez in charming however this far and thus the over therefore inside frisky much.\n"
                + "\n"
                + "As more sewed knelt abysmal while that until dog alongside panther jeez hen dauntlessly far random much before wombat stormy some pouted coasted up iguanodon less forewent spat therefore quetzal outside gazelle and wow in lucid while indelicately mammoth frowningly well and so due therefore gosh insincere dynamically jeez up poked much a hence obsessive as turgid rebound mallard softly triumphantly regardless after cassowary shuddered pouted ahead ouch beaver alas tunefully this so gibbered less handsomely some hey bound wildebeest far darn jeepers one picked a this glared rare ceaselessly and far into into meretricious jeepers before since resignedly sat.\n"
                + "\n"
                + "Excepting irritably goodness tiger much less honey thus interwove panther therefore notwithstanding gazelle flat invoked dull hung bucolic much sourly bat far much telepathically blindly alas less inappreciable oh but nastily guarded one thus foresaw slung more upon more evident tranquil among reliable quetzal perilous darn caterpillar yikes by egret and from a hence since irksomely and starkly lion this cringed ape darn reran the because much together squarely leopard much apart yikes much overate oh charming the hippopotamus jeez overrode dogged vigorous one and before frog eminent but this goodness up marginal glared lovingly while heinous juggled oh thus.\n"
                + "\n"
                + "Caterpillar gibbered before where frequent had outsold one a balked this oh save alas dear archaically less indicative emu following fit cackled goldfinch well when and more much much so darn adroitly in informal that the gosh darn checked explicitly unlike cardinal including komodo blessed mumbled destructive blindly save squid excluding gosh dissolute fraternal crud far advantageously sedulously far due furtive far over so gloated well outrageous gosh that goodness crud so in grasshopper perfect flinched ouch jeez a far brave resignedly much jellyfish far spilled impartially thanks climbed close aboard read less despite hey so far much oyster bandicoot.\n"
                + "\n"
                + "Alas inside returned far much alongside sped some and more cowered vindictively gorilla cut swore some forward yikes some less this symbolically indecent this less some until hey cagy input diverse goodness chose far dear owl on indiscreetly this more toward then and unlike gosh out that trout alas positive tacit ocelot despite dominantly hello mallard vicious therefore manta restfully therefore sewed exquisitely meagerly and as mammoth on this resigned lighted bit furtive and menacing goodness stopped smirked derisive in enticing instead moistly illicit dear well other aside one however one maliciously more around gave sorely far this gosh one.\n"
                + "\n"
                + "Gave slattern when became aardvark that scorpion mischievously snickered abiding ruthless and one treacherous some wonderfully tactfully irresolute wonderfully oh funny tolerable less neutrally scorpion one forbade alas the goodheartedly opposite much cast dug haughtily upon affecting that oh fed after sparing this tamarin wept during sniffed manifest hey yikes slid unlike rattlesnake dolphin far less incapably snuffed then tersely dug grasshopper dear gloated with or yikes and quetzal far this much so more hectic the yikes kiwi composite virtuously hen contrary far and bat fumed much owl where intricately one squid much parrot but mounted abortively where this packed.\n"
                + "\n"
                + "For and then out and yet right babbled the so a expansively glumly jeez off flexibly hence jeez more dominant gasped showed some avoidable alas far shot a and leapt one heartless a therefore one beaver winced alas less ordered moral this relentless since the tiger gazelle much turned according threw carelessly tamely darn inside oyster followed well rattlesnake until ouch on upon tart in curtsied wherever one abortively next roadrunner under some shrugged laxly morbid this frenetic the while far rhythmic solemn well during warthog some excepting jeez closed kangaroo indecisive gecko some adjusted wow up ocelot and activated.\n"
                + "\n"
                + "Spelled since circa when tirelessly through however less against alas some where fruitless and more tunefully far the beneath more unjustifiably that honey significantly nutria one hey insect unlike thoughtful dear jeez mawkishly as proud sank lizard variously cuckoo wedded much a where gorilla wrote the weirdly one fish contemplated tortoise about less owing more and the oh this fallibly hey garishly up jeez examined before far this less far haltered taught desperately and splashed one contrary overslept overslept aloof underwrote tackily beside and tediously before more that yikes caterpillar thus hence much metaphorically alas that limpet yikes or where.\n"
                + "\n"
                + "Man-of-war this bird shark and cassowary goodness while goodness grinned coasted sped hence barbarous amidst close hey more that jeez that and meadowlark ferret admonishing yet exquisite apart far thanks one a some less much wholeheartedly the more like the dear this strewed wetted one dipped a bald groundhog nightingale smiled regardless unbridled dear barring became one much and dishonest sorrowfully much unsaddled some far that well to and yikes more that ashamed the about despicable wildebeest at gaudy jeez across let this circa much attentive cackled in nobly superbly less one when in alongside before tidy aardvark or sexual.\n"
                + "\n"
                + "Much darn without jeez away insistently tyrannically far more swelled hideous jay sloth irrespective and divisively spiteful for scooped artificially and yet cogent yikes darn and however about darn painful goodness opposite like in far so seal goodness human the spacious much towards as guinea caterpillar this ashamedly hedgehog guinea much the activated amongst this pleasant earthworm bent lost unblushing pithily however up enviable whistled wildebeest sped stared since some perversely alas swift one before and responsibly whimpered ostrich much hey far far goodness goodness extrinsically and gloated a camel more rooster cantankerous more woeful until but intrepidly far strict.\n"
                + "\n"
                + "More yikes shrugged smelled far wallaby breathlessly remade beat about like grizzly together felt hey indicatively bestially one crud ostrich bore flabbily awful and when porcupine less darn the far yikes far did in crud forward reined alas goodness as across over scornfully trout gamely more and beside excluding that jeepers gosh up imprecise without alas spryly absurd fanatically far less beside because so frisky on until jeez much heron jeez opossum ladybug lizard as while far sold one darn and on krill much and much and some well bird oh lantern more inside one tacitly snickered until eagerly stolid.\n"
                + "\n"
                + "That specially conically bewitchingly a naively furtive one or constructively so a dear crud unlike laconic some some therefore willfully wow this sanctimonious aside much some far gnu more jeez wherever well this a that more far tenably but wow more devotedly much thus and pending egret casually reliably abysmally smelled thanks far shook sobbed furtively dear continually vociferous outside one newt firefly winked much this fallacious spacious far where measurably doused up moaned broke hippopotamus oppressive walked irrespective a hey instead rode during sought and shameful smooched a cosmetically the less more clever the erotically reindeer petulantly since urchin.\n"
                + "\n"
                + "Said one dear some some after glowered clapped rewound wherever so for baboon greatly hello kiwi wetted yet unlike eagle yikes and this closed this impudently wound more diversely diplomatically porcupine the much the lorikeet zebra less insincerely hello the meant much much gecko shed at regarding powerlessly towards hamster and and scallop rare more up frisky and smugly inverse nutria jeepers a hey then ladybug far courageous via some wow outside rooster contrary wallaby much a rode snickered crud before took forward alas studiedly baboon so ouch a hey much towards keenly along evidently wow and breathless this in.\n"
                + "\n"
                + "Since disgraceful ouch much the one wetted a so augustly that strenuous especial absolute and much dizzy since more much lizard far and gosh therefore excitedly notwithstanding a cuddled some armadillo wow frowned sedulous much noisily cost over within therefore bawdily inappreciably ferret implacably darn sordid other via whispered crab far gecko ripe decidedly orca egret near much restful hilariously much thus spoon-fed intuitively cliquish jeez despite far via tensely ritually sought lobster firefly much hey up fishy grievously kangaroo wow pending oh much darn porcupine fancifully aardvark inside gosh yikes ebullient recast hedgehog much strangely this mild behind far.\n"
                + "\n"
                + "Owl this cow enchantingly untruthful zebra behind and arrogant inside fawning far ouch gosh far against until this hey enviably ouch rattlesnake yellow far otter criminal hence ferret outside unsuccessfully versus gosh victoriously that that euphemistic less turtle curtsied hello mandrill far this cuddled erratically sordid mislaid rang yikes reset much yikes woodpecker that fought hello re-laid oh coquettishly one alongside towards and gosh the horse oh yawned supreme groaned and much this otter darn sanctimoniously then oriole that jeepers like much vain thin this and underneath dizzy lynx so oh huge but coarse before bridled a but alas a.\n"
                + "\n"
                + "Crud rapid jealously then this ritually dear dalmatian shivered next in the wrote far owing and wolf inside before well more beside far oh musically darn chivalrously slovenly due expeditious gosh tidy less wow rebuking rolled intricate much greyhound shot split ostrich and that comfortably sullenly caribou robustly shrank murky jeez less some qualitatively following much wild winked jeez more ahead heated approvingly scallop human yikes plankton bred stretched giggly juicy froze acceptable that and and trustful oh more hummingbird less a out coquettish contrary that much iguana much and more more outside up sensitively between some far where and.\n"
                + "\n"
                + "Far submissive far possessive since inoffensive far far flexible intellectual the arduous impatient and hey garrulous where jaguar horse crud deer where prudent grasshopper self-conscious undid crab indiscreet spent made beneath before alongside and thanks monkey much magic piranha waked more clinically a the checked saluted stank some hey groundhog flirtatiously hence faithfully more much and grunted resold spoon-fed annoying angelfish besides mistook excepting below this so caterpillar on added however immediate ouch and boa angelically unspeakably grizzly tearfully woolly next however comparably ruefully beyond before more lighted hen thin much one barring about scallop raunchy abrasively some along gasped.\n"
                + "\n"
                + "Cut robin bawdily much and forbiddingly ferret hello so porpoise tunefully crud as and stylistic hello wherever gulped boundlessly outside some awakened within steadily mistook after joyfully fatal the one and much but so alas far brought extravagant egregiously goodness exuberant inanimately leaned far darn other far in that gloated egret this then apart groaned jeepers vehement much jeepers along wow alas sadly fallacious and some unblushingly lantern less goldfinch drove rewrote much dear well walking porpoise drew warthog piously deceptive bee hello hung invoked and where less oh well more like as spryly plankton past concentric crud thought that.\n"
                + "\n"
                + "Across under goodness in reran as well raucous fuzzily slowly limpet wasp greyhound hen some minute up goodness wherever the laboriously this tamarin then oriole much foresaw on a lackadaisically more contritely a dim beneath a purred outran less purred much cockatoo so much muttered far one crud despite jeepers disconsolately tenacious less far strictly and rewrote apart cheered the gurgled after blissful excluding objectively away and stupid besides sudden sluggish sparingly gosh other crud shark far jeepers husky in towards opposite hedgehog then strung less grimaced amidst much gosh forward mellifluous astride and extravagant jay inclusively that gosh opposite.\n"
                + "\n"
                + "Yet seagull aboard conclusive krill through and practical the goodness yikes elephant by out wetted caterpillar against walked locked re-laid and advantageous antelope goose the turned well the basically winningly so upheld some yikes suddenly this yikes convincingly forewent and thanks lethargically hello cattily but otter as the skimpy alas turned goodness removed after excluding together suggestively hamster deft dear until promiscuously purposefully oh occasionally circa more egret wildebeest broadly lion squid additional via mammoth one gosh jeepers insincere yikes antagonistically cobra cat hired gosh and a mastodon in reran crud raccoon lied gazelle via ostrich temperate far crud more.\n"
                + "\n"
                + "Less alas luscious jeez goodness and freshly circa the ungraceful noble excluding and grasshopper hamster antelope nasty much pungent more because far goodness parrot or bawled studied amid and the well and yikes drove hey when infallibly including surreptitiously intuitive darn feebly contemptible one crud decidedly mandrill grabbed thus preparatory darn this less grossly mallard fitted lemming darn a fatally continually darn save less hello this sniffled a much hey some yikes esoteric touched unselfishly since and ahead across woolly darn after next poured some until elephant ouch that amidst some inside swung the the boa cassowary supply and much.\n"
                + "\n"
                + "Animated however privately in oh sobbed embarrassingly gnashed ouch together prudent danced along wow a yikes more the tasteful so far insolently perfect inside this less behind man-of-war miraculous considering muttered rolled expectantly and and cowered stuck tyrannical towards contrary snooty until negatively more unlike fox darn vociferous some cutting broadly away well strangely strategically sank one together desirably oh dear partook peculiar alongside a husky a as dropped adjusted some less much exquisitely some krill wonderfully the gazelle well hawk anxiously firefly by viscerally flamingo modest conservative drooled destructively jeez on danced much cavalierly behind found invidious wherever skimpily.\n"
                + "\n"
                + "Dear more the oh up dipped off considering hence the overate candidly more carnal more this however resentfully mighty when snuffed repaid as and acceptably crud a around laxly nutria then much since until firefly to insect wow thanks more dealt including darn faulty wore resolutely yikes above a connected despite wherever outside therefore onto one seagull beseechingly hey cobra near unicorn hamster a wherever sheep onto jeepers wallaby scallop prodigious because below abnormal but far one more parrot before audible dragonfly porcupine soothingly the before far that as moaned much much prideful off arrogant crud moth dear wow doused.\n"
                + "\n"
                + "The fastidiously lewdly far thought bowed lusciously versus hello until egotistic frisky overate this diplomatically in cuddled that some far this far far much in crud some much simply oafishly ouch puerilely cow barbarous on crud some that some meagerly activated indecisive much however balefully hence met elegantly goodness anxiously octopus grimaced abrasively the the shot one belched regardless and far inside overran that duteous far swept insect under according strewed consoled save a the regarding hence the broadcast the dwelled as the unscrupulously far much zebra meticulously limply far baleful one after forgot much annoyingly bled aside the to.\n"
                + "\n"
                + "Forthright scallop ineffectively behind so far sneered tarantula keen inside the and notoriously pushed lobster dynamic since excepting aardvark epidemic but much cuddled slick read earthworm twitched gosh alas gerbil dubious yikes much monkey seal and considering some among because angelfish yikes some wolverine much near in more incompetent yet when felicitous scooped ignoble satisfactorily the a but hello oh much considering jubilantly well that unnecessary cattily hummed artistically unanimous nastily naked punctilious gawked jeez forlornly stood excluding and far yikes oh much cuffed this conservatively bravely wolf grew octopus tactful sensible turtle fraudulently naked yikes growled wow the smooched.\n"
                + "\n"
                + "Between atrociously unblushing much spacious the a reasonable far incredible and aside rash one radically hello wept some darn the positive alas wow express when until tore this wrote caterpillar this far and much instead far thick because that goodness forewent some in played far that bee closed much sought far came darn sobbed glowered much on alas heinous wallaby barbarously far busted and goodness together amidst far diligently peaceful up tacitly jeez self-consciously spelled caught true that darn far less blubbered instead wow unanimously that near a ouch some fresh hey and overheard other some much before derisive porpoise.\n"
                + "\n"
                + "The shined while wherever and following towards before goodness a at the and one since hey during quaint metrically ouch alertly yikes yikes powerless jeez chose wow alas elephant staidly gosh then jeez alas since lion goodness far depending avoidably because dear eagle however one far less subtle gosh eagle fell salmon adjusted far moaned then far well antagonistic when toward however bid cuckoo less fondly unobtrusive said ignorant rat admirably dolorously hound hey this toward quit sparing after kookaburra eel great over alas because a chuckled luscious until up after sighed lecherous mild led when thus some and dear.\n"
                + "\n"
                + "Then oh glared manfully enticing flamingo a fruitful got and hey save examined camel jaguar within this a dull yikes a trustfully much and breathlessly fish jeez grumbled hello that and around furiously so hello and impulsive underneath derisive newt more innocently lorikeet and jeepers belched some while the during human sardonic glanced that pouted inversely far perfect barked one fraudulent sweepingly far noiseless far naked flustered in fruitfully the perceptibly until eerily insecurely warm loyally tapir consolingly hid boa wherever crud howled yikes poked this wow after beaver consoled one goodness vulnerable one goodness much the that hey that.\n"
                + "\n"
                + "Studiedly capable and far wherever dear but as therefore python earthworm hare into when via and and next where one less less parrot more much slept less this flexed peculiar and frog heated this thus less plankton against some before lovingly variously well less persistent emoted amidst one rose hence wiped beneficently this this much and this aboard and visually unbridled walrus until marked that wow joyfully sober tight awkward grotesquely static gnu dauntless wow the then pending while insolently far disagreed wryly and abominably cringed outbid splendid monogamously far shook much circuitously up far however less yikes shuffled pill.\n"
                + "\n"
                + "Inside thin while joking among where until koala notwithstanding amid falteringly so picked more unscrupulous yet one alas much adeptly rattlesnake hound one outsold jeez less ouch penguin falcon and less beheld ambitious since far jollily forwardly dear unanimous jeez overshot frowned lemur subconsciously unexplainably scratched far less spent therefore therefore re-laid jeez so far elephant wow far before so up weasel whooped a rabbit horrendous indubitable inset gosh fed until and rankly and more much yet kangaroo this hey diligent less crud hatchet regardless tonal unwound over therefore cockatoo at floated spun much exulting stingy the much fruitlessly ruminant.\n"
                + "\n"
                + "So cavalierly that tireless grudgingly hey this this fish goodness so oh unlike sore confused abashed darn less that so monkey wow due some about stringently this that grateful according sheep toughly that forthright in wow tonelessly this towards rat that much glowered meadowlark factually more wow safely frighteningly where took jeez naughtily far the and manful evil snickered wrung one leered because unicorn less far awfully hence one and this more hence onto before gent danced much before on much tapir honey heron so raccoon that far feelingly lantern then away about some surely peered ahead save one more.\n"
                + ""
                + "Parrot dire oh bombastically that that wrote while far far swift hey dog badger yawned much mislaid gibbered owl redid wherever and fed anteater contemptible garrulously juicy opposite that incessant jeepers royally innocent a instead by jeez that moth beat and crud a far far and much truculent altruistic much charming when much solemn well smiling factious including that crud jeepers the overhung more humbly a while hen much practicably lion between hey goldfish gosh elephant fabulously about engagingly happily parrot agonizing goodness cheered before one next less paid enviable re-laid about about and wherever that gosh and scowled cobra.\n"
                + "\n"
                + "That dismally that out thus proved komodo nonchalantly that gosh bald so through next conscientiously and cooperative fed aside yet nonsensical resold much the goodness yet pangolin and amenably honey after more alas walking matter-of-fact and a punitive oafish jeepers rode on one a close wow spluttered pending whistled cuddled that hey including fox goodness at amid tersely this grabbed ostrich hello goodness concisely wherever well ludicrously impeccably that other whispered on this along much attentive imminently invaluably newt before much hiccupped walked and the mammoth gull hey kissed did deceptive hyena that and for unlike thanks one demurely hey.\n"
                + "\n"
                + "More and with ouch annoyingly misunderstood bent and much when much inaudibly dipped goodness owing cuckoo furious hiccupped pending much sobbed far dear took garishly that one llama by after man-of-war therefore more more repeatedly excluding dalmatian inexhaustible hey regarding the arrogantly much quick woodchuck notwithstanding much retrospective despite far stingy mad well wow bore shrank reined this absurdly some because dauntless this when behind jeez since more on hey underneath jeepers some crane one much this adroit wherever this after darn worm past mad subtle stark said owl together aardvark since oriole or this up lynx at decided and.\n"
                + "\n"
                + "Ouch the additionally one near wombat goat opposite dear haggard rational much magically below darn alas much far lugubriously much fish far buffalo commendable much alas monumentally until up unreceptive undid intricately black yikes blank considering excruciatingly alas along antelope much crud kangaroo some usefully wetted astride shut glumly near spoon-fed impiously across less goat far jeepers bird that mallard much jeez more far this dangerously the flinched crud lazily hello outside penguin mongoose frustratingly against emphatic one less deservedly a after and some tapir frog outside one blew near relentless much parrot and crud on darn goose one close.\n"
                + "\n"
                + "After lion darn rebuilt irrespective shed where and some placed frowned far jaguar inside less much below much and atrociously alas misread yikes this far surprising extensive narrowly fox instantaneous quickly ahead disgracefully oh some more much far bred snickered the in jealous far jeepers set slatternly spat much capable less much jeez macaw abashed heron ahead greedy oh cheerfully that befell blank one the salaciously ouch dire while jaguar the much and some less infallibly more gibbered freely during bit found haltered some wow and hedgehog horse jeepers when some uselessly and that goldfinch put sloth however the inscrutable.\n"
                + "\n"
                + "Erroneous this the more empiric dealt near crud and abidingly put the additional honey roadrunner much condescendingly redid thus goat knew however much onto artfully and far alas dear and crud and brusquely rhythmically dear more brought until much into eminent ocelot ouch nudged oh accommodating in globefish childish grew off some incapable sent on dalmatian this and but wherever eerily black overslept lizard hello a man-of-war one walrus penguin one equitably clapped far where crud before and until dear the robin horse but ignobly far thus less groundhog after more far dear far dear smart alas much intriguing hypnotically.\n"
                + "\n"
                + "Yikes goodness less silent much turgid ouch obsessive the more underwrote yikes ardently adeptly greyhound chaste much lavishly dear uninhibited misread less charming excluding less mumbled impetuous lamely laughed much much jeepers more that hurriedly until nosily acrimoniously gosh some hey and abortive foolishly paid glowered dear that a the less more as activated when until globefish tonal by next that before submissively wolverine one greedily therefore and cut alas crud the picked bound because incessantly opposite suggestively much divisive unlocked forbidding ahead well baboon censorious and rewrote upon the angrily oh incessant far that because thus more much a.\n"
                + "\n"
                + "Lingering oh repulsive some wore comparable since much advantageous ladybug overpaid this leered tragic far far stringent justly impala save loud spoke and rashly camel supportively less but darn far reciprocatingly jeez brought sensually less dangerous then less met faithfully therefore goodness came crud spread red-handedly jeez wow a octopus rebukingly or barring goodness irrespective this much mounted hungrily crab a circa slackly beside fractious much paid salamander globefish excluding mislaid mysteriously scallop chromatic therefore some porcupine expressly jeepers gnu mounted during a however some flapped therefore much jeepers growled and floated more this honey on gosh heatedly ouch save.\n"
                + "\n"
                + "Seal gloated because jauntily giggled gosh dear winked flipped where plentiful goodness so leaned continual ubiquitously flung picked this much dear snarlingly however rattlesnake drew that cast softly far labrador the outsold after wolverine yet crud save daintily evasive bat wasp dalmatian or that ocelot mammoth one the ebulliently gosh a concentrically so one jeepers auspicious hey sound hence on one jeepers inverse suitable across winsomely leopard oh since crud some far hardheaded underwrote alas impertinent thanks crud even juicily whooped tepid hyena pled much so and less badger this endearing dear far woodchuck heard goodness this maternal horse grievously.\n"
                + "\n"
                + "Mistook hen together a educationally acutely stingily cunning crab atrociously the endearingly until during dear invoked poignantly leopard but until less save neurotic remarkable jeez much together ferret much ceremonial one goodness epidemic far forgot more forward told one studiedly behind dear lazily hence armadillo up hey behind after and cat kindheartedly clung lazily wherever dealt much excluding frog momentously one oh convulsive so and mysteriously spelled labrador and cockatoo more insistent much hoarse robin excluding mallard jaunty this ineffective mournful outside therefore more ouch caribou some trim one oh however jeepers sobbed ouch much one yikes notwithstanding off much.\n"
                + "\n"
                + "Spurious conjointly a much much far extraordinary and a komodo gosh lobster cheeky shuddered tauntingly against correctly since as one lingering seagull cat insect due yikes morally and far stiffly notwithstanding sufficient much less crud poured debonair one so towards spluttered far since moral much hippopotamus much oppressive chameleon lax anticipative bridled haltered exited one loving groundhog cow and before because lubber amidst this alas gosh hey academically jeepers a or as put heartless a more a unlocked terse snootily jeepers wombat flat hey tedious reset around far wrung foresaw menially far yikes cutting one hence quick pessimistically jeez resold.\n"
                + "\n"
                + "Toucan and slapped less thus petulantly sold oversaw this one vainly alas much dug outside eternally sorrowfully fox went alas hence gecko grudgingly as depending far crud a yikes a sordidly demonstrable secretly flipped jay then one hen far the goat one orca immature that poked depending foolhardy alas octopus far bird a and blew jeez joyful some slid a grasshopper including and a cuckoo dipped hey suspiciously premature famous hypnotically greyhound sedately ouch jeepers less other and hey irresolutely far especial disagreeable dove opened squinted much groggily more much more gosh witty less egregiously tearful ladybug jeepers more capitally.\n"
                + "\n"
                + "A fumblingly for wherever elephant depending quail on less much swung cuffed towards naked angelfish thus and giggled wildebeest impatiently yikes hello slack unlike a the but chose far against then slovenly oh went so into and crud wow a badger and much unicorn that much this interwove a while hello that darn jokingly outrageously reindeer far the ouch the invaluably goodness much fox repeatedly dear slight amused fought chromatically and a across notwithstanding broadcast one far overslept much groundhog bridled dear one absently that less preparatory hence sympathetically crucial inside toward yikes impalpable interwove swift along more oh one.\n"
                + "\n"
                + "Cheerful yikes gerbil globefish less burned sordid echidna without played the monumental vulnerably much save forward dubious this fretfully and the the unaccountable this and far adamant the aside along because gorilla less beneath one after far more more unthinking snorted much a preparatory pushed and less up much goodness that hey exaggerated up a much terse picked bird lion and far cockatoo since whispered much cast and cowered jeepers menial effectively far giraffe some interbred thanks therefore ceaselessly dramatically a trod since as far exultingly and far fitted notoriously gosh much kangaroo alongside hence away that in naked far.\n"
                + "\n"
                + "Hello hamster according forward fortuitous swung less against abrasively sorrowfully metaphorically pathetically then cosmetic crud inoffensive jeepers that darn sordid far one leopard or bee via roughly cackled skillful a wildebeest savage tolerably warthog darn alas rolled excluding one according virtuously the far and maturely and since far earthworm nastily elephant that or while echidna some spilled garishly stopped hello some over yet stormily beneath glibly far over yikes strident winked jovial circuitously and noble epidemic less wombat a outsold until and shrank misled resentful until a well experimentally hey thus that and dear much subtly foretold slung this tediously.\n"
                + "\n"
                + "Jeepers belched bleakly cut crud wailed grumbled scandalously submissive however abidingly due and however jeez ape this confidently this hid fastidiously wide ostrich instead inconsiderately daintily until so far dubious fateful realistically that penguin that on mournfully flew away leopard however along including tapir tastefully that because well gregarious out therefore wide as far overate more overran in glum on a bet some the considerably as had alert much and abusive devilish hare grimaced outside that yet clumsily this and then due following beyond opossum hound menially versus gazed oh exorbitantly when jeepers jay serene chortled gerbil hen the judicious.\n"
                + "\n"
                + "Improper cozy because lighted legitimate strenuous certainly erratically goodness as alas far and emu crud overlay dear far insecurely more or or before read lucratively clever woolly inflexible less more lethargically hare rapid less fastidiously pending under goodness as yikes across some rationally oh yikes lyrically more blessed far until save far scowled heartlessly accurate boa one stupid jeez after abrupt and meticulous so therefore more cold much dalmatian during past airy goodness upon less hey crud manta alas less solicitous and well oh less jeepers sheep notably less fractiously indubitable darn through alas hilariously excepting satanic jeez until into.\n"
                + "\n"
                + "Some excluding menacing hit persistently more a darn indistinctly or ferret willfully a agonizingly less a badger upon when yikes far dizzy burped much far oh rewound one shed murkily leered intrepid dear ouch rueful wow fanciful far harmfully that some one far enthusiastic joyful inoffensive hey jeez furrowed beneficently more trout bat some one unceremonious dear far overcast less misunderstood far purred squid the but darn notwithstanding the much after hey gloated one like notwithstanding outside well much while that dolphin buffalo and darn gosh quail plentiful emu set contagious before foully extensively turtle crud noisily as cuttingly lightheartedly.\n"
                + "\n"
                + "Stung misspelled regarding plankton immediate poor hamster macaw therefore the tamarin wow this gosh so hey oh set empirically wide this far far doubtfully so one pill more in considering dalmatian dear by unbound one goodness one educational more waved far jeepers a guffawed goodness well jeepers zebra obediently hyena up apologetically much mockingly before slid this apt caribou waspish about crane this after much turned less until much partook onto intricately with keen while shuffled yikes after much up dear overran a until some vivaciously noiselessly komodo ladybug in or husky vulnerable on since the coasted rooster gosh murkily.\n"
                + "\n"
                + "Jeez belatedly misheard dove restful heroically conductive and much one conjoint arduous hey static conductive and and ground foretold stringent and overslept the rhinoceros then the a and goodness disgracefully porpoise some whooped jeez far much hello less wow mounted more oh armadillo rabbit gibbered hey gurgled lent thus while when up burst unexplainable superb hound and black altruistically lizard haggardly querulously unlike unhopeful tardy labrador thorough crud and befell misled and cuckoo slattern diplomatically goat trout up jovial exquisite one robin coyly hey some solicitously wretchedly aside and much misheard bandicoot and vigorously before some wow and true oh.\n"
                + "";
//        String testKCaesar = KeyedCaesarAnalysis.simpleGuess(ciphertext, abc);
//        System.out.println(testKCaesar);

        OmaHash<Character, Character> testHash = new OmaHash<>();
        testHash.put('a', 'b');
        try {
            OmaHash<Character, Character> cloneHash = testHash.copy();
            System.out.println(cloneHash.get('a'));

        } catch (Exception e) {
            System.out.println("hash copy failed");
        }

        System.out.println(testHash.get('k'));
        System.out.println(testHash.get('k')!=null);

        System.out.println('\u0000');
        
        System.out.println(-15 % 26);
        
        kvig = new KeyedVigenere("avin", Alphabet.ENGLISH);
        System.out.println(kvig.encrypt("this is a test message", "a"));
        System.out.println(Alphabet.removeDuplicates("avain", abc));
        
        KVigenereManualAnalysis manual = new KVigenereManualAnalysis(Alphabet.ENGLISH, 3);
        KeyedVigenereIO.printFreq("fty, fty, fty, fty, fty, fty, fty", abc, 0, 3);

    }

//    public String bestKey() {
//        
//    } 
}
