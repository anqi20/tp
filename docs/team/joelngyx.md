# Joel Ng Yi Xian - Project Portfolio Page

## Overview:

E-Duke-8 (pronounced "Educate") helps CS2113/T students learn and understand software engineering and Object-Oriented Programming (OOP) principles through a gamified platform and enhances their learning experience. 


## Summary of Contributions:

### Enhancements implemented:

- **New Feature:** Topic and TopicList components. 
  - What it does: The TopicList component stores Topic objects, each of which stores the description, note list and question list of the topic.
  - Justification: Necessary for the compartmentalization of data

- **New Feature:** Implemented the NoteCommand component
  - What it does: This command is a type Command object. Entering an input containing the following formats: ``note add``, ``note delete``, ``note list`` will throw this command and process the instruction provided.
  - Justification: Necessary to add/delete/list notes.

- **New Feature:** Implemented the Note and NoteList components.
  - What it does: The NoteList components store Note objects, and contains methods that can modify the NoteList object.
  - Justification: Necessary for the processing of the NoteCommand. 

### Code contributed: [RepoSense link](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=joelngyx&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=false)

### Enhancements to existing features:

- Removed redundant code in the DisplayableList interface which allowed for the better implementation of features.
  Made necessary additions and amendments to various classes and JUnits tests.
- Made necessary additions and amendments to the UserStorage class to accommodate improvements made to the `Note` and `NoteList` classes.

### Contributions to documentation

- User Guide:
  - Added documentation for the setup of E-Duke-8 [Quick Start](https://ay2021s1-cs2113t-f12-3.github.io/tp/UserGuide.html#2-quick-start).
  - Added documentation for the adding, deleting, and the listing of notes: [Adding a note](https://ay2021s1-cs2113t-f12-3.github.io/tp/UserGuide.html#312-adding-a-note-note-add),
   [Deleting a note](https://ay2021s1-cs2113t-f12-3.github.io/tp/UserGuide.html#313-deleting-a-note-note-delete),
   [Listing a note](https://ay2021s1-cs2113t-f12-3.github.io/tp/UserGuide.html#314-listing-out-notes-note-list).
   
- Developer Guide: 
  - Added design and implementation details of the Topic and TopicList components [Link](TBC).
  - Added design and implementation details of the Note and NoteList components [Link](TBC). 
  - Added UML and sequence diagrams relevant to the Topic, TopicList, Note and NoteList components [Link](TBC).

### Contributions to team-based tasks:

### Review contributions:

- PRs reviewed:
  - 
  -

### Contributions beyond the project team:

