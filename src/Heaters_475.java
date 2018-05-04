import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-5-4.
 * <p>
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Heaters_475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int j = 0;
        int n = heaters.length;
        int min;
        for (int i = 0, length = houses.length; i < length; i++) {
            if (j == n || heaters[j] > houses[i] && j != 0)
                --j;
            min = Integer.MAX_VALUE;
            while (j < n && heaters[j] < houses[i]) {
                min = Math.min(min, houses[i] - heaters[j]);
                ++j;
            }
            if (j < n)
                min = Math.min(min, heaters[j] - houses[i]);
            res = Math.max(res, min);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Heaters_475 heaters_475 = new Heaters_475();
        int[] hourses = new int[]{85792839, 958717936, 602546911, 620537572, 987361350, 769047659, 472912098, 396653539, 766789685, 384870148, 291832672, 126552203, 392538800, 329848016, 100312005, 962183718, 869886516, 114005636, 537311128, 419392661, 691123973, 129051235, 591580331, 634316085, 841616887, 727720667, 674859182, 142626998, 540205334, 817672669, 669669308, 963244207, 513655963, 924487779, 821915608, 320806152, 250537625, 717915255, 84056870, 847058011, 627873492, 728117264, 105035442, 892094438, 847879759, 406606599, 544144639, 453578747, 524032557, 584749152, 993828992, 156062178, 859492659, 518110091, 623089430, 133787238, 939709235, 98372607, 578976237, 605210702, 293716322, 218297979, 32063977, 673844620, 625257709, 861808970, 439138353, 844487779, 379657208, 517758197, 151257913, 364084321, 984272744, 605475567, 450335083, 842346531, 898924071, 462383230, 324606695, 56259485, 453338293, 777689473, 41497069, 302031986, 747730841, 830921021, 203443506, 481039318, 699370318, 931913173, 859439618, 419628582, 154259504, 419700377, 213434422, 894640064, 682543001, 435554111, 733674601, 810896511, 806436515, 9211388, 989954110, 602913461, 131671059, 525805712, 321394179, 750594248, 918583658, 375601723, 283719928, 860112134, 985186759, 727918721, 708585466, 399104447, 949989726, 729388015, 987711029, 410673093, 170232593, 650972747, 617261011, 605291798, 509213147, 623028334, 106946766, 10483623, 104592707, 248003303, 718733272, 154588129, 854954880, 206564661, 44178806, 631334227, 910631940, 22547058, 429755443, 912225640, 890575547, 89682486, 345979164, 279071850, 256297902, 894126679, 289510825, 757975320, 211187814, 436099985, 170760684, 936663596, 449925462, 400297325, 523853802, 875381161, 913685908, 810979706, 850189811, 931449986, 517106650, 145147141, 94059442, 895034658, 517528349, 790191293, 706188403, 913855899, 166029727, 673342814, 426833786, 200060322, 247419230, 846658018, 554663504, 3000101, 30573626, 395319127, 607142249, 544972046, 120401245, 447107819, 288811658, 537472364, 774781044, 197149678, 74854472, 239650918, 74119279, 768164049, 654464357, 171208165, 15025822, 721877164, 454373445, 995619961, 192107103, 76158680, 891659726, 984126116, 288582418, 186624400, 63144758, 2983244, 185731536, 296186461, 931734859, 217021289, 49571617, 719490461, 143245417, 782512388, 288829466, 836771420, 539830315, 957179277, 305087440, 206633622, 410227755, 275371415, 133091198, 126266837, 38843379, 591599321, 953481015, 632445191, 609756134, 172359232, 679150999, 615256388, 480352811, 898665404, 616955677, 123015623, 289802278, 213974950, 389359572, 376632773, 78203033, 98383667, 119366726, 32794740, 863855057, 822489279, 18054992, 448034895, 837792461, 520597226, 829199504, 334678345, 472251500, 824379766, 933720365, 20660857, 502156432, 925398492, 95883470, 693723618, 517106741, 939655156, 189466854, 798650324, 936180296, 562531881, 250309873, 830549616, 403690612, 927275011, 422283598, 34461898, 966492152, 267292756, 1044215, 956209485, 38178825, 721384969, 417481599, 784159644, 263995069, 263909981, 981319612, 364309924, 481015071, 291850989, 79900953, 511016274, 656391343, 138785740, 197670116, 877416281, 112714465, 897393757, 512199596, 69647727, 190760074, 58962394, 429468200, 379499833, 227261641, 360475921, 260414638, 10126858, 343872871, 385827398, 140926471, 462692612, 229422675, 966730938, 778580342, 981946823, 168426966, 368570816, 226866564, 955846301, 376596278, 819336637, 925713495, 95171597, 259670920, 395360314, 299372158, 786653163, 370379609, 207974388, 469645447, 121603582, 972927886, 58491744, 316209660, 661212942, 571021547, 54721986, 589417786, 2665691, 852595697, 210481626, 659121573, 135626185, 782120406, 143238933, 880557222, 215418677, 677254075, 945909425, 78267234, 177409874, 813428860, 210931796, 428172753, 81758574, 874302785, 116773299, 394740091, 612702432, 298665837, 800417998, 580706156, 408166855, 997563467, 644357740, 107988006, 916692283, 592495381, 981175906, 96526829, 976261518, 252269946, 561241822, 836103308, 48290166, 11485043, 341546627, 943350136, 13969951, 717248934, 977123127, 700946880, 866408365, 431758826, 223345369, 111685474, 783011196, 82360934, 53727648, 495921705, 572061928, 360536277, 481839352, 906134805, 601126758, 19841149, 610225958, 833261681, 681189058, 302154227, 300246612, 805721081, 515308963, 143676437, 436730940, 37803134, 849597273, 355576986, 528392679, 850875608, 572738283, 990616527, 998737745, 846073841, 119313831, 705314966, 911880700, 535619908, 705324110, 272585330, 759022259, 834243833, 215369968, 213106981, 479285049, 132658646, 505837736, 874554126, 46094192, 49445533, 747880320, 402752349, 190274299, 336992910, 925461231, 2854196, 725831938, 350267006, 477871993, 798725149, 253301846, 931537368, 192757346, 60353124, 181147193, 556544952, 205220510, 282374488, 76643593, 244636507, 115051369, 371549992, 905753715, 284093000, 894903719, 818825292, 714451246, 993999723, 671033026, 260932516, 331189238, 19910042, 768110609, 903781924, 503940015, 837306915, 156981614, 280067982, 611397828, 54044301, 84467873, 750808000, 9124806, 682254083, 22160226, 370720960, 857114773, 207685735, 913221770, 452663281, 524686093, 624289047, 613892265, 175857667, 495289575, 478249831, 706597474, 199177608, 798535630, 8518238, 432105364, 398137172, 79889399, 109806774, 272471354, 990911274, 510099633, 489813007, 982389698, 169376150, 82099353, 597798006, 262586176, 999944025, 999690400, 677477250, 401844356, 109505124, 645090745, 188196090, 915756246, 892907051, 473080921, 86578053, 63886330, 581681966, 776219996, 759295825, 137100301, 787784254, 53273223, 655356740, 137103717, 52218388, 461119140, 553882535, 909639647, 170442714, 680487678, 605983871, 48960754, 397155677, 616288463, 646568160, 603811300, 396287025, 842218406, 893010843, 863007996, 470836934, 26594190, 877909910, 464697411, 918846185, 285904296, 65563111, 846052822, 913531145, 2856543, 765277967, 747229486, 201603546, 769086303, 122401806, 710798194, 81201944, 547430472, 843999156, 964326457, 375678890, 433182050, 521151020, 546880674, 986457336, 814691312, 161147512, 429355317, 629758899, 558403077, 369956327, 683808402, 228312248, 838158594, 231743616, 527102101, 427946210, 362196245, 109129048, 180875198, 280092281, 19791121, 562383940, 911349133, 191507927, 388720814, 585466724, 169159714, 946448217, 336788368, 428186062, 305442937, 93525829, 723556977, 769703125, 751910925, 573137527, 51238072, 603290813, 31375182, 627663868, 706955412, 920074280, 451660491, 850663739, 99801872, 771291553, 678816557, 82235566, 301172741, 984280586, 737276061, 418114037, 676126875, 328411848, 377935124, 491979820, 892793790, 716986941, 868774070, 744478537, 211043937, 165442893, 754863433, 449310533, 9625279, 503769206, 114003699, 504755969, 873165333, 533991780, 258664225, 655706625, 368148549, 572276036, 811565786, 110501783, 216069382, 876234775, 582495946, 424396327, 35876202, 321400785, 861621290, 786789309, 511101784, 946074266, 701266274, 792012382, 248460168, 954812386, 179456049, 50775155, 620000804, 555836162, 177488862, 993496529, 10807478, 45634976, 921336809, 196148924, 287567523, 309153311, 969734462, 866684329, 774918480, 714057952, 826358406, 621963071, 175919279, 737823881, 828368767, 50362046, 119328782, 602091354, 406442014, 72931838, 138195985, 23076066, 730858311, 76655784, 449530644, 207042140, 626717418, 625334369, 209771365, 606666828, 790000818, 799842372, 496094562, 329785880, 848970831, 771405949, 661007904, 626936597, 368613597, 591381762, 798955618, 979310682, 752940344, 340208415, 281362591, 895054821, 63429312, 904557872, 867417591, 568456101, 679922582, 698349987, 170100654, 373936199, 1524049, 430844935, 688943439, 988038296, 261577199, 428958184, 397595509, 566093946, 781372790, 462958703, 406646818, 13083950, 297089165, 278116880, 385986288, 516423407, 546783922, 507830119, 793775433, 608265845, 894875773, 142115448, 118476228, 98580383, 569078753, 761921580, 963986577, 105766671, 296958359, 227144085, 532195876, 139676755, 140573692, 183008322, 417263928, 66225372, 653298058, 44057342, 175845935, 298109851, 45895884, 218471693, 449686459, 885362620, 375364277, 587932300, 598884831, 994479706, 355194141, 890872774, 435704312, 756114092, 348804945, 527332883, 218753412, 96591820, 68565255, 763479502, 585199289, 116830610, 210482421, 672483138, 217666205, 151256594, 341915888, 61573891, 371225339, 537256616, 296188055, 165546639, 351038808, 564646325, 73526760, 754136873, 122918495, 804855629, 209064150, 457922558, 870525105, 902331302, 100161247, 368856237, 374464948, 505295326, 141182422, 469493775, 719935925, 833202855, 692500476, 641617039, 935161464, 618891633, 448373410, 84763125, 625162492, 261496851, 226032995, 830954000, 757721559, 448215403, 931128192, 551165833, 140164298, 537752883, 47012936, 19916903, 321896945, 403626400, 641042505, 75924536, 458390234, 140821049, 45370127, 972008382, 636773545, 341957814, 411719104, 363648872, 901110920, 916553796, 619449441, 86034231, 720825986, 967093975, 792197329, 854875681, 229972137, 464120537, 813259455, 865730677, 926758492, 124061931, 695231658, 299952679, 160556444, 25672254, 415317087, 705407037, 311834350, 139821770, 430357150, 80675532, 644463645, 385944625, 170698435, 683423231, 551699261, 368070459, 407301053, 123909713, 638892448, 240117114, 319540863, 459661872, 38404445, 11391593, 918416124, 500320010, 479930065, 29002901, 765947816, 267963394, 180533777, 629775406, 835836226, 1893933, 205034382, 94583417, 525590739, 3310262, 593977190, 470641074, 675237395, 56801948, 187600768, 293092558, 472114666, 26599444, 966213888, 678455580, 812251137, 744294158, 259669731, 582398213, 136302865, 624684353, 815349266, 481962155, 29622601, 798332550, 890319972, 89200755, 839460835, 643671633, 314005892, 922684743, 376039192, 839305401, 533281111, 51868577, 24296604, 917087654, 795044837, 468302403, 23899544, 893172597, 641145249, 802742944, 1367932, 954470163, 77186451, 192559169, 84097354, 379988952, 5433733, 568910866, 87728418, 70718062, 438484752, 596834007, 886019090, 671237332, 754241233, 83918437, 106371736, 876351226, 37699187, 102560044, 444774614, 729340869, 195328207, 526162433, 667331663, 683655407, 951892577, 498350067, 583352769, 147140028, 21751477, 90811105, 987325874, 379823949, 379711959, 290474607, 776390218, 679754754, 25148438, 763002654, 953728119, 283533403, 872670106, 800646179, 120776929, 318777866, 520873175, 172107053, 735745840, 469493454, 921562300, 45513936, 241522598, 319190334, 10771910, 447843600, 770181043, 548849232, 859756937, 310358074, 97854802, 259140768, 75030238, 253287855, 489369209, 758906231, 31644884, 72599510, 409253074, 73777024, 310851558, 801905802, 816424220, 368844857, 183201288, 719981265, 447748588, 527819428, 953664286, 210692172, 50284548, 609798474, 90989034, 37316352, 903681718, 174282842, 797009564, 484235809, 381198311, 856293976, 444936085, 295700319, 351080853, 123812993, 13319408, 520990968, 4370357, 231124679, 507541108, 438356272, 584954294, 939661870, 302309052, 109411809, 76745540, 372102580, 248660574, 28068734, 97788576, 707606877, 131828300, 21071552, 607751287, 43655477, 71173243, 60303722, 59857917, 448137732, 625711695, 109038506, 806619451, 936333093, 983107413, 347110273, 316773059, 185820278, 433168186, 81117350, 480164183, 23361902, 239936669, 434285395, 885201259, 603832175, 747133150, 522946619, 306236940, 553432368, 579112397, 539146753, 998949556, 111014024, 442390703, 672159407, 219170229, 452562776, 628477136, 490648806, 790256540, 802794732, 724285201, 124062011, 696576218, 423136129, 123543464, 364269955, 602234666, 667603151, 951586929, 803775072, 20990405, 598418727, 957625788, 574168298, 48053446, 180415650, 146403633, 175557525, 745770275, 446448033, 937206591, 986107839, 28641105, 334714807, 292089756, 797890628, 259892928, 831681476, 99508809, 702275497, 367132745, 472505962, 806155306, 577899019, 827760599, 566300705, 961404009, 650219235, 837886709, 104623362, 201695397, 958320991, 166521815, 353931242, 785660682, 869620618, 733003822, 629037162, 958566131, 198643923, 418826423, 557275073, 945967344, 51711867, 183450212, 608679639, 259576943, 170393944, 8293935, 395685646, 324776141, 756654760, 491372364, 420699033, 965460285, 897551841, 228655159, 951991408, 11919037, 607275688, 640197672, 702180412, 916522797, 891427826, 381550110, 119507406, 456741275, 137033125, 451735800, 968898455, 55321631, 516190222, 568105852, 442760002, 436516759, 733030361, 75078135, 703787665, 219357979, 667614801, 792883410, 855442235, 14626980, 22517102, 280790020, 9272259, 658507938, 559680975, 372751543, 418363480, 366526660, 23453602, 633654922, 466868581, 902478376, 70045249, 222439965, 572440906, 287568582, 326951924, 463312573, 118710389, 153199860, 144637914, 563889350, 235949817, 146740535, 395418498, 484292068, 326743324, 252339667, 585559022, 720412200, 248022192, 36200695, 480187342, 58090146, 9003015, 989817815, 459687043};
        int[] heaters = {670671582, 628594149, 309802650, 145756800, 41653529, 784171559, 464250474, 849626967, 61665466, 117347786, 312724865, 74321846, 84761746, 809007061, 262705070, 850711836, 115189573, 546860973, 9847698, 739976623, 502281562, 880974755, 790444867, 466017905, 283047304, 292738801, 968971708, 139001155, 523182727, 334041871, 512451217, 3674580, 629123944, 269627558, 439872136, 292276778, 793685735, 100711559, 442058277, 527526566, 119478524, 764300079, 137229977, 26786561, 377648504, 117208421, 117900957, 581461765, 222785436, 290826131, 34981723, 320277761, 314309745, 587091173, 701470293, 718970999, 2582171, 34832213, 747925416, 160680821, 968592846, 6897040, 540391498, 444542301, 119823572, 328092296, 656697023, 981382206, 61822213, 811332390, 335298858, 370816678, 318363552, 354453787, 978139909, 610132778, 267185421, 197064870, 649486416, 258816011, 266311702, 337833744, 817951318, 264977179, 383342153, 380624471, 949183331, 61209132, 97214611, 798395357, 945917221, 2273184, 343676420, 586064157, 265776488, 139448056, 798818315, 819142808, 608491717, 603160605, 197474395, 882900728, 593513304, 116560013, 519052427, 635566475, 382085147, 728961099, 254984758, 298951941, 166516985, 479774854, 922360340, 218765265, 295805191, 173202332, 171252239, 401272471, 880747095, 904625472, 3570791, 470699377, 507652269, 159155552, 310221949, 602980505, 318017342, 978153258, 627467999, 355447354, 851656371, 603098720, 950351778, 726450107, 795393732, 889729727, 758887628, 718984263, 78026572, 427570934, 497383454, 162852185, 162507017, 449214313, 539939386, 288346858, 522534774, 974292613, 166116894, 990874936, 46850514, 876047505, 582532703, 249192648, 587723286, 587975249, 173245027, 888827104, 413866974, 955677963, 49328228, 923818832, 316341614, 731480173, 436367114, 365430493, 134549078, 652030811, 865768414, 768025673, 476262572, 873495235, 636203753, 355398258, 26499899, 647666142, 523220529, 969380085, 205637384, 846324865, 397811974, 702232485, 644230061, 109570700, 599742930, 738669139, 2234444, 840056887, 71583009, 90747099, 59060679, 81344195, 790759382, 664125638, 132579338, 320391827, 876911938, 871651183, 855476494, 383396571, 88206375, 159301704, 619114966, 699942425, 809897287, 192347923, 621631704, 49085051, 131710287, 392132130, 84879914, 86046499, 927014262, 334842449, 289885203, 253190356, 205208585, 874929591, 121104928, 389006118, 85603758, 721295794, 273222443, 729562215, 768006782, 158761535, 130429171, 335251988, 730556235, 87610324, 878890782, 124849008, 38732915, 89535942, 237519225, 960998449, 69401834, 145982295, 891085769, 720543983, 522436848, 682955400, 924293163, 845971790, 551626321, 496672948, 313301147, 22475185, 930796070, 264158673, 866118762, 213873568, 478410876, 472818564, 972111248, 218158760, 839693891, 620181600, 299507240, 116514112, 895077967, 245422712, 296413275, 803335532, 223576213, 342008219, 465897361, 404547943, 97030177, 639075344, 19082892, 751102441, 869848821, 627949418, 4205546, 401608427, 84708646, 709533939, 160220982, 37034783, 259297407, 560178264, 140753178, 52145877, 828383919, 305021710, 249393159, 455722947, 408885027, 975956967, 428648583, 636582443, 70568725, 430566509, 304404951, 827964303, 49491608, 167757776, 6396368, 715531782, 827215452, 200971086, 876749318, 285980490, 405693444, 229134083, 618353910, 797537, 312281055, 850636695, 852294786, 802542812, 139738124, 817497406, 78529136, 284229494, 834453308, 234027577, 258928982, 810510230, 549641267, 139103653, 452888035, 800137855, 167310049, 716878198, 981592694, 452010382, 81809413, 19743720, 120220402, 555163165, 958351587, 680748787, 344970471, 860342844, 567762435, 906380002, 72680374, 768334322, 368759021, 888039283, 264882731, 150459686, 187690083, 646726116, 111094145, 788984350, 541428803, 905679682, 394325438, 293101824, 982353397, 352243821, 342463346, 525282262, 113704617, 920535736, 764900542, 639277030, 261335847, 460500992, 902087334, 147274718, 345024082, 406877852, 601105094, 803217948, 394825572, 901897952, 259298738, 582548381, 305671372, 430844158, 675884400, 548101817, 35371267, 779397897, 483186757, 284155592, 592382394, 436708466, 807566263, 462511779, 337646091, 166056063, 115971966, 811638242, 387807550, 268624205, 756387441, 648014294, 79643899, 131171921, 288254425, 761991921, 353229186, 871107372, 98558183, 195963353, 463643020, 23060755, 35052825, 515289075, 454913752, 693646544, 576229092, 324079852, 791543772, 962466486, 120379576, 875895514, 968482191, 501623524, 558748324, 84576784, 433791530, 820241723, 105108368, 117761720, 827262662, 994429556, 659806738, 559271036, 132379133, 103030039, 754045991, 949969790, 748828732, 103305882, 533645507, 88326277, 381516040, 546892916, 399230052, 120570736, 775762, 153330052, 37807564, 924052283, 737963855, 240449560, 464509844, 913891263, 967413897, 726675442, 494653205, 727218898, 38583609, 727633647, 566819111, 84319063, 604263399, 404780330, 62296261, 627196047, 434222453, 620313643, 371270294, 499836723, 592754975, 256226392, 692258109, 863122164, 35153441, 58858540, 38499091, 661644690, 591980664, 127283297};
        System.out.println(heaters_475.findRadius(hourses, heaters));
    }
}