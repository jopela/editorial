(ns editorial.definitions)

(defn load-definition
  "load definitions from a file"
  [filename]
  (load-string (slurp filename)))

(def templates-description
  [
   {
    :title "General_information"
    :sections [
               :introduction
               :architecture          
               :arts                  
               :beaches               
               :climate               
               :culture               
               :districts             
               :districts-and-suburbs 
               :do                    
               :etymology             
               :events                
               :festivals             
               :food                  
               :gastronomy            
               :gay-travelers         
               :geography             
               :heritage-and-monuments
               :history               
               :islands               
               :landmarks             
               :parks-and-recreation  
               :respect               
               :sport                 
               :theater               
               :theatre               
               :the-port              
               :toponym               
               :understand            
               :urbanism              
               :with-children         
               ]
    }
    {
     :title "Practical_Information"
     :sections [
                 :get-in             
                 :get-around
                 :healthcare         
                 :connect            
                 :embassies          
                 :learn              
                 :orientation        
                 :public-transport   
                 :talk                               
                 :tourist-information
                 :transportation     
                 :when-to-go         
                 :when-to-visit      
                 :with-children      
                 :work               
                ]
    }
   {
    :title "Attractions"
    :sections [
               :see
               ]
    }
   {
    :title "Drinking_&_Nightlife" 
    :sections [
              :drink
              ]
    }
   {
    :title "Hotel"
    :sections [
              :sleep
              ]
    }
   {
    :title "Restaurants"
    :sections [
               :eat
               ]
    }
   {
    :title "Shopping"
    :sections [
               :buy
               ]
    }
   {
    :title "Transport"
    :sections [
              :public-transport
              ]
    }
 ])
