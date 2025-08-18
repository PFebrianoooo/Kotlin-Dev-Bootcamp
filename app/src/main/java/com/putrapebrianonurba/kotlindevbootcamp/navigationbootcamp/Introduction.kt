package com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp

// Navigation Bootcamp
/*
Navigation
Merupakan sebuah cara untuk berpindah ke satu layar ke layar lainnya yang berbeda layar. Konsep navigation bila merujuk pada produk, menjadi detail screen
bagi produk yang akan di tampilkan.

Ada beberapa macam materi navigation yang akan di bahas disini
1. What Navigation is? and How to navigate between screens?
2. How we passing a data to another screen?
3. Nested Navigation
4. Navigation work with scaffold

Understanding the jargon
Beberapa yang diperlukan untuk membuat sebuah navigation & how they work together?
a. NavHost (Tour guide) DIFFERENT FILE/SAME SCREEN
b. NavController (Map) DIFFERENT FILE/SAME SCREEN
c. NavGraph (Everything that controlled a till e component) DIFFERENT FILE/SAME SCREEN
d. Destination (Screen) SCREEN ITSELF
e. Action (Route Destination) ON SCREEN

NB:
- Different screen or same file, based on team needed and the project itself
- Must importing dependency


Fungsi- Fungsi yang ada pada navigation
1.


I Got Some My Mind
1. Navigation dengan scaffold bottom bar dan tiap menu pada bottom bar berisi first screen dan navigation
   a. Single Nav Host (NESTED NAV)
       MainActivity (Component Activity)
     └── Scaffold
          ├── BottomBar (ubah currentTab)
          └── NavHost(navController, startDestination = "home_graph")
               ├── home_graph
               │     ├── HomeScreen (Composable)
               │     ├── DetailProductScreen
               │     └── StoreDetailScreen
               │
               ├── search_graph (Composable)
               │     ├── SearchScreen
               │     ├── SearchResultScreen
               │     ├── DetailProductScreen
               │     └── StoreDetailScreen
               │
               └── profile_graph (Composable)
                     └── ProfileScreen

   b. Multiple Nav host
       MainActivity (Component Activity)
     └── Scaffold
          ├── BottomBar (ubah currentTab)
          └── when(currentTab) {
                  HOME -> HomeNavHost(homeNavController)
                  SEARCH -> SearchNavHost(searchNavController)
                  PROFILE -> ProfileNavHost(profileNavController)
              }

        // Composable
        HomeNavHost
         ├── HomeScreen
         ├── DetailProductScreen
         └── StoreDetailScreen

        SearchNavHost
         ├── SearchScreen
         ├── SearchResultScreen
         ├── DetailProductScreen
         └── StoreDetailScreen


*/