# MVVM-APP-Demonstration
MVVM App using Retrofit and Glide

Model–view–viewmodel is a software architectural pattern that facilitates the separation of the development of the graphical user interface from the Data.  

In MVVM, the Model is made up of the data models, business logic and application data.



## General Retrofit MVVM architecture below:

![final-architecture copy](https://user-images.githubusercontent.com/44032084/155833036-52d960d6-e28f-44df-a81a-dcf275c3e36c.jpg)



## What is Retrofit?

Retrofit is a type-safe REST client for Android, Java and Kotlin developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp.

Retrofit is type safe in the sense that we  strictly defined what kind of result we are getting, and we are getting this or nothing/error. Of course the error is on runtime, as we can't never really know what will be retrieved from the internet.

More details can be found below
https://square.github.io/retrofit/


## Retrofit API

```
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    
    //GSon API to convert JSON to Objects
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
    //HttpLogging interceptor to intercept incoming Stream. 
    implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'
```


## Glide

Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

More can be found below:

https://github.com/bumptech/glide


For this project we will be using glide to load Images

```
    implementation 'com.github.bumptech.glide:glide:4.10.0'
```


## LiveData

LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

For this project, LifeData Observes the Incoming request and Updates the Observers when a new data is made available or changed

```
    //LiveData and View Model
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
```

## Google Book API

For this project we will be using Google's Book API
``` 
https://www.googleapis.com/books/v1/volumes?q=harry&inauthor=rowling

```

In order to search for books using a keyword and author we will need to use a GET request passing in the keyword and author as query parameters.


The complete project is available above
