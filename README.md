# CompanyReviews
Android application built in Kotlin, designed to take JSON input and parse the data into an application for reviewing companies.

There are three different model objects: Review, Interview, and Salary, where the given data is stored. The data is first retreived using Okhttp, and then parsed into the model objects using GSON. Each model object can be clicked to open a second screen with their corresponding data populating that screen. The images for each company are also retrieved and displayed using a 3rd party library (Picasso).

### 3rd Party Libraries

#### Okhttp
Okhttp was necessary for retreiving the JSON object representing the data from the link provided, and JSON was used to store these values into objects from which the data could be retreived and placed into the Model objects (Review, Interview, or Salary).

#### GSON
GSON was used to parse the data retreived from the JSON objects built off of the original data. GSON parsed said data into each model object, depending on the type provided in the data, and then returned a new object which could be appended to a list. 

#### Picasso
Picasso was used to retreive the company logo from the URL provided in the data, and then display that image by storing it into an ImageView in either screen. 


### Challenges Faced

I initially had some trouble retreiving the data from the URL given, because I was not aware of the Okhttp library. I also had issues actually using Okhttp to retreive said data, but this was because the emulator was not connected to the internet, and this was resolved by adding Google's IP to my systems recognized DNS servers. 

There were also some issues with using GSON to parse the data, as I had originally labeled each variable in the model objects differently from the fields in the original data. This was fixed by renaming all the varriables in each model object to match the data, which fixed that issue and allowed GSON to automatically store each field in the data into the model object variables as Strings or Ints. 


### What I Would Have Liked to Added

The UI for the application is very barebones. If I had more time to work on the application I would have liked to clean up UI elements of the application and add some transition effects between screens. 


### Other Notes

Occasionally the application does not display any cards on startup. I could not figure out any solution to this, other than simply restarting the application from Android Studio. Sometimes the project also needed to be cleaned, but this is easily resolvable by cleaning the project.
