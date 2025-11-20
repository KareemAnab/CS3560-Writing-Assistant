# Writing Assistant

AI-powered writing tool with different modes (creative, professional, academic).  
Built for the CS3560 API Integration Project.

## Setup

1. Get an OpenAI API key from the official website.
2. Copy `src/main/resources/config.properties.example` to `src/main/resources/config.properties`.
3. Edit `config.properties` and set:
   - `OPENAI_API_KEY`
   - `OPENAI_BASE_URL`
   - `MODEL_NAME`
4. Build and run `Main.java`.

Important: Do not commit `config.properties` to Git. The file is ignored via `.gitignore`.

## Features

- Creative, professional, and academic writing modes
- Save and load sessions to keep your work between runs
- Responsive Swing GUI (no console interaction)
- Error handling for:
  - Network failures
  - Invalid or missing API key
  - Rate limiting responses

## Design Patterns

- Strategy: Different writing behaviors (Creative, Professional, Academic) that all implement a common interface.
- Factory: `RequestFactory` builds JSON request bodies for the OpenAI API.
- Singleton: `APIClient` ensures a single HTTP client and shared configuration.
- Observer: `DocumentModel` notifies UI listeners when the document text changes.

## Architecture (MVC)

- Model:  
  `DocumentModel`, `SessionManager`, strategies, factory, and `APIClient`.  
  Handles the document state, file I/O, and API request creation.

- View:  
  `MainFrame` (Swing UI component).  
  Displays text, mode selection, and status messages.

- Controller:  
  `MainController` connects the view and model.  
  It reacts to button clicks, triggers async API calls, and updates the model.

## API Integration

- Uses Java `HttpClient` to send JSON requests to the OpenAI API.
- Reads configuration from `config.properties` instead of hardcoding keys.
- Performs calls on a background thread using `SwingWorker` to keep the UI responsive.
- Handles error cases with clear messages, without exposing sensitive data.

## Testing

JUnit tests (10 total), including:

- `DocumentModelTest`: verifies observers are notified when text changes.
- `RequestFactoryTest`: verifies the JSON body is built correctly.
- `SessionManagerTest`: verifies saving and loading sessions.
- `APIPromptServiceExtractContentTest`: checks that content is parsed correctly from a sample JSON string.
- Strategy tests for each writing mode.

To run tests:

```bash
mvn test
```

or use your IDE's test runner.

## Demo Video

The demo video should:

1. Show the UI and different writing modes.
2. Demonstrate a successful request.
3. Demonstrate error handling (for example, temporarily using an invalid key).
4. Mention where the API key is stored and how it is kept out of the repository.

A link to the uploaded video (YouTube or Drive) can be added here:

- Demo Video: [link goes here]

## AI Assistance Disclosure

I used ChatGPT to help design and implement this project, including parts of the architecture, sample code, and documentation. I have reviewed and studied every line of code that I am submitting and I am able to explain how it works if asked in office hours or during grading.
