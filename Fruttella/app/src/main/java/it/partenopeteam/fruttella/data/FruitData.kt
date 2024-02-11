package it.partenopeteam.fruttella.data

import it.partenopeteam.fruttella.model.Fruit
import it.partenopeteam.fruttella.ui.theme.BlueBerryDark
import it.partenopeteam.fruttella.ui.theme.BlueBerryLight
import it.partenopeteam.fruttella.ui.theme.LemonDark
import it.partenopeteam.fruttella.ui.theme.LemonLight
import it.partenopeteam.fruttella.ui.theme.StrawberryDark
import it.partenopeteam.fruttella.ui.theme.StrawberryLight


var fruitsData: List<Fruit> = listOf(
    Fruit(
        title = "Fragola",
        headline = "Ampiamamente apprezzata per il suo aroma caratteristico, colore rosso, consistenza succosa e dolcezza.",
        image = "strawberry",
        gradientColors = listOf(StrawberryLight, StrawberryDark),
        description = """La fragola da giardino (o semplicemente fragola; Fragaria × ananassa) è una specie ibrida ampiamente coltivata del genere Fragaria, conosciuta collettivamente come le fragole, che sono coltivate in tutto il mondo per il loro frutto. Il frutto è ampiamente apprezzato per il suo aroma caratteristico, colore rosso brillante, consistenza succosa e dolcezza. È consumato in grandi quantità, sia fresco che in alimenti preparati come marmellata, succo, torte, gelato, frullati di latte e cioccolatini. Aromi e sapori artificiali di fragola sono anche ampiamente utilizzati in prodotti come caramelle, saponi, lucidalabbra, profumi e molti altri.
Dal punto di vista botanico, la fragola non è una bacca. Tecnicamente, è un frutto accessorio aggregato, il che significa che la parte carnosa non deriva dalle ovaie della pianta ma dal ricettacolo che contiene le ovaie. Ogni apparente "seme" (achenio) sulla parte esterna del frutto è in realtà una delle ovaie del fiore, con un seme al suo interno.

CULINARIO: Oltre ad essere consumate fresche, le fragole possono essere congelate o trasformate in marmellata o conserve, così come essiccate e utilizzate in alimenti preparati, come barrette di cereali. Le fragole e gli aromi di fragola sono un'aggiunta popolare ai prodotti lattiero-caseari, come il latte di fragola, il gelato di fragola, frullati-smoothie di fragola e yogurt di fragola.
Nel Regno Unito, "fragole e panna" è un dessert popolare consumato durante il torneo di tennis di Wimbledon. Fragole e panna è anche uno snack tradizionale in Messico, solitamente disponibile nelle gelaterie. In Svezia, le fragole sono un dessert tradizionale servito nel giorno di San Giovanni, noto anche come Vigilia di San Giovanni. A seconda dell'area, torta di fragole, torta di fragole e rabarbaro o shortcake di fragole sono anche comuni. In Grecia, le fragole possono essere cosparse di zucchero e poi immerse in Metaxa, un brandy, e servite come dessert. In Italia, le fragole sono utilizzate per vari dessert e come aroma comune per il gelato (gelato alla fragola).
Suonenjoki nella Savonia settentrionale, Finlandia, è una piccola città famosa per le sue fragole, ecco perché è conosciuta anche come "la città delle fragole" o "la capitale delle fragole". Molti stranieri, principalmente dall'Ucraina e dalla Russia, vengono a Suonenjoki in estate per lavorare nelle fattorie di fragole. Questo rende Suonenjoki la città più internazionale della Finlandia in estate. C'è una festa a Suonenjoki a luglio chiamata Mansikkakarnevaalit, "Carnevale delle fragole".

NUTRIZIONE: Una porzione (100 g; vedi tabella) di fragole contiene approssimativamente 33 chilocalorie, è un'eccellente fonte di vitamina C, una buona fonte di manganese e fornisce diverse altre vitamine e minerali dietetici in quantità minori.
Le fragole contengono una modesta quantità di acidi grassi essenziali insaturi nell'olio degli acheni (semi).
          """,
        nutrition = listOf(
            "240 kJ (57 kcal)",
            "9.96 g",
            "0.33 g",
            "0.74 g",
            "A, B1, B2, B3, B5, B6, B9, C, E, K",
            "Calcio, Ferro, Magnesio, Manganese, Fosforo, Sodio, Zinco"
        )
    ),

    Fruit(
        title = "Mirtillo",
        headline = "I mirtilli sono frutti dolci, nutrienti e molto popolari in tutto il mondo.",
        image = "mirtillo",
        gradientColors = listOf(BlueBerryLight, BlueBerryDark),
        description = """I mirtilli sono piante perenni fiorite con bacche blu o viola. Sono classificati nella sezione Cyanococcus all'interno del genere Vaccinium. Vaccinium include anche i mirtilli rossi, i mirtilli neri, i mirtilli americani e i mirtilli di Madeira.
I mirtilli commerciali, sia selvatici (a basso cespuglio) che coltivati (ad alto cespuglio), sono tutti originari del Nord America. Le varietà ad alto cespuglio sono state introdotte in Europa negli anni '30.
I mirtilli sono generalmente arbusti bassi che possono variare in dimensione da 10 centimetri a 4 metri in altezza. Nella produzione commerciale di mirtilli, le specie con piccole bacche della dimensione di un pisello che crescono su cespugli a basso livello sono note come "mirtilli a basso cespuglio" (sinonimo di "selvatici"), mentre le specie con bacche più grandi che crescono su cespugli coltivati più alti sono note come "mirtilli ad alto cespuglio".
Il Canada è il principale produttore di mirtilli a basso cespuglio, mentre gli Stati Uniti producono circa il 40% dell'offerta mondiale di mirtilli ad alto cespuglio.

USI: I mirtilli sono venduti freschi o sono lavorati come frutta surgelata rapidamente (IQF), purè, succo, o bacche essiccate o infuse. Questi possono poi essere utilizzati in una varietà di prodotti di consumo, come gelatine, marmellate, torte ai mirtilli, muffin, snack, o come additivo per cereali da colazione.
La marmellata di mirtilli è fatta con mirtilli, zucchero, acqua e pectina di frutta. La salsa di mirtilli è una salsa dolce preparata utilizzando i mirtilli come ingrediente principale.
Il vino di mirtilli è fatto dalla polpa e dalla pelle della bacca, che viene fermentata e poi maturata; di solito si utilizza la varietà a basso cespuglio.

NUTRIENTI: I mirtilli sono composti dal 14% di carboidrati, 0.7% di proteine, 0.3% di grassi e 84% di acqua. Contengono solo quantità trascurabili di micronutrienti, con livelli moderati (rispetto ai rispettivi Valori Giornalieri) di manganese, vitamina C, vitamina K e fibra alimentare.
Generalmente, il contenuto di nutrienti dei mirtilli è una bassa percentuale del Valore Giornaliero. Una porzione fornisce un valore calorico relativamente basso di 57 kcal con un carico glicemico di 6.
""",
        nutrition = listOf(
            "240 kJ (57 kcal)",
            "9.96 g",
            "0.33 g",
            "0.74 g",
            "A, B1, B2, B3, B5, B6, B9, C, E, K",
            "Calcio, Ferro, Magnesio, Manganese, Fosforo, Sodio, Zinco"
        )
    ),


    Fruit(
        title = "Limone",
        headline = "Non c'è dubbio che i limoni siano deliziosi, ma aggiungerli all'acqua li rende più salutari?",
        image = "lemon",
        gradientColors = listOf(LemonLight, LemonDark),
        description = """Il limone, Citrus limon, è una specie di piccolo albero sempreverde nella famiglia delle piante fiorite Rutaceae, nativo del Sud Asia, principalmente del nord-est dell'India. I suoi frutti sono rotondi.
Il frutto giallo ellissoidale dell'albero è utilizzato per scopi culinari e non in tutto il mondo, principalmente per il suo succo, che ha usi sia culinari che per la pulizia. La polpa e la scorza sono utilizzate anche nella cucina e nella pasticceria. Il succo di limone è circa dal 5% al 6% di acido citrico, con un pH di circa 2.2, conferendogli un gusto aspro. Il gusto aspro distintivo del succo di limone lo rende un ingrediente chiave in bevande e cibi come la limonata e la torta al limone meringata.

NUTRIZIONE: Il limone è una ricca fonte di vitamina C, fornendo il 64% del Valore Giornaliero in una quantità di riferimento di 100 g (tabella). Altri nutrienti essenziali sono contenuti in quantità basse
I limoni contengono numerosi fitochimici, inclusi polifenoli, terpeni e tannini. Il succo di limone contiene leggermente più acido citrico del succo di lime (circa 47 g-l), quasi il doppio dell'acido citrico del succo di pompelmo, e circa cinque volte la quantità di acido citrico trovata nel succo d'arancia.

CULINARIO: Il succo di limone, la scorza e la buccia sono utilizzati in una vasta gamma di cibi e bevande. L'intero limone è utilizzato per fare marmellata, crema di limoni e liquore al limone. Fette di limone e scorza di limone sono usate come guarnizione per cibi e bevande. La scorza di limone, la scorza esterna grattugiata del frutto, è utilizzata per aggiungere sapore a prodotti da forno, budini, riso e altri piatti.

SUCCO: Il succo di limone è utilizzato per fare limonata, bevande analcoliche e cocktail. È usato nelle marinature per il pesce, dove il suo acido neutralizza le ammine nel pesce convertendole in sali di ammonio non volatili. Nella carne, l'acido idrolizza parzialmente le fibre di collagene dure, ammorbidendola. Nel Regno Unito, il succo di limone è frequentemente aggiunto ai pancake, specialmente il Martedì Grasso.
Il succo di limone è utilizzato anche come conservante a breve termine su alcuni cibi che tendono ad ossidarsi e diventare marroni dopo essere stati tagliati (imbrunimento enzimatico), come mele, banane e avocado, dove il suo acido denatura gli enzimi.

BUCCIA: In Marocco, i limoni sono conservati in barattoli o barili di sale. Il sale penetra nella buccia e nella scorza, ammorbidendoli e curandoli in modo che durino quasi indefinitamente. Il limone conservato è utilizzato in una vasta gamma di piatti. I limoni conservati si possono trovare anche in piatti siciliani, italiani, greci e francesi.
L'olio di limone è estratto dalle cellule contenenti olio nella pelle. Una macchina rompe le cellule e usa uno spruzzo d'acqua per lavare via l'olio. La miscela di olio-acqua è poi filtrata e separata per centrifugazione.

FOGLIE: Le foglie dell'albero di limone sono utilizzate per fare un tè e per preparare carni e frutti di mare cucinati.
          """,
        nutrition = listOf(
            "121 kJ (29 kcal)",
            "2.5 g",
            "0.3 g",
            "1.1 g",
            "B1, B2, B3, B5, B6, B9, C, Colina",
            "Calcio, Ferro, Magnesio, Manganese, Fosforo, Potassio, Zinco"
        ),
    ),
);