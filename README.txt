# CacheProject

1. Cache został stworzony w klasie CacheManager, która implementuje interfejs Cache.
2. Klasa CacheManager zawiera w sobie klasę wewnętrzną CacheViewManager, która implementuje interfejs CacheView.
3. Klasa LinkedMap, która rozszerza LinkedHashMap została wykorzystana do przechowywania obiektów w cache'u. Zawiera ona dodatkową metodę umożliwiającą pobieranie obiektów za pomocą indexu.
4. Klasy ItemA, ItemB, ItemC, ItemD implementują interfejs CacheItem i służą do tworzenia obiektów przechowywanych w cache'u.
5. Dodatkowo w folderze 'test' znajduje się kilka testów jednostkowych napisanych z wykorzystaniem biblioteki jUnit.
6. Przykładowe działanie programu zostało zaprezentowane w klasie Main. W klasie CacheManager został ustawiony maksymalny rozmiar cache'a.
