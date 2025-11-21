# Writing Assistant

This project is a simple writing assistant that will be used as a prototype for the final project.

## Setup

1. Get an OpenAI API key.
2. Copy `config.properties.example` → `config.properties`.
3. API key is inside `config.properties` which is added to .gitignore.
4. Open the project in IntelliJ and run `Main.java`.

## Features

- Three writing modes: Creative, Professional, Academic
- Dark-themed Swing UI
- Save and Load session files
- Real API calls using Java's HttpClient
- Asynchronous calls using SwingWorker
- Basic error handling and input validation

## Design Patterns Used

- **Strategy** – each writing mode has its own strategy class
- **Factory** – the JSON request body is built in one place
- **Singleton** – APIClient is shared across the project
- **Observer** – the view updates automatically when the model changes

## Demo

https://youtu.be/_9CLXfPXy84

## AI Usage Disclosure

We used ChatGPT to brainstorm ideas, help structure the project, and help write documentation.
We rewrote and reviewed all generated content so we fully understand how the project works.
