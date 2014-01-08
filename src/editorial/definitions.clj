(ns editorial.definitions)

; data structure that describes what the template-articles are in terms of 
; content. A template has a title and a list of section that will logically
; group content together. Content for the logical section is pulled out of the 
; different sources (wikipedia, wikivoyage etc). The order of the items in the 
; section list is the order of appearance in the template article.
(def templates-description
  [
   {
    :title "General_information"
    :sections [
               :introduction
               :architecture
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
               :introduction          
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
                 :connect            
                 :embassies          
                 :get-in             
                 :healthcare         
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
    :section [
              :get-around
              :public-transport
              ]
    }
 ])
; map that allows for the mapping between logical section names and their 
; names in different language. Content pulled from sources is categorized
; into the right logical section with this mapping. 
(def logical-section-map
{:districts #{"districts" "stadtteile" "districts et quartiers de madrid" "районы города"
   "quartiers de la ville" "районы" "division territoriale"
   "административное деление" "zone turistiche"
   "quartieri di buenos aires" "distritos de budapeste"
   "stadsdistricten" "áreas e distritos" "areas" "áreas"
   "districts et quartiers" "subdivisions" "歴史地区" "aree cittadine"
   "subdivisões" "quartieri di lisbona" "distretti cittadini"
   "stadtviertel" "définitions de tokyo"
   "stadtteile und sehenswürdigkeiten" "أحياء برشلونة"
   "subdivisions de la ville" "subdivision" "barrios"
   "quartieri o barrios" "zone di amsterdam" "distretti di sydney"
   "distretti" "城市布局" "les quartiers et leurs aménagements"
   "التقسيمات الادارية" "التقسيم الإداري" "地区と歴史的地域社会" "المناطق"
   "quartieri di miami" "المناطق التجارية" "行政区画" "التقسيمات الإدارية"
   "stadtbezirke mit wohnviertel und ortsteilen" "arrondissements"
   "районы праги" "distretti di barcellona" "quartiers de bezons"
   "المدن والتقسيمات الادارية" "neighbourhoods" "bezirke"
   "quartiers d'arnhem" "distritos" "stadtteile von den haag"
   "stadtteile im zentrum" "quartiers" "wijken" "barrios de chicago"
   "circoscrizioni di budapest" "áreas de la ciudad" "arrondissement"
   "distrikte" "staatliche einrichtungen und organisationen"
   "zone di tokyo" "行政区分"},
 :climate #{"climate" "climat" "気候" "气候" "klima und reisezeit" "المناخ" "погода" "مناخ"
   "climatología" "التضاريس والمناخ" "الطقس في شيكاغو" "気象" "الطقس"
   "géographie et climat" "klimaat" "klima und hurrikane"
   "klima und geographie" "clima" "氣候" "il clima" "климат"
   "klimatabelle" "klima"},
 :drink #{"boire un verre" "activités nocturnes" "boire-sortir" "beber e sair"
   "uitgaan" "sortir" "sortir / boire un verre" "boire"
   "come divertirsi" "où sortir ? où boire un verre ?" "beba y salga"
   "sortez" "prendre un verre/sortir" "vie nocturne"
   "boire un verre/sortir" "nachtleben" "drink"
   "boire un verre / sortir" "ночная жизнь" "boire un verre - sortir"
   "boire des verres" "clubs, discothèques"},
 :when-to-visit #{"quand visiter" "when to visit"},
 :talk #{"talk" "lingua" "hable" "talen" "people and language" "sprache" "idioma"
   "communiquer" "اللغة" "язык" "parler" "taal" "言語" "langue"
   "klarkommen"},
 :theatre #{"theatre" "theatre/concerts" "theater and music" "theatre and music"
   "theatre and musicals" "theatre & comedy"},
 :culture #{"culture" "culture and festivals" "bezienswaardigheden en cultuur" "文化と現代的な生活"
   "cultura y turismo" "patrimoine et culture locale"
   "culture locale et patrimoine" "culture et événements"
   "culture et curiosités" "art, culture and nightlife"
   "cultuur en recreatie" "الثقافة والفنون" "culture et patrimoine"
   "kunst, cultuur en uitgaansleven" "arts & culture" "culture et art"
   "arti, intrattenimento e cultura" "cultuur en ontspanning"
   "beni culturali" "culture & events" "arte y cultura"
   "الثقافة والمعالم السياحية" "vie culturelle"
   "cultura, architetture e luoghi di interesse" "arts et cultures"
   "cultura y lugares de interés" "culture and art"
   "cultura e luoghi d'interesse turistico" "艺术与文化" "文化・生活"
   "art and culture" "culture et manifestations culturelles"
   "культура и общество" "الحياة الثقافية في أوتاوا" "cultura"
   "芸術、文化及びスポーツ" "культура и досуг" "cultura e stile di vita"
   "culture and arts" "cultuur en bedrijvigheid"
   "kunst, sehenswürdigkeiten und freizeit" "культура"
   "arts, culture and tourism" "kultur und freizeit"
   "cultura e turismo" "culture et principaux sites" "culture et lieux"
   "文化和名胜" "culture et monuments" "культура и отдых"
   "culture and recreation" "kunst, cultuur, erfgoed"
   "arts, entertainment, and culture" "arts et culture"
   "kultur- und nachtleben" "culture and entertainment" "文化娱乐"
   "culture and architecture" "culture" "文化と見所" "cultura e folklore"
   "культура и достопримечательности" "文化" "kultur" "歴史遺産と文化" "文化的特徴"
   "culture and tourism" "attractions and culture"
   "culture, tourisme et patrimoine" "arte e cultura"
   "culture and sights" "culture and attractions" "atrações culturais"
   "cultuur en bezienswaardigheden" "culture and contemporary life"
   "cultura e vita contemporanea" "الفنون والثقافة"
   "culture and events" "cultura y patrimonio" "arts and culture"
   "الثقافة والترفيه" "cultura y ocio" "الثقافة ومعالم المدينة"
   "الثقافة والحياة المعاصرة" "cultuur" "культура и архитектура"
   "culture et vie au mans" "ثقافة" "文化・スポーツ" "culture et tourisme"
   "patrimoine et culture" "art et culture" "culture and the arts"
   "culture and heritage" "patrimoine culturel" "cultura y museos"
   "الثقافة" "culture et communications" "芸術と文化" "kunst en cultuur"
   "cultura e attrazioni" "kultur und sehenswürdigkeiten"
   "ثقافة المدينة" "cultura ed economia" "arts, culture and heritage"
   "culture et loisirs" "cultura e intrattenimento" "文化・芸術・音楽"
   "cultura e società" "культура и искусство" "langue et culture"},
 :history #{"histoire de grenade" "تاريخ مدينة دبلن" "geschiedenis"
   "история и культура" "histoire de florence" "geschichte"
   "تاريخ كوبنهاجن" "geschichte und stadtgründung" "歴史と概要" "历史"
   "histoire et culture" "история иерусалима" "исторические сведения"
   "城市歷史" "histoire" "histoire et étymologie" "история"
   "краткая история города" "history" "histoire d'ypres"
   "storia della città" "تاريخ" "تاريخها" "歴史と文化" "história" "التاريخ"
   "歷史" "storia" "histoire et description" "historia" "historique"
   "تاريخ المدينة" "歴史" "geschichte isfahans" "histoire de zonnebeke"
   "histoire de münster"},
 :tourist-information #{"informations touristiques" "official tourism information"
   "tourist centres" "tourist office" "oficinas de información"
   "tourist information centres" "visitor information"},
 :theater #{"theater und kinos" "theater" "cinema"
   "théâtre, opéra et comédies musicales" "shows" "théâtres"
   "theater, opera, and music" "theatres"},
 :festivals #{"feste/ festivals" "festival cinematografico" "festivals et fêtes"
   "festivals in bretagne" "festivals in rennes" "festival"
   "festividades" "festivals et manifestations" "festival e turismo"
   "festivals"},
 :respect #{"respete" "respecter"},
 :work #{"werk" "trabalhe" "arbeiten" "travailler" "werken" "work" "trabajar"
   "trabaje"},
 :the-port #{"haven"},
 :learn #{"enseignement et vie étudiante" "leren" "faire ses études" "leer"
   "aprenda" "étudier" "apprendre" "lernen"},
 :food #{"الطعام والشراب في برلين" "spécialités culinaires"
   "food and drink"},
 :public-transport #{"public transportation" "les transports en commun sainfoniards"
   "городской транспорт филадельфии" "Transportation"},
 :do #{"casinos/gaming" "faire" "golf" "a faire" "u-boot fahrten"
   "ice skating" "polo" "que faire à miami" "beach"
   "activités sportives" "randonnée roller" "sports dans la ville"
   "spa" "faire du sport" "les sports" "leisure"
   "sportliche austragungen" "parks und sportmöglichkeiten" "attività"
   "onderwijs, sport en recreatie" "tango" "get married" "il tango"
   "onderwijs, welzijn en sport" "sports et loisirs" "spas"
   "wintersport" "à faire/à voir" "horseback riding"
   "sposarsi a las vegas" "outdoor activities" "baden & wellness"
   "excursions" "skydiving" "helicopter tours" "haga"
   "leisure & sports" "cosa fare" "activités" "esporte"
   "parks and outdoor recreation" "النشاطات الترفيهية"
   "sport et loisirs" "la plage" "walking" "food tours" "bicycle tours"
   "visites et excursions" "aktivitäten" "water sports and yachting"
   "piscines" "desporto" "sport treiben" "esportes" "sport automobile"
   "loisirs" "motorsport" "bathing and wellness" "attività ricreative"
   "quoi faire" "Do"},
 :toponym #{"étymologie, toponymie" "toponymie" "toponomia" "toponimia"
   "toponymy" "toponymie et héraldique" "toponomastica" "toponyme"},
 :gastronomy #{"cuisine" "kulinarische spezialitäten" "specialità gastronomiche"
   "gastronomía" "küche, brauhäuser und kneipen" "gastronomia"
   "culire locale et patrimoine" "кухня" "küche" "gastronomie" "美食"
   "kulinarisches" "typische küche" "cuisine et gastronomie"
   "cuisine madrilène"},
 :eat #{"coma" "mangez" "comida" "lyoner küche" "食物" "cucina" "essen"
   "comer" "食文化" "se nourrir" "küche" "où manger" "еда" "cibi locali"
   "manger et sortir" "comer y beber" "eet" "الطعام والشراب في ميونخ"
   "пивные бары, рестораны" "restaurants à miami" "eten"
   "знаменитые гамбуржцы" "manger" "s'y restaurer" "dove mangiare"},
 :transportation #{"الطرق المواصلات" "transport en commun" "وسائل النقل"
   "النقل والمواصلات" "transports en commun"
   "infraestruturas e transportes" "verkehr"
   "transporte e infraestrutura" "verkeer en vervoer"
   "transport- und verkehrswege" "infraestrutura"
   "транспорт и инфраструктура" "transport" "vervoer" "infra estrutura"
   "verkeer" "transports" "infraestruturas" "النقل"
   "transports à noisy-le-grand" "infrastruttura e trasporti"
   "trasporti ed infrastrutture" "transportation and tourism"
   "transporte en miami" "trasporti pubblici"
   "infrastrutture e trasporti" "mezzi di trasporto"
   "transports publics" "trasporti e mobilità" "交通"
   "городской транспорт" "مواصلات"
   "trasporti ed infrastrutture di vienna" "infra-estruturas"
   "transportes" "trasporti e infrastrutture" "транспорт"
   "transporte e infraestructuras" "trasporti" "المواصلات"
   "verkeer & vervoer" "交通機関" "transporte e infraestructura" "公共交通"
   "transporte" "infra-estrutura" "المواصلات في البندقية"},
 :etymology #{"etimologia" "city name" "names and etymology" "etymology and names"
   "名前" "этимология" "origine e significati del nome della città" "名称"
   "地名の由来" "antica denominazione" "un nom, une légende" "名字的意思"
   "origine del nome e storia" "топонимика" "origin of the name"
   "étymologie de québec" "этимология названия, прозвища"
   "etymologie und name" "nom et attributs" "noms de la ville"
   "etimologia del nome" "أصل الاسم" "origine del nome"
   "name und geschichte" "étymologie et histoire" "étymologie"
   "أصل التسمية" "etymology and other names" "語源" "origen del nombre"
   "etymologie" "der ursprung des stadtnamens" "название"
   "произношение и этимология названия" "étymologie, devise, blason"
   "origin of name" "etymology and historical names"
   "etymologie des namens „minsk“" "der name der stadt"
   "origen etimológico" "etimología" "da dove deriva il nome" "地名"
   "nom et armoiries" "名字由来" "origine du nom"},
 :connect #{"rester en contact" "comunicazioni" "tenersi in contatto"
   "restare in contatto" "come restare in contatto"},
 :healthcare #{"medical care" "الرعاية الصحية في ميونخ" "conserver la santé" "医療"
   "la santé" "医療と公共サービス" "gesund bleiben" "santé"},
 :sleep #{"ホテル" "se loger" "الفنادق وأماكن الإقامة في برلين"
   "hôtels et casinos" "hébergement" "unterkunft" "宿泊" "dormir"
   "dove dormire" "overnachten" "slapen" "duerma" "alloggio" "durma"
   "s'y loger" "slaap" "فنادق وأماكن الإقامة في ميونيخ"
   "где остановиться" "dove alloggiare" "logement"},
 :beaches #{"strand" "playas" "go to the beach" "spiagge" "strände"},
 :landmarks #{"monuments, sites et œuvres d'art public" "城市的主要景点"
   "toerisme en bezienswaardigheden" "主なランドマーク"
   "monuments et patrimoine" "minor attractions" "مواقع سياحية"
   "monumentos y lugares" "baudenkmale"
   "monuments and tourist attractions" "lugares de interés turístico"
   "monumenti" "monuments, curiosités" "sitios y monumentos"
   "musées et lieux intéressants à visiter"
   "bauwerke und sehenswürdigkeiten"
   "monumenti e luoghi caratteristici" "monuments d’i̇stanbul"
   "основные достопримечательности" "major attractions"
   "monumentos y lugares de interés" "monumenti e luoghi di interesse"
   "les monuments" "bâtiments et lieux publics remarquables"
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
   "lieux. monuments" "sites et monuments" "places and monuments"
   "monuments et sites" "sites and monuments"
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
   "lieux, monuments et centre d'intérêts"
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
 :buy #{"التسوق" "التسوق في برلين" "compre" "acheter" "à acheter"
   "weihnachtsmärkte" "acquisti" "shopping" "marchés" "magasinage"
   "kopen" "compras" "покупки" "achats" "einkaufen" "ショッピング" "winkelen"
   "valuta e acquisti"},
 :orientation #{"come orientarsi" "orientación" "come spostarsi"},
 :districts-and-suburbs #{"\"quartiers\" and villages" "les quartiers de la ville"},
 :gay-travelers #{},
 :architecture #{"architettura" "patrimoine architectural"
   "cityscape and architecture" "architektur und stadtentwicklung"
   "architectural heritage" "paisagem urbana e a arquitectura"
   "beschreibung der stadt und ihrer architektur" "architetture"
   "stadtbild und architektur" "arquitectura y urbanismo"
   "architecture, topologie et infrastructures de la ville"
   "paisagem urbana" "notable architecture" "architettura e monumenti"
   "architektur" "buildings and structures" "architetture moderne"
   "stadsbeeld" "arts and architecture"
   "arquitetura e pontos turísticos" "arquitectura"
   "paisaje urbano y la arquitectura" "architecture and neighborhoods"
   "arquitectura e atracções" "architecture et urbanisme"
   "архитектура и градостроительство" "архитектура города"
   "architecture et paysage urbain"
   "patrimoine architectural et artistique" "architecture"
   "geschiedenis en architectuur" "arquitetura"
   "arquitectura típica y edificios de interés" "paesaggio urbano"
   "архитектура" "architecture and attractions" "العمارة"
   "архитектура и достопримечательности" "baustil"
   "architecture industrielle" "cityscape" "architectuur" "城市景观与建筑"
   "architecture et tourisme" "ناطحات السحاب"
   "architecture and skyline"},
 :see #{"voir & visiter" "atrações e turismo" "a voir" "à voir" "voir"
   "interesses turísticos" "museos y bibliotecas"
   "attrazioni turistiche" "veja" "da vedere" "cosa vedere a roma"
   "à voir dans la ville" "museen und sehenswürdigkeiten" "cosa vedere"
   "lugares de interés" "attrazioni" "attrazioni e luoghi d'interesse"
   "atrações turísticas" "da visitare" "attractions"
   "sehenswürdigkeiten und kultur" "musei" "attrazioni principali"
   "a voir ici" "à voir ici" "attraits touristiques" "vea"
   "atracciones" "monumenti e luoghi d'interesse" "чем заняться"
   "points of interest" "sehenswürdigkeiten" "attraktionen" "attraits"
   "visiter" "a voir sur place" "visites" "luoghi d'interesse"
   "atracções" "a voir à milan"},
 :parks-and-recreation #{"公园与景观" "umwelt und parks" "parcs et forêts"
   "parks and outdoor attractions" "parks" "парки и места отдыха"
   "parks & gardens" "парки" "parcs" "parcs et espaces verts"
   "парки и зоны отдыха"},
 :sport #{"رياضة" "спорт" "الرياضة" "sportliche ereignisse" "loisirs et sport"
   "sportclubs" "sportvereine" "スポーツ" "events and sports"
   "spectator sports" "extreme sports" "sport" "beim sport zuschauen"
   "professional sports" "sportliche erigisse" "le sport à pittsburgh"
   "sport in indianapolis" "sport treiben" "sporten" "sports" "体育"},
 :heritage-and-monuments #{"patrimoine naturel et architectural" "patrimoine" "patrimoines"
   "patrimoines urbanistique et culturel" "patrimoine urbain"
   "patrimoine et urbanisme"},
 :get-in #{"come arrivare" "arriveren" "arriver / se déplacer" "aeropuerto"
   "aller" "llegar" "как добраться" "s'y rendre" "chegar" "arriver"
   "anreise"},
 :urbanism #{"urbanisme et environnement" "organización territorial y urbanismo"
   "urbanistica" "urbanisme" "urbanisation" "urbanismo"
   "urbanisme et cadre de vie"},
 :geography #{"geographie und klima" "市内の地理" "geografía y clima" "جغرافية المدينة"
   "geography and location" "clima y geografía"
   "الجغرافيا, التوقيت, والمناخ" "géographie, géologie"
   "geografie und klima" "الموقع والمناخ" "geography & climate"
   "地理と都市概観" "geografía y ubicación" "地理及び気象"
   "geografie und verkehrswesen" "география и климат" "地理和氣候"
   "géographie physique" "地理・地形・気象"
   "физико-географическая характеристика" "geography and cityscape"
   "geografie und verkehr" "géographie, géologie et toponymie"
   "geografisch" "geografia e clima" "geographical location"
   "physical geography" "география"
   "géographie, administration et urbanisme" "地理・地域" "地理と気候"
   "geografía" "地理" "الموقع" "geography and climate"
   "caracterização geográfica" "geography, climate, and wildlife"
   "geografía y localización" "geografia e população"
   "localização geográfica" "site et localisation"
   "geografía y geología" "geografia" "geographie" "الموقع والمساحة"
   "جغرافيا" "lage und klima" "geografische ligging"
   "geografie en klimaat" "地理和气候" "géographie naturelle" "地理气候"
   "الجغرافيا" "geografía y entorno" "geografie" "地理与气候" "géographie"
   "geografia fisica" "géographie et quartiers de saint-denis"
   "géographie et développement"},
 :embassies #{"consulates" "консульства" "посольства" "ambassades"},
 :when-to-go #{"quando andare"},
 :arts #{"art" "art dans la ville" "arts" "искусство и культура"
   "искусство"},
 :with-children
 #{"wien mit kindern" "für kinder"
   "amusement park and children's activities" "прага для детей"},
 :islands #{"islas" "isole"},
 :get-around
 #{"rondreizen" "circuler et conduire" "circule" "circuler"
   "cómo desplazarse" "mobilität" "come spostarsi" "se déplacer"
   "circular"},
 :understand
 #{"comprenez" "übersicht" "comprenda" "comprendre" "hintergrund"
   "城区概述" "понять" "概要" "概況" "Understand"},
 :events
 #{"special events" "événements sportifs" "annual and seasonal events"
   "ricorrenze tradizionali e festival" "festivités" "événements"
   "évènements" "节日" "eventi culturali periodici" "культурные события"
   "eventi famosi" "kulturelle ereignisse" "sport events"
   "celebrazioni" "annual town events" "evénements"
   "calendario festivo" "evènements" "festivals and events"
   "marché de noël" "calendario degli eventi" "eventos regulares"
   "manifestazioni" "manifestations culturelles" "أحداث" "мероприятия"
   "events and festivals" "sportveranstaltungen" "annual attractions"
   "sporting events" "事件" "fêtes et festivals" "notable events"
   "manifestations" "regelmäßige veranstaltungen / feste"
   "festivals/events" "folclore e manifestazioni" "events and folklore"
   "local events" "carnevale" "eventi" "veranstaltungen und feste"
   "feste und veranstaltungen" "yearly events" "wine events"
   "événement" "مناسبات واحتفالات في ميونخ" "événements et folklore"
   "besondere ereignisse" "major events and festivals" "evenementen"
   "regelmäßige kulturelle veranstaltungen" "eventi e manifestazioni"
   "events in the town" "мероприятия, проводимые в москве"
   "eventi culturali" "le manifestazioni culturali" "cultural events"
   "événements culturels" "festivals & events" "oktoberfest"
   "eventi annuali" "eventi sportivi" "events"
   "regelmäßige veranstaltungen" "eventi e feste"
   "مناسبات واحتفالات برلين" "messe münchen" "événements annuels"
   "できごと" "events & festivals" "annual events" "acontecimientos"
   "festivals" "festivals / événement"
   "manifestations culturelles et festivités" "eventos"
   "veranstaltungen" "催事"}
  :introduction #{:abstract}})

(def languages
  #{"en" "it" "fr" "pt" "ar" "nl" "ko" "ru" "pl"})
