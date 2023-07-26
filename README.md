# StarWars_Test
Welcome to the StarWars_test project! This repository contains an Android app developed using Jetpack Compose, MVI architecture, Kotlin Flow, and Clean Architecture. The app allows users to search for characters, starships, and planets from the Star Wars universe using the data provided by the SWAPI (Star Wars API).

# Features
User-friendly interface using Jetpack Compose for UI development.
MVI (Model-View-Intent) architecture for a clear separation of concerns.
Utilization of Kotlin Flow for asynchronous data streams and reactive programming.
Clean Architecture for maintainable and scalable codebase.

# App Functionality

# Search Page
The main page displays an input element that allows users to search for characters, starships, and planets by "name."
The API call is triggered only after the user enters at least 2 characters in the search input.

# Favorites Page
The favorites page displays detailed information for Star Wars characters and starships.
For characters, it shows "name, gender, and number of starships this person has flown."
For starships, it shows "name, model, manufacturer, and passenger capacity."
