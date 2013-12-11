(ns 
  "manual mapping of the categories title to logical categories
  as well as template description."
  editorial.categories)


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

   :history #{"Histoire de Florence" 
              "History" "geschichte"
              "geschichte"
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



   


