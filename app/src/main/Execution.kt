// Small Summary
/*
< Execution Runtime >
> Secara Garis besar
Os -> Launcher -> Launcher Activity

> Detail with files Included
os => Launcher/Manifest (AndroidManifest.xml) => Launcher Activity (MainActivity.kt) -> MainActivity.onCreate() -> SetContent {} ->
MyAppTheme -> Scaffold/Surface -> Composable (Greeting()) -> Text() -> GreetingPreview()

Description
1. OS membuka aplikasi yang mana akan eksekusi android manifest/Launcher
2. Launcher activity in case adalah MainActivity.kt akan dieksekusi sebagai entry poin ke dua sebagai tampilan UI
3. Mengeksekusi seluruh yang ada di MainActivity.kt

nb:
for description of each files or function will included on each file
*/