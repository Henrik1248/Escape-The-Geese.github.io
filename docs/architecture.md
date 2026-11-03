---
layout: page
title: Architecture
---
This section presents the architecture of Escape the Geese and shows how it satisfies the requirements set out in section 2. Our design began with Class-Responsibility-Collaborator (CRC) cards, which we used to identify the core classes (Game, Player, Goose, Item, Event and Score), their responsibilities, and how they collaborate. These cards formed the basis of our UML diagrams, created using [https://plantuml.com/]. 
The structural view is shown through class diagrams, which set out each class, its attributes and methods, and the relationships between them. The behavioural view is shown through sequence diagrams, which illustrate how these classes interact during key gameplay scenarios, such as using an item to disperse geese or the game ending. Class names are kept consistent across the CRC cards, diagrams and code, and each class and scenario is linked to the requirements it satisfies using the identifiers from section 2 (e.g. UR_GEESE, FR_ITEM_DISPERSE), giving clear traceability from requirements to design. 
We then justify the key design decisions and describe how the architecture evolved from our initial CRC cards to its current form. Interim versions of our diagrams and the CRC cards are available on our team website.

## CRC Cards
We began our design with Class-Responsibility-Collaborator (CRC) cards, which helped us identify the main classes in the game, what each one is responsible for, and which other classes it works with. We identified six core classes from our requirements: 
**Game**, which manages the game state, timer and win or loss conditions; 
**Player**, which handles movement and the inventory; 
**Goose**, which approaches in waves and blocks the player; 
**Item**, which the player uses to distract or disperse geese; 
**Event**, which represents hidden events that help or hinder the player; and 
**Score**, which tracks the player's progress. 
Walking through gameplay scenarios with the cards helped us find missing responsibilities early, and the cards formed the basis of our first class diagram.

<img width="600" height="288" alt="image" src="https://github.com/user-attachments/assets/c161bf7a-4eb4-435e-a7ee-69d87c171c0d" />
<img width="576" height="234" alt="image" src="https://github.com/user-attachments/assets/bf67588c-3310-419d-a002-92eb2df6313b" />
<img width="570" height="260" alt="image" src="https://github.com/user-attachments/assets/62f65713-fa6e-4e6a-9051-0136bd16b39d" />
<img width="572" height="217" alt="image" src="https://github.com/user-attachments/assets/500fe2e7-5915-46ed-a55d-7ffa291b918a" />
<img width="517" height="213" alt="image" src="https://github.com/user-attachments/assets/4b1cd7df-d6f0-4864-9b85-f5df34037055" />
<img width="519" height="192" alt="image" src="https://github.com/user-attachments/assets/a6fb7082-f456-40de-9de3-a2bdf348160b" />

## Class Diagrams
### Version 1 (30/10/2026)

#### Figure 1. Game and Player Class Diagrams
<img width="471" height="357" alt="image" src="https://github.com/user-attachments/assets/dc61010f-f4ef-45f0-9e0d-dcff84231be2" />
Game is used to coordinate the overall state of play such as the timer, events, waves and end condition. 
Player holds the character’s movement, health and inventory behaviour. Separating these responsibilities lets Player respond to user actions while Game manages rules affecting the whole session. This design relates to FR_MOVE_KEYS, FR_MAP_BOUNDS and FR_TIMER from our requirements.

#### Figure 2. Score and Event Class Diagrams
<img width="660" height="309" alt="image" src="https://github.com/user-attachments/assets/21eb740c-6228-49c9-a9d4-19ff00a9c456" />
Score tracks the current score, geese dispersed, total geese and items used. It awards dispersal points with a time bonus, so faster play earns more. It also lets items and events adjust scoring through applyItemBonus() and setMultiplier(). isAllDispersed() gives Game a simple way to check the win condition. Event represents a positive or negative change to gameplay that triggers when the player enters its range. It can then affect the player, geese and score, spawn items and play a sound for a set duration. Keeping these effects inside Event means new events can be added without changing Game or Player. This design relates to UR_EVENTS, FR_SCORE_ITEMS and FR_WIN.

#### Figure 3. Goose and Item Class Diagrams 
<img width="587" height="189" alt="Screenshot 2026-11-03 at 03 41 53" src="https://github.com/user-attachments/assets/04a6e207-caee-48de-9aa7-85e86f46ffe9" />
Goose stores its own health, speed and position, and uses pathfindToPlayer() to chase the player. decrementHealth() lets items weaken a goose gradually, while disperseGoose() removes it from play. This allows Game to manage each wave as a list of independent geese. Item stores a name, effect type, strength and duration. applyToGeese() and applyToPlayer() let a single class cover both items that act on geese and items that help the player, so new items only need different property values. This design relates to UR_GEESE, UR_ITEMS and FR_ITEM_DISPERSE.

## Sequence Diagrams
### Version 1 (30/10/2026)
