package com.putrapebrianonurba.kotlindevbootcamp.coroutines

// Small Summary
/*
Lifecycle, ViewModelScope & launchedEffect
1. LifecycleScope (Activity)
   Merupakan sebuah scoping coroutines yang akan hidup ketika activity masih tampil di layar, apabila activity tidak tampil di layar
   coroutines akan hilang, dan akan muncul kembali apabila activity tampil di layar.

2. viewModelScope (ViewModel)
   Merupakan sebuah scoping coroutines yang akan hidup selama owner (activity/composable/backstackentry) masih ada. begitu pindah screen
   yang tidak memiliki view model sama sekali, viewmodelscope akan destroy dan memanggil fungsi onCleared, jika ada!


   Example Code
   fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repo.fetchUsers()   // suspend function
            _users.value = data
            Log.d("VM", "Users loaded in VM scope")
        }
    }

3. Launched Effect (Composable)
   Merupakan scope coroutine yang akan hidup apabila composable muncul di layar, apabila tidak muncul di layar. maka scoping coroutine akan hilang

   // LaunchedEffect = jalan sekali saat Composable masuk composition
    LaunchedEffect(Unit) {
        Log.d("COMPOSE", "LaunchedEffect started")
        viewModel.loadUsers()
    }
*/