; map that allows for the mapping between logical section names and their 
; names in different language. Content pulled from sources is categorized
; into the right logical section with this mapping. 
(def logical-section-map
{:districts
 #{"أحياء المدينة" "neighborhoods and districts" "stadtteile"
   "distritos y barrios" "districts et quartiers de madrid"
   "районы города" "quartiers de la ville" "quartieri centrali"
   "районы" "division territoriale" "административное деление"
   "districts and zones" "zone turistiche" "quartieri di buenos aires"
   "districts" "distritos de budapeste" "stadsdistricten"
   "áreas e distritos" "areas" "áreas" "districts et quartiers"
   "subdivisions" "歴史地区" "aree cittadine" "subdivisões"
   "quartieri di lisbona"
   "neighborhoods, commercial districts, and suburbs"
   "distritos de la ciudad" "districts in bochum" "distretti cittadini"
   "stadtviertel" "définitions de tokyo"
   "stadtteile und sehenswürdigkeiten" "quartieri della città"
   "أحياء برشلونة" "subdivisions de la ville" "barrios y sectores"
   "subdivision" "barrios" "distretto di niles" "district" "地区構成"
   "quartieri o barrios" "zone di amsterdam" "distretti di sydney"
   "distretti" "city districts" "歴史的地区" "城市布局"
   "les quartiers et leurs aménagements" "distretti e parrocchie"
   "التقسيمات الادارية" "التقسيم الإداري" "nachbarschaft"
   "quartieri di quito" "地区と歴史的地域社会" "المناطق" "quartieri di miami"
   "المناطق التجارية" "行政区画" "التقسيمات الإدارية"
   "stadtbezirke mit wohnviertel und ortsteilen" "down town districts"
   "arrondissements" "principaux quartiers de libreville"
   "landmarks and districts" "районы праги" "barrios y vecindarios"
   "distretti di barcellona" "quartiers de bezons"
   "المدن والتقسيمات الادارية" "neighbourhoods" "bezirke"
   "quartiers d'arnhem" "distritos" "barrios y área metropolitana"
   "stadtteile von den haag" "stadtteile im zentrum" "quartiers"
   "wijken" "principaux quartiers" "quartieri storici"
   "barrios de chicago" "circoscrizioni di budapest"
   "áreas de la ciudad" "arrondissement" "地方行政区" "quartieri di lima"
   "distrikte" "staatliche einrichtungen und organisationen"
   "stadtteile und stadtviertel" "zone di tokyo" "行政区分"},
 :climate
 #{"climat" "気候" "climate" "气候" "klima und reisezeit" "المناخ" "погода"
   "le climat" "données climatiques" "climat et végétation" "مناخ"
   "climatología" "التضاريس والمناخ" "الطقس في شيكاغو" "気象" "الطقس"
   "géographie et climat" "klimaat" "klima und hurrikane"
   "klima und geographie" "climat de reno" "clima" "氣候" "il clima"
   "климат" "climat et pollution" "klimatabelle" "klima"},
 :drink
 #{"boire un verre" "activités nocturnes" "night life" "boire-sortir"
   "beber e sair" "uitgaan" "sortir" "sortir / boire un verre"
   "nachtleven" "ナイトライフ" "nachtleben und kultur" "boire"
   "ショッピング、ナイトライフ" "leisure and nightlife" "come divertirsi"
   "où sortir ? où boire un verre ?" "vida nocturna" "beba y salga"
   "sortez" "shopping and nightlife" "prendre un verre/sortir"
   "vie nocturne" "nightlife" "boire un verre/sortir" "nachtleben"
   "drink" "boire un verre / sortir" "ночная жизнь"
   "boire un verre - sortir" "boire des verres" "clubs, discothèques"
   "recreation and nightlife"},
 :when-to-visit #{"quand visiter" "when to visit"},
 :talk
 #{"lingua" "hable" "talen" "talk" "people and language" "sprache"
   "idioma" "communiquer" "اللغة" "язык" "parler" "taal" "言語" "langue"
   "klarkommen"},
 :theatre
 #{"theatre/concerts" "theater and music" "theatre and music"
   "theatre and musicals" "theatre" "theatre & comedy"},
 :culture
 #{"landmarks and culture" "culture and festivals" "historia y cultura"
   "تعليم وثقافة" "bezienswaardigheden en cultuur" "文化と現代的な生活"
   "cultura y turismo" "turismo y cultura" "التعليم والثقافة"
   "kultur, sehenswürdigkeiten, sport, freizeit"
   "turismo y patrimonio cultural" "loisirs et culture"
   "savannah dans la culture" "patrimoine et culture locale" "文化と当代の生活"
   "culture locale et patrimoine" "life and culture" "lengua y cultura"
   "観光と文化" "culture et événements" "culture et curiosités"
   "kultur & sehenswürdigkeiten" "art, culture and nightlife" "住民および文化"
   "文化・観光" "vie culturelle et sociale" "産業・観光・文化"
   "cultuur en recreatie" "الثقافة والفنون" "culture et religions"
   "tourisme et culture" "vita culturale"
   "facilidades culturales y atracciones turísticas"
   "culture et patrimoine" "kultur und tourismus" "kulturleben" "伝統文化"
   "food and culture" "культура и развлечения"
   "kunst, cultuur en uitgaansleven" "cultuur en religie"
   "arts & culture" "culture et art" "arti, intrattenimento e cultura"
   "cultuur en ontspanning" "sehenswürdigkeiten, kultur, erholung"
   "kulturelles" "culture et divertissements" "heritage and culture"
   "beni culturali" "culture & events" "arte y cultura"
   "lugares de interés/cultura" "الثقافة والمعالم السياحية"
   "vie culturelle" "cultura, architetture e luoghi di interesse"
   "arts et cultures" "cultura y lugares de interés"
   "sehenswürdigkeiten/kultur" "cultures and tourism"
   "文化施設・名所・旧跡・祭事・催事" "culture and art"
   "cultura e luoghi d'interesse turistico" "艺术与文化" "文化・生活"
   "kunst, kultur" "art and culture"
   "culture et manifestations culturelles" "博物館および文化的組織"
   "культура и общество" "الحياة الثقافية في أوتاوا" "アートと文化"
   "taal en cultuur" "культурная жизнь города" "cultura"
   "famous religious and cultural landmarks of bharatpur" "芸術、文化及びスポーツ"
   "patrimonio cultural" "культура и досуг" "cultura e stile di vita"
   "tourismus und kulturerbe" "culture and arts"
   "cultuur en bedrijvigheid" "kunst, sehenswürdigkeiten und freizeit"
   "kunst und kulturzentren" "культура" "arts, culture and tourism"
   "人々と文化" "芸術・歴史・文化" "文化と名所" "kultur und freizeit" "cultura e turismo"
   "名所・名物・文化観光施設" "文化・教育・観光" "culture et principaux sites"
   "turismo e cultura" "культура и полиэтничность" "culture et lieux"
   "人物和文化" "文化和名胜" "الثقافة والتعليم والرياضة" "culture et monuments"
   "культура и отдых" "culture and recreation"
   "kunst, cultuur, erfgoed" "arts, entertainment, and culture"
   "文化的見どころ" "arts et culture" "kultur- und nachtleben"
   "culture and entertainment" "culture et éducation"
   "entertainment and culture" "文化娱乐" "culture and architecture"
   "culture" "nachtleben und kultur" "文化与现代生活" "kultur und bauwerke"
   "kultur und sport" "文化と見所" "cultura e folklore"
   "культура и достопримечательности" "芸術・文化" "文化" "kultur"
   "culture et divertissement" "文化と観光" "歴史遺産と文化" "文化的特徴"
   "culture et religion" "الثقافة والتعليم" "culture and tourism"
   "tourisme et vie culturelle" "tourism and culture" "ثقافة وتعليم"
   "sprache und kultur" "attractions and culture"
   "culture, tourisme et patrimoine" "arte e cultura" "oferta cultural"
   "culture populaire" "monuments et culture" "culture and sights"
   "culture and attractions" "culture et mode de vie"
   "atrações culturais" "culture and traditions"
   "cultuur en bezienswaardigheden" "culture and contemporary life"
   "vida cultural" "メディアと文化" "культура и национальный уклад"
   "cultura e vita contemporanea" "الفنون والثقافة"
   "культура и современность" "الثقافـة والترفيـه" "ثقافة ومعالم"
   "культурные учреждения" "people and culture" "culture and events"
   "文化と芸術" "観光・文化" "cultura y patrimonio" "文化・教育施設" "arts and culture"
   "名所・旧跡・観光・文化芸術" "伝統・文化" "kultur und tradition"
   "religion and culture" "الثقافة والترفيه" "cultura y ocio"
   "الثقافة ومعالم المدينة" "الثقافة والحياة المعاصرة" "cultuur" "文化遺産"
   "tourism, art & culture" "культура и архитектура"
   "culture et vie au mans" "ثقافة" "文化・スポーツ" "local culture"
   "معالم المدينة والثقافة" "المجتمع والثقافة" "文化と呼び物"
   "culture et tourisme" "patrimoine et culture" "art et culture"
   "kультура" "culture and the arts" "culture and heritage" "住民及び文化"
   "休閒和文化" "patrimoine culturel" "cultura y museos" "الثقافة"
   "sights and culture" "культурная жизнь" "культура и туризм"
   "文化施設・観光スポット・スポーツ施設" "culture et communications" "芸術と文化"
   "kultur und erholung" "kunst en cultuur" "cultura e attrazioni"
   "kultur und lebensart" "kultur und sehenswürdigkeiten"
   "culture et musique et célébrités" "language and culture" "人と文化"
   "ثقافة المدينة" "cultura ed economia" "culture médiatique"
   "arts, culture and heritage" "cultuur en samenleving"
   "culture et loisirs" "cultura e intrattenimento" "文化・芸術・音楽"
   "cultuur en onderwijs" "kultur und attraktionen" "cultura e società"
   "kunst und kultur" "指定文化財" "kultur und kunst" "культура и искусство"
   "文化施設" "geschichte und kultur" "langue et culture"},
 :history
 #{"history and traditional culture" "history and name"
   "histoire de grenade" "تاريخ مدينة دبلن" "تاريخ جبل طارق"
   "geschiedenis" "история и культура" "تاريخ زنجبار"
   "histoire de florence" "历史中心" "history and legend" "تاريخ فيلنيوس"
   "تاريخ المقاطعة" "تاريخ مكة" "تاريخ صوفيا" "تاريخ منطقة تبوك"
   "histoire de vilnius" "storia e origini" "geschichte"
   "تاريخ كوبنهاجن" "تاريخ كابلعدل" "geschichte der stadt"
   "lage und geschichte" "geschichte und stadtentwicklung"
   "geschichte und stadtgründung" "history and geography"
   "تاريخ المدينةعدّل" "geschichte und sehenswürdigkeiten"
   "storia di nuova delhi" "歴史と概要" "geschichte und geographie"
   "تاريخ القدسعدّل" "история развития города" "历史" "bref historique"
   "history and etymology" "storia in breve" "起源と歴史"
   "история и название" "histoire et culture" "история иерусалима"
   "origen e historia" "تاريخ إنسبروك" "исторические сведения"
   "تاريخ مدينة دبلنعدل" "geschichte und entstehung" "城市歷史"
   "histoire de la principauté" "histoire" "history and mythology"
   "storia ed economia" "نبذة عن تاريخ المدينة" "تاريخ بلنسية"
   "histoire et étymologie" "تاريخ المدينةعدل" "history and legends"
   "تاريخ آخن" "تاريخ بيروتعدّل" "история" "краткая история города"
   "تاريخ غرناطة" "names and history" "تاريخ سمرقند" "history"
   "histoire d'ypres" "تاريخ صلالة" "histoire de la ville"
   "storia della città" "история города нью-йорка" "name and history"
   "история и достопримечательности" "cronistoria" "تاريخ" "布鲁日歷史中心"
   "تاريخها" "歴史と文化" "história" "التاريخ والاسم" "history and culture"
   "تاريخ مانيلاعدّل" "этимология названия и история" "التاريخ"
   "geschichte und bedeutung" "歷史" "storia" "histoire et description"
   "historia" "historique" "история и география" "история и топонимика"
   "تاريخ المدينة" "cenni di storia" "歴史" "تاريخ مدينة كارديف"
   "geschichte isfahans" "histoire de zonnebeke" "التأريخ"
   "история и хозяйство" "histoire de münster"},
 :tourist-information
 #{"informations touristiques" "official tourism information"
   "tourist centres" "tourist office" "oficinas de información"
   "tourist information centres" "visitor information"
   "tourist information"},
 :theater
 #{"theater und kinos" "theater" "cinema"
   "théâtre, opéra et comédies musicales" "shows" "théâtres"
   "theater, opera, and music" "theatres"},
 :festivals
 #{"feste/ festivals" "sehenswürdigkeiten und volksfeste"
   "feste und festivals" "festival cinematografico" "feste/festivals"
   "festivals et fêtes" "festivals in bretagne" "filmfestivals"
   "festivals in rennes" "festival" "festividades"
   "festivals et manifestations" "festival e turismo" "festivals"},
 :respect #{"respect" "respete" "respecter"},
 :work
 #{"werk" "trabalhe" "arbeiten" "travailler" "werken" "work" "trabajar"
   "trabaje"},
 :the-port #{"haven" "the port"},
 :learn
 #{"enseignement et vie étudiante" "leren" "learn" "faire ses études"
   "leer" "aprenda" "étudier" "apprendre" "lernen"},
 :food
 #{"الطعام والشراب في برلين" "spécialités culinaires" "food and drink"
   "food"},
 :public-transport
 #{"public transportation" "les transports en commun sainfoniards"
   "public transport" "городской транспорт филадельфии"},
 :do
 #{"casinos/gaming" "faire" "golf" "a faire" "u-boot fahrten"
   "ice skating" "polo" "que faire à miami" "beach"
   "activités sportives" "randonnée roller" "sports dans la ville"
   "spa" "faire du sport" "les sports" "leisure"
   "sportliche austragungen" "parks und sportmöglichkeiten" "attività"
   "onderwijs, sport en recreatie" "tango" "get married" "do"
   "il tango" "onderwijs, welzijn en sport" "sports et loisirs" "spas"
   "wintersport" "à faire/à voir" "horseback riding"
   "sposarsi a las vegas" "outdoor activities" "baden & wellness"
   "excursions" "skydiving" "helicopter tours" "haga"
   "leisure & sports" "cosa fare" "activités" "esporte"
   "parks and outdoor recreation" "النشاطات الترفيهية"
   "sport et loisirs" "la plage" "walking" "food tours" "bicycle tours"
   "visites et excursions" "aktivitäten" "water sports and yachting"
   "piscines" "desporto" "sport treiben" "esportes" "sport automobile"
   "loisirs" "motorsport" "bathing and wellness" "attività ricreative"
   "quoi faire"},
 :toponym
 #{"étymologie, toponymie" "toponymie" "toponym" "toponomia"
   "toponimia" "toponymy" "toponymie et héraldique" "toponomastica"
   "toponyme"},
 :gastronomy
 #{"cuisine" "kulinarische spezialitäten" "gastronomy"
   "specialità gastronomiche" "gastronomía"
   "küche, brauhäuser und kneipen" "gastronomia"
   "culire locale et patrimoine" "кухня" "küche" "gastronomie" "美食"
   "kulinarisches" "typische küche" "cuisine et gastronomie"
   "cuisine madrilène"},
 :eat
 #{"coma" "mangez" "comida" "lyoner küche" "食物" "cucina"
   "традиционная пища" "essen" "comer" "食文化" "se nourrir" "küche"
   "où manger" "еда" "cibi locali" "eten en drinken" "manger et sortir"
   "nourriture et boissons" "الأطعمة والمأكولات" "comer y beber" "eet"
   "الطعام والشراب في ميونخ" "名物料理・お菓子" "пивные бары, рестораны"
   "restaurants" "bere e mangiare a birmingham" "restaurants à miami"
   "eten" "eat" "food and cuisine" "знаменитые гамбуржцы" "manger"
   "street food" "s'y restaurer" "еда и напитки" "restauration rapide"
   "dove mangiare" "食"},
 :transportation
 #{"الطرق المواصلات" "lage und verkehr" "transport en commun"
   "وسائل النقل" "النقل والمواصلات" "transports en commun"
   "infraestruturas e transportes" "verkehr"
   "transporte e infraestrutura" "verkeer en vervoer"
   "transport- und verkehrswege" "infraestrutura"
   "транспорт и инфраструктура" "transport" "vervoer" "infra estrutura"
   "verkeer" "transports" "infraestruturas" "öffentlicher verkehr"
   "النقل" "transportation" "transports à noisy-le-grand"
   "infrastruttura e trasporti" "trasporti ed infrastrutture"
   "transportation and tourism" "transporte en miami"
   "transport, nahverkehr" "trasporti pubblici"
   "infrastrutture e trasporti" "mezzi di trasporto" "nahverkehr"
   "transports publics" "trasporti e mobilità" "交通"
   "городской транспорт" "مواصلات"
   "trasporti ed infrastrutture di vienna" "infra-estruturas"
   "transportes" "trasporti e infrastrutture" "транспорт"
   "transporte e infraestructuras" "trasporti" "المواصلات"
   "verkeer & vervoer" "交通機関" "transporte e infraestructura" "公共交通"
   "verkehr und transport" "transporte" "infra-estrutura"
   "المواصلات في البندقية"},
 :etymology
 #{"etimologia" "city name" "names and etymology" "etymology and names"
   "名前" "etymology" "etymology and spelling" "этимология"
   "origine e significati del nome della città"
   "origen etimológico del nombre" "名称" "etymology of the name" "地名の由来"
   "der name dublin" "antica denominazione" "un nom, une légende"
   "名字的意思" "origine del nome e storia" "топонимика"
   "этимология топонима" "origin of the name" "étymologie de québec"
   "этимология названия, прозвища" "etmologia" "etymologie und name"
   "geschiedenis en etymologie" "nom et attributs" "noms de la ville"
   "etimologia del nome" "أصل الاسم" "origine del nome"
   "name und geschichte" "étymologie et histoire" "étymologie"
   "أصل التسمية" "этимология названия" "etymology and other names" "語源"
   "origen del nombre" "etymologie" "اصل التسمية"
   "etymology of the name kamakura and its first use"
   "etymology and legend" "der ursprung des stadtnamens" "название"
   "произношение и этимология названия" "nombres y etimología"
   "etymology and usage" "étymologie, devise, blason" "origin of name"
   "etymology and historical names" "etymologie des namens „minsk“"
   "der name der stadt" "origen etimológico" "etimología"
   "da dove deriva il nome" "地名" "nom et armoiries"
   "origin and etymology" "name und etymologie" "名字由来"
   "origine du nom"},
 :connect
 #{"rester en contact" "connect" "comunicazioni" "tenersi in contatto"
   "restare in contatto" "come restare in contatto"},
 :healthcare
 #{"medical care" "الرعاية الصحية في ميونخ" "conserver la santé" "医療"
   "la santé" "healthcare" "医療と公共サービス" "gesund bleiben" "santé"},
 :sleep
 #{"ホテル" "se loger" "الفنادق وأماكن الإقامة في برلين"
   "hôtels et casinos" "hébergement" "unterkunft" "宿泊" "dormir"
   "dove dormire" "overnachten" "slapen" "duerma" "alloggio" "durma"
   "s'y loger" "sleep" "slaap" "فنادق وأماكن الإقامة في ميونيخ"
   "где остановиться" "dove alloggiare" "logement"},
 :beaches
 #{"urban beaches" "strände in niterói" "strand" "playas"
   "go to the beach" "beaches and boating" "vaya a la playa" "spiagge"
   "plages" "beaches" "пляжи" "praias" "strände"
   "strände und schwimmbäder"},
 :landmarks
 #{"monuments, sites et œuvres d'art public" "城市的主要景点"
   "toerisme en bezienswaardigheden" "主なランドマーク"
   "monuments et patrimoine" "minor attractions" "مواقع سياحية"
   "monumentos y lugares" "baudenkmale"
   "monuments and tourist attractions" "lugares de interés turístico"
   "monumenti" "monuments, curiosités" "sitios y monumentos"
   "musées et lieux intéressants à visiter"
   "bauwerke und sehenswürdigkeiten"
   "monumenti e luoghi caratteristici" "monuments d’i̇stanbul"
   "основные достопримечательности" "major attractions"
   "museen und galerien" "monumentos y lugares de interés"
   "monumenti e luoghi di interesse" "les monuments"
   "bâtiments et lieux publics remarquables"
   "monuments et édifices publics" "patrimoine, sites et monuments"
   "достопримечательности и культура" "monument"
   "monuments et lieux de visite" "bauwerke"
   "lugares de interés y monumentos" "attrattive turistiche"
   "attrattive" "名所、旧跡" "luoghi di particolare interesse"
   "lugares e monumentos" "観光名所" "lieux d'intérêts"
   "monuments et musées" "toerisme"
   "monumentos e outros locais de interesse"
   "monumentos y espacios verdes" "landmarks, sights and culture"
   "lieux d'intérêt" "monuments et sites intéressants"
   "édifices remarquables" "sites d'intérêt"
   "quartiers, monuments et lieux touristiques"
   "bekannte bauwerke und orte" "monumentos"
   "monumentos históricos y otros lugares de interés"
   "monuments and parks" "достопримечательности" "monuments"
   "aree di interesse turistico" "名胜和文化" "principaux sites"
   "monumentos e lugares" "monumenti storici"
   "monumente und sehenswürdigkeiten" "地标建筑"
   "monumentos e lugares turísticos" "lieux intéressants"
   "baudenkmäler" "lieux. monuments" "sites et monuments"
   "places and monuments" "monuments et sites" "sites and monuments"
   "monuments et lieux réputés" "lieux et monuments"
   "sites, lieux et monuments" "monumenten"
   "monumenti e luoghi interessanti" "monumenti e luoghi turistici"
   "monuments historiques et sites remarquables"
   "monumentos y atracciones turísticas" "locais de interesse"
   "attractions de la ville" "pontos turísticos" "ランドマーク"
   "principales edificios" "monuments célèbres"
   "monuments et attraits touristiques" "主な建造物" "monumentos históricos"
   "見所" "lugares y monumentos" "建筑和公园" "sights" "édifices historiques"
   "musei e monumenti" "centres d'intérêt" "monumentos y parques"
   "معالم سياحية في برلين" "attractions de guelph" "主な観光名所" "見どころ"
   "lieux et monuments touristiques" "monumenti principali"
   "معالم المدينة" "monumentos y lugares turísticos"
   "lieux touristiques, monuments" "monuments et lieux touristiques"
   "lieux, monuments et centre d'intérêts" "landmarks"
   "monumentos e atrações turísticas" "キエフの風景"
   "monuments et sites remarquables" "monuments et lieux remarquables"
   "monumentos y lugares célebres" "monumentos y sitios de interés"
   "monumentos de interés" "monumenti e punti di interesse"
   "unique attractions" "旅游景点" "المعالم العمرانية" "sites touristiques"
   "attractions touristiques" "monumentos y edificios significativos"
   "monuments remarquables" "lieux touristiques"
   "lieux historiques et musées" "tourist attractions"
   "museums and points of interest" "世界遺産" "lieux remarquables"
   "places of interest" "luoghi di interesse" "monuments et curiosités"
   "sites of interest"},
 :buy
 #{"التسوق" "التسوق في برلين" "compre" "acheter" "à acheter"
   "weihnachtsmärkte" "acquisti" "shopping centers"
   "shopping complexes" "buy" "shopping malls" "shopping"
   "einkaufszentren" "shopping in vizag" "marchés" "shopping areas"
   "shopping a medellín" "ショッピングセンター" "einkaufs-tipps"
   "shopping and shopping-centres" "magasinage" "kopen"
   "торговые улицы и центры" "compras" "покупки"
   "shopping centres and malls" "einkaufen/ shoppen" "шоппинг"
   "winkelen en markten" "achats" "einkaufen" "centros comerciales"
   "shopping malls and centers" "centres commerciaux" "ショッピング"
   "winkelen" "valuta e acquisti"},
 :orientation
 #{"come orientarsi" "orientation" "orientación" "come spostarsi"},
 :districts-and-suburbs
 #{"\"quartiers\" and villages" "districts and suburbs"
   "les quartiers de la ville"},
 :gay-travelers #{"gay travelers"},
 :architecture
 #{"architettura" "من المعالم الاثرية والمعمارية في المدينة"
   "architecture and urban planning" "landmarks and architecture"
   "arquitectura urbana" "patrimoine architectural"
   "cityscape and architecture" "المعالم المعمارية والتاريخية للمدينة"
   "architektur und stadtentwicklung" "architectural heritage"
   "paisagem urbana e a arquitectura"
   "beschreibung der stadt und ihrer architektur"
   "архитектурные памятники" "architetture" "stadtbild und architektur"
   "архитектурные особенности" "architecture and cityscape"
   "архитектурные и ландшафтные достопримечательности"
   "arquitectura y urbanismo"
   "architecture, topologie et infrastructures de la ville"
   "paisagem urbana" "notable architecture" "architettura e monumenti"
   "архитектура и городские постройки" "churches and architecture"
   "العمران والمعالم" "architektur" "city planning and architecture"
   "buildings and structures" "architetture moderne" "الطراز المعماري"
   "stadsbeeld" "архитектура и инфраструктура"
   "urbanistica e architettura" "arts and architecture" "الفن والعمارة"
   "arquitetura e pontos turísticos" "arquitectura"
   "الهندسه المعماريه لبلنسية" "paisaje urbano y la arquitectura"
   "the architecture of salzburg" "architecture and neighborhoods"
   "arquitectura e atracções" "architecture et urbanisme"
   "architectuurbewerken" "архитектура и градостроительство"
   "архитектура города" "architecture et paysage urbain" "建築と都市計画"
   "patrimônio arquitectónico" "patrimoine architectural et artistique"
   "opere architettoniche" "наука, культура и архитектура"
   "lieux d'intérêt, architecture et urbanisme"
   "culture et architecture" "architecture"
   "architecture and influences" "património arquitetónico e museus"
   "geschiedenis en architectuur" "arquitetura"
   "arquitectura típica y edificios de interés" "culture, architecture"
   "paesaggio urbano" "архитектура" "patrimoine bâti et architecture"
   "arquitectura y sistema vial" "architecture and attractions"
   "العمارة" "architecture and notable buildings"
   "urbanismo y arquitectura" "urbanisme et architecture"
   "سكان بغداد وعمارتها" "архитектура и достопримечательности"
   "baustil" "architecture industrielle" "архитектура и план застройки"
   "cityscape" "culture, art and architecture"
   "gadag style of architecture" "architectuur"
   "patrimonio y arquitectura" "城市景观与建筑" "المعمار"
   "marcos arquitetônicos" "edificios y arquitectura"
   "architecture et tourisme" "ناطحات السحاب"
   "العمارة والتخطيط العمراني" "architecture and skyline"},
 :see
 #{"voir & visiter" "atrações e turismo" "a voir" "à voir" "voir"
   "interesses turísticos" "museos y bibliotecas"
   "attrazioni turistiche" "veja" "da vedere" "cosa vedere a roma"
   "à voir dans la ville" "museen und sehenswürdigkeiten" "cosa vedere"
   "lugares de interés" "attrazioni" "attrazioni e luoghi d'interesse"
   "atrações turísticas" "da visitare" "attractions"
   "sehenswürdigkeiten und kultur" "musei" "attrazioni principali"
   "a voir ici" "à voir ici" "attraits touristiques" "vea" "see"
   "atracciones" "monumenti e luoghi d'interesse" "чем заняться"
   "points of interest" "sehenswürdigkeiten" "attraktionen" "attraits"
   "visiter" "a voir sur place" "visites" "luoghi d'interesse"
   "atracções" "a voir à milan"},
 :parks-and-recreation
 #{"公园与景观" "umwelt und parks" "parcs et forêts" "zoos und tiergärten"
   "parks and outdoor attractions" "parks" "парки и места отдыха"
   "parks & gardens" "парки" "parcs" "parcs et espaces verts"
   "parks and recreation" "парки и зоны отдыха" "zoo"},
 :sport
 #{"رياضة" "спорт" "الرياضة" "sportliche ereignisse" "loisirs et sport"
   "sportclubs" "sportvereine" "スポーツ" "events and sports"
   "spectator sports" "extreme sports" "sport" "beim sport zuschauen"
   "professional sports" "sportliche erigisse" "le sport à pittsburgh"
   "sport in indianapolis" "sport treiben" "sporten" "sports" "体育"},
 :heritage-and-monuments
 #{"heritage and monuments" "patrimoine naturel et architectural"
   "patrimoine" "patrimoines" "patrimoines urbanistique et culturel"
   "patrimoine urbain" "patrimoine et urbanisme"},
 :get-in
 #{"come arrivare" "arriveren" "arriver / se déplacer" "aeropuerto"
   "aller" "get in" "llegar" "как добраться" "s'y rendre" "chegar"
   "arriver" "anreise"},
 :with-children #{"with children"},
 :urbanism
 #{"urbanisme et environnement" "organización territorial y urbanismo"
   "urbanistica" "urbanism" "urbanisme" "urbanisation" "urbanismo"
   "urbanisme et cadre de vie"},
 :geography
 #{"geographie und klima" "جغرافيا المدينة" "市内の地理" "地理および気候"
   "географическая характеристика" "geografía y clima"
   "جغرافية المدينة" "geography and location" "clima y geografía"
   "géographie de la ville" "الجغرافيا, التوقيت, والمناخ"
   "géographie, géologie" "geografie und klima" "地理・概況"
   "الموقع والمناخ" "地理・市勢" "urbanisme et géographie urbaine"
   "características ambientales y geográficas"
   "географическая информация" "地理・気候" "geography & climate"
   "faits géographiques" "地理、交通等" "地理と都市概観" "geografía y ubicación"
   "地理及び気象" "ubicación y geografía" "geographie und umwelt"
   "geografie und verkehrswesen" "الجغرافيا والمناخ"
   "geographie und verkehr" "география и климат" "الطبيعة الجغرافية"
   "geografie und lage" "география квебека" "curiosidade geográfica"
   "geografía y urbanismo" "معلومات جغرافية" "地理和氣候" "地理、気候"
   "géographie physique" "географическое положение и климат" "地理・地形・気象"
   "физико-географическая характеристика" "geography and cityscape"
   "جغرافيا المدينةعدل" "география и городской пейзаж"
   "geografie und verkehr" "géographie, géologie et toponymie"
   "position géographique" "geografia, popolazione e clima"
   "geografisch" "地理・自然" "geografia, geologia e clima"
   "geografia e clima" "географическое положение" "الموقع الجغرافى"
   "geography and topography" "geographical location" "الموقع الجغرافي"
   "physical geography" "география"
   "géographie, administration et urbanisme" "地理・地域" "地理と気候"
   "geografía" "geografía y naturaleza" "地理と景観" "地理" "地理・地勢"
   "geografía y descripción" "географические особенности" "الموقع"
   "geography and climate" "caracterização geográfica"
   "geography, climate, and wildlife" "geografía y localización"
   "geografia e população" "立地と地理概況" "localização geográfica"
   "site et localisation" "geografía y geología" "市内地理" "geografia"
   "geographie" "الموقع والمساحة" "جغرافيا" "lage und klima"
   "geografische ligging" "الجغرافيا والطقس والسكان" "geografía urbana"
   "geografie en klimaat" "地理和气候" "geographical features"
   "situación geográfica" "geografía y climatología"
   "aspectos geográficos" "géographie naturelle" "geographie & klima"
   "curiosidad geográfica" "地理气候" "جغرافية" "geography"
   "географическое положение, климат" "الجغرافيا" "geografía y entorno"
   "geografie" "جغرافيتها" "地理与气候" "géographie" "география и история"
   "geografia fisica" "géographie et quartiers de saint-denis"
   "جغرافية المكان" "geographie und infrastruktur"
   "géographie et développement" "geografische lage" "الجغرافية"
   "geografie en stadsbeeld"},
 :embassies
 #{"consulates" "консульства" "посольства" "embassies" "ambassades"},
 :when-to-go #{"quando andare" "when to go"},
 :arts
 #{"art" "art dans la ville" "arts" "искусство и культура"
   "искусство"},
 :introduction 
