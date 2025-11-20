# Project Report – Writing Assistant

## Challenges I Faced

Challenge 1: API error handling  
Problem:  
Solution:  
Learned:  

Challenge 2: Keeping the UI responsive  
Problem:  
Solution:  
Learned:  

(Describe additional challenges as needed.)

## Design Pattern Justifications

Strategy Pattern:  
Explain why different writing behaviors needed their own classes and how `WritingModeStrategy` keeps the controller simple.

Factory Pattern:  
Explain why building JSON bodies in one place (`RequestFactory`) made it easier to update the API format and to test.

Singleton Pattern:  
Explain why `APIClient` is a singleton and how that helps with configuration and resource sharing.

Observer Pattern:  
Explain why the UI components listening to `DocumentModel` updates made the design cleaner and reduced manual wiring.

## API Usage

Describe which OpenAI endpoint you used, how you handled network errors, invalid keys, and rate limits, and any limitations you discovered.

## Testing Summary

- Number of JUnit tests written.
- What kinds of scenarios you covered (happy path, edge cases, error handling).
- Any bugs caught by tests.

## AI Usage

I used ChatGPT to help brainstorm design patterns, draft some class skeletons, and refine error handling. I rewrote and adapted the generated code to match my own understanding and project structure. I reviewed every line that I am submitting and can explain how it works.

## Time Spent

Time Spent: ~ hours (design, implementation, testing, documentation, and demo video).
