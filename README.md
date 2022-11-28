# Weather
Weatherapp is a simple weather forecast app, which uses some APIs to fetch 5 day / 3 hour forecast data from the OpenWeatherMap and to fetch places,cities,counties,coords etc. from Map.ir Places. The main goal of this app is to be a sample of how to build an high quality Android application that uses the Architecture components, Hilt etc. in Kotlin.

### Libraries and tools

+ [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/)
+ [Shared Preferences](https://developer.android.com/training/data-storage/shared-preferences)
+ [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
+ [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
+ [Transformations](https://developer.android.com/reference/androidx/lifecycle/Transformations)
+ [Data Binding](https://developer.android.com/topic/libraries/data-binding)
+ [RoomDB](https://developer.android.com/topic/libraries/architecture/room)
+ [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
+ [RxJava](https://github.com/ReactiveX/RxJava)
+ [RxAndroid](https://github.com/ReactiveX/RxAndroid)
+ [Retrofit](https://square.github.io/retrofit/)
+ [OkHttp](https://github.com/square/okhttp)
+ [Moshi](https://github.com/square/moshi)
+ [Material Design](https://material.io/develop/android/docs/getting-started/)

### Testing

+ [Mockk](https://github.com/mockk/mockk)

### Architecture

The app uses MVVM [Model-View-ViewModel] architecture to have a unidirectional flow of data, separation of concern, testability, and a lot more.

![image](https://user-images.githubusercontent.com/28188198/204174066-2146dc1f-f382-4c9e-9be8-95f5ff896bc3.png)

### Dependency Graph
![image](https://user-images.githubusercontent.com/22769589/69224544-ce709380-0b8d-11ea-9bb5-51e9ea8828c9.png)