#{:abstract},
 :islands #{"islas" "isole" "islands"},
 :get-around
 #{"rondreizen" "circuler et conduire" "circule" "get around"
   "circuler" "cómo desplazarse" "mobilität" "come spostarsi"
   "se déplacer" "circular"},
 :understand
 #{"comprenez" "übersicht" "comprenda" "comprendre" "hintergrund"
   "城区概述" "понять" "understand" "概要" "概況"},
 :events
 #{"special events" "événements sportifs" "annual and seasonal events"
   "ricorrenze tradizionali e festival" "festivités" "événements"
   "évènements" "节日" "eventi culturali periodici" "großveranstaltungen"
   "культурные события" "eventi famosi" "kulturelle ereignisse"
   "sport events" "celebrazioni" "annual town events" "evénements"
   "sport-veranstaltungen" "calendario festivo" "evènements"
   "festivals and events" "marché de noël" "calendario degli eventi"
   "eventos regulares" "manifestazioni" "manifestations culturelles"
   "أحداث" "мероприятия" "events and festivals" "sportveranstaltungen"
   "annual attractions" "sporting events" "事件" "fêtes et festivals"
   "notable events" "veranstaltungen und sehenswürdigkeiten"
   "manifestations" "regelmäßige veranstaltungen / feste"
   "festivals/events" "folclore e manifestazioni" "events and folklore"
   "local events" "kulturelle veranstaltungen" "carnevale" "eventi"
   "veranstaltungen und feste" "feste und veranstaltungen"
   "yearly events" "wine events" "événement"
   "مناسبات واحتفالات في ميونخ" "événements et folklore"
   "besondere ereignisse" "major events and festivals" "evenementen"
   "regelmäßige kulturelle veranstaltungen" "ereignisse"
   "eventi e manifestazioni" "events in the town"
   "kulturelles leben, veranstaltungen"
   "мероприятия, проводимые в москве" "eventi culturali"
   "le manifestazioni culturali" "cultural events"
   "événements culturels" "festivals & events" "oktoberfest"
   "regelmäßige großveranstaltungen und märkte" "eventi annuali"
   "eventi sportivi" "events" "regelmäßige veranstaltungen"
   "eventi e feste" "مناسبات واحتفالات برلين" "messe münchen"
   "événements annuels" "できごと" "events & festivals" "annual events"
   "acontecimientos" "festivals" "festivals / événement"
   "manifestations culturelles et festivités" "eventos"
   "veranstaltungen" "催事"}})

(def languages
  #{"en" "it" "fr" "pt" "ar" "nl" "ko" "ru" "pl"})
