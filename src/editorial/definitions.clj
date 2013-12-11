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
               :understand
               :history
               :with-children
               :arts
               :beaches
               :climate
               :culture
               :districts
               :do
               :etymology
               :events
               :festivals
               :food
               :gastronomy
               :gay-travelers
               :geography
               :heritage-and-monuments
               :architecture
               :islands
               :landmarks
               :parks-and-recreation
               :respect
               :sport
               :the-port
               :theater
               :toponym
               :urbanism]}])

; map that allows for the mapping between logical section names and their 
; names in different language. Content pulled from sources is categorized
; into the right logical section with this mapping. 
(def logical-section-map
  {:understand #{"Comprenez" 
                 "comprenda" 
                 "comprendre" 
                 "comprenez" 
                 "hintergrund" 
                 "Übersicht" 
                 "Понять" 
                 "城区概述" 
                 "概況" 
                 "概要"
                 "understand"}

   :introduction #{"abstract"}

   :with-children #{"with children"}

   :arts #{"art" "art dans la ville" "Искусство" "Искусство и культура"}

   :history #{"Histoire de Florence" 
              "History" "geschichte"
              "geschichte isfahans"
              "geschichte und stadtgründung"
              "geschiedenis"
              "histoire"
              "histoire d'ypres"
              "histoire de florence"
              "histoire de grenade"
              "histoire de münster"
              "histoire de zonnebeke"
              "histoire et culture"
              "histoire et description"
              "histoire et étymologie"
              "historia"
              "historique"
              "história"
              "storia"
              "storia della città"
              "Исторические сведения"
              "История"
              "История Иерусалима"
              "История и культура"
              "Краткая история орода"
              "历史"
              "城市歷史"
              "歴史"
              "歴史と文化"
              "歴史と概要"
              "歷史"}


  :climate #{"climate" 
             "Klima und Reisezeit" 
             "clima"
             "climat" "climatología"
             "géographie et climat" "il clima"
             "klima" "klima und geographie"
             "klima und hurrikane"
             "klima und reisezeit" "klimaat"
             "klimatabelle" "Климат"
             "Погода" "气候" "気候"
             "気象" "氣候"}

  :culture #{"Kultur und Nachtleben"
             "art, culture and nightlife"
             "art and culture"
             "art et culture"
             "arte e cultura"
             "arte y cultura"
             "arti, intrattenimento e cultura"
             "arts, culture and heritage"
             "arts, culture and tourism"
             "arts, entertainment, and culture"
             "arts & culture"
             "arts and culture"
             "arts et culture"
             "arts et cultures"
             "atrações culturais"
             "attractions and culture"
             "beni culturali"
             "bezienswaardigheden en cultuur"
             "cultura"
             "cultura, architetture e luoghi di interesse"
             "cultura e attrazioni"
             "cultura e folklore"
             "cultura e intrattenimento"
             "cultura e luoghi d'interesse turistico"
             "cultura e società"
             "cultura e stile di vita"
             "cultura e turismo"
             "cultura e vita contemporanea"
             "cultura ed economia"
             "cultura y lugares de interés"
             "cultura y museos"
             "cultura y ocio"
             "cultura y patrimonio"
             "cultura y turismo"
             "culture"
             "culture, tourisme et patrimoine"
             "culture & events"
             "culture and architecture"
             "culture and art"
             "culture and arts"
             "culture and attractions"
             "culture and contemporary life"
             "culture and entertainment"
             "culture and events"
             "culture and festivals"
             "culture and heritage"
             "culture and recreation"
             "culture and sights"
             "culture and the arts"
             "culture and tourism"
             "culture et art"
             "culture et communications"
             "culture et curiosités"
             "culture et lieux"
             "culture et loisirs"
             "culture et manifestations culturelles"
             "culture et monuments"
             "culture et patrimoine"
             "culture et principaux sites"
             "culture et tourisme"
             "culture et vie au mans"
             "culture et événements"
             "culture locale et patrimoine"
             "cultuur"
             "cultuur en bedrijvigheid"
             "cultuur en bezienswaardigheden"
             "cultuur en ontspanning"
             "cultuur en recreatie"
             "kultur"
             "kultur und freizeit"
             "kultur und sehenswürdigkeiten"
             "kunst, cultuur, erfgoed"
             "kunst, cultuur en uitgaansleven"
             "kunst, sehenswürdigkeiten und freizeit"
             "kunst en cultuur"
             "langue et culture"
             "patrimoine culturel"
             "patrimoine et culture"
             "patrimoine et culture locale"
             "vie culturelle"
             "Культура"
             "Культура и архитектура"
             "Культура и достопримечательности"
             "Культура и досуг"
             "Культура и искусство"
             "Культура и общество"
             "Культура и отдых"
             "文化"
             "文化と現代的な生活"
             "文化と見所"
             "文化・スポーツ"
             "文化・生活"
             "文化・芸術・音楽"
             "文化和名胜"
             "文化娱乐"
             "文化的特徴"
             "歴史遺産と文化"
             "艺术与文化"
             "芸術、文化及びスポーツ"
             "芸術と文化"}})

(def languages
  #{"en" "it" "fr" "pt" "ar" "nl" "ko" "ru" "pl"})
