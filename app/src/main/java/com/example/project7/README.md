# Project_07 - Reconfiguring Notes App
<span style="font-size: smaller;"><strong>Ashley Steitz and Jacob Fritz worked on this as partners</strong></span>

---
<span style="font-size: smaller;"><strong> Description </strong> </span>
In our efforts to complete Project 07 we implemented an interactive Ui (User Interface) that allows the user to add notes utilizing Firebase's Realtime Database.

This app allows for a user to:
- Log in to their account
- Sign up if they are not in the system
- Create a new note
- Edit a previous Note
- Delete an Existing Note

To begin we integrated Firebase into our data handling to store our user entries. We used a recycler view to store the notes and display them on the main note page (screen)
and it allows for users to scroll and view all posted notes without fear of losing the content when it goes off the page!
<br>
<br>
To begin a user is prompted to sign in to the notes app. If they do not have an account they can sign up if they have an account they will be brough back to their previous
notes app with their previously made notes.
<br>
<br>
Once on the home page a user can click the upper band's add not button in order to "Add a Note" in the ribbon  of the main screen where they are taken to the next fragment, prompting for a Note Title and Note Body.
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
* [Add Note] -> [TITLE:Gettysburg address intro] 
[Typed: Four score and seven years ago our fathers brought forth on this continent a new nation] [SAVE]
* [Add Note] -> [TITLE:Lyrics to One Direction's That's what makes you beautiful] [Typed:You're insecure, don't know what for You're turning heads when you walk through the door] [BACK]
* [Add Note] -> [TITLE:Cities I have visited] [Typed: I have been to New York, I have been to Seattle, I have been to Chicago, I have been to Paris, I have been to Madrid] [SAVE]
* [Delete Note] -> [Clicked the second cities I have visitied] -> [Are you sure? Yes/No] -> [Yes] 
* [Add Note] -> [TITLE:Animals you see at the Zoo]  [Typed: When i went to the zoo recently. When I I went I saw many animals. I saw lions, i saw elephants, i saw monkeys, i saw orangatans, i saw snakes, and so many more!] [SAVE] [SAVE]

<br>

**END**


---
## Video Walkthrough
Watch a demonstration of the different options when working with the notes app in the gif available on Github
Here's a walkthrough of a few translations:
**there was a slight adjustment to the buttons size that was implemented after the video was created and the changes do not alter the performance of the app -> however this changes clossly
reflects the UI requested in the PDF**
<br>
<img src='https://github.com/asteitz/Project_6/blob/master/app/src/main/java/com/example/project_7/RecordingNotesApp.gif' title='Project6 Video Walkthrough' width='50%' height = '50%' alt='Video Walkthrough' />

GIF created with [CloudConvert](https://cloudconvert.com/).

## Notes
UI Challenges:
- Not much changed, but we built off our previous learnings from Project 6's challenges
- Integrating a recycler View into the UI for the main notes page
- Adding in a constraint layout to keep the buttons in place when the user is typing
- Adding function calls inside the xml files

Backend Challenges:
- Shifting our approach from a SQL based database and utilizing a call to Firebase and the configuration files
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