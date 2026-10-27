---
layout: page
title: Requirements
---

## Customer meetings

| Meeting | Date | Focus | Notes |
|---|---|---|---|
| Meeting 1 | 09/10/2026 | Clarifying the product brief: platform, gameplay rules, accessibility | [PDF]({{ "/assets/customer-meeting-1-09-10-2026.pdf" | relative_url }}) |

### Meeting 1: Key outcomes

- **Platform:** Windows, macOS and Linux desktops, in a top-down 2D view (CR_PLATFORM, CR_VIEW)
- **Technology:** Java with a stable, well-documented engine; all licences recorded (CR_JAVA, CR_LICENCE)
- **Gameplay:** non-violent wave survival with a tiredness meter instead of health; win by clearing the waves, lose when the 5-minute timer ends (CR_PEACE, FR_WIN, FR_LOSE)
- **Accessibility:** important events shown through at least two of sound, visuals and text, plus pause, volume and full screen (UR_ACCESSIBILITY, FR_EVENT_VISUAL)
- **Performance:** loads within a couple of seconds on an average computer (QR_STARTUP)
- **Out of scope:** saving progress, leaderboards and storing player data

[Read the full meeting notes (PDF)]({{ "/assets/customer-meeting-1-09-10-2026.pdf" | relative_url }})

## Current requirements

Requirements describe what the game must do and the conditions it must meet to satisfy the customer. We elicited them from the customer's product brief, the assessment paper and our customer meetings, and record each one with a unique ID so it can be traced through design, implementation and testing. Each requirement has a priority: *Shall* for mandatory, *Should* for desirable and *May* for optional requirements. These are our initial requirements, agreed after the first customer meeting, and will be refined as the project develops.

| Type | Prefix | What it means | Count |
|---|---|---|---|
| Constraint requirements | CR_ | Fixed conditions on the solution that the team cannot change, such as platform, programming language and licensing | 7 |
| User requirements | UR_ | What the customer and players need from the game, written in plain language | 8 |
| Functional requirements | FR_ | Specific behaviours the game must perform, each linked to the user requirement it satisfies | 23 |
| Quality requirements | QR_ | How well the game must perform, such as start-up time, frame rate and usability, each with a measurable fit criterion | 5 |

### Summary

- **Constraints:** runs on Windows, macOS and Linux on standard hardware; written in Java 17 and delivered as an executable JAR; uses properly licensed assets; never shows geese being harmed.
- **Gameplay:** the player moves around a campus-style map with York landmarks, avoiding waves of geese and using items to disperse them within a 5-minute timer.
- **Scoring and events:** score rewards dispersing geese efficiently; at least five triggerable events help or hinder the player.
- **Accessibility:** distinct event sounds, pausing, a settings menu, volume control and full screen.
- **Quality:** fast start-up, a steady 30 fps, readable HUD at common resolutions, and a game most players can win on their first attempt.

[Read the full requirements document (PDF)]({{ "/assets/requirements-v1.pdf" | relative_url }})
