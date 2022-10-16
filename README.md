# Coles Coding Challenge
## Table of content
- [Overview](#overview)
- [Requirements](#requirements)
- [Usage](#usage)
- [Technologies and libraries](#technologies-and-libraries)
- [Architecture and design decisions](#architecture-and-design-decisions)
- [Standards](#standards)
- [Implementation decisions and compromises](#implementation-decisions-and-compromises)
- [Tests](#tests)
- [CI/CD](#continuous-integration-and-delivery)
- [Caching and data-sync](#caching-and-data-sync)
- [Dependencies management](#dependencies-management)
- [Acknowledgement](#acknowledgement)

## Overview
ColesChallengeApp  is developed by Alex Duong in accordance with requirements defined by Coles coding challenge. 
The app intends to provide a grid of available recipes, data is provided from a .json file called recipesSample.json

## Requirements
[Please see this document for requirements](https://github.com/bhlaing/MyMonashApp/blob/master/challenge.docx)

## Usage
Launching - Simply launch the app by tapping on the app icon <br />
Refreshing - Kill and Launch 

## Technologies and libraries 
App uses 100% kotlin, Architecture components, Coroutines, Hilt, ViewModel, LiveData

## Architecture and Design decisions
The app is implemented in MVVM pattern in conjunction with clean architecture
<br/><br/>
**MVVM design pattern**
<br/><br/>
MVVM is an alternative design pattern to traditional design patterns such as MVP, MVC in android development. Primarily decouple UI to business logic,
allows further ease of access, maintain and alter in code development
**Clean architecture and benefits**
<br/><br/>
Clean architecture allows us to decouple business logics from android framework. The use of domain use-cases (in this case)
meaning each business logic is isolated from view.
Each feature will be declared separately as prefix feature_xxx.
Each feature also holds it's own \_di module to allow easy refactor or removal <br/> 

## Standards
**Themes and Styles**
Due to time constrains, Theme + Style are default in Android Project Creation

**Model naming**
- Data layer models are surfixed with xxxDTO (data transfer object) (For example, RecipeDTO.kt)
- Domain layer models has neither prefix or surfix
- Presentation/ui layer models are surfixed with Displayxxx (For example, DisplayRecipeGeneral.kt)

**Layout naming**
- Root layouts are prefixed with layout_xxx
- Child layouts are prefixed with view_xxx

**Drawable resource naming**
- Icons are surfixed with ic_xxx

## Implementation decisions and compromises 
### Implementation decisions 

**Asynchronous flow**
- The application utilises coroutine flows to achieve live data update for available recipes information

### Compromises
**Graphics**
_ Logos, icons from the app are converted to .webp format in order to reduce size of the application
  
**Data**
- Data recipes is provided in the given .json file. 
<br/>

**Exception handling**<br/><br/>
Exceptions are omitted and treated as empty responses due to time-constraint.

**Uses of coroutine experimental APIs**<br/><br/>
Uses coroutine experimental such as _callBackFlow_ and _TestCoroutineDispatcher_ to accelerate development

**Testing**
_ Due to minimal of knowledge in testing, this can be implemented with use-case classes.
_ UI testing can also be performed with ViewModel
## Tests
- No Testing was conducted
## Continuous integration and delivery
- Not Applicable
<br />
## Caching and data sync
**Persistency**
- Offline capability can be developed by caching through Room Database. Due to time constrain, have not implemented it.

## Dependencies management
Dependencies and versions are declared in .gradle Module

## Acknowledgement 
I would like to have a great thank you to Coles for the opportunity of a such good experience. 
Also to the ideology from my former mentor, Phyo (Billy) Hlaing










