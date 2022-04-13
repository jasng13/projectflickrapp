# projectflickrapp
Sample App that consumes Flickr Api with search capability.

Sample web service feed: https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=API_KEY&text=kittens&format=json&nojsoncallback=1

Flickr Web Service Documentation:
(https://api.flickr.com)

## Requirements
Listed below are the requirements for this app

•The app should display the first page of results returned by the API. However, see the bonus
task section for additional optional requirements.
• The app should correctly handle orientation changes. i.e. image search term and results should
remain after screen rotation. If you’re writing this app in Android, we’d like you to avoid
requiring android:configChanges in the manifest file.

• Don’t worry about supporting old versions of iOS and Android, the latest versions are fine.

• make use of the following approach, and encourage you to show us your skills in
these areas, or similar:
    - We use the MVVM software architecture pattern, with a navigation coordinator
    - RXJava on Android
    - Dependency injection
    - Feel free to use the technologies you are most comfortable with. This includes any
open-source third-party libraries.

### General:

Your list should show the following details from the API:
- image in Grid 3x3 recycler view
- dynamic search - display default api if there is no input 

## Libraries
- Kotlin
- Coroutines
- RxJava2
- Hilt
- Dagger2
- Retrofit
- Glilde
- Mockito
- Espresso
## Architecture
- The application attempts to adhere in MVVM structure. Clean Code and SOLID Principles are also observed while working on the application
- Main language for this application is Kotlin and other Android Development Kit is also used


## Further Enhancements / Dev personal note
- Implement UseCase instead of direct access to repository in view model & handle exceptions (handle no internet service connection)
- Unit testing : implement unit tests in Mockito / Espresso
- Simplify gradle dependency versions by having a separate file (versions.gradle) to place all versions of the dependency
