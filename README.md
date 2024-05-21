# Mercado Libre Search

|   Personal Info    |                                 |
|-------|---------------------------------|
| Name  | Christian Alfredo Chamorro Vela |
| Email | chamorro.vela@gmail.com         |
| Phone | +57 3016611974                  |

<br>
MercadoLibre - Search is a test application where the Mercado Libre public API is consumed, the favorite products and search history are stored locally.

## Demo
<img src="Demo.gif" width="300">

## Architecture

The project was structured in modules: application, features and common libraries, this allows each module to be reusable and have a single responsibility.

![Structure](projectStructure.png)

|Module|Description|
|---|---|
|**App**|This module integrates the entire application and handles navigation.|
|**Features**|Modules that represent a feature that can be reused or interchangeable.|
|**Commons**|Libraries and utilities that are used by the features.|

Each feature module is based on clean architecture segmenting the presentation, domain and data layers.

![Architecture](FeatureArchitecture.png)

|Layer|Description|
|---|---|
|**Domain**|This layer defines the logic and business rules through usecases and models, and additionally defines the repositories to access the information.|
|**Presentation**|Presentation layer where composables, screens and viewmodels are defined to manage the state of the views, it depends on the domain layer.|
|**Data**|Layer for data access that implements the repositories defined in domain and the local and remote data sources.|

## Code Quality

To ensure the quality of the code, the following tools were used:

|Tool|Description|
|---|---|
|**Unit Testing**|Implemented unit tests in repositories and usecases using junit and the Mockk library.|
|**Ktlint**|Linter to verify code style and quality.|
|**Manual regregressions**|Functional tests with emulator following the requirements flows.|

## Libraries

For the development of this project the following libraries were used:

|Library|Description|
|---|---|
|**Room**|Official Android library for SQLite database storage.|
|**Retrofit**|Library to implement http client.|
|**Jetpack Compose**|Official Android library for UI implementation with composables.|
|**Coil**|Library for loading and caching images.|
|**Mockk**|Library for the implementation of mocks and stubs in unit tests.|
|**Hilt**|Official Android library for dependency injection.|