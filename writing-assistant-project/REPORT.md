# Project Report – Writing Assistant

## Challenges We Faced

### Challenge 1: API Errors
- **Problem:** We had issues with invalid JSON and failed API responses early on.
- **Solution:** We improved input escaping, tested with example responses, and added clearer error messages.
- **What we learned:** Always test API responses separately and never assume the response format is perfect.

### Challenge 2: Keeping the UI Responsive
- **Problem:** The UI originally froze during API calls.
- **Solution:** We implemented SwingWorker to run the network request in the background.
- **Learned:** Never perform long operations on the UI thread.

### Challenge 3: Organizing Code
- **Problem:** At the beginning, logic and UI code were mixed.
- **Solution:** Switching fully to MVC made things much cleaner.
- **Learned:** Good structure makes debugging easier.

## Design Pattern Justifications

### Strategy Pattern
We used this to separate each writing mode (Creative, Professional, Academic). Each mode has its own 
prompt-building behavior, and the service just chooses the right strategy.

### Factory Pattern
The RequestFactory builds the JSON body for the API. This keeps the controller free from formatting logic 
and makes it easy to test and modify the request structure.

### Singleton Pattern
APIClient is a singleton so the program only creates one HttpClient. This avoids duplicate configuration 
and keeps API logic centralized.

### Observer Pattern
The DocumentModel notifies the view whenever its text changes. This kept the UI updates clean and prevented 
tight coupling between model and view.

## API Usage
We used the OpenAI Chat Completions endpoint. We added handling for:
- network errors
- invalid keys
- empty user input
- malformed or unexpected JSON responses

## Testing Summary
We wrote over 10 JUnit tests. They covered:
- Model updates and listeners
- Session save/load
- Strategy behavior
- Request building structure
- Content extraction
- Error handling

## AI Usage
We used ChatGPT for guidance, design pattern brainstorming, and documentation help. We made sure to 
understand and revise everything so we can explain any part of the project if needed.

## Time Spent
Around **~25 hours**, including design, coding, debugging, UI work, testing, and completing documentation.
