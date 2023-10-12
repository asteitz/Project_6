# Project_06 - Notes App
<span style="font-size: smaller;"><strong>Ashley Steitz and Jacob Fritz worked on this as partners</strong></span>

---
<span style="font-size: smaller;"><strong> Description </strong> </span>
In our efforts to complete Project 05 we implemented an interactive Ui (User Interface) that allows the user to select a language and translate into one of the 3 options.

This app allows for a user to:
- Create a new note
- Edit a previous Note
- Delete an Existing Note

To begin we integrated SQL into our data handling to store our user entries. We used a recycler view to store the notes and display them on the main note page (screen) 
and it allows for users to scroll and view all posted notes without fear of losing the content when it goes off the page!
<br>
<br>
To begin a user is prompted to "Add a Note" at the bottom  of the main screen where they are taken to the next fragment, prompting for a Note Title and Note Body.
After the user enters both they have the option to go "BACK" to the main page or "SAVE". If "SAVE" is pressed, then their note title and bosy are inserted into the database.
If they select back, then their note is not saved and they will return back to the main page and will _not_ see their note present.
<br>
<br>
When a user clicks onto the note title then the screen is brought up with their their previous body, allowing them to make edits to the
previously held data in that note. They need to select the save button to save their modified (or newly created note), where their changes are enacted into their note using the "Update" call to the database.
If the back button is pressed then their changes are not saved and they are brought back to the main screen.
<br>
<br>
On the main screen after a note is created, we see the title and a button with a red "X", this is a delete button and if this is pressed the user is greeted by a dialog that prompts
them to select "YES" or "NO", confirming or denying their selection to delete their note. If they delete the note the note title and body are deleted from the data base. If "NO" is selected,
then nothing happens to the database.



## Functionality
'*' indicates tested in GIF  
The following **required** functionality is completed:
<br>
Safeargs and View Groups were implemented to transfer data from MainActivity.kt to Fragment1.kt. This allows us to gather the user data and translate it in real time!

**Demonstrated**
<br>
**START** 
<br>
* [Add Note] -> [TITLE:Names of my friends] [Typed: Ashley, Jacob, Anna, Clarissa, Jenna, John, Kyle] [SAVE]
* [Add Note] -> [TITLE:Cities] [Typed: New York, Miami, Seattle, Chicago, Paris, Madrid] [BACK] 
* [Add Note] -> [TITLE:Cities] [Typed: New York, Miami, Seattle, Chicago, Paris, Madrid] [SAVE]
* [Add Note] -> [TITLE:Food] [Typed: Popcorn, Salad, Fruit, Vegtable, Pasta ] [SAVE]
* [Cities]   -> [TITLE:Cities] [Typed: New York, Miami, Seattle ] [SAVE]
* [Add Note] -> [TITLE:Test 2]  [Typed: u] [SAVE]
  [Add Note] -> [TITLE:TEST 3]  [Typed: T] [SAVE]
  [Add Note] -> [TITLE:TEST 4]  [Typed: T] [SAVE]
  [Add Note] -> [TITLE:TEST 5]  [Typed: T] [SAVE]
* [Add Note] -> [TITLE:Animals you see at the Zoo]  [Typed: Cat, Dog, Elepant, Snake, Zebra] [SAVE]
* [Add Note] -> [TITLE:Hello] [Typed: Hello, Aloha, Hola, Bonjour, Ni Hao, Halo ] [SAVE] 
* [Animals]  -> [TITLE:House Pet]  [Typed: Cat] [BACK]
* [Cities] [BACK]
* [House Pet] [Type: Cat] [BACK]
* [Test 2] [X] [yes]
* [TEST 3] [X] [yes]
* [TEST 4] [X] [yes]
* [TEST 5] [X] [yes]
* [friends] [X] [no]

<br>

**END**


---
## Video Walkthrough
Watch a demonstration of the different options when working with the notes app in the gif available on Github
Here's a walkthrough of a few translations:
**there was a slight adjustment to the buttons size that was implemented after the video was created -> however this changes clossly
reflects the UI requested in the PDF**
<br>
<img src='https://github.com/asteitz/Project_6/blob/master/app/src/main/java/com/example/project6/RecordingNotesApp.gif' title='Project6 Video Walkthrough' width='50%' height = '50%' alt='Video Walkthrough' />

GIF created with [CloudConvert](https://cloudconvert.com/).

## Notes
UI Challenges:
- Had the wrong auto set for the view of the notes (needed to be wrap contents instead of match parent)
  - due to this we were not able to see the notes as they popped up
- Integrating a recycler View into the UI for the main notes page
- Adding in a constraint layout to keep the buttons in place when the user is typing
- Adding function calls inside the xml files

Backend Challenges:
- Big issues with having the data being passed between the fragment and the database had to request extension and attend office hours
- Difficult time with the gradle files and versions not being compatible
- Struggled integrating the SQL database into the calls when a button is pressed
- Working with an adapter to communicate between the view model and the database

## License

    Copyright [2023] [Ashley Steitz, Jacob Fritz]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.